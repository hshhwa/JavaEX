package ch6;


/**
 *  - 객체지향의 공부 방법
 *    캡슐화, 상속, 추상화, 다형성 이란?
 *    
 *    논리적인 개념을 코드로 어떻게 표현을 하는지? => 문법
 *    
 *    4대 특성이 어떤 경우에 활용하는지?
 *    
 *    클래스 설계시 유지보수성을 고려하려면 어떻게 해야 하는지?
 * 
 *  - 객체지향의 장점
 *    코드의 재사용성이 높다.
 *     -> 기존 코드를 활용하기 위함.
 *    코드의 관리가 용이하다.
 *     -> 쉽게 코드를 변경할수 있다.
 *    신뢰성이 높은 프로그래밍을 가능하게 한다.
 *     -> 재사용성이 높고, 변겅이 쉬워 코드의 불일치가 줄어든다.
 *    
 * - 클래스와 객체
 *   클래스는 객체(메모리에 로딩)를 정의해 놓은것. 객체를 생성하는데 사용.
 *   
 *   변수 -> 배열 -> 구조체(C언어, 여러가지 기본형 타입을 하나로 묶음) -> 클래스 (정보 + 기능)  정보 : 속성, 필드, 멤버변수 / 기능 : 메소드, 함수 
 *                stugrade (학생정보, 교과목 정보, 평가정보)      String 클래스
 *                학생성적을 관리할 수 있는 새로운 자료형            정보(char 배열), 대문자바꾸기,잘라내기,치환하기 기능 등등..
 *                
 *                단점으로는 정보만 관리되고 있어, 기능이 없음.
 *                학생의 주소 변경을 쉽게 하기 위한 기능이 없음.
 *                
 *   객체의 정의 : 실제로 존재하는 것. 사물 또는 개념 이라고한다.
 *   객체의 용도 : 객체가 가지고 있는 기능과 속성(정보)에 따라 다름.
 *              객체를 사용한다는 것은 객체가 가지고 있는 속성과 기능을 사용한다는 의미이다.
 *   
 *   
 *   유형의 객체 : 컴퓨터, 강의실, 학생 등
 *   무형의 객체 : 논리적인 것들.
 *   
 *   
 *   객체(object)와 인스턴스(instance)
 *   - 클래스로 부터 객체를 만드는 과정을 클래스의 인스턴스화(메모리에 적재)라고 함.
 *   - 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 함.
 *   
 *   - 인스턴스화는 객체화 라고 함.
 *   
 *   -객체의 구성요소
 *   속성(property) : 멤버변수, 필드, 상태, 특성 
 *   기능(function) : 메소드, 함수, 행위
 *   
 *   
 *   - 인스턴스는 참조변수를 통해서만 접근이 가능.
 *     참조변수의 타입은 인스턴스의 타입과 일치해야 한다.
 *     
 *   - 객체 배열
 *     객체배열에 저장되는 값은 instance의 주소값 이다.
 *     
 *   - 변수와 메소드
 *   변수 : 클래스 변수, 인스턴스 변수, 지역 변수 등(매게변수 등)
 *         구분 기준은 선언된 위치에 따름.
 *         
 *   클래스 변수 : 모든 인스턴스에서 공유할 수 있는 변수.
 *              인스턴스화를 거치지 않아도 사용 가능.
 *   인스턴스 변수 : 인스턴스마다 고유한 상태를 유지해야 하는 변수.
 *              객체가 생성이 되어야만 사용 가능.
 *   지역 변수 : 해당 블럭(구역)에서만 사용하고, 그 범위를 벗어나면 사용할 수 없게 되는 변수.(메소드 내에 선언된 변수, 매게변수)
 *   
 * - 메소드
 *   특정 작업을 수행하는 일련의 문장들의 묶음.
 *   
 *   사용하는 이유 : 높은 재사용성, 중복된 코드의 감소, 프로그램의 구조화
 *               리팩토링시 메소드를 자주 활요하게 됨.
 *               
 *   구조 : 선언부(메소드의 머리), 구현부(메소드의 몸통)
 *   
 *   반환타입의 메소드 : 반환이 없으면, void를 사용.
 *                 반환형에 맞추어서 반환타입을 사용. 마지막에 return.
 *                 반환타입과 return 타입이 동일해야 함.
 *   매개변수 : 기본형, 참조형
 *       기본형 -> 변수의 값을 읽기만 할 수 있음.(read only)
 *       참조형 -> 변수의 값을 수정할 수 있음.  (read & write)
 *       
 *   참조형 반환타입 : 참조변수의 값(instance의 주소)이 반환.
 *   
 *   클래스 메소드와 인스턴스 메소드
 *    클래스 메소드 : static 키워드를 사용하면 됨.
 *                인스턴스와 관계없는 작업을 수행.
 *    
 *    인스턴스 메소드 : static 키워드를 사용하지 않음.
 *                 인스턴스 변수와 관련된 작업을 수행.
 *                 인스턴스로 생성되어야만 호출이가능.
 *                 
 *    - 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로
 *      사용하는 것에 static을 붙인다.
 *    - 클래스 변수(static 변수)는 인스턴스를 생성하지 않아도 사용 가능.
 *    - 클래스 메소드(static 메소드)는 인스턴스 변수를 사용할 수 없다.
 *    - 메소드 내에서 인스턴스 변수를 사용하지 않는다면, static를 붙이는것을 고려한다.
 *   
 *   - 오버로딩
 *   한 클래스 내에서 같은 이름의 메소드를 여러 개 정의하는 것.
 *   조건 : 메소드 이름이 동일. 매개변수의 개수와 타입으로 구분.
 *      : (static,메소드의 반환타입)은 조건에 해당되지 않음.
 *   장점 : 메소드의 이름만 보더라도 이 메소드의 기능을 예상할 수 있음.
 *       : 메소드의 이름을 절약.
 *   
 *   - 가변 매개변수
 */

