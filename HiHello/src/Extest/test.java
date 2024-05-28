package Extest;
/*
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
*/



public class test {

	public static void main(String[] args) 
	{
		String xmlFilePath = "example.xml";
		String htmlFilePath = "example.html";
		
		
		XmlParser.parse(xmlFilePath);
		
		HtmlParser.parse(htmlFilePath);
		// TODO Auto-generated method stub

	}

}

class XmlParser
{
	public static void parse(String xmlFilePath)
	{
		System.out.println("xml 파일을 파싱한다. " + xmlFilePath);
	}
}

class HtmlParser
{
	public static void parse(String htmlFilepath)
	{
		System.out.println("html 파일을 파싱한다." + htmlFilepath);
	}
}
