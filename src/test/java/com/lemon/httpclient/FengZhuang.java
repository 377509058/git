package com.lemon.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FengZhuang {
	public static void main(String[] args) {

		String urlpostForm1="http://test.lemonban.com/futureloan/mvc/api/member/register";
		String pramaspostForm1="mobilephone=13876788811&pwd=12345678";
	    FengZhuang.testPostForm(urlpostForm1, pramaspostForm1);
	}

	public static void testGetJson(String url,String params){
		try {
			//1.发送get请求,包含method和url
			HttpGet get=new HttpGet(url);
			//1.1填写请求头
			get.addHeader("X-Lemonban-Media-Type","lemonban.v1");
			//2.创建发送请求的客户端
			CloseableHttpClient createDefault = HttpClients.createDefault();
			//3.客户端调用发送get请求，立即返回http响应
			CloseableHttpResponse execute = createDefault.execute(get);
			//4.获取数据
			//4.1获取响应头
			Header[] allHeaders = execute.getAllHeaders();
			//4.2获取状态码
			int statusCode = execute.getStatusLine().getStatusCode();
			//4.3获取响应体
			HttpEntity entity = execute.getEntity();
			//4.4格式化响应体
			String body = EntityUtils.toString(entity);
			//5.输出响应
			for(Header he:allHeaders){
				System.out.print("Header:"+he);
			}
			System.out.println();
			System.out.println("code:"+statusCode);
			System.out.println("body:"+body);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void testPostJson(String url,String pramas){
		try {
			//1.发送post请求,包含method和url
			HttpPost post=new HttpPost(url);
			//1.1填写请求头
			post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
			post.addHeader("Content-Type", "application/json");
			//1.2填写请求体（传参）
			StringEntity requestentity=new StringEntity(pramas);
			post.setEntity(requestentity);
			//2.创建发送请求的客户端
			CloseableHttpClient createDefault = HttpClients.createDefault();
			//3.客户端调用发送get请求，立即返回http响应
			CloseableHttpResponse execute = createDefault.execute(post);
			//4.获取数据
			//4.1获取响应头
			Header[] allHeaders = execute.getAllHeaders();
			//4.2获取状态码
			int statusCode = execute.getStatusLine().getStatusCode();
			//4.3获取响应体
			HttpEntity entity = execute.getEntity();
			//4.4格式化响应体
			String body = EntityUtils.toString(entity);
			//5.输出响应
			for(Header he:allHeaders){
				System.out.print("Header:"+he);
			}
			System.out.println();
			System.out.println("code:"+statusCode);
			System.out.println("body:"+body);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void testPostForm(String url,String pramas){
		try {
			//1.发送post请求,包含method和url
			HttpPost post=new HttpPost(url);
			//1.1填写请求头
			post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
			post.addHeader("Content-Type", "application/x-www-form-urlencoded");
			//1.2填写请求体（传参）
			StringEntity requestentity=new StringEntity(pramas);
			post.setEntity(requestentity);
			//2.创建发送请求的客户端
			CloseableHttpClient createDefault = HttpClients.createDefault();
			//3.客户端调用发送get请求，立即返回http响应
			CloseableHttpResponse execute = createDefault.execute(post);
			//4.获取数据
			//4.1获取响应头
			Header[] allHeaders = execute.getAllHeaders();
			//4.2获取状态码
			int statusCode = execute.getStatusLine().getStatusCode();
			//4.3获取响应体
			HttpEntity entity = execute.getEntity();
			//4.4格式化响应体
			String body = EntityUtils.toString(entity);
			//5.输出响应
			for(Header he:allHeaders){
				System.out.print("Header:"+he);
			}
			System.out.println();
			System.out.println("code:"+statusCode);
			System.out.println("body:"+body);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
