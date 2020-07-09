package swing.project.dao.impl;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.ThongKeHoaDonDAO;
import swing.project.hibernate.HibernateUtil;

public class ThongKeHoaDonDAOImpl implements ThongKeHoaDonDAO{
	// https://www.roseindia.net/hibernate/hibernate-count.shtml
	
	public ThongKeHoaDonDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public double tinhThanhTienTheoNgay(int ngayLap, int thangLap, int namLap) {
		Transaction transaction = null;
		Session session=null;
		double thanhTien=0;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            
            Query query=session.createQuery("SELECT SUM(cthd.soLuong*dp.giaBan) "
            		+ "FROM ChiTietHoaDon cthd "
            		+ "INNER JOIN cthd.duocPham dp "
            		+ "INNER JOIN cthd.hoaDon hd "
            		+ "WHERE day(hd.ngayLapHoaDon)=:ngaylap AND month(hd.ngayLapHoaDon)=:thangLap AND year(hd.ngayLapHoaDon)=:namlap");
            query.setParameter("ngaylap", ngayLap);
            query.setParameter("thangLap", thangLap);
            query.setParameter("namlap", namLap);
            thanhTien=(double) query.getSingleResult();
            
            transaction.commit();  
            return thanhTien;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return thanhTien;
	}
	

	@Override
	public double tinhThanhTienTheoThang(int thangLap, int namLap) {
		Transaction transaction = null;
		Session session=null;
		double thanhTien=0;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            
            Query query=session.createQuery("SELECT SUM(cthd.soLuong*dp.giaBan) "
            		+ "FROM ChiTietHoaDon cthd "
            		+ "INNER JOIN cthd.duocPham dp "
            		+ "INNER JOIN cthd.hoaDon hd "
            		+ "WHERE month(hd.ngayLapHoaDon)=:thangLap AND year(hd.ngayLapHoaDon)=:namlap");
           
            query.setParameter("thangLap", thangLap);
            query.setParameter("namlap", namLap);
            thanhTien=(double) query.getSingleResult();
            
            transaction.commit();  
            return thanhTien;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return thanhTien;
	}
	
	@Override
	public double tinhThanhTienTheoNam(int namLap) {
		Transaction transaction = null;
		Session session=null;
		double thanhTien=0;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            
            Query query=session.createQuery("SELECT SUM(cthd.soLuong*dp.giaBan) "
            		+ "FROM ChiTietHoaDon cthd "
            		+ "INNER JOIN cthd.duocPham dp "
            		+ "INNER JOIN cthd.hoaDon hd "
            		+ "WHERE year(hd.ngayLapHoaDon)=:namlap");                  
            query.setParameter("namlap", namLap);
            thanhTien=(double) query.getSingleResult();          
            transaction.commit();  
            return thanhTien;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return thanhTien;
	}
	
	@Override
	public long demSoLuongHoaDonTheoNgay(int ngayLap, int thangLap, int namLap) {
		Transaction transaction = null;
		Session session=null;
		long soLuong=0l;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            
            Query query=session.createQuery("SELECT COUNT(hd.maHoaDon) "
            		+ "FROM HoaDon hd "
            		+ "WHERE DAY(hd.ngayLapHoaDon)=:ngayLap AND MONTH(hd.ngayLapHoaDon)=:thangLap AND YEAR(hd.ngayLapHoaDon)=:namLap");    
            
            query.setParameter("ngayLap", ngayLap);
            query.setParameter("thangLap",thangLap);
            query.setParameter("namLap",namLap);
            soLuong=(long)query.getSingleResult();
            
            transaction.commit();  
            return soLuong;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return soLuong;
	}
	@Override
	public long demSoLuongHoaDonTheoThang(int thangLap, int namLap) {
		Transaction transaction = null;
		Session session=null;
		long soLuong=0l;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();         
            
            Query query=session.createQuery("SELECT COUNT(hd.maHoaDon) "
            		+ "FROM HoaDon hd "
            		+ "WHERE MONTH(hd.ngayLapHoaDon)=:thangLap AND YEAR(hd.ngayLapHoaDon)=:namLap");                          
            query.setParameter("thangLap",thangLap);
            query.setParameter("namLap",namLap);
            soLuong=(long)query.getSingleResult();
            
            transaction.commit();  
            return soLuong;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return soLuong;
	}
	@Override
	public long demSoLuongHoaDonTheoNam(int namLap) {
		Transaction transaction = null;
		Session session=null;
		long soLuong=0l;
		try {
            // bắt đầu một transaction
			session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();                  
            Query query=session.createQuery("SELECT COUNT(hd.maHoaDon) "
            		+ "FROM HoaDon hd "
            		+ "WHERE YEAR(hd.ngayLapHoaDon)=:namLap");                          
            query.setParameter("namLap",namLap);
            soLuong=(long)query.getSingleResult();
            
            transaction.commit();  
            return soLuong;
        } catch (Exception e) {      
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	session.close();
        }
		return soLuong;
	}
	

}
