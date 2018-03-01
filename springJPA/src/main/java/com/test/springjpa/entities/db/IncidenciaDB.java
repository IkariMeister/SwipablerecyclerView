package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC016_INCIDENCIA", schema = "SAC", catalog = "")
public class IncidenciaDB {
    private long cdgoIncidencia;
    private String descIncidencia;
    private Time fecha;
    private AsistenciaDB tbsac014AsistenciaByCdgoAsistencia;

    @Id
    @Column(name = "CDGO_INCIDENCIA", nullable = false, precision = 0)
    public long getCdgoIncidencia() {
        return cdgoIncidencia;
    }

    public void setCdgoIncidencia(long cdgoIncidencia) {
        this.cdgoIncidencia = cdgoIncidencia;
    }

    @Basic
    @Column(name = "DESC_INCIDENCIA", nullable = false, length = 2056)
    public String getDescIncidencia() {
        return descIncidencia;
    }

    public void setDescIncidencia(String descIncidencia) {
        this.descIncidencia = descIncidencia;
    }

    @Basic
    @Column(name = "FECHA", nullable = false)
    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncidenciaDB that = (IncidenciaDB) o;

        if (cdgoIncidencia != that.cdgoIncidencia) return false;
        if (descIncidencia != null ? !descIncidencia.equals(that.descIncidencia) : that.descIncidencia != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoIncidencia ^ (cdgoIncidencia >>> 32));
        result = 31 * result + (descIncidencia != null ? descIncidencia.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CDGO_ASISTENCIA", referencedColumnName = "CDGO_ASISTENCIA")
    public AsistenciaDB getTbsac014AsistenciaByCdgoAsistencia() {
        return tbsac014AsistenciaByCdgoAsistencia;
    }

    public void setTbsac014AsistenciaByCdgoAsistencia(AsistenciaDB tbsac014AsistenciaByCdgoAsistencia) {
        this.tbsac014AsistenciaByCdgoAsistencia = tbsac014AsistenciaByCdgoAsistencia;
    }
}
