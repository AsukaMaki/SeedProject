package vo;

import java.util.Date;

public class ReceiveMessage {
	private int receiveID;
	private int sendID;
	private int empID;
	private int messageState=1;//1.Î´¶Á 2.ÒÑ¶Á 0.ÒÑÉ¾³ý
	private Date openDate;
	
	
	public ReceiveMessage(int receiveID, int sendID, int empID, int messageState, Date openDate) {
		this.receiveID = receiveID;
		this.sendID = sendID;
		this.empID = empID;
		this.messageState = messageState;
		this.openDate = openDate;
	}
	
	public ReceiveMessage() {
	}
	
	
	public int getReceiveID() {
		return receiveID;
	}
	public void setReceiveID(int receiveID) {
		this.receiveID = receiveID;
	}
	
	public int getSendID() {
		return sendID;
	}
	public void setSendID(int sendID) {
		this.sendID = sendID;
	}
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	public int getMessageState() {
		return messageState;
	}
	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}
	
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
}
