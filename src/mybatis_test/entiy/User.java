package mybatis_test.entiy;

public class User {
    private String stu_num;
    private String stu_name;
    private String stu_gender;
    private int stu_age;
    private String stu_tel;

    public User(String stu_num, String stu_name, String stu_gender, int stu_age, String stu_tel) {
        this.stu_num = stu_num;
        this.stu_name = stu_name;
        this.stu_gender = stu_gender;
        this.stu_age = stu_age;
        this.stu_tel = stu_tel;
    }

    public User() {
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public int getStu_age() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_tel() {
        return stu_tel;
    }

    public void setStu_tel(String stu_tel) {
        this.stu_tel = stu_tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_age=" + stu_age +
                ", stu_tel='" + stu_tel + '\'' +
                '}';
    }
}
