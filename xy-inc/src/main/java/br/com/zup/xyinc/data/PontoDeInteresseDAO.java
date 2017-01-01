package br.com.zup.xyinc.data;

import java.util.List;

import br.com.zup.xyinc.model.PontoDeInteresse;

public interface PontoDeInteresseDAO {

	List<PontoDeInteresse> findAll();
	
	PontoDeInteresse insert(PontoDeInteresse pontoDeInteresse);

	PontoDeInteresse findByNomePOI(String nomePOI);

	List<PontoDeInteresse> findByMargem(Long x, Long y, Long margem);

	PontoDeInteresse findById(Long id);
	
}
