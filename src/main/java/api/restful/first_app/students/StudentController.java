package api.restful.first_app.students;

import api.restful.first_app.common.ApiResponse;
import org.springframework.http.ResponseEntity;
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
    private final StudentSerrvice studentSerrvice;

    public StudentController(StudentSerrvice studentSerrvice) {
        this.studentSerrvice = studentSerrvice;
    }

    @GetMapping("/students")
    // ResponseEntity<?> sử dụng dấu ? để cho kiểu dữ liệu tùy ý - giống any bên
    // typescript
    public ResponseEntity<ApiResponse> getStudent() { // sử dụng ResponseEntity để custom request với status
        return studentSerrvice.getAll();

    }

    @PostMapping("/students")
    public ResponseEntity<ApiResponse> AddStudent(@RequestBody Student student) { // lấy từ body ra student và trả về
                                                                                  // đối tượng đó
        System.out.println("Student:::" + student.toString());
        return studentSerrvice.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> UpdateStudent(@PathVariable int id, @RequestBody Student student) { // Optional
                                                                                                      // cho phép
        // trả về giá trị null
        System.out.println("Student:::" + student.toString());
        return studentSerrvice.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> DeleteStudent(@PathVariable int id) {
        return studentSerrvice.deleteStudent(id);

    }

}
