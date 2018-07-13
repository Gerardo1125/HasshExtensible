
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HashExtensible<E> {
	protected class Element{
		protected ArrayList<Register<E>> list;
		protected int contador;

		public Element(){ 
			this.contador = 1;
			this.list = new ArrayList<Register<E>>();
		}
		public String toString(){
			String s = "";
			for(int i = 0; i < list.size() ; i++){
				s = s + "\t"+ list.get(i).toString() + contador; 
			}
			return s;
		}
	}

	protected ArrayList<Element> table;
	protected int m;
	protected int conteo;

	public HashExtensible(int o){
		conteo = 1;
		this.m = o;
		this.table = new ArrayList<Element>();
		this.table.add(new Element());
		this.table.add(new Element());
	}

	public void insert(Register<E> a){
		if(search(a.key) == null){
			int op = a.key%table.size();
			if(table.get(op).contador < conteo){
				op = a.key%(table.size()/
						(2*(conteo-table.get(op).contador)));
			}
			if(table.get(op).list.size() < m){	
				table.get(op).list.add(a);
			}else{
				if(table.get(op).contador == conteo){
					dividir();
					//auxDireccionar();
					repartir(op,a);
					
				}else{
					repartir(op,a);
					//auxDireccionar();
				}
			}
		}else{
			System.out.println("Elemento ya existente");
		}
		
	}
	public void dividir(){
		int cont = table.size();
		conteo = conteo+1;
		for(int i = 0; i < cont; i++){
			table.add(new Element());
		}
	}
	
	public void repartir(int a,Register<E>b){
		table.get(a).contador++;
		int op = (int)Math.pow(2, table.get(a).contador);	
		for(int i = 0; i < table.get(a).list.size(); i ++){
			
			if((table.get(a).list.get(i).key%op) != a){
				Register<E> aux = table.get(a).list.remove(i);
				
				if(table.get(aux.key%op).list.equals(
						table.get(a).list) ){
					table.get(aux.key%op).list = 
							new ArrayList<>();
				}
				table.get(aux.key%op).list.add(aux);
				table.get(aux.key%op).contador = 
						table.get(a).contador;
				i--;
			}
		}
		if(table.get(b.key%op).list.equals(
				table.get(a).list) && a != b.key%op){
			table.get(b.key%op).list = new ArrayList<>();
		}
		if(table.get(b.key%op).list.size() == m){
			dividir();
			//auxDireccionar();
			repartir(b.key%op, b);
			auxDireccionar();
		}else{
			table.get(b.key%op).list.add(b);
			table.get(b.key%op).contador = 
					table.get(a).contador;
			auxDireccionar();
		}
		
		//auxDireccionar();
		//direccionar(a);
	}
	/*public void direccionar(int a){
		int c=a;
		if(c%2 == 1){
			c = 0;
			if(table.get(c).contador < conteo){
				direccionar2(c);
			}
		}
	}
	public void direccionar2(int a){
		for(int i = 0; i < table.size(); i++){
			if(table.get(i).list.size()== 0 && i%Math.pow(2, table.get(a).contador) ==0 && i != a){
				table.get(i).list= table.get(a).list;
				table.get(i).contador= table.get(a).contador;
			}
		}
	}*/
	public void auxDireccionar(){
		for(int i = 0; i < table.size(); i++){
			int j = i;
			
			for(j = j+(int)Math.pow(2, table.get(i).contador); 
					j < table.size(); 
					j = j+(int)Math.pow(2, table.get(i).contador)){
				if(table.get(j).list.size() == 0){
					table.get(j).list = table.get(i).list;
					table.get(j).contador = table.get(i).contador;
				}else if(table.get(i).contador > table.get(j).contador){
					table.get(j).list = new ArrayList<Register<E>>();
					table.get(j).list = table.get(i).list;
					table.get(j).contador = table.get(i).contador;
				}
			}
		}
	}
	
	public void remove(int k) {
		int op = k%table.size();
		Register<E> aux = search(k);
		if(aux != null) {
			int i = 0;
			for(i= 0; i < table.get(op).list.size(); i++) {
				if(aux.equals(table.get(op).list.get(i))) {
					break;
				}
			}
			if(table.get(op).contador == 1 ) {
				table.get(op).list.remove(i);
			}else {
				table.get(op).list.remove(i);
				merge(op);
				unir();
			}
		}else {
			System.out.println("El elemento no existe");
		}
	}
	private void merge(int op) {
		if(table.get(op).contador == conteo) {
			int c = (int)Math.pow(2, table.get(op).contador-1);
			if(c+op > table.size()-1) {
				if(table.get(op).list.size() + table.get(op-c).list.size() <= m) {
					for(int i = 0; i < table.get(op).list.size(); i++) {
						table.get(op-c).list.add(table.get(op).list.remove(i));
						i--;
					}
					table.get(op-c).contador--;
					auxDireccionar();
					/*table.get(op).list = table.get(op-c).list; 
					table.get(op).contador = table.get(op-c).contador;*/
				}
			}else {
				if(table.get(op).list.size() + table.get(op+c).list.size() <= m) {
					for(int i = 0; i < table.get(op+c).list.size(); i++) {
						table.get(op).list.add(table.get(op+c).list.remove(i));
						i--;
					}
					table.get(op).contador--;
					auxDireccionar();
					/*table.get(op+c).list = table.get(op).list; 
					table.get(op+c).contador = table.get(op).contador;*/
				}
			}
		}else {	
			int c = op % (int)Math.pow(2, table.get(op).contador);
			int hermano = c - (int)Math.pow(2, table.get(c).contador-1);
			if( hermano >= 0) {
				if(table.get(hermano).contador == table.get(c).contador && table.get(hermano).list.size() + table.get(c).list.size() <= m) {
					for(int i = 0; i < table.get(c).list.size() ; i++) {
						table.get(hermano).list.add(table.get(c).list.remove(i));
						i--;
					}
					table.get(hermano).contador--;
					/*table.get(c).list = new ArrayList<>();
					table.get(op).list = new ArrayList<>();
					table.get(c).list = table.get(hermano).list;
					table.get(op).list = table.get(hermano).list;
					table.get(c).contador= table.get(hermano).contador;
					table.get(op).contador= table.get(hermano).contador;
					*/
					auxDireccionar();
				}
			}else {
				hermano = c + (int)Math.pow(2, table.get(c).contador-1);
				if(table.get(hermano).contador == table.get(c).contador && table.get(hermano).list.size() + table.get(c).list.size() <= m) {
					for(int i = 0; i < table.get(hermano).list.size() ; i++) {
						table.get(c).list.add(table.get(hermano).list.remove(i));
						i--;
					}
					table.get(c).contador--;
					auxDireccionar();
				}
			}
		}
	}
	
	private void unir() {
		boolean verdad = false;
		for(int i = 0; i < table.size(); i++){
			if(table.get(i).contador == conteo) {
				verdad = true;
				break;
			}
		}
		if(verdad == false) {
			int tam = table.size()/2;
			for(int i = 0; i< table.size(); i++) {
				table.remove(tam);
			}
			conteo--;
		}
	}
	public void mostrar(){
		for(int i = 0; i < table.size(); i ++) {
			System.out.println();
			System.out.print(i+ "("+conteo+")\t");
			System.out.print("("+table.get(i).contador+")  ");
			for(int j = 0; j < table.get(i).list.size(); j++){
				System.out.print(table.get(i).list.get(j).key+"\t\t");
			}
		}
	}
	public Register<E> search(int k){
		int op = k%table.size();
		
		for(int i = 0; i < table.get(op).list.size(); i++){
			if(table.get(op).list.get(i).key == k){
				return table.get(op).list.get(i);
			}
		}
		return null;
		
	}
	public String toString(){
		String s= "";

		for (Element item : table){

			s += item.toString() +"\n";

		}
		return s;
	}
}
