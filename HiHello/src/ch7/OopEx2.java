package ch7;

/*################################ 본격적인 OOP ######################################################
* 
*   - 생성자
*     인스턴스가 생성될 때호출되는 '인스턴스 초기화 메소드'.
*     인스턴스의 초기화 작업에 주로 사용됨.
*     인스턴스 생성 시 실행되어야 할 작업을 위해서도 사용.
*     
*     특징 : 구조가 메소드와 유사. 반환값이 없음. (void 사용하지 않음.)
*     
*     작성 : 클래스 이름과 동일해야 한다.
*     
*     MyMath mm = new MyMath(); // 기본 생성자 호출. 선언하지 않았지만 사용가능.
*     
*     생성자를 위한 인스턴스 생성.
*     MyMath mm = new MyMath(); // 현재의 생성자는 코드에 없음.
*                               // 컴파일러가 기본적으로 제공.
(추가)0. 클래스 변수 초기화 블럭이 수행된다.                           
*    1. 연산자 new에 의해서 메모리에 MyMath 클래스의 인스턴스가 생성됨.
*       메모리의 빈공간에 MyMath 클래스를 적재할 곳을 마련. 메모리에 자리를 잡음(인스턴스의 주소값이 생성).
*       이때부터 this사용가능.
*       
(추가)1.5 인스턴스 초기화 블럭이 있다면 수행된다. 
*    2. 자리만 잡은 인스턴스의 초기화 작업을 수행하기 위해서 MyMath()가 호출이 됨.
*    3. 생성된 MyMath 인스턴스의 주소가 반환이 되어 참조변수 mm에 저장됨.
*    4. mm 참조 변수를 사용해서 인스턴스에 접근해서 사용가능.
*    
*    - 기본 생성자(default constructor)
*     컴파일 시 소스파일에 생성자가 하나도 정의가 되지 않은 경우 컴파일러가 제공한다.
*     
*    - 매개 변수가 있는 생성자
*     인스턴스마다 각기 다른 값으로 초기화해야 하는 경우 사용.
*     오버로딩 적용가능.
*     
*     인스턴스 변수 초기화(생성자 사용 전)
*     d1.value = 100;
*     
*     인스턴스 변수 초기화(생성자 사용 후)
*     Data1(100);
*     
*     여러개 일때
*     d1.value = 100;
*     d2.value = 200;
*     d3.value = 300;
*     d4.value = 400;
*     
*     Data1(100,200,300,400);
*     
*    - 생성자에서 다른 생성자 호출 가능.
*      클래스 내에 여러개의 생성자가 있는 경우, 
*      
*    - 생성자를 이용한 인스턴스의 복사
*      현재 사용하고 있는 인스턴스와 같은 상태를 갖는 인스턴스를 하나 더 만들고자 경우. => 상태가 동일함.고유 정보가 동일하다는 의미는 아님.
*      ex) 게임에 동일한 몬스터를 생성.
*      
*      생성자의 매개변수를 해당 클래스의 참조변수로 받으면 구현이 가능.
*      
*    - 변수의 초기화
*      멤버변수의 초기화는 기본값으로 초기화된다.
*      지역변수는 반드시 초기화가 필수이다.
*      
*    - 멤버변수의 초기화 방법
*      1. 명시적 초기화
*         class car
*         {
*           int doorType = 4; // 기본형
*           DoorType dt = new Doortype();  // 참조형         
*         }
*      
*         참조변수.멤버변수 = 100;
*      2. 생성자
*      3. 초기화 블록
*         - 인스턴스 변수 초기화 블록 : 인스턴스 변수가 대상  
*         - 클래스(static) 변수 초기화 블록 : 클래스 변수가 대상
*         
*         - 동작
*           클래스가 메모리에 처음 로딩될 때 한 번만 수행되며,
*           인스턴스 초기화 블럭은 생성자와 같이 인스턴스를 생설할 때마다 수행된다.
*           인스턴스 초기화 블럭은 생성자 보다 먼저 초기화 블럭이 수행된다.
*           
*   - 멤버변수의 초기화 시점
*     클래스변수 : 클래스가 처음 로딩될 때 단 한번 초기화
*     인스턴스 변수 : 인스턴스가 생성될 때 마다 각 인스턴스별로 초기화
*   
*   - 멤버변수의 초기화 우선순위
*     클래스 변수 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블럭.
*     인스턴스 변수 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자.  
*     
*     
*     클래스 간의 관계
*   - 상속
*     조상 클래스 : 부모 클래스, 상위 클래스, 기반 클래스
*     자식 클래스 : 자손 클래스, 하위 클래스, 파생 클래스
*     
*   - 장점
*     상속을 통하면 적은 양의 코드로 새로운 클래스를 작성할 수 있다.
*     코드의 추가 및 변경이 매우 용이해짐.
*     
*   - 단점 (강한결합)        
*     강결합의 가능성이 있을 수 있다.
*     
*     결합도가 낮고, 응집도가 높은 코드 => 코드 품질 향상. = > 유지보수, 테스트 => 생산성 향상.
*     
*     결합도가 낮다는 것은 클래스간의 관계를 약하게 하는 것이다.        => 문법적인 요소로 활용.
*     => 코드 수정시 사용되는 다른 곳에 영향이 없도록 코드를 작성. 
*     응집도가 높다는 것은 관련 기능을한 곳에서 관리가 되도록 하는 것이다. => 도메인 지식이 필요하다.
*     
*     
*   - 관계
*     논리적으로 합당한 관계가 되어야 한다.
*     
*     상속관계 : is-a 관계. ~은 ~이다.
*        사람,학생. 학생은 사람이다. => 학생 extends 사람
*        권총,경찰. 경찰은 권총이다. => 논리적 성립 불가.
*     포함관계 : has-a 관계. ~은 ~을 가지고잇다.
*        사람,학생. 학생은 사람을 가지고 있다.
*        권총,경찰. 경찰은 권총을 가지고 있다. => 논리적 성립 가능. => 멤버변수의 가능성.
*     
*   - 문법적 관계
*     extends(확장)
*     
*   - 단일 상속, 멀티 상속(다중 상속)
*     단일 상속 : 기반 클래스가 하나.   => JAVA
*     다중 상속 : 기반 클래스가 여러개.  => C++ 
*     
*     JAVA 에서 다중상속 처럼 사용하고 싶은 경우.
*      상속관계(is-a) + 포함관계(has-a) => extends + 멤버변수로 사용.
*      
*   - Object 클래스
*     Object 클래스는 모든 클래스 상송계층도의 최상위에 있는 부모 클래스이다.
*     
*     class Tv {} class를 만들면 컴파일러가 아래의 코드로 변경
*     class Tv {} extends Object{}
*     
*     Object class 에서 제공되는 메소드를 활용할 수 있도록 하면 좋음.
*     => 재사용성, 유지보수 좋아짐.
*   
*   - 오버라이딩(overriding)
*     기반 클래스로부터 상속받은 메소드의 내용을 변경하는 것.
*     
*     조건 : 메소드의 이름이 동일해야한다, 매개변수도 동일해야 한다, 반환타입또한 동일해야 한다.
*     
*     오버로딩과 오버라이딩
*     오버로딩 : 상속관계가 아니다. 기존에 없는 메소드를 새로 정의하는 것이다.
*     오버라이딩 : 상속관계이다. 자식클래스 쪽에서 부모 메소드와 동일한 것을 재정의 하는 것이다.
*   
*   - super
*     모든 인스턴스 메소드에는 자신이 속한 인스턴스의 주소가 지역변수로 저장된다.
*     이것이 참조변수인 this와 super이다.
*     
*     this : 멤버변수와 지역변수의 차이를 두고 싶어서. 자기 클래스 안에서 구분을 위함.
*     super : 클래스 간의 관계에서 부모(기반)의멤버와 자식(파생)의멤버을 구분하기 위해서.
*     
*   - super()
*     자식 클래스의 인스턴스를 생성하면, 자식의 멤버와 부모의 멤버가 모두 합쳐진 하나의 인스턴스가 생성된다.
*     => 자식 클래스에서 부모 클래스의 멤버를 사용할 수 있게 된다.
*     
*   - 인스턴스 생성시 선택
*     클래스 : 어떤 클래스의 인스턴스를 생성할 것인가? => 클래스 설계
*     생성자 : 선택한 클래스의 어떤 생성자를 이용해서 인스턴스를 생성할 것인가? => 상태 설계    
*                               
*/  


