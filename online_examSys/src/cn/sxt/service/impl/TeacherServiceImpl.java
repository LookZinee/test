package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.TeacherDao;
import cn.sxt.service.TeacherService;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teDao;
	@Override
	public List<Student> findAll() {
		
		return teDao.findAllStu();
	}
	public TeacherDao getTeDao() {
		return teDao;
	}
	public void setTeDao(TeacherDao teDao) {
		this.teDao = teDao;
	}
	@Override
	public List<Clazz> findAllClazz() {
		return teDao.findAllClazz();
	}
	@Override
	public boolean addStu(Student student) {
		int num = teDao.addStu(student);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteStu(Student student) {
		int num = teDao.deleteStu(student);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public Student getStuById(int id) {
		return teDao.findStuById(id);
	}
	@Override
	public boolean updateStu(Student student) {
		int num = teDao.updateStu(student);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public List<Subject> findAllSub() {
		
		return teDao.findAllSub();
	}
	@Override
	public boolean deleteSub(int id) {
		int num = teDao.deleteSub(id);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public boolean addSub(Subject subject) {
		System.out.println("TeacherServiceImpl.addSub(新添加的科目的名称是:)"+subject.getName());
		int num = teDao.addSub(subject);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public Subject findSubjectById(int id) {
		
		return teDao.finSubById(id);
	}
	@Override
	public boolean updateSub(Subject subject) {
		int num = teDao.updateSub(subject);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public List<Question> findAllQue() {
		
		return teDao.findAllQue();
	}
	@Override
	public boolean addQue(Question question) {
		int num = teDao.addQue(question);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public Question findQueById(int id) {
		return teDao.findQueById(id);
	}
	@Override
	public boolean updateQue(Question question) {
		int num = teDao.updateQue(question);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteQue(int id) {
		int num = teDao.deleteQue(id);
		if(num >0){
			return true;
		}
		return false;
	}
	@Override
	public boolean saveSetExam(SetExam setExam) {
		int num = teDao.saveSetExam(setExam);
		if(num >0){
			return true;
		}
		return false;
	}
	
	
}
