package cn.sxt.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_result")
public class Result implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="stuid")
	private Student student;
	@ManyToOne
	@JoinColumn(name="subid")
	private Subject subject;
	private Date testtime;
	private int usetime;
	private int score;
	@OneToMany
	@JoinColumn(name="resultid")
	private Set<XiangQing> xiangqings;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public Result(Student student, Subject subject, Date testtime, int usetime,
			int score) {
		super();
		this.student = student;
		this.subject = subject;
		this.testtime = testtime;
		this.usetime = usetime;
		this.score = score;
	}
	public Result() {
		super();
	}
	public Date getTesttime() {
		return testtime;
	}
	public void setTesttime(Date testtime) {
		this.testtime = testtime;
	}
	public int getUsetime() {
		return usetime;
	}
	public void setUsetime(int usetime) {
		this.usetime = usetime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Set<XiangQing> getXiangqings() {
		return xiangqings;
	}
	public void setXiangqings(Set<XiangQing> xiangqings) {
		this.xiangqings = xiangqings;
	}
	
	
}
