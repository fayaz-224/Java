package Jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StandardPBEEncryptor {
    public static void main(String[] args) throws IOException {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("jasypt");
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());

        Properties props = new Properties();
        props.load(new FileInputStream("./src/main/resources/demo.properties"));
        String encryptedPassword = props.getProperty("TEST_PASSWORD");
        System.out.println("loaded from file :: " + encryptedPassword);

//        String encryptedPassword = encryptor.encrypt("fayaz");
//        System.out.println(encryptedPassword);

        String plainText = encryptor.decrypt(encryptedPassword);
        System.out.println(plainText);

    }
}
