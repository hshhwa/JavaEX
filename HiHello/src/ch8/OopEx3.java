package ch8;

/**
 *  - 다형성(polymorphism : 폴리모피즘)
 *  
 *    다양한 형태를 가지고 있음. => 일반적인 의미.
 *    한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함. => JAVA OOP에서의 의미.
 *    => 타입 변환 => 형변환(cating) 
 *    
 *    class Tv {}                         -> 부모클래스
 *    class TvVcr extends Tv {}           -> 자식클래스
 *    class TvCation extends TvCation {}  -> 자식클래스
 *    
 *    
 *    
 *    Tv t = new Tv();                -> 부모 클래스
 *    TvVcr tvcr = new TvVcr();       -> 자식 클래스
 *    TvCation tvca = new TvCation(); -> Tv로 부터 파생된 클래스이다.
 *    
 *    Tv t = new TvVcr(); -> 다형성, 인스턴스는 TvVcr인데, 참조 변수의 타입은 Tv인 부모 클래스 타입이다
 *     
 *    Tv t = new TvCation();
 *    -> Tv 라는 하나의 타입으로 TvVcr, TvCation의 인스턴스 타입으로 표현함.
 *    
 *  - 다형성으로 표현된 클래스가 인스턴스가 되었을 때.
 *    
 *    Tv tv = new TvVcr();       메모리의 인스턴스는 tvVcr 이다.
 *                               참조변수의 타입이 기반
 *                               따라서, 부모 클래스의 범위 내에서 사용가능. 사용제한이 있다.
 *                               비록 인스턴스는 TvVcr 이지만 Tv의 멤버들만 사용할 수 있다.
 *                               그래서, TvVcr의 모든 것을 사용하려면 다운 casting 해야한다.
 *                               
 *                               
 *    TvVcr tvcr = new TvVcr();  메모리의 인스턴스는 TvVcr 이다.
 *                               참조변수의 타입이 자기자신.
 *                               따라서, 자식 클래스 자신의 범위내에서 사용가능. 사용제한이 없다.
 *    
 *    현재 까지 배운 내용에서의 다형성의 장점
 *    
 *    Tv tv = new Tv();
 *    Tv tv = new TvVcr();
 *    Tv tv = new TvCamera();
 *    Tv tv = new TvGame();
 *    Tv tv = new TvCdPlayer();
 *    
 *    다양한 타입의 인스턴스들을 하나의 타입으로 표현할 수 있다.
 *    Tv[] tvArr = new Tv[100];
 *    
 *    Tv[0]= new TvVcr();
 *    Tv[1]= new TvCamera();
 *    Tv[2]= new TvGame();
 *    Tv[3]= new TvCdPlayer();
 *    
 *    
 *    형변환(casting)
 *    1. up casting   : 자식 -> 부모   자동형변환
 *                      자바는 단일상속만 허용 / 자식 입장에서 부모는 무조건 하나임으로 자동 형변환.
 *                      
 *    2. down casting : 부모 -> 자식   명시적형변환
 *                      부모 입장에서는 자식이 경우에 따라서 여러개 일수 있다.
 *                      down casting 대상이 누가 될 지 알수 없으므로 명시적 형번환을 해야한다.
 *       
 * - instanceof 연산자
 *   메모리 상의인스턴스 상태까지 고려해주는 것은 아님.
 *   그래서, 상속관계의 상태만 고려해주는 것이다.
 *   
 *   참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보는 용도로 사용.
 *   
 * - 다형성의 활용과 instanceof 연산자의 용도
 *   매개변수를 활용한 다형성 -> 메소드의 매개변수가 다형성을 띄고 있다.
 *   -> 전달된 인스턴스의 참조변수 타입에 따라 해당 인스턴스의 멤버변수 사용시 범위를 알 수 있기 때문
 *   
 *   반환타입을 활용한 다형성 -> 메소드의 반환형타입이 다형성을 띄고 있다.
 *   -> 메소드를 호출한 쪽에서 현재 참조변수가 누구의 인스턴스인지 확인이 필요한 경우가 있기 때문
 *   
 *   매개변수를 활용하는 메소드의 경우, 반환형을 사용하는 메소드의 경우(void 제외)
 *   오버로딩을 통해서 동일한 기능을 하는 메소드가 많아지면, 유지보수가 힘들어 짐으로
 *   부모 클래스 타입으로 매개변수와 반환형을 적용하면 관리해야 할 메소드가 줄어든다.
 *   따라서 유지보수가 간편해 질 수 있는 장점이 있다.
 *   
 * - 참조변수와 인스턴스의 연결  
 *  
 *   
 * 
 * 
 * 
 * 
 */

