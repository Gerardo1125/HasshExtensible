
import java.util.ArrayList;

public class TetstExtensible {

	public static void main(String[] args) {
	Articulo a1 = new Articulo(4,"Uso para casos de hash", 50,"2-5-2020");
	Articulo a2 = new Articulo(8,"Uso para casos de arrayList", 100,"1-8-2022");
	Articulo a3 = new Articulo(12,"Uso para casos de Array", 30,"28-10-2028");
	Articulo a4 = new Articulo(7,"Uso para casos de interfase", 38,"14-11-2019");
	Articulo a5 = new Articulo(18,"Uso para casos de metodos", 46,"30-6-2028");
	Articulo a6 = new Articulo(11,"Uso para casos de comparaciones", 84,"19-7-2025");
	Articulo a7 = new Articulo(13,"Uso para casos de clases", 99,"22-12-024");
	Articulo a8 = new Articulo(22,"Uso para casos de LinkedList", 133,"26-1-2021");
	Register<Articulo> r1 = new Register<Articulo>(a1.clave,a1);
	Register<Articulo> r2 = new Register<Articulo>(a2.clave,a1);
	Register<Articulo> r3 = new Register<Articulo>(a3.clave,a3);
	Register<Articulo> r4 = new Register<Articulo>(a4.clave,a4);
	Register<Articulo> r5 = new Register<Articulo>(a5.clave,a5);
	Register<Articulo> r6 = new Register<Articulo>(a6.clave,a6);
	Register<Articulo> r7 = new Register<Articulo>(a7.clave,a7);
	Register<Articulo> r8 = new Register<Articulo>(a8.clave,a8);
	
	HashExtensible h = new HashExtensible(2);
	
	h.insert(r1);
	h.insert(r2);
	//h.insert(r3);
	h.insert(r5);
	h.mostrar();
	System.out.println();
	System.out.println(h.search(18));
	
	}

}
