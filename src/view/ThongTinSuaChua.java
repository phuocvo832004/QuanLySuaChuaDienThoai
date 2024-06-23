package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ChiTietSuaChuaController;
import controller.CongViecController;
import controller.ConnectionController;
import controller.DienThoaiController;
import controller.PhieuSuaChuaController;
import model.CongViec;
import model.DienThoai;
import model.SuaChua;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThongTinSuaChua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIMEI;
	private JTextField txtCustomerName;
	private JTextField txtDate;
	private JTextField txtPhoneName;
	private JTable table;
	private JTable table2;
	Connection con = ConnectionController.createConnection();
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinSuaChua frame = new ThongTinSuaChua();
					frame.setLocationRelativeTo(null);
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
	public ThongTinSuaChua() {
		setTitle("Thông tin sửa chữa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 687, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số IMEI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 124, 39);
		panel.add(lblNewLabel);
		
		txtIMEI = new JTextField();
		txtIMEI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String IMEI = txtIMEI.getText();
				DienThoai dt = searchDT(IMEI, con);
				txtCustomerName.setText(dt.getHotenKh());
				txtPhoneName.setText(dt.getSdtKh());
				
			}
		});
		txtIMEI.setColumns(10);
		txtIMEI.setBounds(144, 11, 166, 39);
		panel.add(txtIMEI);
		
		JLabel lblHTnKhch = new JLabel("Họ tên KH");
		lblHTnKhch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHTnKhch.setBounds(10, 61, 124, 39);
		panel.add(lblHTnKhch);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(false);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(144, 61, 166, 39);
		panel.add(txtCustomerName);
		
		JLabel lblNgyLp = new JLabel("Ngày lập");
		lblNgyLp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyLp.setBounds(10, 111, 124, 39);
		panel.add(lblNgyLp);
		
		txtDate = new JTextField();

		txtDate.setColumns(10);
		txtDate.setBounds(144, 111, 166, 39);
		panel.add(txtDate);
		
		JLabel lblTninThoi = new JLabel("Tên điện thoại");
		lblTninThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTninThoi.setBounds(335, 11, 137, 39);
		panel.add(lblTninThoi);
		
		txtPhoneName = new JTextField();
		txtPhoneName.setEditable(false);
		txtPhoneName.setColumns(10);
		txtPhoneName.setBounds(482, 11, 166, 39);
		panel.add(txtPhoneName);
		
		JLabel lblNiDungSa = new JLabel("Nội dung sửa chữa");
		lblNiDungSa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNiDungSa.setBounds(335, 61, 137, 39);
		panel.add(lblNiDungSa);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setEditable(false);
		txtContent.setBounds(492, 61, 156, 133);
		panel.add(txtContent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 229, 687, 255);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchCng = new JLabel("Danh sách công việc");
		lblDanhSchCng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanhSchCng.setBounds(10, 11, 232, 39);
		panel_1.add(lblDanhSchCng);
		
		JLabel lblDanhSchCng_1 = new JLabel("Danh sách công việc sửa chữa");
		lblDanhSchCng_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanhSchCng_1.setBounds(371, 11, 306, 39);
		panel_1.add(lblDanhSchCng_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 306, 185);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] columnNames = {"Mã công việc", "Công việc"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(348, 59, 329, 185);
		panel_1.add(scrollPane_1);
		
		table2 = new JTable();
		String[] columnName2s = {"Công việc", "Đơn giá"};
		model1.setColumnIdentifiers(columnName2s);
		table2.setModel(model1);
		scrollPane_1.setViewportView(table2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

		            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		            Date utilDate = formatter.parse(txtDate.getText());
		            java.sql.Date ngayLap = new java.sql.Date(utilDate.getTime());
		            
					int tongTien = 0;
					for(int i=0;i<table2.getRowCount();i++) {
						tongTien+=Integer.parseInt(table2.getValueAt(i, 1).toString());
//						ChiTietSC ctsc = new ChiTietSC(mapsc, macv);
//						ChiTietSuaChuaController.insertCTSC(null, con);
					}
					String mapsc = PhieuSuaChuaController.queryMaPsc(ngayLap, txtIMEI.getText(), con);
					if(PhieuSuaChuaController.updateTongTien(tongTien, mapsc, con)) {
						JOptionPane.showMessageDialog(null, "Them thanh cong!");
					}

		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(287, 495, 140, 42);
		contentPane.add(btnNewButton);
		

		txtDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

		            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		            Date utilDate = formatter.parse(txtDate.getText());
		            java.sql.Date a = new java.sql.Date(utilDate.getTime());
		            
		            SuaChua sc = queryPSC(a, con);
		            txtContent.setText(sc.getNoiDung());
		            txtIMEI.setText(sc.getIMEI());
		            

		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		
		loadDSCV(con);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				
				
				String macv = table.getValueAt(row, 0).toString();
				String tencv = table.getValueAt(row, 1).toString();
				int dongia = queryGia(macv, con);
				model1.addRow(new Object[]{tencv, dongia});
				
				model.removeRow(row);
			}
		});
	}
	
	private DienThoai searchDT(String IMEI, Connection con) {
		return DienThoaiController.queryDT(IMEI, con);
	}
	
	private SuaChua queryPSC(java.sql.Date ngayLap, Connection con) {
		
		return PhieuSuaChuaController.querySC(ngayLap, con);
	}
	
	private void loadDSCV(Connection con) {
		
		List<CongViec> dscv = CongViecController.queryDSCV(con);
		
		for(CongViec cv : dscv) {
			Object[] o = new Object[3]; 
	        o[0] = cv.getMacv();
	        o[1] = cv.getTencv();
	        model.addRow(o);
		}
				
	}
	private int queryGia(String MaCV, Connection con) {
		return CongViecController.queryDongia(MaCV, con);
	}
	
	
}
