package generics;

import java.awt.*;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}

interface HasColor {
    java.awt.Color getColor();
}

class Testele<T extends HasColor>{

}

class Colored<T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    public static void main(String[] args) {
        TypeVariable<Class<Colored>>[] typeVariable = Colored.class.getTypeParameters();
        for (TypeVariable<Class<Colored>> type : typeVariable) {
            System.out.println(type.getName());

            Type[] types = type.getBounds();
            for (Type t : types) {
                System.out.println(t);
            }

            System.out.println(type.getGenericDeclaration());
        }
    }
}

class Dimension {
    public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

