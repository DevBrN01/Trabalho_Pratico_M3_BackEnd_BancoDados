/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;
import java.util.List;
public class CadastroBDTeste {
    
    public static void main(String[] args) {
        
        PessoaFisicaDAO daoFisica = new PessoaFisicaDAO();
        PessoaJuridicaDAO daoJuridica = new PessoaJuridicaDAO();
   
        System.out.println("### Testando Pessoa Física ###");
        System.out.println("\n1. Criando e persistindo uma pessoa física...");
        PessoaFisica pf = new PessoaFisica();
        pf.setId(0); // 0 para novo cadastro
        pf.setNome("João da Silva");
        pf.setLogradouro("Rua das Flores, 100");
        pf.setCidade("São Paulo");
        pf.setEstado("SP");
        pf.setTelefone("(11) 98765-4321");
        pf.setEmail("joao@email.com");
        pf.setCpf("123.456.789-00");

        daoFisica.incluir(pf);
        System.out.println("✅ Pessoa Física inserida com sucesso!");
        System.out.println("\n2. Alterando os dados da pessoa física...");
        pf.setNome("João da Silva Atualizado");
        daoFisica.alterar(pf);
        System.out.println("✅ Pessoa Física atualizada com sucesso!");
        System.out.println("\n3. Listando todas as pessoas físicas:");
        List<PessoaFisica> pessoasFisicas = daoFisica.getPessoas();
        for (PessoaFisica p : pessoasFisicas) {
            p.exibir();
            System.out.println("--------------------");
        }
    
        System.out.println("\n4. Excluindo a pessoa física...");
        daoFisica.excluir(pf.getId());
        System.out.println("✅ Pessoa Física excluída com sucesso!");   
        System.out.println("\n\n### Testando Pessoa Jurídica ###");
        System.out.println("\n5. Criando e persistindo uma pessoa jurídica...");
        PessoaJuridica pj = new PessoaJuridica();
        pj.setId(0); // 0 para novo cadastro
        pj.setNome("Empresa X Ltda");
        pj.setLogradouro("Av. Brasil, 500");
        pj.setCidade("Rio de Janeiro");
        pj.setEstado("RJ");
        pj.setTelefone("(21) 3333-4444");
        pj.setEmail("empresa@email.com");
        pj.setCnpj("12.345.678/0001-90");

        daoJuridica.incluir(pj);
        System.out.println("✅ Pessoa Jurídica inserida com sucesso!");      
        System.out.println("\n6. Alterando os dados da pessoa jurídica...");
        pj.setNome("Empresa X Ltda - Atualizada");
        daoJuridica.alterar(pj);
        System.out.println("✅ Pessoa Jurídica atualizada com sucesso!");       
        System.out.println("\n7. Listando todas as pessoas jurídicas:");
        List<PessoaJuridica> pessoasJuridicas = daoJuridica.getPessoas();
        for (PessoaJuridica p : pessoasJuridicas) {
            p.exibir();
            System.out.println("--------------------");
        }
        
        System.out.println("\n8. Excluindo a pessoa jurídica...");
        daoJuridica.excluir(pj.getId());
        System.out.println("✅ Pessoa Jurídica excluída com sucesso!");
        System.out.println("\n✅ Todos os testes concluídos!");
    }
}