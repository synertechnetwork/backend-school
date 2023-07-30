package io.marcus.restapi.subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SubjectRepository: JpaRepository<SubjectModel, Long> {

    fun findBySubjectName(subjectName: String): SubjectModel?

    @Query("SELECT s FROM SubjectModel s JOIN s.subjectTeachers t WHERE t.id = ?1")
    fun findByTeacherId(teacherId: Long): List<SubjectModel>?
}