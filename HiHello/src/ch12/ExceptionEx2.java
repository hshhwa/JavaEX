package ch12;

/*
 * - Object
 *  - Throwable
 *   - Exception : checked 예외
 *    - RuntimeException : unchecked 예외
 *    
 * - 사용시의 Exception 의 분류
 *   - Exception : checked 예외
 *                 -> 컴파일러가 예외처리를 확인.
 *   - RuntimeException : unchecked 예외
 *                        -> 컴파일러가 예외처리를 확인하지 않음.
 *                          -> ex) 0으로 나누는 코드 ( 컴파일러가 코드를 체크하지 않는다. )   
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
public class ExceptionEx2 {

	public static void main(String[] args) 
	{
		
		
		
		try
		{
			throw new RuntimeException();
			// 개발자가 필요에 의해서 예외를 발생시키는 경우. -> 사용자정의 예외
			// 1. Exception 클래스의 인스턴스 생성.
			// 2. 인스턴스를 던지면 된다.
			
//			Exception ue = new Exception("고의로 예외 발생시킴");     <- 참조변수를 이용한 방법.   
//			throw ue;	
			
			//throw new Exception("고의로 예외 발생시킴");
//			
//			System.out.println(3);
//			System.out.println(0/0);  // ArithmeticException 발생.
//			System.out.println(4);
			
		} 
		catch(ArithmeticException e)
		{
			if(e instanceof Exception)
			{
				System.out.println("true");
			}
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			// ArithmeticException는 Exception로 만들어진 파생이다.
			// 따라서, 다형성으로 catch가 된 것이다.
			System.out.print("Exception!! : ");
			System.out.println(e.getMessage());
		}
		
		// Exception 처리가 되었으므로, 정상종료가 됬다.
		System.out.println(5); // 출력이 되면, 정상 종료 했다.
		
		System.out.println("프로그램이 정상 종료 되었습니다.");
		
		
	}

}
