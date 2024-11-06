package controller;

import java.util.Scanner;

import model.LessonVO;

public class LessonRegisterManager {
	public static Scanner sc = new Scanner(System.in);
	//과목 목록
	public void lessonList()throws Exception{
		LessonDAO id =new LessonDAO();
		System.out.println("과목 전체 리스트");
		id.getLessonTotalList();
		System.out.println();
		String sql = "test Pull Request";
		String test = "test PullRequest2";
	}
	
	// 과목 등록 관리
	public void lessonRegister()throws Exception{
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		
		String l_abbre = null;	//과목약어
		String l_name = null;	//과목명
		
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
		System.out.println("과목 정보 입력");
		System.out.print("과목약어 : ");
		l_abbre = sc.nextLine();
		System.out.print("과목명 : ");
		l_name = sc.nextLine();
		
		lvo.setL_abbre(l_abbre);
		lvo.setL_name(l_name);
		ld.setLessonRegister(lvo);
		
		System.out.println();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}//end of lessonRegister
	
	//과목 수정 관리
	public void lessonUpdate() throws Exception{
		LessonDAO ld = new LessonDAO();
		LessonVO lvo = new LessonVO();
		
		int l_no = 0;			//수정할 과목 일련번호
		String l_abbre = null;	//수정할 과목약어
		String l_name = null;	//수정할 과목명
		
		System.out.println("과목 전체 리스트(사용중인 과목 변경 불가)");
		ld.getLessonTotalList();
		System.out.println();
		
		System.out.println("수정할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = sc.nextInt();
		sc.nextLine();	//입력 버퍼 클리어

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("새로운 과목약어 : ");
		l_abbre = sc.nextLine();
		System.out.print("새로운 과목명 : ");
		l_name = sc.nextLine();
		
		lvo.setNo(l_no);
		lvo.setL_abbre(l_abbre);
		lvo.setL_name(l_name);
		ld.setLessonUpdate(lvo);
		
		System.out.println();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
	}//end of lessonUpdate
	
	//과목 삭제 관리
	public void lessonDelete()throws Exception{
		LessonDAO ld = new LessonDAO();
		int l_no = 0;		//삭제할 과목 일련번호
		
		System.out.println("과목 전체 리스트(사용중인 과목 삭제 불가)");
		ld.getLessonTotalList();
		System.out.println();
		
		System.out.println("삭제할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = sc.nextInt();
		sc.nextLine();	//입력 버퍼 클리어

		ld.setLessonDelete(l_no);
		
		System.out.println();
		System.out.println("과목 전체 리스트");
		ld.getLessonTotalList();
		System.out.println();
		
	}//end of lessonDelete
}//end of class
