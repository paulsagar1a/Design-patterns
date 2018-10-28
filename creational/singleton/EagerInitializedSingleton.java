/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * This class instance is created at the time of class loading. This is 
 * easist method to create singleton object, but it has a draw back that
 * instance is created even though client application might not need it.
 ************************************************************************/
package creational.singleton;

public class EagerInitializedSingleton {
	private static EagerInitializedSingleton instance = new EagerInitializedSingleton();
	//constructor
	private EagerInitializedSingleton() {
		System.out.println("Eager Initialized Singleton Instance");
	}
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerInitializedSingleton.getInstance();
	}

}
