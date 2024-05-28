package ch1;
import java.time.LocalDateTime;


/*======= 구현 목록 =======
*  1. SCV 구현
*     - 수리
*       대상 : SCV, Tank, Dropship
*       
*     고려사항
*       a. 관계가 없는 Unit을 수리를 하기 위해 새로운 타입으로 묶어야한다.
*       b. SCV 클래스에 repair(수리interface)
*          Unit의 멤버변수에 접근해서 값을 수정.
*          
*          -> 매개변수의 타입과 멤버변수 접근 타입이 다름. -> 형변환.
*       
*  2. Building 에서 공중을 띄우는 공통 능력을 구현.
*    
*  
*  3. Barrack, Factory에서 interface를 구현.
*     Barrack : 마린생산
*     Factory : 탱크생산
*     
*     이륙, 이동, 정지, 착륙
*     
*     class Barrack
*     {
*        이륙, 이동, 정지, 착률 method 구현 -> 코드 중복
*        이륙 and 이동 method => 향후에 신기능 구현? => 기본메소드에서 확장되는 기능.
*     }
*     
*     class Factory
*     {
*        이륙, 이동, 정지, 착륙 method 구현 -> 코드 중복
*        이륙 and 이동 method => 향후에 신기능 구현? => 기본메소드에서 확장되는 기능.
*        
*     }
*     
*     1. 새로운 건물이 추가될 경우.
*     2. 이륙, 이동, 정지, 착륙의 기본 메소드의 재활용. 기능 구현의 강제성.
*     3. 유지보수 및 확장성을 위해서
*/

public class StarCraftEx {

	public static void main(String[] args) 
	{

		// ============== 1번 문제 동작 테스트 =================
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		Marine marine = new Marine();
		
		// Tank의 수리 테스트
		tank.currentHP = 10;
		System.out.print("수리전 : " + tank.currentHP);
		// Tank 수리 후
		scv.repair(tank);
		System.out.print("수리후 : " + tank.currentHP);
		
		scv.repair(dropship);
		scv.repair(tank);
		scv.repair(scv);
		
		//scv.repair(Marine);  // 컴파일 에러 ( 타입이 맞지 않음. )
		                     // Marine은 Repairable 을 implements 하지않음.
		                     // 수리 관계를 맺지 않는 상태로
		                     // SCV가 수리할 대상이 안됨.
		
		// ===================== 2번 문제 동작 테스트 ==================
		// Barrack, Factory
		
		Barrak barrack = new Barrak();
		barrack.Land();
		barrack.Stop();
		barrack.LiftOff();
		
		Factory factory = new Factory();
		
	}

}

//============================ 1번 문제 ====================================
class Unit
{
	final int MAX_HP;
	int currentHP; 
	int x;
	int y;
	
	
	// Unit 별로 기본 최대 체력이 다르기 때ㅣ문에,
	// 생성자에서 상수인 MAX_HP를 초기화 하도록 함.
	Unit(int Maxhp)
	{
		this.MAX_HP = Maxhp;
	}
}

class GroundUnit extends Unit
{
	GroundUnit(int hp)
	{
		super(hp);
	}
}

class AirUnit extends Unit
{
	AirUnit(int hp)
	{
		super(hp);
	}
}

interface Repairable {}

class Tank extends GroundUnit implements Repairable
{
	Tank()
	{
		super(100);
		this.currentHP = this.MAX_HP; // 자기 체력이 만땅으로 초기화
	}
	
	public String toString()
	{
		return "Tank";
	}
}

// Marine은 medic에게 치료 받아야 함으로,
// Repairable의 implements 대상이 아님.
class Marine extends GroundUnit
{
	Marine()
	{
		super(20);
		this.currentHP = this.MAX_HP; // 자기 체력이 만땅으로 초기화
	}
	
	public String toString()
	{
		return "Marine";
	}
}

class Dropship extends AirUnit implements Repairable
{
	Dropship()
	{
		super(130);
		this.currentHP = this.MAX_HP; // 자기 체력이 만땅으로 초기화
	}
	
	public String toString()
	{
		return "Dropship";
	}
}

class SCV extends GroundUnit implements Repairable
{
	// SCV의 타입의 다른 인스턴스는 수리 대상임.
	// 따라서, 자기자신도 implements Repairable 해야한다.
	
