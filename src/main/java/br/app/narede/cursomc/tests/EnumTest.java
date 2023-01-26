package br.app.narede.cursomc.tests;

public class EnumTest {

	public static void main(String[] args) {
		DiaSemana dia = DiaSemana.DOMINGO;
		
		for (DiaSemana value:DiaSemana.values())
		{
			System.out.println(value);
		}
	}

}
