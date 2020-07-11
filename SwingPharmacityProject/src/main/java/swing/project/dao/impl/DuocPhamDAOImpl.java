package swing.project.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.DuocPhamDAO;
import swing.project.entity.DuocPham;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.hibernate.HibernateUtil;

public class DuocPhamDAOImpl implements DuocPhamDAO{
	
	public DuocPhamDAOImpl() {
		
	}
	@Override	
	public boolean themDuocPham(DuocPham duocPham) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            session.persist(duocPham);       
            transaction.commit();  
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return false;
	}

	@Override
	public DuocPham timDuocPhamTheoMa(Long maDuocPham) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            Query query=session.createQuery("FROM DuocPham d WHERE d.maDuocPham=:duocpham_id ")
            			.setParameter("duocpham_id", maDuocPham);   
            DuocPham duocPham=(DuocPham) query.getSingleResult();
            transaction.commit();   
            return duocPham;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return null;
	}
	
	@Override
	public List<DuocPham> timDuocPhamTen(String tenDuocPham) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            Query query=session.createQuery("FROM DuocPham d WHERE d.tenDuocPham like '%s%'");
            			  
            List<DuocPham> danhSachDuocPham=query.getResultList();
            transaction.commit();   
            return danhSachDuocPham;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return null;
	}
	
	

	@Override
	public List<DuocPham> getDanhSachDuocPham() {
		Transaction transaction = null;
	Session session=null;
	
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            Query query=session.createQuery("FROM DuocPham");
            List<DuocPham> result=query.getResultList();
            transaction.commit();  
            return result;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return null;	
	}
	
	
	@Override
	public boolean xoaDuocPham(Long maDuocPham) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            Query query=session.createQuery("DELETE FROM DuocPham d WHERE d.maDuocPham=:duocpham_id ")
            			.setParameter("duocpham_id", maDuocPham);   
            int result=query.executeUpdate();
            System.out.println("Cột đã bị xóa :" + result);
            transaction.commit();   
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return false;
	}
	
	@Override
	public boolean xoaDuocPhamTheoTen(String tenDuocPham) {	
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            String hql = "DELETE FROM DuocPham "  + 
                    "WHERE tenDuocPham = :duocpham_id";
	       Query query = session.createQuery(hql);
	       query.setParameter("duocpham_id", tenDuocPham);
	       int result = query.executeUpdate();
	       System.out.println("Cột bị xóa: " + result);      
            transaction.commit();  
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return false;
	}
	
	// sửa dược phẩm có thể lấy dữ liệu từ model truyền vào parameter trong hàm suaDuocPham.
	@Override
	public boolean suaDuocPham(DuocPham duocPham) {	
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();                    
            session.saveOrUpdate(duocPham);
            transaction.commit();  
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }	
		return false;
	}
	@Override
	public boolean themLoaiDuocPham(LoaiDuocPham loaiDuocPham) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            session.persist(loaiDuocPham);       
            transaction.commit();  
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return false;
	}
	@Override
	public boolean themNhaCungCap(NhaCungCap nhaCungCap) {
		Transaction transaction = null;
		Session session=null;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            session.persist(nhaCungCap);       
            transaction.commit();  
            return true;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return false;
	}
	
}
