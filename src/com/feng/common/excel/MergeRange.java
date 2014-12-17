// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MergeRange.java

package com.feng.common.excel;

import org.apache.poi.ss.usermodel.Cell;

public class MergeRange
{

	private int firstColumn;
	private int lastColumn;
	private int firstRow;
	private int lastRow;
	private String value;
	private Cell cell;

	public MergeRange()
	{
	}

	public MergeRange(int firstColumn, int lastColumn, int firstRow, int lastRow, String value)
	{
		this.firstColumn = firstColumn;
		this.lastColumn = lastColumn;
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.value = value;
	}

	public MergeRange(int firstColumn, int lastColumn, int firstRow, int lastRow, String value, Cell cell)
	{
		this.firstColumn = firstColumn;
		this.lastColumn = lastColumn;
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.value = value;
		this.cell = cell;
	}

	public int getFirstColumn()
	{
		return firstColumn;
	}

	public void setFirstColumn(int firstColumn)
	{
		this.firstColumn = firstColumn;
	}

	public int getLastColumn()
	{
		return lastColumn;
	}

	public void setLastColumn(int lastColumn)
	{
		this.lastColumn = lastColumn;
	}

	public int getFirstRow()
	{
		return firstRow;
	}

	public void setFirstRow(int firstRow)
	{
		this.firstRow = firstRow;
	}

	public int getLastRow()
	{
		return lastRow;
	}

	public void setLastRow(int lastRow)
	{
		this.lastRow = lastRow;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public Cell getCell()
	{
		return cell;
	}

	public void setCell(Cell cell)
	{
		this.cell = cell;
	}
}
