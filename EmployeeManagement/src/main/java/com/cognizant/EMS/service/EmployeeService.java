package com.cognizant.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cognizant.EMS.entity.Absences;
import com.cognizant.EMS.entity.Employee;
//import com.cognizant.EMS.repository.AbsencesRepository;
import com.cognizant.EMS.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private RolesRepository rolesRepository;
	
//	@Autowired
//	private AbsencesRepository absencesRepository;
	
	 public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	public Employee createEmployee(Employee employee) {
		
		employee.setTotalLeaveCount(36);
		employee.setTrainingSlot(10);
		
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployee(Long id) {
	    return employeeRepository.findById(id).orElse(null);
	            //.orElseThrow(() -> new IllegalArgumentException("Employee not found"));
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
		
		if(updatedEmployee.hasFirstName()) {
			employee.setFirstName(updatedEmployee.getFirstName());
		}
		if(updatedEmployee.hasLastName()) {
			employee.setLastName(updatedEmployee.getLastName());
		}
		if(updatedEmployee.hasAge()) {
			employee.setAge(updatedEmployee.getAge());
		}
		if(updatedEmployee.hasMobileNumber()) {
			employee.setMobileNumber(updatedEmployee.getMobileNumber());
		}
		if(updatedEmployee.hasAddress()){
			employee.setAddress(updatedEmployee.getAddress());
		}
		if(updatedEmployee.hasEmailId()) {
			employee.setEmailId(updatedEmployee.getEmailId());
		}
		if(updatedEmployee.hasJoinDate()) {
			employee.setJoinDate(updatedEmployee.getJoinDate());
		}
		
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
		employeeRepository.delete(employee);
	}
	
	
	
	public void requestTrainingSlot(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        // Check if training slot is available
        if (employee.getTrainingSlot() > 0) {
            // Request training slot logic here
            // ...
        } else {
            throw new IllegalArgumentException("No available training slots");
        }
    }

    public void requestCertificate(Long id, String certificateType) {
       employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        // Request certificate logic here
        // ...
    }

	public Employee getEmployeeByEmailId(String emailId) {
		
		return employeeRepository.findByEmailId(emailId);
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}
	

}
