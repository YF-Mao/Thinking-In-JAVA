package containers;

import java.io.*;
import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/16
 **/
public class SerializeTest {
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try {
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                oos.flush();
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), e);
            }

            return baos.toByteArray();
        }
    }

    public static Object deSerialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            try {
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
                return ois.readObject();
            } catch (IOException var2) {
                throw new IllegalArgumentException("Failed to deserialize object", var2);
            } catch (ClassNotFoundException var3) {
                throw new IllegalStateException("Failed to deserialize object type", var3);
            }
        }
    }

    public static void main(String[] args) {
        TravelDate travelDate = new TravelDate("2019-05-01", "2019-08-01");

        byte[] a = serialize(travelDate);
        System.out.println(Arrays.toString(a));
        Object o = deSerialize(a);
        System.out.println(o);

        if (o instanceof TravelDate) {
            TravelDate date = (TravelDate) o;
            System.out.println(date.getQuantity());
        }
    }
}
