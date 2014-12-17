// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelStyle.java

package com.feng.common.excel;

import org.apache.poi.ss.usermodel.*;

public class ExcelStyle
{

	private Workbook wb;
	public static final int ALIGN_CENTER = 2;
	public static final int ALIGN_LEFT = 1;
	public static final int ALIGN_RIGHT = 1;
	public static final int ALIGN_CENTER_SELECTION = 6;
	public static final int ALIGN_FILL = 4;
	public static final int ALIGN_GENERAL = 0;
	public static final int ALIGN_ = 5;
	public static final short BORDER_THIN = 1;
	public static final short BORDER_NONE = 0;
	public static final short BORDER_MEDIUM = 2;
	public static final short BORDER_THICK = 5;
	public static final short BORDER_DOUBLE = 6;
	public static final short BORDER_HAIR = 4;
	public static final short BOLDWEIGHT_BOLD = 700;
	public static final short BOLDWEIGHT_NORMAL = 400;
	public static final short COLOR_YELLOW = 13;
	public static final short COLOR_BULE = 12;
	public static final short COLOR_RED = 12;
	public static final short COLOR_BLACK = 8;
	public static final short COLOR_WHITE = 9;

	public ExcelStyle(Workbook wb)
	{
		this.wb = wb;
	}

	public CellStyle createCellStyle()
	{
		CellStyle style = wb.createCellStyle();
		return style;
	}

	public CellStyle createCellStyle(Font font)
	{
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		return style;
	}

	public Font createFont(Integer fontPoint, boolean isBold, Integer color)
	{
		Font font = wb.createFont();
		font.setFontName("Arial");
		if (fontPoint != null)
			font.setFontHeightInPoints(fontPoint.shortValue());
		else
			font.setFontHeightInPoints((short)10);
		if (isBold)
			font.setBoldweight((short)700);
		else
			font.setBoldweight((short)400);
		if (color != null)
			font.setColor(color.shortValue());
		return font;
	}

	public Workbook getWb()
	{
		return wb;
	}

	public void setWb(Workbook wb)
	{
		this.wb = wb;
	}
}
