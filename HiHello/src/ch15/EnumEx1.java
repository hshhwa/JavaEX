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
 *  
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
 * 
 * 
 */

enum Direction { EAST, SOUTH, WEST, NORTH }  


public class EnumEx1 {

	public static void main(String[] args) 
	{
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
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