public class OopEx2  
{
	
	static int staticVar =11111;
	// 생성자
	OopEx2()
	{
		System.out.println("생성자 호출");
	}
	
	// 클래스 변수 초기화 블럭
	static
	{
		System.out.println("(Block)StaticVar = " + staticVar);
		System.out.println("클래스 변수 초기화 블럭 호출됨");
	}
	
	// 인스턴스 변수 초기화 블럭
	{
		System.out.println("인스턴스 초기화 블럭 호출됨");
	}
	

	public static void main(String[] args) 
	{
		
		System.out.println("(main) StaticVar = " + staticVar);
		// Data1, Data2 인스턴스 생성.
		
		Data1 d1 = new Data1();  // 기본생성자
		
		System.out.println("d1.value = " + d1.value);
		
		Data2 d2 = new Data2(); // Data2 클래스에는 매개변수가 있는 생성자가 존재.
                                  // 컴파일러가 기본생성자를 제공하지 않음.
		System.out.println("d2.value = " + d2.value);
		
		Data2 d3 = new Data2(777);
		System.out.println("d3.value = " + d3.value);
		
		
		// 생성자를 이용한 인스턴스의 복사
		Car c1 = new Car("BLACK");
		System.out.println(c1.color);
		
		Car c2 = new Car(c1);
		System.out.println(c2.color);
		
		
		// 초기화 블럭 및 생성자 동작 순서 확인
		OopEx2 ope2 = new OopEx2();
		
		// Product class 사용.
		Product P1 = new Product();
		Product P2 = new Product();
		Product P3 = new Product();
		
		Deck d = new Deck(); // 52장의 포커 카드 준비 완료.
		PockerCard c = d.pick();
		System.out.println(c.toString());
		
		d.shuffle();
		
		Child2 ctest = new Child2();
		
	}// end of main()

}

