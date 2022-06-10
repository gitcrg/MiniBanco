package org.cursobbva.modulo4.proyecto.minibanco.implem;




import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ServicioCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ResultadoCambioImplem implements ResultadoCambio{
	
	TipoMoneda de;
	TipoMoneda a;
	Double monto;
	
	
	public ResultadoCambioImplem(TipoMoneda de, TipoMoneda a, Double monto) {
		super();
		this.de = de;
		this.a = a;
		this.monto = monto;
	}
	public ResultadoCambioImplem() {}

	@Override
	public Double getTasa() {
		// TODO Auto-generated method stub
				
		switch(de) {
		case USD: 
			return 200.0D;
		case EUR: 
			return 300.0D;
		}
		return null;
	}

	@Override
	public Double getResultado() {
		// TODO Auto-generated method stub
		return monto * getTasa();

	}
		

}
