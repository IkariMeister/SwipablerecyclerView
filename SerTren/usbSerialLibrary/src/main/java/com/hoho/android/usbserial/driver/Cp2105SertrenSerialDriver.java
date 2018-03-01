package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by a on 15/01/2015.
 */
public class Cp2105SertrenSerialDriver extends CommonUsbSerialDriver {

    private static final String TAG = Cp2105SertrenSerialDriver.class.getSimpleName();

    private static final int DEFAULT_BAUD_RATE = 9600;
    private static final int DEVICE_BAUD_RATE = 115200;

    //private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
    private static final int USB_WRITE_TIMEOUT_MILLIS = 200;

    /*
     * Configuration Request Types
     */
    private static final int REQTYPE_HOST_TO_INTERFACE = 0x41;
    private static final int REQTYPE_HOST_TO_DEVICE = 0x40;
    private static final int REQTYPE_INTERFACE_TO_HOST = 0xc1;

    /*
     * Configuration Request Codes
     */
    private static final int SILABSER_IFC_ENABLE_REQUEST_CODE = 0x00;
    private static final int SILABSER_SET_BAUDDIV_REQUEST_CODE = 0x01;
    private static final int SILABSER_SET_LINE_CTL_REQUEST_CODE = 0x03;
    private static final int SILABSER_SET_MHS_REQUEST_CODE = 0x07;
    private static final int SILABSER_SET_BAUDRATE = 0x1E;
    private static final int SILABSER_FLUSH_REQUEST_CODE = 0x12;
    private static final int SILABSER_WRITE_LATCH = 0x37e1;
    private static final int VENDOR_SPECIFIC = 0xff;

    private static final int FLUSH_READ_CODE = 0x0a;
    private static final int FLUSH_WRITE_CODE = 0x05;

    /*
     * SILABSER_IFC_ENABLE_REQUEST_CODE
     */
    private static final int UART_ENABLE = 0x0001;
    private static final int UART_DISABLE = 0x0000;

    /*
     * SILABSER_SET_BAUDDIV_REQUEST_CODE
     */
    private static final int BAUD_RATE_GEN_FREQ = 0x384000;

    /*
     * SILABSER_SET_MHS_REQUEST_CODE
     */
    private static final int CONTROL_DTR = 0x0001;
    private static final int MCR_RTS = 0x0002;
    private static final int MCR_ALL = 0x0003;

    private static final int CONTROL_WRITE_DTR = 0x0100;
    private static final int CONTROL_WRITE_RTS = 0x0200;

    /*
     * VALORES GPIO PARA LATCH
     */
    private final int GPIO_0 = 0x0001;
    private final int GPIO_1 = 0x0002;
    private final int GPIO_2 = 0x0004;
    private final int GPIO_3 = 0x0008;
    private final byte LATCH_MASK = GPIO_0 | GPIO_1 | GPIO_2 | GPIO_3;
    private final int GPIO_SET_ENCENDIDO = 0x0001;
    private final int GPIO_SET_APAGADO = 0x0000;

    private UsbEndpoint mReadEndpoint;
    private UsbEndpoint mWriteEndpoint;

    public Cp2105SertrenSerialDriver(UsbDevice device, UsbDeviceConnection connection) {
        super(device, connection);
    }

    private int setConfigSingle(int request, int value) {
        return mConnection.controlTransfer(REQTYPE_HOST_TO_INTERFACE, request, value,
                0, null, 0, USB_WRITE_TIMEOUT_MILLIS);
    }

    private void usbEnable(boolean habilitar) throws IOException {
        int i = 0;

        if(habilitar){
            i = UART_ENABLE;
        } else {
            i = UART_DISABLE;
        }

        int ret = mConnection.controlTransfer(
                  REQTYPE_HOST_TO_INTERFACE,
                  SILABSER_IFC_ENABLE_REQUEST_CODE,
                  i,
                  0,
                  null,
                  0,
                  USB_WRITE_TIMEOUT_MILLIS);
        if (ret < 0) {
            throw new IOException("No se ha podido habilitar el modo USB en el chip");
        }
    }

    private void setBaudRate(int baudRate) throws IOException {
        byte[] baudBytes = new byte[4];
        intToLittleEndianBytes(baudRate, baudBytes);
        int ret = mConnection.controlTransfer(
                REQTYPE_HOST_TO_INTERFACE,
                SILABSER_SET_BAUDRATE,
                0,
                0,
                baudBytes,
                4,
                USB_WRITE_TIMEOUT_MILLIS);
        if (ret < 0) {
            throw new IOException("No se ha podido establecer el baud rate");
        }
    }

