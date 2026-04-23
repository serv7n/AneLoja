package leandro.aneloja.controller;

import leandro.aneloja.DTOs.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Map<String, String> users = new HashMap<>();

    public AuthController() {
        users.put("admin@email.com", "123456");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        String password = users.get(dto.getEmail());

        if (password != null && password.equals(dto.getPassword())) {
            return ResponseEntity.ok("login ok");
        }

        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}