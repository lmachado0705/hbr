package com.hbr.baseconhecimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hbr.baseconhecimento.model.Projeto;
import com.hbr.baseconhecimento.repository.ProjetoRepository;

@FacesConverter(forClass = Projeto.class)
public class ProjetoConverter implements Converter {

	@Inject
	private ProjetoRepository repositorio;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Projeto retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.repositorio.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Projeto projeto = ((Projeto) value);
			return projeto.getId() == null ? null : projeto.getId().toString();
		}
		return null;
	}

}
