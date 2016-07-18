package com.newer.io.stream;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader {

	protected CaesarReader(Reader in) {
		super(in);
	}
	@Override
	public int read() throws IOException {
		int c = (char) super.read();
		
		//TODO 有问题:Z
		c = decode(c);
		
		return c;
	}
	/*
	 * 使用缓冲区  cbuf 读取数据，返回缓冲区中有效数据的长度
	 */
	private int decode(int c) {
		if(c >= 'a' && c<= 'z'){
			c--;
		}
		return c;
	}
	@Override
	public int read(char[] cbuf) throws IOException {
		int size = super.read(cbuf);
		for(int i = 0;i<size;i++){
			
			//解码
			cbuf[i] = (char) decodeCaesar(cbuf[i]);
		}
		return size;
	}
	private char decodeCaesar(char c) {
		// TODO 
		return 0;
	}
	

}
