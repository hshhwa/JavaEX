package ch12;

import java.util.Vector;


/*
 * --------------------------- 메소드에서 Exception 발생시켜서 던지기 ----------------------------
 *                                    - 예외 처리 위임 -
 * 
 * 
 * 
 * 
 * 
 * --------------------------- 메소드에서 Exception 처리 문제 ( 해결해보기 ) ----------------------------
 * 
 * - 요구사항
 *   파일을 처리하는 중 예외가 발생할 수 있음을 가정하고 프로그램을 구현.
 *   - 기능 : 복사공간 여유 확인, 메모리 여유 확인, 파일복사, 설치, 임시파일 삭제
 *   - 예외 처리 : 복사공간 여유 없을때, 메모리가 부족할때
 *   
 *   - 프로그램 동작 순서
 *     - 설치 시작 -> 복사공간 여유 확인 -> 메모리 여유 확인 -> 파일복사 -> 설치 완료.
 *     - 설치 완료 -> 임시파일 삭제
 *   
 *   - 좋은 코드로 작성하기 위한 기준
 *     응집도 높다 -> 관련있는 것끼리 묶는다 -> 메소드 형태
 *                                   -> 설치 메소드, 파일 복사 메소드, 파일 삭제 메소드, 메모리 체크, 디스크 용량 체크
 *     재사용 성이 높은 것 -> 예외클래스 작성.
 * 
 */


class PartEmptyException extends RuntimeException
{
	public PartEmptyException(String message)
	{
		super(message);
	}
}

class Computers
{
	ComputerPart HDD = new Disk();
	ComputerPart Memomy = new Memory();
	
	ComputerPart[] Parr = {new Disk(),new Memory()};

	
	void Install()
	{
		for(int i = 0; i < Parr.length; i++)
		{
			FileSave(Parr[i]);
		}
	}
	
	void UnIstall()
	{
		for(int i = 0; i < Parr.length; i++)
		{
			FileDelete(Parr[i]);
		}
	}
	
	void FileSave(ComputerPart cp)
	{
		cp.Save();
	}
	
	void FileDelete(ComputerPart cp)
	{
		cp.Delete();
	}
	
	
	
	
	
	
}

class ComputerPart
{
	final int MAX_VALUE;
	int CurrentValue = 0;
	String Partname;
	
	ComputerPart(int Maxvalue,String Name)
	{
		this.MAX_VALUE = Maxvalue;
		this.Partname = Name;
	}
	
	public void GetPartName()
	{
		System.out.println("부품의 이름은 : " + this.Partname);
	}
	
	public boolean Check()
	{
		if(this.MAX_VALUE <= this.CurrentValue)
		{
			throw new PartEmptyException(this.Partname + "저장공간이 부족합니다.");
			// 저장공간이 부족
		}
		System.out.println(this.Partname + "저장공간이 남았습니다.");
		return true;
		// 저장공간 여유
	}
	
	public void Save()
	{
		try
		{
			if(Check())
				CurrentValue =10;
			System.out.print("파일을 저장합니다.");
		}
		catch(PartEmptyException e)
		{
			throw e;
		}
		// 파일을 저장.
	}
	
	public void Delete()
	{
		try
		{
			if(CurrentValue > 0)
			{
				CurrentValue--;
				System.out.println(this.Partname + "저장공간 확보");
			}
			else
			{
				throw new PartEmptyException(this.Partname + " 공간 부족");
			}
			System.out.println("파일을 삭제합니다.");
		}
		catch(PartEmptyException e)
		{
			throw e;
		}
		// 파일을 삭제
	}
}


class Disk extends ComputerPart 
{
	Disk() 
	{
		super(3,"DISK");
	}

	boolean CookieFile = false;

	public void Save()
	{
		super.Save();
		CookieSave();
	}
	
	public void Delete()
	{
		super.Delete();
		CookieDelete();
	}
	public void CookieDelete()
	{
		if(CookieFile)
		{
			CookieFile = !CookieFile;
			System.out.println("쿠키파일 삭제완료");
		}
	}
	public void CookieSave()
	{
		if(!CookieFile)
		{
			CookieFile = !CookieFile;
			System.out.println("쿠키파일 생성");
		}
	}
}

class Memory extends ComputerPart
{

	Memory() 
	{
		super(3,"MEMORY");
	}

}


public class ExceptionEx3 
{

	static void method1() throws Exception
	{
		method2();
//		try 
//		{
//			method2();			
//		}
//		catch(Exception e)
//		{
//			
//		}
	}
	
	static void method2() throws Exception
	{
		throw new Exception("mtehod2() : 예외 발생."); // 예외 처리 위임
	}
	
	public static void main(String[] args) 
	{
		try
		{
			method1(); // 위임 받은 예외를 처리한다.
		}
		catch(Exception e)
		{
			
		}
		//method1(); // 비정상 종료되게 됨. -> JVM 에서 예외처리했다.
		
		System.out.println("정상 종료됨");
		
		Computers C = new Computers();
		C.Install();
		C.Install();
		C.Install();
		C.Install();
		C.Install();
		C.Install();

		
	}

}
