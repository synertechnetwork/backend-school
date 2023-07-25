package io.marcus.restapi.school

import io.marcus.restapi.school.payload.SchoolRequest
import org.springframework.stereotype.Service

@Service
class SchoolService(private val schoolRepo: SchoolRepository) {

    fun createSchool(school: SchoolRequest): SchoolModel{
        school.let {
            val newSchool = SchoolModel().apply {
                schoolName = it.schoolName
                schoolAddress = it.schoolAddress
                schoolEmail = it.schoolEmail
                schoolWebsite = it.schoolWebsite
                schoolPhoneNumber = it.schoolPhoneNumber
                schoolLogo = it.schoolLogo
            }
            return schoolRepo.save(newSchool)
        }
    }

    fun getAllSchools(): List<SchoolModel>{
        return schoolRepo.findAll()
    }

    fun getSchoolById(id: Long): SchoolModel? {
        return schoolRepo.findById(id).orElse(null)
    }

    fun updateSchool(school: SchoolRequest, id: Long): SchoolModel? {
        val oldSchool: SchoolModel? = schoolRepo.findById(id).orElse(null)
        if(oldSchool != null){
            with(school){
                when {
                    schoolName.isNotBlank() -> oldSchool.schoolName = schoolName
                    schoolAddress.isNotBlank() -> oldSchool.schoolAddress = schoolAddress
                    schoolPhoneNumber.isNotBlank() -> oldSchool.schoolPhoneNumber= schoolPhoneNumber
                    schoolWebsite.isNotBlank() -> oldSchool.schoolWebsite= schoolWebsite
                    schoolEmail.isNotBlank() -> oldSchool.schoolEmail= schoolEmail
                    schoolLogo.isNotBlank() -> oldSchool.schoolLogo= schoolLogo
                }
            }
            return schoolRepo.save(oldSchool)
        }
        return null
    }

    fun deleteSchoolById(id: Long){
        schoolRepo.deleteById(id)
    }

//    Custom query functions
    fun findSchoolByName(schoolName: String): SchoolModel? {
        return schoolRepo.findBySchoolName(schoolName)
    }

    fun findSchoolByPhoneNumber(schoolPhoneNumber: String): SchoolModel? {
        return schoolRepo.findBySchoolPhoneNumber(schoolPhoneNumber)
    }

    fun findSchoolByWebsite(schoolWebsite: String): SchoolModel? {
        return schoolRepo.findBySchoolWebsite(schoolWebsite)
    }

    fun findSchoolByEmail(schoolEmail: String): SchoolModel? {
        return schoolRepo.findBySchoolEmail(schoolEmail)
    }
}