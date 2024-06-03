package ch14;

import java.util.ArrayList;
import java.util.*;

/*
 *  제한된 제네릭 클래스
 *  
 *  1. 클래스 관계에 대한 제한 -> 제네릭에 다형성 적용 ***** 중요포인트 *****
 *  
 *  Box<T> b = new Box<T>();
 *  
 *  T 대신에 어떤것 이라도 올 수 있다. Apple, Grape, Toy..등
 *  제한을 두고 싶은데, 클래스 간의 관계를 통해서 제한을 둘 수 있다.
 *  
 *  Object
 *  Fruit
 *  Apple
 *  
 *  현재는 Type 변수 T에 하나만 올 수 있고, 뭐든지 올 수 있다.
 *  Fruit 를 상속 받은 것들만 T에 올 수 있도록 하고 싶다. ( 제한 -> 관계 제한 )
 *  
 *  
 *  class FruitBox<T>
 *  {
 *  	ArrayList<T> list = new ArrayList<T>();
 *  }
 *  
 *  
 *  Fruit 를 상속 받은 것들만 T에 올 수 있도록
 *  ( T가 어떤 것이 올지는 모르겠지만, Fruit를 상속 받은 객체만 허용 하겟다. 
 *    따라서, Fruit를 상속 받은 것만 이라는 제한이 생긴다. -> Apple, Grape
 *  )
 *  class FruitBox<T extends Fruit> -> 다형성
 *  {
 *   	컴파일 전
 *  	ArrayList<T> list = new ArrayList<T>();
 *  	컴파일 후
 *  	ArrayList<Fruit> list = new ArrayList<Fruit>();
 *  }
 * 
 *  제한 적용 전의 기존사용법
 *  class FruitBox<Apple>
 *  {
 *  	ArrayList<T> list = new ArrayList<T>();
 *  }
 *  
 *  class FruitBox<Grape>
 *  {
 *  	ArrayList<T> list = new ArrayList<T>();
 *  }
 *  
 *  
 *  2. 인터페이스 구현에 대한 제한.
 *  
 *  T extends Fruit
 *  T에 오는 실제 타입 클래스에 interface 구현을 강제하고 싶다.
 * 
 *  - 인터페이스의 작성시 구성 요소.
 *    상수, 추상메소드(강제성), 디폴트 메소드(강제성x)
 *  
 *  Fruit, Apple, Grape -> 공통적인 요소인 먹다를 추상메소드로 강제성을 부여하고 싶다.
 *  
 *  interface Eatable {}
 *  
 *  T extends Fruit & Eatable <- Generic 클래스 선언.
 *  1. Fruit를 상속받은 것만 올 수 있도록 제한 한다.
 *  2. Eatable interface를 구현한 것만 올 수 있도록 제한 한다. 
 *  
 *  주의사항 : interface를 구현시 implements 키워드를 사용 했지만,
 *           제네릭에서는 implements키워드를 사용하지 않고, extends 를 사용한다.
 *           
 *           
 *  T extends Fruit : Fruit 자신과 Fruit를 상속 받은 것만 허용. 
 *  T extends Eatable : Eatable interface를 구현한 것만 허용.
 * 
 * 
 */

public class GenericsEx2 {

