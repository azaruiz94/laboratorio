package com.fiuni.sd.dto.factura_detalle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.dto.base.BaseDTO;

@XmlRootElement(name="facturaDetalle")
public class FacturaDetalleDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public double getPrecioUnitario() {
		return _precioUnitario;
	}
	
	public void setPrecioUnitario(double precioUnitario) {
		this._precioUnitario = precioUnitario;
	}
	
	@XmlElement
	public double getSubtotal() {
		return _subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this._subtotal = subtotal;
	}
	@XmlElement
	public Integer getFacturaId() {
		return _factura;
	}
	
	public void setFacturaId(Integer facturaId) {
		this._factura = facturaId;
	}
	
	@XmlElement
	public Integer getIvaId() {
		return _ivaId;
	}
	
	public void setIvaId(Integer ivaId) {
		this._ivaId = ivaId;
	}
	
	@XmlElement
	public Integer getSolicitudDetalleId() {
		return _solicitudDetalleId;
	}
	
	public void setSolicitudDetalleId(Integer solicitudDetalleId) {
		_solicitudDetalleId =solicitudDetalleId;
	}

	@XmlElement
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}


	private Integer _factura;
	
	private Integer _ivaId;
	
	private Integer _solicitudDetalleId;
	
	private double _precioUnitario;
	
	private double _subtotal;
	
	private Integer _id;
}
