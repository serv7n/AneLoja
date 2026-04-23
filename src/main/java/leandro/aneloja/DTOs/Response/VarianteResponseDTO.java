package leandro.aneloja.DTOs.Response;

import leandro.aneloja.enuns.Color;

import java.math.BigDecimal;
import java.util.List;

public record VarianteResponseDTO(
                                   Color color,
                                   String size,
                                   BigDecimal price,
                                   Integer stock,
                                   List<ImageResponseDTO> imagens) {

}
