package ch4;

/**
 * 조건문
 * - if, switch
 * - if - else if - else
 * 
 * 중첩 조건문 => 가독성을 고려해야 한다. 길어지면 가독성이 심하게 떨어짐. 리팩토링을 고려해야 함.
 * 
 * 반복문
 * - for, while, do while  -> 최근 사용결과 가독성이 많이 떨어짐.
 * => foreach, stream, 람다  -> 가독성과 유지보수가 뛰어남. 적용할 수 없는지 고려(리팩토링 이유)
 * => 코드 품질이 향상된다.
 * 
 * - for문
 *   for(초기화; 조건식; 증감식)
 *   {
 *   }
 *   
 * - 향상된 for문
 *   for(초기화(변수 선언) : 배열및 자료구조)
 *   
 * - while문
 *   while(조건식)
 *   {
 *     반복 처리 실행하기 전에 조건이 만족하는지 확인.
 *   }
 *   
 * - do while(조건식)
 *   {
 *     조건 확인 없이 한 번 실행한 후 반복 조건이 만족하는지 확인.
 *   }
 *   
 * - 반복문 제어
 *   break    : 반복문 종료 용도
 *   continue : 반복은 유지하되 조건에 해당되면 건너뛰기.
 *   이름 붙은 반복분 : 가독성이 엄청 낮음. 리팩토링 대상
 *    
 *    
 * - 무한반복
 *   for(;;)
 *   {
 *     경우에 따라 무한반복 조건 체크 후 종료.
 *   }
 *   while(true)
 *   {
 *     경우에 따라 무한반복 조건 체크 후 종료.
 *   }
 *   
 * 
 */

public class FlowEx {

	public static void main(String[] args) 
	{
		if(0 < 10)
		{
			System.out.println("0은 10보다 작다");
		}
		else
		{
			System.out.println("0은 10보다 작지 않다.");
		}
		
		int a = 10;
		
		if(a == 10)
		{
			
		}
		else if(a > 10)
		{
			
		}
		else if(a > 100)
		{
			
		}
		else
		{
			
		}
		
		// switch
		// - 조건식을 계산 (조건식의 결과는 정수 상수 또는 문자열) 
		// - 조건의 결과와 맞는 case로 이동
		// - 이후의 문장을 실행
		// - break를 만나기 전까지 실행.
		
		
		// 중첩 switch는 가독성을 악화시킨다. 
		switch(3)
		{
		case 3:
			System.out.println("3");
			break;
		case 2:
			System.out.println("2");
			break;
		case 1:
			System.out.println("1");
			break;
		}
		
		// for 반복문
		for(int i = 0; i <= 5; i++)
		{
			System.out.println(i);			
			if(i == 3)
			{
				break;
			}
		}
		
		// 배열 처리하는 경우 => for 활용.
		int[] arr = {1,2,3,4,5};  // 배열의 요소가 5개. 각 요소마다 위치값이 있다. 정수.
		// -> 위치정보는 0 ~ ...; 0부터 시작한다.
		for(int i= 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		// 배열 처리하는 경우 => 향상된 for 활용
		// 배열과 collection 에서 활용.
		for(int tmp : arr)
		{
			System.out.println(tmp);
		}
		
		//while 문
		int i = 1;  //반복의 초기화
		
		while(i <= 5) //조건식
		{
			System.out.println(i);
			i++; //증감식
		}
		
		i = 5;
		
		// 후위형 : 참조 후에 증감
		while(i-- != 0) // 4, 3, 2, 1, 0
		{
			System.out.println(i); // 먼저 참조 후 조건판단.
		}
		
		i = 5;
		// 전위형 : 참조 전에 증감
		while(--i != 0) // 4, 3, 2, 1
		{
			System.out.println(i); // 증감 후 조건 판단.
		}
		
		// 어쩌다 보니 이런 경우
		//for(int j = 0; j < 5; j++);  // 괄호 뒤에; 가 있음.
		//{ 
		//   for 문의 block 이라고 생각하지만, 위의 ;로 인해서 그냥 block로 됨.
		//	 System.out.println(j);
		//}
		
		// continue 사용
		for(i = 0; i <= 10; i++)
		{
			//반복제어
			if(i % 3 == 0)
			{
				continue;  // 건너뛰기 용도.
			}
			
			System.out.println(i);
		}
		
		// 이름 붙은 반복문(이런게 있다 정도만)
		// 가능하면 다른 방법으로 구현.
		Loop1 : for(i = 2; i < 9; i++)
		{
			if(i == 7)
			{
				break Loop1;
			}
			System.out.println(i);
		}
	}

}
