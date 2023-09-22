package alkaram.javatpoint;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Application1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory=Persistence.createEntityManagerFactory("alkaram");
		EntityManager em=factory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		/*
		et.begin();
		Emp emp=new Emp();
		emp.setName("ajay 2");
		emp.setSalary(20000);
		em.persist(emp);
		System.out.println("1 record inserted");
		et.commit();
		
		et.begin();
		Emp emp=em.find(Emp.class, 5);
		System.out.println(emp.getEmpid()+", "+
		emp.getName()+", "+emp.getSalary());
		et.commit();
		
		
		et.begin();
		Emp emp=em.find(Emp.class, 10);
		em.remove(emp);
		et.commit();
		System.out.println("10 id removed");
		*/
		
		Query query=em.createQuery("select e from Emp e");
		List<Emp> emps=query.getResultList();
		for(Iterator<Emp> itr=emps.iterator();
				itr.hasNext()==true;) {
			Emp emp2=itr.next();
			String str=String.format("%d \t %-20s \t %12.2f",
					emp2.getEmpid(), emp2.getName(), emp2.getSalary());
			
			System.out.println(str);
		}
		
		Query query2=em.createQuery("select upper(e.name) from Emp e");
		List<String> list=query2.getResultList();
		for(String element : list) {
			System.out.println(element);
		}
		
		Query query3=em.createQuery("select sum(e.salary) from Emp e");
		List<Object> list2=query3.getResultList();
		double sumsalary=(Double)list2.get(0);
		System.out.println("total sum salary given Rs."+sumsalary);
		
		
		
		
	}

}
