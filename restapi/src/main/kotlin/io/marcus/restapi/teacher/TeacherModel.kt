package io.marcus.restapi.teacher


import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "teachers")
data class TeacherModel(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column(name="teacher_name")
        var teacherName: String,

        @Column(name="teacher_age")
        var teacherAge: Int,

        @Column(name="teacher_classroom")
        var teacherClassroom: MutableList<String> = mutableListOf(),

        @Column(name="teacher_qualifications")
        var teacherQualifications: MutableList<String> = mutableListOf()
        )
