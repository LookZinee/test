package cn.sxt.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_setexam")
public class SetExam implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int questionnum;
	private int degree;
	private int examtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionnum() {
		return questionnum;
	}
	public void setQuestionnum(int questionnum) {
		this.questionnum = questionnum;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getExamtime() {
		return examtime;
	}
	public void setExamtime(int examtime) {
		this.examtime = examtime;
	}
	public SetExam(int questionnum, int degree, int examtime) {
		super();
		this.questionnum = questionnum;
		this.degree = degree;
		this.examtime = examtime;
	}
	public SetExam() {
		super();
	}
	
	
}
