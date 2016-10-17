package br.com.igrejavpc.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.igrejavpc.dao.hibernate.HibernateGenericDAO;
import br.com.igrejavpc.domain.Lancamentos;
import br.com.igrejavpc.filter.LancamentosFilter;

@SuppressWarnings("serial")
public class LancamentosDAO extends HibernateGenericDAO<Lancamentos, Long> implements Serializable{
	
	@Inject
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Lancamentos> filtrar(LancamentosFilter filtro){
		
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Lancamentos.class);
		
		if(filtro.getDataInicial() != null && filtro.getDataFinal() != null){
			
			criteria.add(Restrictions.ge("data", filtro.getDataInicial()))
					.add(Restrictions.le("data", filtro.getDataFinal()));
				
			
		}
		
		return criteria.setCacheable(true).list() ;
	}
	
	public BigDecimal somarTotal(LancamentosFilter sfiltro){
		
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Lancamentos.class);
		
		if(sfiltro.getDataInicial() == null && sfiltro.getDataFinal() == null){
			
			criteria.setProjection(Projections.sum("valor"));
			
			return (BigDecimal) criteria.uniqueResult();
			
		}
		
		criteria.setProjection(Projections.sum("valor"))
				.add(Restrictions.ge("data", sfiltro.getDataInicial()))
				.add(Restrictions.le("data", sfiltro.getDataFinal()));
		
		return (BigDecimal)criteria.uniqueResult();
		
	}

}
