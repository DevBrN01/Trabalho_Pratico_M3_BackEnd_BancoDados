/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    
    public PessoaJuridica() {
        super();
        this.cnpj = "";
    }

    
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }

    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

   
    @Override
    public void exibir() {
        super.exibir(); // Chama o exibir() da classe Pessoa
        System.out.println("CNPJ: " + cnpj);
    }
}