// super 활용 예제 클래스
class Parent2
{
	int x = 10;
	int y = 10;
}

class Child2 extends Parent2
{
	int y = 20;
	void method1()
	{
		System.out.println("x = " + x);             // 10
		System.out.println("this.x = " + this.x);   // 10
		System.out.println("super.x = " + super.x); // 10
	}
	
	void method2()
	{
		System.out.println("y = " + y);             // 20
		System.out.println("this.y = " + this.y);   // 20
		System.out.println("super.y = " + super.y); // 10
	}
}

// 컴파일러상 Object 상속
// 메모리 상에 아래와 비슷하게 만들어 준다.
// 그래서 x로 접근이가능하고 method() 에서는 지역변수로 this, super가 초기화 되어 있어,
// this.x 와 super.x 를 메소드 내에서 사용할 수 있게 됨.
// class Child
//{ int x = 10;
//	void method(){ this, super }
//}



// 오버라이딩 클래스
class Point2    // 부모 클래스, 2차원
{
	int x;
	int y;
	
	Point2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	String GetLocation()
	{
		return "x : " + x + ", y = " + y;
	}
}

class Point3D extends Point2 // 자식 클래스, 3차원
{
	int z;
	
	Point3D(int x)
	{
		super(x,0);
	}
	
	Point3D(int x, int y)
	{
		// Point3D 는 자식 클래스임으로 부모 클래스인 Point2가 없이는 존재할 수 없다.
		// => 따라서 Point2가 먼저 인스턴스로 생성되어야 Point3D의 인스턴스를 생성할 수 있다.
		// => 자식 클래스의 생성자에는 반드시 첫 줄에 부모 클래스의 생성자를 호출해서,
		//    자식클래스의 인스턴스를 먼저 생성해야 한다.
		super(x,y); // this : 자기참조 연산자, this() : 생성자 호출 , super() : 부모생성자 호출
	}
	
	
	// 오버라이딩
	// 좌표를 출력할 때,
	// 1. 재사용고려 => 부모 클래스의 메소드를 사용.
	// 2. 나의 상태 정보는 내가 출력 => 추가적으로 코드 작성필요.
	
	
	// 아쉬운 오버라이딩
	//String GetLocation()
	//{ 재사용 코드가 아님
	//	return "x : " + x + ", y = " + y + ", z = " + z;
	//}
	
	// 추천되는 오버라이딩
	
	String GetLocation()
	{
		// 재사용 코드이다.
		// 부모 클래스의 메소드 내부의 내용이 변경이 되더라도,
		// 변경된 내용이 자식 클래스에 영향을 주지않고,
		// 자동적으로 반영이 된다.
		return super.GetLocation() + ", z : " + z;
	}
}





