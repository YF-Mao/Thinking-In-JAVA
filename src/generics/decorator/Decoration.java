package generics.decorator;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
    }
}

class Basic {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public String getValue() {
        return basic.getValue();
    }

    @Override
    public void setValue(String value) {
        basic.setValue(value);
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = System.currentTimeMillis();
    }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}