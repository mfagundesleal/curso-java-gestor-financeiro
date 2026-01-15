import java.util.Scanner;

public class Main {
    public static void cadastroInicial(Conta conta, Scanner ler){
        System.out.println("Olá! Seja bem vindo ao seu Gestor Financeiro!");
        System.out.println("Digite seu nome:");
        conta.setProprietario(ler.nextLine());

        System.out.println("Agora informe o tipo da conta, por gentileza (poupança ou corrente:");
        conta.setTipoConta(ler.nextLine());

        System.out.println("Caso tenha algum saldo inicial (quantia em conta) informe, senão digite 0:");
        conta.setSaldoInicial(ler.nextDouble());
        conta.setSaldo();
        System.out.println();
    }
    public static int menuPrincipal(Conta conta, String menu, Scanner ler){
        int opcaoEscolhida;
        System.out.printf("""
                ***********************
                Dados do proprietário da conta:
                - Nome: %s
                - Tipo de conta: %s
                - Saldo inicial: %.2f
                - Saldo atual: %.2f
                ***********************
                
                %s
                """, conta.getProprietario(),conta.getTipoConta(), conta.getSaldoInicial(), conta.getSaldo(), menu);
        opcaoEscolhida = ler.nextInt();
        return opcaoEscolhida;
    }
    public static String opcao1(Conta conta, String menu){
        return String.format("""
                Saldo atual da conta: R$ %.2f
                
                %s
                """,conta.getSaldo(),menu);
    }
    public static String opcao2(Conta conta, String menu, Scanner ler){
        double valor;
        System.out.println("Digite o valor a ser depositado:");
        valor = ler.nextDouble();

        conta.depositar(valor);

        return String.format("""
                Valor depositado com sucesso!
                
                Saldo atualizado: R$ %.2f
                
                %s
                """,conta.getSaldo(),menu);
    }
    public static String opcao3(Conta conta, String menu, Scanner ler){
        double valor;
        System.out.println("Digite o valor a ser transferido:");
        valor = ler.nextDouble();

        if(valor > conta.saldo){
            return String.format("""
                Saldo insuficiente para transferência! Tente novamente.
                
                %s
                """,menu);
        }

        conta.transferir(valor);

        return String.format("""
                Valor transferido com sucesso!
                
                Saldo atualizado: R$ %.2f
                
                %s
                """,conta.getSaldo(),menu);
    }
    public static void main(String[] args) {
        Conta conta = new Conta();
        Scanner ler = new Scanner(System.in);
        int opcaoEscolhida;
        String menu = """
                MENU DE OPERAÇÕES
                1. Consultar saldos
                2. Depositar valores
                3. Transferir valores
                4. Sair
                
                Digite a opção desejada:
                """;


        cadastroInicial(conta, ler);

        opcaoEscolhida = menuPrincipal(conta, menu, ler);

        while (opcaoEscolhida != 4){
            switch (opcaoEscolhida){
                case 1:
                    System.out.printf(opcao1(conta, menu));
                    opcaoEscolhida = ler.nextInt();
                    break;
                case 2:
                    System.out.printf(opcao2(conta, menu, ler));
                    opcaoEscolhida = ler.nextInt();
                    break;
                case 3:
                    System.out.printf(opcao3(conta, menu, ler));
                    opcaoEscolhida = ler.nextInt();
                    break;
                default:
                    System.out.print("Opção inválida! Tente novamente.");
                    opcaoEscolhida = menuPrincipal(conta, menu, ler);
                    break;
            }
        }
        System.out.println("Como você escolheu a opção 4, estamos encerrando o programa. Até a próxima! :)");
    }
}