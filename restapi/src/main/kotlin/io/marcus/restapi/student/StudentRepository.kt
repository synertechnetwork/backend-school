package io.marcus.restapi.student

import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository: JpaRepository<StudentModel, Long> {

    fun findStudentByName(studentName: String): StudentModel?

    fun findStudentsByAge(studentAge: Int): MutableList<StudentModel>?

    fun findStudentsByClassroomName(classroomName: String): MutableList<StudentModel>?

    fun findStudentsBySubject(subjectName: String): MutableList<StudentModel>?

}