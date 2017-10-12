package shiwuDao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

public class DemoTest {
 
	
	/*  事务>事务是确保"同时成功则成功，任何一个失败则失败"的一种机制。
	一个事务往往包括三种动作行为：开始事务（Begin Transaction），提交事务（Commit）和回滚（Rollback）。
	从开始事务到提交事务过程中所发生的一切数据库修改要么同时成功（被Commit，固化在数据库中），
	要么一个失败，大家同时回复原有状态（Rollback，数据库回复到事务开始时的状态）。*/
	@Test
  public void testName() throws Exception {
	  String sql1 = "UPDATE people SET xinzi = xinzi - 500 WHERE NAME = '小红';";
	  String sql2 = "UPDATE people SET xinzi = xinzi + 500 WHERE NAME = '赵三';"; 
	  Connection conn = mysql.getconn();
	  Statement stat =null;
	try {
		conn.setTransactionIsolation(conn.TRANSACTION_REPEATABLE_READ);
		conn.setAutoCommit(false);  // 事务设置为手动
		  stat = mysql.getStat(conn);
	      stat.executeUpdate(sql1);
	      // int n = 1/0;
	      stat.executeUpdate(sql2);
	      conn.commit();           //  提交事务
	} catch (Exception e) {
        e.printStackTrace(); //展示异常
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
