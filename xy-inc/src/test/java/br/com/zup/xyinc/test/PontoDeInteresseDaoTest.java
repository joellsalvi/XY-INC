package br.com.zup.xyinc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.xyinc.data.PontoDeInteresseDAO;
import br.com.zup.xyinc.model.PontoDeInteresse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml",
                                   "classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class PontoDeInteresseDaoTest {
    @Autowired
    private PontoDeInteresseDAO pontoDeInteresseDao;

    @Test
    public void testRegister() {
        PontoDeInteresse pontoDeInteresse = new PontoDeInteresse();
        pontoDeInteresse.setNomePOI("teste");
        pontoDeInteresse.setCoordenadaX(12L);
        pontoDeInteresse.setCoordenadaY(21L);

        pontoDeInteresse = pontoDeInteresseDao.insert(pontoDeInteresse);
        assertNotNull(pontoDeInteresse.getId());
        return;
    }

    @Test
    public void testFindByMargem() {
    	
    	testRegister();
    	
        List<PontoDeInteresse> listPontoDeInteresse = pontoDeInteresseDao.findByMargem(10L, 20L, 3L);

        assertEquals("teste", listPontoDeInteresse.get(0).getNomePOI());
        assertEquals("12", listPontoDeInteresse.get(0).getCoordenadaX().toString());
        assertEquals("21", listPontoDeInteresse.get(0).getCoordenadaY().toString());
        return;
    }
}
