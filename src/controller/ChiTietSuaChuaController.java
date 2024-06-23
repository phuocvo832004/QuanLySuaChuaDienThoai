package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ChiTietSC;

public class ChiTietSuaChuaController {
	
	public static boolean insertCTSC(ChiTietSC ctsc, Connection con) {
		
		String sql = "INSERT INTO ctsc (MAPSC, MACV) VALUES (?, ?)";
		
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ctsc.getMaPsc());
			statement.setString(2, ctsc.getMacv());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}

		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
