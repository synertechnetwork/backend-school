package io.marcus.restapi.student

import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun createStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun getStudentById(id: Long): Student? {
        return studentRepository.findById(id).orElse(null)
    }

    fun updateStudent(id: Long, updatedStudent: Student): Student? {
        if (studentRepository.existsById(id)) {
            updatedStudent.id = id
            return studentRepository.save(updatedStudent)
        }
        return null
    }

    fun deleteStudent(id: Long) {
        studentRepository.deleteById(id)
    }

}