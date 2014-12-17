// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelWriter.java

package com.feng.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Referenced classes of package com.feng.common.excel:
//			ExcelReader, ExcelStyle, Formula, MergeRange

public class ExcelWriter
{

	private static Log log = LogFactory.getLog(com.feng.common.excel.ExcelWriter.class);
	private Workbook wb;
	private Sheet sheet;
	FileInputStream inputStream;
	private ExcelReader reader;
	private ExcelStyle style;
	String filepath;

	public ExcelWriter(String filepath)
	{
		wb = null;
		sheet = null;
		inputStream = null;
		try
		{
			this.filepath = filepath;
			File file = new File(filepath);
			if (!file.exists())
			{
				if (filepath.endsWith("xls"))
					wb = (Workbook) new HSSFWorkbook();
				else
					wb = new XSSFWorkbook();
			} else
			{
				inputStream = new FileInputStream(new File(filepath));
				if (filepath.endsWith("xls"))
					wb = (Workbook) new HSSFWorkbook(inputStream);
				else
					wb = new XSSFWorkbook(inputStream);
			}
			reader = new ExcelReader(wb);
			style = new ExcelStyle(wb);
		}
		catch (Exception e)
		{
			log.error("初始化Excel文件失败", e);
		}
	}

	public void createSheet(String sheetName)
		throws Exception
	{
		if (wb.getSheet(sheetName) != null)
		{
			log.debug("传入的Sheet已存在,不创建");
			setActiveSheet(sheetName);
		} else
		{
			sheet = wb.createSheet(sheetName);
			setActiveSheet(sheet.getSheetName());
		}
	}

	public int getSheetNum()
	{
		return wb.getNumberOfSheets();
	}

	public Sheet getSheetByName(String name)
	{
		return wb.getSheet(name);
	}

	public String[] getSheetNames()
	{
		String sheetNames[] = new String[wb.getNumberOfSheets()];
		for (int i = 0; i < wb.getNumberOfSheets(); i++)
			sheetNames[i] = wb.getSheetName(i);

		return sheetNames;
	}

	public void setActiveSheet(String name)
		throws Exception
	{
		sheet = wb.getSheet(name);
		if (sheet == null)
		{
			throw new Exception("指定的Sheet不存在!");
		} else
		{
			reader.setActiveSheet(name);
			return;
		}
	}

	public Cell writeCellComment(Object value, int rowNum, int colNum)
		throws Exception
	{
		vaildate();
		Row row = null;
		Cell cell = null;
		if (reader.getPhysicalRows() - 1 < rowNum)
			row = sheet.createRow(rowNum);
		else
			row = sheet.getRow(rowNum);
		if (reader.getUsedWidth(row) - 1 < colNum)
			cell = row.createCell(colNum);
		else
			cell = row.getCell(colNum);
		if (value == null)
			cell.setCellType(3);
		else
		if (value instanceof String)
		{
			cell.setCellValue(String.valueOf(value));
			cell.setCellType(1);
		} else
		if ((value instanceof Double) || (value instanceof Float) || (value instanceof BigDecimal))
		{
			cell.setCellValue(Double.valueOf(String.valueOf(value)).doubleValue());
			cell.setCellType(0);
		} else
		if ((value instanceof Date) || (value instanceof java.sql.Date) || (value instanceof Timestamp) || (value instanceof Time))
		{
			cell.setCellType(0);
			cell.setCellValue(java.sql.Date.valueOf(String.valueOf(value)));
		} else
		if ((value instanceof Integer) || (value instanceof Long))
		{
			cell.setCellValue(String.valueOf(value));
			cell.setCellType(0);
		} else
		if (value instanceof Boolean)
		{
			cell.setCellValue(Boolean.valueOf(String.valueOf(value)).booleanValue());
			cell.setCellType(4);
		} else
		if (value instanceof Formula)
		{
			cell.setCellFormula(((Formula)value).getValue());
			cell.setCellType(2);
		} else
		{
			cell.setCellValue(String.valueOf(value));
		}
		log.debug((new StringBuilder("根据类型 写值 行号: ")).append(rowNum).append(" 列号: ").append(colNum).append(" 值: ").append(value).append(" CellType: ").append(cell.getCellType()).append(" Sheet名称:").append(sheet.getSheetName()).toString());
		return cell;
	}

	public Cell writeCellComment(String value, int rowNum, int colNum)
		throws Exception
	{
		vaildate();
		Row row = null;
		Cell cell = null;
		if (reader.getPhysicalRows() - 1 < rowNum)
			row = sheet.createRow(rowNum);
		else
			row = sheet.getRow(rowNum);
		if (reader.getUsedWidth(row) - 1 < colNum)
			cell = row.createCell(colNum);
		else
			cell = row.getCell(colNum);
		log.debug((new StringBuilder("写值  行号:")).append(rowNum).append(" 列号:").append(colNum).append(" 值:").append(value).append(" Sheet名称:").append(sheet.getSheetName()).append("列宽:").append(reader.getUsedWidth(row)).toString());
		if (value == null)
			cell.setCellType(3);
		else
			cell.setCellValue(value);
		return cell;
	}

	public void deleteRow(int rowNum)
		throws Exception
	{
		vaildate();
		if (reader.getUsedRowNum() < rowNum)
		{
			throw new Exception("要删除的行超过当前使用行");
		} else
		{
			Row row = sheet.getRow(rowNum);
			sheet.removeRow(row);
			return;
		}
	}

