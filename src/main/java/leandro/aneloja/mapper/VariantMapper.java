package leandro.aneloja.mapper;

import leandro.aneloja.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.model.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VariantMapper {

    private final ImageMapper imageMapper;

    public VariantMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public VarianteResponseDTO toDTO(ProductVariant v) {

        List<ImageResponseDTO> images =
                imageMapper.safeList(v.getImages()).stream()
                        .map(imageMapper::toDTO)
                        .toList();

        return new VarianteResponseDTO(
                v.getColor(),
                v.getSize(),
                v.getPrice(),
                v.getStock(),
                images
        );
    }
}