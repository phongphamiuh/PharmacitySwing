package swing.project.dao;

import java.util.List;

import swing.project.entity.ChiTietHoaDon;
import swing.project.entity.HoaDon;

public interface HoaDonDAO {
	public boolean themHoaDon(HoaDon hoaDon);
	
	public boolean xoaHoaDon(Long maHoaDon);
		
	public HoaDon timHoaDonTheoMa(Long maHoaDon);
	
	public List<HoaDon> getDanhSachHoaDon();
	
	public List<HoaDon> getDanhSachHoaDonTheoTenKhachHang(String tenKhachHang);
	

}