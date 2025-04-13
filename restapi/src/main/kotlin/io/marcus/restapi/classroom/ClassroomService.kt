package io.marcus.restapi.classroom

import io.marcus.restapi.classroom.payload.ClassroomRequest

import org.springframework.stereotype.Service

@Service
class ClassroomService(private val classroomRepo: ClassroomRepository) {
    fun createClassroom(classroom: ClassroomRequest): ClassroomModel {
        classroom.let {
            val newClassroom = ClassroomModel().apply {
                name = it.name
                classroomDescription = it.classroomDescription
            }
            return classroomRepo.save(newClassroom)
        }
    }

    fun getAllClassrooms(): List<ClassroomModel>{
        return classroomRepo.findAll()
    }

    fun getClassroomById(id: Long): ClassroomModel? {
        return classroomRepo.findById(id).orElse(null)
    }

    fun updateClassroom(classroom: ClassroomRequest, id: Long): ClassroomModel? {
        val oldClassroom: ClassroomModel? = classroomRepo.findById(id).orElse(null)
        if(oldClassroom != null){
            with(classroom){
                when {
                    name.isNotBlank() -> oldClassroom.name = name
                    classroomDescription.isNotBlank() -> oldClassroom.classroomDescription = classroomDescription

                }
            }
            return classroomRepo.save(oldClassroom)
        }
        return null
    }

    fun deleteClassroomById(id: Long) {
        classroomRepo.deleteClassroomById(id)
    }
}