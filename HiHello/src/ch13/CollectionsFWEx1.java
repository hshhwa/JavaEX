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
 *
 */



public class CollectionsFWEx1 
{

	public static void main(String[] args) 
	{
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
		
		// LinkedList
		LinkedList ll = new LinkedList();
		
		// list에 데이터저장.
		add(ll);
		
		// 탐색 시간 확인
		//System.out.println("LinkedList : " + access(ll));
		
		// 탐색 속도 비교 대상
		ArrayList al = new ArrayList(100000);
		
		add(al);
		//System.out.println("ArrayList : " + access(al));
		
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
		Object[] objArr = {"1", new Integer(1), "2", "3", "3", "4"};
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
		
		
		// ------------------ TreeSet ---------------------
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
		if(o1 instanceof Comparable && o2 instanceof Comparable)
		{
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(o2) * -1;
		}
		
		return -1;
	}
	
}
