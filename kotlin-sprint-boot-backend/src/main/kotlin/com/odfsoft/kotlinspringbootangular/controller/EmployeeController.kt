package com.odfsoft.kotlinspringbootangular.controller

import com.odfsoft.kotlinspringbootangular.entity.Employee
import com.odfsoft.kotlinspringbootangular.service.EmployeeService
import com.odfsoft.kotlinspringbootangular.utils.Constant.EMPLOYEE_API_PATH
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(EMPLOYEE_API_PATH)
class EmployeeController(val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployees() : List<Employee> = employeeService.listEmployees()

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Long) : Employee = employeeService.getEmployee(id)

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long) = employeeService.deleteEmployee(id)

    @PostMapping
    fun saveEmployee(@RequestBody employee: Employee) = employeeService.saveEmployee(employee)

    @PutMapping
    fun updateEmployee(@RequestBody employee: Employee) = employeeService.updateEmployee(employee)

}