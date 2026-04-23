package leandro.aneloja.DTOs.Response;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO(
            Long id,
         String name,
         String description,
         BigDecimal basePrice,
         List<VarianteResponseDTO> variants) {
}
