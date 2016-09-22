package cn.sxt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.sxt.dao.TeacherDao;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class TeacherDaoImpl implements TeacherDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> findAllStu() {
		String  hql =" from Student where role=0";
		List<Student> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<Clazz> findAllClazz() {
		return sessionFactory.getCurrentSession().createQuery("from Clazz").list();
	}

	@Override
	public int addStu(Student student) {
		try {
			sessionFactory.getCurrentSession().save(student);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	public int deleteStu(Student student) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Student s = (Student) session.get(Student.class, student.getId());
			session.delete(s);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	public Student findStuById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student s = (Student) session.get(Student.class, id);
		return s;
	}

	@Override
	public int updateStu(Student student) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Student s = (Student) session.get(Student.class, student.getId());
			s.setName(student.getName());
			s.setSex(student.getSex());
			s.setAge(student.getAge());
			s.setPwd(s.getPwd());
			s.setClazz(student.getClazz());
		} catch (Exception e) {
			System.out.println("修改学生信息失败");
			return -1;
		}
		return 1;
	}

	@Override
	public List<Subject> findAllSub() {
		
		return sessionFactory.getCurrentSession().createQuery("from Subject").list();
	}

	@Override
	public int deleteSub(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Subject sub = (Subject) session.get(Subject.class, id);
			session.delete(sub);
		} catch (Exception e) {
			System.out.println("删除科目失败");
			return -1;
		}
		return 1;
	}

	@Override
	public int addSub(Subject subject) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(subject);
		} catch (Exception e) {
			System.out.println("添加科目失败");
			return -1;
		}
		return 1;
	}

	@Override
	public Subject finSubById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Subject sub = (Subject) session.get(Subject.class, id);
		return sub;
	}

	@Override
	public int updateSub(Subject subject) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Subject sub = (Subject) session.get(Subject.class, subject.getId());
			sub.setName(subject.getName());
		} catch (Exception e) {
			System.out.println("添加科目失败");
			return -1;
		}
		return 1;
	}

	@Override
	public List<Question> findAllQue() {
		
		return sessionFactory.getCurrentSession().createQuery("from Question").list();
	}

	@Override
	public int addQue(Question question) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(question);
			
		} catch (Exception e) {
			System.out.println("添加科目失败");
			return -1;
		}
		return 1;
	}

	@Override
	public Question findQueById(int id) {
		Question qu = (Question) sessionFactory.getCurrentSession().get(Question.class, id);
		return qu;
	}

	@Override
	public int updateQue(Question question) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Question que = (Question) session.get(Question.class, question.getId());
			que.setAnswer(question.getAnswer());
			que.setDegree(question.getDegree());
			que.setOptiona(question.getOptiona());
			que.setOptionb(question.getOptionb());
			que.setOptionc(question.getOptionc());
			que.setOptiond(question.getOptiond());
			que.setSubject(question.getSubject());
			que.setTitle(question.getTitle());
			
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	@Override
	public int deleteQue(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Question que = (Question) session.get(Question.class, id);
			session.delete(que);
		} catch (Exception e) {
			System.out.println("添加科目失败");
			return -1;
		}
		return 1;
	}

	@Override
	public int saveSetExam(SetExam setExam) {
		try {
			sessionFactory.getCurrentSession().save(setExam);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
	
	
}
