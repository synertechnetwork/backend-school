package io.marcus.restapi.enrollment

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api-v1/enrollments")
class EnrollmentRestApi(private val enrollmentService: EnrollmentService) {
    @PostMapping("/enroll")
    fun enrollStudentInSubject(@RequestParam studentId: Long, @RequestParam subjectId: Long): ResponseEntity<String> {
        enrollmentService.enrollStudentInSubject(studentId, subjectId)
        return ResponseEntity.status(HttpStatus.CREATED).body("Enrolled successfully")
    }
}