package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC014_ASISTENCIA", schema = "SAC", catalog = "")
public class AsistenciaDB {
    private long cdgoAsistencia;
    private Time fechaAlta;
    private String tipoAsistencia;
    private String cdgoEstacion;
    private String descEstacion;
    private String puntoEncuentro;
    private String estacionAccesible;
    private Time fechaAsistencia;
    private Timestamp horaAsistencia;

    @Id
    @Column(name = "CDGO_ASISTENCIA", nullable = false, precision = 0)
    public long getCdgoAsistencia() {
        return cdgoAsistencia;
    }

    public void setCdgoAsistencia(long cdgoAsistencia) {
        this.cdgoAsistencia = cdgoAsistencia;
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
    @Column(name = "TIPO_ASISTENCIA", nullable = false, length = 8)
    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    @Basic
    @Column(name = "CDGO_ESTACION", nullable = false, length = 9)
    public String getCdgoEstacion() {
        return cdgoEstacion;
    }

    public void setCdgoEstacion(String cdgoEstacion) {
        this.cdgoEstacion = cdgoEstacion;
    }

    @Basic
    @Column(name = "DESC_ESTACION", nullable = false, length = 256)
    public String getDescEstacion() {
        return descEstacion;
    }

    public void setDescEstacion(String descEstacion) {
        this.descEstacion = descEstacion;
    }

    @Basic
    @Column(name = "PUNTO_ENCUENTRO", nullable = false, length = 128)
    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    @Basic
    @Column(name = "ESTACION_ACCESIBLE", nullable = false, length = 8)
    public String getEstacionAccesible() {
        return estacionAccesible;
    }

    public void setEstacionAccesible(String estacionAccesible) {
        this.estacionAccesible = estacionAccesible;
    }

    @Basic
    @Column(name = "FECHA_ASISTENCIA", nullable = false)
    public Time getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Time fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    @Basic
    @Column(name = "HORA_ASISTENCIA", nullable = false)
    public Timestamp getHoraAsistencia() {
        return horaAsistencia;
    }

    public void setHoraAsistencia(Timestamp horaAsistencia) {
        this.horaAsistencia = horaAsistencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsistenciaDB that = (AsistenciaDB) o;

        if (cdgoAsistencia != that.cdgoAsistencia) return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (tipoAsistencia != null ? !tipoAsistencia.equals(that.tipoAsistencia) : that.tipoAsistencia != null)
            return false;
        if (cdgoEstacion != null ? !cdgoEstacion.equals(that.cdgoEstacion) : that.cdgoEstacion != null) return false;
        if (descEstacion != null ? !descEstacion.equals(that.descEstacion) : that.descEstacion != null) return false;
        if (puntoEncuentro != null ? !puntoEncuentro.equals(that.puntoEncuentro) : that.puntoEncuentro != null)
            return false;
        if (estacionAccesible != null ? !estacionAccesible.equals(that.estacionAccesible) : that.estacionAccesible != null)
            return false;
        if (fechaAsistencia != null ? !fechaAsistencia.equals(that.fechaAsistencia) : that.fechaAsistencia != null)
            return false;
        if (horaAsistencia != null ? !horaAsistencia.equals(that.horaAsistencia) : that.horaAsistencia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoAsistencia ^ (cdgoAsistencia >>> 32));
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (tipoAsistencia != null ? tipoAsistencia.hashCode() : 0);
        result = 31 * result + (cdgoEstacion != null ? cdgoEstacion.hashCode() : 0);
        result = 31 * result + (descEstacion != null ? descEstacion.hashCode() : 0);
        result = 31 * result + (puntoEncuentro != null ? puntoEncuentro.hashCode() : 0);
        result = 31 * result + (estacionAccesible != null ? estacionAccesible.hashCode() : 0);
        result = 31 * result + (fechaAsistencia != null ? fechaAsistencia.hashCode() : 0);
        result = 31 * result + (horaAsistencia != null ? horaAsistencia.hashCode() : 0);
        return result;
    }
}