// JAVA에서의 다중상속과 유사한 클래스 작성.
// TV, VCR(셋톱박스처럼 생각) class를 이용해서 다중상속처럼 사용하려면,
// 하나의 클래스로부터는 상속을 받고, 다른 클래스를 참조변수 멤버변수로 가지게 한다.

// TV : 부모 클래스
// VCR : 자식, 멤버변수(옵션)

class Tv
{
	boolean power;
	int channel;
	
	void Power()
	{
		power = !power;
	}
	
	void ChannelUp()
	{
		channel++;
	}
	
	void ChannelDown()
	{
		channel--;
	}
}

class Vcr
{
	boolean power;
	
	void Play()
	{
		power = true;
	}
	
	void Stop()
	{
		power = false;
	}
	
	void rew()	
	{
		
	}
	
	void pp()
	{
		
	}
}

class TvVcr extends Tv
{
	Vcr vcr = new Vcr();
	
	// 전원은 기반 클래스의 메소드를 사용.
	
	// TvVcr은 별도의 새로운 제품임으로 자기만의 기능을 구현해야한다.
	void play()
	{
		// 추가적으로 나만을 위한 play() 관련 기능을 향후에 개선하고 싶다.
		
		// vcr 기능은 내가 신경 쓰지 않아도 관리되고 향상되면 나는 오케이다.
		vcr.Play();
	}
	
	void Stop()
	{
		vcr.Stop();
	}
	
	void rew()
	{
		vcr.rew();
	}
	
	void pp()
	{
		vcr.pp();
	}
}


// 포커카드를 만듬.
// 포커카드 한 세트


class PockerCard
{
	// static 변수는 기본적으로 대문자를 사용
	static final int KIND_MAX = 4;  // 카드의 무늬 수.
	static final int NUM_MAX = 13;  // 카드의 무늬별 총 수량.
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	// 카드별 무늬 및 숫자
	int kind;    // 1. 무늬를 나타내는 정보. 2. 화면 출력용 데이터 배열의 index 정보.
	int number;
	
	PockerCard()
	{
		//this(SPADE,1);
	}
	
	PockerCard(int kind, int number)
	{
		this.kind= kind;
		this.number = number;
	}
	
	// 현재 인스턴트 카드 한 장의 정보를 출력.
	public String toString()
	{
		// 배열로 관리하는 이유.
		// 1. 화면 출력용 데이터를 한곳에서 관리하려는 이유
		// 2. 코드 작성 시 가독성과 사용 편리성을 높이기 위한 이유.
		
		String[] Kinds = {"","CLOVER","HEART","DIAMOND","SPADE"};
		String numbers = "0123456789XJQK";
		return "kind : " + Kinds[this.kind] + " Number = " + numbers.charAt(this.number);
	}
	
}

// 포커카드한 세트
// 포커카드 한 벌은 52장의 포커 카드를 가지고 있다.(포함관계 => 멤버변수 => 객체배열)

class Deck
{
	// 클래스 변수
	static final int CARD_NUM = 52;
	
	// 인스턴스 상수
	// final int CARD_NUM = 52;
	
	// 인스턴스 변수
	PockerCard[] CardArr = new PockerCard[CARD_NUM];
	
	// 구현대상 !!
	// 생성자 52장의 포커카드 인스턴스를 생성, 객체배열에 저장해야한다.
	Deck()
	{
		// 무늬 4개, 각 13장 => 중첩 반복문 => cardArr[] 저장.
		// 배열의 인덱스 변수
		int index = 0;
		
		for(int i = 0; i < PockerCard.NUM_MAX; i++)
		{
			for(int j = 1; j <= PockerCard.KIND_MAX; j++)
			{				
				CardArr[index++] = new PockerCard(j,i);
			}
		}
	}
	
	
	// 카드 뽑기 오버로딩. 인스턴스 메소드
	PockerCard pick(int idx)
	{
		return CardArr[idx];
	}
	
	// 구현대상 !!
	PockerCard pick()
	{
		// 난수를 이용해서 임의의 카드를 뽑을 수 있도록 배열의 위치정보를 만들어야한다.
		int idx = (int)(CARD_NUM * Math.random());
		return pick(idx);
	}
	
