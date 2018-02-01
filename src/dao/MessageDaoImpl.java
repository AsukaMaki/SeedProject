package dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;

import vo.PageInfo;
import vo.ReceiveMessage;
import vo.SendMessage;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void send(SendMessage message, int[] ids) {
		
		Object[] obj=Dao.queryOne("select max(sendID)+1 from to_sendmessage");
		int sendId=((Long)obj[0]).intValue();
//		int sendId=1;
		String sql1="insert into to_sendmessage values(?,?,?,?,now(),?,?);";
		Dao.executeSql(sql1, sendId,message.getEmpID(),message.getMessageTitle(),message.getMessageContent(),message.getPriority(),message.getMessageState());
		String sql2="insert into to_receivemessage values(null,?,?,1,null);";
		for(int i=0;i<ids.length;i++){
			Dao.executeSql(sql2, sendId,ids[i]);
		}

	}

	@Override
	public List<Object[]> getReceiveMessage(PageInfo info, int empID) {
		
		Object[] obj=Dao.queryOne("select count(*) from to_receivemessage where empID=?",empID);
		int count=((Long)obj[0]).intValue();
		info.setRecordCount(count);
		
		String sql="select receiveID,messageTitle,EmpName,OpenDate "
				+ "from to_receivemessage r left join to_sendmessage s "
				+ "on r.sendID=s.sendID left join tb_emp e "
				+ "on s.EmpID=e.EmpID "
				+ "where r.EmpID=? and r.messageState!=0 "
				+ "order by createDate desc";
				
		List<Object[]> list=Dao.query(sql, empID);
		
		info.setList(list);
		
		return list;
				
	}

	@Override
	public List<Object[]> getSendMessage(PageInfo info, int empID) {
		
		String sql1="select sendID,MessageTitle,CreateDate,'' empName from to_sendmessage where EmpID=? and messageState"
				+ "!=0 order by createDate desc";
		List<Object[]> list=Dao.query(sql1, empID);
		
		for(Object[] obj:list){
			String sql2="select EmpName from tb_emp where EmpID in(select EmpID from to_receivemessage where sendID=?)";
			List<Object[]> names=Dao.query(sql2, obj[0]);
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<names.size();i++){
				if(i==names.size()-1){
					sb.append(names.get(i)[0]);
				}else{
					sb.append(names.get(i)[0]).append(",");
				}
			}
			obj[3]=sb.toString();
		}
		
		info.setList(list);
		info.setRecordCount(list.size());
		
		return list;
	}

	@Override
	public Object[] getSendMessageById(int sendId) {
		
		Object[] obj=Dao.queryOne("select EmpID from to_sendmessage where sendID=?", sendId);
		String sql1="select MessageTitle,CreateDate,'' empName,messageContent from to_sendmessage where EmpID=? and messageState!=0 and sendID=?";
		Object[] o=Dao.queryOne(sql1, obj[0],sendId);
		
		String sql2="select EmpName from tb_emp where EmpID in(select EmpID from to_receivemessage where sendID=?)";
		List<Object[]> names=Dao.query(sql2, sendId);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<names.size();i++){
			if(i==names.size()-1){
				sb.append(names.get(i)[0]);
			}else{
				sb.append(names.get(i)[0]).append(",");
			}
		}
		o[2]=sb.toString();
		return o;
	}

	@Override
	public Object[] getReceiveMessageById(int receiveId) {
		
		Dao.executeSql("update to_receivemessage set messageState=2,openDate=now() where receiveID=?", receiveId);
		String sql="select messageTitle,empName,openDate,messageContent "
				+ "from to_sendmessage s,tb_emp e,to_receivemessage r "
				+ "where s.sendID=r.sendID and s.EmpID=e.EmpID "
				+ "and ReceiveID=?";
		return Dao.queryOne(sql, receiveId);
	}

	@Override
	public void deleteSendMessage(int[] sendIds) {
		
		for(int i=0;i<sendIds.length;i++){
			Dao.executeSql("update to_sendmessage set messageState=0 where sendID=?", sendIds[i]);
		}
	}

	@Override
	public void deleteReceiveMessage(int[] receiveIds) {
		
		for(int i=0;i<receiveIds.length;i++){
			Dao.executeSql("update to_receivemessage set messageState=0 where receiveID=?", receiveIds[i]);
		}
	}

}
