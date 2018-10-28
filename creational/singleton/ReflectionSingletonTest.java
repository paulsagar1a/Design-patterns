/**************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * Reflection can destroy the singleton pattern as it can make constructor
 * access modifier private to public.When you run the above test class, we
 * will notice that hashCode of both the instances are not same that 
 * destroys the singleton pattern.
 ***************************************************************************/
package creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitializationOnDemandHolder instance1 = InitializationOnDemandHolder.getInstance();
		InitializationOnDemandHolder instance2 = null;
		try {
			Constructor[] constructors = InitializationOnDemandHolder.class.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				constructor.setAccessible(true);
				instance2 = (InitializationOnDemandHolder)constructor.newInstance();
				break;
			}
		} catch (SecurityException | InstantiationException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("HashCode of instance1= "+instance1.hashCode());
		System.out.println("HashCode of instance2= "+instance2.hashCode());
		
		/*OutPut:
			HashCode of instance1= 31168322
			HashCode of instance2= 17225372*/
	}

}
class InitializationOnDemandHolder {
	private InitializationOnDemandHolder() {}
	private static class SingletonHolder {
		private static InitializationOnDemandHolder instance = new InitializationOnDemandHolder();
	}
	public static InitializationOnDemandHolder getInstance() {
		return SingletonHolder.instance;
	}
}
