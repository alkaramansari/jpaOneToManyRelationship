package alkaram.javatpoint;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application3 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("alkaram");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Student s1=new Student();
		s1.setName("ajay narang");
		
		Address a1=new Address();
		a1.setDetails("bhopal");
		Address a2=new Address();
		a2.setDetails("indore");
		Address a3=new Address();
		a3.setDetails("jabalpur");
		
		

		s1.getAddresses().add(a1);
		s1.getAddresses().add(a2);
		s1.getAddresses().add(a3);
		
		em.persist(s1);
		et.commit();
		System.out.println(s1.getStudentid()+" inserted");
		
		et.begin();
		List<Student> list=em.createQuery("select s from "+
		" Student s")
				.getResultList();
		for(Student s : list) {
			System.out.println(s.getStudentid()+", "+
		s.getName());
			System.out.println("...............");
			List<Address> lista=s.getAddresses();
			for(Address a : lista) {
				System.out.println(a.getAid()+", "+
			a.getDetails());
			}
		}
		
		et.commit();
		
	}
}
