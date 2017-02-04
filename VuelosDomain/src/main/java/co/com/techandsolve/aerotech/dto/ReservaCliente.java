package co.com.techandsolve.aerotech.dto;

import java.util.Date;

import co.com.techandsolve.aerotech.models.Reserva;

public class ReservaCliente {
	
	private long id; 
	
	private Date fechaReserva;
	
	private String idVuelo;
	
	private Date fechaVuelo;
	
	private String origenVuelo;
	
	private String destinoVuelo;
	
	private double tarifaVuelo;
	
	private String estadoVuelo;
	
	private long idAvion;
	
	private String placaAvion;
	
	private String nombresUsuario;
	
	private String apellidosUsuario;
	
	private long idUsuario;
	
	public ReservaCliente(){
		
	}
	
	public ReservaCliente(Reserva reserva){
		
		setReservaCliente(reserva);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public String getOrigenVuelo() {
		return origenVuelo;
	}

	public void setOrigenVuelo(String origenVuelo) {
		this.origenVuelo = origenVuelo;
	}

	public String getDestinoVuelo() {
		return destinoVuelo;
	}

	public void setDestinoVuelo(String destinoVuelo) {
		this.destinoVuelo = destinoVuelo;
	}

	public double getTarifaVuelo() {
		return tarifaVuelo;
	}

	public void setTarifaVuelo(double tarifaVuelo) {
		this.tarifaVuelo = tarifaVuelo;
	}

	public String getEstadoVuelo() {
		return estadoVuelo;
	}

	public void setEstadoVuelo(String estadoVuelo) {
		this.estadoVuelo = estadoVuelo;
	}

	public long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}

	public String getPlacaAvion() {
		return placaAvion;
	}

	public void setPlacaAvion(String placaAvion) {
		this.placaAvion = placaAvion;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setReservaCliente(Reserva reserva){
		this.id=reserva.getId();
		this.fechaReserva= reserva.getFechaReserva();
		this.idVuelo=reserva.getIdVuelo().getId();
		this.fechaVuelo=reserva.getIdVuelo().getFecha();
		this.origenVuelo=reserva.getIdVuelo().getOrigen();
		this.destinoVuelo=reserva.getIdVuelo().getDestino();
		this.tarifaVuelo=reserva.getIdVuelo().getTarifa();
		this.estadoVuelo=reserva.getIdVuelo().getEstado();
		this.idAvion=reserva.getIdVuelo().getIdAvion().getId();
		this.placaAvion= reserva.getIdVuelo().getIdAvion().getPlaca();
		this.nombresUsuario=reserva.getIdUsuario().getNombres();
		this.apellidosUsuario=reserva.getIdUsuario().getApellidos();
		this.idUsuario=reserva.getIdUsuario().getId();
		
	}

}
