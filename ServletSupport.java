package com.neusoft.web.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletSupport extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		this.doGet(req, resp);
	}
	
	/**
	 * 创建DTO
	 * @param request
	 * @return
	 */
	protected final Map<String,Object>  createDto(HttpServletRequest request)
	{
	    //获取页面数据,形成Map
		Map<String,String[]> tem=request.getParameterMap();
		//计算tem中,键值对的个数
		int count=tem.size();
		//计算安全的初始容量
		int initSize=((int)(count/0.75))+1;
		
		//导出所有键值对,形成集合
		Set<Entry<String,String[]>> entrySet=tem.entrySet();
		//创建DTO对象
		Map<String,Object> dto=new HashMap<>(initSize);
		//定义变量,表示tem的value部分
		String[] val=null;
		//循环集合,获取每个Entry对象
		for(Entry<String,String[]> entry:entrySet)
		{
			//获取entry对象的value部分,形成数组
			val=entry.getValue();
			//依据数组长度判断页面控件类型
			if(val.length==1)  //非checkbox
			{
				//还原数据为页面录入状态
				dto.put(entry.getKey(), val[0]);
			}
			else     //checkbox
			{
				//以数组方式,装载页面的checkbox的数据
				dto.put(entry.getKey(), val);
			}	
		}
		return dto;
	}

}
