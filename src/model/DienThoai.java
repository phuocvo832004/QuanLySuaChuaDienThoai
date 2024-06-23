package model;

public class DienThoai {

	private String IMEI;
	private String tenDt;
	private String loaiDt;
	private String hotenKh;
	private String sdtKh;
	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DienThoai(String iMEI, String tenDt, String loaiDt, String hotenKh, String sdtKh) {
		super();
		this.IMEI = iMEI;
		this.tenDt = tenDt;
		this.loaiDt = loaiDt;
		this.hotenKh = hotenKh;
		this.sdtKh = sdtKh;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getTenDt() {
		return tenDt;
	}
	public void setTenDt(String tenDt) {
		this.tenDt = tenDt;
	}
	public String getLoaiDt() {
		return loaiDt;
	}
	public void setLoaiDt(String loaiDt) {
		this.loaiDt = loaiDt;
	}
	public String getHotenKh() {
		return hotenKh;
	}
	public void setHotenKh(String hotenKh) {
		this.hotenKh = hotenKh;
	}
	public String getSdtKh() {
		return sdtKh;
	}
	public void setSdtKh(String sdtKh) {
		this.sdtKh = sdtKh;
	}
	
	
}
