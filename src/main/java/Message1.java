/**
 * Created by Aleksey P. on 20/02/2018.
 */
public class Message1 implements Message {

    private String one;
    private Message2 msg2;

    public Message1() {
    }

    public Message1(String one, Message2 msg2) {
        this.one = one;
        this.msg2 = msg2;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public Message2 getMsg2() {
        return msg2;
    }

    public void setMsg2(Message2 msg2) {
        this.msg2 = msg2;
    }

    @Override
    public String toString() {
        return "Message1{" +
                "one='" + one + '\'' +
                ", msg2=" + msg2 +
                '}';
    }
}
