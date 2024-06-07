package hr.tis.praksa.model;

import java.math.BigDecimal;

public class Product {
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal ocjena;
    private String mjernaJedinica;


    public Product(String naziv, BigDecimal cijena, BigDecimal ocjena , String mjernaJedinica) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.ocjena = ocjena;
        this.mjernaJedinica = mjernaJedinica;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public BigDecimal getOcjena() {
        return ocjena;
    }

    public void setOcjena(BigDecimal ocjena) {
        this.ocjena = ocjena;
    }

    public String getMjernaJedinica() {
        return mjernaJedinica;
    }

    public void setMjernaJedinica(String mjernaJedinica) {
        this.mjernaJedinica = mjernaJedinica;
    }
}