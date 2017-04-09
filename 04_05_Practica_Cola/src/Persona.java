
public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private float altura;
	
	public Persona(String nombre, String apellido, int edad, float altura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public float getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido
				+ ", edad=" + edad + ", altura=" + altura + "]";
	}
	
	
}
