package modelo;

public class Serie {
	
	 private String fecha;
     private double valor;
     
	public Serie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Serie(String fecha, double valor) {
		super();
		this.fecha = fecha;
		this.valor = valor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Serie \nFecha: " + fecha + "\nValor: " + valor + "\n";
	}
     
     

}
