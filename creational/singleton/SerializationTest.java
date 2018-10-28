/********************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Singleton Design Patters
 * 
 * Deserialization always return new object no matter whether it is singleton class.
 * So to resolve this we need to provide readResolve method to the singleton class.
 *******************************************************************************/
package creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializationSingleton instance1 = SerializationSingleton.getInstance();
		SerializationSingleton instance2 = null;
		
		try(FileOutputStream file = new FileOutputStream("elephant.txt")) {
			ObjectOutput out = new ObjectOutputStream(file);
			out.writeObject(instance1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileInputStream file = new FileInputStream("elephant.txt")) {
			ObjectInput in = new ObjectInputStream(file);
			instance2 = (SerializationSingleton)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Instance1 hashCode= "+instance1.hashCode());
		System.out.println("Instance2 hashCode= "+instance2.hashCode());
		/*Output: (if we don't provide readResolve method in singleton class)
			HashCode of instance1= 38568376
			HashCode of instance2= 24725345*/
		/*Output: (if we provide readResolve method in singleton class)
		HashCode of instance1= 34560071
		HashCode of instance2= 34560071*/
	}

}

class SerializationSingleton implements Serializable {
	private static final long serialVersionUID = 1L;
	private static SerializationSingleton instance;
	private SerializationSingleton() {}
	public static SerializationSingleton getInstance() {
		if(instance == null) {
			instance = new SerializationSingleton();
		}
		return instance;
	}
	
	// implement readResolve method 
    protected Object readResolve() 
    { 
        return instance; 
    }

}
