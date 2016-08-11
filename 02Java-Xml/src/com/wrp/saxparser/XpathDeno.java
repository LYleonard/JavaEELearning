package com.wrp.saxparser;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/*
 * 应用Xpath提取XML文档数据
 */
public class XpathDeno {
	
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		String value = document.selectSingleNode("//作者").getText();
		System.out.println(value);
	}
	
}
