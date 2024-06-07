package hr.tis.praksa.repository;

import hr.tis.praksa.model.Product;
import hr.tis.praksa.model.ProductsMetadata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryInMemory implements ProductRepository {
    private static final List<ProductsMetadata> productsMetadataList
            = new ArrayList<>();

    @Override
    public Long insertProducts(ProductsMetadata ProductsMetadata) {
        productsMetadataList.add(ProductsMetadata);

        return (Long) (long) productsMetadataList.indexOf(ProductsMetadata);
    }

    @Override
    public BigDecimal fetchSumOfPrices(LocalDate createdDate) {
        ProductsMetadata productsMetadata = fetchProductsMetadata(createdDate);
        List<Product> productList = productsMetadata.getListaProizvoda();

        BigDecimal sumOfPrices = BigDecimal.ZERO;
        for (Product product : productList) {
            sumOfPrices = product.getCijena().add(sumOfPrices);
        }

        return sumOfPrices;
    }

    @Override
    public BigDecimal fetchSumOfPrices(Long id) {
        ProductsMetadata productsMetadata = productsMetadataList.get(Math.toIntExact(id));
        List<Product> productList = productsMetadata.getListaProizvoda();

        BigDecimal sumOfPrices = BigDecimal.ZERO;
        for (Product product : productList) {
            sumOfPrices = product.getCijena().add(sumOfPrices);
        }

        return sumOfPrices;
    }

    @Override
    public ProductsMetadata fetchProductsMetadata(LocalDate createdDate) {
        ProductsMetadata lastProductMetadata = null;

        for (ProductsMetadata productsMetadata : productsMetadataList) {
            if (productsMetadata.getDatumKreiranja().equals(createdDate)) {

                if (lastProductMetadata == null) {
                    lastProductMetadata = productsMetadata;
                } else if (lastProductMetadata.getId() < productsMetadata.getId()) {
                    lastProductMetadata = productsMetadata;
                }
            }
        }

        if (lastProductMetadata == null) {
            throw new RuntimeException("Record doesn't exist!");
        }

        return lastProductMetadata;
    }

    @Override
    public ProductsMetadata fetchProductsMetadata(Long id) {
        ProductsMetadata productsMetadata = productsMetadataList.get(Math.toIntExact(id));
        if (productsMetadata == null) {
            throw new RuntimeException("Record doesn't exist!");
        } else {
            return productsMetadata;
        }
    }

    @Override
    public Integer fetchProductsMetadataCount() {
        Integer count = 0;
        for (ProductsMetadata productsMetadata : productsMetadataList) {
            count++;
        }

        return count;
    }

    @Override
    public BigDecimal calculateSumOfPrices(List<Product> products) {

        BigDecimal sumOfPrices = BigDecimal.ZERO;
        for (Product product : products) {
            sumOfPrices = product.getCijena().add(sumOfPrices);
        }

        return sumOfPrices;
    }
}
