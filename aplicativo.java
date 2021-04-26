import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.*;

import static java.lang.Integer.*;

public class aplicativo {
	public static void main(String[] args) {
		reserva[] reservas = new reserva[10];
		int posicao = 0;
		int opcao;

		do {
			opcao = parseInt(showInputDialog(gerarMenu()));
			if (opcao < 1 || opcao > 6) {
				showMessageDialog(null, " !opção inválida! ");
			} else {
				switch (opcao) {
				case 1:
					cadastrar(reservas, posicao);
					posicao++;
					break;

				case 2:
					pesquisar(reservas, posicao);
					break;

				case 3:
					imprimir(reservas, posicao);

					break;
				
				case 4:
					listaespera(reservas,posicao);
					break;

				case 5:
					remover(reservas, posicao);
					break;

				case 6:

					break;

				}

			}

		}

		while (opcao != 6);

	}

	public static String gerarMenu() {
		String temp = "Restaurante SABOR SOFISTICADO\n";
		temp += "1. Reservar mesas\n";
		temp += "2. Pesquisar reserva\n";
		temp += "3. Imprimir reservas\n";
		temp += "4. Imprimir lista de espera\n";
		temp += "5. Cancelar reserva\n";
		temp += "6. Finalizar\n";
		return temp;
	}
       // não consegui criar uma seletor de pessoa física e juridica, quando fiz ficou com diversos erros
	
	public static void cadastrar(reserva[] reservas, int posicao) {
		reservas[posicao] = new reserva();

		reservas[posicao].nome = showInputDialog("Nome:");
		reservas[posicao].cpf = showInputDialog("CPF:");
		reservas[posicao].telefone = showInputDialog("Telefone:");
		reservas[posicao].pagamento = parseInt(showInputDialog("Como irá pagar? \n 1. À Vista \n 2. Parcelado"));
		if (posicao > 4) {
			showMessageDialog(null, "Você está na lista de espera!");
		}
	}

	public static int LocalizarCPF(reserva[] reservas, String cpf, int posicao) {
		int posicao_temp = -1;
		for (int i = 0; i < posicao; i++) {
			if (reservas[i].cpf.equalsIgnoreCase(cpf))
				;
			posicao_temp = i;
			break;
		}

		return posicao_temp;
	}

	public static void pesquisar(reserva[] reservas, int posicao) {
		String cpf = showInputDialog("Informe o CPF do cliente");
		int posicao_temp = LocalizarCPF(reservas, cpf, posicao);
		if (posicao_temp == -1) {
			showMessageDialog(null, cpf + " Não foi encontrado");
		} else {
			showMessageDialog(null, reservas[posicao_temp].GetDados());
			if (posicao_temp > 4) {

				showMessageDialog(null, "Você está na lista de espera!");
			}

		}
	}

	public static int remover(reserva[] reservas, int posicao) {
		String cpf = showInputDialog("Qual CPF será deletado?");
		int posicao_temp = LocalizarCPF(reservas, cpf, posicao);
		if (posicao_temp == -1) {
			showMessageDialog(null, cpf + " Inexistente");
		} else {
			for (int i = posicao_temp; i < posicao; i++) {
				reservas[i] = reservas[i + 1];
			}
			posicao--;

		}
		return posicao;
	}

	public static void imprimir(reserva[] reservas, int posicao) {
		String temp = "";
		for (int g = 0; g < 5; g++) {
			temp += reservas[g].GetDados() + "\n";

		}
		showMessageDialog(null, temp);

	}

	public static void listaespera(reserva[] reservas, int posicao) {
		String temp = "";
		for (int g = 0; g > 5; g++) {
			temp += reservas[g].GetDados() + "\n";

		}
		showMessageDialog(null, temp);
 }
}
