import java.io.Console;
import java.util.*;

public class main {

	public static Cola<Persona> Colita = new Cola<Persona>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char respuesta = ' ';
		boolean seguir = true;

		while (seguir) {
			System.out.println("1-Añadir nueva persona");
			System.out.println("2-Eliminar persona");
			System.out.println("3-Eliminar siguiente persona(pop)");
			System.out.println("4-Comprobar existencia persona");
			System.out.println("5-Mostrar listado");
			System.out.println("6-Limpiar cola");
			System.out.println("7-Salir");
			System.out.print("Elige lo que quieres hacer (1-5):");
			respuesta = sc.next().charAt(0);

			switch (respuesta) {
			case '1':
				AnadirPersona();
				break;
			case '2':
				EliminarPersona();
				break;
			case '3':
				BorrarSiguiente();
				break;
			case '4':
				ComprobarPersona();
				break;
			case '5':
				MostrarLista();
				break;
			case '6':
				LimpiarCola();
				break;
			case '7':
				System.out.println("Adios :D");
				seguir = false;
				break;
			default:
				System.err.println("No eligiste una opción correcta (1-5)");
				break;
			}
		}

	}

	public static void AnadirPersona() {
		String nombre, apellido, edad, altura;
		char confirmacion = ' ';
		int edadn = 0;
		float alturan = 0;
		boolean error = true, seguir = true;

		do {
			seguir = true;
			System.out.print("Introduce el nombre: ");
			nombre = sc.next();
			System.out.print("Introduce el apellido: ");
			apellido = sc.next();
			do {
				error = true;
				System.out.print("Introduce la edad: ");
				edad = sc.next();
				if (Comprobador(edad, 1)) {
					edadn = Integer.parseInt(edad);
					error = false;
				} else {
					System.err.println("ERROR: No introduciste un número entero");
				}
			} while (error);

			do {
				error = true;
				System.out.print("Introduce la altura: ");
				altura = sc.next();
				if (Comprobador(altura, 2)) {
					alturan = Float.parseFloat(altura);
					error = false;
				} else {
					System.err.println("ERROR: No introduciste un número");
				}
			} while (error);

			System.out.println("Nombre: " + nombre);
			System.out.println("Apellido: " + apellido);
			System.out.println("Edad: " + edadn);
			System.out.println("Altura: " + alturan);
			System.out.print("¿Confirmar?(S/N):");
			confirmacion = sc.next().charAt(0);
			if (confirmacion == 's' || confirmacion == 'S') {
				seguir = false;
			}
		} while (seguir);

		Colita.push(new Persona(nombre, apellido, edadn, alturan));

		System.out.println("Persona añadida con exito!");

	}

	public static boolean Comprobador(String msg, int tipo) {
		try {
			if (tipo == 1) {
				Integer.parseInt(msg);
			} else {
				Float.parseFloat(msg);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void EliminarPersona() {
		String respuesta = "";
		int respuestan = 0;
		boolean error = true;
		Persona aux = null;

		if (!Colita.isEmpty()) {
			System.out.println("0 Volver..");
			MostrarLista();
			do {
				error = true;
				System.out.print("Elige persona según su indice: ");
				respuesta = sc.next();
				if (Comprobador(respuesta, 1)) {
					respuestan = Integer.parseInt(respuesta);
					respuestan--;
					error = false;
				}

				if (!error) {
					if (respuestan == -1) {
						error = false;
					} else {
						aux = Colita.get(respuestan);
						if (aux == null) {
							System.err.println("ERROR: No se encontro ningún elemento en ese indice");
							error = true;
						} else {
							Colita.remove(aux);
							error = false;
						}
					}
				}

			} while (error);
		} else {
			System.err.println("No hay personas disponibles ");
		}

	}

	public static void MostrarLista() {
		if(!Colita.isEmpty())
			System.out.println(Colita);
		else
			System.err.println("No hay ninguna persona añadida...");
	}

	public static void ComprobarPersona() {
		String nombre;
		if(!Colita.isEmpty()){
		System.out.print("Introduce el nombre de la persona a buscar: ");
		nombre = sc.next();
		for (int i = 0; i < Colita.size(); i++) {
			if (Colita.get(i).getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Si esta!!! :P");
				break;
			}else if(i==Colita.size()-1){
				System.err.println("No se encontro ningún " + nombre + " :(");
			}
		}
		}else{
			System.err.println("No hay ninguna persona en la lista");
		}
	}

	public static void BorrarSiguiente() {
		try {
			Colita.pop();
		} catch (Exception e) {
			System.err.println(e.getMessage());;
		}
	}

	public static void LimpiarCola() {
		Colita.clear();
		System.out.println("Limpiadita :P");
	}
}
