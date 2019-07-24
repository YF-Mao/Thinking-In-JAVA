package typeinfo.toys;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
