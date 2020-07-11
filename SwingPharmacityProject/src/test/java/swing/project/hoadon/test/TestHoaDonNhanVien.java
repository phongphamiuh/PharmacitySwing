package swing.project.hoadon.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.dao.DuocPhamDAO;
import swing.project.dao.HoaDonDAO;
import swing.project.dao.impl.ChiTietHoaDonDAOImpl;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.entity.DuocPham;
import swing.project.entity.HoaDon;
import swing.project.entity.KhachHang;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.NhanVien;
import swing.project.entity.XuatXu;

public class TestHoaDonNhanVien {
	DuocPhamDAO duocPhamDAO=new DuocPhamDAOImpl();
	HoaDonDAO hoaDonDAO=new HoaDonDAOImpl();
	ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAOImpl();
	
	@Test
	public void hoaDonNhanVien() {
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
		KhachHang khachHang1=new KhachHang("Huy", 1);
		
		
		
		
		HoaDon hoaDon=new HoaDon();
		hoaDon.setMaHoaDon(48l);
		hoaDon.setNgayLapHoaDon(parsedDate);
		hoaDon.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon.setSoLuongDuocPham(2);
		hoaDon.setTongTien(5000l);
		hoaDon.setKhachHang(khachHang);
		hoaDon.setNhanVien(nhanVien);
		nhanVien.getDanhSachHoaDon().add(hoaDon);	
		khachHang.getDanhSachHoaDon().add(hoaDon);
		
		
		NhanVien nhanVienTim=hoaDonDAO.timNhanVienTheoMaNhanVien(18042041l);
		
		HoaDon hoaDon1=new HoaDon();
		hoaDon1.setMaHoaDon(49l);
		hoaDon1.setNgayLapHoaDon(parsedDate);
		hoaDon1.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon1.setSoLuongDuocPham(2);
		hoaDon1.setTongTien(5000l);
		hoaDon.setKhachHang(khachHang1);
		hoaDon1.setNhanVien(nhanVienTim);
		nhanVien.getDanhSachHoaDon().add(hoaDon1);
		khachHang.getDanhSachHoaDon().add(hoaDon);
		
		hoaDonDAO.themHoaDon(hoaDon);
		hoaDonDAO.themHoaDon(hoaDon1);
		assertEquals(nhanVien.getDanhSachHoaDon().size(), 2);
		
		
		
	}
}
