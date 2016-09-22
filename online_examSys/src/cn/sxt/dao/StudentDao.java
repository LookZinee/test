package cn.sxt.dao;

import java.util.Date;
import java.util.List;

import cn.sxt.vo.Clazz;
import cn.sxt.vo.Result;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public interface StudentDao {
	public List<Student> findAll();

	public Student login(String name, String pwd, int role);

	public List<Clazz> findAllClazz();

	public int save(Student student);

	public List<Subject> findAllSubject();

	public Subject findSubById(int id);

	public SetExam findSetExam();

	public char getRightAnser(int id);

	public int getResultId(Student stu, int id, Date parse);

	public void saveXiangQing(int resultid, int parseInt, char charAt);

	public void updateResult(int resultid, int score);

	public List<Result> findAllResultById(int id);

	public Result findXiangQingById(int id);

}
