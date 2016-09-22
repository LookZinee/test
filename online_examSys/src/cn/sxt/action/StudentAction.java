package cn.sxt.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import cn.sxt.service.StudentService;
import cn.sxt.vo.Clazz;
import cn.sxt.vo.Question;
import cn.sxt.vo.Result;
import cn.sxt.vo.SetExam;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class StudentAction {
	private StudentService stuService;
	private List<Student> stuList;
	private Student student;
	private List<Clazz> calzzList;
	private List<Subject> subList;
	private String meg;
	private Subject subject;
	private SetExam setExam;
	private List<Question> questions;
	private String tihao;
	private List<Result> resultList;
	private Result result;
	
	
	public String list(){
		System.out.println("查询到的学生的人数为："+stuService.findAll().size());
		return Action.SUCCESS;
	}
	//登录 
	public String login(){
		System.out.println("用户名："+student.getName());
		System.out.println("密码："+student.getPwd());
		student = stuService.login(student.getName(),student.getPwd(),student.getRole());
		if(student != null){
			ServletActionContext.getRequest().getSession().setAttribute("currentStudent", student);
			return Action.SUCCESS;
		}
		return "login_defeat";
	}
	
	public String tosignup(){
		calzzList = stuService.findAllClazz();
		return "tosignup";
		
	}
	
	public String signup(){
		boolean flag = stuService.save(student);
		if(flag){
			meg="";
			return Action.SUCCESS;
		}
		meg = "您填写的信息不符合规则，请重新输入";
		return "signup_false";
	}
	//查询所有的学生信息
	public String findAll(){
		stuList = stuService.findAll();
		calzzList = stuService.findAllClazz();
		return "findall";
	}
	public String tokaoshi(){
		subList = stuService.findAllSubject();
		return "tokaoshi";
	}
	public String kaoshi(){
		subject = stuService.findSubById(subject.getId());
		questions = stuService.getQuestions(subject.getId());
		tihao = stuService.getTiHao(questions);
		setExam = stuService.findSetEeam();
		return "kaoshi";
	}
	public String result(){
		//获得刚才每个题的题号
		String[] tihaos = stuService.getEveryTihao(tihao);
		HttpServletRequest request = ServletActionContext.getRequest();
		int score = 0;
		setExam = stuService.findSetEeam();
		String uuid = UUID.randomUUID().toString();
		//保存result
		int  resultid = stuService.getResultId(subject.getId());
		for (String string : tihaos) {
			System.out.println("StudentAction.result(题号的id是)-----"+string);
			String str = request.getParameter("question"+string);
			System.out.println("str=="+str);
			char rightAnswer = stuService.getRightAnswer(Integer.parseInt(string));
			System.out.println(rightAnswer);
			if(str.trim() != ""){
				if(str.charAt(0) == rightAnswer){
					
					score+=(100/setExam.getQuestionnum());
				}
			}
			
			stuService.saveXiangQing(resultid,Integer.parseInt(string),str.charAt(0));
		}
		stuService.updateResult(resultid,score);
		return "result";
	}
	
	public String findallexam(){
		resultList = stuService.findAllResult();
		return "findallexam" ;
	}
	public String findxiangqing(){
		result = stuService.findXiangQing(result.getId());
		return "findxiangqing";
	}
	
	
	public StudentService getStuService() {
		return stuService;
	}
	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
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
	public SetExam getSetExam() {
		return setExam;
	}
	public void setSetExam(SetExam setExam) {
		this.setExam = setExam;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getTihao() {
		return tihao;
	}
	public void setTihao(String tihao) {
		this.tihao = tihao;
	}
	public List<Result> getResultList() {
		return resultList;
	}
	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	
}
