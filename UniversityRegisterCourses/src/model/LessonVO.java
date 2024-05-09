package model;

public class LessonVO {
	//멤버변수
	private int no;				// 과목 일련번호
	private String l_abbre;		// 과목약어
	private String l_name;		// 과목명
	
	//생성자 오버로딩
	public LessonVO() {
		super();
	}

	public LessonVO(int no, String l_abbre, String l_name) {
		super();
		this.no = no;
		this.l_abbre = l_abbre;
		this.l_name = l_name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getL_abbre() {
		return l_abbre;
	}
	public void setL_abbre(String l_abbre) {
		this.l_abbre = l_abbre;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	
}