	// 구현대상 !!
	void shuffle()
	{
		 for(int i = 0; i < CARD_NUM; i++) 
		 { 
			int idx = (int)(CARD_NUM * Math.random());
			int idx2 = (int)(CARD_NUM * Math.random());
			
			PockerCard tmp = CardArr[idx];
				
			System.out.println(CardArr[idx].toString());
			System.out.println(CardArr[idx2].toString());
				
			System.out.println("변경후");
			CardArr[idx] = CardArr[idx2];
			CardArr[idx2] = tmp;
			System.out.println(CardArr[idx].toString());
			System.out.println(CardArr[idx2].toString()); 
		  }
		 
		
	}
	
	
	// 카드 섞기. 인스턴스 메소드
}


// 상속 관련 클래스

// Parent와 Child는 is-a 관계 => extends 키워드 가능.
// Parent와 Child는 직접 상속 관계.

class Parent
{
	int age;
}

class Child extends Parent
{
	
}

// Parent의 기준으로는 간접 상속관계
// Child의 기준으로는 직접 상속관계

class GrandChild extends Child
{
	
}

// 포함 관련 클래스

// Pistol과 Police는 has-a 관계.
// ->Pistol은 Police의 멤버변수.

class Pistol
{
	
}

class Police
{
	Pistol p = new Pistol();
}

// 이것또한 포함관계.
// 원과 삼각형은 Point를 가진다.
class Point
{
	int x, y;
	
}
class Circle
{
	Point Cp = new Point();
	int r;
}

class Triangle
{
	Point[] Tp = new Point[3];
}



// 복습
// 자동차 클래스
class Car
{
	String color;
	String gearType;
	int door;
	
	//ex
	int count;
	int serianum;
	
	// 인스턴스 변수 초기화 블록
	// 모든 생성자에서 공통으로 수횡되어야 하는 문장들이 있다면, 
	// 하나의 블럭에서 관리하면, 가독성, 유지보수성이 높아진다.  => 코드중복제거.
	{
		this.count++;
		this.serianum = this.count;
	}
	
	// 클래스 변수 초기화 블록
	static
	{
		int tireType = 4;
	}
	//ex
	
	//기본 생성자
	Car()
	{
		this("White","auto",3);
		this.count++;
		this.serianum = this.count;
	}
	
	// 매개변수 한개,오버로딩
	Car(String color)
	{
		this(color,"auto",5);
	}
	
	// 매개변수 3개,오버로딩
	Car(String color, String gearType, int door)
	{
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	// 자기자신 타입의 매개변수인 생성자. => 인스턴스 변수 초기화용
	Car(Car c)
	{
		this.color = c.color;
		this.gearType = c.gearType;
		this.door = c.door;
	}
}

// 클래스 변수를 이용한 인스턴스 변수 초기화
class Product
{
	static int count = 0;
	int serialNol; // 제품 시리얼 번호.
	
	// 인스턴스 초기화 블럭
	{
		++count;
		this.serialNol = count;
	}
	
	public Product()
	{
		System.out.println("serialNol = " + this.serialNol);
	}
}

// 생성자가 없는 클래스
class Data1
{
	int value;
}

// 생성자가 있는 클래스
class Data2
{
	int value;
	
	// 기본 생성자.
	// 해당클래스에서 생성자가 하나도 없으면, 컴파일러가 제공해 주지만, 클래스에 다른 생성자가 하나라도 있으면,
	// 컴파일러가 기본 생성자를 제공하지 않는다. 따라서, 기본 생성자를 사용하기 위해선 명시적으로 추가해야 한다.
	Data2()
	{
		this(50);   // 첫 줄이고 생성자 이름 대신에 this() 를 사용.
		//Data2(50);   안됨   => 생성자 이름으로는 생성자 안에서 호출 불가능.
		value = 100;
		//Data2(50);   안됨   => 생성자 이름으로는 생성자 안에서 호출 불가능.
		//this(200);   안됨   => 생성자의 사용 목적은 초기화 임으로 반드시 첫줄에서 사용.
	}
	
	// 매개변수가 있는 생성자.
	Data2(int x)
	{
		value = x;
	}
	
	// 생성자도 함수의 한 형태이므로, 오버로딩이 가능하다.
	Data2(long x)
	{
		value = (int)x;
	}
	
	
}