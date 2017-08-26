package genericLibrary;

import java.io.*;
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Functions {
	
	public Map<String,String> readExcel=new HashMap<String,String>();
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream file;
	
	final static Logger mylog = Logger.getLogger("appLog");
	
	public Map ReadExcel()
	{
		try {
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			
			while(rowIterator.hasNext()) {
				String iterationNumber ="",record = "";
				Row row = rowIterator.next();
				
				if(row.getRowNum()>0)
			{
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					switch(cell.getColumnIndex())
					{
					case 0:
						iterationNumber=cell.getStringCellValue();
						break;
					default:
						if(record.trim().length()==0)
							record=cell.getStringCellValue();
						else
							record=record+"|"+cell.getStringCellValue();
						
						break;
					}
				}
				readExcel.put(iterationNumber, record);				
			}
			}
			file.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return readExcel;
	}
	
	@SuppressWarnings("deprecation")
	public Excel_Functions(String ObjWorkBook,String workSheet) throws IOException
	{
			file = new FileInputStream(new File(ObjWorkBook));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(workSheet);
	}
	
	public void writeInfoIntoExcel(String ObjWorkBook,String workSheet,String rowNum,String custId) throws IOException
	{
		try
		{
		file = new FileInputStream(new File(ObjWorkBook));
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(workSheet);
		Cell cell=sheet.getRow(Integer.parseInt(rowNum)).createCell(11);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(custId.toString());
		file.close();
		FileOutputStream out =new FileOutputStream(new File(ObjWorkBook));
		workbook.write(out);
		out.close();
		mylog.info(custId +" is updated into Excel Successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
