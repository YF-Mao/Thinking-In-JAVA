package containers;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/15
 **/
public class TypesForSets {
}

class SetType {
    int i;

    public SetType(int n) {
        i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType) obj).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {

    public HashType(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType o) {
        return Integer.compare(o.i, i);
    }
}
