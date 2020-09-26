package application.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import application.Entity.Book;


public class ExcelFileExporter {
	
	public static void contactListToExcelFile(List<Book> customers) {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Customers");
			
			Row row = sheet.createRow(0);
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        // Creating header
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Id");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Author");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(2);
	        cell.setCellValue("Price");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(3);
	        cell.setCellValue("Title");
	        cell.setCellStyle(headerCellStyle);
	        
	        // Creating data rows for each customer
	        for(int i = 0; i < customers.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(i+1);
	        	dataRow.createCell(1).setCellValue(customers.get(i).getAuthor());
	        	dataRow.createCell(2).setCellValue(customers.get(i).getPrice());
	        	dataRow.createCell(3).setCellValue(customers.get(i).getTitle());
	        }
	
	        // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        
	        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        workbook.write(outputStream);
//	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			
		}
	}
}