package ch13;
import java.util.*;
/*
 * 컬렉션 프레임워크(Collections Framework)
 * 
 * 데이터 집합을 저장하는 클래스들을 표준화한 설계.
 * 
 * 컬렉션    : 데이터 집합, 그룹
 * 프레임워크 : 표준화된 프로그래밍 방식
 * 
 * 핵심 인터페이스 : List, Set, Map, Collection
 *  Collection : List, Set 의 기반.
 *               컬렉션 클레스에 저장된 데이터를 읽고, 추가, 삭제 하는 등.
 *               컬렉션을 다루는데 가장 기본적인 메소드를 정의하고 있음.
 * 
 *  List : 순서가 있는 데이터 집합. 중복을 허용 한다.
 *         -> ArrayList, LinkedList, Stack, Vector 등...
 *         
 *         LinkedList
 *         		class Node
 *         		{
 *         			Node next;  <- 다음의 Node를 가르키는 정보.
 *         			Object obj;    단방향 LinkedList 임을 알 수 있음.
 *        		}
 *        
 *        ArrayList 와 LinkedList 차이점
 *         - 접근 시간(읽기) : ArrayList(훨~씬빠름) >>>>>>>>>>>> LinkedList 
 *         - 추가/삭제      : ArrayList <<<<<<<<<<<<<< LinkedList가 빠름
 *         
 *        Stack, Queue
 *        
 *        Stack : 후입선출 LIFO (Last In First Out)
 *        		  - 단방향 구조(위에서 밑으로만)
 *        Queue : 선입선출 FIFO (First In First Out)
 *        		  - 단방향 구조(위에서 밑으로만)
 *        
 *        Deque(Double Ended Queue)
 *        		  - 양방향 구조(위 아래로 가능)
 *        
 *        Iterator
 *       		  컬렉션 프레임워크 에서 컬렉션에 저장된 데이터를 읽어오는방법을 표준화
 *         		  
 *         - 종류: Iterator, Enumeration, ListIterator
 *           차이점 : Enumeration은 Iterator 의 구버전.
 *                  ListIterator는 Iterator를 상속받아서 기능을 추가적으로 구현.
 *                  
 *                  따라서, Enumeration은 regacy 코드 유지를 위해서 사용.
 *                  신규 개발에서는 ListIterator or Iterator 를 사용.
 *                  
 *           메소드 : hasNext(), next(), remove()
 *                   -> for 문을 사용하지 않고도 탐색이가능.
 *                   -> 표준화된 개발을 할 수 있다. 재사용성, 코드의 일관성, 코드 품질 향상.
 *           
 *           
 *           Comparator, Comparable : 컬렉션의 정렬과 관련된 기능.
 *                현재 기본 정렬은 오름차순으로 되어 있다.
 *           
 *           
 *          	    
 *                
 *                        
 *         
 *  Set  : 순서를 유지하지 않는다. 중복을 허용하지 않는다.
 *         -> HashSet, TreeSet
 *         
 *         HashSet : 저장 순서를 유지하려고 하면, LinkedhashSet 을 사용.
 *         
 *         TreeSet : 이진 검색 트리
 *                 정렬, 검색, 범위 검색에 높은성능을 보인다.  
 *                 중복된 데이터의 저장을 허용하지 않는다.
 *                 각 노드에 최대 2개의 노드를 연결 할 수 있다.
 *                 Root 라고 하는 하나의 노르도부터 시작해서 확장한다.
 *                 노드 간의 관계. (부모-자식)
 *                 
 *                 class TreeNode
 *                 {
 *                    TreeNode left;
 *                    TreeNode Right;
 *                    Object element;
 *                 }
 *                 
 *                 단점 : 노드의 추가 삭제에 시간이 걸림.
 *         
 *  Map  : 키(Key)와 값(value)의 쌍으로 이루어진 데이터 집합.
 *         순서 유지하지 않음. 키 중복 허용하지않음. 값은 중복허용.
 *		   -> HashMap, TreeMap, HashTable, Properties 등...	 
 *
 *    	   - HashMap
 *      		-> 데이터 저장형태가 선형구조로 저장.
 *      		   탐색방법은 순차 탐색으로 진행.
 *      		   검색 성능이 낮다.
 *    
 *     	   - TreeMap
 *				-> 데이터 저장 형태가 이진 구조(왼쪽, 오른쪽)로 저장.
 *				   이진 탐색으로 진행 검색 성능이 좋음.
 *
 *         - Properties
 *              -> Key, Value 가 String 이다.
 *              Iterator 가 Enumeration 이다.
 *
 */



public class CollectionsFWEx1 
{

