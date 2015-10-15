package com.hbr.baseconhecimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.hbr.baseconhecimento.model.BaseConhecimento;
import com.hbr.baseconhecimento.repository.BaseConhecimentoRepository;

@FacesConverter(forClass = BaseConhecimento.class)
public class BaseConhecimentoConverter implements Converter {
	@Inject
	private BaseConhecimentoRepository repositorio;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		BaseConhecimento retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.repositorio.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			BaseConhecimento baseConhecimento = ((BaseConhecimento) value);
			return baseConhecimento.getId() == null ? null : baseConhecimento.getId().toString();
		}
		return null;
	}

}
