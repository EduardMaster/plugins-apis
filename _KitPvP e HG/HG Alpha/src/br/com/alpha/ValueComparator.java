package br.com.alpha;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class ValueComparator implements Comparator<Object> {

	Map<UUID, Integer> map;

	private ValueComparator(Map<UUID, Integer> map) {
		this.map = map;
	}

	public int compare(Object o1, Object o2) {

		if (map.get(o2) == map.get(o1))
			return 1;
		else
			return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));

	}

	public static Map<UUID, Integer> returnSortedHashMap(Map<UUID, Integer> hashmap) {
		ValueComparator comparador = new ValueComparator(hashmap);
		Map<UUID, Integer> newMap = new TreeMap<>(comparador);
		newMap.putAll(hashmap);
		return newMap;
	}

}
