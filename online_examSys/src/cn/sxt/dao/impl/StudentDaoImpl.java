package cn.sxt.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.sxt.dao.StudentDao;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.Result;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;
import cn.sxt.vo.XiangQing;

public class StudentDaoImpl implements StudentDao{
	SessionFactory sessionFactory;
	@Override
	public List<Student> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Student where role=0").list();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Student login(String name, String pwd,int role) {
		String hql ="from Student where name=? and pwd=? and role=?";
		Query cq = sessionFactory.getCurrentSession().createQuery(hql);
		cq.setString(0, name);
		cq.setString(1, pwd);
		cq.setInteger(2, role);
		List<Student> list = cq.list();
		return list.size()>0?list.get(0):null;
	}
	@Override
	public List<Clazz> findAllClazz() {
		
		return sessionFactory.getCurrentSession().createQuery("from Clazz").list();
	}
	@Override
	public int save(Student student) {
		try {
			sessionFactory.getCurrentSession().save(student);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
	@Override
	public List<Subject> findAllSubject() {
		
		return sessionFactory.getCurrentSession().createQuery("from Subject").list();
	}
	@Override
	public Subject findSubById(int id) {
		
		return (Subject) sessionFactory.getCurrentSession().get(Subject.class, id);
	}
	@Override
	public SetExam findSetExam() {
		Session session = sessionFactory.getCurrentSession();
		List<SetExam> list = session.createQuery("from SetExam").list();
		return list.get(list.size()-1);
	}
	@Override
	public char getRightAnser(int id) {
		Question q =  (Question) sessionFactory.getCurrentSession().get(Question.class, id);
		
		return q.getAnswer();
	}
	@Override
	public int getResultId(Student stu, int id, Date parse) {
		Session session = sessionFactory.getCurrentSession();
		Student student = (Student) session.get(Student.class, stu.getId());
		Subject subject = (Subject) session.get(Subject.class, id);
		Result result = new Result();
		result.setStudent(student);
		result.setSubject(subject);
		result.setTesttime(parse);
		session.save(result);
		List<Result> list = session.createQuery("from Result").list();
		
		return list.get(list.size()-1).getId();
	}
	@Override
	public void saveXiangQing(int resultid, int parseInt, char charAt) {
		Session session = sessionFactory.getCurrentSession();
		Result result = (Result) session.get(Result.class, resultid);
		Question question = (Question) session.get(Question.class, parseInt);
		
		XiangQing xiangqing = new XiangQing(result, question, charAt);
		session.save(xiangqing);
	}
	@Override
	public void updateResult(int resultid, int score) {
		Session session = sessionFactory.getCurrentSession();
		Result result = (Result) session.get(Result.class, resultid);
		result.setScore(score);
		
	}
	@Override
	public List<Result> findAllResultById(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Result> resultList = session.createQuery("from Result where stuid=? ").setInteger(0, id).list();
		return resultList;
	}
	@Override
	public Result findXiangQingById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Result result = (Result) session.get(Result.class, id);
		
		return result;
	}
	
	
	
	
}