	public void mergeRange(MergeRange range)
		throws Exception
	{
		if (range.getValue() != null)
			addMergeRange(range.getValue(), range.getFirstRow(), range.getLastRow(), range.getFirstColumn(), range.getLastColumn());
		else
			addMergeRange(range.getFirstRow(), range.getLastRow(), range.getFirstColumn(), range.getLastColumn());
	}

	public MergeRange addMergeRange(int firstRow, int lastRow, int firstCol, int lastCol)
		throws Exception
	{
		vaildate();
		for (int i = firstRow; i <= lastRow; i++)
			createRow(i);

		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
		MergeRange range = new MergeRange(firstRow, lastRow, firstCol, lastCol, reader.getCellComment(firstRow, firstCol));
		return range;
	}

	public MergeRange addMergeRange(String value, int firstRow, int lastRow, int firstCol, int lastCol)
		throws Exception
	{
		vaildate();
		for (int i = firstRow; i <= lastRow; i++)
			createRow(i);

		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
		Cell cell = writeCellComment(value, firstRow, firstCol);
		MergeRange range = new MergeRange(firstRow, lastRow, firstCol, lastCol, value, cell);
		return range;
	}

	public MergeRange addMergeRangeStyle(Object value, int firstRow, int lastRow, int firstCol, int lastCol, CellStyle style)
		throws Exception
	{
		vaildate();
		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
		for (int i = firstRow; i <= lastRow; i++)
		{
			Row row = createRow(i);
			for (int j = firstCol; j <= lastCol; j++)
			{
				Cell cell = row.createCell(j);
				cell.setCellStyle(style);
			}

		}

		Cell cell = writeCellComment(value, firstRow, firstCol);
		MergeRange range = new MergeRange(firstRow, lastRow, firstCol, lastCol, value.toString(), cell);
		return range;
	}

	public Row createRow(int rowNum)
		throws Exception
	{
		if (reader.getPhysicalRows() - 1 < rowNum)
			return sheet.createRow(rowNum);
		else
			return sheet.getRow(rowNum);
	}

	public int removeMergeRange(MergeRange range)
		throws Exception
	{
		return removeMergeRange(range.getFirstRow(), range.getLastRow(), range.getFirstColumn(), range.getLastColumn());
	}

	public int removeMergeRange(int firstRow, int lastRow, int firstCol, int lastCol)
		throws Exception
	{
		vaildate();
		for (int i = 0; i < sheet.getNumMergedRegions(); i++)
		{
			CellRangeAddress addr = sheet.getMergedRegion(i);
			if (addr.getFirstColumn() == firstCol && addr.getFirstRow() == firstRow && addr.getLastColumn() == lastCol && addr.getLastRow() == lastRow)
			{
				sheet.removeMergedRegion(i);
				return 1;
			}
		}

		log.error("未找到要去掉的合并单元格");
		return 0;
	}

	public void autoSizeColumn(int colNum)
	{
		sheet.autoSizeColumn(colNum);
	}

	public void autoSizeColumn(int colNum, Boolean autoSizeFlag)
	{
		sheet.autoSizeColumn(colNum, autoSizeFlag.booleanValue());
	}

	public void setColumnWidth(int colNum, int width)
	{
		sheet.setColumnWidth(colNum, width);
	}

	public void setCellStyle(int rowNum, int colNum, CellStyle style)
		throws Exception
	{
		vaildate();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		cell.setCellStyle(style);
	}

	public void writeCellCommentStyle(Object value, int rowNum, int colNum, CellStyle style)
		throws Exception
	{
		Cell cell = writeCellComment(value, rowNum, colNum);
		cell.setCellStyle(style);
	}

	public void setMergeRangeStyle(int firstRow, int lastRow, int firstCol, int lastCol, CellStyle style)
		throws Exception
	{
		for (int i = firstRow; i <= lastRow; i++)
		{
			for (int j = firstCol; j < lastCol; j++)
			{
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				cell.setCellStyle(style);
			}

		}

	}

	public void save()
		throws Exception
	{
		try
		{
			if (inputStream != null)
				inputStream.close();
			FileOutputStream os = new FileOutputStream(filepath);
			wb.write(os);
			os.flush();
			if (os != null)
				os.close();
		}
		catch (Exception e)
		{
			log.error("保存Excel失败", e);
			throw e;
		}
	}

	public void saveAs(String filepath)
		throws Exception
	{
		FileOutputStream os = null;
		try
		{
			if (inputStream != null)
				inputStream.close();
			os = new FileOutputStream(filepath);
			wb.write(os);
			os.flush();
		}
		catch (Exception e)
		{
			log.error("保存Excel失败", e);
			throw e;
		}
		 
		if (os != null)
			os.close(); 
		if (os != null)
			os.close();
		return;
	}

	public ExcelReader getReader()
		throws Exception
	{
		return reader;
	}

	public ExcelReader getReader(String sheetName)
		throws Exception
	{
		setActiveSheet(sheetName);
		reader.setActiveSheet(sheetName);
		return reader;
	}

	public ExcelStyle getStyle()
	{
		return style;
	}

	private void vaildate()
		throws Exception
	{
		if (sheet == null)
		{
			log.error("未指定当前的Sheet,请先调用setActiveSheet 设置当前使用的Sheet");
			throw new Exception("未指定当前的Sheet,请先调用setActiveSheet 设置当前使用的Sheet");
		} else
		{
			return;
		}
	}

}
