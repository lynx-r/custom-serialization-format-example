import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Aleksey P. on 20/02/2018.
 */
public interface Message extends Externalizable {

    @Override
    default void writeExternal(ObjectOutput out) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ZipOutputStream zout = new ZipOutputStream(bout);
        zout.putNextEntry(new ZipEntry(getClass().getName()));
        Gson gson = new Gson();
        String json = gson.toJson(this);
        zout.write(json.getBytes());
        System.out.println("Объект был конвертирован в JSON:\n\t" + json);
        System.out.println("длинной " + json.length() + " символа");
        zout.close();
        byte[] b = bout.toByteArray();
        System.out.println("Объект был сжат в последовательность байт:");
        System.out.println(new String(b));
        System.out.println("длинной " + b.length + " символа");
        out.write(b);
    }

    @Override
    default void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int BUFFER = 256;
        byte[] buffer = new byte[BUFFER];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (in.read(buffer) != -1) {
            out.write(buffer);
        }
        byte[] buf = out.toByteArray();
        ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(buf));
        while (zin.available() == 1) {
            ZipEntry entry = zin.getNextEntry();
            String className = entry.getName();
            byte[] bytes = zin.readAllBytes();
            String json = new String(bytes);
            Gson gson = new Gson();
            Object message = gson.fromJson(json, Class.forName(className));
            Arrays.stream(message.getClass().getDeclaredFields())
                    .forEach(field -> {
                        try {
                            Field f = getClass().getDeclaredField(field.getName());
                            f.setAccessible(true);
                            field.setAccessible(true);
                            f.set(this, field.get(message));
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
