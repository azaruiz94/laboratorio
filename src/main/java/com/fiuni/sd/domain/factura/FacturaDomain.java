package com.fiuni.sd.domain.factura;

import java.util.List;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura_detalle.FacturaDetalleDomain;
import com.fiuni.sd.domain.usuario.UsuarioDomain;

public class FacturaDomain extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public double getDescuento() {
		return _descuento;
	}
	
	public void setDescuento(double descuento) {
		this._descuento = descuento;
	}
	
	public double getTotal() {
		return _total;
	}
	
	public void setTotal(double total) {
		this._total = total;
	}

	public List<FacturaDetalleDomain> getFacturaDetalles() {
		return _facturaDetalles;
	}
	
	public void addFacturaDetalle(FacturaDetalleDomain facturaDetalle) {
		_facturaDetalles.add(facturaDetalle);
	}
	
	public void removeFacturaDetalle(FacturaDetalleDomain facturaDetalle) {
		_facturaDetalles.remove(facturaDetalle);
	}
	
	public int cantFacturaDetalles() {
		return _facturaDetalles.size();
	}

	public UsuarioDomain getUsuario(){
		return _usuario;
	}

	public void setUsuario(UsuarioDomain usuario){
		this._usuario = usuario;
	}

	private UsuarioDomain _usuario;
	private List<FacturaDetalleDomain> _facturaDetalles;
	private double _descuento;
	private double _total;

}
