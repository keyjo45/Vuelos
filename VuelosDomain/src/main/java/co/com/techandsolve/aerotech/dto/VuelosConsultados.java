package co.com.techandsolve.aerotech.dto;

import java.util.Date;

import co.com.techandsolve.aerotech.models.Vuelo;

public class VuelosConsultados {

	private String id;
	private Date fecha;
	private String origen;
	private String destino;
	private double tarifa;
	private String estado;
	private long idAvion;
	private int cantidadSilla;
	private String placa;
	private String nombreAerolinea;

	public VuelosConsultados() {
		// constructor
	}

	public VuelosConsultados(Vuelo vuelo) {

		setVuelosConsultados(vuelo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}

	public int getCantidadSilla() {
		return cantidadSilla;
	}

	public void setCantidadSilla(int cantidadSilla) {
		this.cantidadSilla = cantidadSilla;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

	public void setVuelosConsultados(Vuelo vuelo) {

		this.id = vuelo.getId();
		this.fecha = vuelo.getFecha();
		this.origen = vuelo.getOrigen();
		this.destino = vuelo.getDestino();
		this.tarifa = vuelo.getTarifa();
		this.estado = vuelo.getEstado();
		this.idAvion = vuelo.getIdAvion().getId();
		this.cantidadSilla = vuelo.getIdAvion().getCantidadSilla();
		this.placa = vuelo.getIdAvion().getPlaca();
		this.nombreAerolinea = vuelo.getIdAvion().getIdAerolinea().getNombre();

	}
}
