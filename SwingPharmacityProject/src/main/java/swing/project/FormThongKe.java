package swing.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;


import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.GridLayout;

public class FormThongKe extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNhapNgay;
	private JTextField txtNhapThang;
	private JTextField txtNhapNam;
	private JTextField txtTongTienThuDuoc;
	private JTextField txtTongSoLuongDaBan;
	private JTable DSHoaDon;

	private DefaultTableModel model;
	private JRadioButton rdoNgay;
	private JRadioButton rdoThang;
	private JRadioButton rdoNam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThongKe frame = new FormThongKe();
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
	public FormThongKe() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("(-_-) tsukareta to yasumimasu \r\n");
		setBounds(100, 100, 803, 470);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblThongKeDuocPham = new JLabel("THỐNG KÊ");
		panel.add(lblThongKeDuocPham);

		lblThongKeDuocPham.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblThongKeDuocPham.setForeground(Color.red);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel pnThongKeHoaDon = new JPanel();
		Border centerBorder = BorderFactory.createLineBorder(Color.red);
		TitledBorder giuaTitle = new TitledBorder(centerBorder, "Thống kê hóa đơn");
		pnThongKeHoaDon.setBorder(giuaTitle);
		panel_1.add(pnThongKeHoaDon, BorderLayout.CENTER);
		pnThongKeHoaDon.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		pnThongKeHoaDon.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);

		JPanel panel_4 = new JPanel();
		panel_10.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNhapNgay = new JLabel("Nhập ngày:");
		panel_4.add(lblNhapNgay);

		txtNhapNgay = new JTextField();
		panel_4.add(txtNhapNgay);
		txtNhapNgay.setColumns(10);

		JLabel lblNhapThang = new JLabel("Nhập tháng:");
		panel_4.add(lblNhapThang);

		txtNhapThang = new JTextField();
		panel_4.add(txtNhapThang);
		txtNhapThang.setColumns(10);

		JLabel lblNhapNam = new JLabel("Nhập năm:");
		panel_4.add(lblNhapNam);

		txtNhapNam = new JTextField();
		panel_4.add(txtNhapNam);
		txtNhapNam.setColumns(10);

		JPanel pnHinhThucThongKe = new JPanel();
		Border centerBorder1 = BorderFactory.createLineBorder(Color.red);
		TitledBorder giuaTitle1 = new TitledBorder(centerBorder1, "Hình thức thống kê");
		pnHinhThucThongKe.setBorder(giuaTitle1);
		pnThongKeHoaDon.add(pnHinhThucThongKe, BorderLayout.WEST);
		pnHinhThucThongKe.setLayout(new BorderLayout(0, 0));

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		pnHinhThucThongKe.add(verticalStrut_3);

		JPanel pnDanhSachHoaDon = new JPanel();

		Border centerBorder2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder giuaTitle2 = new TitledBorder(centerBorder2, "Danh sách hóa đơn");
		pnDanhSachHoaDon.setBorder(giuaTitle2);

		pnThongKeHoaDon.add(pnDanhSachHoaDon, BorderLayout.CENTER);
		pnDanhSachHoaDon.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnDanhSachHoaDon.add(scrollPane, BorderLayout.CENTER);

		DSHoaDon = new JTable();
		DSHoaDon.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n",
						"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng d\u01B0\u1EE3c ph\u1EA9m",
						"T\u1ED5ng ti\u1EC1n", "Ghi ch\u00FA" }) {
			Class[] columnTypes = new Class[] { String.class, LocalDate.class, String.class, String.class, String.class,
					Integer.class, Integer.class, Double.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		DSHoaDon.getColumnModel().getColumn(7).setMinWidth(14);
		scrollPane.setViewportView(DSHoaDon);

		JPanel panel_9 = new JPanel();
		pnDanhSachHoaDon.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTongSoLuongDaBan = new JLabel("Tổng số lượng đã bán:");
		panel_9.add(lblTongSoLuongDaBan);

		txtTongSoLuongDaBan = new JTextField();
		panel_9.add(txtTongSoLuongDaBan);
		txtTongSoLuongDaBan.setColumns(10);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_5);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_6);

		JLabel lblTongTienThuDuoc = new JLabel("Tổng tiền thu được:");
		panel_9.add(lblTongTienThuDuoc);

		txtTongTienThuDuoc = new JTextField();
		panel_9.add(txtTongTienThuDuoc);
		txtTongTienThuDuoc.setColumns(10);
		ButtonGroup btg = new ButtonGroup();

		JPanel panel_2 = new JPanel();
		pnHinhThucThongKe.add(panel_2, BorderLayout.CENTER);

		JButton btnRefresh = new JButton("Refresh");
		panel_2.add(btnRefresh);

		JPanel panel_3 = new JPanel();
		pnHinhThucThongKe.add(panel_3, BorderLayout.NORTH);

		Box verticalBox = Box.createVerticalBox();
		panel_3.add(verticalBox);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);

		rdoNgay = new JRadioButton("Thống kê theo ngày");
		verticalBox.add(rdoNgay);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);

		rdoThang = new JRadioButton("Thống kê theo tháng");
		verticalBox.add(rdoThang);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);

		rdoNam = new JRadioButton("Thống kê theo năm");
		verticalBox.add(rdoNam);
		btg.add(rdoThang);
		btg.add(rdoNgay);
		btg.add(rdoNam);
		rdoNgay.addActionListener(this);
		rdoThang.addActionListener(this);
		rdoNam.addActionListener(this);
		btnRefresh.addActionListener(this);

		DSHoaDon.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
