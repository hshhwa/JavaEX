package ch13;

import java.util.Collections.*;
import java.util.*;

/*
 * Collections class 활용.   ********** 기술질문 단골 **************   *추가* Thread 알아보기
 * 
 *  Collection(자료 묶음)을 쉽게 사용하기 위해 다양한 기능의 메소드가 정의되어 있는 클래스.
 *  - 현재의 Collection의 인스턴스들은 용도가 데이터 저장용.
 *  - 현재는 실행 환경이 single Thread 이다.
 *  - 프로세스 하나가 데이터 저장소를 전용으로 혼자서 사용하고 있음.
 *  
 *  - 프로세스 두 개이상 또는 멀티쓰레드가 같은 데이터 저장소를 함께 사용하게 되면 어떻게 될까?????
 *  - 동기화를 맞춘 Collection 을 사용하면 됨. 자바에서 제공되는 동기화 collection을 사용.
 * 
 * 
 * 
 */



public class CollectionsFWEx2 {

	public static void main(String[] args) 
	{
		// 동기화 Collection 메소드임.
		// 메소드 명 앞에 synchrnized 로 prefix가 시작되는 메소드를 사용.
		// 멀티 쓰레드 환경, 다중 프로세스 환경인 경우가 언제인지 만 알면됨.
		// 멀티 쓰레드 환경 : 채팅 서버(멀티쓰레드 대상 : Socket )
		//                          ( Collection 관리 대상 : 주고 받는 message )
		//     -> TCP/IP 환경, Socket(IP, PORT ), 
		//Collections.synchronizedList(null);
		
		
		List list = new ArrayList();
		System.out.println(list);
		
		// Collections 메소드 사용.
		Collections.addAll(list,1,2,3,4,5);
		System.out.println(list);
		
		Collections.addAll(list, 2);
		System.out.println(list);
		
		Collections.addAll(list, 0, 2);
		System.out.println(list);
		
		Collections.shuffle(list);  // 섞기
		System.out.println(list);
		
		Collections.sort(list);  // 정렬
		System.out.println(list);
		
		Collections.reverse(list); // 역정렬
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder()); // Collections.reverse(list) 와 동일
		System.out.println(list);
		
		int idex = Collections.binarySearch(list, 3); // 해당 데이터의 위치값
		System.out.println("index = " + idex);
		
		List newList = Collections.nCopies(list.size(),2); // 새로운 배열을 생성 후 , 모두 2로 초기화.
		System.out.println(newList);
		
		System.out.println("Max = " + Collections.max(list));
		System.out.println("Max = " + Collections.min(list));
		
		Collections.fill(list, 9); // 요소를 모두 9로 변경.
		System.out.println(list);
		
		Collections.replaceAll(list, 2, 1);
		System.out.println(list);
		
		

	}

}
