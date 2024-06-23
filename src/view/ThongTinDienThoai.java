package view;

import controller.ConnectionController;
import controller.DienThoaiController;
import model.DienThoai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongTinDienThoai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIMEI;
	private JTextField txtName;
	private JTextField txtCustomerName;
	private JTextField txtCustomerPhone;
	Connection con = ConnectionController.createConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinDienThoai frame = new ThongTinDienThoai();
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
	public ThongTinDienThoai() {
		setTitle("Thông tin điện thoại");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 404, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số IMEI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 152, 39);
		panel.add(lblNewLabel);
		
		txtIMEI = new JTextField();
		txtIMEI.setBounds(165, 11, 229, 39);
		panel.add(txtIMEI);
		txtIMEI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên điện thoại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 61, 152, 39);
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(165, 61, 229, 39);
		panel.add(txtName);
		
		JLabel lblLoiinThoi = new JLabel("Loại điện thoại");
		lblLoiinThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoiinThoi.setBounds(10, 111, 152, 39);
		panel.add(lblLoiinThoi);
		
		JComboBox cbTypephone = new JComboBox();
		cbTypephone.setModel(new DefaultComboBoxModel(new String[] {"Iphone", "Android"}));
		cbTypephone.setBounds(165, 111, 229, 39);
		panel.add(cbTypephone);
		
		JLabel lblHTnKhch = new JLabel("Họ tên khách hàng");
		lblHTnKhch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHTnKhch.setBounds(10, 161, 152, 39);
		panel.add(lblHTnKhch);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(165, 161, 229, 39);
		panel.add(txtCustomerName);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại KH");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSinThoi.setBounds(10, 211, 152, 39);
		panel.add(lblSinThoi);
		
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setColumns(10);
		txtCustomerPhone.setBounds(165, 211, 229, 39);
		panel.add(txtCustomerPhone);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				String a = txtIMEI.getText();
				String b = txtName.getText();
				String c = cbTypephone.getSelectedItem().toString();
				String d = txtCustomerName.getText();
				String e = txtCustomerPhone.getText();
				addButton(a,b,c,d,e);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(170, 295, 96, 34);
		contentPane.add(btnAdd);
	}
	
	private void addButton(String a, String b, String c, String d, String e) {
		
		DienThoai dt = new DienThoai(a,b,c,d,e);
		if(DienThoaiController.insertDienThoai(dt, con)) {
			JOptionPane.showMessageDialog(null, "Them thanh cong!");
		}
	}
}
