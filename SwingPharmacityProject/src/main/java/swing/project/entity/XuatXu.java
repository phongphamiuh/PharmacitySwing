package swing.project.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class XuatXu {
	
	@Column
	private String tenXuatXU;
	
	
	public XuatXu() {
		// TODO Auto-generated constructor stub
	}


	public XuatXu(String tenXuatXU) {
		super();
		this.tenXuatXU = tenXuatXU;
	}


	public String getTenXuatXU() {
		return tenXuatXU;
	}


	public void setTenXuatXU(String tenXuatXU) {
		this.tenXuatXU = tenXuatXU;
	}


	@Override
	public String toString() {
		return "XuatXu [tenXuatXU=" + tenXuatXU + "]";
	}
	
	
	
	
	
}
