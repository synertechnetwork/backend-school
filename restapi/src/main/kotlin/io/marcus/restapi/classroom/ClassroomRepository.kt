package io.marcus.restapi.classroom

import org.springframework.data.jpa.repository.JpaRepository

interface ClassroomRepository: JpaRepository<ClassroomModel, Long> {

    fun findClassroomByName(classroomName: String): ClassroomModel?
    fun deleteClassroomById(classroomId: Long): Unit

//    fun findClassroomsByStudentName(studentName: String): MutableList<ClassroomModel>?

    // add student to classroom
    //assign teacher to classroom
    //remove student from classroom
    //remove teacher from classroom

//    fun findClassroomsByTeacherName(teacherName: String): MutableList<ClassroomModel>?

//    fun findClassroomsBySubjectName(subjectName: String): MutableList<ClassroomModel>?
}