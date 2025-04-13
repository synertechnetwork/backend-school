package io.marcus.restapi.subject.payload

data class SubjectRequest(
    var subjectName: String,
    var subjectDescription: Int,
    var subjectTeachers: MutableList<Long>,
)
