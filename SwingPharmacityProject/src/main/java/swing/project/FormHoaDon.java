package swing.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class FormHoaDon extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnMainHoaDon;
	private JTable tableHD, tableTimThuoc, tableThuocDaChon;
	private DefaultTableModel dfTableHD, dftableTimThuoc, dftableThuocDaChon;
	private JTextField txtTimThuoc;
	private JTextField txtThuocDaChon;
	private JTextField txtTimHDTheoMa;
	private JTextField txtTimTheoTenKH;
	private JTextField txtSoLuong;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtTenNV;
	private JTextField txtGhiChu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHoaDon frame = new FormHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 1000);
		setTitle("Quản lý nhà thuốc Pharmacity");
		setLocationRelativeTo(null);
		setResizable(true);
		pnMainHoaDon = new JPanel();
		pnMainHoaDon.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMainHoaDon.setLayout(new BorderLayout(0, 0));
		setContentPane(pnMainHoaDon);
		
		JPanel pnNorthHoaDon = new JPanel();
		pnMainHoaDon.add(pnNorthHoaDon, BorderLayout.NORTH);
		pnNorthHoaDon.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTieuDeNhaThuoc = new JPanel();
		pnNorthHoaDon.add(pnTieuDeNhaThuoc, BorderLayout.NORTH);
		
		JLabel lblTieuDeNhaThuoc = new JLabel("NHÀ THUỐC PHARMACITY");
		lblTieuDeNhaThuoc.setForeground(Color.RED);
		lblTieuDeNhaThuoc.setFont(new Font("Times New Roman", Font.BOLD, 35));
		pnTieuDeNhaThuoc.add(lblTieuDeNhaThuoc);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.info);
		pnNorthHoaDon.add(menuBar, BorderLayout.SOUTH);
		
		JButton btnDanhMucThuoc_menu = new JButton("   Danh mục thuốc   ");
		btnDanhMucThuoc_menu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhMucThuoc_menu.setForeground(Color.BLUE);
		btnDanhMucThuoc_menu.setBackground(new Color(255, 255, 225));
		menuBar.add(btnDanhMucThuoc_menu);
		
		JButton btnXuatHD_menu = new JButton("   Xuất hóa đơn   ");
		btnXuatHD_menu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXuatHD_menu.setForeground(Color.BLUE);
		btnXuatHD_menu.setBackground(SystemColor.info);
		menuBar.add(btnXuatHD_menu);
		
		JButton btnThongKeDT_menu = new JButton("   Thống kê doanh thu   ");
		btnThongKeDT_menu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThongKeDT_menu.setForeground(Color.BLUE);
		btnThongKeDT_menu.setBackground(SystemColor.info);
		menuBar.add(btnThongKeDT_menu);
		
		JButton btnThongKeThuocHH_menu = new JButton("   Thống kê thuốc hết hạn   ");
		btnThongKeThuocHH_menu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThongKeThuocHH_menu.setForeground(Color.BLUE);
		btnThongKeThuocHH_menu.setBackground(SystemColor.info);
		menuBar.add(btnThongKeThuocHH_menu);
		
		JPanel pnCenterHoaDon = new JPanel();
		pnMainHoaDon.add(pnCenterHoaDon, BorderLayout.CENTER);
		pnCenterHoaDon.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTieuDeHoaDon = new JPanel();
		pnCenterHoaDon.add(pnTieuDeHoaDon, BorderLayout.NORTH);
		
		JLabel lblTieuDeHoaDon = new JLabel("XUẤT HÓA ĐƠN");
		lblTieuDeHoaDon.setForeground(SystemColor.textHighlight);
		lblTieuDeHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnTieuDeHoaDon.add(lblTieuDeHoaDon);
		
		JPanel pnThongTinHD = new JPanel();
		pnCenterHoaDon.add(pnThongTinHD, BorderLayout.CENTER);
		pnThongTinHD.setLayout(new BorderLayout());
		
		JPanel pnChonThuoc = new JPanel();
		pnChonThuoc.setBorder(new TitledBorder(null, "Ch\u1ECDn thu\u1ED1c", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		pnThongTinHD.add(pnChonThuoc, BorderLayout.WEST);
		
		JPanel pnTimThuoc = new JPanel();
		JLabel lblTimThuoc = new JLabel("Tìm theo tên thuốc");
		pnTimThuoc.add(lblTimThuoc);
		
		txtTimThuoc = new JTextField();
		pnTimThuoc.add(txtTimThuoc);
		txtTimThuoc.setColumns(40);
		
		JPanel pnListThuoc = new JPanel();
		String[] tieude2 = {"Tên dược phẩm", "Đơn vị", "Số lượng","Đơn giá"};
		dftableTimThuoc = new DefaultTableModel(tieude2, 0);
		tableTimThuoc = new JTable(dftableTimThuoc);
		pnListThuoc.add(pnTimThuoc);
		pnListThuoc.add(Box.createVerticalStrut(10));
		pnListThuoc.add(new JScrollPane(tableTimThuoc));
		pnListThuoc.setLayout(new BoxLayout(pnListThuoc, BoxLayout.PAGE_AXIS));
		
		JPanel pnSoLuong = new JPanel();
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		pnSoLuong.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		pnSoLuong.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		pnSoLuong.add(btnThem);
		pnChonThuoc.setLayout(new BoxLayout(pnChonThuoc, BoxLayout.Y_AXIS));
		pnChonThuoc.add(pnListThuoc);
		pnChonThuoc.add(pnSoLuong);
		
		JPanel pnButtonHoaDon = new JPanel();
		pnThongTinHD.add(pnButtonHoaDon, BorderLayout.SOUTH);
		
		JPanel pnLeft = new JPanel();
		pnButtonHoaDon.add(pnLeft);
		
		JLabel lblTimTheoTenKH = new JLabel("Tìm theo tên khách hàng");
		pnLeft.add(lblTimTheoTenKH);
		
		txtTimTheoTenKH = new JTextField();
		pnLeft.add(txtTimTheoTenKH);
		txtTimTheoTenKH.setColumns(25);
		
		JButton btnTimTheoTenKH = new JButton("Tìm");
		pnLeft.add(btnTimTheoTenKH);
		pnButtonHoaDon.add(Box.createHorizontalStrut(50));
		
		JPanel pMiddle = new JPanel();
		pnButtonHoaDon.add(pMiddle);
		pnButtonHoaDon.add(Box.createHorizontalStrut(50));
		
		JLabel lblTimHDTheoMa = new JLabel("Tìm hóa đơn theo mã");
		pMiddle.add(lblTimHDTheoMa);
		
		txtTimHDTheoMa = new JTextField(25);
		pMiddle.add(txtTimHDTheoMa);
		
		JButton btnTifmHDTheoMa = new JButton("Tìm");
		pMiddle.add(btnTifmHDTheoMa);
		
		JPanel pnRight = new JPanel();
		pnButtonHoaDon.add(pnRight);
		
		JButton btnHDMoi = new JButton("Hóa đơn mới");
		pnRight.add(btnHDMoi);
		
		JButton btnXuatHD = new JButton("Xuất hóa đơn");
		pnRight.add(btnXuatHD);
		
		JButton btnCapNhatHD = new JButton("Cập nhật hóa đơn");
		pnRight.add(btnCapNhatHD);
		
		JPanel pnThuocDaChon = new JPanel();
		pnThuocDaChon.setBorder(new TitledBorder(null, "Thu\u1ED1c \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinHD.add(pnThuocDaChon, BorderLayout.CENTER);
		pnThuocDaChon.setLayout(new BoxLayout(pnThuocDaChon, BoxLayout.Y_AXIS));
		
		dftableThuocDaChon = new DefaultTableModel(tieude2, 0);
		tableThuocDaChon = new JTable(dftableThuocDaChon);
		pnThuocDaChon.add(new JScrollPane(tableThuocDaChon));
		
		JPanel pnXoaThuoc = new JPanel();
		pnThuocDaChon.add(pnXoaThuoc);
		
		JButton btnXoaThuoc = new JButton("Xóa thuốc");
		pnXoaThuoc.add(btnXoaThuoc);
		
		JPanel pnThongTin = new JPanel();
		pnThongTinHD.add(pnThongTin, BorderLayout.EAST);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnThongTinKH = new JPanel();
		pnThongTinKH.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin khách hàng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTin.add(pnThongTinKH);
		pnThongTinKH.setLayout(new GridLayout(6, 2));
		
		JPanel pnMaHD = new JPanel();
		pnThongTinKH.add(pnMaHD);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
		lblMaHoaDon.setPreferredSize(new Dimension(92, 16));
		pnMaHD.add(lblMaHoaDon);
		
		textField = new JTextField();
		textField.setColumns(30);
		pnMaHD.add(textField);
		
		JPanel pnNgay = new JPanel();
		pnThongTinKH.add(pnNgay);
		
		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setPreferredSize(new Dimension(92, 16));
		pnNgay.add(lblNgay);
		
		textField_1 = new JTextField();
		textField_1.setColumns(30);
		pnNgay.add(textField_1);
		
		JPanel pnTenKH = new JPanel();
		pnThongTinKH.add(pnTenKH);
		
		JLabel lblTenKH = new JLabel("Tên Khách hàng");
		pnTenKH.add(lblTenKH);
		
		textField_2 = new JTextField();
		textField_2.setColumns(30);
		pnTenKH.add(textField_2);
		
		JPanel pnTongTien = new JPanel();
		pnThongTinKH.add(pnTongTien);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setPreferredSize(new Dimension(92, 16));
		pnTongTien.add(lblTongTien);
		
		textField_3 = new JTextField();
		textField_3.setColumns(30);
		pnTongTien.add(textField_3);
		
		JPanel pnSDT = new JPanel();
		pnThongTinKH.add(pnSDT);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setPreferredSize(new Dimension(92, 16));
		pnSDT.add(lblSDT);
		
		textField_4 = new JTextField();
		textField_4.setColumns(30);
		pnSDT.add(textField_4);
		
		JPanel pnGhiChu = new JPanel();
		pnThongTinKH.add(pnGhiChu);
		
		JLabel lblGhichu = new JLabel("Ghi chú");
		pnGhiChu.add(lblGhichu);
		
		txtGhiChu = new JTextField();
		pnGhiChu.add(txtGhiChu);
		txtGhiChu.setColumns(30);
		
		JPanel pnThongTinNhanVien = new JPanel();
		pnThongTinNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTin.add(pnThongTinNhanVien);
		pnThongTinNhanVien.setLayout(new BoxLayout(pnThongTinNhanVien, BoxLayout.Y_AXIS));
		
		JPanel pnMaNV = new JPanel();
		pnThongTinNhanVien.add(pnMaNV);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		pnMaNV.add(lblMaNV);
		
		JComboBox cbMaNV = new JComboBox();
		pnMaNV.add(cbMaNV);
		
		JPanel pnTenNV = new JPanel();
		pnThongTinNhanVien.add(pnTenNV);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		pnTenNV.add(lblTenNV);
		
		txtTenNV = new JTextField();
		pnTenNV.add(txtTenNV);
		txtTenNV.setColumns(30);
		
		lblTenNV.setPreferredSize(lblTenKH.getPreferredSize());
		lblMaNV.setPreferredSize(lblTenNV.getPreferredSize());
		lblGhichu.setPreferredSize(lblTenKH.getPreferredSize());
		
		JPanel pnSouthHoaDon = new JPanel();
		pnSouthHoaDon.setLayout(new BoxLayout(pnSouthHoaDon, BoxLayout.PAGE_AXIS));
		pnMainHoaDon.add(pnSouthHoaDon, BorderLayout.SOUTH);
		
		String[] tieuDe1 = { "Mã hóa đơn", "Ngày lập hóa đơn", "Mã nhân viên", "tên nhân viên","Tên Khách hàng","Số điện thoại", "Số lượng dược phẩm", "Tổng tiền", "Ghi chú" };
		dfTableHD = new DefaultTableModel(tieuDe1, 0);
		tableHD = new JTable(dfTableHD);
		
		pnSouthHoaDon.add(new JScrollPane(tableHD));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
