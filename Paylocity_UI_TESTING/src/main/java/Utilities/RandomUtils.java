package Utilities;

import java.security.SecureRandom;
import java.util.UUID;

public class RandomUtils {
    public static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static String getRandomEmail(String domain){
        return getRandomString() + "@" + domain;
    }

    public static String getRandomPassword() {
        return getRandomString();
    }

    public static String getRandomUsername() {
        return getRandomString();
    }

    public static String generateRandomEmail(String domain) {
        return UUID.randomUUID().toString().substring(0, 10) + "@" + domain;
    }

    public static void main (String[] args) {
        System.out.println(getRandomEmail("gmail.com"));
        System.out.println(generateRandomEmail("gmail.com"));
        System.out.println(getRandomPassword());
        System.out.println(getRandomUsername());
    }
}