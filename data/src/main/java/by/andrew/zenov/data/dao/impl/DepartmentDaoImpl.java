package by.andrew.zenov.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.andrew.zenov.data.dao.DepartmentDao;
import by.andrew.zenov.data.model.Department;

@Repository(value = "departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Department, Long> implements DepartmentDao {

	public DepartmentDaoImpl() {
		setEntityClass(Department.class);
	}
}
