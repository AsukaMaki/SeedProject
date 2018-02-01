package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDao;
import dao.MessageDaoImpl;

/**
 * Servlet implementation class DeleteSendMessage
 */
@WebServlet("/files/sendDelete.do")
public class DeleteSendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids=request.getParameterValues("delid");
		int[] sendIds=new int[ids.length];
		for(int i=0;i<sendIds.length;i++){
			sendIds[i]=Integer.parseInt(ids[i]);
		}
		
		MessageDao md=new MessageDaoImpl();
		md.deleteSendMessage(sendIds);
		
		request.getRequestDispatcher("sendList.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
