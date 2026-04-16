package leandro.aneloja.DTOs;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import leandro.aneloja.model.ProductVariant;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO(
            Long id,
         String name,
         String description,
         BigDecimal basePrice,
         List<VarianteResponseDTO> variants) {
}
