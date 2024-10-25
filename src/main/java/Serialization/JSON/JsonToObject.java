package Serialization.JSON;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//There are many open source JSON processing packages available like gson, Jackson etc
//Jackson - https://www.tutorialspoint.com/how-to-convert-java-object-to-json-using-jackson-library
//gson - as below
public class JsonToObject {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        MobilePhone mobile = gson.fromJson(new FileReader("src/main/java/Serialization/JSON/input.json"), MobilePhone.class);
        System.out.println(mobile);
    }
}
