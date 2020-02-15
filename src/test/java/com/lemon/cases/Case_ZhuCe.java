package com.lemon.cases;


import java.util.Map;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.lemon.httpclient.ExcellUtils;
import com.lemon.httpclient.FengZhuang;

public class Case_ZhuCe {

	private static final int Map = 0;

	@Test(dataProvider="datas")
	public void test(String url,String pramas,String type,String Content_Type){
		if("json".equalsIgnoreCase(Content_Type)){
			if("post".equalsIgnoreCase(type)){
				FengZhuang.testPostJson(url, pramas);
			}else if("get".equalsIgnoreCase(type)){
				FengZhuang.testGetJson(url, pramas);
			}
			
		}else if("form".equalsIgnoreCase(Content_Type)){
			String s = jsonToform(pramas);
			FengZhuang.testPostForm(url, s);
		}
	
		System.out.println("================================================");
	}

	private String jsonToform(String pramas) {
		String s="";
		 Map<String,String> map = JSONObject.parseObject(pramas,Map.class);
		 Set<String> keySet = map.keySet();
		 for(String key:keySet){
			String value = map.get(key);
			s+=key+"="+value+"&";
			
		 }
		 //s=s.substring(0,s.length()-1);
		// System.out.print(s);
		System.out.println();
		return s;
	}
	
	@DataProvider(name="datas")
	public Object[][] datas(){
//		Object[][] datas={
//				{"http://api.lemonban.com/futureloan/member/register","{\"mobile_phone\":\"13877788811\",\"pwd\":\"\"}"},
//				{"http://api.lemonban.com/futureloan/member/register","{\"mobile_phone\":\"\",\"pwd\":\"12345678\"}"}
//		};
		Object[][] datas=ExcellUtils.read("src/test/resources/cases_v1.xls");
		return datas;
	}
	
}
