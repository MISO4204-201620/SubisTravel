package co.com.tauLabs.dto;

public class ReportBusquedaDTO {

	private String nombreItem;
	private Long idItem;
	private Long cantidad;
	private String palabrasBuscadas;
	
	
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getPalabrasBuscadas() {
		return palabrasBuscadas;
	}
	public void setPalabrasBuscadas(String palabrasBuscadas) {
		this.palabrasBuscadas = palabrasBuscadas;
	}
}
