package ch14;

import java.nio.file.Path;
import java.util.*;

/*
 *	 와일드 카드 적용 ->  메소드의 중복 선언을 막기 위한 용도로 사용한다.
 *	 메소드 중복의 해결 방법은 기반 타입으로 매개변수 타입이 되도록 하는 것이다.
 *	 <? super T> : 하한 제한. T와 그 부모만 가능하다.  <= 사용된 와일드 카드
 *	 <? extends T> : 상한 제한. T와 그 자식들만 가능하다.
 *	 <?> : 제한이 없음. 모든 타입이 가능하다. <? extends Object>	 
 */

/*
 *   와일드 카드의 상한 제한 관련 코드
 * 
 * 
 *
 *
 *
 *  제네릭 메소드
 *   메소드의 선언부에 제네릭 타입이 선언된 메소드 이다.
 *   
 *   static 멤버에서는 제네릭을 사용하지 못한다. 하지만 왜 될까?
 *   -> 제네릭 메소드에서는 제네릭 타입이 지역 변수처럼 메소드 내에서 지역적으로만 사용됨으로 가능하다.
 *   
 *   
 *   Collections.sort(null);
 *   
 *   -> 호출   public static <T> void sort(List<T> list) -> 제네릭 메소드 
 *    		  {
                  list.sort(null);
     		  }
     
     제네릭 부분의 와일드 카드를 제거해서 확인.
    
     		  public static <T extends Comparable> void sort(List<T> list) 
     		  {
        		  list.sort(null);
    		  }
     <T extends Comparable> 제한된 제네릭 클래스
     -> 관계성을 적용하려고 한다. -> Comparable와의 관계를 적용하겟다.
     Comparable 인터페이스를 구현 한다.
     
     - List<T>의 요소는 Comparable 인터페이스를 구현한 것이어야 한다.
     		  
     		  
 * 
 * 
 */




public class GenericsEx3 {

	public static void main(String[] args) 
	{
		
		Collections.sort(null);
		
		
		
		
		
		
		// sort(List<Object> list, Comparator<? super Object> c)
		// 1. list, Comparator<Apple3>	
		// 2. list, Comparator<Grape3>
		// 3. list, Comparator<Fruit3>
		
		// Collections.sort() 의 두 번째 매개변수가
		// 왜? 하한제한 와일드 카드를 적용 하였는지.
		
		/*
		 * Java의 api 
		 * 
		 * 
		 * 
		 * 
		 * sort(List<Object> list, Comparator<? super Object> c)
		 * 
		 * 따라서, 기반 타입의 Fruit 만 있으면 된다. -> 다형성이 적용 되었다.
		 * FruitComparator 만 구현 하면 된다.
		 * 
		 * 
		 */
		
		FruitBox3<Fruit3> fruitbox3 = new FruitBox3<Fruit3>();
		fruitbox3.add(new Apple3("Apple", 10));
		fruitbox3.add(new Grape3("Grape", 40));
		fruitbox3.add(new Fruit3("Fruit", 20));
		
		System.out.println(fruitbox3.getList());
		
		Collections.sort(fruitbox3.getList(), new FruitSort());
		
		System.out.println("내림 차순");
		System.out.println(fruitbox3.getList());
		
		//강의
		FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
		FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();
		FruitBox3<Fruit3> fruitBox = new FruitBox3<Fruit3>();
		
		appleBox.add(new Apple3("YellowApple", 200));
		appleBox.add(new Apple3("YellowApple", 100));
		appleBox.add(new Apple3("YellowApple", 300));
		
		grapeBox.add(new Grape3("GreenGrape", 500));
		grapeBox.add(new Grape3("GreenGrape", 300));
		grapeBox.add(new Grape3("GreenGrape", 200));
		
		Collections.sort(appleBox.getList(), new AppleComparator());
		Collections.sort(grapeBox.getList(), new GrapeComparator());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		Collections.sort(appleBox.getList(), new FruitComparator());
		Collections.sort(grapeBox.getList(), new FruitComparator());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		
		
		
		//강의
	}

}
// Collections.sort() 의 두 번째 매개변수로 사용될 Comparator를 구현해야 함.
// Comparator<Apple3> 구현
// Comparator<Grape3> 구현
// Comparator<Fruit3> 구현



// 강의
class AppleComparator implements Comparator<Apple3>
{

	public int compare(Apple3 o1, Apple3 o2) 
	{
		return o1.weight - o2.weight;
	}
}
class GrapeComparator implements Comparator<Grape3>
{

	public int compare(Grape3 o1, Grape3 o2) 
	{
		return o1.weight - o2.weight;
	}
}

class FruitComparator implements Comparator<Fruit3>
{

	public int compare(Fruit3 o1, Fruit3 o2) 
	{
		return o1.weight - o2.weight;
	}
}



//강의

class FruitSort implements Comparator<Fruit3>
{
	@Override
	public int compare(Fruit3 o1, Fruit3 o2) 
	{
		if(o1 instanceof Comparable && o2 instanceof Comparable)
		{
			System.out.println("변환가능");
		}
		else
		{
			Integer I1 = o1.weight;
			Integer I2 = o2.weight;
			return I1.compareTo(I2);
		}
//		Comparable c1 = (Comparable)o1;
//		Comparable c2 = (Comparable)o2;
//		
//		return c1.compareTo(c2);
		return 0;
	}
}

class Fruit3
{
	String name;  // 과일 이름
	int weight;   // 과일 무게
	
	Fruit3(String name, int weight)
	{
		this.name = name;
		this.weight = weight;
	}
	
	public String toString()
	{
		return this.name + "( " + this.weight + " )";
	}

}

class Apple3 extends Fruit3
{
	Apple3(String name, int weight)
	{
		super(name, weight);
	}
}

class Grape3 extends Fruit3
{
	public Grape3(String name, int weight)
	{
		super(name,weight);
	}
}

class FruitBox3<T extends Fruit3> extends Box3<T> {}


//Box Class
class Box3<T>
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
