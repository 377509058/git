package com.lemon.httpclient;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtils {
        public static void main(String[] args) {
        	Object[][] datas=ExcellUtils.read("src/test/resources/cases_v1.xls");
        	for(Object[] data:datas){
        		for (Object da:data) {
					System.out.print(da+"======");
				}
        		System.out.println();
        	}
        	
		}

        public static Object[][] read(String url){
        	Object datas[][]=null;
        	FileInputStream fis=null;
        	try {
        		 fis=new FileInputStream(url);
                Workbook create = WorkbookFactory.create(fis);
                Sheet sheet = create.getSheet("用例");
                int lastRowNum = sheet.getLastRowNum();
                //Object[接口执行次数][想要的参数（列）]
                datas=new Object[lastRowNum][4];
                for (int i = 1; i <=lastRowNum; i++) {
					Row row = sheet.getRow(i);
					/*==========================caseID=======================*/
					Cell cellID = row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellID.setCellType(CellType.STRING);
					String cellIDValue = cellID.getStringCellValue();
					/*==========================cellURl=======================*/
					Cell cellURl = row.getCell(2,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellURl.setCellType(CellType.STRING);
					String cellURlValue = cellURl.getStringCellValue();
					//获取每行的url
					datas[i-1][0]=cellURlValue;
					/*==========================caseType=======================*/
					Cell caseType = row.getCell(3,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					caseType.setCellType(CellType.STRING);
					String caseTypeValue = caseType.getStringCellValue();
					datas[i-1][2]=caseTypeValue;
					/*==========================caseParams=======================*/
					Cell cellPamars = row.getCell(5,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellPamars.setCellType(CellType.STRING);
					String cellPamarsValue = cellPamars.getStringCellValue();
					datas[i-1][1]=cellPamarsValue;
					/*==========================Content_Type=======================*/
				    Cell Content_Type = row.getCell(6,MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Content_Type.setCellType(CellType.STRING);
                    String Content_TypeValue = Content_Type.getStringCellValue();
                    datas[i-1][3]=Content_TypeValue;
                   // System.out.println(cellIDValue+","+cellURlValue+","+caseTypeValue+","+cellPamarsValue+","+Content_TypeValue);
                }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}finally {
				close(fis);
			}
        	
        	return datas;
        }
		private static void close(FileInputStream fis) {
			try {
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	
}
