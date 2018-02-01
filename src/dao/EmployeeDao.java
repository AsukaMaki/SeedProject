package dao;

import java.util.List;

import vo.Employee;
import vo.PageInfo;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public void delEmployee(int[] empIds);
	public Employee getById(int empId);
	public void alterEmployee(Employee employee);
	public void getAll(PageInfo info);
	
	public List<Employee> getAll();
	public Employee login(String userName,String password);
}
