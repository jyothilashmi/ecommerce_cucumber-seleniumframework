package Learn.com.magento.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;


public class CommonActionUtil {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "MySecretKey12345"; // 16-byte key

    private static SecretKeySpec getKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, getKey());
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, getKey());
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decrypted, "UTF-8");
    }    
   /* Code to find the decrypt and encrypt the string
    *  public static void main(String[] args) {
        try {
            String original = "SensitivePassword123!";
            System.out.println("Original: " + original);

            String encrypted = encrypt(original);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = decrypt(encrypted);
            System.out.println("Decrypted: " + decrypted);

        } catch (Exception e) {
            System.err.println("Encryption/Decryption error: " + e.getMessage());
            e.printStackTrace();
        }
    }*/
}
