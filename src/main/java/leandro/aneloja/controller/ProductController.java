package leandro.aneloja.controller;

import jakarta.validation.Valid;
import leandro.aneloja.DTOs.Request.ProductRequestDTO;
import leandro.aneloja.DTOs.Response.ProductResponseDTO;
import leandro.aneloja.repository.ProductRepository;
import leandro.aneloja.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private  final ProductService service;
    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> index(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(service.getProducts(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.getProductById(id));
    }
    @PostMapping
    public ResponseEntity createNewProduct(@RequestBody  @Valid ProductRequestDTO ProductDTO){
        service.newProduct(ProductDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@RequestBody @Valid ProductRequestDTO productDTO,
                                         @PathVariable Long id) {

        service.editProduct(productDTO, id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        service.removeProduct(id);
        return ResponseEntity.ok().build();
    }


}
