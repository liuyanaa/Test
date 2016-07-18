package com.newer.io.stream;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/*
 *对字符数据进行凯撒密码加密的流
 */

public class CaesarWriter extends FilterWriter {

	public CaesarWriter(Writer out) {
		super(out);
	}
	
	@Override
	public void write(String str) throws IOException {
		char[] data = str.toCharArray();
		// 每个字符的ANSI 值加一
		for (int i = 0; i < data.length; i++) {
			if (data[i] >= 'a' && data[i] <= 'z') {
				data[i] += 1;
			}
		}
		super.write(data);
	}

}
