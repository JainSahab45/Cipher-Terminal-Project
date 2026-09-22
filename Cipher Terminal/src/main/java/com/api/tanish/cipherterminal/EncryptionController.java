package com.api.tanish.cipherterminal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Add the annotation to mark this class as a REST Controller
@RestController
// TODO: Map this controller to the base path "/api"
@RequestMapping("/api")
public class EncryptionController {

    private final EncryptionService encryptionService;

    // 1. CONSTRUCTOR INJECTION
    public EncryptionController(EncryptionService encryptionService) {
        // TODO: Assign the passed service to the class field
        this.encryptionService = encryptionService;
    }

    // 2. ENCRYPT ENDPOINT
    // TODO: Map this method to handle GET requests at "/encrypt"
    @GetMapping("/encrypt")
    public EncryptionResponse encrypt(@RequestParam String message) {
        // TODO: Call the service's encrypt method
        String encrypted = encryptionService.encrypt(message);

        // TODO: Return a new EncryptionResponse object with message, encrypted text, and the string "encryption"
        return new EncryptionResponse(message,encrypted, "encryption");
    }

    // 3. DECRYPT ENDPOINT
    // TODO: Map this method to handle GET requests at "/decrypt"
    @GetMapping("/decrypt")
    public EncryptionResponse decrypt(@RequestParam String message) {
        // TODO: Call the service's decrypt method
        String decrypted = encryptionService.decrypt(message);

        // TODO: Return a new EncryptionResponse object with message, decrypted text, and the string "decryption"
        return new EncryptionResponse(message, decrypted, "decryption");
    }
}



