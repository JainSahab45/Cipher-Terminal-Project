package com.api.tanish.cipherterminal;

import org.springframework.stereotype.Service;

// TODO: Annotate this class to indicate it's a service component in Spring
@Service
public class EncryptionService {

    // Secret key for scrambling
    private static final int SHIFT = 5;

    public String encrypt(String text) {
        // TODO: Call the process method with the text and the SHIFT constant
        return process(text, SHIFT);

    }

    public String decrypt(String text) {
        /* TODO: Call the process method with the text.
           To move backward by SHIFT, we move forward by (26 - SHIFT).
        */
        return process(text, 26 - SHIFT);

    }

    private String process(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // TODO: Convert the input text into a character array and loop through it
        for (char character : text.toCharArray()) {

            if (Character.isLetter(character)) {

                // TODO: Set the 'base' to 'a' if lowercase, or 'A' if uppercase
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                /* TODO: Apply the Caesar Cipher formula:
                   1. Subtract the base from the character
                   2. Add the shift
                   3. Apply modulo 26 to stay within alphabet bounds
                   4. Add the base back to return to the correct ASCII range
                */
                char transformed = (char) ((character - base + shift)%26 + base ) ;

                result.append(transformed);
            } else {
                // TODO: If it's not a letter (space, number, punctuation),
                // just append it as it is
                result.append(character);
            }
        }

        // TODO: Convert the StringBuilder back to a regular String and return it

        return result.toString();
    }
}