    public void enviarEncenderEscaner(boolean encender) throws IOException {
        byte[] datos = new byte[2];
        datos[0] = LATCH_MASK;
        if(encender) {
            datos[1] = GPIO_SET_ENCENDIDO | GPIO_SET_APAGADO | GPIO_SET_APAGADO | GPIO_SET_APAGADO;
        } else {
            datos[1] = GPIO_SET_APAGADO | GPIO_SET_APAGADO | GPIO_SET_APAGADO | GPIO_SET_APAGADO;
        }

        int ret = mConnection.controlTransfer(
                REQTYPE_HOST_TO_DEVICE,
                VENDOR_SPECIFIC,
                SILABSER_WRITE_LATCH,
                0,
                datos,
                2,
                USB_WRITE_TIMEOUT_MILLIS);
        //Log.d(TAG, "enviarEncenderEscaner: "+ ret);

        if (ret < 0) {
            throw new IOException("No se ha podido encender el escáner");
        }
    }

    @Override
    public void open() throws IOException {
        boolean abierto = false;
        try {
            //Debería haber 2 interfaces según la arquitectura electrónica de la carcasa
            if(mDevice.getInterfaceCount() > 1){
                //Se pilla la primera, que es el escáner y se configuran los endpoints
                UsbInterface usbInterface = mDevice.getInterface(0);
                Log.d(TAG, "Hay más de 1 interfaz(" + mDevice.getInterfaceCount() + ") se pilla el primero");
                for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
                    UsbEndpoint ep = usbInterface.getEndpoint(i);
                    if (ep.getDirection() == UsbConstants.USB_DIR_IN) {
                        mReadEndpoint = ep;
                        Log.d(TAG, "mReadEndpoint: " + ep.getDirection());
                    } else if(ep.getDirection() == UsbConstants.USB_DIR_OUT) {
                        mWriteEndpoint = ep;
                        Log.d(TAG, "mWriteEndpoint: " + ep.getDirection());
                    }
                }
            } else {
                throw new IOException("No hay el número de interfaces previsto");
            }

            //Se comprueba que la conexión no es nula
            if(mConnection == null){
                throw new IOException("No hay conexión con el dispositivo");
            }

            //Habilitar usb
            usbEnable(true);

            //Establecer baud rate
            setBaudRate(DEVICE_BAUD_RATE);

            //Enviar WRITE_LATCH para encender el escáner
            enviarEncenderEscaner(true);

            abierto = true;
        } finally {
            if (!abierto) {
                close();
            }
        }
    }

    @Override
    public void close(){
        try {
            enviarEncenderEscaner(false);
            usbEnable(false);
        } catch(IOException ioe){
            Log.e(TAG, "No se ha podido cerrar el driver correctamente");
        } finally {
            mConnection.close();
        }
    }

    @Override
    public int read(byte[] dest, int timeoutMillis) throws IOException {
        //Log.d(TAG, "SE LANZA read. bytes=" + dest.length);
        final int numBytesRead;
        synchronized (mReadBufferLock) {
            int readAmt = Math.min(dest.length, mReadBuffer.length);
            numBytesRead = mConnection.bulkTransfer(mReadEndpoint, mReadBuffer, readAmt, timeoutMillis);
            if (numBytesRead < 0) {
                // This sucks: we get -1 on timeout, not 0 as preferred.
                // We *should* use UsbRequest, except it has a bug/api oversight
                // where there is no way to determine the number of bytes read
                // in response :\ -- http://b.android.com/28023
                return 0;
            }
            else if(numBytesRead == 1){
                byte[] tempBuffer = new byte[DEFAULT_READ_BUFFER_SIZE];
                System.arraycopy(tempBuffer, 0, dest, 0, numBytesRead);

                StringBuilder salida = new StringBuilder();
                //Log.d(TAG, "Llega 1 byte=" + dest.length);
                for (int i=0; i < tempBuffer.length; i++) {
                    if (tempBuffer[i] > ' ' && tempBuffer[i] < '~') {
                        salida.append(new String(tempBuffer, i, 1));
                    }
                }
                if(salida.toString().isEmpty()){
                    //Log.d(TAG, "La lectura está vacía");
                    return 0;
                }
            }
            System.arraycopy(mReadBuffer, 0, dest, 0, numBytesRead);
        }
        return numBytesRead;
    }

    @Override
    public int write(byte[] src, int timeoutMillis) throws IOException {
        int offset = 0;

        while (offset < src.length) {
            final int writeLength;
            final int amtWritten;

            synchronized (mWriteBufferLock) {
                final byte[] writeBuffer;

                writeLength = Math.min(src.length - offset, mWriteBuffer.length);
                if (offset == 0) {
                    writeBuffer = src;
                } else {
                    // bulkTransfer does not support offsets, make a copy.
                    System.arraycopy(src, offset, mWriteBuffer, 0, writeLength);
                    writeBuffer = mWriteBuffer;
                }

                amtWritten = mConnection.bulkTransfer(mWriteEndpoint, writeBuffer, writeLength,
                        timeoutMillis);
            }
            if (amtWritten <= 0) {
                throw new IOException("Error writing " + writeLength
                        + " bytes at offset " + offset + " length=" + src.length);
            }

            Log.d(TAG, "Wrote amt=" + amtWritten + " attempted=" + writeLength);
            offset += amtWritten;
        }
        return offset;
    }

    /**
     * Transfers int to little endian byte array
     * @param in integer value
     * @param out 4 or less length byte array
     */
    private void intToLittleEndianBytes(int in, byte[] out) {
        if(out == null) return;
        if(out.length > 4) return;
        for(int i=0; i<out.length; i++) {
            out[i] = (byte)((in >> (i*8)) & 0x000000FF);//255
        }
    }

    @Override
    public void setParameters(int baudRate, int dataBits, int stopBits, int parity)
            throws IOException {
        setBaudRate(baudRate);

        int configDataBits = 0;
        switch (dataBits) {
            case DATABITS_5:
                configDataBits |= 0x0500;
                break;
            case DATABITS_6:
                configDataBits |= 0x0600;
                break;
            case DATABITS_7:
                configDataBits |= 0x0700;
                break;
            case DATABITS_8:
                configDataBits |= 0x0800;
                break;
            default:
                configDataBits |= 0x0800;
                break;
        }
        setConfigSingle(SILABSER_SET_LINE_CTL_REQUEST_CODE, configDataBits);

        int configParityBits = 0; // PARITY_NONE
        switch (parity) {
            case PARITY_ODD:
                configParityBits |= 0x0010;
                break;
            case PARITY_EVEN:
                configParityBits |= 0x0020;
                break;
        }
        setConfigSingle(SILABSER_SET_LINE_CTL_REQUEST_CODE, configParityBits);

        int configStopBits = 0;
        switch (stopBits) {
            case STOPBITS_1:
                configStopBits |= 0;
                break;
            case STOPBITS_2:
                configStopBits |= 2;
                break;
        }
        setConfigSingle(SILABSER_SET_LINE_CTL_REQUEST_CODE, configStopBits);
    }

    @Override
    public boolean getCD() throws IOException {
        return false;
    }

    @Override
    public boolean getCTS() throws IOException {
        return false;
    }

    @Override
    public boolean getDSR() throws IOException {
        return false;
    }

    @Override
    public boolean getDTR() throws IOException {
        return true;
    }

    @Override
    public void setDTR(boolean value) throws IOException {
    }

    @Override
    public boolean getRI() throws IOException {
        return false;
    }

    @Override
    public boolean getRTS() throws IOException {
        return true;
    }

    @Override
    public boolean purgeHwBuffers(boolean purgeReadBuffers,
                                  boolean purgeWriteBuffers) throws IOException {
        int value = (purgeReadBuffers ? FLUSH_READ_CODE : 0)
                | (purgeWriteBuffers ? FLUSH_WRITE_CODE : 0);

        if (value != 0) {
            setConfigSingle(SILABSER_FLUSH_REQUEST_CODE, value);
        }

        return true;
    }

    @Override
    public void setRTS(boolean value) throws IOException {
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        final Map<Integer, int[]> supportedDevices = new LinkedHashMap<Integer, int[]>();
        supportedDevices.put(Integer.valueOf(UsbId.VENDOR_SILAB),
                new int[] {
                        UsbId.SILAB_CP2102,
                        UsbId.SILAB_CP2105
                });

        return supportedDevices;
    }
}