public class OopEx {

	// 프로그램의 시작점.
	public static void main(String[] args) 
	{
		// 다른 클래스를 재사용해서 코딩.
		// String 과 같은 API 대신에 사용자 정의 클래스를 사용.
		
		Tv test; // 변수만 선언된 상태이지, 인스턴스(메모리 적대) 상태가 아님. null인 상태
		      // test는 참조변수이고, 참조변수가 초기화가 안된상태임.
		      // 기본 초기화인 상태임. null로 초기화 되어 있음.
		Tv t = new Tv(); // 참조변수가 null에서 실제 tv 객체의 주소로 초기화 됨.
		                    // 사용할 수 있는 상태.
		                    // 멤버변수 접근가능, 메소드 호출가능.
		
		//멤버변수 초기화 전의 상태
		// color  => null
		// power  => false  
		// channel => 0
		
		
		// 멤버변수 초기화
		
		
		//t.channel = 21;
		//t.channel = -100; // 논리적으로 채널이 마이너스인 경우는 없음.
		                  // 문제점은 멤버변수를 함부로 접근하도록 하면 안됨.
		                  // 해결방법은 직접접근이 아닌 간접 접근이 되도록 하는 기능.
					      // 기능에서 유효한 값으로 멤버변수 초기화되도록 체크.
						  // 체크해서 문제가 없다면, 멤버변수에 적용.
		
					      // 정리
		 				  // 멤버변수에 접근제어자가 필요.
						  // 메소드가 필요.(세터 Setter())
		 				  // 
		t.power();
		t.channelUp();
		//System.out.println(t.channel + " " + t.power + " " + t.color);
		
		Tv t2 = new Tv();
		
		// Tv 객체 배열
		Tv t3, t4, t5;          // 변수 3개로 관리하게 됨.
								// 만약에 Tv가 1000대 라면...
		Tv[] TvArr = new Tv[3]; // 하나의 배열로 3개의 Tv를 관리.
		                        // Tv가 1000대라도 변수는 1개;
		
		// 위의 new Tv는 자세히 보면 ()가없다.
		// 객체 3개로 만들어 질것이라고 생각하면 안된다.
		// 단지 주소값 3개를 저장할 수 있는 배열이 만들어 진 것이다.
		// 3개의 요소는 모두 null 상태임.
		
		// 각 요소에 객체를 생성해서 그 객체의 주소값을 배열의 요소에 저장해야 한다.
		// 그래야 객체배열을 생각한대로 사용이 가능해짐.
		
		// 객체 배열의 요소 초기화
		Tv[] TvArr2 = {new Tv(),new Tv(),new Tv()};
		TvArr[0] = new Tv();
		TvArr[1] = new Tv();
		TvArr[2] = new Tv();
		
		
		t.Setchannel(-100);
		System.out.println(t.Getchannel());
	
		int tmp;
		{
			int tmp2;
		}
		
		// tmp2= 0; tmp2는 접근 유효 범위를 벗어난 상태임으로 사용 불가.
		
		// 클래스 변수와 인스턴스 변수
		// 카드 클래스
		
		Card c1 = new Card();
		
		System.out.println(c1.height);
		
		// 참조변수를 통한 멤버변수 사용은 인스턴스가 되어야한다.
		
		Card c2;
		
		// 따라서, 클래스 변수의 접근은 참조변수를 사용하면 안되고,
		// 클래스 이름으로 접근을 해야함.
		//System.out.println(c2.height);
		
		Card.height = 100; // 논리적으로 문제가 없나? 변경이 안되도록 해야한다.
		                   // 클래스 멤버변수에 final을 추가.
		System.out.println(Card.height);
		
		
		// 기본형 매개변수, 참조형 매개변수
		Data d = new Data();
		d.x = 10;
		
		System.out.println(d.x);
		
		// 기본형 매개변수
		change(d.x);
		System.out.println(d.x);  // d.x가 전달되는 것이 아니고, d.x의 값인 10 이 전달됨.
		
		change(d);
		System.out.println(d.x);
		
		Data d2= Copy(d);
		
		System.out.println("d2.x = " + d2.x);
		
		change(d2);
		
		MyMath mm = new MyMath(); 
		
		// 클래스 메소드 호출 => 인스턴스가 생성되지 않는 상태.
			
		System.out.println(MyMath.add(100L, 200L));
		
		//인스턴스 메소드
		mm.a = 400L;
		mm.b = 200L;
		System.out.println("mm.add() = " + mm.add());
		// 클래스(static)메소드
		// 인스턴스 변수를 매개변수로 사용.
		System.out.println("mm.add(mm.a,mm.b) = " + mm.add(mm.a,mm.b));
		mm.add(mm.a,mm.b); // 인스턴스 변수의 값이 값복사가 됨.
		// 인스턴스 변수를 사용하지 않고 매개변수 초기화.
		System.out.println(mm.add(500L,500L)); // 현재의 매개변수 500L은 상수임.
		   									   // 상수 500L이 값 복사로 메소드에 전달됨.
		
		
		// 인스턴스 메소드 호출 => 인스턴스 생성이 필수.
		
		
		// 가변 매개변수 메소드 호출
		String[] strArr = {"100","200","300"};
		System.out.println(concatenate("-",strArr));
		
		String[] strArr2 = {"100","200","300","100","200","300"};
		System.out.println(concatenate("-",strArr2));
		
		concatenate(null);
		concatenate2(null);
		
		concatenate("",new String[0]);
		concatenate2(new String[0]);
		
		concatenate("","");
		
		// 배열 매개변수 메소드
		concatenate2(new String[0]);
		
		// 가변 매개변수 메소드.
		concatenate3();
		
		
	} //end of main()
	
