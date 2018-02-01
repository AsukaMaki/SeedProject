package vo;

import java.util.Date;

public class Employee {
	 int empID;
	private int roleID;
	private int dutyID;
	private String empNo;
	private String password;
	 String empName;
	private String sex;
	private Date birth;
	private String idCard;
	private String email;
	private String tel;
	private String address;
	private String empType;
	private String bankName;
	private String bankNo;
	private int sal;
	private int comm;
	private int subsidy;
	private Date hiredate;
	private String descript;
	
	
	public Employee(int empID, int roleID, int dutyID, String empNo, String password, String empName, String sex,
			Date birth, String idCard, String email, String tel, String address, String empType, String bankName,
			String bankNo, int sal, int comm, int subsidy, Date hiredate, String descript) {
		this.empID = empID;
		this.roleID = roleID;
		this.dutyID = dutyID;
		this.empNo = empNo;
		this.password = password;
		this.empName = empName;
		this.sex = sex;
		this.birth = birth;
		this.idCard = idCard;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.empType = empType;
		this.bankName = bankName;
		this.bankNo = bankNo;
		this.sal = sal;
		this.comm = comm;
		this.subsidy = subsidy;
		this.hiredate = hiredate;
		this.descript = descript;
	}
	
	public Employee() {
	}
	
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	public int getDutyID() {
		return dutyID;
	}
	public void setDutyID(int dutyID) {
		this.dutyID = dutyID;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	
	public int getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(int subsidy) {
		this.subsidy = subsidy;
	}
	
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
}
