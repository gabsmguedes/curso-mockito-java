package br.com.alura.leilao.service;

import java.time.Clock;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Pagamento;

@Service
public class GeradorDePagamento {

//	@Autowired
	private PagamentoDao pagamentos;
	private Clock clock;

	@Autowired
	public GeradorDePagamento(PagamentoDao pagamentoDao, Clock clock) {
		this.clock = clock;
		this.pagamentos = pagamentoDao;
	}

	public void gerarPagamento(Lance lanceVencedor) {
		LocalDate vencimento = LocalDate.now(clock).plusDays(1);
		Pagamento pagamento = new Pagamento(lanceVencedor, vencimento);
		this.pagamentos.salvar(pagamento);
	}

}
