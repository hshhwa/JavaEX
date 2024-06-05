package ch16;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

/*
 * 
 *  함수형 인터페이스의 JAVA API
 *  
 *  목적 : Stream 의 API문서를 보고 사용하기 위해.
 *        Stream 의 메소드를 사용해야 하는데, 이때 각 메소드의 매개변수를 파악하고 사용하기 위함이다.
 * 
 *  - 패키지 : java.util.function 
 *  
 *  - 매개변수가 없거나, 하나인 함수형 인터페이스 (종류 및 의미)
 *    1. Supplier<T> : 매개변수는 없고 반환형만 있다.
 *    2. Consumer<T> : 매개변수만 있고 반환값이 없다.
 *    3. Function<T, R> : 모양이 일반적인 함수. 하나의 매개변수를 받아 처리 후, 결과를 반환
 *    4. Predicate<T> : 조건식을 표현할 때 사용. 매개변수는 하나, 반환타입이 boolean
 *  
 *  - 매개변수가 두 개인 함수형 인터페이스 (종류 및 의미)
 *    1. BiConsumer<T, U> : 두개의 매개변수가 있고 반환값이 없다.
 *    2. BiFunction<T, U, R> : 모양이 일반적인 함수. 두개의 매개변수를 받아 처리 후, 결과를 반환
 *    3. BiPredicate<T, U> : 조건식을 표현할 때 사용. 매개변수는 두개, 반환타입이 boolean
 *    
 *    
 *  - Operator
 *    1. UnaryOperator(Unary : 단 항)
 *    	  UnaryOperator<T> : 매개변수가 한 개이고, 매개변수와 결과의 타입이 동일한 경우.
 *         Function<T>와의 차이점은 매개변수와 결과의 타입이 동일한 것이다.  
 *    2. BinaryOperator(Binary : 이 항)
 *        BinaryOperator<T> : 매개변수가 두 개이고, 매개변수와 결과의 타입이 동일한 경우.
 *         BiFunction<T>와의 차이점은 매개변수와 결과의 타입이 동일한 것이다.
 *         
 *         
 *  - 함수형 API가 매개변수로 사용되는 JAVA API 메소드
 *  
 *    Map : Key와 value 로 구성된 자료형. 따라서, 데이터 추가시 매개변수가 2개이다.
 *    
 *    void forEach( BiConsumer<T,U> action )  BiConsumer<T,U> action는 람다식
 *    
 *    Map의 모든 요소에 작업 action을 수행한다.
 *    
 *    
 *    
 *    Collection 
 *    
 *    boolean removeIf( Predicate<T> filter )
 *    조건에 맞는 요소를 삭제
 *         
 *         
 *         
 *         
 */

public class LambdaEx2 {

	public static void main(String[] args) {
		
		// 데이터 소스( ArrayList ) => Collection ( List, Set, Map )
		ArrayList<Integer> list =  new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		// forEach()
		// 함수형 인터페이스 : Consumer<? super E> action
		// 매개변수가 있고 반환값이 없다.
		list.forEach(i -> System.out.println(i + ","));
		System.out.println();
		
		// removeIf
		// 함수형 인터페이스 : Predicate<? super E> filter
		// 매개변수는 하나, 반환타입 boolean
		list.removeIf(i -> i % 2 == 0  );
		System.out.println(list);
		
		// replaceAll
		// 함수형 인터페이스 : UnaryOperator<E> operator
		// Function<T> 와 차이 : 매개변수과 반환 타입이 동일하다 
		list.replaceAll(i -> i * 10);
		
		
		// 데이터 소스( Map )
		Map<String, String> map = new HashMap<String, String>();
		map.put("1","1");
		map.put("2","2");
		map.put("3","3");
		map.put("4","4");
		
		
		// forEach()
		// 함수형 인터페이스 : BiConsumer<? super K, ? super V> action
		// 매개변수가 2개이고 반환값이 없다.
		// (k,v)->{}
		// (k,v)->{System.out.println("{" + k + ", " + v + "}");}
		map.forEach((k,v)->System.out.println("{" + k + ", " + v + "}"));
		
	}

}
