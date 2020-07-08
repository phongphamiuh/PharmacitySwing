package swing.project.duocpham.test;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import swing.project.entity.NhaCungCap;
import swing.project.entity.XuatXu;
import swing.project.hibernate.HibernateUtil;

public class OneToManyDuocPham {
	
	@Test
	public void embbededTest() {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
                     
            transaction.commit();   
           
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
	}
	
}
