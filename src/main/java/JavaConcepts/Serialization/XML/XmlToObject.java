package JavaConcepts.Serialization.XML;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//There are many open source XML processing packages available like Jaxb, Jackson etc
//Jackson - https://www.javatpoint.com/xml-serialization-and-deserialization-with-jackson
//Jaxb - as below
public class XmlToObject {
    public static void main(String[] args) {

        try {
            File file = new File("src/main/java/Serialization/XML/readFrom.xml");  //we should give absolute path
            JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Question que = (Question) jaxbUnmarshaller.unmarshal(file);

            System.out.println(que.getId()+". "+que.getQuestionname());
            System.out.println("Answers:");

            List<Answer> list = que.getAnswer();
            for(Answer ans:list)
                System.out.println(ans.getAnswername());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}