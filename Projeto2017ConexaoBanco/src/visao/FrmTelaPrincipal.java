/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Conecta;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author RalphChaos
 */
public class FrmTelaPrincipal extends javax.swing.JFrame {

    Conecta objConecta = new Conecta();
    Pessoa cadPessoa = new Pessoa();
    int codigo;
    String sql = "select * from tbaulaum";
    String operacao;

    /**
     * Creates new form FrmTelaPrincipal
     */
    public FrmTelaPrincipal() {
        objConecta.conectandoBanco();
        initComponents();
        setLocationRelativeTo(this);
        objConecta.executaSql(sql);

       
            //MUDAR A APARÊNCIA DO JFRAME
            /*
            OPÇÕES DISPONÍVEIS:
            com.sun.java.swing.plaf.gtk.GTKLookAndFeel - padrão GTK+
            javax.swing.plaf.metal.MetalLookAndFeel - Metal
            com.sun.java.swing.plaf.windows.WindowsLookAndFeel - Windows
            com.sun.java.swing.plaf.motif.MotifLookAndFeel - Motif
            javax.swing.plaf.mac.MacLookAndFeel - Mac
            
            */
        try {    
            UIManager.setLookAndFeel
                ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            //FIM DO TRATAMENTO DE MUDANÇA DE APARÊNCIA
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

   
        //Tratamento para iniciar com os dados carregados
        try {
            objConecta.rs.first();
            carregarDados();
            btnAnt.setEnabled(false);
            btnPri.setEnabled(false);
            btnCancel.setEnabled(false);
            btnLimpar.setEnabled(false);
            btnAtualiza.setEnabled(false);
        } catch (SQLException ex) {
           /* Logger.getLogger(FrmTelaPrincipal.class.getName())
                    .log(Level.SEVERE, null, ex);*/
            JOptionPane.showMessageDialog
            (null, "Erro: " +ex);
        }
        //Fim do tratamento
    }

    public final void carregarDados() {
        try {

            codigo = objConecta.rs.getInt("codigo");
            txtNome.setText(objConecta.rs.getString("nome"));
            txtCidade.setText(objConecta.rs.getString("cidade"));
            txtSalario.setText(objConecta.rs.getString("salario"));
            txtIdade.setText(objConecta.rs.getString("idade"));
            btnCadastrar.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog
            (null, "A tabela está vazia. Não existem cadastros.");
            limpar();
            btnCadastrar.setEnabled(false);
            btnExclui.setEnabled(false);
            btnProx.setEnabled(false);
            btnUlt.setEnabled(false);
        }
    }

    public void limpar() {
        txtNome.setText(null);
        txtCidade.setText(null);
        txtSalario.setText(null);
        txtIdade.setText(null);
        txtNome.grabFocus();
    }

    public void recebeDados(String operacao) {
        try {
            cadPessoa.setNome(txtNome.getText());
            cadPessoa.setCidade(txtCidade.getText());
            cadPessoa.setSalario(Float.parseFloat(txtSalario.getText()));
            cadPessoa.setIdade(Integer.parseInt(txtIdade.getText()));
            cadastrarBanco();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog
        (this, "Digite os valores corretamente");
        }
    }

    public void cadastrarBanco() {
        if (objConecta.cadastraPessoas(cadPessoa, operacao, codigo) > 0) {
            JOptionPane.showMessageDialog
            (null, "Dados cadastrados com sucesso!");
            btnNovo.setEnabled(true);
            btnPri.setEnabled(true);
            btnAnt.setEnabled(true);
            btnProx.setEnabled(true);
            btnUlt.setEnabled(true);
            btnExclui.setEnabled(true);
            btnSair.setEnabled(true);
            btnEditar.setEnabled(true);
            btnAtualiza.setEnabled(false);
            btnLimpar.setEnabled(false);
            btnCadastrar.setEnabled(false);
            btnCancel.setEnabled(false);
            txtNome.setEditable(false);
            txtCidade.setEditable(false);
            txtSalario.setEditable(false);
            txtIdade.setEditable(false);
            try {
                objConecta.executaSql(sql);
                objConecta.rs.first();
                btnPri.setEnabled(false);
                btnAnt.setEnabled(false);
                carregarDados();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTelaPrincipal.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        btnPri = new javax.swing.JButton();
        btnAnt = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();
        btnUlt = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR");
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Nome");

        jLabel2.setText("Cidade");

        jLabel3.setText("Salário");

        jLabel4.setText("Idade");

        txtNome.setEditable(false);

        txtCidade.setEditable(false);

        txtSalario.setEditable(false);

        txtIdade.setEditable(false);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        btnCadastrar.setMnemonic('a');
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Salvar o cadastro");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        btnLimpar.setMnemonic('L');
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar todos os campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo cadastro");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancelar");
        btnCancel.setToolTipText("Cancelar cadastro ou atualização");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/apagar.png"))); // NOI18N
        btnExclui.setMnemonic('E');
        btnExclui.setText("Excluir");
        btnExclui.setToolTipText("Apagar o registro atual");
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });

        btnPri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/primeiro.png"))); // NOI18N
        btnPri.setMnemonic('P');
        btnPri.setText("Primeiro");
        btnPri.setToolTipText("Ir para o primeiro registro");
        btnPri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriActionPerformed(evt);
            }
        });

        btnAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/anterior.png"))); // NOI18N
        btnAnt.setMnemonic('t');
        btnAnt.setText("Anterior");
        btnAnt.setToolTipText("Ir para o registro anterior");
        btnAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntActionPerformed(evt);
            }
        });

        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo.png"))); // NOI18N
        btnProx.setMnemonic('r');
        btnProx.setText("Próximo");
        btnProx.setToolTipText("Ir para o próximo registro");
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });

        btnUlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ultimo.png"))); // NOI18N
        btnUlt.setMnemonic('i');
        btnUlt.setText("Último");
        btnUlt.setToolTipText("Ir para o último registro");
        btnUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btnSair.setMnemonic('s');
        btnSair.setText("Sair");
        btnSair.setToolTipText("Sair do sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editar.png"))); // NOI18N
        btnEditar.setMnemonic('d');
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Alterar o registro atual");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualiza.png"))); // NOI18N
        btnAtualiza.setMnemonic('u');
        btnAtualiza.setText("Atualizar");
        btnAtualiza.setToolTipText("Salvar alterações feitas");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPri, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUlt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUlt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        operacao = "cadastrar";
        recebeDados(operacao);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        limpar();
        btnNovo.setEnabled(false);
        btnPri.setEnabled(false);
        btnAnt.setEnabled(false);
        btnProx.setEnabled(false);
        btnUlt.setEnabled(false);
        btnSair.setEnabled(false);
        btnExclui.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAtualiza.setEnabled(false);
        btnLimpar.setEnabled(true);
        btnCadastrar.setEnabled(true);
        btnCancel.setEnabled(true);
        txtNome.setEditable(true);
        txtCidade.setEditable(true);
        txtSalario.setEditable(true);
        txtIdade.setEditable(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        try {
            objConecta.rs.first();
            carregarDados();
        } catch (SQLException ex) {
            /*Logger.getLogger(FrmTelaPrincipal.class.getName())
             .log(Level.SEVERE, null, ex);*/
            JOptionPane.showMessageDialog(null, ex);
        }
        btnNovo.setEnabled(true);
        //btnPri.setEnabled(true);
        //btnAnt.setEnabled(true);
        btnProx.setEnabled(true);
        btnUlt.setEnabled(true);
        btnExclui.setEnabled(true);
        btnSair.setEnabled(true);
        btnEditar.setEnabled(true);
        btnAtualiza.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnCadastrar.setEnabled(false);
        btnCancel.setEnabled(false);
        txtNome.setEditable(false);
        txtCidade.setEditable(false);
        txtSalario.setEditable(false);
        txtIdade.setEditable(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        int escolha = 
                (JOptionPane.showConfirmDialog
                (null, "Deseja realmente sair?",
                "Sair", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE));
        if (escolha == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiActionPerformed
        // TODO add your handling code here:
        String nome;
        nome = txtNome.getText();
        int escolha = 
                (JOptionPane.showConfirmDialog(null, "Você excluirá "
                + nome + "\nDeseja realmente apagar este registro?",
                "Excluir Registro", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE));
        if (escolha == 0) {
            objConecta.excluir(codigo);
            try {
                objConecta.executaSql(sql);
                objConecta.rs.last();
                carregarDados();
            } catch (SQLException ex) {
                /*Logger.getLogger(FrmCadastraAluno.class.getName())
                 .log(Level.SEVERE, null, ex);*/
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnExcluiActionPerformed

    private void btnPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriActionPerformed
        // TODO add your handling code here:
        try {
            objConecta.rs.first();
            carregarDados();
            btnAnt.setEnabled(false);
            btnPri.setEnabled(false);
            btnProx.setEnabled(true);
            btnUlt.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPriActionPerformed

    private void btnAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntActionPerformed
        // TODO add your handling code here:
        try {
            if (!objConecta.rs.isFirst()) {
                objConecta.rs.previous();
                carregarDados();
                btnProx.setEnabled(true);
                btnUlt.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog
                 (null, "Primeiro Registro!");
                btnAnt.setEnabled(false);
                btnPri.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAntActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        // TODO add your handling code here:
        try {
            if (!objConecta.rs.isLast()) {
                objConecta.rs.next();
                carregarDados();
                btnAnt.setEnabled(true);
                btnPri.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog
                (null, "Último Registro!");
                btnProx.setEnabled(false);
                btnUlt.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProxActionPerformed

    private void btnUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltActionPerformed
        // TODO add your handling code here:
        try {
            objConecta.rs.last();
            carregarDados();
            btnAnt.setEnabled(true);
            btnPri.setEnabled(true);
            btnProx.setEnabled(false);
            btnUlt.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(FrmTelaPrincipal.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUltActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        btnNovo.setEnabled(false);
        btnPri.setEnabled(false);
        btnAnt.setEnabled(false);
        btnProx.setEnabled(false);
        btnUlt.setEnabled(false);
        btnSair.setEnabled(false);
        btnExclui.setEnabled(false);
        btnEditar.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnCadastrar.setEnabled(false);
        btnAtualiza.setEnabled(true);
        btnCancel.setEnabled(true);
        txtNome.setEditable(true);
        txtCidade.setEditable(true);
        txtSalario.setEditable(true);
        txtIdade.setEditable(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        // TODO add your handling code here:
        operacao = "atualizar";
        recebeDados(operacao);
        btnEditar.setEnabled(true);
        btnAtualiza.setEnabled(false);
    }//GEN-LAST:event_btnAtualizaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPri;
    private javax.swing.JButton btnProx;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUlt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
