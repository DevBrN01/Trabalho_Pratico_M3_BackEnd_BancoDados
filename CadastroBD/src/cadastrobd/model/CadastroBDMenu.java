package cadastrobd.model;
import java.util.Scanner;
public class CadastroBDMenu {

    private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
    private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CadastroBDMenu().exibirMenu();
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Sistema de Cadastro ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Listar Todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        incluir();
                        break;
                    case 2:
                        alterar();
                        break;
                    case 3:
                        excluir();
                        break;
                    case 4:
                        buscarPeloId();
                        break;
                    case 5:
                        exibirTodos();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada. Tente novamente.");
                scanner.nextLine();
            }
        }
    }

    private void incluir() {
        System.out.print("Tipo (F/J): ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if ("F".equals(tipo)) {
            incluirPessoaFisica();
        } else if ("J".equals(tipo)) {
            incluirPessoaJuridica();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void alterar() {
        System.out.print("Tipo (F/J): ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if ("F".equals(tipo)) {
            alterarPessoaFisica();
        } else if ("J".equals(tipo)) {
            alterarPessoaJuridica();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void excluir() {
        System.out.print("Tipo (F/J): ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if ("F".equals(tipo)) {
            excluirPessoaFisica();
        } else if ("J".equals(tipo)) {
            excluirPessoaJuridica();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void buscarPeloId() {
        System.out.print("Tipo (F/J): ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if ("F".equals(tipo)) {
            buscarPessoaFisicaPeloId();
        } else if ("J".equals(tipo)) {
            buscarPessoaJuridicaPeloId();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void exibirTodos() {
        System.out.print("Tipo (F/J): ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if ("F".equals(tipo)) {
            listarPessoasFisicas();
        } else if ("J".equals(tipo)) {
            listarPessoasJuridicas();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    // Métodos para Pessoa Física

    private void incluirPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();

        System.out.print("ID: ");
        pf.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        pf.setNome(scanner.nextLine());

        System.out.print("Logradouro: ");
        pf.setLogradouro(scanner.nextLine());

        System.out.print("Cidade: ");
        pf.setCidade(scanner.nextLine());

        System.out.print("Estado: ");
        pf.setEstado(scanner.nextLine());

        System.out.print("Telefone: ");
        pf.setTelefone(scanner.nextLine());

        System.out.print("Email: ");
        pf.setEmail(scanner.nextLine());

        System.out.print("CPF: ");
        pf.setCpf(scanner.nextLine());

        pessoaFisicaDAO.incluir(pf);
        System.out.println("✅ Pessoa Física inserida com sucesso!");
    }

    private void alterarPessoaFisica() {
        System.out.print("Digite o ID da pessoa física: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PessoaFisica pf = pessoaFisicaDAO.getPessoa(id);
        if (pf == null) {
            System.out.println("❌ Pessoa Física não encontrada.");
            return;
        }

        System.out.println("Dados atuais:");
        pf.exibir();

        System.out.print("Novo nome: ");
        pf.setNome(scanner.nextLine());

        System.out.print("Novo logradouro: ");
        pf.setLogradouro(scanner.nextLine());

        System.out.print("Nova cidade: ");
        pf.setCidade(scanner.nextLine());

        System.out.print("Novo estado: ");
        pf.setEstado(scanner.nextLine());

        System.out.print("Novo telefone: ");
        pf.setTelefone(scanner.nextLine());

        System.out.print("Novo email: ");
        pf.setEmail(scanner.nextLine());

        System.out.print("Novo CPF: ");
        pf.setCpf(scanner.nextLine());

        pessoaFisicaDAO.alterar(pf);
        System.out.println("✅ Pessoa Física alterada com sucesso!");
    }

    private void excluirPessoaFisica() {
        System.out.print("Digite o ID da pessoa física a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pessoaFisicaDAO.excluir(id);
        System.out.println("✅ Pessoa Física excluída com sucesso!");
    }

    private void buscarPessoaFisicaPeloId() {
        System.out.print("Digite o ID da pessoa física: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PessoaFisica pf = pessoaFisicaDAO.getPessoa(id);
        if (pf != null) {
            pf.exibir();
        } else {
            System.out.println("❌ Pessoa Física não encontrada.");
        }
    }

    private void listarPessoasFisicas() {
        for (PessoaFisica p : pessoaFisicaDAO.getPessoas()) {
            p.exibir();
            System.out.println("--------------------");
        }
    }

    // Métodos para Pessoa Jurídica

    private void incluirPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();

        System.out.print("ID: ");
        pj.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        pj.setNome(scanner.nextLine());

        System.out.print("Logradouro: ");
        pj.setLogradouro(scanner.nextLine());

        System.out.print("Cidade: ");
        pj.setCidade(scanner.nextLine());

        System.out.print("Estado: ");
        pj.setEstado(scanner.nextLine());

        System.out.print("Telefone: ");
        pj.setTelefone(scanner.nextLine());

        System.out.print("Email: ");
        pj.setEmail(scanner.nextLine());

        System.out.print("CNPJ: ");
        pj.setCnpj(scanner.nextLine());

        pessoaJuridicaDAO.incluir(pj);
        System.out.println("✅ Pessoa Jurídica inserida com sucesso!");
    }

    private void alterarPessoaJuridica() {
        System.out.print("Digite o ID da pessoa jurídica: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PessoaJuridica pj = pessoaJuridicaDAO.getPessoa(id);
        if (pj == null) {
            System.out.println("❌ Pessoa Jurídica não encontrada.");
            return;
        }

        System.out.println("Dados atuais:");
        pj.exibir();

        System.out.print("Novo nome: ");
        pj.setNome(scanner.nextLine());

        System.out.print("Novo logradouro: ");
        pj.setLogradouro(scanner.nextLine());

        System.out.print("Nova cidade: ");
        pj.setCidade(scanner.nextLine());

        System.out.print("Novo estado: ");
        pj.setEstado(scanner.nextLine());

        System.out.print("Novo telefone: ");
        pj.setTelefone(scanner.nextLine());

        System.out.print("Novo email: ");
        pj.setEmail(scanner.nextLine());

        System.out.print("Novo CNPJ: ");
        pj.setCnpj(scanner.nextLine());

        pessoaJuridicaDAO.alterar(pj);
        System.out.println("✅ Pessoa Jurídica alterada com sucesso!");
    }

    private void excluirPessoaJuridica() {
        System.out.print("Digite o ID da pessoa jurídica a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        pessoaJuridicaDAO.excluir(id);
        System.out.println("✅ Pessoa Jurídica excluída com sucesso!");
    }

    private void buscarPessoaJuridicaPeloId() {
        System.out.print("Digite o ID da pessoa jurídica: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PessoaJuridica pj = pessoaJuridicaDAO.getPessoa(id);
        if (pj != null) {
            pj.exibir();
        } else {
            System.out.println("❌ Pessoa Jurídica não encontrada.");
        }
    }

    private void listarPessoasJuridicas() {
        for (PessoaJuridica p : pessoaJuridicaDAO.getPessoas()) {
            p.exibir();
            System.out.println("--------------------");
        }
    }
}