package testadb.testadb;

import org.junit.Test;

import junit.framework.TestCase;
import testadb.testadb.storage.IStorage;
import testadb.testadb.storage.MapStorage;

public class TestStorage1 extends TestCase {
	@Test
	public void testMapStorage() {
		IStorage<String, String> map = new MapStorage<>();
		map.put("1", "One");
		map.put("2", "Two");
		assertEquals("fail to  get value from map", "One",map.get("1"));
	}
}
