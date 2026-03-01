package com.snhu.sslserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class HashController {

    // Open in browser:
    // https://localhost:8443/hash?data=Jarod%20Jecas%20Project%20Two%202026

    @GetMapping("/hash")
    public String getHash(@RequestParam(value = "data", defaultValue = "") String data) {

        if (data == null || data.trim().isEmpty()) {
            return "Please provide data using: /hash?data=your_text_here";
        }

        String checksum = sha256Hex(data);

        return "Data: " + data + "\nSHA-256: " + checksum;
    }

    private String sha256Hex(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }
}