	SCV()
	{
		super(70);
		this.currentHP = this.MAX_HP; // 자기 체력이 만땅으로 초기화
	}
	
	public String toString()
	{
		return "Dropship";
	}
	
	// 수리 메소드 구현 -> 수리 대상만 수리될 수 있도록 해야 한다. -> Repairable
	// 참조변수인 r의 대상은 Tank,Dropship,SCV
	void repair(Repairable r)
	{
		if(r instanceof Unit)
		{
			// 체력 인스턴스 변수에 접근하기 위해서
			// 인스턴스 변수는 타입을 따라감으로 Unit으로 형변환(casting)
			
			// 다운캐스팅은 반드시 명시적 형변환 하여야 한다.
			Unit u = (Unit)r;
			while(u.currentHP != u.MAX_HP)
			{
				System.out.println(u.toString() + "수리중.....");
				u.currentHP++;
			}
			System.out.println(u.toString() + "의 수리가 완료됨.");
			
		}
	}
}

//============================ 2번 문제 ====================================
/*
*     1. 새로운 건물이 추가될 경우.
*     2. 이륙, 이동, 정지, 착륙의 기본 메소드의 재활용. 기능 구현의 강제성.
*     3. 유지보수 및 확장성을 위해서
*/

class Building 
{
  	
}

// 1. 이륙 가능한 건물의 타입으로 사용하려는 목적.
// 2. 이륙 가능한 건물 클래스가 새롭게 추가될 경우
//    이륙, 이동, 정지, 착륙 기능의 강제 구현을 시키려는 목적.

interface Liftable
{
	public abstract void LiftOff();
	public abstract void Move();
	public abstract void Stop();
	public abstract void Land();
}

// 구체화 클래스 작성 : Barrak, Factory
// 구체화 해보면, 코드 중복성이 발견됨 => 유지보수 편하도록 해야함.
// 유지보수성을 높이게 하려면 어떻게 하면 좋을까??
// 응집도를 높이고, 결합도를 낮추려면 어떻게 하면 좋을까??


// 해결 방향
// 1. 공통 또는 반복 되는 코드는 별도로 뽑아내야 한다.
//    -> 4가지 메소드가 한 곳에 있도록 해야한다. -> 응집도를 높여야 한다.
// 2. 뽑아낸 코드를 쉽게 사용할 수 있도록 해야 한다.
// 3. 뽑아낸 곳의 코드에 기능 추가, 성능개선, 요구사항 반영을 하더라도,
//    사용되어지고 있는 곳에 영향이 가면 안된다. -> 결합도를 낮추어야한다.


// 응집도 높아짐.
class LiftableImpl implements Liftable
{
	// 진정한 결합도가 낮다고 볼수는 없지만..
	// 수정이 발생하더라도 다른 곳에 영향력이 없다.
	
	@Override
	public void LiftOff() {
		System.out.println("이륙");
		System.out.println("이륙 중");
		System.out.println("이륙 완료");
	}

	@Override
	public void Move() {
		System.out.println("이동");
		
	}

	@Override
	public void Stop() {
		System.out.println("정지");
		
	}

	@Override
	public void Land() {
		System.out.println("착륙");
	}
	
}


class Barrak extends Building implements Liftable
{
	// 건물의 이동과 관련된 기능의 인스턴스만 생성 후,
	// 필요한 기능의 메소드만 호출만 하면 된다.
	
	LiftableImpl l = new LiftableImpl();

	@Override
	public void LiftOff() {
		l.LiftOff();
		
	}

	@Override
	public void Move() {
		l.Move();
		
	}

	@Override
	public void Stop() {
		l.Stop();
		
	}

	@Override
	public void Land() {
		l.Land();
	}
	
}

class Factory extends Building implements Liftable
{

	LiftableImpl l = new LiftableImpl();

	@Override
	public void LiftOff() {
		l.LiftOff();
		
	}

	@Override
	public void Move() {
		l.Move();
		
	}

	@Override
	public void Stop() {
		l.Stop();
		
	}

	@Override
	public void Land() {
		l.Land();
	}
	
	public void liftoffAndMove()
	{
		this.LiftOff();
		this.Move();
	}
}

//============================ 3번 문제 ====================================





