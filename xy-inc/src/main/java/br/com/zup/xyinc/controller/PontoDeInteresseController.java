package br.com.zup.xyinc.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.zup.xyinc.business.PontoDeInteresseModel;
import br.com.zup.xyinc.data.PontoDeInteresseDAO;
import br.com.zup.xyinc.model.PontoDeInteresse;

@Controller
@RequestMapping("/")
public class PontoDeInteresseController {

	private static final Logger LOGGER = Logger.getLogger(PontoDeInteresse.class);

	@Autowired
	private PontoDeInteresseDAO dao;

	@Autowired
	private PontoDeInteresseModel model;

	/**
	 * Busca todos os registros de PontoDeInteresse
	 * 
	 * @return ResponseBody List<PontoDeInteresse>
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PontoDeInteresse> findAll() throws Exception {
		try {
			return dao.findAll();
		} catch (Exception e) {
			LOGGER.error("Erro ao executar findAll. " + e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Insere novo registro PontoDeInteresse via POST
	 * 
	 * @param nome
	 * @param x
	 * @param y
	 * @return ResponseBody PontoDeInteresse
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PontoDeInteresse insertPontoDeInteresse(
			@Valid @ModelAttribute("pontoDeInteresse") PontoDeInteresse pontoDeInteresse, BindingResult result)
			throws Exception {
		try {
			if(!result.hasErrors()) {
				dao.insert(pontoDeInteresse);
				return pontoDeInteresse;
			}
			return null;
		} catch (Exception e) {
			LOGGER.error("Erro ao executar insertPontoDeInteresse. " + e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Insere novo registro PontoDeInteresse via URL
	 * 
	 * @param nome
	 * @param x
	 * @param y
	 * @return ResponseBody PontoDeInteresse
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/insert/{nome}/{x}/{y}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PontoDeInteresse insertPontoDeInteresse(@PathVariable("nome") String nome,
			@PathVariable("x") Long x, @PathVariable("y") Long y) throws Exception {
		try {
			PontoDeInteresse pontoDeInteresse = new PontoDeInteresse();
			pontoDeInteresse.setNomePOI(nome);
			pontoDeInteresse.setCoordenadaX(x);
			pontoDeInteresse.setCoordenadaY(y);
			return dao.insert(pontoDeInteresse);
		} catch (Exception e) {
			LOGGER.error("Erro ao executar insertPontoDeInteresse. " + e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Busca todos os registros de PontoDeInteresse que estão dentro da margem
	 * passada de acordo com as coordenadas X e Y
	 * 
	 * @param x
	 * @param y
	 * @param margem
	 * @return ResponseBody List<PontoDeInteresse>
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/margem/{x}/{y}/{margem}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PontoDeInteresse> findByMargem(@PathVariable("x") Long x, @PathVariable("y") Long y,
			@PathVariable("margem") Long margem) throws Exception {
		try {
			return model.filtrarPorMargem(dao.findByMargem(x, y, margem), margem, x, y);
		} catch (Exception e) {
			LOGGER.error("Erro ao executar findByMargem. " + e.getMessage(), e);
			throw e;
		}
	}

}
