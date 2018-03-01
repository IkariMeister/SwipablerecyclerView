package com.test.springjpa.entities.db;

import javax.persistence.*;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC010_VIAJERO", schema = "SAC", catalog = "")
public class ViajeroDB {
    private long idViajero;
    private String nombre;
    private String mail;
    private String telefonoMovil;
    private String telefonoFijo;
    private String idAppViajero;

    @Id
    @Column(name = "ID_VIAJERO", nullable = false, precision = 0)
    public long getIdViajero() {
        return idViajero;
    }

    public void setIdViajero(long idViajero) {
        this.idViajero = idViajero;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 512)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "MAIL", nullable = false, length = 512)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "TELEFONO_MOVIL", nullable = false, length = 32)
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Basic
    @Column(name = "TELEFONO_FIJO", nullable = false, length = 32)
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    @Basic
    @Column(name = "ID_APP_VIAJERO", nullable = true, length = 9)
    public String getIdAppViajero() {
        return idAppViajero;
    }

    public void setIdAppViajero(String idAppViajero) {
        this.idAppViajero = idAppViajero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViajeroDB that = (ViajeroDB) o;

        if (idViajero != that.idViajero) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (telefonoMovil != null ? !telefonoMovil.equals(that.telefonoMovil) : that.telefonoMovil != null)
            return false;
        if (telefonoFijo != null ? !telefonoFijo.equals(that.telefonoFijo) : that.telefonoFijo != null) return false;
        if (idAppViajero != null ? !idAppViajero.equals(that.idAppViajero) : that.idAppViajero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idViajero ^ (idViajero >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (telefonoFijo != null ? telefonoFijo.hashCode() : 0);
        result = 31 * result + (idAppViajero != null ? idAppViajero.hashCode() : 0);
        return result;
    }
}
