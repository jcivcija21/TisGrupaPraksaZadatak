package hr.tis.praksa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsMetadata {
    private Long id;
    private LocalDate datumKreiranja;
    private String naslov;
    private List<Product> listaProizvoda;

    public ProductsMetadata(Long id, LocalDate datumKreiranja, String naslov, List<Product> listaProizvoda){
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.naslov = naslov;
        this.listaProizvoda = listaProizvoda;
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        List<Product> listaProizvoda = new ArrayList<>();
        Product prviProdukt = new Product("Keks", new BigDecimal("3.5"), new BigDecimal("5"), "EUR/kom");
        Product drugiProdukt = new Product("Coca Cola", new BigDecimal("2"), new BigDecimal("5"), "EUR/kom");
        listaProizvoda.add(prviProdukt);
        listaProizvoda.add(drugiProdukt);
        ProductsMetadata productsMetadata = new ProductsMetadata(1L, localDate, "Neki naslov", listaProizvoda);
        System.out.println(productsMetadata);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public List<Product> getListaProizvoda() {
        return listaProizvoda;
    }

    public void setListaProizvoda(List<Product> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

    @Override
    public String toString() {
        return "ProductsMetadata{" +
                "id=" + id +
                ", datumKreiranja=" + datumKreiranja +
                ", naslov='" + naslov + '\'' +
                ", listaProizvoda=" + listaProizvoda +
                '}';
    }
}