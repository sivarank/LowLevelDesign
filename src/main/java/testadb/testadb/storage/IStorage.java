package testadb.testadb.storage;

public interface IStorage<K, V> {
	void put(K k, V v);
	void remove(K k);
	V get(K k);
}
