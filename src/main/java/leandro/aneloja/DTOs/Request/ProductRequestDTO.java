package leandro.aneloja.DTOs.Request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String name,

        @NotBlank(message = "Descrição é obrigatória")
        @Size(min = 5, max = 255, message = "Descrição deve ter entre 5 e 255 caracteres")
        String description,

        @NotNull(message = "Preço é obrigatório")
        @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
        BigDecimal basePrice

) {}