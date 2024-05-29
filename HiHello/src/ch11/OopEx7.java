package ch11;

/*
 *  - 스터디 조 구성
 *    JAVA 프로젝트 추천( 자바 종료 ~ React 시작 후 1/4 시점)
 *    - 레이어가 있는 수준( MVC - DB )  DB는 없이. -> S/W 아키텍처
 *      순수 자바로 MVC 아키텍처 기반의 자바 프로그램.
 *      ( 없는 것 : html, javascript, jsp, servlet, db )
 *      html, javascript(화면에 보여주기) : view
 *                                      model
 *      jsp, servlet(메뉴에 따른 처리) : controller
 *      DB : java의 자료구조.
 *      
 *    - 주제 선정
 *      도서관리( 도서정보 관리, 회원정보 관리, 재고관리, 대출 처리, 구매 관리 ...... )
 *      
 *      도서정보 관리 : 등록, 수정, 삭제, 조회(제목, 저자, 출판사, 분류코드...)
 *      
 *    - 목표
 *      각 한명이 관리 기능 구현.   
 *      
 *    - 좋은 점
 *      실제의 개발 경험.
 *      
 *      리액트, 스프링부트, jpa 가 끝낫다고 했을 때,
 *      선행 프로젝트 결과물을 새로운 웹 기술로 마이그레이션 가능.
 *      
 *      최종 프로젝트에서 엄청 도움이 된다.
 *      
 *    - 더더 좋은 점.
 *      이력서에 어필할 내용이 생김.(GitHub 결과물 제출 가능.)  
 *      
 *   
 *   
 *   
 * -------------- interface -----------------------
 *  interface는 상수와 추상메소드로 구성된다.
 *  작성한 interface를 이미 사용중이다.
 *  필요에 의해서 새로운 추상메소드를 추가해야하는 상황이라서, 추상메소드 추가
 *  
 *  기존에 interface를 implements 한 모든 클래스에서 추가된 새로운 추상메소드를 구현해야 한다.
 *  
 *  따라서, 새로운 메소드를 interface에 추가를 하더라도, 다른 곳에 영향이 없으면 좋겟다고 생각 한다면
 *  -> default method
 * 
 *  interface의 작성 원칙은 추상메소드만 가능하다.
 *  다른 곳에서 사용되고 있는 static method는 인스턴스 없이도 잘 사용중이다.
 *  그래서, interface 에도 static method를 추가해서 사용하면 좋겠다 라고 생각했다.
 *  -> static method 도 사용가능해졌다.
 * 
 *  클래스간의 상속, 인터페이스를 활용한 다중 상속 처럼 사용.
 *  클래스의 메소드명, interface의 default, 메소드 명이 중복되는 경우가 발생.
 *  - 여러 interface에서 메소드명이 충돌
 *  
 *  - default method와 부모 클래스에서 메소드명이 충돌
 * 
 * 
 * - default method
 * 
 * - static method
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



public class OopEx7 {

	public static void main(String[] args) 
	{
		
		Child c = new Child();
		
		
		
		// 여러 interface간의 충 -> 두 군데의 interface 중에 아무거나 하나를 
		                      // 구현하려는 클래스에 오버라이딩 하면 된다.
		                      // 결과적으로 클래스에 구현된 오버라이딩 메소드가 호출된다.
		// ->  method1 : Child 
		// method1 은 두군데의 interface에 존재하고,
		// 그리고 Child에 class에 구현된 상태이다.
		// 따라서 코드 기준으로 총 3군데 이다.
		c.method1();
		
		
		
		// 결과 : method2 : Parent
		// 중복 상황은 클래스와 interface간의 메소드 충돌.
		// 결과적으로 클래스의 메소드가 호출된다.
		c.method2();
		
		
		
		// 원칙은 interface에서 추상메소드만 가능했으나,
		// 자바 버전이 jdk1.8 부터는 interface에서도 static method도 가능해졌다.
		MyInterface.staticMethod();
		
		MyInterface2.staticMethod();
		
		// default 메소드와 부모 클레스에서 메소드 명이 충돌.
	}

}


interface MyInterface
{
	// default method
	default void method1() // Myinterface2 와 충돌
	{
		System.out.println(" method1 : MyInterface ");
	}
	
	default void method2() // Parent와 충돌.
	{
		System.out.println(" method2 : MyInterface ");
	}
	
	// static method
	
	static void staticMethod()
	{
		System.out.println(" staticmethod : MyInterface ");
	}
}

interface MyInterface2
{
	// default method
	default void method1()  // Myinterface 와 충돌
	{
		System.out.println(" method1 : MyInterface2 ");
	}
	
	// static method
	static void staticMethod()
	{
		System.out.println(" staticmethod : MyInterface2 ");
	}
}


class Parent
{
	public void method2() // MyInterface와 충돌
	{
		System.out.println(" method2 : Parent ");
	}
}

class Child extends Parent implements MyInterface,MyInterface2
{
	// MyInterface,MyInterface2 에서 default method 2개가 충돌되고 있음.
	// 추돌 되고 있는 default 메소드 중에서 아무거나 하나만 구현하면 된다.

	@Override
	public void method1() 
	{
		System.out.println(" method1 : Child ");
	}
}






















