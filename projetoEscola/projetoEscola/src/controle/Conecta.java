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
import modelo.Aluno;
import modelo.Professor;

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
    
    //Método para desconectar do banco
    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! \n erro:"
                    + ex.getMessage());
        }
    }

    //Método para executar query SQL
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
    
    //Método para excluir um registro
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
    
    
    
    
    
    //MÉTODO PARA CADASTRAR Professor
    public int cadastraPessoa(Professor cadProfessor, String operacao, int codigo) {
        int linha = 0;
      
        if (operacao.equals("cadastrar")) {
            try {
                stm = conn.createStatement();
                linha = stm.executeUpdate("insert into tbprofessor "
                        + "(nomeprofessor, formacaoprofessor, emailprofessor) values "
                        + "('" + cadProfessor.getNome() + "','" 
                        + cadProfessor.getFormacao() + "',"
                        + cadProfessor.getEmail()+ ")"
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
                            "UPDATE tbprofessor SET nomeprofessor='" 
                            + cadProfessor.getNome() + "',formacaoprofessor='" 
                            + cadProfessor.getFormacao() +"',emailprofessor=" 
                            + cadProfessor.getEmail() 
                            + " WHERE codigoprofessor="+codigo);
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
    
     //MÉTODO PARA CADASTRAR Aluno
    public int cadastraPessoa(Aluno cadAluno, String operacao, int codigo) {
        int linha = 0;
        
        if (operacao.equals("cadastrar")) {
            try {
                stm = conn.createStatement();
                linha = stm.executeUpdate("insert into tbaluno "
                        + "(nomealuno, cidadealuno, enderecoaluno, emailaluno) values "
                        + "('" + cadAluno.getNome() + "','" 
                        + cadAluno.getCidade() + "',"
                        + cadAluno.getEndereco() + "," 
                        + cadAluno.getEmail() + ")"
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
                            "UPDATE tbaluno SET nomealuno='" 
                            + cadAluno.getNome() + "',cidadealuno='" 
                            + cadAluno.getCidade() + "',enderecoaluno=" 
                            + cadAluno.getEndereco()+ ",emailaluno=" 
                            + cadAluno.getEmail()
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
}