	public static void main(String[] args) 
	{
		
		// HashMap 과 TreeMap 차이
		
		HashMap testhashMap = new HashMap();
		TreeMap testTreeMap = new TreeMap();
		
		
		
		
		// ArrayList
		ArrayList list1 = new ArrayList();
		list1.add(5);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		System.out.println("list1 : " + list1);
		
		// 정렬
		Collections.sort(list1);
		System.out.println(list1);
		
		// 다른 데이터 유형 저장
		list1.add(3, "A");
		System.out.println(list1);
		
		Collections.shuffle(list1);
		System.out.println(list1);
		
		// LinkedList -> 데이터가 노드 구조로 연결되 있다 -> 다음 데이터 탐색시 참조해서 이동.
		LinkedList ll = new LinkedList();
		
		// list에 데이터저장
		add(ll);
		
		// 탐색 시간 확인
		// LinkedList -> 데이터가 노드 구조로 연결되 있다 -> 다음 데이터 탐색시 참조해서 이동.
		System.out.println("LinkedList : " + access(ll));
		
		// 탐색 속도 비교 대상
		// ArrayList
		// 데이터의 시작과 끝 사이까지 전부 데이터.
		// 다음 데이터 탐색시 참조해서 이동과 같은 탐색 작업이 없음.
		// 배열 단점 : 크기가 고정. 저장 공간의 확장성이 없다.
		// 그래서, 배열의 단점을 개선한 ArrayList는
		// 저장 공간의 확장성이 자유롭다.
		// 단점 : 기존의 배열에 공간이 없으면, 새로운 배열을 생성 후 기존 배열의 데이터를 복사
		// 고려사항 : 저장된 대상의 데이터가 작으면 상관이 없지만, 대량의 데이터의 경우는 고려해야한다.
		
		// 기타 : 데이터 수정, 추가, 삭제 시 발생하는 성능과 관련해서 확장해서  
		ArrayList al = new ArrayList(100000);
		
		add(al);
		System.out.println("ArrayList : " + access(al));
		
		// ------------------- Iterator 사용 ------------------------
		ArrayList list2 = new ArrayList();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("5");
		Iterator iter = list2.iterator();
		
		// 표준화된 데이터 탐색이 가능해진다.
//		while(iter.hasNext())
//		{
//			Object obj = iter.next();
//			System.out.println(obj);
//		}
//		
		// ListIterator : Iterator 를 개선한 것. 양방향 탐색이 가능.
		ListIterator Liter = list2.listIterator();
		
		while(Liter.hasNext())
		{
			System.out.println(Liter.next());      // 순방향 탐색.
			
		}
		
		System.out.println();
		
		while(Liter.hasPrevious())
		{
			System.out.println(Liter.previous()); // 역방향 탐색.
		}
		
		// -------------------- Comparator, comparable ---------------------
		// 기본형 타입
		// 우리에게 의미 있는 것은 값이 10
		int a = 10;
		
		// 참조형 타입
		// 우리에게 의미 있는 것은 값이 10
		// 랩퍼 클래스 : 객체지향 프로그래밍에서 기본형도 객체지향으로 관리하고 싶은 경우 제공되는 클래스
		
		
		Integer ii = new Integer(10);
		
		ii.compareTo(ii);
		
		// 정렬
		String[] strArr = {"cat", "Dog", "loin", "tiger"};
		
		// sort() 메소드의 기본 정렬은 오름차순임.
		// 내림차순으로 정렬하려는 경우
		// 1. Comparator interface를 구현한 클래스 작성.
		//    compare 메소드를 내림차순 되도록 재정의
		// 2. Arrays 에서 제공되는 sort() 중에서
		//    Comparator 타입의 매개변수가 있는 메소드를 선택.
		// 3. 구현된 Comparator 클래스를 이용해서
		// 4. sort() 메소드 매개변수로 적용해서 사용.
		
		List temp = new ArrayList();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(4);
		
		
		Arrays.sort(strArr);
		System.out.println("strArr = " + Arrays.toString(strArr));
		System.out.println(strArr);
		
		// 내림차순 정렬
		Arrays.sort(strArr, new Descending());
		System.out.println("sort = " + Arrays.toString(strArr));
		
		System.out.println("Descending = " + Arrays.toString(strArr));
		
		
		// ------------------ HashSet ---------------------
		Object[] objArr = {"1", new Integer(1), "2", "3", "3", "4",1, 2};
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; i++)
		{
			set.add(objArr[i]);
		}
		
		System.out.println(set);
		
		// ------------------ TreeSet ---------------------
		Set treeset = new TreeSet();
		