	public static void main(String[] args) 
	{
		// ------------------------- 클래스 관계에 대한 제한 예제 --------------------------
		
		// Fruit2 Box
		// FruitBox2 에는 Apple, Grape를 담을 수 있다.
		FruitBox2<Fruit2> Fruit2box = new FruitBox2<Fruit2>();
		
		/*
		 * 컴파일전
		 * ArrayList<T> list = new Arraylise<T>();
		 *
		 * 컴파일후 -> Apple, Grape도 담을 수 있게 된다.
		 * ArrayList<Fruit2> list = new Arraylise<Fruit2>();
		 * 
		 */
		
		
		// Apple2 Box
		FruitBox2<Apple2> Apple2box = new FruitBox2<Apple2>();
		
		/*
		 * 컴파일전
		 * ArrayList<T> list = new Arraylise<T>();
		 *
		 * 컴파일후 -> Apple2만 담을 수 있게 된다. -> 다형성이 적용 되지 않음.
		 * -> ArrayList에 저장할 수 있는 타입은 파생 클래스 타입.
		 * -> Fruit2를 담을 수 없고, Grape2 와 Apple2은 서로 관계가 없다.
		 * -> 그래서, Arraylist 에는 Apple2만 담을 수 있다.
		 * ArrayList<Apple2> list = new Arraylise<Apple2>();
		 * 
		 */
		// Grape2 Box
		FruitBox2<Grape2> Grape2box = new FruitBox2<Grape2>();
		// Toy Box
		Box2<Toy2> Toy2box = new Box2<Toy2>();
		
		// 제네릭 제한이 다형성으로 적용되도록 했으므로,
		// 과일을 담을 때, 다형성이 적용되도록 담아야 한다.
		// 각 Box에 과일 담기
		
		Fruit2box.add(new Fruit2());
		
		// 제네릭 제한 -> 다형성 적용된 것을 확인.
		Fruit2box.add(new Apple2());
		Fruit2box.add(new Grape2());
		
		// Apple만 담을 수 있는 Box
		// 제네릭 클래스 에서는 다형성을 적용 하지만.
		// 실제 T에 대한 타입이 기반 클래스 타입이 아닌,
		// 파생 클래스 타입으로 지정했으므로,
		// 정확하게는 다형성을 활용하고 있지 못하는 상태다.
		Apple2box.add(new Apple2());
//		Apple2box.add(new Fruit2());
//		Apple2box.add(new Grape2());
		

		System.out.println("Fruit2box : " + Fruit2box);
		// ------------------------- 클래스 관계에 대한 제한 예제 --------------------------
		
		
		
		
		
		// -------------------------  인터페이스 구현에 대한 제한 --------------------------
		/*
		 *  1. Eatable을 기반쪽에 구현하지 않는 경우.
		 *  2. Eatable을 파생쪽에만 구현한 경우.
		 *     모두 에러
		 *  3. Eatable을 기반쪽에 구현한 경우.
		 *     기반만 에러
		 *  4. Eatable을 기반쪽에 구현한 경우.
		 *     모두 정상
		 *     
		 *     
		 *  --- 구현해보세요 ---
		 *  1. 프로그램에서 사용중인 Collection 에서 Iterator 구하기.
		 *  2. 표준 api 이용해서 오버라이딩된 toString()을 사용.
		 *  3. Fruit2 기반 클래스의 interface를 구현한 eat_String()를 사용해 보세요.
		 *  4. 왜 안되는지 생각해보기.
		 *     왜 안되는지를 OOP 4대 특성과 연결지어서 생각해 볼 것.
		 *  
		 *  
		 */
		// 1번
		Iterator boxiter = Fruit2box.list.iterator();
		
		// 2번
		while(boxiter.hasNext())
		{
			// 3번
			//System.out.println(boxiter.next().toString());
			// Object <- Fruit2 <- Apple
			// Object에서 오버라이딩 된 파생클래스의 메소드를 호출.
			// 상속관계에서 메소드는 자식을 따라간다.
			
			// 4번
			// it.next().eat_toString();
			// eat_toString() 메소드는 Fruit2 가 가지고 있다.
			// 그래서 Fruit2로 다운캐스팅 해야한다. -> 제네릭에서 형변환이 필요 없는 것이 장점인데
			//                                  case by case 이다. 

			//((Fruit2)boxiter.next()).eat_String();
			// 현재 interface에 구현된 쪽은 부모 클래스만 되어있다.
			// 자식의 eat_String() 을 해도 부모쪽의 메소드가 호출됨.
			
			// 만약에 자식 클래스에 eat_String() 구현한다면??
			// -> 자식의 메소드 접근은 인스턴스 타입을 따라 감으로
			//    Down cating이 필요해진다.
			
			// instanceof Apple 로 형변환 가능한지, Grape로 형변환 가능한지 확인 후
			// donw Cating을 해야 한다.
			
				Eatable tmp = (Eatable)boxiter.next();
				System.out.print(tmp.toString() + tmp.eat_String() + " ");

		}
		
		Iterator<Fruit2> Eatiter = Fruit2box.list.iterator();
		System.out.println();
		
		while(Eatiter.hasNext())
		{
			// None Cating
			Eatable tmp = Eatiter.next();
			System.out.print(tmp.toString() + tmp.eat_String() + " ");
		}
		
		// -------------------------  인터페이스 구현에 대한 제한 --------------------------
		
		/*
		 * Juicer class로 Juice 만들기
		 * 
		 * 
		 * 
		 */
		System.out.println(Juicer.makeJuice(Fruit2box));
		//System.out.println(Juicer.makeJuice(Apple2box));
		
		
		
		
	}// end of main()
	

}
// 제네릭의 제한 활용 예제.

