// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelReader.java

package com.feng.common.excel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Referenced classes of package com.feng.common.excel:
//			MergeRange

public class ExcelReader
{

	private static Log log = LogFactory.getLog(com.feng.common.excel.ExcelReader.class);
	private Workbook wb;
	private Sheet sheet;
	private int usedRowNum;
	FileInputStream inputStream;

	public ExcelReader(Workbook wb)
	{
		this.wb = null;
		sheet = null;
		inputStream = null;
		this.wb = wb;
	}

	public ExcelReader(String filepath)
	{
		wb = null;
		sheet = null;
		inputStream = null;
		try
		{
			inputStream = new FileInputStream(new File(filepath));
			if (filepath.endsWith("xls"))
				wb = (Workbook) new HSSFWorkbook(inputStream);
			else
				wb = new XSSFWorkbook(inputStream);
		}
		catch (Exception e)
		{
			log.error("加载excel失败", e);
		}
	}

	public ExcelReader(File file)
	{
		wb = null;
		sheet = null;
		inputStream = null;
		try
		{
			inputStream = new FileInputStream(file);
			if (file.getName().endsWith("xls"))
				wb = (Workbook)new HSSFWorkbook(inputStream);
			else
				wb = new XSSFWorkbook(inputStream);
		}
		catch (Exception e)
		{
			log.error("加载excel失败", e);
		}
	}

	public int getSheetNum()
	{
		return wb.getNumberOfSheets();
	}

	public String[] getSheetNames()
	{
		String sheetNames[] = new String[wb.getNumberOfSheets()];
		for (int i = 0; i < wb.getNumberOfSheets(); i++)
			sheetNames[i] = wb.getSheetName(i);

		return sheetNames;
	}

	public Sheet getSheetByName(String name)
	{
		return wb.getSheet(name);
	}

	public Sheet getSheetByIndex(int index)
	{
		return wb.getSheetAt(index);
	}

	public void setActiveSheet(String name)
		throws Exception
	{
		sheet = wb.getSheet(name);
		if (sheet == null)
			throw new Exception("指定的Sheet不存在!");
		else
			return;
	}

	public void setActiveSheet(int index)
		throws Exception
	{
		sheet = wb.getSheetAt(index);
		if (sheet == null)
			throw new Exception("指定的Sheet不存在!");
		else
			return;
	}

	public int getUsedRowNum()
		throws Exception
	{
		vaildate();
		return sheet.getLastRowNum();
	}

	public int getUsedRowNum(String sheetName)
		throws Exception
	{
		if (sheetName == null)
			throw new Exception("输入参数不正确!");
		Sheet sheet = getSheetByName(sheetName);
		if (sheet == null)
			throw new Exception("指定的Sheet不存在!");
		else
			return sheet.getLastRowNum();
	}

	public int getUsedWidthByRowid(int rowNum)
		throws Exception
	{
		vaildate();
		if (rowNum > usedRowNum)
		{
			throw new Exception("行数大于当前Sheet最大行数!");
		} else
		{
			Row rows = sheet.getRow(rowNum);
			return getUsedWidth(rows);
		}
	}

	public int getUsedWidth(Row row)
	{
		return row.getPhysicalNumberOfCells();
	}

	public String getMergedRegionValue(Sheet sheet, int row, int column)
	{
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++)
		{
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn)
			{
				Row fRow = sheet.getRow(firstRow);
				Cell fCell = fRow.getCell(firstColumn);
				return getStringCellValue(fCell);
			}
		}

		return null;
	}

	public MergeRange getMargedRegion(int row, int column)
		throws Exception
	{
		vaildate();
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++)
		{
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn)
			{
				MergeRange range = new MergeRange();
				range.setFirstColumn(firstColumn);
				range.setLastColumn(lastColumn);
				range.setFirstRow(firstRow);
				range.setLastRow(lastRow);
				Row fRow = sheet.getRow(firstRow);
				Cell fCell = fRow.getCell(firstColumn);
				range.setValue(getStringCellValue(fCell));
				return range;
			}
		}

		return null;
	}

	public CellRangeAddress getMargedReginCell(int firstRow, int lastRow, int firstCol, int lastCol)
		throws Exception
	{
		vaildate();
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++)
		{
			CellRangeAddress ca = sheet.getMergedRegion(i);
			if (ca.getFirstColumn() == firstCol && ca.getLastColumn() == lastCol && ca.getFirstRow() == firstRow && ca.getLastRow() == lastRow)
				return ca;
		}

		return null;
	}

	public MergeRange getMargedRegion(Sheet sheet, int row, int column)
		throws Exception
	{
		int sheetMergeCount = sheet.getNumMergedRegions();
		MergeRange range = new MergeRange();
		int i = 0;
		if (i < sheetMergeCount)
		{
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			range.setFirstColumn(firstColumn);
			range.setLastColumn(lastColumn);
			range.setFirstRow(firstRow);
			range.setLastRow(lastRow);
			if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn)
			{
				Row fRow = sheet.getRow(firstRow);
				Cell fCell = fRow.getCell(firstColumn);
				range.setValue(getStringCellValue(fCell));
			}
			return range;
		} else
		{
			return null;
		}
	}

	public boolean isMergedRegion(int row, int column)
		throws Exception
	{
		vaildate();
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++)
		{
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn)
				return true;
		}

		return false;
	}

	public int getPhysicalRows()
		throws Exception
	{
		vaildate();
		return sheet.getPhysicalNumberOfRows();
	}

	public String getCellComment(int rowNum, int colNum)
		throws Exception
	{
		vaildate();
		Row rows = sheet.getRow(rowNum);
		Cell cell = rows.getCell(colNum);
		return getStringCellValue(cell);
	}

	private String getStringCellValue(Cell cell)
	{
		String strCell = "";
		if (cell == null)
			return "";
		switch (cell.getCellType())
		{
		case 1: // '\001'
			strCell = cell.getStringCellValue();
			break;

		case 2: // '\002'
			strCell = cell.getCellFormula();
			// fall through

		case 0: // '\0'
			if (HSSFDateUtil.isCellDateFormatted((HSSFCell) cell))
				strCell = String.valueOf(dateFormat2String(cell.getDateCellValue()));
			else
				strCell = String.valueOf(cell.getNumericCellValue());
			break;

		case 4: // '\004'
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;

		case 3: // '\003'
			strCell = "";
			break;

		default:
			strCell = cell.getStringCellValue();
			break;
		}
		if (strCell.equals("") || strCell == null)
			return "";
		else
			return strCell;
	}

	private String dateFormat2String(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public int getMergeRangeNum()
		throws Exception
	{
		vaildate();
		return sheet.getNumMergedRegions();
	}

	public List getMergeRangeNumForCol(int colNum)
		throws Exception
	{
		vaildate();
		List list = new ArrayList();
		for (int i = 0; i < sheet.getNumMergedRegions(); i++)
		{
			CellRangeAddress range = sheet.getMergedRegion(i);
			if (range.getFirstColumn() >= colNum && range.getLastColumn() <= colNum)
				list.add(new MergeRange(range.getFirstColumn(), range.getLastColumn(), range.getFirstRow(), range.getLastRow(), getCellComment(range.getFirstRow(), range.getFirstColumn())));
		}

		return list;
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

	public void closeExcel()
	{
		sheet = null;
		wb = null;
		if (inputStream != null)
			try
			{
				inputStream.close();
			}
			catch (IOException e)
			{
				log.error("关闭Excel流异常", e);
			}
	}

}
