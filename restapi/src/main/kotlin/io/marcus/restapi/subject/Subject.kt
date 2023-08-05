package io.marcus.restapi.subject

import io.marcus.restapi.constant.Enums
import io.marcus.restapi.enrollment.Enrollment
import io.marcus.restapi.student.Student
import jakarta.persistence.*

@Entity
@Table(name = "subject")
class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name="subject_name")
    var subjectName: String? = null

    @Column(name = "subject_description")
    var subjectDescription: String? = null

    @Column(name="subject_grade")
    var studentGrade: Enums.Grade = Enums.Grade.O

    @OneToMany(mappedBy = "subject")
    var enrollments: List<Enrollment> = ArrayList()
}