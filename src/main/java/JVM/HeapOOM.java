package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author superball
 * @time 2018年3月23日上午1:18:49
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}

/*
 * -verbose:gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * [GC (Allocation Failure) 5279K->3489K(19968K), 0.0080049 secs] [GC
 * (Allocation Failure) 9030K->8040K(19968K), 0.0133140 secs] [Full GC
 * (Ergonomics) 16837K->12631K(19968K), 0.1671016 secs] [Full GC (Ergonomics)
 * 16314K->16140K(19968K), 0.1242979 secs] [Full GC (Allocation Failure)
 * 16140K->16128K(19968K), 0.0982989 secs] java.lang.OutOfMemoryError: Java heap
 * space Dumping heap to java_pid10656.hprof ... Heap dump file created
 * [27633016 bytes in 0.124 secs] Exception in thread "main"
 * java.lang.OutOfMemoryError: Java heap space at
 * java.util.Arrays.copyOf(Arrays.java:3210) at
 * java.util.Arrays.copyOf(Arrays.java:3181) at
 * java.util.ArrayList.grow(ArrayList.java:261) at
 * java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235) at
 * java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227) at
 * java.util.ArrayList.add(ArrayList.java:458) at
 * JVM.HeapOOM.main(HeapOOM.java:18)
 */
