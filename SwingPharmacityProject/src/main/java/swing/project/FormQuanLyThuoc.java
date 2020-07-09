package swing.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

import swing.project.dao.DuocPhamDAO;
import swing.project.dao.impl.DuocPhamDAOImpl;
import swing.project.entity.DuocPham;
import swing.project.entity.LoaiDuocPham;
import swing.project.entity.NhaCungCap;
import swing.project.entity.XuatXu;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class FormQuanLyThuoc extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtSoLuong;
	private JTextField txtGiaNhap;
	private JTable table;
	private DefaultTableModel dftable;
	private JTextField txtGiaBan;
	private JButton btnThemThuoc;
	private JButton btnSuaThuoc;
	private JButton btnXoaThuoc;
	private JComboBox<String> cbDonVi;
	private JComboBox<Integer> cbngaynhap;
	private JComboBox<Integer> cbThangNhap;
	private JComboBox<Integer> cbNamNhap;
	private JComboBox<Integer> cbngayHetHan;
	private JComboBox<Integer> cbNamHetHan;
	private JComboBox<Integer> cbThangHetHan;
	private JComboBox<Integer> cbngaySX;
	private JComboBox<Integer> cbThangSX;
	private JComboBox<Integer> cbNamSX;
	private JTextField txtTimTheoTen;
	private JButton btnTim;
	DuocPhamDAO duocPhamDAO=new DuocPhamDAOImpl();
	private JTextArea txtMoTa;
	private JComboBox cbloaiDuocPham;
	private JTextField txtTenNhaCungCap;
	private JComboBox<String> cbXuatXu;
	private JTextField txtMaNhaCungCap;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormQuanLyThuoc frame = new FormQuanLyThuoc();
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
	public FormQuanLyThuoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNhThucPharmacity = new JLabel("NHÀ THUỐC PHARMACITY");
		lblNhThucPharmacity.setForeground(Color.RED);
		lblNhThucPharmacity.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel.add(lblNhThucPharmacity);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		JPanel panel_1_1 = new JPanel();
		verticalBox.add(panel_1_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_1_1.add(verticalBox_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		JPanel panel_3 = new JPanel();
		verticalBox_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMaThuoc = new JLabel("Mã Thuốc");
		panel_3.add(lblMaThuoc);
		
		txtMaThuoc = new JTextField(10);
		txtMaThuoc.setColumns(20);
		panel_3.add(txtMaThuoc);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		JPanel panel_4 = new JPanel();
		verticalBox_1.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTenThuoc = new JLabel("Tên Thuốc");
		panel_4.add(lblTenThuoc);
		
		txtTenThuoc = new JTextField(10);

		txtTenThuoc.setColumns(20);
		panel_4.add(txtTenThuoc);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		JPanel panel_7 = new JPanel();
		verticalBox_1.add(panel_7);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		panel_7.add(lblSoLuong);
		
		txtSoLuong = new JTextField(10);
		txtSoLuong.setColumns(20);
		panel_7.add(txtSoLuong);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_3);
		
		JPanel panel_5 = new JPanel();
		verticalBox_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel lblDonVi = new JLabel(" Đơn vị tính");
		panel_5.add(lblDonVi);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		panel_5.add(horizontalStrut_1);
		
		 cbDonVi = new JComboBox<String>();
		 cbDonVi.addItem("Hộp");
		 cbDonVi.addItem("Vĩ");
		 cbDonVi.addItem("Viên");
		panel_5.add(cbDonVi);
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		panel_5.add(horizontalStrut);
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_10);
		
		JPanel panel_8 = new JPanel();
		verticalBox_1.add(panel_8);
		
		JLabel lblGiaNhap = new JLabel("Giá Nhập");
		panel_8.add(lblGiaNhap);
		
		txtGiaNhap = new JTextField(10);
		txtGiaNhap.setColumns(20);
		panel_8.add(txtGiaNhap);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_4);
		
		JPanel panel_9_2 = new JPanel();
		verticalBox_1.add(panel_9_2);
		
		JLabel lblGiaBan = new JLabel("Giá Bán");
		panel_9_2.add(lblGiaBan);
		
		txtGiaBan = new JTextField(20);
		panel_9_2.add(txtGiaBan);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_9);
		
		JPanel panel_9 = new JPanel();
		verticalBox_1.add(panel_9);
		
		JLabel lblNgayNhap = new JLabel("Ngày Nhập");
		panel_9.add(lblNgayNhap);
		
		Component verticalStrut_8 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_8);
		
		JPanel panel_9_1 = new JPanel();
		verticalBox_1.add(panel_9_1);
		
		JLabel lblNgaySX = new JLabel("Ngày Sản Xuất");
		panel_9_1.add(lblNgaySX);
		
		cbngaySX = new JComboBox<Integer>();
		 for (int i = 1; i < 32; i++) {
			 cbngaySX.addItem(i);
		}
		panel_9_1.add(cbngaySX);
		cbThangSX = new JComboBox<Integer>();
		
		 cbNamSX = new JComboBox<Integer>();
		 for (int i = 1; i < 13; i++) {
			 cbThangSX.addItem(i);
		}
		panel_9_1.add(cbThangSX);
		
		 cbNamSX = new JComboBox<Integer>();
		 for (int i = 1990; i < 2031; i++) {
			 cbNamSX.addItem(i);
		}
		panel_9_1.add(cbNamSX);
		
		 		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_11);
		
		JPanel panel_9_1_1 = new JPanel();
		verticalBox_1.add(panel_9_1_1);
		
		JLabel lblHanSD = new JLabel("Hạn Sử Dụng");
		panel_9_1_1.add(lblHanSD);
		
		lblGiaBan.setPreferredSize(lblNgaySX.getPreferredSize());
		lblMaThuoc.setPreferredSize(lblNgaySX.getPreferredSize());
		lblTenThuoc.setPreferredSize(lblNgaySX.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNgaySX.getPreferredSize());
		lblGiaNhap.setPreferredSize(lblNgaySX.getPreferredSize());
		lblNgayNhap.setPreferredSize(lblNgaySX.getPreferredSize());
		
		 cbngaynhap = new JComboBox<Integer>();
		 for (int i = 1; i < 32; i++) {
			 cbngaynhap.addItem(i);
		}
		panel_9.add(cbngaynhap);
		
		 cbThangNhap = new JComboBox<Integer>();
		 for (int i = 1; i < 13; i++) {
			 cbThangNhap.addItem(i);
		}
		panel_9.add(cbThangNhap);
		
		 cbNamNhap = new JComboBox<Integer>();
		 for (int i = 1990; i < 2031; i++) {
			 cbNamNhap.addItem(i);
		}
		panel_9.add(cbNamNhap);
		lblHanSD.setPreferredSize(lblNgaySX.getPreferredSize());
		
		 cbThangHetHan = new JComboBox<Integer>();
		 for (int i = 1; i < 13; i++) {
			 cbThangHetHan.addItem(i);
		}
		 
		 cbngayHetHan = new JComboBox<Integer>();
		 for (int i = 1; i < 32; i++) {
			 cbngayHetHan.addItem(i);
		}
		panel_9_1_1.add(cbngayHetHan);
		
		
		panel_9_1_1.add(cbThangHetHan);
		
		 cbNamHetHan = new JComboBox<Integer>();
		 for (int i = 1990; i < 2031; i++) {
			 cbNamHetHan.addItem(i);
		}
		panel_9_1_1.add(cbNamHetHan);
		lblDonVi.setPreferredSize(lblNgaySX.getPreferredSize());
		
		JPanel panel_15 = new JPanel();
		verticalBox_1.add(panel_15);
		
		JLabel lbltenLoai = new JLabel("Loại Dược Phẩm");
		panel_15.add(lbltenLoai);
		
		cbloaiDuocPham= new JComboBox<String>();
		cbloaiDuocPham.addItem("Da liễu");
		cbloaiDuocPham.addItem("Tai");
		cbloaiDuocPham.addItem("Mũi");
		cbloaiDuocPham.addItem("Họng");
		panel_15.add(cbloaiDuocPham);
		cbloaiDuocPham.addItem(null);
		
		JPanel panel_20 = new JPanel();
		verticalBox_1.add(panel_20);
		
		JLabel lblMNhCung = new JLabel("Mã Nhà Cung Cấp");
		panel_20.add(lblMNhCung);
		
		txtMaNhaCungCap = new JTextField();
		panel_20.add(txtMaNhaCungCap);
		txtMaNhaCungCap.setColumns(20);
		
		JPanel panel_18 = new JPanel();
		verticalBox_1.add(panel_18);
		
		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp");
		panel_18.add(lblTnNhCung);
		
		txtTenNhaCungCap = new JTextField();
		panel_18.add(txtTenNhaCungCap);
		txtTenNhaCungCap.setColumns(20);
		
		JPanel panel_19 = new JPanel();
		verticalBox_1.add(panel_19);
		
		JLabel lblXutX = new JLabel("Xuất xứ");
		panel_19.add(lblXutX);
		
		cbXuatXu = new JComboBox<String>();
		cbXuatXu.addItem("Trung Quốc");
		cbXuatXu.addItem("Việt Nam");
		cbXuatXu.addItem("My");
		panel_19.add(cbXuatXu);
		
		JPanel panel_16 = new JPanel();
		verticalBox_1.add(panel_16);
		
		JLabel lblMT = new JLabel("Mô tả");
		panel_16.add(lblMT);
		
		JPanel panel_17 = new JPanel();
		verticalBox_1.add(panel_17);
		
		 txtMoTa = new JTextArea();
		txtMoTa.setRows(8);

		panel_17.add(txtMoTa);
		txtMoTa.setColumns(40);
		
		JPanel panel_6 = new JPanel();
		verticalBox.add(panel_6);
		
		JLabel lblChucNang = new JLabel("Chức Năng:");
		
		 btnThemThuoc = new JButton("Thêm Thuốc");
		
		 btnSuaThuoc = new JButton("  Sửa Thuốc ");
		
		 btnXoaThuoc = new JButton("  Xóa Thuốc ");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(66)
					.addComponent(lblChucNang)
					.addGap(14)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSuaThuoc)
						.addComponent(btnThemThuoc)
						.addComponent(btnXoaThuoc))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChucNang)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnThemThuoc)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSuaThuoc)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnXoaThuoc)
					.addGap(86))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		panel_10.add(menuBar);
		
		JButton btnAaaaaaaa = new JButton("Danh Mục Thuốc");
		btnAaaaaaaa.setForeground(Color.BLUE);
		btnAaaaaaaa.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		menuBar.add(btnAaaaaaaa);
		
		JButton btnBbbbbbbb = new JButton("Xuất Hóa Đơn");
		btnBbbbbbbb.setForeground(Color.BLUE);
		btnBbbbbbbb.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuBar.add(btnBbbbbbbb);
		
		JButton btnCcccccccc = new JButton("Thống Kê Doanh Thu");
		btnCcccccccc.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCcccccccc.setForeground(Color.BLUE);
		menuBar.add(btnCcccccccc);
		
		JButton btnDddddd = new JButton("Thống Kê Thuốc Hết Hạn");
		btnDddddd.setForeground(Color.BLUE);
		btnDddddd.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuBar.add(btnDddddd);
		
		JButton btnEeeeeee = new JButton("eeeeeee");
		menuBar.add(btnEeeeeee);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12, BorderLayout.NORTH);
		
		Box verticalBox_2 = Box.createVerticalBox();
		panel_12.add(verticalBox_2);
		
		JLabel lblQunLThuc = new JLabel("QUẢN LÝ THUỐC");
		verticalBox_2.add(lblQunLThuc);
		lblQunLThuc.setForeground(Color.BLUE);
		lblQunLThuc.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JPanel panel_14 = new JPanel();
		verticalBox_2.add(panel_14);
		
		JLabel lblTmTheoTn = new JLabel("Tìm Theo Tên:");
		panel_14.add(lblTmTheoTn);
		
		txtTimTheoTen = new JTextField();
		panel_14.add(txtTimTheoTen);
		txtTimTheoTen.setColumns(25);
		
		 btnTim = new JButton("Tìm");
		panel_14.add(btnTim);
		
		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.PAGE_AXIS));
		String[] tieuDe = {"Mã Thuốc","Tên Thuốc","Đơn vị tính", 
				"Số Lượng","Giá Nhập","Giá Bán","Ngày Nhập","Ngày Sản Xuất","Hạn SD","Loai Duoc Pham","Ma Nha Cung Cap","Ten nha cung cap","Xuat xu","Mo tat"};
		dftable = new DefaultTableModel(tieuDe,0);
		table = new JTable(dftable);
		panel_13.add(new JScrollPane(table));
		btnThemThuoc.addActionListener(this);
		btnSuaThuoc.addActionListener(this);
		btnXoaThuoc.addActionListener(this);
		table.addMouseListener(this);
		btnTim.addActionListener(this);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThemThuoc))
		{																								
						
					
						
						int ngaySanXuat=Integer.parseInt((String) cbngaySX.getSelectedItem().toString());
						int thangSanXuat=Integer.parseInt((String) cbThangSX.getSelectedItem().toString());
						int namSanXuat=Integer.parseInt((String) cbNamSX.getSelectedItem().toString());
						
						int ngayHetHan=Integer.parseInt((String) cbngayHetHan.getSelectedItem().toString());
						int thangHetHan=Integer.parseInt((String) cbThangHetHan.getSelectedItem().toString());
						int namHetHan=Integer.parseInt((String) cbNamHetHan.getSelectedItem());
						
						int ngayNhap=Integer.parseInt((String) cbngaynhap.getSelectedItem().toString());
						int thangNhap=Integer.parseInt((String) cbThangNhap.getSelectedItem().toString());
						int namNhap=Integer.parseInt((String) cbNamNhap.getSelectedItem().toString());
											
						Long maNhaCungCap=Long.parseLong(txtMaNhaCungCap.getText());					
						NhaCungCap nhaCungCap=new NhaCungCap();
						nhaCungCap.setMaNhaCungCap(maNhaCungCap);
						nhaCungCap.setTenNhaCungCap(txtTenNhaCungCap.getText());
						nhaCungCap.setXuatXu(new XuatXu(cbXuatXu.getSelectedItem().toString()));					
						
						DuocPham duocPham=new DuocPham();
						duocPham.setMaDuocPham(Long.parseLong(txtMaThuoc.getText()));
						duocPham.setTenDuocPham(txtTenThuoc.getText());
						duocPham.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
						duocPham.setDonViTinh(cbDonVi.getSelectedItem().toString());
						duocPham.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
						duocPham.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
						
						
						
						duocPham.setMoTa(txtMoTa.getText());
						duocPham.setLoaiDuocPham(new LoaiDuocPham(cbloaiDuocPham.getSelectedItem().toString()));
						duocPham.setNhaCungCap(nhaCungCap);
						
						duocPhamDAO.themDuocPham(duocPham);		
						List<DuocPham> listDuocPham=new ArrayList<DuocPham>();
						listDuocPham=duocPhamDAO.getDanhSachDuocPham();
						
						dftable.addRow(new Object[] {
								duocPham.getMaDuocPham(),duocPham.getTenDuocPham(),duocPham.getDonViTinh()				
						});
						
					
		}if(o.equals(btnXoaThuoc)) {
			try {
				
//				int r = table.getSelectedRow();
//				dftable.removeRow(r);
//				Thuoc sp = listSP.getElement(r);
//				listSP.xoaSP(sp.getMaThuoc());
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Phải chọn dòng để xóa");
		}
		
		}
		if(o.equals(btnTim)) {
//			TimTheoMa();
			JOptionPane.showMessageDialog(this, "Tìm");
		}
