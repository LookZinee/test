package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.Result;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public interface StudentService {
	public List<Student> findAll();

	public Student login(String name, String pwd, int i);

	public List<Clazz> findAllClazz();

	public boolean save(Student student);

	public List<Subject> findAllSubject();

	public Subject findSubById(int id);

	public SetExam findSetEeam();

	public List<Question> getQuestions(int i);

	public String getTiHao(List<Question> questions);

	public String[] getEveryTihao(String tihao);

	public char getRightAnswer(int parseInt);

	public int getResultId(int id);

	public void saveXiangQing(int resultid, int parseInt, char charAt);

	public void updateResult(int resultid, int score);

	public List<Result> findAllResult();

	public Result findXiangQing(int id);

}
