package api.restful.first_app.students;

public class Student {
    // file này sẽ định nghĩa các thông tin về sinh viên - thường được gọi là Model
    // hoặc Entity
    private int id;
    private String name;
    private int age;
    private String address;

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

}
