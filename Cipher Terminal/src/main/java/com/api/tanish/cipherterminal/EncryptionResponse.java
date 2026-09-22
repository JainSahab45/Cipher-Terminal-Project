package com.api.tanish.cipherterminal;

public class EncryptionResponse {

    private String originalText;
    private String transformedText;
    private String operation; // "encrypt" or "decrypt"

    // 1. CONSTRUCTOR
    public EncryptionResponse(String originalText, String transformedText, String operation) {
        // TODO: Assign the constructor parameters to the class fields
        this.originalText = originalText;
        this.transformedText = transformedText;
        this.operation = operation;
    }

    // 2. GETTERS

    public String getOriginalText() {
        // TODO: Return the original text field
        return originalText;
    }

    public String getTransformedText() {
        // TODO: Return the transformed text field
        return transformedText;
    }

    public String getOperation() {
        // TODO: Return the operation type (encrypt/decrypt)
        return operation;
    }
}



