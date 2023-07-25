package io.marcus.restapi.school

import io.marcus.restapi.school.payload.SchoolRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api-v1/schools")
class SchoolRestApi(private val schoolService: SchoolService) {

    @PostMapping("/")
    fun createSchool(@RequestBody schoolRequest: SchoolRequest): ResponseEntity<SchoolModel>{
        return ResponseEntity.ok().body(schoolService.createSchool(schoolRequest))
    }

    @GetMapping("/")
    fun getAllSchools(): ResponseEntity<List<SchoolModel>>{
       return ResponseEntity.ok().body(schoolService.getAllSchools())
    }

    @GetMapping("/{id}")
    fun getSchoolById(@PathVariable id: Long): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.getSchoolById(id))
    }

    @PutMapping("/{id}")
    fun updateSchool(@RequestBody schoolRequest: SchoolRequest, @PathVariable id: Long): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.updateSchool(schoolRequest, id))
    }

    @DeleteMapping("/{id}")
    fun deleteSchoolById(@PathVariable id: Long): ResponseEntity<String>{
        return ResponseEntity.ok().body("School Deleted Successfully")
    }

    // Custom query endpoints
    @GetMapping("/byName/{schoolName}")
    fun findSchoolByName(@PathVariable schoolName: String): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.findSchoolByName(schoolName))
    }

    @GetMapping("/byPhoneNumber/{schoolPhoneNumber}")
    fun findSchoolByPhoneNumber(@PathVariable schoolPhoneNumber: String): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.findSchoolByPhoneNumber(schoolPhoneNumber))
    }

    @GetMapping("/byWebsite/{schoolWebsite}")
    fun findSchoolByWebsite(@PathVariable schoolWebsite: String): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.findSchoolByWebsite(schoolWebsite))
    }

    @GetMapping("/byEmail/{schoolEmail}")
    fun findSchoolByEmail(@PathVariable schoolEmail: String): ResponseEntity<SchoolModel?> {
        return ResponseEntity.ok().body(schoolService.findSchoolByEmail(schoolEmail))
    }
}