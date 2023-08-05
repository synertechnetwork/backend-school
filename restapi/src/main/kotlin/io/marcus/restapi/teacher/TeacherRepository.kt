package io.marcus.restapi.teacher

import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository: JpaRepository<TeacherModel, Long>  {

    fun findByName(teacherName: String): TeacherModel?

    fun findByClassroomName(classroomName: String): MutableList<TeacherModel>?

}