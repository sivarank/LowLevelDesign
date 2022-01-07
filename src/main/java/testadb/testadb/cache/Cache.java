package testadb.testadb.cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import testadb.testadb.evictionPolicy.IEvictionPolicy;
import testadb.testadb.exceptions.StorageFull;
import testadb.testadb.storage.IStorage;

/*
 *   APP --> use cache
 *   Cache
 *   Storage 
 *        HashMap
 *   EvictionPolicy
 *       LRUEvictionPolicy
 *         Map & LinkedList
 *   
 */

public class Cache<K, V> implements ICache<K, V> {
	IStorage<K, V> storage;
	IEvictionPolicy<K> evictPolicy;
	private static final Logger logger = LogManager.getLogger(Cache.class);  

	public Cache(IStorage<K, V> storage, IEvictionPolicy<K> evict) {
		this.storage = storage;
		this.evictPolicy = evict;
	}

	@Override
	public void put(K key, V value) {
		try {
			storage.put(key, value);
			evictPolicy.add(key);
		} catch (StorageFull ex) {
//			Properties props = new Properties();
//		    try {
//				//props.load(new FileInputStream("main/resources/log4j2.properties"));
//		    	String log4jConfPath = "main\\resources\\log4j2.properties";
//		    	PropertyConfigurator.configure(log4jConfPath);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		    PropertyConfigurator.configure(props);
//			logger.error(ex);
			K k1 = evictPolicy.evict();
			storage.remove(k1);
			storage.put(key, value);
		}
	}

	@Override
	public V get(K key) {
		return storage.get(key);
	}
}
