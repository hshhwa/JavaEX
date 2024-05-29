package ch11;
/*
 *  - 지금까지 중요한 부분
 *    - OOP 4대 특성의 개념, 활용, 코드레벨로 이해해야한다.
 *      개인적으로 또는 스터디 그룹으로 공부 중에 4대 특성과 관련된 새로운 적용 사례.
 *      정리 잘 해 두어야 한다.
 *    - 추상화, 다형성
 *    - 인터페이스 -> 다형성 -> 약결합 -> 생산성 향상
 *      상속도 다형성이 된다. 하지만 상속은 강결합. 수정이 없을 경우, 상속을 적용.
 *    - 인터페이스를 활용한 약결합 예제 많이 연습해야 한다. -> 리팩토링 책, 디자인 패턴
 *    - 리팩토링( 초보 <- 우리가볼꺼 , 아키텍처, DDD, TDD )
 *    
 *    
 * -------------------------- 내부 클래스 ---------------------------------
 * 
 *  클래스 : 멤버변수, 멤버함수
 * 
 *  내부(inner) 클래스
 *   클래스 안에 클래스를 선언하는 이유는 그만큼 클래스간의 밀접도(긴밀도)가 높다는 것이다.
 *   
 *   장점  
 *   1. 멤버변수처럼 쉽게 접근이 가능
 *   2. 코드의 복잡성이 줄어든다(캡슐화)
 *   
 *   종류 : 인스턴스변수, 클래스변수, 지역변수, 익명(무명 noname)클래스
 *       - 인스턴스 클래스
 *          인스턴스 멤버처럼 다루어진다. 멤버변수 선언 위치에 선언.
 *       - static 클래스
 *          static 멤버처럼 다루어짐. static 멤버 변수 선언 위치에 선언.
 *       - 지역 클래스
 *          외부 클래스의 메소드, 초기화 블럭 안에 위치.
 *       - 익명 클래스
 *          클래스 이름이 없는 상태이다.( 클래스 코드만 있는 상태 )
 *          코드를 한 번 실행하면 끝난다. 1회성.
 *          -> 클래스 선언과 객체 생성이 동시에 된다.
 *       
 *  
 *  
 *  
 *  
 *  class ClassA     <- outer class
 *  {
 *     class ClassC  <- inner class  -> 캡슐화
 *     {
 *     
 *     }
 *  }
 *  
 *  class ClassB
 *  {
 *  
 *  }
 *  
 *  
 *  
 *  class Outer
 *  {
 *    class InstanceInnerClass {}      // 인스턴스 클래스
 *    static class StaticInnerClass {} // Static 클래스
 *    
 *    void MyMethod()
 *    {
 *      class LocalInnerClass {}       // 지역 클래스
 *    }
 *  }
 * 
 * 
 * 
 * ---------------------- 익명 클래스 ------------------------
 * 
 * 이름이 없는 클래스. 클래스 선언과 동시에 인스턴스 생성.
 * 단 한번만 사용될 수 있고( 하나의 객체만 생성 ), 일회용 클래스 이다.
 * 
 * - 이름이 없기 때문에 생성자를 가질 수 없음.
 * - 기반 클래스 이름 또는 interface의 이름을 사용해서 정의
 * - 기반 클래스도 단일상속, interface도 단일 implement
 * 
 * 버튼을 예시로
 * 버튼은 눌렀을 때, 기능이 동작해야 한다
 *  -> 눌러졌다는 것을 인식해야 한다. event 라고함.
 *     -> 누름 -> 인식
 *         누름과 인식 사이에 모니터링 해야한다. -> 수행할 내용을 작성.
 * Button b = new Button("눌러주세요!!");
 * 
 * 안드로이드 앱 사용자가 버튼을 클릭 했다는 것은 아래의 addActionListener가 호출된다.
 * b.addActionListener( 수행해야 할 Action 인스턴스를 매개변수로 전달 한다. 
 *                      인스턴스를 생성.
 * 버튼이 눌러졌을 때, 인스턴스가 생성되어야 한다. -> 익명클래스
 * 
 *   new ActionListener()
 *   {
 *     public void actionPerformed(ActionEvent e)
 *     {
 *       System.out.println("버튼이 눌러졌음"); <- 작성해야 하는곳.
 *     }
 *     
 *     
 *   } // 익명 클래스의 끝
 * 
 * );  // addAtctionListener 의 끝
 *
 */


 // ---------------------- 익명 클래스 ------------------------
class AnonumousClass
{
	// 자기 이름이 없기 때문에 기반 클래스의 이름을 사용해서 정의.
	
	Object obj = new Object() { void method() {}}; // 익명클래스
	
	static Object obj2 = new Object() { void method() {}}; // 익명클래스
	
