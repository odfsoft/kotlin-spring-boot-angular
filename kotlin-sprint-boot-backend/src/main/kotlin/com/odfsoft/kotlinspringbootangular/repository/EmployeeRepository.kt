package com.odfsoft.kotlinspringbootangular.repository

import com.odfsoft.kotlinspringbootangular.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long>