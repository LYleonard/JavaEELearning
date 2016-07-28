package com.wrp.saxparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDemo3 {
	// Sax 解析 Xml 文档 
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		
		//1. 创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance(); 
		
		//2. 得到解析器
		SAXParser sp = factory.newSAXParser();
		
		//3. 得到读取器
		XMLReader reader = sp.getXMLReader();
		
		//4. 设置内容处理器
		BeanListHandler handle = new BeanListHandler();
		reader.setContentHandler(handle);
		
		//5. 读取XML文档
		reader.parse("src/book.xml");
		
		List<Book> list = handle.getBooks();
		System.out.println(list);
	}
}
//吧XML中的每一本书的信息封装到一个book对象中，并把多本书放到一个list集合中返回
class BeanListHandler extends DefaultHandler{
	
	private List list = new ArrayList<>();
	private String currentTag;
	private Book book;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if("书".equals(currentTag)){
			book = new Book();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("书".equals(currentTag)){
			String bookname = new String(ch,start,length);
			book.setName(bookname);
		}
		if("作者".equals(currentTag)){
			String author = new String(ch,start,length);
			book.setAuthor(author);
		}
		if("售价".equals(currentTag)){
			String price = new String(ch,start,length);
			book.setPrice(price);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("书")){
			list.add(book);
			book = null;
		}
		
		currentTag = null;
	}

	public List getBooks() {
		return list;
	}
	
}


