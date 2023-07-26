package api.restful.first_app.students;

import java.util.List;

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

        List<Student> arr = studentRepository.getAllDataStudentInDatabase();
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
        Object result = studentRepository.inserDatatoDataBase(student);

        ApiResponse responseSuccess = new ApiResponse("success", result);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudent(int id, Student student) {

        Boolean isUpdate = studentRepository.updateStudentInDataBase(id, student);
        if (isUpdate) {
            return new ResponseEntity<>("Update row success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update row failed or not exits row", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteStudent(int id) {

        Boolean isDelete = studentRepository.deleteStudentInDataBase(id);
        if (isDelete) {
            return new ResponseEntity<>("Delete row success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delete row failed or not exits row", HttpStatus.BAD_REQUEST);
        }

    }

}
