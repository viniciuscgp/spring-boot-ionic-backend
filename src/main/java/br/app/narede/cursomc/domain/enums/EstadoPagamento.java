package br.app.narede.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1),
	QUITADO(2),
	CANCELADO(3);

	private Integer cod;

	EstadoPagamento(int i) {
		cod = i;
	}

	public Integer getCod() {
		return cod;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (x.getCod() == cod) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
