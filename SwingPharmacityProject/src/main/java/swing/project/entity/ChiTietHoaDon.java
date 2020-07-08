package swing.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@org.hibernate.annotations.Immutable
public class ChiTietHoaDon {
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "maHoaDon")
		protected Long maHoaDon;

		@Column(name = "maDuocPham")
		protected Long maDuocPham;

		public Id() {
		}

		public Id(Long maHoaDon, Long maDuocPham) {
			this.maHoaDon = maHoaDon;
			this.maDuocPham = maDuocPham;
		}

		public boolean equals(Object o) {
			if (o != null && o instanceof Id) {
				Id that = (Id) o;
				return this.maHoaDon.equals(that.maHoaDon) && this.maDuocPham.equals(that.maDuocPham);
			}
			return false;
		}

		public int hashCode() {
			return maHoaDon.hashCode() + maDuocPham.hashCode();
		}
	}

	@EmbeddedId
	protected Id id = new Id();

	@Column
	private int soLuong;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "maDuocPham", insertable = false, updatable = false),
	})
	protected DuocPham duocPham;
	
	
	@ManyToOne
	@JoinColumn(name = "maHoaDon", insertable = false, updatable = false)
	protected HoaDon hoaDon;

	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(int soLuong, HoaDon hoaDon, DuocPham duocPham) {

		// Set fields
		this.soLuong = soLuong;
		this.hoaDon = hoaDon;
		this.duocPham = duocPham;

		// Set identifier values
		this.id.maDuocPham = duocPham.getMaDuocPham();
		this.id.maHoaDon = hoaDon.getMaHoaDon();

		// Guarantee referential integrity if made bidirectional
		hoaDon.getChiTietHoaDon().add(this);
		duocPham.getChiTietHoaDon().add(this);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public DuocPham getDuocPham() {
		return duocPham;
	}

	public void setDuocPham(DuocPham duocPham) {
		this.duocPham = duocPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [id=" + id + ", soLuong=" + soLuong + ", duocPham=" + duocPham + ", hoaDon=" + hoaDon
				+ "]";
	}
	
	

}
