package leandro.aneloja.service;

import leandro.aneloja.DTOs.ImageResposeDTO;
import leandro.aneloja.DTOs.ProductResponseDTO;
import leandro.aneloja.DTOs.VarianteResponseDTO;
import leandro.aneloja.model.Product;
import leandro.aneloja.model.ProductImage;
import leandro.aneloja.model.ProductVariant;
import leandro.aneloja.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Page<ProductResponseDTO> getProducts(int page, int size) {
        Page<Product> products = repository.findAll(PageRequest.of(page, size));

        return products.map(this::toDTO);
    }

    private ProductResponseDTO toDTO(Product p) {

        List<VarianteResponseDTO> variants =
                safeList(p.getVariants()).stream()
                        .map(this::toVariantDTO)
                        .toList();

        return new ProductResponseDTO(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getBasePrice(),
                variants
        );
    }

    private VarianteResponseDTO toVariantDTO(ProductVariant v) {

        List<ImageResposeDTO> images =
                safeList(v.getImages()).stream()
                        .map(this::toImageDTO)
                        .toList();

        return new VarianteResponseDTO(
                v.getColor(),
                v.getSize(),
                v.getPrice(),
                v.getStock(),
                images
        );
    }

    private ImageResposeDTO toImageDTO(ProductImage i) {
        return new ImageResposeDTO(
                i.getIsMain(),
                i.getImageUrl()
        );
    }

    // util pra evitar null
    private <T> List<T> safeList(List<T> list) {
        return list == null ? List.of() : list;
    }
}
