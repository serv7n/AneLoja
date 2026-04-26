package leandro.aneloja.DTOs.Request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import leandro.aneloja.enuns.Color;

import java.math.BigDecimal;

public record VariantRequestDTO(
        Color color,
         String size,
         BigDecimal price,
         Integer stock
) {
}
