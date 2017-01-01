package br.com.zup.xyinc.business;

import java.util.List;

import br.com.zup.xyinc.model.PontoDeInteresse;

public interface PontoDeInteresseModel {

	List<PontoDeInteresse> filtrarPorMargem(List<PontoDeInteresse> pontosDeInteresse, Long margem, Long x, Long y);
	
}
