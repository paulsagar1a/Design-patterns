/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * A Bill Pugh Singleton is based on the “initialization on demand holder”
 * idiom. This idiom uses inner classes and does not use any
 * synchronization construct. It uses static blocks, but in a different 
 * way — and suggests using static inner classes.
 ************************************************************************/
package creational.singleton;

public class BillPughSingleton {
	private BillPughSingleton() {
		System.out.println("Bill Pugh Singleton Instance");
	}
	
	private static class SingletonHolder {
		private static BillPughSingleton instance = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
