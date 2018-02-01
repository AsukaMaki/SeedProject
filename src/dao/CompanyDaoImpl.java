package dao;

import java.util.Arrays;
import java.util.List;

import com.oracle.jdbc.util.Dao;

import vo.Company;
import vo.PageInfo;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	public void insert(Company company) {
		
		String sql="INSERT INTO `tb_company` (`CompanyName`, `Linkman`, `Tel`, `Address`, `CreateDate`, `Descript`) VALUES (?, ?, ?, ?, now(), ?)";
		Dao.executeSql(sql, company.getCompanyName(),company.getLinkMan(),company.getTel(),company.getAddress(),company.getDescript());
	}

	@Override
	public void delete(Integer[] companyIds) {
		
		StringBuffer sb=new StringBuffer("(");
		for(int i=0;i<companyIds.length;i++){
			if(i!=companyIds.length-1){
				sb.append("?,");
			}else{
				sb.append("?)");
			}
		}
		String sql="delete from tb_company where CompanyID in"+sb.toString();
		Dao.executeSql(sql, companyIds);
	}

	@Override
	public void update(Company company) {
		
		String sql="update tb_company set CompanyName=?,Linkman=?,Tel=?,Address=?,Descript=? where CompanyID=?";
		Dao.executeSql(sql, company.getCompanyName(),company.getLinkMan(),company.getTel(),company.getAddress(),company.getDescript(),company.getCompanyID());
	}

	@Override
	public void getAll(PageInfo info) {
		
		Object[] obj=Dao.queryOne("select count(*) from tb_company");
		int count=((Long)obj[0]).intValue();
		info.setRecordCount(count);
		
		List<Company> list=Dao.query("select * from tb_company limit ?,?", Company.class,(info.getCurrentPage()-1)*info.getPageSize(),info.getPageSize());
		info.setList(list);
	}

	@Override
	public Company getById(int companyId) {
		
		return Dao.queryOne("select * from tb_company where CompanyID=?", Company.class, companyId);
	}

}
