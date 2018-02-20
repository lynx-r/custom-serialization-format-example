/**
 * Created by Aleksey P. on 20/02/2018.
 */
public class Message2 implements Message {

    private String two;
    private Message3 msg3;

    public Message2() {
    }

    public Message2(String two, Message3 msg3) {
        this.two = two;
        this.msg3 = msg3;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public Message3 getMsg3() {
        return msg3;
    }

    public void setMsg3(Message3 msg3) {
        this.msg3 = msg3;
    }

    @Override
    public String toString() {
        return "Message2{" +
                "two='" + two + '\'' +
                ", msg3=" + msg3 +
                '}';
    }
}
