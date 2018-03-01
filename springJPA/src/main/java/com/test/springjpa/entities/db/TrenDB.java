package com.test.springjpa.entities.db;

import javax.persistence.*;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC015_TREN", schema = "SAC", catalog = "")
public class TrenDB {
    private long cdgoTren;
    private String rutaTren;
    private String coche;
    private String tipoPlaza;

    @Id
    @Column(name = "CDGO_TREN", nullable = false, precision = 0)
    public long getCdgoTren() {
        return cdgoTren;
    }

    public void setCdgoTren(long cdgoTren) {
        this.cdgoTren = cdgoTren;
    }

    @Basic
    @Column(name = "RUTA_TREN", nullable = false, length = 64)
    public String getRutaTren() {
        return rutaTren;
    }

    public void setRutaTren(String rutaTren) {
        this.rutaTren = rutaTren;
    }

    @Basic
    @Column(name = "COCHE", nullable = false, length = 32)
    public String getCoche() {
        return coche;
    }

    public void setCoche(String coche) {
        this.coche = coche;
    }

    @Basic
    @Column(name = "TIPO_PLAZA", nullable = false, length = 8)
    public String getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(String tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrenDB that = (TrenDB) o;

        if (cdgoTren != that.cdgoTren) return false;
        if (rutaTren != null ? !rutaTren.equals(that.rutaTren) : that.rutaTren != null) return false;
        if (coche != null ? !coche.equals(that.coche) : that.coche != null) return false;
        if (tipoPlaza != null ? !tipoPlaza.equals(that.tipoPlaza) : that.tipoPlaza != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoTren ^ (cdgoTren >>> 32));
        result = 31 * result + (rutaTren != null ? rutaTren.hashCode() : 0);
        result = 31 * result + (coche != null ? coche.hashCode() : 0);
        result = 31 * result + (tipoPlaza != null ? tipoPlaza.hashCode() : 0);
        return result;
    }
}
