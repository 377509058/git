package com.lemon.cases;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.lemon.httpclient.FengZhuang;
import com.lemon.test.ExcellUtils;

public class Case_ZhuCe2 {

	@Test(dataProvider="datas")
	public void test(String url,String pramas,String content_type,String Type) {
        if("json".equalsIgnoreCase(content_type)){
        	if("post".equalsIgnoreCase(Type)){
        		FengZhuang.testPostJson(url, pramas);
        	}else if("get".equalsIgnoreCase(Type)){
        		FengZhuang.testGetJson(url, pramas);
        	}
        }else if("form".equalsIgnoreCase(content_type)){
        	String str="";
        	Map<String,String> map=JSONObject.parseObject(pramas,Map.class);
        	Set<String> keySet = map.keySet();
        	for(String key:keySet){
        		String value = map.get(key);
        		str +=key+"="+value+"&";
        		
        	}
        	str = str.substring(0, str.length()-1);
    		System.out.println(str);
        	FengZhuang.testPostForm(url, str);	
        }
	}
	
	@DataProvider(name="datas")
	public Object[][] datas(){
		Object[][] datas=ExcellUtils.readExcel("src/test/resources/cases_v1.xls");;
		return datas;
	}

}
