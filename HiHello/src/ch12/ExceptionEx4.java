package ch12;


/*
 *  - 예외 처리
 *   실행중인 프로그램의 실행 유지 또는 정상 종료.
 *   자바에서 제공되는 예외처리 메커니즘을 사용하지 않으면, 비정상 종료.
 *   
 *   try
 *   {
 *     예외 모니터링
 *     예외 발생한 코드 작성
 *   }
 *   catch(Exception e)
 *   {
 *     예외 처리 코드 작성
 *   }
 * 
 *   처리할 코드 -> 정상종료.
 *   
 *   finally
 *   {
 *     예외 발생 유무와 상관없이 처리할 코드를 작성.
 *     예) 프로그램 설치시, 사용했던, 설치 파일 삭제.
 *     
 *         File 생성하고, 작성, 수정, 삭제 -> 자원해제시 사용되는 메소드 close();
 *         
 *         모든 OS 입장에서의 자원에 대해서는 대부분 close(); 함수 또는 메소드가 있음.
 *         자원 : File, Socket, DB 등..
 *         
 *     고려사항. -> 자원 해제시, finally가 복잡도가 높아질 가능성.
 *             -> 해결점 -> try...with...resources...
 *                         해결을 위한 구문을 사용하기 위해서는 AutoCloseable interface를 구현.      
 *        자원해제 가능한 경우 -> 메모리에 자원이 로딩되어 있는 상태인 경우.    
 *        자원의 인스턴스가 null인지 체크 후, null이 아니면 자원해제
 *        
 *        try{}
 *        catch(){}
 *        finally{}
 *         
 *   }
 * 
 * 
 * 
 * 
 */

class TestException extends Exception
{
	public void testMethod()
	{
		
	}
}

public class ExceptionEx4 {

	public static void main(String[] args) 
	{
		method1();
		System.out.println("method1() 호출 종료");
		System.out.println("main() 정상 종료.");
	}
	
	static void method1()
	{
		try
		{
			System.out.println("method1() : 호출됨.");
			return;
			// return 이 있더라도 finally는 수행된다.
			// 예외 발생 유무와 상관없이 finally는 수행된다.
//			Exception e = new Exception("강제호출");
//			throw e;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("method1() : finally");
		}
	}
	

}
