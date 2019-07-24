package typeinfo;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;

        //genericIntClass = double.class; Illegal


        /**
         * 通配符? 表示任何事物，使用Class<\?>表示 你就是选择了非具体的版本
         *
         */
        Class<?> intClass1 = int.class;
        intClass = double.class;

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