	// 가변 매개변수 메소드
	// String...strings : 배열의 요소가 2개 of 3개이상일수 있을때.
	static String concatenate(String delim, String...strings)
	{
		String result = "";
		for(String str : strings)
		{
			result += str + delim;
		}
		
		return result;
	}
	
	static String[] concatenate2(String[] strings)
	{
		return strings;
	}
	
	static String[] concatenate3(String... strings)
	{
		return strings;
	}
	
	
	
	
	// static 메소드는 static 메소드만 호출가능.
	// 참조형 반환타입의 메소드
	// 사용되는 쪽 main()이 static이라 static으로 받음
	static Data Copy(Data d)
	{
		Data tmp = new Data();
		tmp.x = d.x;  // 인스턴스변수의 값을 복사.
		
		return tmp;
	}
	
	
	
	// * 오버로딩 메소드 *
	// 기본형 매개변수의 메소드              
	static void change(int x)  // int x = 10;  값복사.
	{
		x = 1000;
	}
	
	// 참조형 매게변수의 메소드
	static void change(Data d) // 값은 값인데, 인스턴스의 주소값이 넘어온다.
	{
		d.x = 1000;
		System.out.println(d.x);
	}
	

} 


class Tv
{
	// 속성, 멤버변수
	String color;
	boolean power;
	private int channel;
	
	
	// 기능, 메소드
	void power()
	{
		power = !power;
	}
	
