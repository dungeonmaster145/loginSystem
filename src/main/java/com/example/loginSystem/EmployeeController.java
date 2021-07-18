package com.example.loginSystem;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> listAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping("/employees/{id")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getByID(@PathVariable Long employeeId)throws Exception{

        return employeeRepository.findById(employeeId)
                .orElseThrow(()->new Exception("Ex=mployee Not found "+employeeId));

    }
    @PutMapping("/employees/{id}")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee ,
                                             @PathVariable Long employeeId)throws Exception
    {
        return employeeRepository.findById(employeeId)
                .map(emp->{
                    emp.setName("Mayank Joshi");
                    emp.setRole("Admin");
                    return employeeRepository.save(emp);
                });

    }
    @DeleteMapping("/employees/{id")
    public void deleteEmployee(@PathVariable Long id){

         employeeRepository.deleteById(id);

    }

}
