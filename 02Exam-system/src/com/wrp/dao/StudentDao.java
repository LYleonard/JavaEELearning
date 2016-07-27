package com.wrp.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.wrp.domain.Student;
import com.wrp.exception.StudentNotExistException;
import com.wrp.utils.XmlUtils;

//数据访问模块（Data Access Object）
public class StudentDao {
	
	public void add(Student s){
		
		try {
			Document document = XmlUtils.getDocument();
			//创建出封装学生信息的标签
			Element student_tag = document.createElement("student");
			student_tag.setAttribute("idcard", s.getIdcard());
			student_tag.setAttribute("examid", s.getExamid());
			
			//创建用于封装学生姓名、所在地和成绩的标签
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");
			
			name.setTextContent(s.getName());
			location.setTextContent(s.getLocation());
			grade.setTextContent(s.getGrade()+"");
			
			student_tag.appendChild(name);
			student_tag.appendChild(location);
			student_tag.appendChild(grade);
			
			//变封装了学生信息的标签，挂到文档上
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);
			//内存写回到文件
			XmlUtils.write2Xml(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			// 运行时异常，即（unchecked exception）
		} //编译时异常，即（checked exception）
			
	}
	
	public Student find(String examid){
		
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			
			for(int i=0; i<list.getLength(); i++) {
				Element student_tag = (Element) list.item(i);
				if(student_tag.getAttribute("examid").equals(examid)){
					//找到与examid相匹配的学生 new一个学生对象，封装学生信息返回
					Student student = new Student();
					student.setExamid(examid);
					student.setIdcard(student_tag.getAttribute("idcard"));
					student.setName(student_tag.getElementsByTagName("name").item(0).getTextContent());
					student.setLocation(student_tag.getElementsByTagName("location").item(0).getTextContent());
					student.setGrade(Double.parseDouble(student_tag.getElementsByTagName("grade").item(0).getTextContent()));
					return student;
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public void delete(String name) throws StudentNotExistException{
		
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("name");
			
			for(int i=0; i<list.getLength(); i++) {
				Element student_tag = (Element) list.item(i);
				if(list.item(i).getTextContent().equals(name)){
					
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XmlUtils.write2Xml(document);
					return;
				}
			}
			
			throw new StudentNotExistException(name + "不存在");
		} catch(StudentNotExistException e){
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
