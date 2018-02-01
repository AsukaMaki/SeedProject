package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDao;
import dao.MessageDaoImpl;
import vo.*;

/**
 * Servlet implementation class MessageSend
 */
@WebServlet("/files/message.do")
public class MessageSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		
		SendMessage message=new SendMessage();
		message.setEmpID(((Employee)request.getSession().getAttribute("user")).getEmpID());
		message.setMessageTitle(request.getParameter("messageTitle"));
		message.setMessageContent(request.getParameter("messageContent"));
		message.setPriority(Integer.valueOf(request.getParameter("priority")));
		
		String[] ids=request.getParameterValues("empId");
		int[] empIds=new int[ids.length];
		for(int i=0;i<empIds.length;i++){
			empIds[i]=Integer.valueOf(ids[i]);
		}
		
		MessageDao md=new MessageDaoImpl();
		md.send(message, empIds);
		
		response.sendRedirect("sendList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
