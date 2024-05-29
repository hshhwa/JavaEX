package ch11;

/**
 * 
 * interfact 의 활용 - 반환타입에 적용하면 결합도가 낮아짐.
 * 					- java 의 jdbc 임.
 * 
 * 구문 분석 기능을 구현
 * 
 * - xml, html 을 파싱하는 기능을 구현.
 * - 여기서 중요한 것은 xml 1.0 버전의 구문 분석에서 2.0으로 변경되더라도
 *   파싱 기능을 호출하는 쪽에서는 변경에 대한 영향이 없도록 구현하는 것이 중요함.
 *   
 * - xml 파싱 전용 클래스, html 파싱 전용 클래스
 * - 파싱 기능을 사용하는 클래스(main 메소드가 있는 쪽)
 * - main 메소드 쪽에서 파싱할 파일을 전달하면 해당 전용 클래스쪽에서
 *   파싱한 결과를 알려주도록 하면 됨.
 * - 단, 파싱 전용 쪽에서 어떤 변화가 있더라도 호출한 쪽(main 메소드 쪽)에는
 *   영향이 없도록 해야 함.
 * - 파싱 기능은 실제 파싱을 수해하지 않고, System.out.println() 을 사용해서
 *   간단하게 출력되는 기능으로 구현하면 됨.
 *   
 *   1. main 메소드에서xml 파싱 기능을 사용시,
 *      xml 파싱 버전이 변경되어 코드가 변경되더라도, main 메소드에는 영향이 없어야함.
 *      
 *      -> 인터페이스의 반환형 다형성을 적용.
 *      
 *   2. main 메소드에서 xml 파싱 에서 html 파싱으로 변경이 되더라도
 *      쉽게 파싱기능을사용할 수 있도록 해야 한다.
 *      
 *      -> 인터페이스의 반환형 다형성을 적용.
 *      
 *   3. 파싱 기능에 대해서는 표준화가 되도록 해야 한다.
 *      향후에 JSON 파싱 등의 다른 구문 분석에 대한 요구사항이 발생할 수 있음.
 *      
 *   4. 개발 팀의 멤버가 변경될 수도 있다.    
 */


/*
 *  인터페이스의 장점
 * 1. 개발 시간을 단출할 수 있음. or 독립적인 프로그래밍이 가능 -> 생산성과 관련됨.
 * 2. 표준화가 가능 -> 생산성과 관련됨.
 * 3. 관계가 없는 것 끼리 맺어줄 수 있음.
 * 
 * 
 * 
 * */


// 아래의 A, B 클래스의 관계는 강결합된 관계
// 다른 쪽의 코드가 완성이 되기까지 기다려야 한다. -> 생산성이 떨어진다. 독립적인 프로그래밍 불가능.
// 강결합 스타일의 코드
//class A
//{
//	public void methodA(B b)
//	{
//		b.methodB();
//	}
//}
//
//class B
//{
//	public void methodB()
//	{
//		System.out.println("methodB()");
//	}
//}

// 강결합을 약결합으로 변경(결합도가 낮아짐.).

class A
{
	public void methodA(I b)
	{
		b.methodB();
	}
}


// 인터페이스를 활용하면, class A 쪽에 영향이 가지않는다.
// class A를 구현하는 팀원이 class B의 완성까지 기디리지 않아도된다.
// 독립적인 프로그래밍이 가능하다. => 생산성이 높아진다 & 유지보수성이 높아진다 & 개발시간이 단축된다.



class B implements I
{
	// 표준화가 가능.
	// 기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하도록 한다.
	// 항상 일관되게 methodB() 가 구현되어 짐으로 일관되고 정형화된 개발이 가능.
	public void methodB()
	{
		System.out.println("methodB()");
	}
}

interface I
{
	public abstract void methodB();
}




interface Parser
{
	public abstract void Parsing(Parser p);
}

class ParsingManager
{
	public static ParsingManager m_Instance;
	ParsingManager()
	{
		m_Instance = new ParsingManager();
	}
	
	public ParsingManager GetInstance()
	{
		if(m_Instance == null)
		{
			return m_Instance = new ParsingManager();
		}
		return m_Instance;
	}
	
	public static Parser CheckVersion(Parser p)
	{
		if(p instanceof HtmlParsing)
		{
			return new HtmlParsing();
		}
		else if(p instanceof xmlParsing)
		{
			return new xmlParsing();
		}
		else
		{
			return null;
		}
	}
}


class HtmlParsing implements Parser
{
	public void Parsing(Parser p)
	{
		if(p instanceof HtmlParsing)
		{
			System.out.println("htmlParsing 진행");
		}
	}
}

class xmlParsing implements Parser
{
	public void Parsing(Parser p)
	{
		if(p instanceof xmlParsing)
		{
			System.out.println("xmlParsing 진행");
		}
	}
}

public class OppEx6 {

	public static void main(String[] args) 
	{
		
		// ====================== parser 기능 동작 테스트 ======================
		// XML, HTML 관련 Parser class 를 직접 호출해서 사용하지 않으면 -> 약결합
		
		// 인스턴스 생성을 대리자(별도의 클래스)를 통해서 수행하면,
		// main() method 와의 직접적인 관계는 없어짐.
		
		// 인터페이스 형태로 반환이 되도록 해야한다.
		
		// 현재는 Parseable 반환되므로, NewXMLParser 가 되던, XMLParser 되던
		// 사용하는 쪽에서는 모르고 사용.
		ParserManager P_Manager = new ParserManager();
	}

}



// ==================== 파싱 기능 구현 문제 ====================
// 강의 구현
// 표준화 용도, main method 에서 쉽게 사용되도록 하는 용도.
interface Parseable
{
	public abstract void parse(String FileName);
}

// 파싱 전용 클래스
// 1.0 전용 XML parser
class XMLParser implements Parseable
{
	@Override

	public void parse(String FileName) 
	{
		System.out.println(FileName + " : XML 구문 분석 완료 ");
	}
	
}
// 2.0 전용 XML parser
// main 메소드에서 반환되는 인스턴스가 1.0이 될지 2.0이 될지 몰라도,
// 최신의 Parser가 사용 될 수있게 만들어야한다.
// XMLParser의변경이 main mothod 에서 코드레벨로 영향이 가지 않는다는 것을 의미함. -> 약결합.
// -> 인터페이스의 반환형 다형성.
class NewXMLParser implements Parseable
{
	@Override
	public void parse(String FileName) 
	{
		System.out.println(FileName + " : NEWXML 구문 분석 완료 ");
	}
	
}

// 응집도가 높게 구현함.
class HTMLParser implements Parseable
{
	@Override
	public void parse(String FileName) 
	{
		System.out.println(FileName + " : HTML 구문 분석 완료 ");
	}
	
}
// Parser 인스턴스 생성 대리자 클래스
// -> 약결합을 위한 클래스, 사용 편리성.
class ParserManager
{
	public static Parseable getParser()
	{
		return new XMLParser();
	}
}








