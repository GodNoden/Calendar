import java.util.Scanner;
import java.util.Calendar;
import java.util.TimeZone;
public class Encapsulamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia, mes, anio, opc = 0;
		Scanner scanner = new Scanner(System.in); 
		miFecha fecha = new miFecha(); // a)Declaraci�n de variable de instancia del tipo MiFecha en una l�nea independiente
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); //Fecha actual
		
		//b)	Instanciaci�n de un objeto del tipo MiFecha sobre la variable del punto anterior
		 fecha.setDia(calendar.get(Calendar.DATE));
		 fecha.setMes(calendar.get(Calendar.MONTH) + 1);
		 fecha.setAnio(calendar.get(Calendar.YEAR));
		
		while(opc != 4) { // d)	Crear men� para poder hacer cambio de d�a, mes o a�o.

			System.out.print("Fecha: ");
			System.out.println(fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAnio()); // c)	Impresi�n en consola del contenido de cada uno de los atributos, uno por l�nea
			System.out.println("Elija una opci�n");
			System.out.println("1: Cambiar d�a");
			System.out.println("2: Cambiar mes");
			System.out.println("3: Cambiar a�o");
			System.out.println("4: Salir");
			opc = scanner.nextInt();
			switch (opc) {
			case 1: System.out.print("Nuevo d�a: ");
					dia = scanner.nextInt();
					while(fecha.setDia(dia) == false) {
						System.out.println("D�a no v�lido");
						System.out.print("Ingresa otro d�a: ");
						dia = scanner.nextInt();
					}
					fecha.setDia(dia);
					break;
			case 2: System.out.print("Nuevo mes: ");
					mes = scanner.nextInt();
					while(fecha.setMes(mes) == false) {
						System.out.println("Mes no v�lido");
						System.out.print("Ingresa otro mes: ");
						mes = scanner.nextInt();
					}
					fecha.setMes(mes);
					break;
			case 3: System.out.print("Nuevo a�o: ");
					anio = scanner.nextInt();
					while(fecha.setAnio(anio) == false) {
						System.out.println("A�o no v�lido (revise la fecha)");
						System.out.print("Ingresa otro a�o: ");
						anio = scanner.nextInt();
					}
					fecha.setAnio(anio);
					break;
			case 4:
					break;
			default:
				throw new IllegalArgumentException("Opci�n inv�lida: " + opc);
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
	public boolean verifica(int anio) { // �A�o biciesto?
		if((anio % 4 == 0) && (anio % 100 != 0) || (anio% 400 == 0)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
}
