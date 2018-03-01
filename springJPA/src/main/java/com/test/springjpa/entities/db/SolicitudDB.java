package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC011_SOLICITUD", schema = "SAC", catalog = "")
public class SolicitudDB {
    private long cdgoSolicitud;
    private Time fechaAlta;
    private String observaciones;
    private ViajeroDB tbsac010ViajeroByIdViajero;

    @Id
    @Column(name = "CDGO_SOLICITUD", nullable = false, precision = 0)
    public long getCdgoSolicitud() {
        return cdgoSolicitud;
    }

    public void setCdgoSolicitud(long cdgoSolicitud) {
        this.cdgoSolicitud = cdgoSolicitud;
    }

    @Basic
    @Column(name = "FECHA_ALTA", nullable = false)
    public Time getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Time fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Basic
    @Column(name = "OBSERVACIONES", nullable = false, length = 2056)
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitudDB that = (SolicitudDB) o;

        if (cdgoSolicitud != that.cdgoSolicitud) return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoSolicitud ^ (cdgoSolicitud >>> 32));
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_VIAJERO", referencedColumnName = "ID_VIAJERO", nullable = false)
    public ViajeroDB getTbsac010ViajeroByIdViajero() {
        return tbsac010ViajeroByIdViajero;
    }

    public void setTbsac010ViajeroByIdViajero(ViajeroDB tbsac010ViajeroByIdViajero) {
        this.tbsac010ViajeroByIdViajero = tbsac010ViajeroByIdViajero;
    }
}
