package entity;
/*
通过数据库导入参赛人员的基本信息
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.mysql.cj.protocol.Resultset;

public class PlayerSelect {
	static HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
	private static PlayerSelect instance = null;
	private PlayerSelect() {
		
	}
	public static PlayerSelect getInstance() {
		if(instance == null)
			instance = new PlayerSelect();
		return instance;
		
	}
	
	 static  {
		String Driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/baolin?useSSL=false&serverTimezone=UTC";
		String user="root";
		String password="123456";
		Connection c =null;
		        try{
		            Class.forName(Driver);
		            c = DriverManager.getConnection(url,user,password);		           
		            Statement s = c.createStatement();
		            String sql = "select * from information";
		            //执行查询语句，并且把结果返回到ResultSet
		            Resultset rs = (Resultset) s.executeQuery(sql);
		            while(((ResultSet) rs).next()) {
		            	int id = ((ResultSet) rs).getInt(1);
		            	String name =((ResultSet)rs).getString(2);
		            	dictionary.put(id, name);
		            }
		            } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		            } catch (SQLException e) {
		            e.printStackTrace();
		            }finally {
		            if( c!=null){
		                try {
		                    c.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		         }
			}

}
