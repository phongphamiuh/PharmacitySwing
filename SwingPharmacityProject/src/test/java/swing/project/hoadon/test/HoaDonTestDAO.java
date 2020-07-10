package swing.project.hoadon.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.dao.DuocPhamDAO;
import swing.project.dao.HoaDonDAO;
import swing.project.dao.impl.ChiTietHoaDonDAOImpl;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.entity.ChiTietHoaDon;
import swing.project.entity.DuocPham;
import swing.project.entity.HoaDon;
import swing.project.entity.KhachHang;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.NhanVien;
import swing.project.entity.XuatXu;

public class HoaDonTestDAO {
	DuocPhamDAO duocPhamDAO=new DuocPhamDAOImpl();
	HoaDonDAO hoaDonDAO=new HoaDonDAOImpl();
	ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAOImpl();
	
	@Test
	public void hoaDonTestDAO() {
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
		
		KhachHang khachHang=new KhachHang( "Phong", 1);
		NhanVien nhanVien=new NhanVien(18042041l, "Phong", "0358984752", "BRVT");
		
		KhachHang khachHang1=new KhachHang( "Huy", 1);
		NhanVien nhanVien1=new NhanVien(18042047l, "Hien", "0358984752", "BRVT");
		
		HoaDon hoaDon=new HoaDon();
	
		hoaDon.setNgayLapHoaDon(parsedDate);
		hoaDon.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon.setSoLuongDuocPham(2);
		hoaDon.setTongTien(5000l);
		hoaDon.setKhachHang(khachHang);
		hoaDon.setNhanVien(nhanVien);
		
		
		HoaDon hoaDon1=new HoaDon();
		
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
		
		duocPhamDAO.themDuocPham(dp1);
		duocPhamDAO.themDuocPham(dp2);
		duocPhamDAO.themDuocPham(dp3);
		
		hoaDonDAO.themHoaDon(hoaDon);
		hoaDonDAO.themHoaDon(hoaDon1);
		
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon);
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon1);
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon2);
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon3);
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon4);
		
		 System.out.println("-----------------------------------------------------------------------------------------");
         System.out.println("Tìm kiếm danh sách hóa đơn theo tên khách hàng");
         
         List<HoaDon> danhSachHoaDonTHeoTenKhachHang= hoaDonDAO.getDanhSachHoaDonTheoTenKhachHang("huy");
         for (HoaDon danhSachHoaDon : danhSachHoaDonTHeoTenKhachHang) {
			System.out.println(danhSachHoaDon);
		}
         
         System.out.println("-----------------------------------------------------------------------------------------");
         System.out.println("Tìm kiếm chi tiết hóa đơn theo mã hóa đơn");
         List<ChiTietHoaDon> chiTietHoaDonTheoMaHoaDon=chiTietHoaDonDAO.getDanhSachChiTietHoaDonTheoMaHoaDon(126l);
         for (ChiTietHoaDon chiTietHoaDon5 : chiTietHoaDonTheoMaHoaDon) {
				System.out.println(chiTietHoaDon5);
			}  
         
         
	}
}
