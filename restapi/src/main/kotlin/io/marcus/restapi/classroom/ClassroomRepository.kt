package io.marcus.restapi.classroom

import org.springframework.data.jpa.repository.JpaRepository

interface ClassroomRepository: JpaRepository<ClassroomModel, Long> {

    fun findClassroomByName(classroomName: String): ClassroomModel?

    fun findClassroomsByStudentName(studentName: String): MutableList<ClassroomModel>?

    fun findClassroomsByTeacherName(teacherName: String): MutableList<ClassroomModel>?

    fun findClassroomsBySubjectName(subjectName: String): MutableList<ClassroomModel>?
}