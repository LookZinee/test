package cn.sxt.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_xiangqing")
public class XiangQing implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="resultid")
	private Result result;
	@ManyToOne
	@JoinColumn(name="questionid")
	private Question question;
	private char choseanswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public char getChoseanswer() {
		return choseanswer;
	}
	public void setChoseanswer(char choseanswer) {
		this.choseanswer = choseanswer;
	}
	
	

	public XiangQing(Result result, Question question, char choseanswer) {
		super();
		this.result = result;
		this.question = question;
		this.choseanswer = choseanswer;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public XiangQing() {
		super();
	}

	
}
