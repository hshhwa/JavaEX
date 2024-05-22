package ch2;

// https://github.com/jongyeonsim2/Megazone2024_JAVA
// 강사님 깃허브 주소
	


/**
 * 변수의 초기화
 * - 변수를 사용하기 전에 처음으로 값을 저장하는 것.
 * 
 * 변수의 명명
 * - 대소문자 구분, 길이 제한이 없음.
 * - 예약어 사용 불가
 *   int
 * - 숫자로 시작하면 안됨.
 * - 특수문자는 _ $ 만 가능.
 * 
 * 
 * 변수의 타입
 * - 기본형 : int
 *   논리형 ( boolean ), 문자형 ( char ),
 *   정수형 ( byte(1byte), short(2byte), int(4byte, 약 +-20억), long(8byte) ),
 *   실수형 ( float(4byte), double(8byte) )
 * - 참조형 : 객체의 주소값
 * 
 * 
 * 상수
 * - 변수와 달리 값을 한 번 저장하면 변경이 불가.
 * - final int MAX_SPEED = 10;  final 키워드
 * 
 * 형변환(casting)
 * - 변수를 다른 타입의 변수로 변환하는 것.
 * - 기본형에 대한 형변환 보다 참조형에 대한 형변환이 중요.
 * - 자동 형변환의 규칙
 * - 기본의 값을 최대한 보존할 수 있는 타입으로 자동 형변환이 이루어진다.
 *   byte > short > int > long > float > double
 *   char > int
 */

public class VarEx1 {

	public static void main(String[] args) 
	{
	
		int year = 0;
		int age = 14;
		// sysout 입려 후 ctrl + space 표준입력 불러오기
		
		System.out.println(year);
		System.out.println(age);
		
		year = age + 2000;
		age = age + 1;
		
		System.out.println(year);
		System.out.println(age);
		
		final int MAX_SPEED = 10;
		System.out.println(MAX_SPEED);
		//MAX_SPEED = MAX_SPEED + 0; // 값을 보호. 빨간줄 생김
		
		char ch = 'A';
		//char ch2 = 'AA'; 불가
		//char ch3 = "AA"; 불가 문자열로 변수 초기화 할려는 행위.
		String str = "AA";
		System.out.println(str);
		
		float f = 9.12345678901234567890f;
		double d = 9.12345678901234567890d;
		
		
		System.out.println(f);
		System.out.println(d);
		
	
		double d2 = 85.4d;
		int score = (int)d2;
		
		System.out.println(score);
		
		double d3 = 85.5d;
		int score2 = (int)d3;
		
		System.out.println(score2);
		
		char ch3 = 'A'; // 아스키코드표 대문자 A = 65
		int intA = (int)ch3;
		
		
		System.out.println(ch3);
		System.out.println(intA);
	}
	
	

}

