package lab7;
 class PolyStudent {
	public String fullName;
	public Career career;

	public void print() {
		System.out.println(">Fullname: " + this.fullName);
		switch (this.career) {
		case UDPM:
			System.out.println(">Career: Ứng dụng phần mềm");
			break;
		case TKTW:
			System.out.println(">Career: Thiết kế trang web");
			break;
		case LTDĐ:
			System.out.println(">Career: Lập trình di động");
			break;
		case TKĐH:
			System.out.println(">Career: Thiết kế đồ họa");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + career);
		}
	}
}
