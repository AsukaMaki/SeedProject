package dao;

import java.util.List;

import vo.PageInfo;
import vo.ReceiveMessage;
import vo.SendMessage;

public interface MessageDao {
	public void send(SendMessage message,int[] ids);
	public List<Object[]> getReceiveMessage(PageInfo info,int empID);
	public List<Object[]> getSendMessage(PageInfo info,int empID);
	public Object[] getSendMessageById(int sendId);
	public Object[] getReceiveMessageById(int receiveId);
	public void deleteSendMessage(int sendIds[]);
	public void deleteReceiveMessage(int receiveIds[]);
}
