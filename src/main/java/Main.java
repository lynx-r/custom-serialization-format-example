import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Message message = new Message1("1", createMsg2(6));

        FileOutputStream fos = new FileOutputStream("m1");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(message);

        FileInputStream fis = new FileInputStream("m1");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Message1 msg1 = (Message1) ois.readObject();

        System.out.println("Оригинальный объект:\t" + message);
        System.out.println("Восстановленный объект:\t" + msg1);
    }

    private static Message2 createMsg2(int deep) {
        return new Message2("2", createMsg3(--deep));
    }

    private static Message3 createMsg3(int deep) {
        if (deep == 0) {
            return new Message3(null);
        }
        return new Message3(new Message1("12", createMsg2(deep)));
    }
}
