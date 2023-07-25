package io.marcus.restapi.school

import org.springframework.data.jpa.repository.JpaRepository

interface SchoolRepository: JpaRepository<SchoolModel, Long> {


    fun findBySchoolAddress(addrss: String?): SchoolModel?

    fun findBySchoolName(schoolName: String): SchoolModel?

    // To find a school by its phone number:
    fun findBySchoolPhoneNumber(schoolPhoneNumber: String): SchoolModel?

    // To find a school by its website:
    fun findBySchoolWebsite(schoolWebsite: String): SchoolModel?

    // To find a school by its email:
    fun findBySchoolEmail(schoolEmail: String): SchoolModel?
}