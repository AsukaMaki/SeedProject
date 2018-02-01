package vo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	int pageCount;
	int recordCount;
	int pageSize=4;
	int currentPage=1;
	List list=new ArrayList();
	String action;
	
	
	public PageInfo(HttpServletRequest request){
		String page = request.getParameter("currentPage");
		if(page!=null){
			this.currentPage =Integer.parseInt(page);
		}
		request.setAttribute("pageInfo", this);
	}	

	
	public int getPageCount() {
		return recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;
	}

	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
