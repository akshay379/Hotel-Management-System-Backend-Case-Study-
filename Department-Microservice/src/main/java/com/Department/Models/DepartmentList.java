package com.Department.Models;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DepartmentList {
	
	private List<Department> alldept;

	public List<Department> getAlldept() {
		return alldept;
	}

	public void setAlldept(List<Department> alldept) {
		this.alldept = alldept;
	}

}
