package junit.test;

import org.junit.Test;

import com.wrp.dao.StudentDao;
import com.wrp.domain.Student;
import com.wrp.exception.StudentNotExistException;

public class StudentDaoTest {
	
	@Test
	public void testAdd() {
		
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExamid("121");
		s.setGrade(96);
		s.setIdcard("121");
		s.setLocation("北京");
		s.setName("WRP");
		
		dao.add(s);
	}
	
	@Test
	public void testFind(){
		StudentDao dao = new StudentDao();
		dao.find("444");
	}
	
	@Test
	public void testDelete() throws StudentNotExistException{
		StudentDao dao = new StudentDao();
		dao.delete("WRP");
	}
}
