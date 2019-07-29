package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {

}
