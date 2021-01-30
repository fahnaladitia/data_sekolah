package net.data.sekolah;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "natural000";
        String encoded = encoder.encode(rawPassword);

        System.out.println(encoded);
    }
}
