package leandro.aneloja.DTOs;

import leandro.aneloja.model.ProductImage;

public record ImageResposeDTO(Boolean isMain,
                              String url) {
    public ProductImage toEntity() {
        ProductImage image = new ProductImage();
        image.setIsMain(isMain); // mantém null se vier null
        image.setImageUrl(url);
        return image;
    }
}
