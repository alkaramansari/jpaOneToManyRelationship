package alkaram.javatpoint;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("alkaram");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Payment p1=new Payment();
		
		p1.setCustomername("alkaram 1");
		p1.setAmount(1000);
		
		Booking b1=new Booking();
		b1.setSeatno("a2");
		b1.setPayment(p1);
		
		p1.setBooking(b1);

		
		em.persist(p1);
		et.commit();

		System.out.println(p1.getPaymentid()+", "+
		p1.getCustomername()+", "+p1.getAmount());

		et.begin();
		
		List<Booking> list=em.createQuery("select b from Booking b "+
		" where b.bookingid="+p1.getPaymentid()).getResultList();
		Booking b=list.get(0);
		System.out.println(b.getBookingid()+", "+
		b.getSeatno());
		
		et.commit();
		
		et.begin();
		String query="select p "+
		" from Payment p, Booking b "+
				" where p.paymentid=b.bookingid";
		List<Payment> list1=em.createQuery(query).getResultList();
		for(Payment p  : list1) {
			System.out.println(p.getPaymentid()+", "+
		p.getCustomername()+", "+
		p.getBooking().getSeatno()+", "+
		p.getBooking().getBookingid());
		}
		et.commit();
	}
}
