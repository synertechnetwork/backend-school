package io.marcus.restapi.teacher

import io.marcus.restapi.classroom.ClassroomModel
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "teachers")
data class TeacherModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="teacher_id")
        var id: Long = 0,

        @Column(name="teacher_name")
        var teacherName: String,

        @Column(name="teacher_age")
        var teacherAge: Int,

        // Assuming a teacher can be in many classrooms and a classroom can have many teachers
        @ManyToMany(mappedBy = "classroomTeachers")
        var teacherClassrooms: MutableList<ClassroomModel> = mutableListOf(),

        @ElementCollection
        @CollectionTable(name = "teacher_qualifications", joinColumns = [JoinColumn(name = "teacher_id")])
        @Column(name = "qualification")
        var teacherQualifications: MutableList<String> = mutableListOf()
)
