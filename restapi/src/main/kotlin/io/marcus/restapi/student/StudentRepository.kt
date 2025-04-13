package io.marcus.restapi.student

import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository: JpaRepository<StudentModel, Long> {

    fun findStudentByStudentName(studentName: String): StudentModel?

    fun findStudentsByStudentAge(studentAge: Int): MutableList<StudentModel>?

//    fun findStudentsByClassroomName(classroomName: String): MutableList<StudentModel>?

//    fun findStudentsByStudentSubjects(subjectName: String): MutableList<StudentModel>?

}