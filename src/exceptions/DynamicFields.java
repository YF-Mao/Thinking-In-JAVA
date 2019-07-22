package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/10
 **/
public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] objects : fields) {
            result.append(objects[0]).append(": ").append(objects[1]).append("\n");
        }
        return result.toString();
    }

    private int hasFiled(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFiledNumber(String id) throws NoSuchFieldException {
        int filedNum = hasFiled(id);
        if (filedNum == -1) {
            throw new NoSuchFieldException();
        }
        return filedNum;
    }

    private int makeFiled(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        fields = tmp;
        return makeFiled(id);
    }

    public Object getFiled(String id) throws NoSuchFieldException {
        return fields[getFiledNumber(id)][1];
    }

    public Object setFiled(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            //TODO 2.把NullPointerException对象插入而建立的
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int filedNumber = hasFiled(id);
        if (filedNumber == -1) {
            filedNumber = makeFiled(id);
        }
        Object result = null;
        try {
            result = getFiled(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fields[filedNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setFiled("d", "A value for d");
            df.setFiled("number", 47);
            df.setFiled("number2", 48);
            System.out.println(df);

            df.setFiled("d", "A new value for d");
            df.setFiled("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getFiled(\"d\") : " + df.getFiled("d"));
            Object field = df.setFiled("d", null);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        }
    }
}
