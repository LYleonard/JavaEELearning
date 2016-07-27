package com.wrp.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.wrp.dao.StudentDao;
import com.wrp.domain.Student;
import com.wrp.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("添加学生(a)	删除学生(b)	查询成绩(c)");
			System.out.println("请输入操作类型：");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();

			if ("a".equals(type)) {
				System.out.println("请输入学生姓名： ");
				String name = br.readLine();

				System.out.println("请输入学生准考证号： ");
				String examid = br.readLine();

				System.out.println("请输入学生身份证号： ");
				String idcard = br.readLine();

				System.out.println("请输入学生所在地： ");
				String location = br.readLine();

				System.out.println("请输入学生成绩： ");
				String grade = br.readLine();

				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("添加成功！");

			} else if ("b".equals(type)) {

				System.out.println("请输入要删除学生的姓名： ");
				String name = br.readLine();

				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
				} catch (StudentNotExistException e) {
					System.out.println("您要删除的学生不存在！");
				}
				System.out.println("删除学生成功！");

			} else if ("c".equals(type)) {

				System.out.println("请输入准考证号： ");
				String examid = br.readLine();

				try{
					StudentDao dao = new StudentDao();
					Student s = dao.find(examid);
					
					System.out.println("您要查询的学生成绩为：" + s.getGrade());
				} catch(RuntimeException e){
					System.out.println("对不起您输入的准考证号不存在，请输入正确的准考证号！");
				}
				

			} else {
				System.out.println("对不起，不支持您的操作，请按提示输入！ ");
			}

		} catch (IOException e) {
			System.out.println("对不起，系统正在维护！");
		}

	}

}
