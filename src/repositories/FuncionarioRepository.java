package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entities.Funcionario;

/*
 * classe para acessar e manipular arquivos ou banco de dados
 * para armazenamento dos registros de funcionario
 */

public class FuncionarioRepository {

	/*
	 * Método para gravar os dados
	 */
	
	public void exportarDados(Funcionario funcionario) {

		try {

			// criando um arquivo txt para gravação em modo "append"
			// append-> o arquivo nunca será substituido, mas sim terá o conteudo adiconado
			var fileWriter = new FileWriter("c:\\temp\\funcionarios.txt", true);// add no mesmo arquivo
			var printWriter = new PrintWriter(fileWriter);

			printWriter.write("\nId do funcionário...: " + funcionario.getId());
			printWriter.write("\nNome................: " + funcionario.getNome());
			printWriter.write("\nMatrícula...........: " + funcionario.getMatricula());
			printWriter.write("\nData de admissão....: " + funcionario.getDataAdmissao());
			printWriter.write("\nTipo de contratação.: " + funcionario.getTipoContratacao());
			printWriter.write("\n----------------------------------");
			
			printWriter.close();

			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

		} catch (Exception e) {
			System.out.println("\nFalha ao gravar o arquivo: " + e.getMessage());
		}

	}

}
