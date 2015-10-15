package com.hbr.baseconhecimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hbr.baseconhecimento.model.Tecnico;
import com.hbr.baseconhecimento.repository.TecnicoRepository;

@FacesConverter(forClass = Tecnico.class)
public class TecnicoConverter implements Converter {

	@Inject
	private TecnicoRepository repositorio;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Tecnico retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.repositorio.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Tecnico tecnico = ((Tecnico) value);
			return tecnico.getId() == null ? null : tecnico.getId().toString();
		}
		return null;
	}

}
