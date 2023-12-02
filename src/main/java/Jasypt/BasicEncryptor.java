package Jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasicEncryptor {
    public static void main(String[] args) throws IOException {

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("test");

//        Properties props = new Properties();
//        props.load(new FileInputStream("./src/main/resources/demo.properties"));
//        String encryptedPassword = props.getProperty("TEST_PASSWORD");
//        System.out.println("loaded from file :: " +encryptedPassword);

//        String encryptedPassword = textEncryptor.encrypt("Asmsa1");
//        System.out.println(encryptedPassword);

        String plainText = textEncryptor.decrypt("password");
        System.out.println(plainText);
    }
}
