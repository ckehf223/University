package controller;

import java.util.Scanner;

import model.LessonVO;
import model.TraineeVO;

public class TraineeRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 수강 신청 리스트
	public void traineeList() throws Exception {
		String sd_num = null; // 학번
		String id = null; // 아이디
		String pw = null; // 비밀번호
		String mainMenu = null; // 메인 메뉴
		boolean success = false;

		TraineeDAO td = new TraineeDAO();
		StudentDAO sdao = new StudentDAO();

		System.out.println("수강 신청한 리스트");
		do {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			pw = sc.nextLine();
			
			success = sdao.getStudentLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = sc.nextLine();
				if (mainMenu.toLowerCase().equals("y")) {
					return;
				}
				System.out.println();
			}
		} while (!success);

		sd_num = sdao.getStudentNum(id, pw);
		System.out.println();
		System.out.println("수강 신청한 리스트");
		td.getTraineeTotalList(sd_num);
		System.out.println();
	}// end of traineeList

	// 수강 신청 관리
	public void traineeRegister() throws Exception {
		TraineeDAO td = new TraineeDAO();
		TraineeVO tvo = new TraineeVO();
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		StudentDAO sdao = new StudentDAO();

		String sd_num = null; // 학번
		String l_abbre = null; // 과목약어
		String t_section = null; // 과목구분
		String id = null; // 아이디
		String pw = null; // 비밀번호
		String mainMenu = null; // 메인메뉴
		boolean success = false;

		System.out.println("수강 가능 과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();

		System.out.println("수강 신청을 위한 정보 입력");
		do {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			pw = sc.nextLine();

			success = sdao.getStudentLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = sc.nextLine();
				if (mainMenu.toLowerCase().equals("y")) {
					return;
				}
				System.out.println();
			}
		} while (!success);

		sd_num = sdao.getStudentNum(id, pw);
		
		System.out.println("학번 : "+ sd_num);
		System.out.print("과목약어(영문 대문자) : ");
		l_abbre = sc.nextLine();
		System.out.print("과목구분(교양,전공,부전공) : ");
		t_section = sc.nextLine();
		
		tvo.setSd_num(sd_num);
		tvo.setL_abbre(l_abbre);
		tvo.setT_section(t_section);
		
		//수강 신청 등록
		td.setTraineeRegister(tvo);
		
		System.out.println();
		System.out.println("수강 신청한 리스트");
		td.getTraineeTotalList(sd_num);
		System.out.println();
	}//end of traineeRegister
	
	//수강 취소 관리
	public void traineeDelete() throws Exception {
		TraineeDAO td = new TraineeDAO();
		StudentDAO sdao = new StudentDAO();
		
		String sd_num = null; 	// 학번
		int t_no = 0;			// 수강 번호
		String id = null; 		// 아이디
		String pw = null; 		// 비밀번호
		String mainMenu = null; // 메인메뉴
		boolean success = false;
		
		System.out.println("수강 취소를 위한 정보 입력");
		do {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			pw = sc.nextLine();

			success = sdao.getStudentLogin(id, pw);
			
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
				System.out.print("메인 메뉴로 이동(y/n) : ");
				mainMenu = sc.nextLine();
				if (mainMenu.toLowerCase().equals("y")) {
					return;
				}
				System.out.println();
			}
		} while (!success);

		sd_num = sdao.getStudentNum(id, pw);
		
		System.out.println();
		System.out.println("수강 신청한 리스트");
		td.getTraineeTotalList(sd_num);
		System.out.println();
		
		System.out.println("취소할 강의 일련번호 입력");
		System.out.print("일련번호 : ");
		t_no = sc.nextInt();
		sc.nextLine();		//입력 버퍼 클리어
		
		td.setTraineeDelete(t_no);
		
		System.out.println();
		System.out.println("수강 신청 취소 후 리스트");
		td.getTraineeTotalList(sd_num);
		System.out.println();
	}//end of traineeDelete
}
