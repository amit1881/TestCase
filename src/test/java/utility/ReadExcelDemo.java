package utility;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo
{
	/*
	public static void main(String[] args) throws Exception
    {
		//ReadExcelDemo xcel=new ReadExcelDemo();
		ReadExcelDemo.getTableArray("C://Users//amit//Downloads//Messages.xlsx","Sheet1");
    }
    */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		   String[][] tabArray = null;
		   
        try
        {
        	
        	FileInputStream file = new FileInputStream(FilePath);
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(SheetName);
 
            int totalRows = sheet.getLastRowNum()+1;
            int totalCols=1;
            tabArray=new String[totalRows][totalCols];
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int i=0,j=0;
            while (rowIterator.hasNext())
            {
            	if(i==0)
            	{
            		Row row = rowIterator.next();
            	}
            	
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    /*
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            tabArray[i][j]=cell.getStringCellValue();
                            break;
                    }
                    */
                    
                    tabArray[i++][j]=cell.getStringCellValue();
                    System.out.println(cell.getStringCellValue());
                   
                }
                if(i==totalRows)
                	break;
                //System.out.println("");
            }
            file.close();
            //return(tabArray);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return tabArray;
    }
}
