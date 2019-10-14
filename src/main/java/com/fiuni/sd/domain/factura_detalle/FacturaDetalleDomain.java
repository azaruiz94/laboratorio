package com.fiuni.sd.domain.factura_detalle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura.FacturaDomain;
import com.fiuni.sd.domain.iva.IvaDomain;
import com.fiuni.sd.domain.solicitud_detalle.SolicitudDetalleDomain;

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
	
	public FacturaDomain getFactura() {
		return _factura;
	}
	
	public void setFactura(FacturaDomain factura) {
		this._factura = factura;
	}
	
	public IvaDomain getIva() {
		return _iva;
	}
	
	public void setIva(IvaDomain iva) {
		this._iva = iva;
	}
	
	public SolicitudDetalleDomain getSolicitudDetalle() {
		return _solicitudDetalle;
	}
	
	public void setSolicitudDetalle(SolicitudDetalleDomain solicitudDetalle) {
		_solicitudDetalle =solicitudDetalle;
	}

	@Column(name="factura")
	private FacturaDomain _factura;
	
	@Column(name="iva")
	private IvaDomain _iva;
	
	@Column(name="solicitudDetalle")
	private SolicitudDetalleDomain _solicitudDetalle;
	
	@Column(name="precioUnitario")
	private double _precioUnitario;
	
	@Column(name="subtotal")
	private double _subtotal;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
}
