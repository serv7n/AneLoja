package leandro.aneloja.controller;

import leandro.aneloja.DTOs.Request.VariantRequestDTO;
import leandro.aneloja.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
@AllArgsConstructor
public class VariantController {

    private final VariantService variantService;

    @PostMapping("/products/{idProduct}/variants")
    public ResponseEntity<Void> createVariants(
            @PathVariable Long idProduct,
            @RequestBody VariantRequestDTO variantRequestDTO) {

        variantService.createVariant(idProduct, variantRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products/{idProduct}/variants")
    public ResponseEntity<List<VarianteResponseDTO>> getVariants(@PathVariable Long idProduct) {
        return ResponseEntity.ok(variantService.getVariantByIdProduct(idProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VarianteResponseDTO> updateVariant(
            @PathVariable Long id,
            @RequestBody VariantRequestDTO dto) {

        return ResponseEntity.ok(variantService.updateVariant(id, dto));
    }
}