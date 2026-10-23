

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestsMain {

    private static void mostrarProduto(ProdutoDAO produtoDAO) {
        List<Produto> todosProdutos = produtoDAO.listarTodos();
        if(todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto encontrado");
        } else {
            System.out.println("LISTA DE PRODUTOS:");
            for(Produto p : todosProdutos) {
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Quantidade: " + p.getQuantidade());
                System.out.println("Preço: R$" + p.getPreco());
            }
        }
    }

    public static void main(String[] args) {
        ConexaoDB conexaoDB = new ConexaoDB();
        LerCredenciais credenciais = new LerCredenciais();

        try (Connection conexao = conexaoDB.conectar(credenciais.retornaUsuario(), credenciais.retornaSenha())) {
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

            // Deve Mostrar Produtos
            mostrarProduto(produtoDAO);

            // Deve Inserir Produtos
            Produto novoProduto1 = new Produto("Notebook", 10, new BigDecimal("1999.90"), "Disponivel");
            Produto novoProduto2 = new Produto("Celular", 5, new BigDecimal("1499.90"), "Disponivel");
            Produto novoProduto3 = new Produto("Perfume", 0, new BigDecimal("159.90"), "Indisponivel");
            
            produtoDAO.inserir(novoProduto1);
            produtoDAO.inserir(novoProduto2);
            produtoDAO.inserir(novoProduto3);

            // Deve Mostrar Produtos após inserção
            mostrarProduto(produtoDAO);

            // Deve Consultar por ID
            Produto produtoConsultado = produtoDAO.consultarPorId(1);
            if(produtoConsultado != null) {
                System.out.println("Produto Consultado: " + produtoConsultado.getNome());
                
                // Deve alterar nome do produto consultado
                produtoConsultado.setNome("Notebook Positivo");

                produtoDAO.atualizar(produtoConsultado);
                System.out.println("Produto ALTERADO COM SUCESSO!");
            } else {
                System.out.println("Produto não encontrado");
            }

            // Deve mostrar produtos após atualização
            mostrarProduto(produtoDAO);

            // Deve excluir um produto
            produtoDAO.excluirPorId(3);

            // Deve mostrar produtos após atualização
            mostrarProduto(produtoDAO);

            // Deve excluir todos os produtos
            produtoDAO.excluirTodos();

            // Deve mostrar produtos após atualização
            mostrarProduto(produtoDAO);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*
javac -cp "lib/mysql-connector-j-9.4.0.jar;." *.java
java -cp "lib/mysql-connector-j-9.4.0.jar;." TestsMain.java
*/