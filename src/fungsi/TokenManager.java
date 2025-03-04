/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fungsi;

/**
 *
 * @author thori
 */
import java.util.prefs.Preferences;

public class TokenManager {
    private static final String TOKEN_KEY = "auth_token";
    private static final Preferences prefs = Preferences.userRoot().node(TokenManager.class.getName());

    // Simpan Token
    public static void saveToken(String token) {
        prefs.put(TOKEN_KEY, token);
    }

    // Ambil Token
    public static String getToken() {
        return prefs.get(TOKEN_KEY, null); // Default null jika tidak ada token
    }

    // Hapus Token (Misal saat Logout)
    public static void clearToken() {
        prefs.remove(TOKEN_KEY);
    }

    public static void main(String[] args) {
        saveToken("your_jwt_token_here");
        System.out.println("Stored Token: " + getToken());
        clearToken();
        System.out.println("Token after clear: " + getToken());
    }
}

