package com.fiuni.sd.domain.factura_detalle;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura.FacturaDomain;
import com.fiuni.sd.domain.iva.IvaDomain;
import com.fiuni.sd.domain.solicitud_detalle.SolicitudDetalleDomain;

public class FacturaDetalleDomain extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	private FacturaDomain _factura;
	private IvaDomain _iva;
	private SolicitudDetalleDomain _solicitudDetalle;
	private double _precioUnitario;
	private double _subtotal;
}
