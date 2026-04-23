package leandro.aneloja.service;

import leandro.aneloja.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.model.ProductImage;
import leandro.aneloja.repository.ProductImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageService {
    private  final  ProductImageRepository repository;
    public ImageResponseDTO newImage(String urlImage){
        ProductImage image = new ProductImage();
        image.setImageUrl(urlImage);
        repository.save(image);
        return  new ImageResponseDTO(false,urlImage);
    }
}
