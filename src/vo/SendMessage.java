package vo;

import java.util.Date;

public class SendMessage {
	private int sendID;
	private int empID;
	private String messageTitle;
	private String messageContent;
	private Date createDate;
	private int priority;
	private int messageState=1;//1.ÒÑ·¢ËÍ 0.ÒÑÉ¾³ý
	
	
	public SendMessage(int sendID, int empID, String messageTitle, String messageContent, Date createDate, int priority,
			int messageState) {
		this.sendID = sendID;
		this.empID = empID;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.createDate = createDate;
		this.priority = priority;
		this.messageState = messageState;
	}
	
	public SendMessage() {
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
	
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getMessageState() {
		return messageState;
	}
	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}
	
}
