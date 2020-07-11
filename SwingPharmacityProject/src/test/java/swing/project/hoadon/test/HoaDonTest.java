package swing.project.hoadon.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.dao.HoaDonDAO;
import swing.project.dao.impl.ChiTietHoaDonDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.entity.ChiTietHoaDon;
import swing.project.entity.DuocPham;
import swing.project.entity.HoaDon;
import swing.project.entity.KhachHang;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.NhanVien;
import swing.project.entity.XuatXu;
import swing.project.hibernate.HibernateUtil;

public class HoaDonTest {
	
	HoaDonDAO hoaDonDAOImpl=new HoaDonDAOImpl();
	ChiTietHoaDonDAO chiTietHoaDonDaoImpl=new ChiTietHoaDonDAOImpl();

	@Test
	public void hoaDonTest() {		
		LocalDate date = LocalDate.of(2000,4, 19);
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyy");
	    String text = date.format(formatters);
	    LocalDate parsedDate = LocalDate.parse(text, formatters);
	    
		LoaiDuocPham loaiDuocPham=new LoaiDuocPham("Đau đầu");
		
		NhaCungCap nhaCungCap=new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(123l);
		nhaCungCap.setTenNhaCungCap("Akamaot");
		nhaCungCap.setXuatXu(new XuatXu("My"));	
		
		
		DuocPham dp1=new DuocPham(35l, "pharmtis", 5, 10000, 12000,"Hop", parsedDate,parsedDate, parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);
		DuocPham dp2=new DuocPham(12l, "Uestasa", 5, 10000, 13000,"Hop", parsedDate,parsedDate, parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);	
		DuocPham dp3=new DuocPham(15l, "Najyraky", 7, 10000, 15000,"Hop",parsedDate,parsedDate,parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);	
		
		KhachHang khachHang=new KhachHang("Phong", "1");
		NhanVien nhanVien=new NhanVien(18042041l, "Phong", "0358984752", "BRVT");
		
		KhachHang khachHang1=new KhachHang("Huy", "1");
		NhanVien nhanVien1=new NhanVien(18042047l, "Hien", "0358984752", "BRVT");
		
		HoaDon hoaDon=new HoaDon();
		hoaDon.setMaHoaDon(126l);
		hoaDon.setNgayLapHoaDon(parsedDate);
		hoaDon.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon.setSoLuongDuocPham(2);
		hoaDon.setTongTien(5000l);
		hoaDon.setKhachHang(khachHang);
		hoaDon.setNhanVien(nhanVien);
		
		
		HoaDon hoaDon1=new HoaDon();
		
		hoaDon1.setMaHoaDon(467l);
		hoaDon1.setNgayLapHoaDon(parsedDate);
		hoaDon1.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon1.setSoLuongDuocPham(3);
		hoaDon1.setTongTien(5000l);
		hoaDon1.setKhachHang(khachHang1);
		hoaDon1.setNhanVien(nhanVien1);
		
		
//		hoaDon.getDanhSachDuocPham().add(dp1);
//		hoaDon.getDanhSachDuocPham().add(dp2);
//			
//		dp1.getDanhSachHoaDon().add(hoaDon);
//		dp2.getDanhSachHoaDon().add(hoaDon);
		
		ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon(5, hoaDon, dp1);
		ChiTietHoaDon chiTietHoaDon1=new ChiTietHoaDon(5, hoaDon, dp2);	
		ChiTietHoaDon chiTietHoaDon2=new ChiTietHoaDon(10, hoaDon1, dp1);
		ChiTietHoaDon chiTietHoaDon3=new ChiTietHoaDon(10, hoaDon1, dp2);
		ChiTietHoaDon chiTietHoaDon4=new ChiTietHoaDon(20, hoaDon1, dp3);
		
		Transaction transaction = null;		
		Session session=null;
		try {
            // mở một session
			session = HibernateUtil.getSessionFactory().openSession();
			// bắt đầu một transaction
            transaction = session.beginTransaction(); 
            session.persist(dp1);
            session.persist(dp2);
            session.persist(dp3);
            session.persist(hoaDon);    
            session.persist(hoaDon1);    
            session.persist(chiTietHoaDon);   
            session.persist(chiTietHoaDon1);
            session.persist(chiTietHoaDon2);   
            session.persist(chiTietHoaDon3);
            session.persist(chiTietHoaDon4);   
           
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Tìm kiếm danh sách hóa đơn theo tên khách hàng");
            Query query=session.createQuery("SELECT hd FROM HoaDon hd INNER JOIN hd.khachHang kh WHERE kh.tenKhachHang=:tenKhachHang")
            		.setParameter("tenKhachHang", "huy")
            		;
            List<HoaDon> result=query.getResultList();    
            for (HoaDon hoaDon2 : result) {
				System.out.println(hoaDon2.toString());
			}
            
       
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Danh sách chi tiết hóa đơn ");
            query=session.createQuery("FROM ChiTietHoaDon");    			  
            List<ChiTietHoaDon> danhSachChiTietHoaDon=(List<ChiTietHoaDon>) query.getResultList();           
            for (ChiTietHoaDon chiTietHoaDon5 : danhSachChiTietHoaDon) {
				System.out.println(chiTietHoaDon5);
			}
            
            
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Tìm kiếm chi tiết hóa đơn theo mã hóa đơn");
            List<ChiTietHoaDon> chiTietHoaDonTheoMaHoaDon=chiTietHoaDonDaoImpl.getDanhSachChiTietHoaDonTheoMaHoaDon(126l);
            for (ChiTietHoaDon chiTietHoaDon5 : chiTietHoaDonTheoMaHoaDon) {
				System.out.println(chiTietHoaDon5);
			}
                 
            // Nếu một transaction được thông qua thì commit dữ liệu lên databases
            transaction.commit();     
        } catch (Exception e) {  
        	// Nếu xảy ra lỗi dữ liệu được roolback(trả dữ liệu về không commit tới database). 
        	transaction.rollback();
            e.printStackTrace();            
        } finally {
        	// kết thúc một session(một phiên thực hiện)
        	session.close();
        }		
		
	}
}