	void channelUp()
	{
		channel++;
	}
	
	void channelDown()
	{
		channel--;
	}
	
	// channel 세터, 멤버변수의 값을 설정.
	// public은 접근제어지시자,
	// void 반환값이 없음.
	
	public void Setchannel(int ch)
	{
		// 유요한 channel 인지 체크
		if(ch < 0)
		{
			return;   // channel 이 음수면 적용하지않음.
		}
		channel = ch; // channel 이 양수면 멤버변수에 적용.
		
	}
	// channel 게터, 멤버변수의 값을 확인.
	public int Getchannel()
	{
		return channel;
	}
	
	
}

//하트, 다이아몬드, 스페이스, 클로버
//숫자와 무늬는 각각 고유하지만, 공통적인 것은 카드의 크기(폭, 높이)
//클래스 변수의 대상 : 카드의 크기
//인스턴스 변수의 대상 : 숫자, 무늬

class Card
{
	// 멤버변수(클래스, 인스턴스)
	
	// 인스턴스 멤버 변수
	private String kind;  // 무늬 
	private int number;   // 숫자
	
	// 클래스 멤버 변수 => 객체 생성하지 않고 사용 가능. 공유
	static int width = 100;
	/*final*/ static int height = 230;
}


// 기본형 매개변수, 참조형 매개변수 용 클래스
class Data
{
	int x;
}

// 클래스 메소드, 인스턴스 메소드 관련 클래스
class MyMath
{
	long a,b;
	
	// 인스턴스 메소드
	// 인스턴스 변수임을 명시적으로 나타내기 위해
	// 자기참조변수(this)를 사용하면 확실하게 구분이 됨.
	long add()
	{
		return this.a + this.b;
	}
	
	// 클래스(static) 메소드
	// 오버로딩에 static은 관계가 없다. 매게변수로 차이가 된다.
	
	// 클래스 메소드는 인스턴스 상태이던 아니던 모두 사용(호출) 가능.
	// 단, 클래스 메소드 자체 내에서는 인스턴스는 사용할 수 없다.
	static long add(long a, long b)
	{
		// static 메소드 안에서는 인스턴스는 사용할 수 없음.
		//this.add();
		// 아래의 a,b 는 지역변수임. 인스턴스 변수가 아님.
		return a + b;
	}
	
	static long add(int a, long b)               // 오버로딩
	{
		return a + b;
	}
	
	static long add(int a, long b, long c)       // 오버로딩
	{
		return a + b;
	}
	
	/*
	 * static int add(int a, long b int c)       // 반환타입이 다르면 안됨. 
	 * { 
	 *   return a + b; 
	 * }
	 */
	
}

