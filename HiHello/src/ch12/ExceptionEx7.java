package ch12;

/*
 *  예외 되던지기 : 예외 처리 후 throw -> 직접처리 or 위임처리
 *  
 *  기존 : 예외 던지기 -> throw -> 직접 처리 또는 위임 처리
 * 
 *  
 *  예외 되던지기 분류.
 *    - 연관된 시스템이 자바가 아닌 경우.
 *      별도의 A, B 라는 분리된 시스템이 있다고 가정.
 *      A : JAVA 로 개발됨.
 *      B : C#로 개발됨.
 *      
 *      A <-> B , 업무 처리시 서로 연결이 되어야 할 때
 *      
 *      통신규약(네트워크 통신) -> main() 메소드에서 전문을 반환.
 *      
 *      같은 서버에 A,B 가 존재하는 경우. -> main() 메소드에서 반환형을 정수 또는 문자.
 *      -> batch system.( spring batch )
 *      
 *      public static int main(String[] args) 
	    {
		  try
		  {
			  method1();
		  }
		  catch(Exception e)
		  {
			System.out.println("main() 예외 처리");
			return 1;   <--------------- 정수로 반환
		  }
		  return 0;     <--------------- 정수로 반환
	    }
	    
    연결된 예외 (chained exception)
    
    큰 분류로 묶어서 관리하는 경우, checked 에외를 unchecked로 변경하는 경우를 
    주로 사용 가능성이 높음
    
    
    예외 A가 예외 B를 발생시켰다면, A를 B의 예외 원이라고 한다.
    
    설치하는 프로그램 예시
    
    
    SpaceException, MemoryException, InstallException
    
    
    SpaceException, MemoryException 는 InstallException 의 예외 원인 이라고 할수 있다.
    -> 포함관계, 다형성가능 
    
    
    
    try
    {
      startInstall();
    }
    catch(SpaceException se)
    {
      InstallException ie = new InstallException();
      ie.initCause(se);
      
      initCause() : Throwable에 있는 메소드,Throwable에는 cause라는 변수가 있다.
                                                       cause의 type은 Throwable 이다.
      -> 현재 예외 인스턴스의 원인 예외를 등록할 수 있는 변수이다.
         cause의 type이 Throwable 임으로, 모든 예외는 발생한 예외의 원인 예외를 등록이 가능하다.
    }
    catch(MemoryException me)
    {
      InstallException ie = new InstallException();
      ie.initCause(me);
    }
    
    발생한 예외를 그냥 처리하면 되는데, 왠지 복잡해진 것 같은 느낌..
    - 하나의 큰 분류의 예외로 묶어서 관리하고 싶은 경우.
       -> 큰 분류의 예외 catch 블럭 에서 처리하려고 하는데, 실제로 발생한 예외를 알 수 없다.
       
    목적 : 추상화 또는 상속을 통해서 다형성을 통해 관리의 편리성을 높이기 위해.
          -> 반복되는 코드가 줄어들게 된다.(다형성이 적용된 매게변수, 반환타입)
       
    - 상속 관계로 exception을 정의하면 casting 처리가 필요해진다.
      파생된 exception이 많아지게 되면, cating 처리가 부담된다.    
    
      casting 대신에 initCause(), getCause()
    
    - checked 예외를 unchecked 로 변경하려고 하는 경우.  
      new RuntimeException(new MemoryException()) -> unchecked
 * 
 */


public class ExceptionEx7 
{

	public static void main(String[] args) 
	{
		try
		{
			method1();
		}
		catch(Exception e)
		{
			System.out.println("main() 예외 처리");
			
		}
		
		try
		{
			install();
		}
		catch(InstallException e)
		{
			// InstallException 에는 SpaceException or MemoryException 을
			// 원인 예외로 가지고 있다.
			
			if(e.getCause() instanceof MemoryException2)
			{
				System.out.println("InstallException 의 원인 : MemoryException2 ");
			}
			
			if(e.getCause() instanceof SpaceException2)
			{
				System.out.println("InstallException 의 원인 : SpaceException2 ");
			}
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			deleteTempFile2();
		}
		
		// checked 예외를 uncheced로 변경하려고 하는경우.
		// Exception -> RuntimeException 로 형변환 처럼 되는것 같지만,
		// 실제로는 연결된 예외 처리
		MemoryException2 met = new MemoryException2("unchecked 예외 용");
		
		// Exception -> RuntimeException 으로 변경됨.
		// 하지만, 실제로는 연결된 예외이다.
		// RuntimeException(met)
		// -> super((Throwable)met) -> Exception((Throwable)met)
		// -> super((Throwable)met) -> Throwable((Throwable)met)
		// -> this.cause = (Throwable)met; <<- 저장.
		
		// Throwable class 의 cause 인스턴스 변수에 저장.
		// 자기 자신이 원인이 되는 예외 -> 연결된 예외 라고 한다.
		
		// 결론적으로 checked -> unchecked 로 변경됨. 컴파일 체크를 하지 않게 된다.
		RuntimeException rte = new RuntimeException(met);
		
	}
	
	// 예외 되던지기 메소드
	static void method1() throws Exception
	{
		try
		{
			throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("method1() 예외 처리");
			throw e;
		}
	}
	


static void install() throws InstallException
{
	try
	{
		startInstall2();
	}
	catch (SpaceException se)
	{
		InstallException ie = new InstallException("설치중 예외 발생");
		
		// InstallException 의 원인 예외를 등록할 수 있다.
		// 원인 예외 InstallException의 인스턴스 멤버변수로 관리하고 있으니
		// 연결된 예외라고 말 할 수 있다.
		
		// 원인 예외(Cause)의 실제 소유 클래스는 Throwable 이다.
		// 즉, Throwable 클래스의 맴버변수(cause)이다.
		
		// 모든 예외는 자신을 발생시킨 원인 예외를 가질 수 있다.
		ie.initCause(se);
		throw ie;
	}
	catch(MemoryException me)
	{
		InstallException ie = new InstallException("설치중 예외 발생");
		ie.initCause(me);
		throw ie;
	}
}


// 프로그램 설치와 관련된 메소드 작성.
static void startInstall2() throws SpaceException,MemoryException
{
	if(!enoughSpace2())
	{
		throw new SpaceException("설치 실패 : 설치 공간 부족");
	}
	
	if(!enoughMemory2())
	{
		throw new MemoryException("설치 실패 : 메모리 공간 부족");
	}
	
	System.out.print("설치 완료");
	
}

static void deleteTempFile2()
{
	System.out.println("설치 파일 삭제 성공");
}

static boolean enoughSpace2()
{
	return false;
	// 디스크 여유 공간 체크 로직 작성.
	// false : 공간이 부족. -> 예외 발생 시켜야 하는 상황.
	// true : 디스크의 설치 공간이 충분 -> 예외 발생 하지 않음.
}

static boolean enoughMemory2()
{
	// 메모리 여유 공간 체크 로직 작성.
	return false;
}

} // end of main()


// 설치 예외
class InstallException extends Exception
{
	public InstallException(String msg)
	{
		super(msg);
	}
}

// 설치 예외의 원인 예외(디스크 용량)

class SpaceException2 extends Exception
{
  SpaceException2(String message)
  {
	super(message);
  }
}

// 설치 예외의 원인 예외(메모리 용량)
class MemoryException2 extends RuntimeException
{
  MemoryException2(String message)
  {
	super(message);
  }
}


