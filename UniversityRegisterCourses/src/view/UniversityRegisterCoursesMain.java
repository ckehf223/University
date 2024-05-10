package view;

import java.util.Scanner;

import controller.LessonRegisterManager;
import controller.StudentRegisterManager;
import controller.SubjectRegisterManager;
import controller.TraineeRegisterManager;

public class UniversityRegisterCoursesMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		mainMenu();
	}

	// 메인 메뉴
	public static void mainMenu() {
		int choiceNum = 0;

		while (true) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = sc.nextInt();
				sc.nextLine(); // 입력 버퍼클리어

				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT:
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT:
					studentMenu();
					break;
				case MENU_CHOICE.LESSON:
					lessonMenu();
					break;
				case MENU_CHOICE.TRAINEE:
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		} // end of while
	}// end of mainMenu

	// 수강 신청 메뉴
	public static void traineeMenu() throws Exception {
		int choice = 0;

		TraineeRegisterManager traineeManager = new TraineeRegisterManager();
		MenuViewer.traineeMenuView();
		choice = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 클리어

		switch (choice) {
		case TRAINEE_CHOICE.LIST:
			System.out.println("");
//			traineeManager.traineeList();
			break;
		case TRAINEE_CHOICE.INSERT:
			System.out.println("");
//			traineeManager.traineeRegister();
			break;
		case TRAINEE_CHOICE.UPDATE:
			System.out.println("");
//			traineeManager.traineeDelete();
			break;
		case TRAINEE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}// end of traineeMenu

	// 학과 메뉴
	public static void subjectMenu() throws Exception {
		int choice = 0;

		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		MenuViewer.subjectMenuView();
		choice = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 클리어

		switch (choice) {
		case SUBJECT_CHOICE.LIST:
			System.out.println("");
			subjectManager.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT:
			System.out.println("");
			subjectManager.subjectRegister();
			break;
		case SUBJECT_CHOICE.UPDATE:
			System.out.println("");
			subjectManager.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE:
			System.out.println("");
			subjectManager.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");

		}
	}// end of subjectMenu

	// 학생 메뉴
	public static void studentMenu() throws Exception {
		int choice = 0;

		StudentRegisterManager studentManager = new StudentRegisterManager();
		MenuViewer.studentMenuView();
		choice = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 클리어

		switch (choice) {
		case STUDENT_CHOICE.INSERT:
			System.out.println("");
			studentManager.studentRegister();
			break;
		case STUDENT_CHOICE.UPDATE:
			System.out.println("");
			studentManager.studentUpdate();
			break;
		case STUDENT_CHOICE.LIST:
			System.out.println("");
			studentManager.studentTotalList();
			break;
		case STUDENT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");

		}
	}// end of subjectMenu

	// 과목 메뉴
	public static void lessonMenu() throws Exception {
		int choice = 0;

		LessonRegisterManager lessonManager = new LessonRegisterManager();
		MenuViewer.lessonMenuView();
		choice = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 클리어

		switch (choice) {
		case LESSON_CHOICE.LIST:
			System.out.println("");
//			lessonManager.lessonList();
			break;
		case LESSON_CHOICE.INSERT:
			System.out.println("");
//			lessonManager.lessonRegister();
			break;
		case LESSON_CHOICE.UPDATE:
			System.out.println("");
//			lessonManager.lessonUpdate();
			break;
		case LESSON_CHOICE.DELETE:
			System.out.println("");
//			lessonManager.lessonDelete();
			break;
		case LESSON_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");

		}
	}// end of subjectMenu

}// end of class
