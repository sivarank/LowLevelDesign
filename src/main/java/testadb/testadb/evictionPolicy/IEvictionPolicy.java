package testadb.testadb.evictionPolicy;

public interface IEvictionPolicy<K> {
	void add(K k);

	K evict();
}
