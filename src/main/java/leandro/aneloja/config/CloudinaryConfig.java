package leandro.aneloja.config;

import com.cloudinary.Cloudinary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary("cloudinary://199641788479325:2H2AEskfvy0SSJA93GV7NTDnF0k@dvg9mzlnh");
    }
}