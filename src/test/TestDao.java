package test;

import java.util.List;

import dao.MessageDao;
import dao.MessageDaoImpl;
import vo.PageInfo;
import vo.SendMessage;

public class TestDao {

	public static void main(String[] args) {
		MessageDao md=new MessageDaoImpl();
		SendMessage message=new SendMessage();
		PageInfo info=null;

//		message.setMessageTitle("≤‚ ‘1.1");
//		message.setMessageContent("≤‚ ‘1.1");
//		message.setEmpID(1);
//		message.setPriority(1);
//		message.setMessageState(1);
//		int[] ids={4,5};
//		
//		md.send(message, ids);
		List list=md.getSendMessage(info, 1);
		for(Object o:list){
			System.out.println(o);
		}


	}

}
