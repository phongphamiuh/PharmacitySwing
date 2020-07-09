package swing.project.dao;

public interface ThongKeHoaDonDAO {
	
	public double tinhThanhTienTheoNgay(int ngayLap, int thangLap, int namLap);
	public double tinhThanhTienTheoThang(int thangLap, int namLap);
	public double tinhThanhTienTheoNam(int namLap);
	
	public long demSoLuongHoaDonTheoNgay(int ngayLap, int thangLap, int namLap);
	public long demSoLuongHoaDonTheoThang(int thangLap, int namLap);
	public long demSoLuongHoaDonTheoNam(int namLap);
	
}
