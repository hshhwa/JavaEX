package ch3;


/**
 * 연산자의 종류
 * - 산술 : 사칙연산, 나머지 연산(%)
 * - 비교 : >, <,>=, <=, == ,!=
 * - 논리 : &&(and), ||(or), !(not)
 * - and : 조건 두 가지 모두 참인경우, true
 * - or  : 조건 두 가지중 하나만 참이면, true
  
 * - 대입 : =
 * - 기타 : instance of, (), ? :,
 * 
 * 연산자의 우선순위
 * 
 * 산술 변환
 * - 연산전에 타입을 일치시키기 위해서 자동 형변환 되는 것.
 * - 작은 자료형에서 큰 자료형으로 변환.
 * - int 보다 작은 타입이면, int로 변환된다.
 * 
 * 
 * 단항연산자의 동작
 * - 전위형 : 값이 참조되기 전에 먼저 증감이 발생. ex) ++i
 * - 후위형 : 값이 참조된 후에 증감이 발생.      ex) i++
 * 
 * 조건 연산자(3항식)
 * - 조건식 ? 식1(true일때) : 식2(false일때)
 * 
 */
public class OperatorEx {

	public static void main(String[] args) 
	{
		
		int i = 5;
		
		System.out.println(i++); // 후위형
		
		i = 5;
		System.out.println(++i); // 전위형
		
		int a = 5, b = 0;
		b = a++;
		System.out.println("a = " + a + ", b = " + b);

		//산술변환
		//- int 보다 작은 경우는 int 로 자동 변환됨.
		byte b2 = 10;
		byte b3 = 20;
		//byte b4 = b2 + b3;       // b2 + b3는 int임.
		                           // int를 byte로 하려고 함.
		byte b4 = (byte)(b2 + b3); // 값 소실 가능성이 있음.
		System.out.println(b4);
		
		
		// 변수 초기화 표현 스타일 -> 가독성이 좋아진다.
		int read1 = 1000000;
		int read2 = 1_000_000;
		
		long long1 = 1_000_000 * 1_000_000;
		long long2 = 1_000_000 * 1_000_000L;
		
		// 비교연산
		System.out.println('0' == 0);
		System.out.println('0' != 0);
		System.out.println('A' > 'B');
		System.out.println('A' < 'B');
		System.out.println('B' == 66);
		
		// 문자열인 경우의 논리연산. 문자열은 참조형(주소값).
		String str1 = "abc";  // str1 에는 주소값이있다.
		                      // 논리연산은 문자열 값인 abc가 비교되도록 해야한다.
		// String 참조형의 경우 == 대신에 equals() 메소드를 사용해서 비교해야한다.
		System.out.println(str1.equals("abc"));
		System.out.println(str1.equals("def"));
		
		
		// and, or 논리 연산.
		System.out.println(0 < 10 && 10 < 20);
		System.out.println(100 < 10 || 10 < 20);
		
		// !(논리 부정 not) 연산
		System.out.println(!(0 < 10 && 10 < 20));
		
		System.out.println(!!(0 < 10 && 10 < 20));
		
		// 조건 연산자
		System.out.println(0 < 10 ? true : false);
		System.out.println(0 > 10 ? true : false);
		
		// 복합 대입 연산자
		// i = i + 1;
		// i += 1;
		
		
		
	}

}
