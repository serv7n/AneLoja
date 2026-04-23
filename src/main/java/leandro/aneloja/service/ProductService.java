package leandro.aneloja.service;

import jakarta.transaction.Transactional;
import leandro.aneloja.DTOs.Request.ProductRequestDTO;
import leandro.aneloja.DTOs.Response.ProductResponseDTO;
import leandro.aneloja.mapper.ProductMapper;
import leandro.aneloja.model.Product;
import leandro.aneloja.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Page<ProductResponseDTO> getProducts(int page, int size) {
        Page<Product> products = repository.findAll(PageRequest.of(page, size));
        return products.map(mapper::toDTO);
    }
    @Transactional
    public void newProduct(ProductRequestDTO productDTO){
            Product p = mapper.toEntity(productDTO);
            repository.save(p);
    }
    @Transactional
    public void editProduct(ProductRequestDTO pDTO, Long id){
        Product p = findProductOrThrow(id);

        p.setName(pDTO.name());
        p.setDescription(pDTO.description());
        p.setBasePrice(pDTO.basePrice());
    }
    private Product findProductOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    @Transactional
    public void removeProduct(Long id){
        Product p = findProductOrThrow(id);
        repository.delete(p);
    }
    public ProductResponseDTO getProductById(Long id){
        return mapper.toDTO(findProductOrThrow(id));
    }
}
