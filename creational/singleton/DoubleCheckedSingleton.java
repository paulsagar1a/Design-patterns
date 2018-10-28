/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * Thread safe implementation works fine and provides thread-safety but 
 * it reduces the performance because of cost associated with the 
 * synchronized method, although we need it only for the first few
 * threads who might create the separate instances. To avoid this extra 
 * overhead every time, double checked locking principle is used. In this
 * approach, the synchronized block is used inside the if condition with
 * an additional check to ensure that only one instance of singleton class
 * is created.
 ************************************************************************/
package creational.singleton;

public class DoubleCheckedSingleton {
	private static DoubleCheckedSingleton instance;
	private DoubleCheckedSingleton() {
		System.out.println("Double Checked Singleton Instance");
	}
	public static DoubleCheckedSingleton getInstance() {
		if(instance == null) {
			synchronized(DoubleCheckedSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}
}
