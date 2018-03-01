package com.ineco.nfcclient;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;


/**
 * Created by jcgarcia on 11/04/2017.
 */

public class FakeCardService extends HostApduService {
    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        return new byte[0];
    }

    @Override
    public void onDeactivated(int reason) {

    }
}
