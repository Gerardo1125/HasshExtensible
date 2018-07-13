import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		Register<String> a1 = new Register<String>(1,"s");
		Register<String> a2 = new Register<String>(2,"sa");
		Register<String> a3 = new Register<String>(3,"ss");
		Register<String> a4 = new Register<String>(4,"ss");
		Register<String> a5 = new Register<String>(5,"ss");
		Register<String> a6 = new Register<String>(6,"ssaa");
		Register<String> a7 = new Register<String>(7,"ssaa");
		Register<String> a8 = new Register<String>(8,"ssaa");
		Register<String> a9 = new Register<String>(9,"ssaa");
		Register<String> a10 = new Register<String>(10,"ssaa");
		Register<String> a11 = new Register<String>(11,"ssaa");
		Register<String> a12 = new Register<String>(12,"ssaa");
		Register<String> a13 = new Register<String>(13,"ssaa");
		Register<String> a14 = new Register<String>(14,"ssaa");
		Register<String> a15 = new Register<String>(15,"ssaa");
		Register<String> a16 = new Register<String>(16,"ssaa");
		Register<String> a17 = new Register<String>(17,"ssaa");
		Register<String> a18 = new Register<String>(18,"ssaa");
		Register<String> a26 = new Register<String>(26,"ssaa");
		HashExtensible nuevo = new HashExtensible(3);
		//System.out.println("dasd");
		nuevo.insert(a1);
		nuevo.insert(a2);
		nuevo.insert(a3);
		nuevo.insert(a4);
		nuevo.insert(a5);
		nuevo.insert(a6);
		nuevo.insert(a7);
		nuevo.insert(a8);
		//nuevo.insert(a9);
		nuevo.insert(a10);
		//nuevo.insert(a11);
		//nuevo.insert(a12);
		//nuevo.insert(a13);
		nuevo.insert(a14);
		//nuevo.insert(a15);
		//nuevo.insert(a16);
		//nuevo.insert(a17);
		nuevo.insert(a18);
		nuevo.insert(a26);
		nuevo.remove(2);
		nuevo.remove(5);
		//nuevo.remove(12);
		//nuevo.remove(8);
		//nuevo.remove(10);
		/*nuevo.remove(10);
		nuevo.remove(8);
		nuevo.remove(14);
		nuevo.remove(12);
		nuevo.remove(13);*/
		nuevo.mostrar();
		System.out.println();
		//System.out.println(nuevo.search(13));
		//System.out.println(nuevo.search(3));
		
		
	}
}
