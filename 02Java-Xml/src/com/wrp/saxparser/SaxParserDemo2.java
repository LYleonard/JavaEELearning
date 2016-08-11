package com.wrp.saxparser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDemo2 {
	
	// Sax 解析 Xml 文档 
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		
		//1. 创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance(); 
		
		//2. 得到解析器
		SAXParser sp = factory.newSAXParser();
		
		//3. 得到读取器
		XMLReader reader = sp.getXMLReader();
		
		//4. 设置内容处理器
		reader.setContentHandler(new TagValueHandler());
		
		//5. 读取XML文档
		reader.parse("src/book.xml");
	}
	
}
//获取指定标签的值
class TagValueHandler extends DefaultHandler{
	
	private String currentTag;
	private int needNumber = 2; //想要获取的第1个作者标签的值
	private int currentNumber; //当前解析到的是第几个
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if(currentTag.equals("作者")){
			currentNumber++;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		currentTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("作者".equals(currentTag) && currentNumber == needNumber){
			System.out.println(new String(ch,start,length));
		}
	}
	
	
}
