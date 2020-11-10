package com.baeldung.freemarker.controller;

import java.util.*;

import com.baeldung.freemarker.dto.ShowEmployee;
import com.baeldung.freemarker.method.LastCharMethod;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Version;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baeldung.freemarker.model.Car;
import com.baeldung.freemarker.model.Employee;
import com.baeldung.freemarker.dto.*;

@Controller
public class SpringController {

	private static List<Employee> empList = new ArrayList<>();
	private static int currentEmpId = 0;

	public static List<Employee> getEmpList() {
		return empList;
	}

	public static void setEmpList(List<Employee> empList) {
		SpringController.empList = empList;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/employee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String empInit(@ModelAttribute("model") ModelMap model) {
		empList = ShowEmployee.display();
		model.addAttribute("empList", empList);
		return "Employee";
	}

	@RequestMapping(value = "/addEmployee/{empId}", method = RequestMethod.PUT)
	public String addEmp(@PathVariable(required=true) int empId, @ModelAttribute("emp") Employee emp) {
		if (emp != null && emp.getName() != null && emp.getSalary() != 0) {
			if(currentEmpId!=0)
			{
			UpdateEmployee.update(currentEmpId,emp);
			currentEmpId=0;
			}
			else
				AddEmployee.add(emp);
		}
		return "redirect:/employee";
	}

	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.DELETE)//.GET se v ho jata hai 
	public @ResponseBody String delete(@PathVariable(value = "empId") int empId) {
		//System.out.println(empId);
		DeleteEmployee.delete(empId);
		return "redirect:/employee";
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.GET)
	public @ResponseBody String empID(@PathVariable(value = "empId") int empId) {
		currentEmpId = empId;
		return "redirect:/employee";
	}
}