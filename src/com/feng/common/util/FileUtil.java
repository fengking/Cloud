// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileUtil.java

package com.feng.common.util;

import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.FileUtil.class);
	private static final int DEFAULT_BUFFER_SIZE = 4096;

	public FileUtil()
	{
	}

	public static String ltrim(String src)
	{
		int i = 0;
		for (i = 0; i < src.length(); i++)
			if (src.charAt(i) > ' ')
				break;

		return src.substring(i);
	}

	public static String rtrim(String src)
	{
		int i;
		for (i = src.length() - 1; i >= 0; i--)
			if (src.charAt(i) > ' ')
				break;

		return src.substring(0, i + 1);
	}

	public static String trim(String src)
	{
		return ltrim(rtrim(src));
	}

	public static boolean createDir(String dir)
	{
		File file = new File(dir);
		if (!file.exists())
			file.mkdirs();
		return true;
	}

	public static String getFileName(String file)
	{
		int pos = file.lastIndexOf('/');
		if (pos == -1)
			pos = file.lastIndexOf('\\');
		return file.substring(pos + 1);
	}

	public static void deleteFile(String filePath)
	{
		File file = new File(filePath);
		file.deleteOnExit();
	}

	public static byte[] getBytesByFile(String filePath)
		throws Exception
	{
		try
		{
		byte content[];
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		byte temp[] = new byte[1024];
		for (int size = 0; (size = in.read(temp)) != -1;)
			out.write(temp, 0, size);

		in.close();
		content = out.toByteArray();
		log.info((new StringBuilder("文件：")).append(filePath).append("共读取byte数组长度：").append(content.length).toString());
		return content;
		}
		catch(Exception e)
		{
		log.info((new StringBuilder("文件：")).append(filePath).append("读成byte数组时异常").append(e).toString());
		throw new Exception((new StringBuilder("文件：")).append(filePath).append("读成byte数组时异常").toString(), e);
		}
	}

	public static String readFileToString(String filePath, String encoding)
		throws Exception
	{
		try
		{
		InputStream in;
		Reader input;
		BufferedReader reader;
		in = null;
		input = null;
		reader = null;
		String s;
		in = new FileInputStream(filePath);
		input = new InputStreamReader(in, encoding);
		reader = new BufferedReader(input);
		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = reader.readLine()) != null) 
			sb.append(str);
		s = sb.toString();
		if (reader != null)
			try
			{
				reader.close();
			}
			catch (Exception e)
			{
				log.error("close BufferReader happen error！", e);
			}
		if (input != null)
			try
			{
				input.close();
			}
			catch (Exception e)
			{
				log.error("close Reader happen error！", e);
			}
		if (in != null)
			try
			{
				in.close();
			}
			catch (Exception e)
			{
				log.error("close InputStream happen error！", e);
			}
		return s;
		}
		catch(Exception exception)
		{
		 
		throw exception;
		}
	}

	public static boolean writeBytesToFile(byte b[], String fileName, String filePath, boolean isAppendOn)
		throws Exception
	{
		File file = new File(filePath);
		String imagePath = (new StringBuilder(String.valueOf(filePath))).append(File.separatorChar).append(fileName).toString();
		log.info((new StringBuilder("文件保存路径：   ")).append(imagePath).toString());
		try
		{
			if (!file.exists())
			{
				file.mkdirs();
				if (!file.exists())
				{
					log.error((new StringBuilder("创建目录发生异常         ")).append(filePath).toString());
					throw new IOException((new StringBuilder("创建目录发生异常         ")).append(filePath).toString());
				}
			}
			writeBytesToFile(b, imagePath, isAppendOn);
		}
		catch (Exception e)
		{
			log.error((new StringBuilder("保存文件到")).append(imagePath).append("时发生异常").toString(), e);
			throw new Exception((new StringBuilder("保存文件到")).append(imagePath).append("时发生异常").toString(), e);
		}
		return true;
	}

	public static void writeBytesToFile(byte bytes[], String filePath, boolean isAppendOn)
		throws Exception
	{
		 
		FileOutputStream output;
		BufferedOutputStream bos;
		File dir;
		output = null;
		bos = null;
		File f = new File(filePath);
		dir = new File(f.getParent());
		try
		{
			if (!dir.exists())
				dir.mkdirs();
			if (!dir.exists())
				dir.mkdirs();
			output = new FileOutputStream(filePath, isAppendOn);
			bos = new BufferedOutputStream(output, 4096);
			bos.write(bytes);
		}
		catch (IOException e)
		{
			String msg = new String((new StringBuilder("写文件失败,IO错误.")).append(filePath).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		catch (RuntimeException e)
		{
			String msg = new String((new StringBuilder("写文件失败，运行时异常.")).append(filePath).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		 
		 
		if (bos != null)
			try
			{
				bos.close();
			}
			catch (Exception ex)
			{
				log.error("关闭文件出错！", ex);
			}
		if (output != null)
			try
			{
				output.close();
			}
			catch (Exception ex)
			{
				log.error("关闭文件出错！", ex);
			}
		 
		if (bos != null)
			try
			{
				bos.close();
			}
			catch (Exception ex)
			{
				log.error("关闭文件出错！", ex);
			}
		if (output != null)
			try
			{
				output.close();
			}
			catch (Exception ex)
			{
				log.error("关闭文件出错！", ex);
			}
		return;
		 
	}

	public void serialization(Serializable obj, String fileName)
		throws Exception
	{
		File f;
		File dir;
		FileOutputStream out;
		BufferedOutputStream bos;
		ObjectOutputStream objectOutputStream;
		f = new File(fileName);
		dir = new File(f.getParent());
		out = null;
		bos = null;
		objectOutputStream = null;
		try
		{
			if (!dir.exists())
				dir.mkdirs();
			if (!f.exists())
				f.createNewFile();
			out = new FileOutputStream(f);
			bos = new BufferedOutputStream(out, 4096);
			objectOutputStream = new ObjectOutputStream(bos);
			objectOutputStream.writeObject(obj);
		}
		catch (IOException e)
		{
			String msg = new String((new StringBuilder("序列化失败,IO错误.")).append(fileName).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		catch (RuntimeException e)
		{
			String msg = new String((new StringBuilder("序列化失败,运行时异常.")).append(fileName).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		 
		if (objectOutputStream != null)
			objectOutputStream.close();
		if (bos != null)
			bos.close();
		if (out != null)
			bos.close();
		 
		if (objectOutputStream != null)
			objectOutputStream.close();
		if (bos != null)
			bos.close();
		if (out != null)
			bos.close();
		return;
	}

	public void deleteFiles(String filePath)
	{
		File file = new File(filePath);
		if (file.isFile())
		{
			file.delete();
		} else
		{
			File f[] = file.listFiles();
			if (f != null && f.length > 0)
			{
				for (int i = 0; i < f.length; i++)
				{
					File tmp = f[i];
					if (tmp.isDirectory())
						deleteFiles(tmp.getPath());
					tmp.delete();
				}

			}
		}
		file.delete();
		file.deleteOnExit();
	}

	public Serializable deserialize(String fileName)
		throws Exception
	{
		File f = new File(fileName);
		FileInputStream in = null;
		ObjectInputStream objectInputStream = null;
		Serializable obj = null;
		try
		{
			in = new FileInputStream(f);
			objectInputStream = new ObjectInputStream(in);
			obj = (Serializable)objectInputStream.readObject();
		}
		catch (FileNotFoundException e)
		{
			String msg = new String((new StringBuilder("反序列化失败,文件未找到.")).append(fileName).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		catch (Exception e)
		{
			String msg = new String((new StringBuilder("反序列化失败,IO错误.")).append(fileName).toString());
			log.error(msg, e);
			throw new Exception(msg, e);
		}
		return obj;
	}

}
