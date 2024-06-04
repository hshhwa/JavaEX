package ch15;
import java.util.*;


 /*
 *  상수를 직접 만드는 것. (Enum을 사용하지 않는다.) 과제
 *  
 *  - enum의 구조
 *    - 상수명
 *  1. 부모 클래스
 *    enum Direction { EAST, SOUTH, WEST, NORTH };
 *    - 내부적으로 순서 정보를 관리가 가능해야 한다. ordinal()
 *    - 상수명도 관리가 되어야 한다.
 *  
 *  2. 자식 클래스  
 *    enum Direction { BUS(100)
 *    				   int fare(int distance)
 *    				   {
 *    				   		return distance * BASIC_FARE;		
 *    				   }
 *    				
 *    				 }
 *    Direction 은 자기 자신의 클래스 타입이다.
 *    자기 자신의 클래스 타입이 Direction 클래스에서 상수 멤버의 형태가 되게된다.
 *    
 *  3. main()
 *     1, 2 번에서 구현된 기능(메소드)을 사용.
 *    
 *  - class 를 직접 구현.
 *    상수( 상수명, 상수값, 기능적인 요소 )
 *    
 *    생성자,
 *    
 *    상수명 반환 함수. = name()
 * 
 * 
 * 
 * 
 * 
 * 
 */

// 부모 클래스
abstract class EnumBase
{
	// 순서 정보에 활용되는 정보.
	static int id = 0;
	// enum의 내부 순서 정보.
	private int ordinal;
	// 상수명
	private String name = "";
	
	public String name()
	{
		return this.name;
	}
	
	public int ordinal()
	{
		return ordinal;
	}
	
	protected EnumBase(String name)
	{
		this.name = name;
		ordinal = id++;
	}
	
	
	abstract int fare(int distance);
}

// 부모 클래스 EnumBase를 바탕으로 사용될 Enum 자식 클래스
class TransportationEnum extends EnumBase
{
	public static final TransportationEnum BUS = new TransportationEnum("BUS",1000);
	public static final TransportationEnum CAR = new TransportationEnum("CAR",2000);
	public static final TransportationEnum BIKE = new TransportationEnum("BIKE",3000);
	final int BASIC_FARE;
	
	// 생성자는 반드시 내부에서. private;
	private TransportationEnum(String name, int basicFare)
	{
		super(name);
		this.BASIC_FARE = basicFare;
	}
	
	int fare(int distance) 
	{
		return distance * this.BASIC_FARE;
	}
}


class MyEnum
{
	public static ArrayList<MyEnum> Dirlist = new ArrayList<MyEnum>();
	private final String name;
	private final int value;
	private static int INDEX_COUNT = 0;
	private final int index;
	private MyEnum(String name, int value)
	{
		this.name = name;
		this.value = value;
		this.index = INDEX_COUNT;
		INDEX_COUNT++;
		Dirlist.add(this);
	}
	
	public int getValue() 
	{
		return this.value;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	public static MyEnum getDirinfo(int idx)
	{
		return (MyEnum)Dirlist.get(idx);
	}
	
}

public class EnumEx4 {

	public static void main(String[] args)
	{
//		MyEnum d = null;
//		for(MyEnum tmp : MyEnum.Dirlist)
//		{
//			System.out.println(tmp.getname() + " " + tmp.getValue());
//		}
//		
//		int idx = 0;
//		System.out.println(d.getDirinfo(idx).getname() + " " + d.getDirinfo(idx).getValue());
		
		TransportationEnum t1 = TransportationEnum.BUS;
		
		System.out.println(TransportationEnum.BUS.fare(100) + " 원");
		System.out.println(TransportationEnum.CAR.fare(500) + " 원");
		System.out.println(TransportationEnum.BIKE.fare(500) + " 원");
		
		System.out.println("CAR의 순서정보 : " + TransportationEnum.CAR.ordinal());
		System.out.println("BIKE의 순서정보 : " + TransportationEnum.BIKE.ordinal());
		System.out.println("BUS의 순서정보 : " + TransportationEnum.BUS.ordinal());

		System.out.println("CAR의 이름 : " + TransportationEnum.CAR.name());
		System.out.println("BIKE의 이름 : " + TransportationEnum.BIKE.name());
		System.out.println("BUS의 이름 : " + TransportationEnum.BUS.name());
	}

}
