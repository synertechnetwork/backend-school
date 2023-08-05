package io.marcus.restapi.subject

import org.springframework.stereotype.Service

@Service
class SubjectService(private val subjectRepository: SubjectRepository) {

    fun createSubject(subject: Subject): Subject {
        return subjectRepository.save(subject)
    }

    fun getAllSubjects(): List<Subject> {
        return subjectRepository.findAll()
    }

    fun getSubjectById(id: Long): Subject? {
        return subjectRepository.findById(id).orElse(null)
    }

    fun updateSubject(id: Long, updatedSubject: Subject): Subject? {
        if (subjectRepository.existsById(id)) {
            updatedSubject.id = id
            return subjectRepository.save(updatedSubject)
        }
        return null
    }

    fun deleteSubject(id: Long) {
        subjectRepository.deleteById(id)
    }
}