package dao;

import vo.Company;
import vo.PageInfo;

public interface CompanyDao {
	public void insert(Company company);
	public void delete(Integer[] companyIds);
	public void update(Company company);
	public void getAll(PageInfo info);
	public Company getById(int companyId);
}
