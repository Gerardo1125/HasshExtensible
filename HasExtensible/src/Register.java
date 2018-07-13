

public class Register<E> implements Comparable<Register<E>>{
	protected int key;
	protected E reg;
	public Register(int key, E reg){
		this.key = key;
		this.reg = reg;
	}
	public int compareTo(Register<E> r){
		return this.key - r.key;
	}
	public boolean equals(Object o){
		if (o instanceof Register){
			Register<E> r = (Register<E>)o;
			return r.key == this.key;
		}
		return false;
	}
	
	public int getKey(){return this.key;}
	
	public String toString(){
		return this.key+":"+this.reg.toString();
	}
}