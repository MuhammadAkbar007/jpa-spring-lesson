package uz.pdp.appspringjpalesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpalesson.model.Student;
import uz.pdp.appspringjpalesson.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController // Controller e'lon qilib bean qiladi
public class StudentController {

    @Autowired // Beanni chaqiruvchi annotatsiya
    StudentRepository studentRepository;

    /* Read all student list */
    @RequestMapping(value = "/student", method = RequestMethod.GET) // Yo'lni tutib olib, boshqarish
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /* Add student */
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) { // JSON dan class ga parse qilib beradi
        studentRepository.save(student);
        return "Student added !";
    }

    /* Get student by id */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id) { // urldan kelgan parametrni olish
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseGet(Student::new);
    }

    /* Delete student */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted !";
    }

    /* Update student */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable Integer id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student editingStudent = optionalStudent.get();
            editingStudent.setFirstName(student.getFirstName());
            editingStudent.setLastName(student.getLastName());
            editingStudent.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(editingStudent);
            return "Student edited !";
        }
        return "Student not found !";
    }
}
