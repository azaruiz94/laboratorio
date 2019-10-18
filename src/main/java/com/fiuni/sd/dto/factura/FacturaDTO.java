package com.fiuni.sd.dto.factura;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name="factura")
public class FacturaDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public double getDescuento() {
		return _descuento;
	}
	
	public void setDescuento(double descuento) {
		this._descuento = descuento;
	}
	
	@XmlElement
	public double getTotal() {
		return _total;
	}
	
	public void setTotal(double total) {
		this._total = total;
	}

	@XmlElement
	public Set<Integer> getFacturaDetalles() {
		return _facturaDetalles;
	}
	
	public void addFacturaDetalleId(Integer facturaDetalleId) {
		_facturaDetalles.add(facturaDetalleId);
	}
	
	public void removeFacturaDetalleId(Integer facturaDetalleId) {
		_facturaDetalles.remove(facturaDetalleId);
	}
	
	public int cantFacturaDetalleId() {
		return _facturaDetalles.size();
	}

	@XmlElement
	public Integer getUsuarioId(){
		return _usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this._usuarioId = usuarioId;
	}

	@XmlElement
	public Integer get_nroFactura() {
		return _nroFactura;
	}

	public void set_nroFactura(Integer nroFactura) {
		this._nroFactura = nroFactura;
	}

	private Integer _usuarioId;
	
	private Set<Integer> _facturaDetalles = new HashSet<>();
	
	private double _descuento;
	
	private double _total;

	private Integer _nroFactura;

}
