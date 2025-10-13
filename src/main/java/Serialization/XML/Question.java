package Serialization.XML;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  //annotation from the JAXB (Java Architecture for XML Binding) API. indicates the root element of an XML document
public class Question {
    private int id;
    private String questionname;
    private List<Answer> answer;

    public Question() {}
    public Question(int id, String questionname, List<Answer> answers) {
        super();
        this.id = id;
        this.questionname = questionname;
        this.answer = answers;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getQuestionname() {
        return questionname;
    }
    public void setQuestionname(String questionname) {
        this.questionname = questionname;
    }
    @XmlElement
    public List<Answer> getAnswer() {
        return answer;
    }
    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}

/*
<employee id="101">
    <name>Alice</name>
    <age>30</age>
</employee>

id -> XmlAttribute
name and age -> XmlElement
 */