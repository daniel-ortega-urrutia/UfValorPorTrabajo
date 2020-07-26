package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Uf {
	private String version;
	private String autor;
	private String codigo;
	private String nombre;
	private String unidad_medida;
	private ArrayList<Serie> serie;
	public static Scanner sc = new Scanner(System.in);// ESCANER STATIC PARA PODER OCUPARLO EN LA CLASE

//	CONSTRUCTOR SIN PARAMTEROS
	public Uf() {
		super();

	}

//	CONSTRUCTOR CON PARAMETROS
	public Uf(String version, String autor, String codigo, String nombre, String unidad_medida,
			ArrayList<Serie> serie) {
		super();
		this.version = version;
		this.autor = autor;
		this.codigo = codigo;
		this.nombre = nombre;
		this.unidad_medida = unidad_medida;
		this.serie = serie;
	}

//	GETTERS AND SETTERS
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public ArrayList<Serie> getSerie() {
		return serie;
	}

	public void setSerie(ArrayList<Serie> serie) {
		this.serie = serie;
	}

//	METODO TO STRING 
	@Override
	public String toString() {
		return "Uf \nVersion: " + version + "\nAutor: " + autor + "\nCodigo: " + codigo + "\nNombre: " + nombre
				+ "\nUnidad medida: " + unidad_medida + "\nSerie=" + serie + "\n";
	}

//	METODO QUE RETORNA EL VALOR DE LA UF EN EL DIA ACTUAL
	public Uf obtenerUf() {
		Uf ufRetornada = null;// variable de tipo uf inicializada en null
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://mindicador.cl/api/").path("uf");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaUf = invocationBuilder.get();
		Uf uf = respuestaUf.readEntity(new GenericType<Uf>() {
		});
		ufRetornada = uf;// le asignamos los datos retornados
		return ufRetornada;// retornamos la uf
	}


//	METODO QUE FIJA EL VALOR DE LA UF
	public double fijarValorUfHora() {
		
		double valorFinal = 0;
		Uf uf = new Uf();
		Uf valorUf = uf.obtenerUf();// METODO QUE NOS RETORNA LA UF ACTUAL, SE LO ASIGNAMOS A UNA VARIABLE DE TIPO UF
		System.out.print("Cuantas UF desea cobrar por hora: ");
		double valorUfHora = sc.nextDouble();// VALOR QUE INGRESAMOS POR CONSOLA
		valorFinal = valorUf.getSerie().get(0).getValor() * valorUfHora;// OBTENEMOS EL VALOR ACTUAL MULTIPLICADO POR EL
																		// VALOR QUE LE DAREMOS
		System.out.printf("\nSu valor hora quedo en: %.0f", valorFinal);
		System.out.println(" ");
		return valorFinal;// NOS RETORNA EL VALOR QUE LE FIJAMOS A LA UF
		
	}

//	METODO QUE RETORNA EL VALOR DEL TOTAL DEL DIA, SE FIJA EL VALOR DE LA HORA Y EN BASE A LAS HORAS TRABAJADAS, DA EL VALOR DIA
	public double fijarValorDia() {
		
		double horasDia=0;
		System.out.print("Cuantas horas trabajara por dia: ");
		horasDia = sc.nextDouble();// VARIABLE QUE GUARDA CUANTAS HORAS TRABAJARA EN EL DIA
//		SE ENVIA MENSAJE, RETORNA EL TOTAL, ESTO CONTEMPLA LA HORAS DEL DIA POR EL VALOR HORA FIJADO EN UF
		double total=horasDia * this.fijarValorUfHora();
		System.out.printf("\nSu valor del dia es: %.0f", total);
		System.out.println(" ");
		return total;
		
	}
	
//	METODO QUE ME RETORNA EL TOTAL EN BASE A X DIAS TRABAJADOS
	public double fijarTotalDias() {

		double totalDiasMes = 0;
		Uf uf = new Uf();
		System.out.print("Cuantos dias trabajara este mes: ");
		totalDiasMes = sc.nextDouble();
		double total = this.fijarValorDia() * totalDiasMes;
		System.out.printf("\nSu total del mes es: %.0f", total);
		System.out.println(" ");
		return totalDiasMes;

	}
	
//	METODO QUE RETORNA EL VALOR ACTUAL DE LA UF
	public Uf valorUfActual() {
		
		Uf uf= new Uf();
		Uf ufDia= uf.obtenerUf();
		System.out.printf("El valor de la uf actual es: %.0f",ufDia.getSerie().get(0).getValor());
		System.out.println(" ");
		return ufDia;
		
	}
}
