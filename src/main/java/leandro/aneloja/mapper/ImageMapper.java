package leandro.aneloja.mapper;

import leandro.aneloja.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.model.ProductImage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageMapper {

    public ImageResponseDTO toDTO(ProductImage i) {
        return new ImageResponseDTO(
                i.getIsMain(),
                i.getImageUrl()
        );
    }

    protected <T> List<T> safeList(List<T> list) {
        return list == null ? List.of() : list;
    }
}