package com.hlv.view;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.hlv.utils.Utils;
 
 
public class Excel2003 extends AbstractExcelPOIView {
 
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Object[]> lstOb = (List<Object[]>) model.get("listOject");
 
		Sheet sheet = workbook.createSheet("2003");
		Row row = null;
		int rows = 0;
		int columns = 0;
 
		// Style for header cell
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
 
		// Create header cells
		row = sheet.createRow(rows++);
		
		//get header
		Object[] headersTemp = lstOb.get(0);
		columns = headersTemp.length;
		for (int i = 0; i < headersTemp.length; i++) {
			Cell cell = row.createCell(i);
    		cell.setCellStyle(style);
    		cell.setCellValue(headersTemp[i].toString());
        }
		//remove header
		lstOb.remove(0);
  
		// Create data cell
		for (Object[] _ob : lstOb) {
			row = sheet.createRow(rows++);
			for (int col = 0; col < columns; col++)
			{				
				//row.createCell(i+1).setCellValue(room.getId());
				Cell cell = row.createCell(col);
				if (_ob[col] == null) {
	               cell.setCellValue("");
	            } else {
	               String typeClass = _ob[col].getClass().getName();
	               if (typeClass.equals("java.sql.Timestamp")) {
	                  cell.setCellValue(Utils.convertTimestampToString((Timestamp) _ob[col]));
	               } else if (typeClass.equals("java.math.BigDecimal")) {
	                  cell.setCellValue(Double.valueOf(_ob[col].toString()));
	               } else {
	                  //cell.setCellValue(_ob[col] == null ? "" : _ob[col].toString());
	                  cell.setCellValue(_ob[col].toString());
	               }
	            }
				
			}
 
		}
		//resize auto
		for (int i = 0; i < columns; i++)
			sheet.autoSizeColumn(i, true);
 
	}
 
	@Override
	protected Workbook createWorkbook() {
		// TODO Auto-generated method stub
		// 2003
		return new HSSFWorkbook();
	}
}