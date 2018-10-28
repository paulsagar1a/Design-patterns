/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * Static block initialization of singleton method is similar to eager
 * initialization except it use static block to initialize singleton
 * instance. It also provides exception handling. But it is also not a 
 * good practice as it initializes object at the time of class loading.
 ************************************************************************/
package creational.singleton;

public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;
	private StaticBlockSingleton() {
		System.out.println("Static Block Singleton Instance");
	}
	
	static {
		try{
			instance = new StaticBlockSingleton();
		} catch(Exception e) {
			System.out.println("Exception occured during the creation of StaticBlockSingleton instance");
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticBlockSingleton.getInstance();
	}

}
