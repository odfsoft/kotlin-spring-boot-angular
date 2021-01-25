package com.odfsoft.kotlinspringbootangular.service

import com.odfsoft.kotlinspringbootangular.entity.Employee
import com.odfsoft.kotlinspringbootangular.exception.EmployeeNotFoundException
import com.odfsoft.kotlinspringbootangular.repository.EmployeeRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EmployeeService(val employeeRepository: EmployeeRepository) {

    fun getEmployee(id: Long) : Employee =
            employeeRepository.findById(id)
                .orElseThrow { EmployeeNotFoundException("employee was not found  for the id: $id") }

    fun saveEmployee(employee: Employee) : Employee = employeeRepository.save(employee)

    fun listEmployees() : List<Employee> = employeeRepository.findAll()

    fun deleteEmployee(id: Long) =
        employeeRepository.findById(id)
                .orElseThrow { EmployeeNotFoundException("employee was not found  for the id: $id") }
                .let { employeeRepository.delete(it) }

    @Transactional
    fun updateEmployee(employee: Employee) : Employee =
        employeeRepository.findById(employee.id)
                .orElseThrow { EmployeeNotFoundException("employee was not found  for the id: $employee.id") }
                .also { employeeRepository.save(employee) }
}