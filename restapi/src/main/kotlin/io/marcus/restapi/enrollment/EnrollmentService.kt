package io.marcus.restapi.enrollment

import org.springframework.stereotype.Service

@Service
class EnrollmentService(private val enrollmentRepository: EnrollmentRepository) {

    fun enrollStudentInSubject(studentId: Long, subjectId: Long) {
        // Implement the logic to enroll a student in a subject
        // You can perform validations and other operations here
        //val enrollment = Enrollment()
        //enrollment.student = // Retrieve Student entity using studentId
        // enrollment.subject = // Retrieve Subject entity using subjectId
                // Set other attributes and save the enrollment
            // enrollmentRepository.save(enrollment)
    }

}