package controllers;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcionario;
import enums.TipoContratacao;
import repositories.FuncionarioRepository;

/*
 * Classe de controle para realizar a entrada 
 * dos dados do funcionario informado pelo usuário
 */

public class FuncionarioController {

	/*
	 * Método para capturar os dados do funcionario e realizar o seu cadastro no
	 * sistema
	 */

	public void cadastrarFuncionario() {

		// criando um objeto (variavel de instancia) para funcionario
		var funcionario = new Funcionario();

		try {

			funcionario.setId(UUID.randomUUID());
			funcionario.setNome(JOptionPane.showInputDialog("Nome do funcionário:"));
			funcionario.setMatricula(JOptionPane.showInputDialog("Matrícula do funcionário:"));
			funcionario.setDataAdmissao(
					new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de admissão:")));

			var opcao = JOptionPane.showInputDialog("Informe (1)Estágio, (2)CLT ou (3)Tercerizado:");

			switch (opcao) {

				case "1":
					funcionario.setTipoContratacao(TipoContratacao.ESTAGIO);
					break;
				case "2":
					funcionario.setTipoContratacao(TipoContratacao.CLT);
					break;
				case "3":
					funcionario.setTipoContratacao(TipoContratacao.TERCERIZADO);
					break;

			}
			
			var funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.exportarDados(funcionario);
		
		} catch (Exception e) {

			System.out.println("\nFalha ao capturar os dados: " + e.getMessage());
		}

	}
}
