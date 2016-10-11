package cn.sxt.vo;
/**
 * 学生表  t_student
id
name
sex
pwd
age
classId
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="t_student")
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String sex;
	private String pwd;
	private int age;
	private int role;
	@ManyToOne
	@JoinColumn(name="clazzid")
	private Clazz clazz;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Student(String name, String sex, String pwd, int age, Clazz clazz) {
		super();
		this.name = name;
		this.sex = sex;
		this.pwd = pwd;
		this.age = age;
		this.clazz = clazz;
	}
	public Student() {
		super();
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", pwd=" + pwd + ", age=" + age + ", role=" + role
				+ ", clazz=" + clazz + "]";
	}
	
	
}
