package com.vti.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

public class Demo {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
//		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
//		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
//		str.remove(2);
//
//
//		System.out.println(list);
//		System.out.println(str);

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(1);
//		stack.push(2);
//		System.out.println(stack);
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.isEmpty());

//		Queue<Integer> queue = new LinkedList<Integer>();
//		for(int i = 0; i < 5; ++i) {
//			queue.add(i);
//		}
//		System.out.println(queue);
//		System.out.println(queue.peek());
//		
//		queue.remove(2);
//		System.out.println(queue);

//		Set<Integer> setFirst = new HashSet<>(list);
//		Set<Integer> set = new HashSet<Integer>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(3);
//		System.out.println(set);
//		System.out.println(setFirst);
//		List<Integer> listAfter = new ArrayList<>(set);
//		System.out.println(listAfter);
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "A");
		map.put(101, "B");
		map.put(102, "C");
		System.out.println(map);
		for(int i = 0; i < map.size(); i++) {
			System.out.println(map);
		}
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry e = itr.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

}
