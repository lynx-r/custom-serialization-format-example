/**
 * Created by Aleksey P. on 20/02/2018.
 */
public class Message3 implements Message {

    private String three;
    private Message1 msg1;

    public Message3() {
    }

    public Message3(Message1 msg1) {
        this.msg1 = msg1;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public Message1 getMsg1() {
        return msg1;
    }

    public void setMsg1(Message1 msg1) {
        this.msg1 = msg1;
    }

    @Override
    public String toString() {
        return "Message3{" +
                "three='" + three + '\'' +
                ", msg1=" + msg1 +
                '}';
    }
}
