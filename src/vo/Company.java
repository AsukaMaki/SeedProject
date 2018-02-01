package vo;

import java.util.Date;

public class Company {
	private int companyID;
	private String companyName;
	private String linkMan;
	private String tel;
	private String address;
	private Date createDate;
	private String descript;
	
	
	public Company(int companyID, String companyName, String linkMan, String tel, String address, Date createDate,
			String descript) {
		this.companyID = companyID;
		this.companyName = companyName;
		this.linkMan = linkMan;
		this.tel = tel;
		this.address = address;
		this.createDate = createDate;
		this.descript = descript;
	}
	
	public Company() {
	}
	
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
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
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
}
