package ch10;
import java.util.Vector;

/**
 * OOP의 4대 특성
 * - 캡슐화
 *   데이터를 외부에서 함부로 변경하지 못하도록 하기 위해서 접근을 제어하는 것.
 *   데이터 감추기(data hiding)
 *   외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위함. -> 복잡성을 줄인다. 
 *   문법적 : private
 *          -> 데이터 사용을 위해서는 getter, setter,... 필요한 비즈니스용 메소드를 만들어야한다.
 *          
 *          private 생성자 -> 인스턴스를 내부에서 생성하는 목적. -> 디자인 패턴(싱글톤)
 *                       -> getInstance()   
 * - 상속
 *   기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것. 부모클래스, 자식클래스.
 *   상속의 원칙은 단일 상속. ( 단일 상속을 대신해서 확장 : 추상클래스, interface )
 *   클래스 간의 관계에 대한 논리성을 고려. Is-A(상속), Has-A(포함) 관계 
 *   Has-A -> 다중상속 처럼 사용할 수 있다.
 *   
 *   문법적 : extends ( 단일 상속에서 확장 : implement )
 *          생성자와 초기화 블록은 상속되지 않음. 멤버만 상속된다.
 *   
 * - 추상화
 *   클래스간의 공통점을 찾아내서 공통의 부모를 만드는 작업.
 *   추상클래스는 추상메소드가 존재하는 클래스.(추상메소드는 선언만된 상태. 몸통이 없는 상태.)
 *   
 *   추상화의 반대는 구체화. 상속을 통한 클래스 확장하는 작업.
 *   문법적 : extends ( 인스턴스로 사용 가능한 부모 클래스, 인스턴스로 사용 불가능한 기반 클래스 ) -> 추상클래스
 * 
 * 
 * - 다형성(가장 중요. 다형성을 이해하기 위해서는 캡슐화, 상속, 추상화 가 기반이 된다.)
 *   단어적인 의미는 여러가지 형태를 가질 수 있는 능력 또는 특성.
 *   부모클래스 타입의 참조변수로 자식클래스의 인스턴스를 참조할 수 있도록 하는 것이다 -> 인스턴스를 그룹핑이 가능해진다. -> 관리가 편해진다.
 *   (10개의 메소드가 하나 의 메소드로 관리 될 수 있다.)
 *   
 *   문법적 : 형변환 연산자, instanceof 
 * 
 * 
 * 
 */



/**###################### interface #########################
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
 *   인터페이스 예제 => 스타크래프트 캐릭터를 만듬. Marine, SCV, Tank, Dropship          
 *   
 *    클래스 간의 관계.
 *    Unit -> GroundUnit  -> Marine, SCV, Tank
 *         -> AirUnit     -> Dropship
 *    추상클래스 -> 상속받아서 추상메소드를 오버라이딩 재정의 해야만 인스턴스로 사용 가능.
 *               논리적인 관계성이 있어야한다.
 *    
 *    클래스의 부족한 면 : 단일상속만 가능. 다중상속이 안된다. 관계성이 있는 것들끼리만 다형성을 적용.
 *    interface -> 다중상속처럼 사용 가능. 관계 없는 것들 끼리 다형성을 적용 가능.
 *    
 *    SCV 역할, 자원 채취, 공격, 건축 등등...
 *        -> SCV의 수리 대상 : Tank, SCV, Dropship
 *            수리 대상과 관련된 공통 부분을 interface로 만들어서 사용한다. -> 수리와 관련된 다형성을 적용할 수 있다.
 *            -> 수리 메소드 하나로 처리가 가능하다.
 *    
 *    interface의 제약사항
 *     - 모든 멤버변수는 public static final 이어야 한다. 생략할 수 없다.
 *     - 모든 메소드는 public abstract 이어야 한다. 생략할 수 없다.
 *     - 단, static 메소드와 default 메소드는 예외.
 *     
 *    interface의 상속
 *     - interface는 interface로부터만 상속을 받을 수 있다.
 *     - 다중 상속이 가능하다.
 *     
 *    interface의 구현
 *     - interface의 추상 메소드를 구현하는 클래스에서 implement를 사용해서 구현한다. 
 *     
 * 
 * ################### StarCraft Unit 구현 ###############
 * 
 * 클래스 간의 관계
*    클래스 간의 관계.
 *    Unit -> GroundUnit  -> Marine, SCV, Tank
 *         -> AirUnit     -> Dropship
 *         
 *         -> Building -> Academy, Buncker, Barrack(공중), Factory(공중)
 *  1. SCV 클래스 구현
 *     - 수리(다형성 적용)
 *       대상 : SCV, Tank, Dropship
 *       
 *  2. Building 에서 공중을 띄우는 공통 능력을 interface 로 작성.
 *  3. Barrack, Factory에서 class 구현.     
 *     
 * 
 */

public class OopEx5 {

