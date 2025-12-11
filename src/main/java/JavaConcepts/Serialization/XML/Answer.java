package JavaConcepts.Serialization.XML;

public class Answer {
    private String answername;
    private String postedby;

    public Answer() {}
    public Answer(String answername, String postedby) {
        super();
        this.answername = answername;
        this.postedby = postedby;
    }

    public String getAnswername() {
        return answername;
    }
    public void setAnswername(String answername) {
        this.answername = answername;
    }
    public String getPostedby() {
        return postedby;
    }
    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

}
