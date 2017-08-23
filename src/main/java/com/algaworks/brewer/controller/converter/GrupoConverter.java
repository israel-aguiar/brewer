package com.algaworks.brewer.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.algaworks.brewer.model.Grupo;

public class GrupoConverter implements Converter<String, Grupo> {
	

	@Override
	public Grupo convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Grupo cidade = new Grupo();
			cidade.setCodigo(Long.valueOf(codigo));
			return cidade;
		}
		
		return null;
	}

}
