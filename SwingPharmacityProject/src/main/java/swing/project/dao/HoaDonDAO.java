package swing.project.dao;

import java.util.List;

import swing.project.entity.HoaDon;
import swing.project.entity.KhachHang;
import swing.project.entity.NhanVien;

public interface HoaDonDAO {
	
	public boolean themHoaDon(HoaDon hoaDon);
	
	public boolean themKhachHang(KhachHang khachHang);
	
	public boolean xoaHoaDon(Long maHoaDon);
		
	public HoaDon timHoaDonTheoMa(Long maHoaDon);
	
	public boolean suaHoaDon(HoaDon hoaDon);
	
	public List<HoaDon> getDanhSachHoaDon();
	
	public List<HoaDon> getDanhSachHoaDonTheoTenKhachHang(String tenKhachHang);
	
	public NhanVien timNhanVienTheoMaNhanVien(Long maNhanVien);
	
	public boolean themNhanVien(NhanVien nhanVien);

	
	
	
}
