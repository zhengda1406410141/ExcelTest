package upupoo.com.entity;

import java.io.Serializable;

public class ExcelEntity implements Serializable{
    private String name;
    private Integer age;
    private Integer workAge;
    private Integer wages;
    private Long phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
