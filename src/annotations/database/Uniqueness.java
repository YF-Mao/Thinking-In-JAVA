package annotations.database;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/28
 **/
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
