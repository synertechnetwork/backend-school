package io.marcus.restapi.classroom

import io.marcus.restapi.student.StudentModel
import io.marcus.restapi.subject.SubjectModel
import io.marcus.restapi.teacher.TeacherModel
import jakarta.persistence.*

@Entity
@Table(name = "classrooms")
data class ClassroomModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name="classroom_name")
    var classroomName: String,

    @Column(name="classroom_description")
    var classroomDescription: String,

    @Column(name="classroom_students")
    var classroomStudents: MutableList<StudentModel> = mutableListOf(),

    @Column(name="classroom_teachers")
    var classroomTeachers: MutableList<TeacherModel> = mutableListOf(),

    @Column(name="classroom_subjects")
    var classroomSubjects: MutableList<SubjectModel> = mutableListOf(),

//    @Column(name="classroom_seating_arrangement")
//    var seatingArrangement: MutableList<String> = mutableListOf()
)
