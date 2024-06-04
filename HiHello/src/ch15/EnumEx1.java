package ch15;

/*
 *  열거형( enums )
 *   - 관련된 상수를 한 곳에 모아서 사용하기 위해쓴다.
 *  
 *  열거형의 정의
 *   - enum Direction { EAST, SOUTH, WEST, NORTH  }
 *   
 *   - class Unit
 *   {
 *   	int x, y;       // 위치 정보
 *   	Direction dir;  // 방향 정보
 *   
 *   	void init()
 * 		{
 * 			dir = Direction.EAST; // 열거형 이름.상수명
 *   	}
 * 
 *   }
 *   
 *  열거형의 부모 - java.lang.Enum
 *   - name()    : 상수의 이름을 문자열로 반환한다.
 *   - ordinal() : 열거형 상수가 정의된 순서를 정수로 반환 한다. (0부터 시작)
 *   - valueOf() : 매개변수와 일치하는 열거형 상수를 반환 한다.
 *  열거형의 활용 및 확장
 *   - 상수간의 비교에 '==' 연산자 사용가능.
 *     equals 메소드 보다 연산이 빠르다.
 *     열거형의 비교는 다른 열거형과는 비교는 할 수 없음.
 *   - 비교 연산자를 사용 못한다. ( <, >, 등등)
 *   - compareTo() 사용가능.
 *     비교 대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면, 음수를 반환한다.
 *   - case 문에서 사용시 반드시 상수 이름을 사용한다.
 *   
 *   - 열거형의 확장
 *     - 기능적인 요소를 추가 -> 인스턴스 변수, 생성자, 메소드, 추상 메소드 -> 클래스와 비슷한 형태이다.
 *     
 *     상수에 불연속적인 값으로 설정하는 경우 필요한 추가 사항.
 *     - 인스턴스 변수, 생성자(private)를 반드시 추가해야 한다.
 *     - getter가 필요하다.
 *     - 인스턴스 변수, 생성자를 작성하지 않으면, 컴파일 에러가 발생한다.
 *     
 *     enum Direction
 *     {
 *     		상수명, 상수값 으로 구성이 된다.
 *     		EAST(1), SOUTH(5), WEST(-1), NORTH(10);
 *     
 *     		상수명, 상수값, 심볼
 *     		EAST(1, ">"), SOUTH(5, ">"), WEST(-1, ">"), NORTH(10, ">");
 *     
 *     		상수에 기능을 추가
 *     		교통 수단 관련 상수, 상수값을 기본요금
 *     		BUS(10000)
 *     		TRAIN(20000)
 *     		
 *     		private final int value;
 *     		Direction(int value) 
 *     		{
 *     		 //private 를 생략해도, private 생성자이다. 
 *     		}
 *     		public int getValue() 
 *     		{
 *     			return value;
 *     		}
 *     
 *     		심볼 정보 관리와
 *     }
 *  
 *  
 *  class Card
 *  {
 *  	static final int CLOVER = 0; 카드의 무늬
 *  	static final int HEART = 1;
 *  	static final int DIAMOND = 2;
 *  	.
 *  	.
 *  	.
 *  
 *  
 *  	static final int TWO = 0;    카드의 숫자
 *  	static final int THREE = 1;
 *  	final int kind;
 *  	final int num; 
 *  }
 * 
 * class Card
 * {
 * 		enum Kind {CLOVER, HEART, ...}
 * 		enum Value { TWO, THREE }
 * 		final int kind;
 *  	final int num;
 * }
 * 
 * 
 * 
 */

enum Direction { EAST, SOUTH, WEST, NORTH }  
// -> 내부적으로 관리되는 순서 정보 -> 정수형이며 0부터 시작한다.

enum Direction2 { EAST, SOUTH, WEST, NORTH }  

public class EnumEx1 {

	public static void main(String[] args) 
	{
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		Direction2 d4 = Direction2.EAST;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		//Direction.EAST == Direction2.EAST
		System.out.println("d1 == d4" + (d1 == d2));
		
		//System.out.println("d1 == d4" + (d1 == d4));
		
		//System.out.println("Direction.EAST == Direction2.EAST : " + d1 == d4);
		
		// Enum의 상수 정보를 배열로 반환.
		Direction[] dirArr = Direction.values();
		
		for(Direction d : dirArr)
		{
			System.out.printf("%s=%d%n",d.name(), d.ordinal());
		}
		
		switch(d1)
		{
		case EAST:
			System.out.println("EAST");
			break;
		case SOUTH:
			System.out.println("SOUTH");
			break;
		default:
			System.out.println("없는 정보");
		}
	}

}
