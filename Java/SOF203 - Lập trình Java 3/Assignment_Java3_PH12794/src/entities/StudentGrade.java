package entities;

public class StudentGrade {
	public String maSV;
	public double tiengAnh;
	public double tinHoc;
	public double GDTC;
	
	public StudentGrade(String maSV, double tiengAnh, double tinHoc, double gDTC) {
		super();
		this.maSV = maSV;
		this.tiengAnh = tiengAnh;
		this.tinHoc = tinHoc;
		GDTC = gDTC;
	}
	
	public double getDTB() {
		return (tiengAnh + tinHoc + GDTC) / 3;
	}
}
