package api.restful.first_app.students;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Tạo table Student trong database
public class Student {
    // file này sẽ định nghĩa các thông tin về sinh viên - thường được gọi là Model
    // hoặc Entity
    public Student() {

    }

    @Id // chỉ định id là primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự tăng, tự tạo
    private int id;
    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", address='" + getAddress() + "'" +
                "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
