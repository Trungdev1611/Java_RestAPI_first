package api.restful.first_app.students;

import org.springframework.web.bind.annotation.GetMapping;
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
    public Student[] getStudent() {
        return studentSerrvice.getAll();

    }
}
