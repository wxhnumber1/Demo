package shiwuDao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

public class DemoTest {
 
	
	/*  ����>������ȷ��"ͬʱ�ɹ���ɹ����κ�һ��ʧ����ʧ��"��һ�ֻ��ơ�
	һ�����������������ֶ�����Ϊ����ʼ����Begin Transaction�����ύ����Commit���ͻع���Rollback����
	�ӿ�ʼ�����ύ�����������������һ�����ݿ��޸�Ҫôͬʱ�ɹ�����Commit���̻������ݿ��У���
	Ҫôһ��ʧ�ܣ����ͬʱ�ظ�ԭ��״̬��Rollback�����ݿ�ظ�������ʼʱ��״̬����*/
	@Test
  public void testName() throws Exception {
	  String sql1 = "UPDATE people SET xinzi = xinzi - 500 WHERE NAME = 'С��';";
	  String sql2 = "UPDATE people SET xinzi = xinzi + 500 WHERE NAME = '����';"; 
	  Connection conn = mysql.getconn();
	  Statement stat =null;
	try {
		conn.setTransactionIsolation(conn.TRANSACTION_REPEATABLE_READ);
		conn.setAutoCommit(false);  // ��������Ϊ�ֶ�
		  stat = mysql.getStat(conn);
	      stat.executeUpdate(sql1);
	      // int n = 1/0;
	      stat.executeUpdate(sql2);
	      conn.commit();           //  �ύ����
	} catch (Exception e) {
        e.printStackTrace(); //չʾ�쳣
		conn.rollback();  
	}finally{
		mysql.close(conn,stat,null);
	}
  
}
    
	@Test
	public void testName2() throws Exception {
		String sql = "select * from people";
		List<employee> lis = mysql.getEmployee(sql);
		System.out.println(lis);
		
	}
	
	
	
	
}
