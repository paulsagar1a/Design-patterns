/***************************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * To overcome the situation with reflection, we can use Enum as java ensures
 * that any enum value is initialized only once in a java program.Since Java Enum 
 * values are globally accessible, so is the singleton. The drawback is that the 
 * enum type is somewhat inflexible; for example, it does not allow lazy initialization.
 ***************************************************************************************/
package creational.singleton;

public enum EnumSingleton {
	INSTANCE;
	public static void method() {
		//method implementation details
	}
}
