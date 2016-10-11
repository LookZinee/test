package cn.sxt.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import cn.sxt.dao.StudentDao;
import cn.sxt.service.StudentService;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.Result;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class StudentServiceImpl implements StudentService {
	private StudentDao stuDao;
	@Override
	public List<Student> findAll() {
		return stuDao.findAll();
	}
	public StudentDao getStuDao() {
		return stuDao;
	}
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}
	@Override
	public Student login(String name, String pwd,int role) {
		Student student = stuDao.login(name,pwd,role);
		//System.out.println("student:"+student.getName()+"-----student.pwd="+student.getPwd()+"-----id:"+student.getId());
		return student;
	}
	@Override
	public List<Clazz> findAllClazz() {
		return stuDao.findAllClazz();
	}
	@Override
	public boolean save(Student student) {
		int num = stuDao.save(student);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public List<Subject> findAllSubject() {
		
		return stuDao.findAllSubject();
	}
	@Override
	public Subject findSubById(int id) {
		
		return stuDao.findSubById(id);
	}
	@Override
	public SetExam findSetEeam() {
		
		return stuDao.findSetExam();
	}
	@Override
	public List<Question> getQuestions(int id) {
		Subject sub = stuDao.findSubById(id);
		SetExam setExam = stuDao.findSetExam();
		List<Question> questions = new  ArrayList<>();
		int count = 0;
		for (Question q : sub.getQuestions()) {
			questions.add(q);
			count++;
			if(count == setExam.getQuestionnum()){
				break;
			}
		}
		return questions;
	}
	@Override
	public String getTiHao(List<Question> questions) {
		String s = "";
		for (Question question : questions) {
			s+=question.getId()+",";
		}
		System.out.println(s);
		return s;
	}
	@Override
	public String[] getEveryTihao(String tihao) {
		String[] split = tihao.split(",");
		for (int i = 0; i < split.length; i++) {
			split[i].trim();
			System.out.println("----------"+split[i]);
		}
		
		return split;
	}
	@Override
	public char getRightAnswer(int id) {
		
		return stuDao.getRightAnser(id);
	}
	@Override
	public int getResultId(int id) {
		Student stu = (Student) ServletActionContext.getRequest().getSession().getAttribute("currentStudent");
		Date date = new Date();
		int num = 0;
		try {
			num = stuDao.getResultId(stu,id,new SimpleDateFormat("yyyy-MM-dd").parse(date.toLocaleString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public void saveXiangQing(int resultid, int parseInt, char charAt) {
		stuDao.saveXiangQing(resultid,parseInt,charAt);
	}
	@Override
	public void updateResult(int resultid, int score) {
		stuDao.updateResult(resultid,score);
		
	}
	@Override
	public List<Result> findAllResult() {
		Student stu = (Student) ServletActionContext.getRequest().getSession().getAttribute("currentStudent");
		return stuDao.findAllResultById(stu.getId());
	}
	@Override
	public Result findXiangQing(int id) {
		
		return stuDao.findXiangQingById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
