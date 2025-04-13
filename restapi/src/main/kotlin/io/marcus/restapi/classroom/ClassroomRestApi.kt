package io.marcus.restapi.classroom

import io.marcus.restapi.classroom.payload.ClassroomRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api-v1/classrooms")
class ClassroomRestApi(private val classroomService: ClassroomService) {

    @PostMapping("/create")
    fun createClassroom(@RequestBody subjectRequest: ClassroomRequest): ResponseEntity<ClassroomModel>{
        return ResponseEntity.ok().body(classroomService.createClassroom(subjectRequest))
    }

    @GetMapping("/all")
    fun getAllClassrooms(): ResponseEntity<List<ClassroomModel>>{
        return ResponseEntity.ok().body(classroomService.getAllClassrooms())
    }

    @GetMapping("/{id}")
    fun getClassroomById(@PathVariable id: Long): ResponseEntity<ClassroomModel?> {
        return ResponseEntity.ok().body(classroomService.getClassroomById(id))
    }

    @PutMapping("/{id}")
    fun updateClassroom(@RequestBody subjectRequest: ClassroomRequest, @PathVariable id: Long): ResponseEntity<ClassroomModel?> {
        return ResponseEntity.ok().body(classroomService.updateClassroom(subjectRequest, id))
    }

    @DeleteMapping("/{id}")
    fun deleteClassroomById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok().body(classroomService.deleteClassroomById(id))
    }
}
