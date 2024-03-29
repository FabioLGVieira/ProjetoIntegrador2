package view;

import controller.PedidoController;
import controller.ProdutoController;
import controller.VendaController;
import java.beans.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Icaro
 */
public class CarrinhoView extends javax.swing.JFrame {

    Connection con;
    Statement rst;

    public CarrinhoView() {

        initComponents();
        setLocationRelativeTo(null);
        lblEstoque.setVisible(false);
        lblCarrinho.setVisible(false);
        lblNome.setVisible(false);
        txt_produto.setEditable(false);
        txt_valor.setEditable(false);
        carregaTabela();
        carregarClientes();
    }

    public void limparcampos() {
        txt_produto.setText("");
        txt_quantidade.setText("");
        txt_valor.setText("");
        tbl_estoque.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_produto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_cancela = new javax.swing.JButton();
        btn_adicionar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Total = new javax.swing.JLabel();
        btn_fimVenda = new javax.swing.JButton();
        txt_data = new javax.swing.JFormattedTextField();
        cpf_cliente = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        lblEstoque = new javax.swing.JLabel();
        lblCarrinho = new javax.swing.JLabel();
        txt_valor = new javax.swing.JFormattedTextField();
        txt_quantidade = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_estoque = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_carrinho = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carrinho");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Produto");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Valor");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_cancela.setText("Cancelar");
        btn_cancela.setMaximumSize(new java.awt.Dimension(80, 25));
        btn_cancela.setMinimumSize(new java.awt.Dimension(80, 25));
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });

        btn_adicionar.setText("Adicionar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_remover.setBackground(new java.awt.Color(255, 0, 0));
        btn_remover.setText("Remover");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_adicionar)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_remover)
                    .addComponent(btn_adicionar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Valor Total: R$");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Data da compra:");

        lbl_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_Total.setText("0,00");

        btn_fimVenda.setText("Finalizar venda");
        btn_fimVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fimVendaActionPerformed(evt);
            }
        });

        try {
            txt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cpf_cliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpf_cliente.setText("CPF do cliente:");

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_fimVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_data, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cpf_cliente)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cpf)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf_cliente)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btn_fimVenda)
                .addGap(12, 12, 12))
        );

        lblEstoque.setText("lblEstoque");

        lblCarrinho.setText("lblCarrinho");

        txt_valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$#,##0.00"))));

        txt_quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txt_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantidadeActionPerformed(evt);
            }
        });
        txt_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantidadeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_produto)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_quantidade))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCarrinho)
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstoque)
                    .addComponent(lblCarrinho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "Produto", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_estoque.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_estoqueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_estoque);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl_carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_carrinho.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbl_carrinho);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/produto.png"))); // NOI18N
        jLabel6.setText("Gerenciar Produto");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio64.png"))); // NOI18N
        jLabel7.setText("Relatório");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fechar64.png"))); // NOI18N
        jLabel8.setText("Sair");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente.png"))); // NOI18N
        jLabel9.setText("Gerenciar Cliente");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        lblNome.setText("lblNome");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(68, 68, 68)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6)
            .addComponent(jLabel7)
            .addComponent(jLabel8)
            .addComponent(jLabel9)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        RelatoriosView minhaJanelaRelatorio;
        minhaJanelaRelatorio = new RelatoriosView();
        minhaJanelaRelatorio.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        EstoqueView minhaJanelaEstoque;
        minhaJanelaEstoque = new EstoqueView();
        minhaJanelaEstoque.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        From_Cliente minhaJanelaCadastroCliente;
        minhaJanelaCadastroCliente = new From_Cliente();
        minhaJanelaCadastroCliente.setVisible(true);

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_fimVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fimVendaActionPerformed

        boolean verifica = true;
        if (verificaCampos2()) {
            ArrayList<String[]> linhasVenda = VendaController.consultarCPF(txt_cpf.getText());

            DefaultTableModel modelProdutos = new DefaultTableModel();
            modelProdutos.addColumn("Cod_cli");
            modelProdutos.addColumn("Nome");
            modelProdutos.addColumn("cpf");

            for (String[] c : linhasVenda) {
                modelProdutos.addRow(c);
            }
            
            if(!(modelProdutos.getRowCount()==0)){
            int cod_cliente = Integer.parseInt(modelProdutos.getValueAt(0, 0).toString());
            String nome = (String) modelProdutos.getValueAt(0, 1).toString();
            String cpf = (String) modelProdutos.getValueAt(0, 2).toString();
            String data = transformaData(txt_data.getText());

            if (cpf.equals(txt_cpf.getText())) {
                VendaController.salvar(cod_cliente, nome, data, Float.parseFloat(lbl_Total.getText().replace(",", ".")));
                ArrayList<String[]> linhasPedido = PedidoController.consultarUltimaVenda();
                DefaultTableModel modelPedidos = new DefaultTableModel();
                modelPedidos.addColumn("Cod_venda");

                for (String[] c : linhasPedido) {
                    modelPedidos.addRow(c);
                }

                for (int i = 0; i < tbl_carrinho.getRowCount(); i++) {
                    PedidoController.salvar(Integer.parseInt(modelPedidos.getValueAt(0, 0).toString()), tbl_carrinho.getValueAt(i, 1).toString(),
                            Integer.parseInt(tbl_carrinho.getValueAt(i, 2).toString()), Float.parseFloat(tbl_carrinho.getValueAt(i, 3).toString().replace(",", ".")));
                }
                lbl_Total.setText("0,00");
            }

            verifica = false;
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Digite um cpf valido");
            }
            if (verifica == false) {
                ((DefaultTableModel) tbl_carrinho.getModel()).setRowCount(0);
                txt_produto.setText("");
                txt_quantidade.setText("");
                txt_valor.setText("");
                txt_data.setText("");
                txt_cpf.setText("");
            }
        }
    }//GEN-LAST:event_btn_fimVendaActionPerformed

    public String transformaData(String dt) {
        String dataFormatada = String.format("%s/%s/%s", dt.substring(6, 10), dt.substring(3, 5), dt.substring(0, 2));
        return dataFormatada;
    }

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        limparcampos();
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregaTabela();
        carregarClientes();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tbl_estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_estoqueMouseClicked
        lblEstoque.setText(tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 0).toString());
        txt_produto.setText(tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 1).toString());
        txt_valor.setText(tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tbl_estoqueMouseClicked

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        boolean limpar = true;
        float valor = Float.parseFloat(lbl_Total.getText().replace(",", "."));
        if (verificaCampos()) {
            DefaultTableModel dtmPedidos = (DefaultTableModel) tbl_carrinho.getModel();
            Object[] dados = {tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 0), txt_produto.getText(), txt_quantidade.getText(), txt_valor.getText().replace(",", ".")};
            dtmPedidos.addRow(dados);
            limpar = false;
            float nValor = Float.parseFloat(txt_valor.getText().replace(",", ".").replace("R$", ""));
            valor += nValor;
            lbl_Total.setText(String.format("%.2f", valor));
            ProdutoController.removerQuantidade(Integer.parseInt(tbl_estoque.getModel().getValueAt(
                    tbl_estoque.getSelectedRow(), 0).toString()), Integer.parseInt(txt_quantidade.getText().replace(".", "")));
            carregaTabela();
        }

        if (limpar == false) {
            limpaInput();
        }

    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        if (tbl_carrinho.getSelectedRow() != -1) {

            float valor = Float.parseFloat(lbl_Total.getText().replace(",", "."));
            float mValor = Float.parseFloat(tbl_carrinho.getValueAt(tbl_carrinho.getSelectedRow(), 3).toString().replace(",", "."));
            valor -= mValor;
            lbl_Total.setText(String.format("%.2f", valor));
            DefaultTableModel dtmPedidos = (DefaultTableModel) tbl_carrinho.getModel();
            ProdutoController.aumentarQuantidade(
                    Integer.parseInt(tbl_carrinho.getModel().getValueAt(tbl_carrinho.getSelectedRow(), 0).toString()),
                    Integer.parseInt(tbl_carrinho.getModel().getValueAt(tbl_carrinho.getSelectedRow(), 2).toString()));
            dtmPedidos.removeRow(tbl_carrinho.getSelectedRow());

            carregaTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir!");
        }
    }//GEN-LAST:event_btn_removerActionPerformed

    private void txt_quantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyReleased
        if (txt_quantidade.getText().isEmpty()) {
            txt_valor.setText(String.valueOf(Float.parseFloat(tbl_estoque.getModel()
                    .getValueAt(tbl_estoque.getSelectedRow(), 2).toString()) * 1));
        } else if (tbl_estoque.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Cadastre um produto!");
            txt_quantidade.setText("");
        } else if (Integer.parseInt(txt_quantidade.getText().replace(".", ""))
                > Integer.parseInt(tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 3).toString())) {
            JOptionPane.showMessageDialog(null, "Quantidade maior do que o Estoque!");
            txt_quantidade.setText("");
        } else {
            float nValor = Integer.parseInt(txt_quantidade.getText().replace(".", ""))
                    * Float.parseFloat(tbl_estoque.getModel().getValueAt(tbl_estoque.getSelectedRow(), 2).toString());

            txt_valor.setText(String.format("%.2f", nValor));
        }
    }//GEN-LAST:event_txt_quantidadeKeyReleased

    private void txt_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantidadeActionPerformed

    private boolean verificaCampos() {
        if (this.txt_produto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do produto");
            return false;
        }
        if (this.txt_valor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite valor para o porduto");
            return false;
        }
        if (this.txt_quantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a quantidade de produtos");
            return false;
        }
        return true;
    }

    private boolean verificaCampos2() {
        if(tbl_carrinho.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Adicione um pedido no carrinho");
            return false;
        }
        if (this.txt_data.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Digite a data da compra");
            return false;
        }
        if (this.txt_cpf.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Digite o CPF do cliente");
            return false;
        }

        return true;
    }

    public ArrayList carregarClientes() {
        ArrayList<String[]> linhasCliente = ProdutoController.consultarEstoque();
        DefaultTableModel cli = new DefaultTableModel();
        cli.addColumn("CPF");

        return linhasCliente;
    }

    public void carregaTabela() {
        ArrayList<String[]> linhasProdutos = ProdutoController.consultarEstoque();

        DefaultTableModel modelProdutos = new DefaultTableModel();
        modelProdutos.addColumn("Código");
        modelProdutos.addColumn("Nome");
        modelProdutos.addColumn("Valor");
        modelProdutos.addColumn("Quantidade");
        tbl_estoque.setModel(modelProdutos);

        for (String[] c : linhasProdutos) {
            modelProdutos.addRow(c);
        }

        for (int i = 0; i < modelProdutos.getColumnCount(); i++) {
            tbl_estoque.getColumnModel().getColumn(i).setPreferredWidth(100);
        }

    }

    public void limpaInput() {
        txt_produto.setText("");
        txt_quantidade.setText("");
        txt_valor.setText("");

    }

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
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarrinhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarrinhoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_fimVenda;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel cpf_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCarrinho;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lbl_Total;
    private javax.swing.JTable tbl_carrinho;
    private javax.swing.JTable tbl_estoque;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JTextField txt_produto;
    private javax.swing.JFormattedTextField txt_quantidade;
    private javax.swing.JFormattedTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
