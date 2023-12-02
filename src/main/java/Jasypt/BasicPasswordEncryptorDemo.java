package Jasypt;

import org.jasypt.util.password.BasicPasswordEncryptor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasicPasswordEncryptorDemo {
    public static void main(String[] args) throws IOException {

        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

//        String encryptedPassword = passwordEncryptor.encryptPassword("fayaz");
//        System.out.println(encryptedPassword);

        Properties props = new Properties();
        props.load(new FileInputStream("./src/main/resources/demo.properties"));
        String encryptedPassword = props.getProperty("TEST_PASSWORD");
        System.out.println("loaded from file :: " + encryptedPassword);

        if (passwordEncryptor.checkPassword("fayaz", encryptedPassword)) {
            System.out.println("Same");
        } else {
            System.out.println("Differ");
        }
    }
}
