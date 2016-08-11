package com.wrp.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jDemo {

	// 读取xml文档book的第二个书名
	@Test
	public void read() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		String value = book.element("书名").getText();

		System.out.println(value);
	}

	// 读取xml文档book的第二个书名
	@Test
	public void readAttr() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		String booknameAttr = book.element("书名").attributeValue("name");

		System.out.println(booknameAttr);
	}

	// 在第一本书上添加一个售价
	@Test
	public void add() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(0);
		book.addElement("售价").setText("￥79.00");

		/*
		 * OutputFormat format = OutputFormat.createPrettyPrint();
		 * format.setEncoding("UTF-8");//xml文件的编码为UTF-8时 XMLWriter writer = new
		 * XMLWriter(new OutputStreamWriter(new
		 * FileOutputStream("src/book.xml"), "UTF-8"),format);
		 */

		/*
		 * //或者如下 OutputFormat format = OutputFormat.createPrettyPrint();
		 * format.setEncoding("UTF-8");//xml文件的编码为GB2312时 XMLWriter writer = new
		 * XMLWriter(new FileOutputStream("src/book.xml"),format);
		 */

		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"));
		writer.write(document);
		writer.close();

	}

	// 在第一本书的指定位置上添加一个售价
	@Test
	public void add2() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("书");
		List list = book.elements(); //[书名，作者，售价，售价]
		
		Element price = DocumentHelper.createElement("售价");
		price.setText("$79.00");
		list.add(2, price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
		writer.write(document);
		writer.close();
	}
	
	//删除一个售价节点
	@Test
	public void delete() throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		Element price = document.getRootElement().element("书").element("售价");
		price.getParent().remove(price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
		writer.write(document);
		writer.close();
	}
	//更新一个售价节点：<作者>王斌（译）</作者>
	@Test
	public void update() throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		Element book = (Element) document.getRootElement().elements("书").get(1);
		book.element("作者").setText("王斌（翻译）");
		
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),format);
		writer.write(document);
		writer.close();
	}

}
