package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoNegativoException;

public class RegistraValorHoraCheiaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorHoraCheia0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoHoraCheia(0.00));
		assertEquals(0.00, estacionamentoBuilder.getDescontoHoraCheia());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorHoraCheia10() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoHoraCheia(10.00));
		assertEquals(10.00, estacionamentoBuilder.getDescontoHoraCheia());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorHoraCheia1025() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoHoraCheia(10.25));
		assertEquals(10.25, estacionamentoBuilder.getDescontoHoraCheia());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorHoraCheia9999() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoHoraCheia(99.99));
		assertEquals(99.99, estacionamentoBuilder.getDescontoHoraCheia());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorHoraCheiaInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorHoraCheiaInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setDescontoHoraCheia(-0.01));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testValorHoraCheiaInvalidoMaior100() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorHoraCheiaInvalidoMaior100Exception.class,
				() -> estacionamentoBuilder.setDescontoHoraCheia(100.01));
	}

}
