package leandro.aneloja.controller;

import leandro.aneloja.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.service.CloudinaryService;
import leandro.aneloja.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final CloudinaryService cloudinaryService;
    private final ImageService imageService;

    public UploadController(CloudinaryService cloudinaryService, ImageService imageService) {
        this.cloudinaryService = cloudinaryService;
        this.imageService = imageService;
    }
    @PostMapping
    public ResponseEntity<ImageResponseDTO> upload(@RequestParam("file") MultipartFile file) {

        String urlImage = cloudinaryService.uploadImage(file);
        ImageResponseDTO response = imageService.newImage(urlImage);

        return ResponseEntity.ok(response);
    }
}