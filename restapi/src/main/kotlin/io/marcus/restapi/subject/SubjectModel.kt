package io.marcus.restapi.subject

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

import io.marcus.restapi.teacher.TeacherModel
@Entity
@Table(name = "subjects")
data class SubjectModel (

    @Id
    @Column(name="subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @NotBlank
    @Size(max=80, min=5, message="Subject name can not be less than 5 or more than 80 characters")
    @Column(name="subject_name", unique = true)
    var subjectName: String? = null,

    @NotBlank
    @Column(name="subject_description")
    var subjectDescription: String,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "subject_teacher", joinColumns = [JoinColumn(name = "subject_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "teacher_id", referencedColumnName = "id")])
    var subjectTeachers: MutableList<TeacherModel> = mutableListOf()

    //each subject could contain its curriculum, for all applicable levels

)