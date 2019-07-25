package typeinfo;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class Positiion {
    private String title;
    private Person person;

    public Positiion(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public Positiion(String jobTitle) {
        this(jobTitle, null);
        //title = jobTitle;
        //person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if (this.person == null) {
            this.person = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return "Position: " + title + " " + person;
    }
}
