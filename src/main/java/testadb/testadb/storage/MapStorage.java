package testadb.testadb.storage;

import java.util.HashMap;
import java.util.Map;

import testadb.testadb.exceptions.StorageFull;

public class MapStorage<K, V> implements IStorage<K,V> {
	Map<K,V> map = new HashMap<>();
	
	@Override
	public void put(K k, V v) {
		if(map.size() > 2) {
			throw new StorageFull();
		}
		map.put(k, v);		
	}

	@Override
	public void remove(K k) {
		map.remove(k);		
	}

	@Override
	public V get(K k) {
		return map.get(k);
	}
}
