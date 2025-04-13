package io.marcus.restapi.teacher.payload

data class TeacherRequest(
    var teacherName: String,
    var teacherAge: Int,
    var teacherClassrooms: MutableList<Long>,
    var teacherQualifications: MutableList<String>
)
