package uz.pdp.appspringjpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpalesson.model.Student;

@Repository // Bean qilib beradi lekin qo'ymasa ham bo'lardi !
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
