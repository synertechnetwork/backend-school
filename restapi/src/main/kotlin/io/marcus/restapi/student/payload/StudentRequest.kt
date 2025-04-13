package io.marcus.restapi.classroom.payload

import io.marcus.restapi.classroom.ClassroomModel
import io.marcus.restapi.student.StudentModel
import io.marcus.restapi.subject.SubjectModel
import io.marcus.restapi.teacher.TeacherModel

data class StudentRequest(
    var studentName: String,
    var studentAge: Int,
    var studentClassroom: Long?,
)