//		if (o.equals(btnSua)) {
//			String maSachOld = txtMaThuoc.getText().trim();
//			if (validData()) { 
//				Thuoc sachNew = revertSachFromTextfields();
//				if (listSP.capNhatSach(maSachOld, sachNew)) {
//					JOptionPane.showMessageDialog(this, "Cập nhật thành công.  ");
//					updateTableData();
//					int index = listSP.getDsSach().indexOf(sachNew);
//					table.setRowSelectionInterval(index, index);
//				} else
//					JOptionPane.showMessageDialog(this, "Cần chọn cuốn sách muốn cập nhật. ");
//			}
//	}
//		private boolean validData() {
//			String maSach = txtMaSach.getText().trim();
//			String tuaSach = txtTuaSach.getText().trim();
//			String tacGia = txtTacGia.getText().trim();
//			String nam = txtNamXB.getText().trim();
//			String gia = txtDonGia.getText().trim();
//			String isbn = txtISBN.getText().trim();
//			String soTrang = txtSoTrang.getText().trim();
//
//			return true;
//		}
//
//		private Thuoc revertSachFromTextfields() {
//			String maThuoc = txtMaThuoc.getText().trim();
//			String tuaSach = txtTenThuoc.getText().trim();
//			String SoLuong = txtTacGia.getText().trim();
//
//			String nam = txtNamXB.getText().trim();
//			int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam); 
//			// Ä�á»ƒ trá»‘ng thÃ¬ coi nhÆ° lÃ  0
//
//			String nhaXB = txtNhaXB.getText().trim();
//			String trang = txtSoTrang.getText().trim();
//			int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);
//
//			String gia = txtDonGia.getText().trim();
//			double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);
//
//			String isbn = txtISBN.getText().trim();
//			return new Thuoc(maThuoc, tuaSach, tacGia,
//					namXB, nhaXB, soTrang, donGia, isbn);
//		}
}
//	private void TimTheoMa() {
//		String str = txtTimTheoTen.getText();
//		if(str != null && str.trim().length()>0) {
//			try {
//				int maNV = Integer.parseInt(str);
//				Thuoc nv = listSP.timNV(maNV);
//				if(nv != null) {
//					XoaHetDuLieuTrenTableModel();
//					dfTable.addRow(new Object[] {
//							nv.getMa(),
//							nv.getHo(),
//							nv.getTen(),
//							nv.getTuoi(), nv.isPhai(),
//							nv.getLuong()});
//				}else {
//					JOptionPane.showMessageDialog(null," Khong tim thay ");
//					return;
//				}
//			}catch (Exception ex) {
//				JOptionPane.showMessageDialog(null," Du lieu khong hop le ");
//				txtNhap.selectAll();
//				txtNhap.requestFocus();
//			}
//		}
//		else {
//			XoaHetDuLieuTrenTableModel();
//			DocDuLieuTuArrayListVaoModel();
//			table.setModel(dfTable);
//		}
//	}
//	
	public  void XoaHetDuLieuTrenTableModel()
	{
		DefaultTableModel dm =(DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
}
