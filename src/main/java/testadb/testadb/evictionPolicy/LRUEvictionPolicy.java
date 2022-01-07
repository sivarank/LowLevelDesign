package testadb.testadb.evictionPolicy;

import java.util.LinkedList;

public class LRUEvictionPolicy<K> implements IEvictionPolicy<K> {

	LinkedList<K> list = new LinkedList<>();
	
	@Override
	public void add(K k) {
		list.remove(k);
		list.addLast(k);
	}

	@Override
	public K evict() {
		return list.removeFirst();
	}
}
