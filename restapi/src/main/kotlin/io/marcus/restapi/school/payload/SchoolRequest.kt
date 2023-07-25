package io.marcus.restapi.school.payload

data class SchoolRequest(
    var schoolName: String = "",
    var schoolAddress: String = "",
    var schoolPhoneNumber: String = "",
    var schoolWebsite: String = "",
    var schoolEmail: String = "",
    var schoolLogo: String = ""
)
