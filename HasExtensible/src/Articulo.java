
public class Articulo<E> implements Comparable<Articulo<E>> {
	int clave;
	protected String descripcion;
	double precio;
	String fechaV;
	public Articulo() {		
	}
	
	public Articulo(int clave,String descrpcion, double precio,String fechaV) {
		this.clave = clave;
		this.descripcion = descrpcion;
		this.precio = precio;
		this.fechaV = fechaV;
		//this.claveBin = binario();
	}
	
	@SuppressWarnings("unchecked")
	public int compareTo(Articulo<E> o) {
		return this.clave - o.clave;
	}
	 
	public boolean equals(Object o) {
		if(o instanceof Articulo) {
			Articulo op = (Articulo) o;
			return op.clave == clave;
		}else {
			return false;
		}
	}
	public String getDescripcion(){
		return descripcion;
	}
	/*private String binario() {
		String claveB =  clave;
		int aux;
		String bin ="";
		for(int i = 0; i< (claveB).length(); i++) {
			aux =  (int)claveB.charAt(i);
			bin = bin + Integer.toBinaryString(aux);
		}
		return bin;
	}*/
	
	public String toString() {
		return  "\ndescripcion: \t" + 
				descripcion + "\nprecio: \t"+ precio+
				"\nfecha de vencimiento: " +fechaV;  
	}
	
}
