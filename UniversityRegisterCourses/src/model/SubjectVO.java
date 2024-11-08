package model;

public class SubjectVO {
	//멤버변수
	private int no;			//학과 일련번호
	private String s_num;	//학과 번호
	private String s_name;	//학과명
	
	//생성자 오버로딩
	public SubjectVO() {
		super();
	}
	public SubjectVO(String s_num, String s_name) {
		super();
		this.s_num = s_num;
		this.s_name = s_name;
	}
	public SubjectVO(int no, String s_num, String s_name) {
		super();
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	//오버라이딩
	@Override
	public String toString() {
		return "일련번호 : " + getNo() + ", 학과명 : " + getS_name() + ", 학과 번호 : " + getS_num();
	}
	
}