public class OopEx3 {

	public static void main(String[] args) 
	{
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		
		// 다형성 적용한 코드
		car = fe;               // 인스턴스는 자식클래스 인데, 참조변수 타입은 부모클래스이다.
		car = (Car)fe;          // -> up casting 자동 형변환
		
		// car 참조 변수의 인스턴스 사용 범위 고려
	    // car.water();         // 자식 인스턴스의 멤버를 사용할 수 없음.
	
		fe2 = (FireEngine)car;  // down cating 명시적 형변환
		// runtime error가 발생하지 않고 정상 실행.
		// 메모리 상에는 FireEngine의 인스턴스가 있음.
		// FireEngine 자식클래스는 부모 클래스인 Car 로부터 상속된 상태이다.
		// 메모리상의 FireEngine 내부에는 Car가 있는 것이다.
		// 따라서, 메모리상에는 Car도 존재하고, FireEngine도 존재한다.
		// 그래서 up,down cating이 가능하다.
		fe2.water();
		fe2.drive(); // Car.dirve()  부모클래스의 인스턴스의 멤버 사용이 가능하다.
		
		// ############## 다운 캐스팅이 고려할 사항
		// 업, 다운이 모두 다되는 경우가 있고, 아닌 경우가 있다.
		
		Car car2 = new Car();
		Car car3 = null;
		FireEngine fe3 = null;
		
		car2.drive();
		
		if(car2 instanceof FireEngine)
		{
			System.out.println("car2 = FireEngine instance");
		}
		if(car2 instanceof Car)
		{
			System.out.println("car2 = Car instance");
		}
		//fe3 = (FireEngine)car2;   // down casting
		                          // donw casting의 본질적인 목적은
		                          // 자식 클래스 인스턴스의 멤버들을 사용하기 위함.
		// 현재 메모리의 인스턴스는 Car만 존재하고 있다.
		// 그래서 메모리에는 donw casting 해서 사용할 FireEngine이 없는 상태이다.
		// 따라서 존재하지 않는 FireEngine의 멤버를 사용하기 위해 donw casting 한다는 자체가 말이 안된다.
		
		// FireEngine의 멤버를 사용하기 위해 시도해본 결과,
		// 메모리에 존재하지 않는다는 것이 확인되어 실행 에러가 발생한다. -> 비정상 종료가 된다.
		
		
		/**
		 * 현재의 인스턴스는 Car이다. FireEngine이 아니다.
		 * 메모리에 있는 인스턴스는 Car임으로
		 * FireEngine 으로 다운 캐스팅 하더라도 Car에만 존재하고 있으므로,
		 * FireEngine의 멤버들을 사용할 수 없다.
		 * 
		 * 에러의 종류 : 문법 에러, 실행 에러(Runtime Error)
		 *            문법적으로는 정상적인 것이지만, 실제 메모리상의 존재 인스턴스에 위배되는 코드로
		 *            실행이 됨으로 Runtime 에러가 발생하게 된다.
		 * 다형성을 활용하는 코드 작성시, 반드시 메모리 상의 인스턴스 상태를 고려해서 코드를 작성해야한다.
		 *            
		 */
		
		
		//############ instance of 연산자
		FireEngine fe4 = new FireEngine();
		
		// 현재코드는 up casting 가능여부 확인.
		if (fe4 instanceof FireEngine)
		{
			System.out.println("up casting - FireEngine instance");
			FireEngine fe5 = (FireEngine)fe4;
		}
		
		if (fe4 instanceof Car)
		{
			System.out.println("up casting - Car instance");
			Car car4 = (Car)fe4;
		}
		
		if (fe4 instanceof Object)
		{
			System.out.println("up casting - Object instance");
			Object obj = (Object)fe4;
		}
		
		
		
		
		// donw cating 가능 여부 확인
		Object fe5 = new FireEngine();
		
		if (fe5 instanceof Object)
		{
			System.out.println("down casting - Object instance");
			Object obj = (Object)fe5;
		}
		
		if (fe5 instanceof Car)
		{
			System.out.println("down casting - Car instance");
			Car obj = (Car)fe5;
		}
		
		if (fe5 instanceof FireEngine)
		{
			System.out.println("down casting - FireEngine instance");
			FireEngine obj = (FireEngine)fe5;
		}
		if (fe5 instanceof Object)
		{
			System.out.println("down casting - Object instance");
			Object obj = (Object)fe5;
		}
		
		if (fe5 instanceof Ambulance)
		{
			System.out.println("down casting - Ambulance instance");
			Ambulance obj = (Ambulance)fe5;
		}
		
		
		// ##참조변수와 인스턴스의 연결 관련###############################
		// casting 후 사용되는 멤버 변수와 멤버 메소드를 확인.
		Parent p = new Child();
		Child c = new Child();
		
		
		// 오버라이딩 된 상태에서 up casting 인 경우.
		// 멤버 변수를 사용하는 경우. -> 참조변수의 타입을 따라간다.
		// 멤버 함수를 사용하는 경우. -> 인스턴스의 클래스 타입을 따라간다.
		
		
		// 참조변수의 타입이 Parent 인 경우
		// Child 의 멤버변수 및 멤버메소드를 사용.
		// up cating이 되었다고 가정 -> 부모 클래스의 멤버를 사용하려는 목적.
		System.out.println("p.x = "+ p.x);  // 부모클래스의 멤버변수 성공.   부모 멤버
		p.method();                         // 부모클래스의 멤버메소드 실패.  자식 멤버
		
		
		
		// 참조변수의 타입이 Child 인 경우
		// Child 의 멤버변수 및 멤버메소드를 사용.
		System.out.println("c.x = "+ c.x);  // 자식클래스 자신의 멤버변수 성공.
		c.method();                         // 자식클래스 자신의 멤버메소드 성공.
		
		
		// ### 참조변수와 인스턴스의 연결 관련 2
		// 부모클래스에만 멤버가 있고, 자식클래스에 멤버가 없는 경우.
		Parent2 p2 = new Child2();
		Child2 c2 = new Child2();
		
		System.out.println("p2.x = " + p2.x);
		p2.method();
		
		System.out.println("c2.x = " + c2.x);
		c2.method();
		
		
	} // end of main()

}

// 참조변수와 인스턴스의 연결관련클래스
class Parent
{
	int x = 100;
	
	void method()
	{
		System.out.println("Parent : method");
	}
}

class Child extends Parent
{
	int x = 200;
	void method()  // 메소드 오버라이딩
	{
		System.out.println("Child : method");
	}
}

class Parent2
{
	int x = 100;
	
	void method()
	{
		System.out.println("Parent : method");
	}
}

class Child2 extends Parent2
{
	
}

//참조변수 형변환 관련 클래스

class Car
{
	String color;
	int door;
	void drive()
	{
		System.out.println("운행중.....");
	}
	void stop()
	{
		System.out.println("정지!!!");
	}
}

class FireEngine extends Car
{
	void water()
	{
		System.out.println("화재 진압중...");
	}
}

class Ambulance extends Car
{
	void siren()
	{
		System.out.println("사이렌중...");
	}
}







