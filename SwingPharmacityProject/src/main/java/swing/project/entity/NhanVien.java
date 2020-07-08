package swing.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class NhanVien {
	
	@Id
	@Column
	private Long maNhanVien;
	
	@Column 
	private String tenNhanVien;
	
	@Column 
	private String soDienThoai;
	
	@Column 
	private String diaChi;
	
	@OneToMany(mappedBy="nhanVien")
	Set<HoaDon> danhSachHoaDon=new HashSet<HoaDon>();
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(Long maNhanVien, String tenNhanVien, String soDienThoai, String diaChi
			) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		
	}

	public Long getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Set<HoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}

	public void setDanhSachHoaDon(Set<HoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}

	public NhanVien(Long maNhanVien, String tenNhanVien, String soDienThoai, String diaChi, Set<HoaDon> danhSachHoaDon) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.danhSachHoaDon = danhSachHoaDon;
	}

	
}
