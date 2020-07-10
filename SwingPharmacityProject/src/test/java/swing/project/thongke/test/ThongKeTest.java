package swing.project.thongke.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.dao.DuocPhamDAO;
import swing.project.dao.HoaDonDAO;
import swing.project.dao.ThongKeHoaDonDAO;
import swing.project.dao.impl.ChiTietHoaDonDAOImpl;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.dao.impl.HoaDonDAOImpl;
import swing.project.dao.impl.ThongKeHoaDonDAOImpl;
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
	ThongKeHoaDonDAO thongKeHoaDonDAO=new ThongKeHoaDonDAOImpl();
	@Test
	public void thongKeTest() {
		
		LocalDate date = LocalDate.of(2000,4, 19);
		LocalDate date1 = LocalDate.of(2000,5, 20);
		
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyy");
	    
	    String text = date.format(formatters);
	    String text1 = date1.format(formatters);
	    
	    LocalDate parsedDate = LocalDate.parse(text, formatters);
	    LocalDate parsedDate1 = LocalDate.parse(text1, formatters);
	    
		LoaiDuocPham loaiDuocPham=new LoaiDuocPham("Đau đầu");
		
		NhaCungCap nhaCungCap=new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(123l);
		nhaCungCap.setTenNhaCungCap("Akamaot");
		nhaCungCap.setXuatXu(new XuatXu("My"));	
		
		
		DuocPham dp1=new DuocPham(35l, "pharmtis", 10, 5000, 10000,"Hop", parsedDate,parsedDate, parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);
		DuocPham dp2=new DuocPham(12l, "Uestasa", 10, 5000, 10000,"Hop", parsedDate,parsedDate, parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);	
		DuocPham dp3=new DuocPham(15l, "Najyraky", 10, 5000, 1000,"Hop",parsedDate,parsedDate,parsedDate, "Thuoc khang sinh",loaiDuocPham,nhaCungCap);	
		
		KhachHang khachHang=new KhachHang( "Phong", 1);
		NhanVien nhanVien=new NhanVien(18042041l, "Phong", "0358984752", "BRVT");
		
		KhachHang khachHang1=new KhachHang( "Huy", 1);
		NhanVien nhanVien1=new NhanVien(18042047l, "Hien", "0358984752", "BRVT");
		
		HoaDon hoaDon=new HoaDon();
		hoaDon.setMaHoaDon(126l);
		hoaDon.setNgayLapHoaDon(parsedDate);
		hoaDon.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon.setSoLuongDuocPham(2);
		hoaDon.setTongTien(dp1.tongTienDuocPham()+dp2.tongTienDuocPham());
		hoaDon.setKhachHang(khachHang);
		hoaDon.setNhanVien(nhanVien);
		
		
		HoaDon hoaDon1=new HoaDon();
		hoaDon1.setMaHoaDon(467l);
		hoaDon1.setNgayLapHoaDon(parsedDate1);
		hoaDon1.setGhiChu("Đọc kỹ hướng dẫn trước khi sử dụng");
		hoaDon1.setSoLuongDuocPham(3);
		hoaDon1.setTongTien(dp1.tongTienDuocPham()+dp2.tongTienDuocPham()+dp3.tongTienDuocPham());
		hoaDon1.setKhachHang(khachHang1);
		hoaDon1.setNhanVien(nhanVien1);
		
		
//		hoaDon.getDanhSachDuocPham().add(dp1);
//		hoaDon.getDanhSachDuocPham().add(dp2);
//			
//		dp1.getDanhSachHoaDon().add(hoaDon);
//		dp2.getDanhSachHoaDon().add(hoaDon);
		
		ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon(2, hoaDon, dp1);
		int soLuong=chiTietHoaDon.capNhatSoLuongTrongKho();
		
		ChiTietHoaDon chiTietHoaDon1=new ChiTietHoaDon(2, hoaDon, dp2);	
		ChiTietHoaDon chiTietHoaDon2=new ChiTietHoaDon(2, hoaDon1, dp1);
		ChiTietHoaDon chiTietHoaDon3=new ChiTietHoaDon(2, hoaDon1, dp2);
		ChiTietHoaDon chiTietHoaDon4=new ChiTietHoaDon(2, hoaDon1, dp3);
		
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
		
		int soLuongTrongKho=chiTietHoaDon.capNhatSoLuongTrongKho();
		DuocPham duocPham=duocPhamDAO.timDuocPhamTheoMa(35l);
		System.out.println(duocPham);
		chiTietHoaDonDAO.capNhapSoLuongTrongKho(dp1.getMaDuocPham(), soLuongTrongKho);
		
		double thanhTienTrongNgay=thongKeHoaDonDAO.tinhThanhTienTheoNgay(19,4,2000);
		System.out.println("Tinh thanh tien trong ngay"+thanhTienTrongNgay);
		
		double thanhTienTrongThang=thongKeHoaDonDAO.tinhThanhTienTheoThang(4,2000);
		System.out.println("Tinh thanh tien trong thang :"+thanhTienTrongThang);
		
		double thanhTienTrongNam=thongKeHoaDonDAO.tinhThanhTienTheoNam(2000);
		System.out.println("Tinh thanh tien trong nam :"+thanhTienTrongNam);
		
		long soLuongTrongNgay=thongKeHoaDonDAO.demSoLuongHoaDonTheoNgay(19,4,2000);
		System.out.println("So luong trong ngay :"+ soLuongTrongNgay);
		
		long soLuongTrongThang=thongKeHoaDonDAO.demSoLuongHoaDonTheoThang(4,2000);
		System.out.println("So luong trong thang :"+ soLuongTrongThang);
		
		long soLuongTrongNam=thongKeHoaDonDAO.demSoLuongHoaDonTheoNam(2000);
		System.out.println("So luong trong nam :"+ soLuongTrongNam);
		
		
		
	}
}
