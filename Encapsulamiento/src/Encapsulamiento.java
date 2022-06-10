import java.util.Scanner;
import java.util.Calendar;
import java.util.TimeZone;
public class Encapsulamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia, mes, anio, opc = 0;
		Scanner scanner = new Scanner(System.in); 
		miFecha fecha = new miFecha(); // a)Declaración de variable de instancia del tipo MiFecha en una línea independiente
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); //Fecha actual
		
		//b)	Instanciación de un objeto del tipo MiFecha sobre la variable del punto anterior
		 fecha.setDia(calendar.get(Calendar.DATE));
		 fecha.setMes(calendar.get(Calendar.MONTH) + 1);
		 fecha.setAnio(calendar.get(Calendar.YEAR));
		
		while(opc != 4) { // d)	Crear menú para poder hacer cambio de día, mes o año.

			System.out.print("Fecha: ");
			System.out.println(fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAnio()); // c)	Impresión en consola del contenido de cada uno de los atributos, uno por línea
			System.out.println("Elija una opción");
			System.out.println("1: Cambiar día");
			System.out.println("2: Cambiar mes");
			System.out.println("3: Cambiar año");
			System.out.println("4: Salir");
			opc = scanner.nextInt();
			switch (opc) {
			case 1: System.out.print("Nuevo día: ");
					dia = scanner.nextInt();
					while(fecha.setDia(dia) == false) {
						System.out.println("Día no válido");
						System.out.print("Ingresa otro día: ");
						dia = scanner.nextInt();
					}
					fecha.setDia(dia);
					break;
			case 2: System.out.print("Nuevo mes: ");
					mes = scanner.nextInt();
					while(fecha.setMes(mes) == false) {
						System.out.println("Mes no válido");
						System.out.print("Ingresa otro mes: ");
						mes = scanner.nextInt();
					}
					fecha.setMes(mes);
					break;
			case 3: System.out.print("Nuevo año: ");
					anio = scanner.nextInt();
					while(fecha.setAnio(anio) == false) {
						System.out.println("Año no válido (revise la fecha)");
						System.out.print("Ingresa otro año: ");
						anio = scanner.nextInt();
					}
					fecha.setAnio(anio);
					break;
			case 4:
					break;
			default:
				throw new IllegalArgumentException("Opción inválida: " + opc);
			}
		}
		
	

	}
}

class miFecha {
	
	private int dia;
	private int mes;
	private int anio;
	
	public miFecha() { // constructor sin parametros
		
	}
	
	// getters
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAnio() {
		return this.anio;
	}
	
	// setters
	public boolean setDia(int dia) {
		if (dia < 1 || dia > 31) {	
			return false;
		}
		else if(this.mes == 2 && dia > 28)
		{
			if(verifica(this.anio) == true && dia == 29) {
				this.dia = dia;
				return true;
			}
			else {
				return false;
			}
		}
		else if(dia > 30 && this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
			return false;
		}
		else {
			this.dia = dia;
			return true;
		}
	}
	public boolean setMes(int mes) {
		if (mes < 1 || mes > 12) {
			return false;
		}
		else if (this.dia > 28 && mes == 2) {
			if(verifica(this.anio) == true && dia == 29) {
				this.mes = mes;
				return true;
			}
			else {
				return false;
			}
		}
		else if (this.dia > 30 && mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return false;
		}
		else {
			this.mes = mes;
			return true;
		}
	}
	public boolean setAnio(int anio) {
		if(this.dia == 29 && this.mes == 2) {
			if(verifica(anio)) {
				this.anio = anio;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			this.anio = anio;
			return true;
		}
	}
	public boolean verifica(int anio) { // ¿Año biciesto?
		if((anio % 4 == 0) && (anio % 100 != 0) || (anio% 400 == 0)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
}
