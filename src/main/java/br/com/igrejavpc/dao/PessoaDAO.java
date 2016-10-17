package br.com.igrejavpc.dao;

import java.io.Serializable;

import br.com.igrejavpc.dao.hibernate.HibernateGenericDAO;
import br.com.igrejavpc.domain.Pessoa;

@SuppressWarnings("serial")
public class PessoaDAO extends HibernateGenericDAO<Pessoa, Long> implements Serializable {

}
