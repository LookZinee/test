package cn.sxt.action;

import java.util.List;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.opensymphony.xwork2.Action;

import cn.sxt.service.TeacherService;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class TeacherAction {
	private TeacherService teService;
	private List<Student> stuList;
	private Student student;
	private List<Clazz> calzzList;
	private List<Subject> subList;
	private String meg;
	private Subject subject;
	private List<Question> queList;
	private Question question;
	private SetExam setExam;
	
	public String  findAll(){
		stuList = teService.findAll();
		calzzList =  teService.findAllClazz();
		return "findAll";
	}
	//添加学生
	public String addStu(){
		System.out.println("TeacherAction.addStu(执行了)");
		boolean flag = teService.addStu(student);
		if(flag){
			return Action.SUCCESS;
		}
		meg="添加失败！请按照格式进行填写信息";
		return "addflase";
	}
	
	public String toaddStu(){
		calzzList =  teService.findAllClazz();
		return "toaddStu";
	}
	
	public String deleteStu(){
		boolean flag = teService.deleteStu(student);
		return Action.SUCCESS;
	}
	
	public String toupdate(){
		calzzList =  teService.findAllClazz();
		student = teService.getStuById(student.getId());
		return "toupdate";
	}
	public String updateStu(){
		System.out.println("TeacherAction.updateStu(要修改的学生的基本信息为)"+student);
		boolean flag = teService.updateStu(student);
		return Action.SUCCESS;
	}
	public String findAllSubject(){
		subList = teService.findAllSub();
		return "toshowSub";
	}
	public String deleteSub(){
		boolean flag = teService.deleteSub(subject.getId());
		return "showsub";
	}
	public String addSub(){
		boolean flag = teService.addSub(subject);
		return "showsub";
	}
	public String toupdateSub(){
		subject = teService.findSubjectById(subject.getId());
		return "toupdateSub";
	}
	public String updateSub(){
		boolean flag = teService.updateSub(subject);
		return "showsub";
	}
	public String findAllQue(){
		queList = teService.findAllQue();
		return "allque";
	}
	public String toaddQue(){
		subList = teService.findAllSub();
		return "toaddQue";
	}
	public String addQue(){
		System.out.println("TeacherAction.addQue(新添加的题目的 信息是：)"+question);
		boolean flag = teService.addQue(question);
		if(flag){
			return "addQueOk";
		}
		return "addQueFalse";
	}
	public String toupdateQue(){
		subList = teService.findAllSub();
		question = teService.findQueById(question.getId());
		return "toupdateQue";
	}
	public String updateQue(){
		boolean flag = teService.updateQue(question);
		return "addQueOk";
	}
	public String deleteQue(){
		boolean flag  = teService.deleteQue(question.getId());
		return "addQueOk";
	}
	public  String setExam(){
		boolean flag = teService.saveSetExam(setExam);
		if(flag){
			return "setExamOk";
		}
		meg="保存失败，请重新设定考试信息 ";
		return "setExamFalse";
	}
	
	
	
	
	public TeacherService getTeService() {
		return teService;
	}

	public void setTeService(TeacherService teService) {
		this.teService = teService;
	}



	public List<Student> getStuList() {
		return stuList;
	}



	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public List<Clazz> getCalzzList() {
		return calzzList;
	}



	public void setCalzzList(List<Clazz> calzzList) {
		this.calzzList = calzzList;
	}
	public String getMeg() {
		return meg;
	}
	public void setMeg(String meg) {
		this.meg = meg;
	}
	public List<Subject> getSubList() {
		return subList;
	}
	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<Question> getQueList() {
		return queList;
	}
	public void setQueList(List<Question> queList) {
		this.queList = queList;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public SetExam getSetExam() {
		return setExam;
	}
	public void setSetExam(SetExam setExam) {
		this.setExam = setExam;
	}
	
}