		for(int i = 0; treeset.size() < 6; i++ )
		{
			int num = (int)(Math.random() * 45) + 1;
			treeset.add(num);
		}
		
		System.out.println(treeset);
		
		
		// ------------------ HashMap ---------------------
		// HashMap을 사용한 데이터 탐색.
		HashMap m = new HashMap();
		m.put("myID", "1234");
		m.put("asdf", "1111");
		m.get("myId");
		
		String id = "myID";
		String password = "1234";
		
		if(!m.containsKey(id))  // id가 존재하는 경우, 하지않는 경우2가지
		{
			System.out.println("아이디가 존재하지않습니다.");
		}
		else
		{
			if (!m.get(id).equals(password))
			{
				System.out.println("비밀번호가 틀림");
			}
			else
			{
				System.out.println("id와 비밀번호가 일치");
			}
		}
		
		
		// HashMap에서 Iterator 사용
		HashMap map2 = new HashMap();
		
		map2.put("김자바", 90); // 정수 상수 -> Object
		                      // 형변환 : 작은 -> 큰거 (자동형변환)
		                      // Integer : int도 객체로 사용하고 싶은 경우.
		                      // Integer 도 클래스 이기 때문에 자동으로 Object를 상속 받게 된다.
		map2.put("이자바", 99);
		map2.put("박자바", 70);
		map2.put("홍자바", 60);
		map2.put("안자바", 100);
		
		// iterator 사용하기 위해서
		// 1. set
		// 2. set에서 iterator
		
		Set set2 = map2.entrySet();
		Iterator it2 = set2.iterator();
		
		while(it2.hasNext())
		{
			// map에서 key와 value를 함께 사용하기 위한 타입 : Entry
			Map.Entry entry = (Map.Entry)it2.next();
			System.out.println("이름 : " + entry.getKey() + " 점수 : " + entry.getValue());
		}
		
		// HashMap에서 value만 출력.
		// 점수 집합 -> 총점계산 으로 활용.
		// 학생 집합 -> 학생 명수로 활용.
		
		// 총점 계산
		Collection values = map2.values();
		it2 = values.iterator();
		
		int total = 0;

		while(it2.hasNext())
		{
			Integer grade = (Integer)it2.next();  // down cating
			
			total += grade.intValue();
		}
		
		System.out.println("총점 : " + total);
		
		// 학생 집합 처리
		set = map2.keySet();
//		System.out.println("학생 명부 : " + set);
		//System.out.println("평균 : " + total / it2)
		
		// set.size() : 요소 개수.
		System.out.println("평균 : " + (float)total / set.size());
		
		// 최고점수 Collections 활용.
		System.out.println("최고 점수 : " +  Collections.max(values));
		
		// 최하 점수
		System.out.println("최하 점수 : " +  Collections.min(values));
		
		// 학원관리 서비스를 만든다는 가정하에.
		
		// 학생리스트 
		// 1. 학생리스트를 메모리에 두고 계속 사용할 것인가? (in memory)
		// 2. 학생리스트를 db에 두고 계속 사용할 것인가?? (out memory)
		// 3. 학생리스트를 in memory 와 out memory를 함께 사용 할 것인가??
		//    -> in memory 와 out memory의 동기화는 어떻게 할 것인가?
		// 4. 서비스별로 in memory 와 out memory를 사용이 필요한가?
		// 4번 까지 진행한 것이 MSA ( MicroServiceArchitecture );
		// 5. 모놀리식 MSA 를 할 것인가? 아니면, 클라우드 기반의 MSA 를 할 것인가?
		//    -> 엄청난 서비스 이면서, 고객수가 엄청남, 글로벌 서비스 -> 클라우드 기반의 MSA
		//    DDD, TDD, 애자일...
		
		
		// ERP ( 전사적 자원 관리 시스템 , 회계 시스템 ) => sap, 더존, 영림원, oracle
		//                                               메가존 클라우드, 베스핀
		// 더존도 클라우드 기반의 ERP
		// 쿠팡, 삼성전자, CJ 대한통운
		
		// ERP 정보관리사 1급( 업무지식, 더존 EPR )
		
		
		// --------------------------- TreeMap -----------------------------------
		String[] data = {"A","K","A","K","D","K","A","Z","K","K","Z","D","D","D"};
		
		TreeMap treeMap = new TreeMap();
		Set tset = treeMap.entrySet();
		
		for(int i = 0; i < data.length; i++)
		{
			if(!treeMap.containsKey(data[i]))
			{
				treeMap.put(data[i],new Integer(1));
				continue;
			}
			Integer tmp = (Integer)treeMap.get(data[i]);
			treeMap.put(data[i],++tmp);
		}
		
