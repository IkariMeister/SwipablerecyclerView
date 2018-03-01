package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC012_TIPO_DISCAPACIDAD", schema = "SAC", catalog = "")
public class TipoDiscapacidadDB {
    private long cdgoTipoDiscapacidad;
    private String descTipoDiscapacidad;
    private Time fechaAlta;
    private Time fechaBaja;

    @Id
    @Column(name = "CDGO_TIPO_DISCAPACIDAD", nullable = false, precision = 0)
    public long getCdgoTipoDiscapacidad() {
        return cdgoTipoDiscapacidad;
    }

    public void setCdgoTipoDiscapacidad(long cdgoTipoDiscapacidad) {
        this.cdgoTipoDiscapacidad = cdgoTipoDiscapacidad;
    }

    @Basic
    @Column(name = "DESC_TIPO_DISCAPACIDAD", nullable = false, length = 128)
    public String getDescTipoDiscapacidad() {
        return descTipoDiscapacidad;
    }

    public void setDescTipoDiscapacidad(String descTipoDiscapacidad) {
        this.descTipoDiscapacidad = descTipoDiscapacidad;
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
    @Column(name = "FECHA_BAJA", nullable = true)
    public Time getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Time fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoDiscapacidadDB that = (TipoDiscapacidadDB) o;

        if (cdgoTipoDiscapacidad != that.cdgoTipoDiscapacidad) return false;
        if (descTipoDiscapacidad != null ? !descTipoDiscapacidad.equals(that.descTipoDiscapacidad) : that.descTipoDiscapacidad != null)
            return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (fechaBaja != null ? !fechaBaja.equals(that.fechaBaja) : that.fechaBaja != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoTipoDiscapacidad ^ (cdgoTipoDiscapacidad >>> 32));
        result = 31 * result + (descTipoDiscapacidad != null ? descTipoDiscapacidad.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaBaja != null ? fechaBaja.hashCode() : 0);
        return result;
    }
}
