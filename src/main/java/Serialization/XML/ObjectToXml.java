package Serialization.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//There are many open source XML processing packages available like Jaxb, Jackson etc
//Jackson - https://www.javatpoint.com/xml-serialization-and-deserialization-with-jackson
//Jaxb - as below
public class ObjectToXml {
    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            List<Answer> answerList = new ArrayList<>() {{
                add(new Answer("java is platform independent", "fayaz"));
                add(new Answer("java is secure", "munni"));
            }};

            Question que = new Question(1, "Java Advantages?", answerList);

            jaxbMarshaller.marshal(que, new File("src/main/java/Serialization/XML/writeTo.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
