package dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;

import vo.Employee;
import vo.PageInfo;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delEmployee(int[] empIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getById(int empId) {
		
		return Dao.queryOne("select * from tb_emp where empID=?", Employee.class, empId);
	}

	@Override
	public void alterEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAll(PageInfo info) {
		
		Object[] obj=Dao.queryOne("select count(*) from tb_emp");
		int count=((Long)obj[0]).intValue();
		info.setRecordCount(count);
		
		List<Employee> list=Dao.query("select * from tb_emp", Employee.class);
		info.setList(list);
	}

	@Override
	public Employee login(String userName,String password) {
		
		return Dao.queryOne("select * from tb_emp where empNo=? and password=?", Employee.class, userName,password);
	}

	@Override
	public List<Employee> getAll() {
		
		return Dao.query("select * from tb_emp", Employee.class);
	}

}
