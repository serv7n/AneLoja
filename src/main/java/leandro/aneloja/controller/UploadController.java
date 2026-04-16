package com.example.loja.controller;

import leandro.aneloja.service.CloudinaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final CloudinaryService cloudinaryService;

    public UploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) {
        return cloudinaryService.uploadImage(file);
    }
}