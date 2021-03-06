package pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.model.Group;
import pl.model.Student;
import pl.model.Teacher;
import pl.repository.StudentRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student getOne(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public List<Student> findByNameAndTeacher(String name,Teacher teacher) {
        List<Student> student = studentRepository.findByNameAndTeacher(name,teacher);
        return student;
    }

    public List<Student> findByTeacher(Teacher teacher){
        List<Student> students = studentRepository.findByTeacher(teacher);
        return students;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByGroup(Group group){
        List<Student> students = studentRepository.findByGroup(group);
        return students;
    }
}
