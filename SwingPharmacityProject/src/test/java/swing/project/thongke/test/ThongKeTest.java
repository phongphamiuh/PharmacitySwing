package swing.project.thongke.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

public class ThongKeTest {
	DuocPhamDAO duocPhamDAO=new DuocPhamDAOImpl();
	HoaDonDAO hoaDonDAO=new HoaDonDAOImpl();
	ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAOImpl();
	@Test
	public void thongKeTest() {
		
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
		
		
			
		KhachHang khachHang=new KhachHang(123l, "Phong", 1);
		NhanVien nhanVien=new NhanVien(18042041l, "Phong", "0358984752", "BRVT");
		
		KhachHang khachHang1=new KhachHang(1289l, "Huy", 1);
		NhanVien nhanVien1=new NhanVien(18042047l, "Hien", "0358984752", "BRVT");
		
		HoaDon hoaDon=new HoaDon();
		hoaDon.setMaHoaDon(126l);
		
		hoaDon.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon.setSoLuongDuocPham(2);
		hoaDon.setTongTien(5000l);
		hoaDon.setKhachHang(khachHang);
		hoaDon.setNhanVien(nhanVien);
		
		
		HoaDon hoaDon1=new HoaDon();
		hoaDon1.setMaHoaDon(467l);
		
		hoaDon1.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon1.setSoLuongDuocPham(3);
		hoaDon1.setTongTien(5000l);
		hoaDon1.setKhachHang(khachHang1);
		hoaDon1.setNhanVien(nhanVien1);		
	
		ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon(5, hoaDon, dp1);
		
		
		duocPhamDAO.themDuocPham(dp1);
		
	}
}
