package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class MultipleInterfaceVariants {
}

interface Payable<T> {

}

class Employees implements Payable<Employee> {

}

//无法编译，由于擦除的存在，意味着在重复实现相同的接口
//列如Comparable接口
//TODO 11.一旦Comparable确定了泛型参数，那么该类及其子类都不能与该泛型参数之外的任何对象比较了
//详见 CRGWithBasicHolder 类
//class Hourly extends Employees implements Payable<Hourly> {
//
//}
