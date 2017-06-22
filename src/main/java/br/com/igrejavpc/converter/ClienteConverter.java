package br.com.igrejavpc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.igrejavpc.dao.ClienteDAO;
import br.com.igrejavpc.domain.Cliente;
import br.com.igrejavpc.util.jpa.CDIServiceLocator;





@FacesConverter (forClass = Cliente.class)
public class ClienteConverter implements Converter {
	
	//@Inject
			private ClienteDAO clienteDAO;
			
			public ClienteConverter() {
				clienteDAO = CDIServiceLocator.getBean(ClienteDAO.class);
			}
			
			@Override
			public Object getAsObject(FacesContext context, UIComponent component, String value) {
				Cliente retorno = null;
				
				if (value != null) {
					Long codigo = new Long(value);
					retorno = clienteDAO.buscarPeloCodigo(codigo);
				}
				
				return retorno;
			}

			@Override
			public String getAsString(FacesContext context, UIComponent component, Object value) {
				if (value != null) {
					Cliente produto = (Cliente) value;
					return produto.getCodigo() == null ? null : produto.getCodigo().toString();
				}
				
				return "";
			}
}