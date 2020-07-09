package swing.project.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class HoaDon {
	
	@Id
	@Column
	private Long maHoaDon;
	
	@Column	
	private LocalDate ngayLapHoaDon;
	
	@Column
	private int soLuongDuocPham;
	
	@Column
	private double tongTien;
	
	@Column
	private String ghiChu;
	
//	@ManyToMany(mappedBy="danhSachHoaDon")
//	private Set<DuocPham> danhSachDuocPham=new HashSet<DuocPham>();
	
	@OneToMany(mappedBy="hoaDon")
	private Set<ChiTietHoaDon> chiTietHoaDon=new HashSet<ChiTietHoaDon>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private KhachHang khachHang;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private NhanVien nhanVien;
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public Long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public int getSoLuongDuocPham() {
		return soLuongDuocPham;
	}

	public void setSoLuongDuocPham(int soLuongDuocPham) {
		this.soLuongDuocPham = soLuongDuocPham;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

//	public Set<DuocPham> getDanhSachDuocPham() {
//		return danhSachDuocPham;
//	}
//
//	public void setDanhSachDuocPham(Set<DuocPham> danhSachDuocPham) {
//		this.danhSachDuocPham = danhSachDuocPham;
//	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	

	public Set<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(Set<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public HoaDon(Long maHoaDon, LocalDate ngayLapHoaDon, int soLuongDuocPham, double tongTien, String ghiChu,
		 KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.soLuongDuocPham = soLuongDuocPham;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
//		this.danhSachDuocPham = danhSachDuocPham;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}



	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", soLuongDuocPham="
				+ soLuongDuocPham + ", tongTien=" + tongTien + ", ghiChu=" + ghiChu + ", danhSachDuocPham="
				 + ", khachHang=" + khachHang.getMaKhachHang() + ", nhanVien=" + nhanVien.getMaNhanVien() + "]";
	}
	
	

	
}
