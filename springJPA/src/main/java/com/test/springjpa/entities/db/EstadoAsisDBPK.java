package com.test.springjpa.entities.db;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jcgarcia on 29/05/2017.
 */
public class EstadoAsisDBPK implements Serializable {
    private long cdgoAsistencia;
    private long cdgoEstado;

    @Column(name = "CDGO_ASISTENCIA", nullable = false, precision = 0)
    @Id
    public long getCdgoAsistencia() {
        return cdgoAsistencia;
    }

    public void setCdgoAsistencia(long cdgoAsistencia) {
        this.cdgoAsistencia = cdgoAsistencia;
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

        EstadoAsisDBPK that = (EstadoAsisDBPK) o;

        if (cdgoAsistencia != that.cdgoAsistencia) return false;
        if (cdgoEstado != that.cdgoEstado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoAsistencia ^ (cdgoAsistencia >>> 32));
        result = 31 * result + (int) (cdgoEstado ^ (cdgoEstado >>> 32));
        return result;
    }
}
