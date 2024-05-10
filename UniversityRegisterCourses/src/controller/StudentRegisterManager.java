package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.StudentVO;

public class StudentRegisterManager {
	public static Scanner sc = new Scanner(System.in);
	// 학생 정보 등록
	public void studentRegister()throws Exception {
		
		SubjectDAO sdao = new SubjectDAO();
		StudentDAO sd = new StudentDAO();
		StudentVO svo = new StudentVO();
		
		String sd_num = null;		//학번
		String sd_name = null;		//이름
		String sd_id = null;		//아이디
		String sd_password = null;	//비밀번호
		String s_num = null;		//학과번호
		String sd_birthday = null;	//생년월일
		String sd_phone = null;		//핸드폰번호
		String sd_address = null;	//주소
		String sd_email = null;		//이메일
		
		boolean id_check = false;	//아이디 체크
		String year = null;			//년도
		
		System.out.println("학생 정보 입력");
		System.out.print("성명 : ");
		sd_name = sc.nextLine();
		
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			sd_id = sc.nextLine();
			id_check = sd.getStudentIdOverlap(sd_id);
			if(id_check) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
			}
		}while(id_check);
		
		System.out.print("비밀번호(12자 이내) : ");
		sd_password = sc.nextLine();
		
		sdao.getSubjectTotalList();
		
		System.out.print("학과번호 : ");
		s_num = sc.nextLine();
		
		//학생 번호는 8자리로 생성한다. (연도2자리+학과2자리+일련번호 = 예06010001)
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		year = sdf.format(new Date());
		sd_num = year + s_num + sd.getStudentCount(s_num);
		
		System.out.print("생년월일(8자리) : ");
		sd_birthday = sc.nextLine();
		System.out.print("전화번호 : ");
		sd_phone = sc.nextLine();
		System.out.print("도로명 주소 : ");
		sd_address = sc.nextLine();
		System.out.print("이메일 : ");
		sd_email = sc.nextLine();
		
		svo.setSd_num(sd_num);
		svo.setSd_name(sd_name);
		svo.setSd_id(sd_id);
		svo.setSd_password(sd_password);
		svo.setS_num(s_num);
		svo.setSd_birthday(sd_birthday);
		svo.setSd_phone(sd_phone);
		svo.setSd_address(sd_address);
		svo.setSd_email(sd_email);

		sd.setStudentRegister(svo);
		
		System.out.println();
		System.out.println("등록 학생 정보");
		sd.getStudent(svo.getSd_id(), svo.getSd_password());
		System.out.println();
		
	}// end of studentRegister
	
	//학생 정보 수정
	public void studentUpdate() throws Exception{
		StudentDAO sdao = new StudentDAO();
		StudentVO svo = new StudentVO();
		
		String id = null;			//입력아이디
		String pw = null;			//입력 비밀번호
		String sd_num = null;		//학번
		String sd_password = null;	//수정 비밀번호
		String sd_phone = null;		//수정 전회번호
		String sd_address = null;	//수정 주소
		String sd_email = null;		//수정 이메일
		
		boolean success = false;
		
		System.out.println("학생 정보 수정");
		do {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.println("비밀번호 : ");
			pw = sc.nextLine();
			success = sdao.getStudentLogin(id, pw);
			
			if(!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}
		}while (!success);
		
		sd_num = sdao.getStudentNum(id, pw);
		System.out.println();
		System.out.println("수정할 학생");
		System.out.println("학생번호 : "+sd_num);
		
		System.out.print("비밀번호(12자 이내) : ");
		sd_password = sc.nextLine();
		System.out.print("전화번호 : ");
		sd_phone = sc.nextLine();
		System.out.print("도로명 주소 : ");
		sd_address = sc.nextLine();
		System.out.print("이메일 : ");
		sd_email = sc.nextLine();
		
		svo.setSd_num(sd_num);
		svo.setSd_password(sd_password);
		svo.setSd_phone(sd_phone);
		svo.setSd_address(sd_address);
		svo.setSd_email(sd_email);

		sdao.setStudentRegister(svo);
		System.out.println();
		System.out.println("등록 학생 정보");
		sdao.getStudent(svo.getSd_id(), svo.getSd_password());
		System.out.println();
	}//end of studentUpdate
	
	//학생 전체 목록
	public void studentTotalList() throws Exception{
		StudentDAO sdao = new StudentDAO();
		
		String pw =null;
		
		System.out.println("학생 정보 전체 목록");
		System.out.print("관리자 비밀번호 : ");
		pw = sc.nextLine();
		
		if(pw.equals("admin1234")) {
			sdao.getStudentTotalList();
		}else {
			System.out.println("관리자 비밀번호가 틀립니다.");
		}
	}
}//end of class
