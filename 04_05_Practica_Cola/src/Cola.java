
public class Cola<T> {

	private T[] elementos;

	public Cola(){
		elementos = (T[])new Object[0];
	}
	
	public void push(T elemento){
		T[]aux = (T[])new Object[elementos.length+1];
		
		for(int i=0; i < elementos.length; i++){
			aux[i] = elementos[i];
		}
		
		aux[aux.length-1] = elemento;
		
		elementos = aux;
	}
	
	public void pop() throws Exception{
		
		if(!isEmpty()){
			remove(get(0));
		}else{
			throw new Exception("No quedan elementos");
		}
	}
	
	public void remove(T elemento){
		T[]aux = (T[])new Object[elementos.length-1];
		
		for(int i=0, j=0; i < elementos.length; i++,j++){
			if(elemento == elementos[i]){
				j--;
			}else{
				aux[j] = elementos[i];
			}
		}
		
		elementos = aux;
	}
	
	public void clear(){
		elementos = (T[])new Object[0];
	}
	
	public boolean contains(T elemento){
		boolean encontrado = false;
		
		for(int i=0; i < elementos.length; i++){
			if(elemento == elementos[i]){
				encontrado = true;
				break;
			}
		}
		
		return encontrado;
	}
	
	public boolean isEmpty(){
		if(elementos.length <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int size(){
		return elementos.length;
	}
	
	//EXTRA
	public T get(int indice){
		
		if(indice >= 0 && indice < elementos.length){
			return elementos[indice];
		}else{
			return null;
		}
		
	}
	
	public String toString(){
		String listilla = "";
		
		for(int i=0; i < elementos.length; i++){
			listilla = listilla +  (i+1) + " " + elementos[i] + "\n";
		}
		
		return listilla;
	}
}
