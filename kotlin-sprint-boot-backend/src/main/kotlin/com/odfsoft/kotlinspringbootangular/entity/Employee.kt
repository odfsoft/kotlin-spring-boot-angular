package com.odfsoft.kotlinspringbootangular.entity

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Employee(
        @Id
        @GeneratedValue(strategy = IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val firstName: String,

        @Column(nullable = false)
        val lastName: String,

        @Column(nullable = false)
        val email: String
)