		System.out.println(treeMap);
		
		
		// 결과
		/*
		 *  A : 3
		 *  K : 5
		 *  D : 2
		 *  Z : 2
		 *  
		 */
		// --------------------------- TreeMap 강의 버전 -----------------------------------
		TreeMap treeMap2 = new TreeMap();
		
		for(int i = 0; i < data.length; i++)
		{
			// 배열의 문자가 map에 key로 존재하는가.
			if(treeMap2.containsKey(data[i]))
			{
				// 빈도수 증가를 위해서 현재의 조회
				Integer value = (Integer)treeMap2.get(data[i]);
				// 현재의 빈도수 + 1 한 값을 해당의 key에 저장.
				treeMap2.put(data[i],new Integer(value.intValue() + 1));
				
				
				// http 통신시 put 함수 역할.
				// get(조회), post(등록), put(수정), delete(삭제)
			}
			else
			{
				treeMap2.put(data[i], new Integer(1));
				// treeMap2의 키로 등록.
			}
		}
		
		// Iterator를 활용해서 출력
		Iterator treeiter = treeMap2.entrySet().iterator();
		while(treeiter.hasNext())
		{
			Map.Entry entry = (Map.Entry)treeiter.next();
		
			
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
		
		// 빈도수를 내림차순으로 정렬해서 출력.
		// 1. Collections.sort()
		// 2. sort() 의 기본 정렬은 오름차순임.
		// 3. Collections.sort()에 매개변수로 구현한 Comparator를 매개변수로 대입.
		// 4. Collections.sort()의 첫 번째매개변수가 List임.
		// 5. 따라서, map을 List로 변경해야한다.
		
		
		/* 1. map -> list
		 *    List는 인터페이스 이다.
		 *    복사생성자를 활용. 구현체가 있어야 복사생성자를 활용.
		 *    ArrayList 클래스에서 복사생성자가 있는지 확인.
		 *    
		 *    ArrayList(Collection<? extends E> c)
		 *    복사생성자의 매개변수가 Collection 이다. 바로 사용 못한다.
		 *    Collection - List - ArrayList
		 *               - Set
		 *               
		 *    map -> Collection(list or set) -> list           
		 *    
		 *    
		 * 
		 * 
		 */
		List test = new ArrayList(treeMap2.entrySet());

		Collections.sort(test,new MapDecsending());
		
		Iterator testcase = test.iterator();
		
		System.out.println("");
		System.out.println("value 기준 내림차순");
		while(testcase.hasNext())
		{
			Map.Entry entry = (Map.Entry)testcase.next();
		
			
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

		// Collections.sort(list,)
		
		
		
        //  ------------------------- Properties ----------------------------
		Properties prop = new Properties();
		prop.setProperty("size","10");
		prop.setProperty("capacity","20");
		prop.setProperty("timeout","30");
		
		Enumeration E = prop.propertyNames();
		
		while(E.hasMoreElements())
		{
			String element = (String)E.nextElement();
			System.out.println("Key : " + element + " | Value : " + prop.getProperty(element));
		}
		
		
		
		
		
	} // end of main()
	
	
	// list 에 데이터 저장.
	public static void add(List list)
	{
		for(int i =0; i < 100000; i++)
		{
			list.add(i + "");
		}
	}
	
	// list 를 탐색.
	public static long access(List list)
	{
		long start = System.currentTimeMillis();
		
		// 시작 노드에서 마지막 노드까지 이동하면서 탐색
		for(int i = 0; i < 100000; i++)
		{
			list.get(i);
		}
		
		long end = System.currentTimeMillis();
		
		return end - start;	
	}
	
}

// 역방향 정렬을 위한 클래스. Comparator interface 를 구현하면 됨.
class Descending implements Comparator
{
	public int compare(Object o1, Object o2) 
	{
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry)
		{
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(o2) * -1;
		}
		
		return -1;
	}
}


class MapDecsending implements Comparator
{
	public int compare(Object o1, Object o2) 
	{
		// Map의 Key, Value 중에서 의미있게 정렬하려면, 비교 대상이 value 로 해야한다.
		
		
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry)
		{
			// Map.Entry key,value의 한 쌍 -> Entry
			Map.Entry c1 = (Map.Entry)o1;
			Map.Entry c2 = (Map.Entry)o2;
			
			Comparable a1 = (Comparable)c1.getValue();
			Comparable a2 = (Comparable)c2.getValue();
			
			// 강의
			Integer v1 = (Integer)c1.getValue();
			Integer v2 = (Integer)c2.getValue();
			
			return a1.compareTo(a2) * -1;
			
			//return v1.compareTo(v2) * -1;
		}
		
		return -1;
	}
	
}
