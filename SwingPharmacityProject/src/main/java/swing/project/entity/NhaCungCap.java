package swing.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class NhaCungCap {
	
	@Id
	@Column
	private Long maNhaCungCap;
	
	@Column
	private String tenNhaCungCap;
	
	@OneToMany(mappedBy="nhaCungCap", orphanRemoval = true)
	List<DuocPham> danhSachDuocPham=new ArrayList<DuocPham>();
	
	private XuatXu xuatXu;
	
	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}
	
	public NhaCungCap(Long maNhaCungCap, String tenNhaCungCap ,XuatXu xuatXu) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		
		this.xuatXu = xuatXu;
	}


	public Long getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(Long maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public List<DuocPham> getDanhSachDuocPham() {
		return danhSachDuocPham;
	}

	public void setDanhSachDuocPham(List<DuocPham> danhSachDuocPham) {
		this.danhSachDuocPham = danhSachDuocPham;
	}

	public XuatXu getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(XuatXu xuatXu) {
		this.xuatXu = xuatXu;
	}


	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", danhSachDuocPham="
				+ danhSachDuocPham + ", xuatXu=" + xuatXu + "]";
	}
	
	
}
