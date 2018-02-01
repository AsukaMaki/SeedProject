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
 * Servlet implementation class DeleteReceiveMessage
 */
@WebServlet("/files/receiveDelete.do")
public class DeleteReceiveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReceiveMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids=request.getParameterValues("delid");
		int[] receiveIds=new int[ids.length];
		for(int i=0;i<receiveIds.length;i++){
			receiveIds[i]=Integer.parseInt(ids[i]);
		}
		
		MessageDao md=new MessageDaoImpl();
		md.deleteReceiveMessage(receiveIds);
		
		request.getRequestDispatcher("receiveList.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
