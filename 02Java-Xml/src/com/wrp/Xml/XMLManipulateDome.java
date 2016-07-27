package com.wrp.Xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.attribute.AclEntry.Builder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//使用dom方法对xml文档进行增、删、改
public class XMLManipulateDome {
	
	//读取xml文档中：<书名>大数据互联网大规模数据挖掘与分布式处理</书名> 节点中的内容
	@Test
	public void read() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		NodeList nodelist = document.getElementsByTagName("书名");
		Node node = nodelist.item(1);
		
		String content = node.getTextContent();
		System.out.println(content);
	}
	
	//遍历xml文档中的所有标签
	@Test
	public void read2() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到根节点
		Node root = document.getElementsByTagName("书架").item(0);
		
		list(root);
	}

	private void list(Node root) {
		if(root instanceof Element){
			System.out.println(root.getNodeName());
		}
		
		NodeList list = root.getChildNodes();
		for(int i=0; i<list.getLength(); i++){
			Node child = list.item(i);
			list(child);
		}
	}

	// 遍历xml文档中标签的属性值：<书名 name="XXXXXX">PostgreSQL修炼之道</书名>
	@Test
	public void read3() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// 得到根节点
		Element bookname = (Element) document.getElementsByTagName("书名").item(0);

		String attr = bookname.getAttribute("name");
		System.out.println(attr);
	}
	
	//向xml文档中添加节点：<售价>￥68.90</售价>
	@Test
	public void add() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		Element price = document.createElement("售价");
		price.setTextContent("68.90");
		
		//把创建的节点加到第一本书上
		Element book = (Element) document.getElementsByTagName("书").item(0);
		book.appendChild(price);
		
		//将更新后的标签和内容写会到xml文档
		TransformerFactory tffactory=TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
		
	}
	
	//向xml文档中指定位置添加节点：<售价>￥68.90</售价>
	@Test
	public void add2() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//创建节点
		Element price = document.createElement("售价");
		price.setTextContent("￥68.90");

		//得到指定参考节点：<售价>￥79.00</售价>
		Element refNode = (Element) document.getElementsByTagName("售价").item(0);
		
		//得到要添加节点的父节点
		Element book = (Element) document.getElementsByTagName("书").item(0);
		
		//往book指定节点前，插入节点
		book.insertBefore(price, refNode);
		
		//将更新后的标签和内容写会到xml文档
		TransformerFactory tffactory=TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	//向xml文档节点中添加属性：<书名>大数据互联网大规模数据挖掘与分布式处理</书名>添加属性name="YYYYYY"
	@Test
	public void addAttr() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到书名节点
		Element bookname = (Element) document.getElementsByTagName("书名").item(1);
		bookname.setAttribute("name", "YYYYYY");
		
		//将更新后的标签和内容写会到xml文档
		TransformerFactory tffactory=TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	//删除指定标签
	@Test
	public void delete() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		//得到要删除的节点
		Element price = (Element) document.getElementsByTagName("售价").item(2);
		//得到要删除节点的父节点
		Element book = (Element) document.getElementsByTagName("书").item(0);
		
		//book节点再删除该节点
		book.removeChild(price);
		//把更新后的内存写回文件中
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer tf = transformerFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	//删除指定节点的第二种方法
	@Test
	public void delete2() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		//得到要删除的节点
		Element price = (Element) document.getElementsByTagName("售价").item(2);
		//得到要删除节点的父节点并删除
		price.getParentNode().removeChild(price);
		
		//把节点所在父节点删除
		//price.getParentNode().getParentNode().removeChild(price.getParentNode());
		
		
		//把更新后的内存写回文件中
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer tf = transformerFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	//更新指定节点的内容
	@Test
	public void update() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		//得到要更新的节点
		Element price = (Element) document.getElementsByTagName("售价").item(0);
		//更新
		price.setTextContent("￥79.90");
		
		//把更新后的内存写回文件中
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer tf = transformerFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
}
