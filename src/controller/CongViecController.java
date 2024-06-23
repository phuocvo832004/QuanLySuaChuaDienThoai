package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CongViec;

public class CongViecController {
	
	public static boolean insertCongViec(CongViec cv, Connection con) {
		String sql = "INSERT INTO cv (MACV, TENCV, DONGIA) VALUES (?, ?, ?)";
		
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, cv.getMacv());
			statement.setString(2, cv.getTencv());
			statement.setInt(3, cv.getDongia());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}

		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static List<CongViec> queryDSCV(Connection con){
		String sql = "SELECT * FROM CONGVIEC" ;
		
		List<CongViec> dscv = new ArrayList<CongViec>();
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){

				String a = result.getString("MACV");
				String b = result.getString("TENCV");
				int c = result.getInt("DONGIA");
				
				CongViec cv = new CongViec(a,b,c);
				
				dscv.add(cv);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dscv;
	}
	
	public static int queryDongia(String MaCV, Connection con) {
		String sql = "SELECT DONGIA FROM CONGVIEC WHERE MACV = '" + MaCV + "'" ;
		
		int dongia = 0;
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){

				int c = result.getInt("DONGIA");
				
				dongia = c;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dongia;
	}

}
