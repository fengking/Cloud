// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ZipUtil.java

package com.feng.common.util;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipUtil
{

	private static ZipUtil instance;

	public ZipUtil()
	{
	}

	public static ZipUtil getInstance()
	{
		if (instance == null)
			instance = new ZipUtil();
		return instance;
	}

	public void compressFile(String filename, String zipFilename)
	{
		File file = new File(filename);
		File zipFileName = new File(zipFilename);
		List fileList = new ArrayList();
		fileList.add(file);
		try
		{
			FileOutputStream fos = new FileOutputStream(zipFilename);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (Iterator iterator = fileList.iterator(); iterator.hasNext();)
			{
				File file1 = (File)iterator.next();
				if (!file1.isDirectory())
					addToZip(zipFileName, file, zos);
			}

			zos.close();
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void compressDirectory(String fileDirectory, String savedZipFileDirectory)
	{
		File directoryToZip = new File(fileDirectory);
		List fileList = new ArrayList();
		try
		{
			System.out.println((new StringBuilder("---Getting references to all directory in: ")).append(directoryToZip.getCanonicalPath()).toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		getAllFiles(directoryToZip, fileList);
		System.out.println("---Creating zip file");
		String folder = (new StringBuilder(String.valueOf(savedZipFileDirectory))).append(File.separator).append(directoryToZip.getName()).toString();
		writeZipFile(folder, directoryToZip, fileList);
		System.out.println("---Done");
	}

	public void unCompressZipFile(String zipFileName)
	{
		try
		{
			ZipFile zipFile = new ZipFile(zipFileName);
			for (Enumeration enu = zipFile.entries(); enu.hasMoreElements();)
			{
				ZipEntry zipEntry = (ZipEntry)enu.nextElement();
				String name = zipEntry.getName();
				long size = zipEntry.getSize();
				long compressedSize = zipEntry.getCompressedSize();
				System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", new Object[] {
					name, Long.valueOf(size), Long.valueOf(compressedSize)
				});
				File file = new File(name);
				if (name.endsWith("/"))
				{
					file.mkdirs();
				} else
				{
					File parent = file.getParentFile();
					if (parent != null)
						parent.mkdirs();
					InputStream is = zipFile.getInputStream(zipEntry);
					FileOutputStream fos = new FileOutputStream(file);
					byte bytes[] = new byte[1024];
					int length;
					while ((length = is.read(bytes)) >= 0) 
						fos.write(bytes, 0, length);
					is.close();
					fos.close();
				}
			}

			zipFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void getAllFiles(File dir, List fileList)
	{
		try
		{
			File files[] = dir.listFiles();
			File afile[];
			int j = (afile = files).length;
			for (int i = 0; i < j; i++)
			{
				File file = afile[i];
				fileList.add(file);
				if (file.isDirectory())
				{
					System.out.println((new StringBuilder("directory:")).append(file.getCanonicalPath()).toString());
					getAllFiles(file, fileList);
				} else
				{
					System.out.println((new StringBuilder("     file:")).append(file.getCanonicalPath()).toString());
				}
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void seeContentOfZipFile(String zipfile)
	{
		try
		{
			ZipFile zipFile = new ZipFile(zipfile);
			String name;
			long size;
			long compressedSize;
			for (Enumeration enu = zipFile.entries(); enu.hasMoreElements(); System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", new Object[] {
	name, Long.valueOf(size), Long.valueOf(compressedSize)
}))
			{
				ZipEntry zipEntry = (ZipEntry)enu.nextElement();
				name = zipEntry.getName();
				size = zipEntry.getSize();
				compressedSize = zipEntry.getCompressedSize();
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void writeZipFile(String folder, File directoryToZip, List fileList)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream((new StringBuilder(String.valueOf(folder))).append(".zip").toString());
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (Iterator iterator = fileList.iterator(); iterator.hasNext();)
			{
				File file = (File)iterator.next();
				if (!file.isDirectory())
					addToZip(directoryToZip, file, zos);
			}

			zos.close();
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void addToZip(File zipfilename, File file, ZipOutputStream zos)
		throws FileNotFoundException, IOException
	{
		FileInputStream fis = new FileInputStream(file);
		String zipFilePath = file.getCanonicalPath().substring(zipfilename.getCanonicalPath().length() + 1, file.getCanonicalPath().length());
		System.out.println((new StringBuilder("Writing '")).append(zipFilePath).append("' to zip file").toString());
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);
		byte bytes[] = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) 
			zos.write(bytes, 0, length);
		zos.closeEntry();
		fis.close();
	}

	public void compressFiles(List fileList, String zipfileName)
	{
		File zip = new File(zipfileName);
		try
		{
			FileOutputStream fos = new FileOutputStream(zip);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (Iterator iterator = fileList.iterator(); iterator.hasNext();)
			{
				File file1 = (File)iterator.next();
				if (!file1.isDirectory())
					addToZip(zip, file1, zos);
			}

			zos.close();
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
