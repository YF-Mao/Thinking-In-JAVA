package containers;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/26
 **/
public class Demo {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("2019-05");
        List<TravelDate> travelDates = new ArrayList<>();
        travelDates.add(new TravelDate("2019-05", "2019-05"));
        travelDates.add(new TravelDate("2019-04", "2019-05"));

        List<String> travelDates1 = travelDates.stream().map(TravelDate::getDateTo).collect(Collectors.toList());
        List<TravelDate> travelDates2;
        Map<String, Integer> map = travelDates.stream().collect(Collectors.groupingBy(TravelDate::getDateTo
                , Collectors.summingInt(TravelDate::getQuantity)));

        Map<String, Integer> map1 = travelDates.stream().collect(Collectors.groupingBy(TravelDate::getDateTo
                , Collectors.summingInt(TravelDate::getQuantity)));

        System.out.println(travelDates1);
        System.out.println("map: " + map);

        f(travelDates, stringSet);
        System.out.println(travelDates);
        System.out.println(stringSet);
        StringBuilder s = new StringBuilder("test");
        System.out.println(s.insert(0, "123").deleteCharAt(s.length()-1));
    }

    public static void f(List<TravelDate> travelDates, Set<String> stringSet) {
        for (TravelDate travelDate : travelDates) {
            if (stringSet.add(travelDate.getDateFrom())) {
                f(addList(travelDates, "2019-04", "2019-04"), new HashSet<>(stringSet));
            }
            if (stringSet.add(travelDate.getDateTo())) {
                f(addList(travelDates, "2019-05", "2019-05"), new HashSet<>(stringSet));
            }
        }
    }

    public static List<TravelDate> addList(List<TravelDate> travelDates, String dateFrom, String dateTo) {
        List<TravelDate> result = new ArrayList<>(travelDates);
        result.add(new TravelDate(dateFrom, dateTo));
        return result;
    }
}

class TravelDate implements Serializable {
    private static final long serialVersionUID = 1L;

    public TravelDate(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public TravelDate() {

    }

    private String dateFrom;
    private String dateTo;
    private Integer quantity = 1;

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "dateFrom: " + this.dateFrom + ",dateTo: " + this.dateTo;
    }
}
