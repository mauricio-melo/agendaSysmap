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

			case "lider":
				return Perfil.LIDER;

			default:
				throw new IllegalArgumentException("Code [" + code
						+ "] not supported.");
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
