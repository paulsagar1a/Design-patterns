/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * This creational singleton method does not initialize class if the 
 * instance is already present in the JVM. This pattern works fine in case
 * of single threaded environment but in multi-threaded environment it
 * can cause issue; if multiple threads want to get access of the instance 
 * then each thread will get different instances of the same singleton 
 * class. For that we need to use thread-safe singleton class.
 ************************************************************************/
package creational.singleton;

public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;
	private LazyInitializedSingleton() {
		System.out.println("Lazy Initialized Singleton Instance");
	}
	
	public static LazyInitializedSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LazyInitializedSingleton.getInstance();
	}

}
