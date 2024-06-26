package ch16;

/*
 *  메서드 참조
 *  
 *  람다식을 더욱 간결하게 표현할 수 있는 방법.
 *  
 *  Function<String, String> f = (String s) -> Interger.parseInt(s);
 *  
 *  Integer wrapper(String s) {
 *  	return Integer.parseInt(s);
 *  }
 * 
 *  Function<String, String> f = Interger::parseInt;
 *  
 *  - 메소드 참조 스타일로 코드를 작성해도 문제가 없이 동작하는 배경이 있다. ( 컴파일러 입장 )
 *    1. parseInt 코드를 보고, Integer 의 parseInt() 메소드라고 생각한다.
 *    2. Function 인터페이스의 지정된 제네릭 타입으로 부터 매개변수 정보를 알 수 있다.
 *    3. (String s) -> Interger.parseInt(s) 형태라는 것을 알게 된다.
 *  
 *  -람다식 형태
 *   BiFunction<String, String, Boolean> f
 *   								= (s1, s2) -> s1.equals(s2);
 *  -메소드 참조 형태
 *   BiFunction<String, String, Boolean> f = s1::equals
 *   
 *  메소드 참조 형태의 코드 작성(람다식 작성)은
 *  	"참조변수"::메소드 이름, "클래스이름::메소드 이름" 로 줄여서 사용 할 수 있다.
 *  
 *  MyClass obj = new MyClass();
 *  Function<String, Bollean> f = (s) -> obj.equal(s);
 *  Function<String, Bollean> f = obj::equal
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class LambdaEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
