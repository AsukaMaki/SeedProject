package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDao;
import dao.CompanyDaoImpl;

/**
 * Servlet implementation class DeleteCompany
 */
@WebServlet("/files/delete.do")
public class DeleteCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] companyIds=request.getParameterValues("delid");
		Integer[] ids=new Integer[companyIds.length];
		for(int i=0;i<ids.length;i++){
			ids[i]=Integer.valueOf(companyIds[i]);
		}
		
		CompanyDao cd=new CompanyDaoImpl();
		cd.delete(ids);
		
		request.getRequestDispatcher("companyList.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
