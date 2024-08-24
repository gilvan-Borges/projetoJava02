package principal;

import controllers.FuncionarioController;

public class Main {

	public static void main(String[] args) {
		
		//criando um objeto da classe controle
		var funcionarioControlller = new FuncionarioController();
		
		//executando o cadastro do funcionário
		funcionarioControlller.cadastrarFuncionario();

	}
}