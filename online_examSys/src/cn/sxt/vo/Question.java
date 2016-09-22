package cn.sxt.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_question")
public class Question implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private char answer;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	private int degree;
	@ManyToOne
	@JoinColumn(name="subid")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name="stuid")
	private Student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer;
	}
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	public String getOptionb() {
		return optionb;
	}
	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}
	public String getOptionc() {
		return optionc;
	}
	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}
	public String getOptiond() {
		return optiond;
	}
	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Question(String title, char answer, String optiona, String optionb,
			String optionc, String optiond, int degree, Subject subject) {
		super();
		this.title = title;
		this.answer = answer;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.degree = degree;
		this.subject = subject;
	}
	public Question() {
		super();
	}
	@Override
	public String toString() {
		return "Question [title=" + title + ", answer=" + answer + ", optiona="
				+ optiona + ", optionb=" + optionb + ", optionc=" + optionc
				+ ", optiond=" + optiond + ", degree=" + degree + ", subject="
				+ subject + ", student=" + student + "]";
	}
	
	
	
}
