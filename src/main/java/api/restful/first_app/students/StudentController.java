package api.restful.first_app.students;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    // Controller - chịu trách nhiệm nhận request và trả về reponse cho client. Việc
    // xử lý dữ liệu để cho bước này được xử lý ở service
    // nó là trung gian của client và Service
    private StudentSerrvice studentSerrvice;

    public StudentController(StudentSerrvice studentSerrvice) {
        this.studentSerrvice = studentSerrvice;
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudent() {
        return studentSerrvice.getAll();

    }

    @PostMapping("/students")
    public Student AddStudent(@RequestBody Student student) { // lấy từ body ra student và trả về đối tượng đó
        System.out.println("Student:::" + student.toString());
        return studentSerrvice.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public Optional<Student> UpdateStudent(@PathVariable int id, @RequestBody Student student) { // Optional cho phép
                                                                                                 // trả về giá trị null
        System.out.println("Student:::" + student.toString());
        return studentSerrvice.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public Optional<Student> DeleteStudent(@PathVariable int id) {
        return studentSerrvice.deleteStudent(id);

    }

}
