package annotations.database;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/28
 **/
@DBTable(name = "MEMBER")
public class Member {
    //因为30是唯一赋值元素，所以无需写出value

    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }
}
