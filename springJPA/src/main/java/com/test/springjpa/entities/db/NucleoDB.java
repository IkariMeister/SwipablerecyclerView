package com.test.springjpa.entities.db;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by jcgarcia on 29/05/2017.
 */
@Entity
@Table(name = "TBSAC008_NUCLEO", schema = "SAC")
public class NucleoDB {
    private long cdgoNucleo;
    private String descNucleo;
    private String centroCic;
    private String mailCic;
    private String tltIntCic;
    private String tltExtCic;
    private String tltMvlCic;
    private String faxCic;
    private Time fechaAlta;
    private Time fechaBaja;

    @Id
    @Column(name = "CDGO_NUCLEO", nullable = false, precision = 0)
    public long getCdgoNucleo() {
        return cdgoNucleo;
    }

    public void setCdgoNucleo(long cdgoNucleo) {
        this.cdgoNucleo = cdgoNucleo;
    }

    @Basic
    @Column(name = "DESC_NUCLEO", nullable = false, length = 32)
    public String getDescNucleo() {
        return descNucleo;
    }

    public void setDescNucleo(String descNucleo) {
        this.descNucleo = descNucleo;
    }

    @Basic
    @Column(name = "CENTRO_CIC", nullable = false, length = 64)
    public String getCentroCic() {
        return centroCic;
    }

    public void setCentroCic(String centroCic) {
        this.centroCic = centroCic;
    }

    @Basic
    @Column(name = "MAIL_CIC", nullable = false, length = 512)
    public String getMailCic() {
        return mailCic;
    }

    public void setMailCic(String mailCic) {
        this.mailCic = mailCic;
    }

    @Basic
    @Column(name = "TLT_INT_CIC", nullable = false, length = 32)
    public String getTltIntCic() {
        return tltIntCic;
    }

    public void setTltIntCic(String tltIntCic) {
        this.tltIntCic = tltIntCic;
    }

    @Basic
    @Column(name = "TLT_EXT_CIC", nullable = false, length = 32)
    public String getTltExtCic() {
        return tltExtCic;
    }

    public void setTltExtCic(String tltExtCic) {
        this.tltExtCic = tltExtCic;
    }

    @Basic
    @Column(name = "TLT_MVL_CIC", nullable = false, length = 32)
    public String getTltMvlCic() {
        return tltMvlCic;
    }

    public void setTltMvlCic(String tltMvlCic) {
        this.tltMvlCic = tltMvlCic;
    }

    @Basic
    @Column(name = "FAX_CIC", nullable = false, length = 32)
    public String getFaxCic() {
        return faxCic;
    }

    public void setFaxCic(String faxCic) {
        this.faxCic = faxCic;
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

        NucleoDB that = (NucleoDB) o;

        if (cdgoNucleo != that.cdgoNucleo) return false;
        if (descNucleo != null ? !descNucleo.equals(that.descNucleo) : that.descNucleo != null) return false;
        if (centroCic != null ? !centroCic.equals(that.centroCic) : that.centroCic != null) return false;
        if (mailCic != null ? !mailCic.equals(that.mailCic) : that.mailCic != null) return false;
        if (tltIntCic != null ? !tltIntCic.equals(that.tltIntCic) : that.tltIntCic != null) return false;
        if (tltExtCic != null ? !tltExtCic.equals(that.tltExtCic) : that.tltExtCic != null) return false;
        if (tltMvlCic != null ? !tltMvlCic.equals(that.tltMvlCic) : that.tltMvlCic != null) return false;
        if (faxCic != null ? !faxCic.equals(that.faxCic) : that.faxCic != null) return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (fechaBaja != null ? !fechaBaja.equals(that.fechaBaja) : that.fechaBaja != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cdgoNucleo ^ (cdgoNucleo >>> 32));
        result = 31 * result + (descNucleo != null ? descNucleo.hashCode() : 0);
        result = 31 * result + (centroCic != null ? centroCic.hashCode() : 0);
        result = 31 * result + (mailCic != null ? mailCic.hashCode() : 0);
        result = 31 * result + (tltIntCic != null ? tltIntCic.hashCode() : 0);
        result = 31 * result + (tltExtCic != null ? tltExtCic.hashCode() : 0);
        result = 31 * result + (tltMvlCic != null ? tltMvlCic.hashCode() : 0);
        result = 31 * result + (faxCic != null ? faxCic.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaBaja != null ? fechaBaja.hashCode() : 0);
        return result;
    }
}
