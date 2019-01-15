/**
 * 数据库连接管理类
 */
package com.neusoft.system.db;

//连接对象
import java.sql.Connection;
//预编译语句对象
import java.sql.PreparedStatement;
//结果集对象
import java.sql.ResultSet;
//驱动管理器
import java.sql.DriverManager;
//资源文件解析器
import java.util.ResourceBundle;



public class DBUtils 
{
	private DBUtils() {}

	//描述在mysql驱动jar包中,核心类是哪个,其完整路径是什么样的----驱动串
	private static String driver=null;
	//描述数据库所在的位置,数据库的名称--- 连接串
	private static String url=null;
	//用户名
	private static String userName=null;
	//密码
	private static String password=null;

    /**
     * 静态块:
     *  静态块中的代码,在类被第一次加载如内存时候,执行一次,以后不执行
     */
	static
	{
		try 
		{
			//获取资源文件解析器对象
			ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
			//通过解析器对象,从资源文件,获取相关信息
			driver=bundle.getString("DRIVER");
			url=bundle.getString("URL");
			userName=bundle.getString("USERNAME");
			password=bundle.getString("PASSWORD");
			
			//加载驱动    --- new com.mysql.jdbc.Driver()
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()throws Exception
	{
		//创建连接---通过驱动管理器,创建到目标数据库的连接对象
		Connection conn=DriverManager.getConnection(url, userName, password);
		//返回连接
		return conn;
	} 
	
	
	public static void close(PreparedStatement pstm)
	{
		try
		{
			if(pstm!=null)   //规避NPE
			{
				pstm.close();	
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void close(Connection conn)
	{
		try
		{
			if(conn!=null)
			{
				conn.close();	
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();	
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
