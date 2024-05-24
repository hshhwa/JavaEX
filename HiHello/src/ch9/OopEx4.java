package ch9;

import java.util.ArrayList;

/*
 * - 매개변수의 다형성
 *   쇼핑몰 시스템 구축(가정)
 *   1. 상품 정보 : 상품에대한 부모 클래스, 카메라, 컴퓨터...
 *   2. 회원 정보 : 결제, 구매 메소드
 *              : 구매(상품)이 있을때, 구매(카메라), 구매(컴퓨터)... 여러함수를 관리하는것 보다
 *                구매(상품) -> 메소드의 매개변수의 다형성으로 관리
 *                
 *     현재는 JAVA만 사용된 비즈니스 로직이 된다 => spring boot에 소스의 일부가 된다
 *     
 *     AWS에 Saas(웹 애플리케이션)
 *     웹 애플리케이션(react, spring boot, mysql, jpa)
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


public class OopEx4 
{

	public static void main(String[] args) 
	{
		// 상품, 구매자 인스턴스 생성.
		// 구매자가 상품을 구매
		// 구매 가능, 구매 불가능.
		Buyer B = new Buyer();
		
		// 상품이 다르지만, 동일한 구매 메소드를 사용.
		// buy 매개변수에 상품의 기반 클래스인 Product 타입으로 선언되어 있음.
		B.buy(new Camera(1000));
		B.buy(new Computer(1000));
		B.buy(new Computer(1000));
		
		
		
		// 구매리스트를 조회 하고 싶다.
		// 현재 구매 후에는 소유할 수 없는 상태임.
		// 객체 배열을 활용.
		
		// 객체 배열의 단점. 구매할 수 있는 상품의 가지수가 제한된다.
		// 구매 개수에 대한 제한이 없도록 하기위한 방법 모색.
		
		// 동시접속자수의 증가를 대비한 서비스 운영에 환경 구축. -> 컨테이너, 클라우드 -> 확장~
		Product[] Buyp = new Product[3];
		
		
		
	}

}

// 상품정보에대한 부모클래스
class Product
{
	int price;
	int bonusPoint;
	Product(int price)
	{
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}
// 상품 : 카메라
class Camera extends Product
{
	Camera(int price)
	{
		super(price);
	}
	
	public String toString()
	{
		return "Camera " + this.price + "원";
	}
}
// 상품 : 컴퓨터
class Computer extends Product
{
	Computer(int price)
	{
		super(price);
	}
	
	public String toString()
	{
		return "Computer " + this.price + "원";
	}
}

// 구매자(회원)
class Buyer
{
	
	int money = 3000;
	int bonusPoint = 0;
	// 구현대상
	// 구매 비즈니스 로직
	
	// 1. 매개변수 다형성 적용
	//    구매할 상품의 가지수가 계속 늘어나는 것을 고려.
	// 2. 구매 가능한지를 확인. 금액을 확인.
	// 3. 구매 불가 또는 구매 가능
	// 4. 구매한 경우 잔액 변경.
	// 5. 보너스 포인트 지급.
	// 6. 구매(결제) 성공 메시지 출력.
	
	void UseMoney(int price)
	{
		this.money -= (price - this.bonusPoint);
		this.bonusPoint = 0;
	}
	
	boolean PriceCheck(Product _product)
	{		
		if(this.money >= _product.price)
		{
			System.out.println(_product.toString() + " 구매가능");
			return true;
		}
		else
		{
			System.out.println(_product.toString() + " 구매불가능");
			return false;
		}
	}
	
	void buy(Product _product) // 혼자
	{
		if(PriceCheck(_product))
		{
			UseMoney(_product.price);
			System.out.println(_product.toString() + " 구매완료");
			this.bonusPoint += _product.bonusPoint;
			System.out.println("보유금액 : " + this.money);
			System.out.println("보유포인트 : " + this.bonusPoint);
		}
		else
		{
			System.out.println("금액이 부족합니다.");
		}
	}
	
	void buy1(Product p) // 강의
	{
		// 구매가능 여부 체크
		if(this.money < p.price)
		{
			System.out.println("구매 가능한 금액이 아닙니다.");
			return;
		}
		
		this.money -= p.price;
		System.out.println("구매 완료");
		
	}
}








