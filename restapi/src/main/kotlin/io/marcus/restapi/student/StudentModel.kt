package io.marcus.restapi.student

import io.marcus.restapi.classroom.ClassroomModel
import io.marcus.restapi.subject.SubjectModel
import jakarta.persistence.*

@Entity
@Table(name = "students")
data class StudentModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(name="student_name")
        var studentName: String,

        @Column(name="student_age")
        var studentAge: Int,

        @Column(name="student_classroom")
        var studentClassroom: ClassroomModel,

        @Column(name="student_subjects")
        var studentSubjects: MutableList<SubjectModel> = mutableListOf()

)
