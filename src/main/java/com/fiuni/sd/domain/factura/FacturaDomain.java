package com.fiuni.sd.domain.factura;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura_detalle.FacturaDetalleDomain;
import com.fiuni.sd.domain.credenciales.usuario.UsuarioDomain;

@Entity
@Table(name="factura")
public class FacturaDomain implements BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}
	
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

	@Column(name="usuario")
	private UsuarioDomain _usuario;
	
	@Column(name="facturaDetalle")
	private List<FacturaDetalleDomain> _facturaDetalles;
	
	@Column(name="descuento")
	private double _descuento;
	
	@Column(name="total")
	private double _total;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

}
