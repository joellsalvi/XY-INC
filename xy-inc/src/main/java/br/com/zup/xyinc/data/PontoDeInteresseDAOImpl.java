package br.com.zup.xyinc.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.xyinc.model.PontoDeInteresse;

@Repository
@Transactional
public class PontoDeInteresseDAOImpl implements PontoDeInteresseDAO {

	@Autowired
	private EntityManager em;
	
	public List<PontoDeInteresse> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PontoDeInteresse> criteria = cb.createQuery(PontoDeInteresse.class);
		Root<PontoDeInteresse> pontoDeInteresse = criteria.from(PontoDeInteresse.class);

		criteria.select(pontoDeInteresse).orderBy(cb.asc(pontoDeInteresse.get("nomePOI")));

		return em.createQuery(criteria).getResultList();
	}

	public PontoDeInteresse insert(PontoDeInteresse pontoDeInteresse) {
		em.persist(pontoDeInteresse);
		return findByNomePOI(pontoDeInteresse.getNomePOI());
	}

	public PontoDeInteresse findByNomePOI(String nomePOI) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PontoDeInteresse> criteria = cb.createQuery(PontoDeInteresse.class);
		Root<PontoDeInteresse> pontoDeInteresse = criteria.from(PontoDeInteresse.class);

		criteria.select(pontoDeInteresse).where(cb.equal(pontoDeInteresse.get("nomePOI"), nomePOI));

		return em.createQuery(criteria).getSingleResult();
	}

	public List<PontoDeInteresse> findByMargem(Long x, Long y, Long margem) {
		Query namedQuery = em.createNamedQuery("findByMargem");
		namedQuery.setParameter("x1", x - margem);
		namedQuery.setParameter("x2", x + margem);
		namedQuery.setParameter("y1", y - margem);
		namedQuery.setParameter("y2", y + margem);
		
		return namedQuery.getResultList();
	}

	@Override
	public PontoDeInteresse findById(Long id) {
		return em.find(PontoDeInteresse.class, id);
	}

}
