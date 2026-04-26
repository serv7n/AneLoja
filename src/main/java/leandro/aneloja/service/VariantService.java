package leandro.aneloja.service;

import jakarta.transaction.Transactional;
import leandro.aneloja.DTOs.Request.VariantRequestDTO;
import leandro.aneloja.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.mapper.VariantMapper;
import leandro.aneloja.model.Product;
import leandro.aneloja.model.ProductVariant;
import leandro.aneloja.repository.ProductRepository;
import leandro.aneloja.repository.ProductVariantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VariantService {
    private  final ProductRepository productRepository;
    private  final ProductVariantRepository productVariantRepository;
    private final VariantMapper mapper;
        private Product findProductOrThrow(Long id) {
            return productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        }
        @Transactional
        public VarianteResponseDTO createVariant(Long idProduct, VariantRequestDTO variantRequestDTO){
            Product p = findProductOrThrow(idProduct);
            ProductVariant variant = mapper.toEntity(variantRequestDTO);
            variant.setProduct(p);
            p.getVariants().add(variant);
            productVariantRepository.save(variant);
            return mapper.toDTO(variant);
        }

        public   List<VarianteResponseDTO> getVariantByIdProduct(Long id){
            Product p = findProductOrThrow(id);
            List<VarianteResponseDTO> variantDTO = p.getVariants().stream().map(mapper::toDTO).toList();
            return variantDTO;
        }

        @Transactional
        public VarianteResponseDTO updateVariant(Long id, VariantRequestDTO dto){
            ProductVariant  v  = getVariantByIdOrThrow(id);
            v.setSize(dto.size());
            v.setStock(dto.stock());
            v.setPrice(dto.price());
            v.setColor(dto.color());
            return mapper.toDTO(v);
        }
        @Transactional
        public void deleteVariant(Long id){
            ProductVariant v = getVariantByIdOrThrow(id);
            productVariantRepository.delete(v);
        }
        public ProductVariant getVariantByIdOrThrow(Long id){
            return productVariantRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Variant não encontrado"));
        }

}