	void myMethod()
	{
		Object obj3 = new Object() { void method() {}}; // 익명클래스
	}
	
	
}
 // ---------------------- 익명 클래스 ------------------------
 


// --------------- 멤버 메소드, 클래스 메소드에서 멤버클래스 및 지역 클래스 접근 ------------------------

class Outer
{
	class InstanceInner
	{
		
	}
	static class StaticInner
	{
		
	}
	
	// 인스턴스 멤버 변수가 인스턴스 클래스에 접근
	// 인스턴스 멤버간의 접근.
	InstanceInner iv = new InstanceInner();
	
	// static 멤버 변수가 static 클래스에 접근
	static StaticInner cv = new StaticInner();
	
	
	// Outer의 instance 메소드
	void instanceMethod()
	{
		// instance의 특성은 instance와 static 모두 접근 가능.
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//LocalInner lv;
	}
	
	// Outer의 static 메소드
	static void staticMethod()
	{
		// static은 instance에 접근 못한다.
		// static은 static에만 접근이 가능하다.
		
		//InstanceInner obj1 = new InstanceInner();  <- 안됨 static이 instance에 접근.
		StaticInner obj2 = new StaticInner();  
		//LocalInner lv;
		
	}
	
	void MyMethod()
	{
		// 지역 클래스
		class LocalInner
		{
			
		}
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		LocalInner lv = new LocalInner();
		
	}
}


// --------------- 멤버 메소드, 클래스 메소드에서 멤버클래스 및 지역 클래스 접근 ------------------------


// --------------- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용----------------------------

class Outer2
{
	class InstanceInner
	{
		int iv = 100;
	}
	static class StaticInner
	{
		int iv = 200;
		static int cv = 300;
	}
	
	void MyMethod()
	{
		class LocalInner
		{
			int iv = 400;
		}
	}
}

// --------------- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용----------------------------


//--------------- Outer, Inner class 에서 this 사용 ----------------------------

class Outer3
{
	int value = 10;
	
	class Inner
	{
		int value = 20;
		
		void method1()
		{
			int value = 30;
			// method1 에서 value 변수 사용 -> 3가지 케이스를 고려.
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value);
			System.out.println("Outer3.this.value = " + Outer3.this.value);
		}
	}
}

//--------------- Outer, Inner class 에서 this 사용 ----------------------------





public class OopEx8 
{
	// instance 와 static 사용 차이점.
	
	// --------------- Inner class의 인스턴스 생성 방법 ------------------------
	
	class InstanceInner
	{
		int iv = 100;
		 static int cv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner
	{
		int iv = 200;
		static int CV = 200;
	}
	
	void MyMethod()
	{
		class LocalInner
		{
			int iv = 300;
			 static int cv = 300;
			final static int CONST = 300;
		}
	}
	
	// --------------- Inner class의 인스턴스 생성 방법 ------------------------
	
	
	
	
	public static void main(String[] args) 
	{
		// --------------- Inner class의 인스턴스 생성 방법 ------------------------	
		
		// InstanceInner.CONST 는 inner class의 멤버라도
		// static 변수임으로 바로 접근이가능하다.
		System.out.println(InstanceInner.CONST);
		
		// InstanceInner는 Instance 클래스
		// Outer class의 객체부터 생성 해야만 접근이가능하다.
		// InstanceInner 클래스도 다시객체를 생성해야만
		// InstanceInner 의 멤버인 iv를 접근할 수 있다.
		//InstanceInner ii = new InstanceInner();  <- 안됨
		
		OopEx8 outer = new OopEx8();
		OopEx8.InstanceInner inner = outer.new InstanceInner();
		
		System.out.println(inner.iv);
		// --------------- Inner class의 인스턴스 생성 방법 ------------------------
		
		
		// --------------- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용----------------------------
		// 이너 클래스 사용을 위해서는 Outer 클래스의 인스턴스를 먼저 생성.
		Outer2 oc = new Outer2();
		Outer2.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer2.StaticInner.cv : " + Outer.cv);
		
		// static inner class 의 인스턴스 변수 사용.
		Outer2.StaticInner si = new Outer2.StaticInner();
		System.out.println("Outer2.StaticInner si.iv : " + si.iv);

		// --------------- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용----------------------------
		
		//--------------- Outer, Inner class 에서 this 사용 ----------------------------
		
		Outer3 o3 = new Outer3();
		Outer3.Inner i3 = o3.new Inner();
		i3.method1();

		//--------------- Outer, Inner class 에서 this 사용 ----------------------------
		
		
		// ---------------------- 익명 클래스 적용 전 후 ------------------------
		
		
		
		// ---------------------- 익명 클래스 적용 전 후 ------------------------
		
		
	}

}
