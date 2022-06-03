package org.cursobbva.modulo4.minibanco.implem;




import org.cursobbva.modulo4.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.minibanco.interf.ServicioCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ResultadoCambioImplem implements ResultadoCambio{
	
	TipoMoneda de;
	TipoMoneda a;
	Float monto;
	
	
	public ResultadoCambioImplem(TipoMoneda de, TipoMoneda a, Float monto) {
		super();
		this.de = de;
		this.a = a;
		this.monto = monto;
	}
	public ResultadoCambioImplem() {}

	@Override
	public Float getTasa() {
		// TODO Auto-generated method stub
				
		switch(de) {
		case USD: 
			return 200.0F;
		case EUR: 
			return 300.0F;
		}
		return null;
	}

	@Override
	public Float getResultado() {
		// TODO Auto-generated method stub
		return monto * getTasa();

	}
		

}
