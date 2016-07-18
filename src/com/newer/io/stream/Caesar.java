package com.newer.io.stream;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Caesar {
	
	public static void main(String[] args) {
		
		charInfo();
//		write();
//		read();
	}
		
	@SuppressWarnings("unused")
	private static void read() {
		try (CaesarReader in = new CaesarReader(new FileReader("file.txt"))){
			char[] buf = new char[8];
			int size;
			
			//字节数组输出流(没存)
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//字符数组的输出流
			CharArrayWriter caw = new CharArrayWriter();
			//可变的字符数组
			StringBuilder s = new StringBuilder();
			
			while(-1!= (size= in.read(buf))){
				//写数据
				//StringBuilder中追加
//				s.append(buf, 0, size);
				caw.write(buf, 0, size);
				
			}
			System.out.println(s.toString());
			System.out.println("over");
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("unused")
	private static void write() {
		String msg = "life is short,time is long";
		try(
				//FileWriter out = new FileWriter("file.txt")
				CaesarWriter out = new CaesarWriter(new FileWriter("file.txt"))
				){
			out.write(msg);
			System.out.println("over");
		} catch(IOException e) {
		}
	}
	
	/*
	 * char 数值
	 */
	private static void charInfo() {
		System.out.println('a'<'z');
		//ANSI 美国国家标准信息码
		for(int i = 0;i<127;i++){
			System.out.printf("%d : %c\n",i,(char)i);
			//printf  格式化
		}
		//char（字符）：2个字节        byte（字节）：1个字节       一个汉字：两个字符，三个字节
		String str = "hello world";
		
		char[] cdata = str.toCharArray();
		
		System.out.println(Arrays.toString(cdata));
		//让每个字符加一：cdata[i] += 1
		for(int i = 0;i<cdata.length;i++){
		//	if(cdata[i] >= 'a' && cdata[i] <= 'z'){
				cdata[i] -= 1;
				//cdata[i] -= 32;   转换成大写
			//}
		}
		System.out.println(Arrays.toString(cdata));
		String result = new String(cdata,0,cdata.length);
		System.out.println(result);
//		byte[] bdata = str.getBytes();
//		
//		System.out.println(cdata.length);
//		System.out.println(bdata.length);
//		System.out.println(Arrays.toString(cdata));
//		System.out.println(Arrays.toString(bdata));
	}
}

