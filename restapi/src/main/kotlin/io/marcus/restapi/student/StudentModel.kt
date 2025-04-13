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

        @ManyToOne  // or @OneToOne depending on the relation
        @JoinColumn(name="classroom_id")  // referencing the foreign key column in the students table
        var studentClassroom: ClassroomModel,

//        @ManyToMany
//        @JoinTable(
//                name = "student_subject",
//                joinColumns = [JoinColumn(name = "student_id")],
//                inverseJoinColumns = [JoinColumn(name = "subject_id")]
//        )
//        var studentSubjects: MutableList<SubjectModel> = mutableListOf()

)