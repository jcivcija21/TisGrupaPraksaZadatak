package hr.tis.praksa.repository;

import hr.tis.praksa.model.Product;
import hr.tis.praksa.model.ProductsMetadata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepository {
    Long insertProducts(ProductsMetadata ProductsMetadata);
    BigDecimal fetchSumOfPrices(LocalDate createdDate);
    BigDecimal fetchSumOfPrices(Long id);
    ProductsMetadata fetchProductsMetadata(LocalDate createdDate);
    ProductsMetadata fetchProductsMetadata(Long id);
    Integer fetchProductsMetadataCount();
    BigDecimal calculateSumOfPrices(List<Product> products);
}
