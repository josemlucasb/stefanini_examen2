package com.stefanini.service;

import java.util.List;

import com.stefanini.domain.OrdenPago;
import com.stefanini.rest.dto.OrdenPagoDTO;

public interface OrdenPagoService {

	OrdenPago create(OrdenPagoDTO ordenPagoDTO);

	OrdenPago update(OrdenPagoDTO ordenPagoDTO);

	boolean deleteById(Long idOrdenPago);

	List<OrdenPago> getOrdenesPago();

	OrdenPago getOrdenPagoById(Long idOrdenPago);

	List<OrdenPago> getOrdenesByFiltros(Long idSucursal, String moneda);

}
