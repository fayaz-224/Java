package JavaConcepts.Serialization.JSON;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//There are many open source JSON processing packages available like gson, Jackson etc
//Jackson - https://www.tutorialspoint.com/how-to-convert-java-object-to-json-using-jackson-library
//gson - as below
public class ObjectToJson {
    public static void main(String[] args) throws IOException {

        MobilePhone mobile = new MobilePhone();
        mobile.setBrand("SAMSUNG");
        mobile.setName("S25");
        mobile.setRam(8);
        mobile.setRom(128);

        Gson gson = new Gson();
        String json = gson.toJson(mobile); // Convert object to JSON string

        // Now write the JSON string to a file
        try (Writer fileWriter = new FileWriter("src/main/java/Serialization/JSON/output.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
//Converting the Object to JSONString using Jackson
      ObjectMapper mapper = new ObjectMapper();
      String jsonString = mapper.writeValueAsString(mobile);
      // then write to a file
 */