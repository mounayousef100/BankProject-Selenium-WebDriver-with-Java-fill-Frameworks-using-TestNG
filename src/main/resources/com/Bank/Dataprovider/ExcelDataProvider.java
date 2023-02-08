package com.Bank.Dataprovider;
import org.testng.annotations.DataProvider;
import com.Bank.Utility.ExcelUtils;



public class ExcelDataProvider {
//	ExcelUtils eat = null ;
	
	/*@DataProvider(name = "useData")
	public Object[][] userFromData( ) throws Exception{
		String xlFilePath = " ";
		String sheetName = " ";
		Object[][] data = testData(xlFilePath,sheetName);
		return data ;
	}*/
	
/*	@DataProvider(name = "useData")
	public Object[] [] testData(String xlFilePath , String sheetName ) throws Exception{
		Object [] [] excelData = null ;
		eat = new   ExcelUtils (xlFilePath);
		int rows= eat.getRowCount(sheetName);
		int colums = eat.getColumnCount(sheetName);
		 
		excelData = new Object[rows-1][colums];
		  for(int i = 1;i<rows;i++) {
		
			for(int j = 0; j<colums; j++)
			{
				excelData[i-1][j]= eat.getCellData(sheetName, j, i);
				
			}
			
		}
		return excelData 
	}*/
	
	
	ExcelUtils obj = new ExcelUtils();
	
	@DataProvider(name = "LoginPage")
	public Object[][] LoginPage() {
		int rows = obj.getRowCount("LoginPage");
		int column = obj.getColumnCount("LoginPage");
		int actRows = rows - 1;
		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("LoginPage", j, i + 2);
			}
		}
		return data;
	}
	
	
}
