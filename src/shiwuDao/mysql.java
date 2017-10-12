package shiwuDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;



public class mysql {

	private static String url = "jdbc:mysql://localhost:3306/helloword?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "root";
	
	//�����������һ�� �����ݿ�����ֻ�����һ�Σ���>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ��װ Connection(���ݿ����Ӷ���)��>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static Connection getconn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
				
	}
	//��װ Statement(������).>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static Statement getStat(Connection conn){
		Statement stat = null;
		try {
			 stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stat;
	}
	//��װ executeUpdate(ִ�����)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static int update (Statement stat,String sql){
		int n =0;
		try {
			 n = stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	};
	// ��װ��������������޸ģ�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..
	public static void ceshi(int n){
		if(n>0){
			   System.out.println("�ɹ�");
		   }else{
			   System.out.println("ʧ��");
		   }
	}
	
	// ��װ close(�رգ���ʡ��Դ)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		public static void close(Connection conn,Statement stat,ResultSet res){
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	public static List<employee> getEmployee(String sql){
		List<employee> list = new ArrayList<employee>(); 
			Connection conn = mysql.getconn();
			Statement stat = mysql.getStat(conn);
			ResultSet rs = null;
			try {
				rs = stat.executeQuery(sql);		    
			    while(rs.next()){
			    	employee emp = new employee();
			    	emp.setAddress(rs.getString("address"));
			    	emp.setAge(rs.getInt("id"));
			    	emp.setName(rs.getString("name"));
			    	emp.setPassword(rs.getInt("password"));
			    	emp.setXinzi(rs.getDouble("xinzi"));
			    	list.add(emp);
			    }
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(conn,stat,rs);
			}
			return list;
		}	
		
		
		
		
}
