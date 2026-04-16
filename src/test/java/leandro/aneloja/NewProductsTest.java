package leandro.aneloja;

import jakarta.transaction.Transactional;
import leandro.aneloja.enuns.Color;
import leandro.aneloja.model.Product;
import leandro.aneloja.model.ProductImage;
import leandro.aneloja.model.ProductVariant;
import leandro.aneloja.repository.ProductImageRepository;
import leandro.aneloja.repository.ProductRepository;
import leandro.aneloja.repository.ProductVariantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NewProductsTest {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductVariantRepository productVariantRepository;
    @Autowired
    ProductImageRepository productImageRepository;


    @Test
    public void newProduct() {

        Product product = new Product();
        product.setName("Camiseta");
        product.setDescription("Camiseta básica");
        product.setBasePrice(new BigDecimal("49.90"));

        ProductVariant variant = new ProductVariant();
        variant.setColor(Color.RED);
        variant.setSize("M");
        variant.setPrice(new BigDecimal("49.90"));
        variant.setStock(10);
        variant.setProduct(product); // IMPORTANTE

        ProductImage image1 = new ProductImage();
        image1.setImageUrl("https://res.cloudinary.com/dvg9mzlnh/image/upload/v1775826721/cld-sample-2.jpg");
        image1.setVariant(variant);

        ProductImage image2 = new ProductImage();
        image2.setImageUrl("https://res.cloudinary.com/dvg9mzlnh/image/upload/v1775826722/cld-sample-5.jpg"); // corrigido
        image2.setIsMain(true);
        image2.setVariant(variant);

        List<ProductImage> productImages = List.of(image1, image2);
        variant.setImages(productImages);

        repository.save(product);
        productVariantRepository.save(variant);
        productImageRepository.saveAll(productImages);
    }

    @Test
    public void Mostrar(){
        System.out.printf(repository.findAll().toString());
    }
}
