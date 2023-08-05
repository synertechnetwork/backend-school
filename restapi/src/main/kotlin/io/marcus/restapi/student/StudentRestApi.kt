package io.marcus.restapi.student

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api-v1/students")
class StudentRestApi(private val studentService: StudentService) {
    @PostMapping
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> {
        val createdStudent = studentService.createStudent(student)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent)
    }

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        val students = studentService.getAllStudents()
        return ResponseEntity.ok(students)
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            ResponseEntity.ok(student)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody updatedStudent: Student): ResponseEntity<Student> {
        val updated = studentService.updateStudent(id, updatedStudent)
        return if (updated != null) {
            ResponseEntity.ok(updated)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteStudent(id)
        return ResponseEntity.noContent().build()
    }
}