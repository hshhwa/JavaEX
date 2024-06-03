package ch14;
import java.util.*;

/*
 *  Error
 *  
 *  java.lang.UnsupportedOperationException
 *  이 클래스는 구현 되지 않은 메소드나 메소드가 호출되지 않는 경우 라고 생각하면 된다.
 *  
 *  메소드를 직접 구현하거나 다른 메소드로 대체할 수 있는지 확인해서 예외를 해결
 * 
 * 
 * 
 */


/*
 *  제네릭스( Generics )
 *   
 *   다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능.
 *   
 *   ArrayList
 *   
 *    - 꺼낼때
 *      Down Cating 이 되는지 안되는지가 고려사항.
 *      cating 전에 타입체크가 필요하다.(instanceof type) 
 *    
 *    - 저장 될 때 
 *      원하지 않는 객체가 포함되지는 않을까 하는 고려사항.
 *      
 *   위 고려사항을 해결하면 Collection을 사용하는데 부담이 없어진다. 
 *   
 *   제네릭스 장점
 *    - 타입 안정성을 제공
 *    - 타입체크와 형변환을 생략할 수 있음. -> 코드가 심플해진다.
 *    
 *   제네릭을 사용한 다형성을 항상 생각.
 *    
 *    
 * class Box
 * {
 *   	Object item;
 * 		
 * 
 * 		void setItem(Object item)
 * 		{
 * 			this.item = item;
 * 		}
 * 
 * 		Object getItem()
 * 		{
 * 			return this.item;
 * 		}
 * }
 * 
 * 제네릭 적용
 * class Box<T>
 * {
 *   	T item;
 * 		
 * 
 * 		void setItem(T item)
 * 		{
 * 			this.item = item;
 * 		}
 * 
 * 		T getItem()
 * 		{
 * 			return this.item;
 * 		}
 * {
 * 
 *  용어 정리
 *   - Box<T> : 제네릭 클래스
 *   - T      : 타입 변수
 *   - Box	  : 원시 타입
 *   
 * 인스턴스 생성
 * 	
 *  Box<T> b = new Box<T>();	
 * 	
 *  Box<String> b = new Box<String>();
 *   
 *   - String : 대입된 타입
 *   - Box<String> : 제네릭 타입의 클래스를 호출
 *  
 *  Box<Integer> b = new Box<Integer>(); 
 *  
 * 제네릭의 사용 제한
 * 
 * 
 * - static 멤버에 타입 변수 T를 사용할 수 없다.
 *   -> 인스턴스를 생성하지 않아도 사용 가능.
 *   -> 하지만 타입 변수 T는 인스턴스이다. (컴파일 시점에 T는 타입이 지정된다. 그래서 인스턴스 변수로 간주된다.)
 *   
 *   class Box<T>
 *   {
 *   	class 멤버
 *   	static T item;  // 에러
 *   }	
 * 
 * - 제네릭 타입의 배열 생성을 할 수 없다.
 *	 T[] tmpArr = new T[100];  <- 배열 생성 할 수 없음. 
 * 
 * 
 * - instanceof 연산자, new 연산자에서 타입 변수 T를 피연산자로 사용할 수 없다.
 * 
 * 
 * 제네릭이란?
 * - 인스턴스별로 원하는 타입을 지정해서 사용함으로
 * - 제네릭은 인스턴스 별로 다르게 동작되도록 말려고 하는 자바의 기능. 
 * 

 * 
 */
public class GenericsEx1 {

	public static void main(String[] args) 
	{
		//List arrList = new ArrayList();
		
		// Box class 
		
		// Box에 담을 수 있는 타입.
		// Fruit - Apple
		// Fruit - Grape
		
		// Box에 담을 수 있는 타입 지정 : Fruit Box, Apple Box, Grape Box
		// - Fruit Box 에 담을 수 있는 대상 : Fruit, Apple, Grape
		// - Apple Box 에 담을 수 있는 대상 : Apple
		// - Grape Box 에 담을 수 있는 대상 : Grape
		
		// 과일 전용 박스.
		Box<Fruit> fruitBox = new Box<Fruit>();
		
		// 사과 전용 박스
		Box<Apple> appleBox = new Box<Apple>();
		
		// 포도 전용 박스
		Box<Grape> grapeBox = new Box<Grape>();
		
		// 장난감 전용 박스
		Box<Toy> toyBox = new Box<Toy>();
		
		
		
		
		// 원하지 않는 타입이 저장되지 않도록 타입체크해서 알려준다.
		//Box<Fruit> fruitBox2 = new Box<Apple>();
		//Box<Toy> toyBox2 = new Box<Apple>();
		
		// add() 메소드가 Fruit 타입으로 다형성 매개변수로 적용.
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		// 매개변수의 타입이 Fruit이다. Toy class와 전혀 관계가 없다.
		//fruitBox.add(new Toy());
		
		appleBox.add(new Apple());
		//appleBox.add(new Grape());
		//appleBox.add(new Fruit());
		//appleBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		
		
	}

}


// Box Class
class Box<T>
{
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item)
	{
		list.add(item);
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

// 과일 클래스들

class Fruit
{
	public String toString()
	{
		return "Fruit";
	}
}

class Apple extends Fruit
{
	public String toString()
	{
		return "Apple";
	}
}

class Grape extends Fruit
{
	public String toString()
	{
		return "Grape";
	}
}

class Toy
{
	public String toString()
	{
		return "Toy";
	}
}





