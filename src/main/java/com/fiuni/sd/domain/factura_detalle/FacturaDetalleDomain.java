package com.fiuni.sd.domain.factura_detalle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura.FacturaDomain;

@Entity
@Table(name="facturaDetalle")
public class FacturaDetalleDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		this._id = id;
	}
	
	public double getPrecioUnitario() {
		return _precioUnitario;
	}
	
	public void setPrecioUnitario(double precioUnitario) {
		this._precioUnitario = precioUnitario;
	}
	
	public double getSubtotal() {
		return _subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this._subtotal = subtotal;
	}
	
	public FacturaDomain getFacturaId() {
		return _factura;
	}
	
	public void setFacturaId(FacturaDomain facturaId) {
		this._factura = facturaId;
	}
	
	public Integer getIvaId() {
		return _ivaId;
	}
	
	public void setIvaId(Integer ivaId) {
		this._ivaId = ivaId;
	}
	
	public Integer getSolicitudDetalleId() {
		return _solicitudDetalleId;
	}
	
	public void setSolicitudDetalleId(Integer solicitudDetalleId) {
		_solicitudDetalleId =solicitudDetalleId;
	}


	@ManyToOne
	private FacturaDomain _factura;
	
	@Column(name="iva")
	private Integer _ivaId;
	
	@Column(name="solicitudDetalle")
	private Integer _solicitudDetalleId;
	
	@Column(name="precioUnitario")
	private double _precioUnitario;
	
	@Column(name="subtotal")
	private double _subtotal;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
}
