package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDao;
import dao.CompanyDaoImpl;
import vo.Company;

/**
 * Servlet implementation class AddCompany
 */
@WebServlet("/files/addCompany.do")
public class AddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Company company=new Company();
		company.setCompanyName(request.getParameter("companyName"));
		company.setLinkMan(request.getParameter("linkMan"));
		company.setTel(request.getParameter("tel"));
		company.setAddress(request.getParameter("address"));
		company.setDescript(request.getParameter("descript"));
		
		CompanyDao cd=new CompanyDaoImpl();
		cd.insert(company);
		
		response.sendRedirect("../index.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
