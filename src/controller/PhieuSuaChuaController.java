package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DienThoai;
import model.SuaChua;

public class PhieuSuaChuaController {
	
	public static boolean insertPhieuSuaChua(SuaChua psc, Connection con) {
		
		String sql = "INSERT INTO SUACHUA (MAPSC, NGAYLAP, NOIDUNG, IMEI, TONGTIEN) VALUES (?, ?, ?, ?, ?)";
		
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, psc.getMaPsc());
			statement.setDate(2, psc.getNgayLap());
			statement.setString(3, psc.getNoiDung());
			statement.setString(4, psc.getIMEI());
			statement.setInt(5, psc.getTongTien());
			


			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}

		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
		
	}
	
	public static SuaChua querySC(java.sql.Date ngayLap, Connection con) {
		
		String sql = "SELECT IMEI, NOIDUNG FROM SUACHUA WHERE NGAYLAP = '" + ngayLap + "'" ;
		
		SuaChua sc = new SuaChua();
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){

				String a = result.getString("IMEI");
				String b = result.getString("NOIDUNG");

				sc.setIMEI(a);
				sc.setNoiDung(b);

			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return sc;
	}
	
	public static String queryMaPsc(java.sql.Date ngayLap, String IMEI, Connection con) {
		
		String sql = "SELECT MAPSC FROM SUACHUA WHERE NGAYLAP = '" + ngayLap + "' AND IMEI = '" + IMEI + "'" ;
		
		String mapsc = "";
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){

				String a = result.getString("MAPSC");

				mapsc = a;

			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return mapsc;
	}
	
	public static boolean updateTongTien(int tongTien, String mapsc, Connection con) {
		
		String sql = "UPDATE suachua SET tongtien = ? WHERE mapsc = '" + mapsc + "'";
		
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, tongTien);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return false;
	}

}
