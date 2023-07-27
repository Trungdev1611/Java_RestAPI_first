package api.restful.first_app.students;

import java.util.List;
import java.util.Optional;

import api.restful.first_app.common.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentSerrvice {
    StudentRepository studentRepository;

    // connect với bean bên StudentRespository
    @Autowired
    public StudentSerrvice(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ResponseEntity<?> sử dụng dấu ? để cho kiểu dữ liệu tùy ý
    public ResponseEntity<ApiResponse> getAll() {

        // sử dụng method findAll get toàn bộ dữ liệu thay cho method tự tạo lúc trước
        List<Student> arr = studentRepository.findAll();
        ApiResponse responseSuccess = new ApiResponse("success", arr);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK); // sau java7 ta chỉ cần sử dụng dấu <> còn trước
                                                                     // java7 return new
                                                                     // ResponseEntity<ApiResponse>(responseSuccess,
                                                                     // HttpStatus.OK);
    }

    // thêm data vào cơ sở dữ liệu
    public ResponseEntity<ApiResponse> addStudent(Student student) {
        // lấy được student trong request được truyền từ controller
        // lấy result từ bên insert Respository

        // sử dụng save thay cho method addStudent tự tạo lúc trước
        Object result = studentRepository.save(student);

        ApiResponse responseSuccess = new ApiResponse("success", result);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateStudent(int id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setAddress(student.getAddress());

            studentRepository.save(existingStudent);

            ApiResponse responseSuccResponse = new ApiResponse("updateSuccess", existingStudent);
            return new ResponseEntity<ApiResponse>(responseSuccResponse, HttpStatus.OK);
        } else {
            ApiResponse responseError = new ApiResponse("updateSuccess", null);
            return new ResponseEntity<ApiResponse>(responseError, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteStudent(int id) {

        Boolean isFound = studentRepository.existsById(id);
        if (isFound) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Delete row success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delete row failed or not exits row", HttpStatus.BAD_REQUEST);
        }

    }

}
