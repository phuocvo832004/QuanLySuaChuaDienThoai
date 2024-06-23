package model;

public class CongViec {
	
	private String macv;
	private String tencv;
	private int dongia;
	
	//getter,setter, constructors...
	public CongViec() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CongViec(String macv, String tencv, int dongia) {
		super();
		this.macv = macv;
		this.tencv = tencv;
		this.dongia = dongia;
	}
	
	public String getMacv() {
		return macv;
	}
	public void setMacv(String macv) {
		this.macv = macv;
	}
	public String getTencv() {
		return tencv;
	}
	public void setTencv(String tencv) {
		this.tencv = tencv;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	
	

}
