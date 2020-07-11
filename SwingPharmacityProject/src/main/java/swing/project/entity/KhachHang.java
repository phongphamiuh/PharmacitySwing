package swing.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class KhachHang {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long maKhachHang;
	
	@Column
	private String tenKhachHang;
	
	@Column
	private String soDienThoai;
	
	
	@OneToMany(mappedBy="khachHang", orphanRemoval = true,cascade=CascadeType.ALL)
	private Set<HoaDon> danhSachHoaDon=new HashSet<HoaDon>();
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String tenKhachHang, String soDienThoai) {
		super();
		
		this.tenKhachHang = tenKhachHang;
		
		this.soDienThoai = soDienThoai;
	
	}


	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Set<HoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}

	public void setDanhSachHoaDon(Set<HoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", danhSachHoaDon=" + danhSachHoaDon + "]";
	}
	
	
	
	
}
