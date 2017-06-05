package Models;

import java.util.Date;

public class Coche {

	private String matricula;
	private float PrecioTotal;
	private Date HoraEntrada;
	private Date HoraSalida;
	
	public Coche(String matricula, float precioTotal, Date horaEntrada, Date horaSalida) {
		super();
		this.matricula = matricula;
		PrecioTotal = precioTotal;
		HoraEntrada = horaEntrada;
		HoraSalida = horaSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public float getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		PrecioTotal = precioTotal;
	}

	public Date getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		HoraSalida = horaSalida;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", PrecioTotal=" + PrecioTotal + ", HoraEntrada=" + HoraEntrada
				+ ", HoraSalida=" + HoraSalida + "]";
	}
	
	
	
}
