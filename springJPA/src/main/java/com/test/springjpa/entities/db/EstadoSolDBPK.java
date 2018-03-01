package com.test.springjpa.entities.db;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jcgarcia on 29/05/2017.
 */
public class EstadoSolDBPK implements Serializable {
    private long cdgoSolicitud;
    private long cdgoEstado;

    @Column(name = "CDGO_SOLICITUD", nullable = false, precision = 0)
    @Id
    public long getCdgoSolicitud() {
        return cdgoSolicitud;
    }

    public void setCdgoSolicitud(long cdgoSolicitud) {
        this.cdgoSolicitud = cdgoSolicitud;
    }

    @Column(name = "CDGO_ESTADO", nullable = false, precision = 0)
    @Id
    public long getCdgoEstado() {
        return cdgoEstado;
    }

    public void setCdgoEstado(long cdgoEstado) {
        this.cdgoEstado = cdgoEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoSolDBPK that = (EstadoSolDBPK) o;

        if (cdgoSolicitud != that.cdgoSolicitud) return false;
        if (cdgoEstado != that.cdgoEstado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoSolicitud ^ (cdgoSolicitud >>> 32));
        result = 31 * result + (int) (cdgoEstado ^ (cdgoEstado >>> 32));
        return result;
    }
}
