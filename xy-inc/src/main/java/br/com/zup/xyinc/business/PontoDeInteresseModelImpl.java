package br.com.zup.xyinc.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.zup.xyinc.model.PontoDeInteresse;

@Component
public class PontoDeInteresseModelImpl implements PontoDeInteresseModel {

	@Override
	public List<PontoDeInteresse> filtrarPorMargem(List<PontoDeInteresse> pontosDeInteresse, Long margem, Long x,
			Long y) {
		List<PontoDeInteresse> listPontoDeInteresse = new ArrayList<PontoDeInteresse>();
		
		for (PontoDeInteresse poi : pontosDeInteresse) {
			Long distanciaX = Math.abs(poi.getCoordenadaX() - x);
			Long distanciaY = Math.abs(poi.getCoordenadaY() - y);
			if(distanciaX + distanciaY <= margem) {
				listPontoDeInteresse.add(poi);
			}
		}

		return listPontoDeInteresse;
	}
	
}
