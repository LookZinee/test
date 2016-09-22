package cn.sxt.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.vo.Result;
import cn.sxt.vo.Student;
import cn.sxt.vo.Subject;

public class ServiceTest {
	@Test
	public void createDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport sc = new SchemaExport(cfg);
		sc.create(true, true);
	}
	
	@Test
	public void  testSet(){
		Set<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("6");
		set.add("7");
		set.add("8");
		set.add("9");
		set.add("10");
		
		System.out.println("===================");
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println("=================");
		for (String string : set) {
			System.out.println(string);
		}
	}
	
}
