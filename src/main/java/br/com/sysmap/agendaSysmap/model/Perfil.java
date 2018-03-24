package br.com.sysmap.agendaSysmap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Perfil {
	DESENVOLVEDOR,
	LIDER;

	@Getter
	private String code;

	@JsonCreator
	public static Perfil fromCode(String code) {
		switch (code) {
			case "desenvolvedor":
				return Perfil.DESENVOLVEDOR;

			case "DESENVOLVEDOR":
				return Perfil.DESENVOLVEDOR;

			case "lider":
				return Perfil.LIDER;

			case "LIDER":
				return Perfil.LIDER;

			default:
				throw new IllegalArgumentException("Perfil [" + code
						+ "] não suportado");
		}
	}

	@JsonValue
	public String toValue() {
		switch (this) {
			case DESENVOLVEDOR:
				return "desenvolvedor";
			case LIDER:
				return "lider";
			default:
				throw new IllegalArgumentException("Code [" + this.getCode()
						+ "] not supported.");
		}

	}
}
