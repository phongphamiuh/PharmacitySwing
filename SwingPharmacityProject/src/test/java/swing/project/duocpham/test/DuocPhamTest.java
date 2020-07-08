package swing.project.duocpham.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import swing.project.dao.DuocPhamDAO;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.entity.DuocPham;

import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.XuatXu;

public class DuocPhamTest {
	DuocPhamDAO duocPhamDao=new DuocPhamDAOImpl();
	Date date1=new Date("5/4/2020");
	Date date2=new Date("6/4/2000");	
	SimpleDateFormat simpleDate=new SimpleDateFormat("dd/mm/yyyy");		
	String date1Format=simpleDate.format(date1);
	String date2Format=simpleDate.format(date2);	
	LoaiDuocPham loaiDuocPham=new LoaiDuocPham("Đau đầu");
	LoaiDuocPham loaiDuocPham1=new LoaiDuocPham("tim");
	LoaiDuocPham loaiDuocPham2=new LoaiDuocPham("gan");
	LoaiDuocPham loaiDuocPham3=new LoaiDuocPham("da liễu");	
	@Test
	public void themDuocPham() {		
		NhaCungCap nhaCungCap=new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(123l);
		nhaCungCap.setTenNhaCungCap("Akamaot");
		nhaCungCap.setXuatXu(new XuatXu("Nhật Bản"));
		
		@SuppressWarnings("deprecation")
		DuocPham dp1=new DuocPham(18042041l, "pharmtis", 5, 100, 120,"Hop", new Date(date1Format),new Date(date1Format), new Date(date2Format), "Thuoc khang sinh",loaiDuocPham,nhaCungCap);
		DuocPham dp2=new DuocPham(18042042l, "hiromotru", 5, 100,120,"Hop",new Date(date1Format), new Date(date1Format), new Date(date2Format), "Thuoc khang sinh",loaiDuocPham,nhaCungCap);
		DuocPham dp3=new DuocPham(18042043l, "islait", 5, 100, 120,"Hop",new Date(date1Format), new Date(date1Format), new Date(date2Format), "Thuoc khang sinh",loaiDuocPham1,nhaCungCap);
		DuocPham dp4=new DuocPham(18042044l, "hibstachi", 5, 100, 120,"Hop",new Date(date1Format), new Date(date1Format), new Date(date2Format), "Thuoc khang sinh",loaiDuocPham2,nhaCungCap);
		DuocPham dp5=new DuocPham(18042045l, "khsamara", 5, 100, 120,"Hop",new Date(date1Format), new Date(date1Format), new Date(date2Format), "Thuoc khang sinh",loaiDuocPham3,nhaCungCap);
			
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Thêm dược phẩm");
		duocPhamDao.themDuocPham(dp1);				
		duocPhamDao.themDuocPham(dp2);		
		duocPhamDao.themDuocPham(dp3);		
		duocPhamDao.themDuocPham(dp4);		
		duocPhamDao.themDuocPham(dp5);
		
//		if(duocPhamDao.xoaDuocPham(18042041l)) {
//			System.out.println("thanh cong");
//		}else {
//			System.out.println("that bai");
//		}
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Xóa dược phẩm theo tên");
		duocPhamDao.xoaDuocPhamTheoTen("islait");
		List<DuocPham> duocPham=duocPhamDao.getDanhSachDuocPham();
		for (DuocPham duocPham2 : duocPham) {
			System.out.println(duocPham2);
		}
		
		DuocPham DuocPhamTim=duocPhamDao.timDuocPhamTheoMa(18042044l);
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("duoc pham tim theo ma :"+ DuocPhamTim);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Danh Sách các dược phẩm tìm theo tên");
		List<DuocPham> DuocPhamTimTen=duocPhamDao.timDuocPhamTen("s");
		for (DuocPham duocPham2 : DuocPhamTimTen) {
			System.out.println(duocPham2);
			System.out.println(duocPham2.getNhaCungCap().getTenNhaCungCap());
		}
		
		System.out.println("--------------------------------------");
		System.out.println("Sau khi tìm kiếm sản phẩm thì sẽ tiến hành sửa dược phẩm");
		dp1.setMaDuocPham(1802323l);
		dp1.setGiaBan(500);
		duocPhamDao.suaDuocPham(dp1);
	}
}
