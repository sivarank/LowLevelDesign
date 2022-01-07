package testadb.testadb;

import testadb.testadb.cache.Cache;
import testadb.testadb.cache.ICache;
import testadb.testadb.evictionPolicy.LRUEvictionPolicy;
import testadb.testadb.storage.MapStorage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ICache cache = new Cache(new MapStorage<String, String>(),  new LRUEvictionPolicy<String>());
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        System.out.println( cache.get("1") );
        System.out.println( "fdfd");
    }
}
