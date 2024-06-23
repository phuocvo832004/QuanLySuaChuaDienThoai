package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DienThoai;

public class DienThoaiController {
	
	public static boolean insertDienThoai(DienThoai dienthoai, Connection con) {
		
		String sql = "INSERT INTO DIENTHOAI (IMEI, TENDT, LOAIDT, HOTENKH, SDTKH) VALUES (?, ?, ?, ?, ?)";
		
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, dienthoai.getIMEI());
			statement.setString(2, dienthoai.getTenDt());
			statement.setString(3, dienthoai.getLoaiDt());
			statement.setString(4, dienthoai.getHotenKh());
			statement.setString(5, dienthoai.getSdtKh());
			


			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}

		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
		
	}
	
	public static DienThoai queryDT(String IMEI, Connection con) {
		
		String sql = "SELECT * FROM DIENTHOAI WHERE IMEI = '" + IMEI + "'" ;
		
		DienThoai dt = new DienThoai();
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){

				String a = result.getString("IMEI");
				String b = result.getString("TENDT");
				String c = result.getString("LOAIDT");
				String d = result.getString("HOTENKH");
				String e = result.getString("SDTKH");

				dt.setIMEI(a);
				dt.setTenDt(b);
				dt.setLoaiDt(c);
				dt.setHotenKh(d);
				dt.setSdtKh(e);


			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dt;
	}

}
