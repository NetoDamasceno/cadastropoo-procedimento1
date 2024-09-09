package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroPOO {

    public static void main(String[] args) {
        try {
            // 1. Instanciar repositório de pessoas físicas (repo1)
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            // 2. Adicionar duas pessoas físicas
            repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));

            // 3. Invocar método de persistência em repo1
            String arquivoPessoaFisica = "pessoas_fisicas.bin";
            repo1.persistir(arquivoPessoaFisica);
            System.out.println("Dados de Pessoa Fisica Armazenados.");

            // 4. Instanciar outro repositório de pessoas físicas (repo2)
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            // 5. Invocar método de recuperação em repo2
            repo2.recuperar(arquivoPessoaFisica);
            System.out.println("Dados de Pessoa Fisica Recuperados.");

            // 6. Exibir dados de todas as pessoas físicas recuperadas
            ArrayList<PessoaFisica> pessoasFisicas = repo2.obterTodos();
            for (PessoaFisica pf : pessoasFisicas) {
                System.out.println("Id: " + pf.getId());
                System.out.println("Nome: " + pf.getNome());
                System.out.println("CPF: " + pf.getCpf());
                System.out.println("Idade: " + pf.getIdade());
            }

            // 7. Instanciar repositório de pessoas jurídicas (repo3)
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            // 8. Adicionar duas pessoas jurídicas
            repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
            repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));

            // 9. Invocar método de persistência em repo3
            String arquivoPessoaJuridica = "pessoas_juridicas.bin";
            repo3.persistir(arquivoPessoaJuridica);
            System.out.println("Dados de Pessoa Juridica Armazenados.");

            // 10. Instanciar outro repositório de pessoas jurídicas (repo4)
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            // 11. Invocar método de recuperação em repo4
            repo4.recuperar(arquivoPessoaJuridica);
            System.out.println("Dados de Pessoa Juridica Recuperados.");

            // 12. Exibir dados de todas as pessoas jurídicas recuperadas
            ArrayList<PessoaJuridica> pessoasJuridicas = repo4.obterTodos();
            for (PessoaJuridica pj : pessoasJuridicas) {
                System.out.println("Id: " + pj.getId());
                System.out.println("Nome: " + pj.getNome());
                System.out.println("CNPJ: " + pj.getCnpj());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao persistir ou recuperar dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}