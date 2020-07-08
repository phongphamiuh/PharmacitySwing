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
public class KhachHang {
	
	@Id
	@Column
	private Long maKhachHang;
	
	@Column
	private String tenKhachHang;
	
	@Column
	private int soDienThoai;
	
	@OneToMany(mappedBy="khachHang")
	private Set<HoaDon> danhSachHoaDon=new HashSet<HoaDon>();
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(Long maKhachHang, String tenKhachHang, int soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		
		this.soDienThoai = soDienThoai;
	
	}

	public Long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(Long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}


	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Set<HoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}

	public void setDanhSachHoaDon(Set<HoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}
	
	
	
}
