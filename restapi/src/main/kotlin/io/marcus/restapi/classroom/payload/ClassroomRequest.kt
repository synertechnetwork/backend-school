package io.marcus.restapi.classroom.payload

import io.marcus.restapi.student.StudentModel
import io.marcus.restapi.subject.SubjectModel
import io.marcus.restapi.teacher.TeacherModel

data class ClassroomRequest(
    var name: String,
    var classroomDescription: String,
    var classroomStudents: MutableList<Long>? = mutableListOf(),
    var classroomTeachers: MutableList<Long>? = mutableListOf(),
    var classroomSubjects: MutableList<Long>? = mutableListOf()
//    var seatingArrangement: MutableList<String> = mutableListOf()
)
