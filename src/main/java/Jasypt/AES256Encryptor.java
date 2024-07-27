package Jasypt;

import org.jasypt.util.text.AES256TextEncryptor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AES256Encryptor {
    public static void main(String[] args) throws IOException {

        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("password"); //key is imp

        Properties props = new Properties();
        props.load(new FileInputStream("./src/main/Java/resources/credentials.properties"));
        String encryptedPassword = props.getProperty("TEST_PASSWORD");
        System.out.println("loaded from file :: " + encryptedPassword);

//        String encryptedPassword = textEncryptor.encrypt("fayaz");
//        System.out.println(encryptedPassword);

        String plainText = textEncryptor.decrypt(encryptedPassword);
        System.out.println(plainText);
    }
}
