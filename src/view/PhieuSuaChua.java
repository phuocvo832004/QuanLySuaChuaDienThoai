package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConnectionController;
import controller.DienThoaiController;
import controller.PhieuSuaChuaController;
import model.DienThoai;
import model.SuaChua;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhieuSuaChua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIMEI;
	private JTextField txtPhoneName;
	private JTextField txtCustomerName;
	private JTextField txtDate;
	Connection con = ConnectionController.createConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuSuaChua frame = new PhieuSuaChua();
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
	public PhieuSuaChua() {
		setTitle("Phiếu sửa chữa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 417, 386);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số IMEI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 152, 39);
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
		txtIMEI.setBounds(165, 11, 229, 39);
		panel.add(txtIMEI);
		
		JLabel lblNewLabel_1 = new JLabel("Tên điện thoại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 61, 152, 39);
		panel.add(lblNewLabel_1);
		
		txtPhoneName = new JTextField();
		txtPhoneName.setEditable(false);
		txtPhoneName.setColumns(10);
		txtPhoneName.setBounds(165, 61, 229, 39);
		panel.add(txtPhoneName);
		
		JLabel lblHTnKhch = new JLabel("Họ tên khách hàng");
		lblHTnKhch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHTnKhch.setBounds(10, 111, 152, 39);
		panel.add(lblHTnKhch);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(false);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(165, 111, 229, 39);
		panel.add(txtCustomerName);
		
		JLabel lblNgyLp = new JLabel("Ngày lập");
		lblNgyLp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyLp.setBounds(10, 161, 152, 39);
		panel.add(lblNgyLp);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(165, 161, 229, 39);
		panel.add(txtDate);
		
		JLabel lblNiDungSa = new JLabel("Nội dung sửa chữa");
		lblNiDungSa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNiDungSa.setBounds(10, 211, 152, 39);
		panel.add(lblNiDungSa);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setBounds(175, 211, 217, 164);
		panel.add(txtContent);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String a = String.valueOf(Math.round(Math.random()));

		            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		            Date utilDate = formatter.parse(txtDate.getText());
		            java.sql.Date b = new java.sql.Date(utilDate.getTime());
		            
		            String c = txtContent.getText();
		            String d = txtIMEI.getText();
		            int ez = 0;
		            
		            SuaChua sc = new SuaChua(a, b, c,d,ez);
		            addPSC(sc, con);

		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(173, 412, 89, 23);
		contentPane.add(btnAdd);
	}
	
	private DienThoai searchDT(String IMEI, Connection con) {
		return DienThoaiController.queryDT(IMEI, con);
	}
	
	private void addPSC(SuaChua sc, Connection con) {
		if(PhieuSuaChuaController.insertPhieuSuaChua(sc, con)) {
			JOptionPane.showMessageDialog(null, "Them thanh cong!");
		}
	}
}
