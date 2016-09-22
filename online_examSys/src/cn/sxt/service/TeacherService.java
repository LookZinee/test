package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public interface TeacherService {
	public List<Student> findAll();

	public List<Clazz> findAllClazz();

	public boolean addStu(Student student);

	public boolean deleteStu(Student student);

	public Student getStuById(int id);

	public boolean updateStu(Student student);

	public List<Subject> findAllSub();

	public boolean deleteSub(int id);

	public boolean addSub(Subject subject);

	public Subject findSubjectById(int id);

	public boolean updateSub(Subject subject);

	public List<Question> findAllQue();

	public boolean addQue(Question question);

	public Question findQueById(int id);

	public boolean updateQue(Question question);

	public boolean deleteQue(int id);

	public boolean saveSetExam(SetExam setExam);
}
