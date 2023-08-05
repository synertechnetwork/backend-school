package io.marcus.restapi.student

import io.marcus.restapi.constant.Enums
import io.marcus.restapi.enrollment.Enrollment
import io.marcus.restapi.subject.Subject
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name="student")
class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotBlank
    @Size(max=50, min=3, message="Student name can not be less than 3 or more than 50 characters")
    @Column(name="student_name")
    var studentName: String? = null

    @Column(name="student_address")
    var studentAddress: String? = null

    @Column(name="student_phone_num")
    var studentPhoneNumber: String? = null

    @Email(message = "Please provide a valid email")
    @Column(name = "student_email", unique = true)
    var studentEmail: String? = null

    @Column(name="student_gender")
    @Enumerated(EnumType.STRING)
    var studentGender: Enums.Gender = Enums.Gender.NONE

    @Column(name = "student_dob")
    var studentDob: LocalDateTime? = null

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    var created: LocalDateTime = LocalDateTime.now()

    @OneToMany(mappedBy = "student")
    var enrollments: List<Enrollment> = ArrayList()

}