package api.restful.first_app.students;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentSerrvice {

    Student student1 = new Student(1, "John", 20, "Hà Nội");
    Student student2 = new Student(2, "John", 20, "Hà Nội");
    Student student3 = new Student(3, "John", 20, "Hà Nội");
    Student student4 = new Student(3, "John", 20, "Hà Nội");

    ArrayList<Student> arr = new ArrayList<>();

    public StudentSerrvice() {
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);
    }

    public ArrayList<Student> getAll() {
        return arr;
    }

    public Student addStudent(Student student) {
        // lấy được student trong request được truyền từ controller
        arr.add(student);
        return student;
    }

    public Optional<Student> updateStudent(int id, Student student) {
        for (Student studentItem : arr) {
            if (studentItem.getId() == id) {

                // lặp qua từng phần tử, tìm thấy phần tử có id trùng và tiến hành update
                studentItem.setName(student.getName());
                studentItem.setAge(student.getAge());
                studentItem.setAddress(student.getAddress());

                return Optional.of(studentItem);
            }
        }
        return Optional.empty(); // trả về null
    }

    public Optional<Student> deleteStudent(int id) {
        for (Student studentItem : arr) {
            if (studentItem.getId() == id) {
                arr.remove(studentItem);
                return Optional.of(studentItem);
            }
        }
        return Optional.empty();
    }

}