	public static void main(String[] args) 
	{
		// 구체화된 Fighter 클래스 사용
		
		// 다형성이 적용이 되었는지 확인.
		// 클래스 간의 관계가 있는 다형성( Object , Unit )
		// -> Vector, 배열에서의 Unit 관리 목적의 다형성. -> 확인 완료됨.
		
		
		// 클래스 간의 관계가 없는 다형성( Fightable, Attackable, Moveable )
		// -> 메소드의 매개변수, 반환형 다형성.
		
		SCV scv = new SCV(1,1,1,1,"SCV");
		Tank tank = new Tank(2,2,2,2,"Tank");
		DropShip dropship = new DropShip(3,3,3,3,"DropShip");
		Marine marine = new Marine(4,4,4,4,"Marine");
		
		scv.Repair(tank);
		scv.Repair(dropship);
		scv.Repair(marine);
		
		scv.Attack(marine);
		marine.Attack(scv);
		scv.Attack(dropship);

		
		/*if(f instanceof Fightable)
		{
			System.out.println("Fightable 타입");
		}
		if(f instanceof Moveable)
		{
			System.out.println("Moveable 타입");
		}
		if(f instanceof Attackable)
		{
			System.out.println("Attackable 타입");
		}*/
		
		
		
		
	} // end of main()

}
/*    ======= 구현 목록 =======
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









// 클래스 작성
class Unit 
{
	final int MAX_HP; // Unit의 에너지. 부족하면 수리 받아야 함.
	private String Name;
	private int Att;
	private int CurrentHP;
	private int x;         // 이동 좌표.
	private int y;         // 이동 좌표.
	
	Unit(int x, int y, int hp,int Att,String str)
	{
		SetName(str);
		Setindex(x,y);
		SetHp(hp);
		SetAtt(Att);
		this.MAX_HP = hp;
	}
	void SetHp(int hp)
	{
		this.CurrentHP = hp;
	}
	
	void Setindex(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	void SetAtt(int Att)
	{
		this.Att = Att;
	}
	
	void SetName(String str)
	{
		this.Name = str;
	}
	
	public int GetAtt()
	{
		return this.Att;
	}
	
	public String GetName()
	{
		return this.Name;
	}
	
	public int GetHp()
	{
		return this.CurrentHP;
	}
	
}

class SCV extends Unit implements Fightable,Repairable,GroundUnit
{
	SCV(int x, int y, int hp,int Att,String str) 
	{
		super(x, y, hp,Att,str);
	}
	public void Attack(Unit unit) 
	{
		if(unit instanceof Attackable && unit instanceof GroundUnit)
		{
			unit.SetHp(unit.GetHp() - this.GetAtt());
			System.out.println(unit.GetName() + "유닛 남은 체력 : " + unit.GetHp());	
		}
		else
		{
			System.out.println(this.GetName() + " 유닛은 " + unit.GetName() + "유닛을 공격할수 없습니다."  );
		}
	}
	public void move(int x, int y) 
	{
		this.Setindex(x, y);
		
	}
	public void Repair(Unit r)
	{
		Unit unit = (Unit)r;
		if(r instanceof Repairable)
		{
			unit.SetHp(unit.MAX_HP);
			System.out.println(unit.GetName() + " 수리 완료.");
		}
		else
		{
			System.out.println(unit.GetName() + " 수리 불가유닛.");
		}
	}
}

class Tank extends Unit implements Fightable,Repairable,GroundUnit
{

	Tank(int x, int y, int hp,int Att,String str) 
	{
		super(x, y, hp,Att,str);
	}
	@Override
	public void Attack(Unit unit) 
	{
		if(unit instanceof Attackable && unit instanceof GroundUnit)
		{
			unit.SetHp(unit.GetHp() - this.GetAtt());
			System.out.println(unit.GetName() + "유닛 남은 체력 : " + unit.GetHp());	
		}
		else
		{
			System.out.println(this.GetName() + " 유닛은 " + unit.GetName() + "유닛을 공격할수 없습니다."  );
		}
	}

	@Override
	public void move(int x, int y) 
	{
		this.Setindex(x, y);
	}

	
}

class DropShip extends Unit implements Moveable,AirUnit
{
	DropShip(int x, int y, int hp,int Att,String str) 
	{
		super(x, y, hp,Att,str);
	}
	
	public void move(int x, int y) 
	{
		this.Setindex(x, y);
	}
	
}

class Marine extends Unit implements Fightable,GroundUnit
{
	
	Marine(int x, int y, int hp,int Att,String str) 
	{
		super(x, y, hp, Att,str);
	}
	@Override
	public void Attack(Unit unit) 
	{
		if(unit instanceof Attackable)
		{
			unit.SetHp(unit.GetHp() - this.GetAtt());
			System.out.println(unit.GetName() + "유닛 남은 체력 : " + unit.GetHp());	
		}	
	}
	@Override
	public void move(int x, int y) 
	{
		this.Setindex(x, y);
		
	}
}


interface GroundUnit{}
interface AirUnit{}
interface Repairable {}

// interface( 이동, 공격 )


// Unit의 이동 능력을 표현
interface Moveable 
{
	void move(int x, int y);	
}

// Unit의 공격 능력을 표현
interface Attackable 
{
	// starcraft에서 모든 대상은 공격받을 수 있는 캐릭터이다.
	// 모든 대상이 포함되도록 다형성 적용. 관계도 상의 최상위 부모클래스 타입으로 한다.
	void Attack(Unit unit);
	
}


// interface의 상속
// Unit의 이동 공격 능력을 표현
interface Fightable extends Moveable,Attackable
{
	
}

//--------------- 여기까지는 추상화 레벨.( 부모 클래스, interface, 추상메소드 )

//--------------- 지금부터는 구체화 레벨.( 공격자 클래스 )

// class의 상속, interface의 구현.
//class Fighter extends Unit implements Fightable
//{
//	Fighter(int x, int y, int hp,int att,String str) 
//	{
//		super(x, y, hp,att,str);
//	}
//
//	@Override
//	public void move(int x, int y) 
//	{
//		Setindex(x, y);
//	}
//
//	@Override
//	public void Attack(Attackable unit) 
//	{
//		if(unit instanceof Unit)
//		{
//			Unit t_unit = (Unit) unit;
//			t_unit.SetHp(t_unit.GetHp() - this.GetAtt());
//			System.out.println(t_unit.GetName() + "유닛 남은 체력 : " + t_unit.GetHp());	
//		}
//	}
//	
//}











