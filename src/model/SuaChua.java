package model;


public class SuaChua {

	private String maPsc;
	private java.sql.Date ngayLap;
	private String noiDung;
	private String IMEI;
	private int tongTien;
	public SuaChua() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuaChua(String maPsc, java.sql.Date ngayLap, String noiDung, String iMEI, int tongTien) {
		super();
		this.maPsc = maPsc;
		this.ngayLap = ngayLap;
		this.noiDung = noiDung;
		IMEI = iMEI;
		this.tongTien = tongTien;
	}
	public String getMaPsc() {
		return maPsc;
	}
	public void setMaPsc(String maPsc) {
		this.maPsc = maPsc;
	}
	public java.sql.Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(java.sql.Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
