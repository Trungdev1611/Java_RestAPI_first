package api.restful.first_app.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student inserDatatoDataBase(Student studentPost) {
        String sql = "INSERT INTO students (name, age, address) VALUES ( ?, ?, ?)";
        int result = jdbcTemplate.update(sql, studentPost.getName(), studentPost.getAge(), studentPost.getAddress());
        if (result > 0) {
            System.out.println("Insert success" + studentPost.toString());
            return studentPost;
        } else {
            return null;
        }
    }

    public List<Student> getAllDataStudentInDatabase() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (result, rowNum) -> new Student(
                result.getInt("id"),
                result.getString("name"),
                result.getInt("age"),
                result.getString("address")));

    }

    public Boolean deleteStudentInDataBase(int id) {
        String sqlcheckExits = "SELECT count(*) FROM students WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sqlcheckExits, Integer.class, id);
        if (count > 0) {
            String sqlDelete = "DELETE FROM students WHERE id = ?";
            jdbcTemplate.update(sqlDelete, id);
            return true;
        } else {
            return false;
        }

    }

    public Boolean updateStudentInDataBase(int id, Student student) {
        String sqlcheckExits = "SELECT count(*) FROM students WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sqlcheckExits, Integer.class, id);
        if (count > 0) {
            String sqlUpdate = "UPDATE students SET name = ?, age=?, address = ? WHERE id = ?";
            jdbcTemplate.update(sqlUpdate, student.getName(), student.getAge(), student.getAddress(), id);
            return true;
        } else {
            return false;
        }
    }
}
