package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC018_ESTADO_ASIS", schema = "SAC", catalog = "")
@IdClass(EstadoAsisDBPK.class)
public class EstadoAsisDB {
    private long cdgoAsistencia;
    private long cdgoEstado;
    private Time fechaEstado;
    private String motivoEstado;
    private AsistenciaDB tbsac014AsistenciaByCdgoAsistencia;

    @Id
    @Column(name = "CDGO_ASISTENCIA", nullable = false, precision = 0)
    public long getCdgoAsistencia() {
        return cdgoAsistencia;
    }

    public void setCdgoAsistencia(long cdgoAsistencia) {
        this.cdgoAsistencia = cdgoAsistencia;
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

        EstadoAsisDB that = (EstadoAsisDB) o;

        if (cdgoAsistencia != that.cdgoAsistencia) return false;
        if (cdgoEstado != that.cdgoEstado) return false;
        if (fechaEstado != null ? !fechaEstado.equals(that.fechaEstado) : that.fechaEstado != null) return false;
        if (motivoEstado != null ? !motivoEstado.equals(that.motivoEstado) : that.motivoEstado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoAsistencia ^ (cdgoAsistencia >>> 32));
        result = 31 * result + (int) (cdgoEstado ^ (cdgoEstado >>> 32));
        result = 31 * result + (fechaEstado != null ? fechaEstado.hashCode() : 0);
        result = 31 * result + (motivoEstado != null ? motivoEstado.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CDGO_ASISTENCIA", referencedColumnName = "CDGO_ASISTENCIA", nullable = false)
    public AsistenciaDB getTbsac014AsistenciaByCdgoAsistencia() {
        return tbsac014AsistenciaByCdgoAsistencia;
    }

    public void setTbsac014AsistenciaByCdgoAsistencia(AsistenciaDB tbsac014AsistenciaByCdgoAsistencia) {
        this.tbsac014AsistenciaByCdgoAsistencia = tbsac014AsistenciaByCdgoAsistencia;
    }
}
