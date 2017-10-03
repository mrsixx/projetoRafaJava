/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Pessoa;

/**
 *
 * @author RalphChaos
 */
public class Conecta {

    //RESPONSÁVEL POR PREPARAR E REALIZAR
    //PESQUISAS E INSERÇÕES NO BANCO DE DADOS
    public Statement stm;

    //RESPONSÁVEL POR ARMAZENAR O RESULTADO DE 
    //UMA PESQUISA PASSADA PARA O STATEMENT
    public ResultSet rs;

    //REALIZA A CONEXÃO COM O BANCO DE DADOS
    public Connection conn = null;

    String connectionUrl = "jdbc:mysql://localhost:3306/bdnoiteaulaum";
    String usuario = "root";
    String senha = "";

    public Conecta() {

    }

    //MÉTODO DE CONEXÃO COM O BANCO DE DADOS
    public Connection conectandoBanco() {

        try {
            conn = DriverManager.getConnection(connectionUrl, usuario, senha);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n"
                    + ex.getMessage()
                    + ex.getStackTrace());
        }
        return conn;
    }

    //MÉTODO PARA CADASTRAR PESSOAS
    public int cadastraPessoas(Pessoa cadPessoa, String operacao, int codigo) {
        int linha = 0;
        if (operacao.equals("cadastrar")) {
            try {
                stm = conn.createStatement();
                linha = stm.executeUpdate("insert into tbaulaum "
                        + "(nome, cidade, salario, idade) values "
                        + "('" + cadPessoa.getNome() + "','" 
                        + cadPessoa.getCidade() + "',"
                        + cadPessoa.getSalario() + "," 
                        + cadPessoa.getIdade() + ")"
                );
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            int escolha = (JOptionPane.showConfirmDialog
                    (null, "Deseja realmente editar os dados?",
                    "Editar", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE));
            if (escolha == 0) {
               try {
                    stm = conn.createStatement();
                    linha = stm.executeUpdate(
                            "UPDATE tbaulaum SET nome='" 
                            + cadPessoa.getNome() + "',cidade='" 
                            + cadPessoa.getCidade() + "',salario=" 
                            + cadPessoa.getSalario() + ",idade=" 
                            + cadPessoa.getIdade() 
                            + " WHERE codigo="+codigo);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog
                    (null, ex.getMessage());
                }
            }else{
                linha = 0; //VALOR QUALQUER SÓ PARA CANCELAR JÁ QUE NO CADASTRAR O CORRETO NO MÉTODO cadastrarBanco DAS OUTRAS CLASSES
            }
        }
        return linha;
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! \n erro:"
                    + ex.getMessage());
        }
    }


    public void executaSql(String sql) {

        try {
            Statement stm
                    = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL!\n Erro:" + ex.getMessage());
        }
    }

    public void excluir(int codigo) {
        try {
            stm = conn.createStatement();
            stm.execute("DELETE FROM tbaulaum WHERE codigo ="
                    + codigo);
            JOptionPane.showMessageDialog(null, "Registro excluído!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n Erro:"
                    + ex.getMessage());
            ex.getStackTrace();
        }
    }
}
