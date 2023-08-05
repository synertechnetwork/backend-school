package io.marcus.restapi.enrollment

import io.marcus.restapi.student.Student
import io.marcus.restapi.subject.Subject
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "enrollment")
class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "student_id")
    var student: Student? = null

    @ManyToOne
    @JoinColumn(name = "subject_id")
    var subject: Subject? = null

    @Column(name = "enrollment_date")
    var enrollmentDate: LocalDateTime? = null

    // Add any other attributes related to enrollment, such as grade, status, etc.

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    var created: LocalDateTime = LocalDateTime.now()
}