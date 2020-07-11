package swing.project.duocpham.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	LocalDate date = LocalDate.of(2000,4, 19);
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyy");
    String text = date.format(formatters);
    LocalDate parsedDate = LocalDate.parse(text, formatters);
    
    
	
	
	@Test
	public void themDuocPham() {			
		LoaiDuocPham loaiDuocPham=new LoaiDuocPham("Đau đầu");
		LoaiDuocPham loaiDuocPham1=new LoaiDuocPham("tim");
			
		duocPhamDao.themLoaiDuocPham(loaiDuocPham);
		duocPhamDao.themLoaiDuocPham(loaiDuocPham1);
						
		NhaCungCap nhaCungCap=new NhaCungCap(123l, "Akamaot", new XuatXu("Nhật Bản"));
		NhaCungCap nhaCungCap1=new NhaCungCap(124l, "Akamaot", new XuatXu("Nhật Bản"));
		
				
		duocPhamDao.themNhaCungCap(nhaCungCap);
		duocPhamDao.themNhaCungCap(nhaCungCap1);
		
			
		DuocPham dp1=new DuocPham(18042041l, "pharmtis", 5, 100, 120,"Hop", parsedDate,parsedDate, parsedDate, "Thuoc khang sinh");
		dp1.setLoaiDuocPham(loaiDuocPham);
		dp1.setNhaCungCap(nhaCungCap);
		DuocPham dp2=new DuocPham(18042042l, "hiromotru", 5, 100,120,"Hop",parsedDate, parsedDate, parsedDate, "Thuoc khang sinh");
		dp2.setLoaiDuocPham(loaiDuocPham1);
		dp2.setNhaCungCap(nhaCungCap1);
		DuocPham dp3=new DuocPham(18042043l, "islait", 5, 100, 120,"Hop",parsedDate, parsedDate, parsedDate, "Thuoc khang sinh");
		dp3.setLoaiDuocPham(loaiDuocPham1);	
		dp3.setNhaCungCap(nhaCungCap1);
		
		loaiDuocPham.getDanhSachDuocPhamLoai().add(dp1);
		loaiDuocPham1.getDanhSachDuocPhamLoai().add(dp2);
		loaiDuocPham1.getDanhSachDuocPhamLoai().add(dp3);
		
		
		nhaCungCap.getDanhSachDuocPham().add(dp1);
		nhaCungCap1.getDanhSachDuocPham().add(dp2);
		nhaCungCap1.getDanhSachDuocPham().add(dp3);
		
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Thêm dược phẩm");
		duocPhamDao.themDuocPham(dp1);				
		duocPhamDao.themDuocPham(dp2);		
		duocPhamDao.themDuocPham(dp3);		
		
		
//		if(duocPhamDao.xoaDuocPham(18042041l)) {
//			System.out.println("thanh cong");
//		}else {
//			System.out.println("that bai");
//		}
		System.out.println("----------------------------------------------------------------------------------------------");
//		System.out.println("Xóa dược phẩm theo tên");
//		duocPhamDao.xoaDuocPhamTheoTen("islait");
//		List<DuocPham> duocPham=duocPhamDao.getDanhSachDuocPham();
//		for (DuocPham duocPham2 : duocPham) {
//			System.out.println(duocPham2);
//		}
		
//		DuocPham DuocPhamTim=duocPhamDao.timDuocPhamTheoMa(18042044l);
//		System.out.println("----------------------------------------------------------------------------------------------");
//		System.out.println("duoc pham tim theo ma :"+ DuocPhamTim);
		
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
