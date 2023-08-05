package io.marcus.restapi.subject

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api-v1/subjects")
class SubjectRestApi(private val subjectService: SubjectService) {

    @PostMapping
    fun createSubject(@RequestBody subject: Subject): ResponseEntity<Subject> {
        val createdSubject = subjectService.createSubject(subject)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject)
    }

    @GetMapping
    fun getAllSubjects(): ResponseEntity<List<Subject>> {
        val subjects = subjectService.getAllSubjects()
        return ResponseEntity.ok(subjects)
    }

    @GetMapping("/{id}")
    fun getSubjectById(@PathVariable id: Long): ResponseEntity<Subject> {
        val subject = subjectService.getSubjectById(id)
        return if (subject != null) {
            ResponseEntity.ok(subject)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateSubject(@PathVariable id: Long, @RequestBody updatedSubject: Subject): ResponseEntity<Subject> {
        val updated = subjectService.updateSubject(id, updatedSubject)
        return if (updated != null) {
            ResponseEntity.ok(updated)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteSubject(@PathVariable id: Long): ResponseEntity<Void> {
        subjectService.deleteSubject(id)
        return ResponseEntity.noContent().build()
    }
}