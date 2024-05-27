package ch10;


/**
 * interface
 *   : 추상메소드, 다중 상속처럼 사용가능, 다형성 => 논리적이지 않은 것도 묶을 수 있다.
 *   
 *   추상메소드 => 메소드 구현을 강제시킬 수 있다. ex)신입사원이 실수하지 못하도록 함.
 *   다중 상속 => 2개 이상의 interface를 사용 할 수 있다. 따라서, 구현해야 하는 추상메소드도 2개.
 *   다형성 => Car, Airplane, Ship 의 공통점 -> 이동체
 *            공격 기능 interface를 추가 한다면
 *            어떤 Airplane에는 공격 interface를 구현하지 않고, => 여객기
 *            어떤 Airplane에는 공격 interface를 구현한다면 => 전투기  
 *            
 *            어떤 Ship에는 공격 Ship를 구현하지 않고, => 여객선
 *            어떤 Ship에는 공격 Ship를 구현한다면 => 함선 
 *            
 *            interface를 기준으로 관계없는 것들도 세분화해서 다형성을 적용할 수 있다.
 *            
 *            전투와 관련된 다형성
 *            전투와 관련 되지않은 다형성
 *            이동과 관련된 다형성
 *            
 *            
 *   인터페이스 예제 => 스타크래프트 캐릭터를 만듬. Marine, Scv, Tank, Dropship          
 *   
 * 
 * 
 * 
 * 
 * 
 */

public class OopEx5 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
