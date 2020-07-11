package swing.project.hoadon.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import swing.project.duocpham.test.DuocPhamTest;
import swing.project.duocpham.test.OneToManyDuocPham;
import swing.project.entity.DuocPham;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.XuatXu;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HoaDonTest.class,
	HoaDonTestDAO.class,
	TestHoaDonNhanVien.class,
	TestSigleNhanVienHoaDon.class
})
public class MainHoaDonTest {
	
	
}
