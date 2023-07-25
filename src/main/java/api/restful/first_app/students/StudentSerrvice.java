package api.restful.first_app.students;

import org.springframework.stereotype.Service;

@Service
public class StudentSerrvice {

    Student student1 = new Student(1, "John", 20, "Hà Nội");
    Student student2 = new Student(2, "John", 20, "Hà Nội");
    Student student3 = new Student(3, "John", 20, "Hà Nội");

    Student[] arr = {
            student1, student2, student3
    };

    public Student[] getAll() {
        return arr;
    }
}
