package swing.project.dao;

import java.util.List;

import swing.project.entity.DuocPham;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;

public interface DuocPhamDAO {
	
	public boolean themDuocPham(DuocPham duocPham);
	
	public boolean xoaDuocPham(Long maDuocPham);
	
	public boolean xoaDuocPhamTheoTen(String tenDuocPham);
	
	public boolean suaDuocPham(DuocPham duocPham);
	
	public DuocPham timDuocPhamTheoMa(Long maDuocPham);
	
	public List<DuocPham> timDuocPhamTen(String maDuocPham);
	
	public List<DuocPham> getDanhSachDuocPham();
	
	public boolean themLoaiDuocPham(LoaiDuocPham loaiDuocPham);
	
	public boolean themNhaCungCap(NhaCungCap nhaCungCap);
}