// Box class : row type class -> 제네릭 클래스를 적용.


// Fruit Box : 클래스 간의 관계 제한 -> 제네릭을 활용.
// Fruit2 또는 파생 클래스는 반드시 Eatable을 구현해야 한다.
// Fruit2 에서implements Eatable를 작성하지 않으면, 컴파일 에러가 발생한다.
// -> 강제 구현 시키고 있다는 것이다. (implements)& Eatable

class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {}


// 제네릭 제한용 interface

interface Eatable
{
	abstract void eat();
	
	abstract String eat_String();
}

// Fruit의 공통 기능(추상 메소드)을 강제 하도록 구현. -> 제네릭을 활용.

class Fruit2 implements Eatable
{
	// Object의 toString()을 오버라이딩한 메소드
	public String toString()
	{
		return "Fruit2";
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String eat_String() {
		return "과일 먹기";
	}

}

// Fruit의 파생 클래스
class Apple2 extends Fruit2
{
	public String toString()
	{
		return "Apple2";
	}
	
}

class Grape2 extends Fruit2
{
	public String toString()
	{
		return "Grape2";
	}
}

class Toy2
{
	
}

//Box Class
class Box2<T>
{
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item)
	{
		list.add(item);
	}
	
	ArrayList<T> getList()
	{
		return list;
	}
	T get(int i)
	{
		return list.get(i);
	}
	
	int size()
	{
		return list.size();
	}
	
	public String toString()
	{
		return list.toString();
	}
}


// FruitBox를 이용한 쥬스를 만드는 클래스
/* 
 * FruitBox의 종류 : FruitBox(Apple, Grape), AppleBox(Apple 전용), GrapeBox(Grape 전용)
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

class Juicer
{
	/*
	// 컴파일 전
	static Juicer makeJuice(FruitBox2<Fruit2> box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	
	static Juicer makeJuice(FruitBox2<Apple> box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	
	static Juicer makeJuice(FruitBox2<Grape> box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	
	// 컴파일 후 -> 메소드 중복 정의가 발생하게 된다.
	static Juicer makeJuice(FruitBox2 box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	
	static Juicer makeJuice(FruitBox2 box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	
	static Juicer makeJuice(FruitBox2 box)
	{
		// 작업 후 Juice를 반환하는 기능.
	}
	*/
	// 와일드 카드 적용 ->  메소드의 중복 선언을 막기 위한 용도로 사용한다.
	// 메소드 중복의 해결 방법은 기반 타입으로 매개변수 타입이 되도록 하는 것이다.
	// <? super T> : 하한 제한. T와 그 부모만 가능하다.  <= 사용된 와일드 카드
	// <? extends T> : 상한 제한. T와 그 자식들만 가능하다.
	// <?> : 제한이 없음. 모든 타입이 가능하다. <? extends Object>
	
	
	public static Juice makeJuice(FruitBox2<? super Fruit2> box)
	{
		String tmp = "";
		
		for(Fruit2 f : box.getList())
		{
			tmp += f + "";
		}
		return new Juice(tmp);
	}
}

class Juice
{
	String name;
	
	Juice(String name)
	{
		this.name = name + " Juice";
	}
	public String toString()
	{
		return name;
	}
}








