package leandro.aneloja.DTOs.Response;

import leandro.aneloja.model.ProductImage;

public record ImageResponseDTO(Boolean isMain,
                               String url) {
    public ProductImage toEntity() {
        ProductImage image = new ProductImage();
        image.setIsMain(isMain); // mantém null se vier null
        image.setImageUrl(url);
        return image;
    }
}
