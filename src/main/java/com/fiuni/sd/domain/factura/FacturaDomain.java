package com.fiuni.sd.domain.factura;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.domain.base.BaseDomain;
import com.fiuni.sd.domain.factura_detalle.FacturaDetalleDomain;

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


	public Set<FacturaDetalleDomain> getFacturaDetalles() {
		return _facturaDetalles;
	}
	
	public void addFacturaDetalleId(FacturaDetalleDomain facturaDetalleId) {
		_facturaDetalles.add(facturaDetalleId);
	}
	
	public void removeFacturaDetalleId(FacturaDetalleDomain facturaDetalleId) {
		_facturaDetalles.remove(facturaDetalleId);
	}
	
	public int cantFacturaDetalleId() {
		return _facturaDetalles.size();
	}

	public Integer getUsuarioId(){
		return _usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this._usuarioId = usuarioId;
	}

	public Integer get_nroFactura() {
		return _nroFactura;
	}

	public void set_nroFactura(Integer nroFactura) {
		this._nroFactura = nroFactura;
	}

	@Column(name="usuario")
	private Integer _usuarioId;
	

	@OneToMany(mappedBy = "_factura")
	private Set<FacturaDetalleDomain> _facturaDetalles = new HashSet<>();
	
	@Column(name="descuento")
	private double _descuento;
	
	@Column(name="total")
	private double _total;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nroFactura", nullable = false, unique = true)
	private Integer _nroFactura;

}
