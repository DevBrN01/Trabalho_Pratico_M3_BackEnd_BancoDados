package cadastrobd.model;

public class TestePessoas {
    public static void main(String[] args) {
        // Testando Pessoa Física
        System.out.println("=== Testando Pessoa Física ===");
        PessoaFisica pf = new PessoaFisica();

        pf.setId(1);
        pf.setNome("João Silva");
        pf.setLogradouro("Rua das Flores, 100");
        pf.setCidade("São Paulo");
        pf.setEstado("SP");
        pf.setTelefone("(11) 98765-4321");
        pf.setEmail("joao@email.com");
        pf.setCpf("123.456.789-00");

        pf.exibir(); // Exibe todos os dados + CPF

        System.out.println("\n=== Alterando Pessoa Física ===");
        pf.setNome("João da Silva Atualizado");
        pf.setCpf("987.654.321-00");
        pf.exibir();

        // Testando Pessoa Jurídica
        System.out.println("\n=== Testando Pessoa Jurídica ===");
        PessoaJuridica pj = new PessoaJuridica();

        pj.setId(2);
        pj.setNome("Empresa X Ltda");
        pj.setLogradouro("Av. Brasil, 500");
        pj.setCidade("Rio de Janeiro");
        pj.setEstado("RJ");
        pj.setTelefone("(21) 3333-4444");
        pj.setEmail("empresa@email.com");
        pj.setCnpj("12.345.678/0001-90");

        pj.exibir(); // Exibe todos os dados + CNPJ

        System.out.println("\n=== Alterando Pessoa Jurídica ===");
        pj.setNome("Nova Empresa S.A.");
        pj.setCnpj("98.765.432/0001-00");
        pj.exibir();

        System.out.println("\n✅ Todos os testes concluídos!");
    }
}