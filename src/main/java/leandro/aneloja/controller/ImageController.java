package leandro.aneloja.controller;

import leandro.aneloja.model.ProductImage;

import leandro.aneloja.service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageController {

    private final ProductImageService service;
    @GetMapping("/unassigned")
    public ResponseEntity<List<ProductImage>> getAllImageWhereNotVariant() {
        return ResponseEntity.ok(service.getAllImageWhereNotVariant());
    }

    @PostMapping("/{idImage}/variant/{idVariant}")
    public ResponseEntity<Void> setVariantImage(
            @PathVariable Long idImage,
            @PathVariable Long idVariant) {

        service.setVariantImage(idImage, idVariant);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        service.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}