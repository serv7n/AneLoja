package leandro.aneloja.controller;

import leandro.aneloja.DTOs.ImageResposeDTO;
import leandro.aneloja.DTOs.ProductResponseDTO;
import leandro.aneloja.DTOs.VarianteResponseDTO;
import leandro.aneloja.model.Product;
import leandro.aneloja.model.ProductVariant;
import leandro.aneloja.repository.ProductRepository;
import leandro.aneloja.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private  final ProductService service;
    private final ProductRepository repository;
    @GetMapping
    public ResponseEntity index(    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(service.getProducts(page, size));
    }
}
