package api.restful.first_app.students;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // khi đã dùng hibernate, ta chỉ cần tạo 1 interface như trên và không cần khai
    // báo các method ở đây
    // bên Service ta chỉ cần tạo một @Autowired (bean) StudentRepository và sử dụng
    // các method có sẵn của Hibernate như
    // save(data) = create
    // findById()
    // findAll()
    //

    // hoặc ta cũng có thể định danh các method ở đây và tạo 1 class triển khai từ
    // interface StudentRepository
    // VD:
    // https://github.dev/scbushan05/spring-boot-hibernate-mysql-rest-api/tree/master/crudapi/src/main
}
