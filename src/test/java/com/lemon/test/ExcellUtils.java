package com.lemon.test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtils {
	public static void main(String[] args) {
		Object[][] datas=ExcellUtils.readExcel("src/test/resources/cases_v1.xls");
		for(Object[] data:datas){
			for(Object da:data){
				System.out.print(da+"==============");
			}
			System.out.println();
		}
		
	}
       
	public static Object[][] readExcel(String url){
		Object datas[][]=null;
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream(url);
			Workbook create = WorkbookFactory.create(fis);
			Sheet sheet = create.getSheet("用例");
			int lastRowNum = sheet.getLastRowNum();
			datas=new Object[lastRowNum][4];
			for(int i=1;i<=lastRowNum;i++){
				Row row = sheet.getRow(i);
				Cell ID = row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				ID.setCellType(CellType.STRING);
				String IDValue = ID.getStringCellValue();
				
				
				Cell URl = row.getCell(2,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				URl.setCellType(CellType.STRING);
				String URlValue = URl.getStringCellValue();
				datas[i-1][0]=URlValue;
				
				Cell Type = row.getCell(3,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Type.setCellType(CellType.STRING);
				String TypeValue = Type.getStringCellValue();
				datas[i-1][3]=TypeValue;
				
				Cell Params = row.getCell(5,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Params.setCellType(CellType.STRING);
				String ParamsValue = Params.getStringCellValue();
				datas[i-1][1]=ParamsValue;
				
				Cell Connect_type = row.getCell(6,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Connect_type.setCellType(CellType.STRING);
				String Connect_typeValue = Connect_type.getStringCellValue();
				datas[i-1][2]=Connect_typeValue;
				//System.out.println(IDValue+","+URlValue+","+TypeValue+","+ParamsValue+","+Connect_typeValue);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Close(fis);
		}
		return datas;
	}

	private static void Close(FileInputStream fis) {
		try {
			if(fis!=null){
				fis.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
