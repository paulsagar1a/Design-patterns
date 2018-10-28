/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * This thread safe singleton class is same as lazy initialized singleton
 * except it can be used in multi-threaded environment. Because this 
 * provides class level synchronization (static synchronization) to
 * prevent access from multiple thread at same time
 ************************************************************************/
package creational.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton() {
		System.out.println("Thread-safe Singleton Instance");
	}
	public static synchronized ThreadSafeSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
}
