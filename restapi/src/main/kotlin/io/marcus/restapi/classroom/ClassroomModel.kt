package io.marcus.restapi.classroom

import io.marcus.restapi.student.StudentModel
import io.marcus.restapi.subject.SubjectModel
import io.marcus.restapi.teacher.TeacherModel
import jakarta.persistence.*

@Entity
@Table(name = "classrooms")
class ClassroomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "classroom_name")
    var name: String = ""

    @Column(name = "classroom_description")
    var classroomDescription: String = ""

    // Assuming one classroom has many students, and one student belongs to one classroom
    @OneToMany(mappedBy = "studentClassroom")
    var classroomStudents: MutableList<StudentModel> = mutableListOf()

    // Assuming a teacher can be in many classrooms and a classroom can have many teachers
    @ManyToMany
    @JoinTable(
        name = "classroom_teacher",
        joinColumns = [JoinColumn(name = "classroom_id")],
        inverseJoinColumns = [JoinColumn(name = "teacher_id")]
    )
    var classroomTeachers: MutableList<TeacherModel> = mutableListOf()

    // Assuming a subject can be in many classrooms and a classroom can have many subjects
    @ManyToMany
    @JoinTable(
        name = "classroom_subject",
        joinColumns = [JoinColumn(name = "classroom_id")],
        inverseJoinColumns = [JoinColumn(name = "subject_id")]
    )
    var classroomSubjects: MutableList<SubjectModel> = mutableListOf()

    // If you want to represent seating arrangement, it's more complex and depends on how you plan to represent it
    // @Column(name="classroom_seating_arrangement")
    // var seatingArrangement: MutableList<String> = mutableListOf()
}
