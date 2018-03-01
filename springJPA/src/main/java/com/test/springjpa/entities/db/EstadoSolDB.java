package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC017_ESTADO_SOL", schema = "SAC", catalog = "")
@IdClass(EstadoSolDBPK.class)
public class EstadoSolDB {
    private long cdgoSolicitud;
    private long cdgoEstado;
    private Time fechaEstado;
    private String motivoEstado;

    @Id
    @Column(name = "CDGO_SOLICITUD", nullable = false, precision = 0)
    public long getCdgoSolicitud() {
        return cdgoSolicitud;
    }

    public void setCdgoSolicitud(long cdgoSolicitud) {
        this.cdgoSolicitud = cdgoSolicitud;
    }

    @Id
    @Column(name = "CDGO_ESTADO", nullable = false, precision = 0)
    public long getCdgoEstado() {
        return cdgoEstado;
    }

    public void setCdgoEstado(long cdgoEstado) {
        this.cdgoEstado = cdgoEstado;
    }

    @Basic
    @Column(name = "FECHA_ESTADO", nullable = false)
    public Time getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Time fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    @Basic
    @Column(name = "MOTIVO_ESTADO", nullable = false, length = 512)
    public String getMotivoEstado() {
        return motivoEstado;
    }

    public void setMotivoEstado(String motivoEstado) {
        this.motivoEstado = motivoEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoSolDB that = (EstadoSolDB) o;

        if (cdgoSolicitud != that.cdgoSolicitud) return false;
        if (cdgoEstado != that.cdgoEstado) return false;
        if (fechaEstado != null ? !fechaEstado.equals(that.fechaEstado) : that.fechaEstado != null) return false;
        if (motivoEstado != null ? !motivoEstado.equals(that.motivoEstado) : that.motivoEstado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoSolicitud ^ (cdgoSolicitud >>> 32));
        result = 31 * result + (int) (cdgoEstado ^ (cdgoEstado >>> 32));
        result = 31 * result + (fechaEstado != null ? fechaEstado.hashCode() : 0);
        result = 31 * result + (motivoEstado != null ? motivoEstado.hashCode() : 0);
        return result;
    }
}
