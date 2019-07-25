package typeinfo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class Staff extends ArrayList<Positiion> {
    public void add(String title, Person person) {
        add(new Positiion(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Positiion(title));
        }
    }

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvaliable(String title) {
        for (Positiion positiion : this) {
            if (positiion.getTitle().equals(title) && positiion.getPerson() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosistion(String title, Person hire) {
        for (Positiion positiion : this) {
            if (positiion.getTitle().equals(title) && positiion.getPerson() == Person.NULL) {
                positiion.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manage"
                , "Project Lead", "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer",
                "Test Engineer", "Technical Writer");
        staff.fillPosistion("President", new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosistion("Project Lead", new Person("Janet", "Planner", "The Burbs"));
        if (staff.positionAvaliable("Software Engineer")) {
            staff.fillPosistion("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
        }
        System.out.println(staff);
    }
}
