package contaBancaria;

import java.io.IOException;
import java.util.Scanner;

import contaBancaria.controller.ContaController;
import contaBancaria.model.Conta;
import contaBancaria.model.ContaCorrente;
import contaBancaria.model.ContaPoupanca;
import contaBancaria.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao, numero, agencia, tipo, aniversario;
		float saldo, limite;
		String titular;

		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João", 10000.0f, 100.0f);
		contas.cadastrar(cc1);
		contas.listarTodas();

//		ContaCorrente c1 = new ContaCorrente(1, 123, 1, "willian", 10000.0f,1000.0f);
//
//		c1.visualizar();
//		
//		c1.sacar(12000.0f);
//		
//		c1.depositar(5000.0f);
//
//		ContaPoupanca cp1 = new ContaPoupanca(2,123,2,"Victor",1000000.f,15);
//		
//		cp1.visualizar();

//		Conta c2 = new Conta();
//		
//		c2.visualizar();
//		
//		c2.setTitular("Gabriel");

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "******************************************************" + Cores.TEXT_RESET);
			System.out.println("                                                      ");
			System.out.println("                    BANCO DO BRAZIL                   ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("            1 - Criar Conta                           ");
			System.out.println("            2 - Listar todas as Contas                ");
			System.out.println("            3 - Buscar Conta por Numero               ");
			System.out.println("            4 - Atualizar Dados da Conta              ");
			System.out.println("            5 - Apagar Conta                          ");
			System.out.println("            6 - Sacar                                 ");
			System.out.println("            7 - Depositar                             ");
			System.out.println("            8 - Transferir valores entre Contas       ");
			System.out.println("            9 - Sair                                  ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      ");
			opcao = leia.nextInt();

			if (opcao == 7) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("\n Criar Conta");
				System.out.println("\nDigite o numero da Agencia: ");
				agencia = leia.nextInt();
				System.out.println("\nDigite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				System.out.println("\nDigite o tipo da conta (1-CC ou 2-CP: ");
				tipo = leia.nextInt();
				System.out.println("\nDigite o Saldo da conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
					}
				case 2 -> {
					System.out.println("\nDigite o dia do aniversário: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversario));
					}
				}
				System.out.println("\nDigite o limite: ");
				System.out.println("\nDigite o dia do aniversário: ");
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as contas");
				contas.listarTodas();
				break;
			case 3:
				System.out.println("\n Buscar Conta por numero");
				System.out.println("\n Digite o nuero da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);

				break;
			case 4:
				System.out.println("\n Atualizar dados da conta");

				break;
			case 5:
				System.out.println("\n Apagar Conta");
				System.out.println("\n Digite o numero a ser deletado:");
				numero = leia.nextInt();
				contas.deletar(numero);
				break;
			case 6:
				System.out.println("\n Transferir");

				break;
			default:
				System.out.println("\n Opção inválida");
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
