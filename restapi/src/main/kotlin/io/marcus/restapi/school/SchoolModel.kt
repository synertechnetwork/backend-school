package io.marcus.restapi.school

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


@Entity
@Table(name = "schools")
class SchoolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotBlank
    @Size(max=80, min=3, message="School name can not be less than 3 or more than 80 characters")
    @Column(name="school_name")
    var schoolName: String? = null

    @Column(name="school_address")
    var schoolAddress: String? = null

    @Column(name="school_phonenumber", unique = true)
    var schoolPhoneNumber: String? = null

    @Column(name="school_website", unique = true)
    var schoolWebsite: String? = null

    @Email(message = "Please provide a valid email")
    @Column(name = "school_email", unique = true)
    var schoolEmail: String? = null

    @Column(name = "school_logo")
    var schoolLogo: String? = null
}