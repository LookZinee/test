package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public interface TeacherDao {

	List<Student> findAllStu();

	List<Clazz> findAllClazz();

	int addStu(Student student);

	int deleteStu(Student student);

	Student findStuById(int id);

	int updateStu(Student student);

	List<Subject> findAllSub();

	int deleteSub(int id);

	int addSub(Subject subject);

	Subject finSubById(int id);

	int updateSub(Subject subject);

	List<Question> findAllQue();

	int addQue(Question question);

	Question findQueById(int id);

	int updateQue(Question question);

	int deleteQue(int id);

	int saveSetExam(SetExam setExam);

}
