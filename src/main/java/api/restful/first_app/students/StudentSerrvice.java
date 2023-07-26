package api.restful.first_app.students;

import java.util.ArrayList;
import java.util.Optional;

import api.restful.first_app.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //ResponseEntity<?> sử dụng dấu ? để cho kiểu dữ liệu tùy ý
    public ResponseEntity<ApiResponse> getAll() {
        ApiResponse responseSuccess = new ApiResponse("success", arr);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);  //sau java7 ta chỉ cần sử dụng dấu <> còn trước java7   return new ResponseEntity<ApiResponse>(responseSuccess, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> addStudent(Student student) {
        // lấy được student trong request được truyền từ controller
        arr.add(student);
//        return student;
        ApiResponse responseSuccess = new ApiResponse("success", student);
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateStudent(int id, Student student) {
        for (Student studentItem : arr) {
            if (studentItem.getId() == id) {

                // lặp qua từng phần tử, tìm thấy phần tử có id trùng và tiến hành update
                studentItem.setName(student.getName());
                studentItem.setAge(student.getAge());
                studentItem.setAddress(student.getAddress());
                ApiResponse responseSuccess = new ApiResponse("success1", studentItem);
                return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
            }
        }
        ApiResponse responseError = new ApiResponse("error", null);
        return new ResponseEntity<>(responseError, HttpStatus.OK); // trả về null
    }

    public ResponseEntity<ApiResponse> deleteStudent(int id) {
        for (Student studentItem : arr) {
            if (studentItem.getId() == id) {
                arr.remove(studentItem);
                ApiResponse responseSuccess = new ApiResponse("success", studentItem);
                return new ResponseEntity<ApiResponse>(responseSuccess, HttpStatus.OK);
            }
        }
        ApiResponse responseError = new ApiResponse("error", null);
        return new ResponseEntity<ApiResponse>(responseError, HttpStatus.OK);
    }

}
