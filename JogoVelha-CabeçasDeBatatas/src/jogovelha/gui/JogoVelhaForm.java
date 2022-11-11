/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jogovelha.gui;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jogovelha.controle.JogoVelhaControle;
import jogovelha.entidade.Jogada;
import jogovelha.entidade.Jogador;
import jogovelha.entidade.Resultados;

/**
 *
 * @author Marco
 */
public final class JogoVelhaForm extends javax.swing.JFrame {
    public final int BTN00 = 1;
    public final int BTN01 = 2;
    public final int BTN02 = 3;
    public final int BTN10 = 4;
    public final int BTN11 = 5;
    public final int BTN12 = 6;
    public final int BTN20 = 7;
    public final int BTN21 = 8;
    public final int BTN22 = 9;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
    EntityManager em = emf.createEntityManager();
    
    JogoVelhaControle jvc = new JogoVelhaControle();
    Jogador j1 = new Jogador();
    Jogador j2 = new Jogador();
    
    Random rd = new Random();
    /**
     * @param vezJogador
     * true = Jogador X
     * false = Jogador O
     */
    Boolean vezJogador;
    
    public void pintarQuadradosGanhador(int modoGanho){
        switch(modoGanho) {
                case 0 -> {
                    btn00.setBackground(new Color(0, 190, 0));
                    btn01.setBackground(new Color(0, 190, 0));
                    btn02.setBackground(new Color(0, 190, 0));
                }
                   
                case 1 -> {
                    btn10.setBackground(new Color(0, 190, 0));
                    btn11.setBackground(new Color(0, 190, 0));
                    btn12.setBackground(new Color(0, 190, 0));
                }
                
                case 2 -> {
                    btn20.setBackground(new Color(0, 190, 0));
                    btn21.setBackground(new Color(0, 190, 0));
                    btn22.setBackground(new Color(0, 190, 0));
                }
                
                case 3 -> {
                    btn00.setBackground(new Color(0, 190, 0));
                    btn10.setBackground(new Color(0, 190, 0));
                    btn20.setBackground(new Color(0, 190, 0));
                }
                    
                case 4 -> {
                    btn01.setBackground(new Color(0, 190, 0));
                    btn11.setBackground(new Color(0, 190, 0));
                    btn21.setBackground(new Color(0, 190, 0));
                }
                    
                case 5 -> {
                    btn02.setBackground(new Color(0, 190, 0));
                    btn12.setBackground(new Color(0, 190, 0));
                    btn22.setBackground(new Color(0, 190, 0));
                }
                    
                case 6 -> {
                    btn00.setBackground(new Color(0, 190, 0));
                    btn11.setBackground(new Color(0, 190, 0));
                    btn22.setBackground(new Color(0, 190, 0));
                }
                    
                case 7 -> {
                    btn02.setBackground(new Color(0, 190, 0));
                    btn11.setBackground(new Color(0, 190, 0));
                    btn20.setBackground(new Color(0, 190, 0));
                }
                
                case 8 ->{
                    btn00.setBackground(new Color(180, 180, 0));
                    btn01.setBackground(new Color(180, 180, 0));
                    btn02.setBackground(new Color(180, 180, 0));
                    btn10.setBackground(new Color(180, 180, 0));
                    btn11.setBackground(new Color(180, 180, 0));
                    btn12.setBackground(new Color(180, 180, 0));
                    btn20.setBackground(new Color(180, 180, 0));
                    btn21.setBackground(new Color(180, 180, 0));
                    btn22.setBackground(new Color(180, 180, 0));
                    
                }

            }
        
    }
    
    public void iniciarPartida() throws Exception{
        if(!txtJogador1.getText().isEmpty() && !txtJogador2.getText().isEmpty()){
            j1.setId(1);
            j1.setNome(txtJogador1.getText());
            j2.setId(2);
            j2.setNome(txtJogador2.getText());
            
            jvc.iniciarPartida(j1, j2);
            
            vezJogador = rd.nextBoolean();
            if(vezJogador) {
                lblMensagem.setText("É a vez do Jogador X");
            } else {
                lblMensagem.setText("É a vez do Jogador O");
            }
            
            lblNumPartida.setText(jvc.getNumPartida()+"° partida");
            
            btnIniciar.setEnabled(false);
            btnCancelar.setEnabled(true);
            txtJogador1.setEnabled(false);
            txtJogador2.setEnabled(false);
            
            definirTabela(true);
            
            
            
        } else {
            throw new Exception("É necessário preencher os dois campos de nome!");
        }
    }
    
    public void realizarJogada(int l, int c, int btn) throws Exception{
        String atualJogador;
        String proximoJogador;
        Jogada jgd;
        Color atualJogadorCor;
        
        if(vezJogador) {
            jgd = new Jogada(l, c, j1);
            atualJogador = "X";
            atualJogadorCor = new Color(255,102,102);
            proximoJogador = "O";
  
        } else {
            jgd = new Jogada(l, c, j2);
            atualJogador = "O";
            atualJogadorCor = new Color(0,153,255);
            proximoJogador = "X";
            
        }
        
        if(jvc.getTabuleiro().obterJogador(l, c).getId() == 0) {
            switch(btn) {
                case 1 -> {
                    btn00.setText(atualJogador); 
                    btn00.setForeground(atualJogadorCor);
                }
                   
                case 2 -> {
                    btn01.setText(atualJogador); 
                    btn01.setForeground(atualJogadorCor);
                }
                
                case 3 -> {
                    btn02.setText(atualJogador); 
                    btn02.setForeground(atualJogadorCor);
                }
                
                case 4 -> {
                    btn10.setText(atualJogador); 
                    btn10.setForeground(atualJogadorCor);
                }
                    
                case 5 -> {
                    btn11.setText(atualJogador); 
                    btn11.setForeground(atualJogadorCor);
                }
                    
                case 6 -> {
                    btn12.setText(atualJogador); 
                    btn12.setForeground(atualJogadorCor);
                }
                    
                case 7 -> {
                    btn20.setText(atualJogador); 
                    btn20.setForeground(atualJogadorCor);
                }
                    
                case 8 -> {
                    btn21.setText(atualJogador); 
                    btn21.setForeground(atualJogadorCor);
                }
                    
                case 9 -> {
                    btn22.setText(atualJogador); 
                    btn22.setForeground(atualJogadorCor);
                }

            }
        }
    
        jvc.realizarJogada(jgd);
        vezJogador = !vezJogador;
        lblMensagem.setText("É a vez do Jogador " + proximoJogador);
        
    }
    
    public JogoVelhaForm() {
        initComponents();
        
        definirTabela(false);
        
    }
    
    public void definirTabela(Boolean estado) {
        btn00.setEnabled(estado);
        btn01.setEnabled(estado);
        btn02.setEnabled(estado);
        btn10.setEnabled(estado);
        btn11.setEnabled(estado);
        btn12.setEnabled(estado);
        btn20.setEnabled(estado);
        btn21.setEnabled(estado);
        btn22.setEnabled(estado);
        
        if(estado) {
            btn00.setText("");
            btn01.setText("");
            btn02.setText("");
            btn10.setText("");
            btn11.setText("");
            btn12.setText("");
            btn20.setText("");
            btn21.setText("");
            btn22.setText("");
            btn00.setBackground(new Color(255, 255, 255));
            btn01.setBackground(new Color(255, 255, 255));
            btn02.setBackground(new Color(255, 255, 255));
            btn10.setBackground(new Color(255, 255, 255));
            btn11.setBackground(new Color(255, 255, 255));
            btn12.setBackground(new Color(255, 255, 255));
            btn20.setBackground(new Color(255, 255, 255));
            btn21.setBackground(new Color(255, 255, 255));
            btn22.setBackground(new Color(255, 255, 255));
        }
        
    }
    
    public void finalizarPartida() {
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        model.setRowCount(0);
        
        List<Resultados> l = jvc.getResultados().findAll();
        for(Iterator<Resultados> it = l.iterator(); it.hasNext();){
            
        }
        
        int i = 0;
        Boolean continuarResultados = true;
        
        while(continuarResultados){
            if(resultadosAnteriores[i][1] != null){
                model.addRow(new Object[]{
                    i+1,
                    resultadosAnteriores[i][0],
                    resultadosAnteriores[i][1]
                    });
                
                i++;
            } else {
                continuarResultados = false;
            }
                
        }
        
        lblMensagem.setText("Fim da partida!");
        
        definirTabela(false);
        txtJogador1.setEnabled(true);
        txtJogador2.setEnabled(true);
        btnIniciar.setEnabled(true);
        btnCancelar.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblMensagem = new javax.swing.JLabel();
        lblDefPartida = new javax.swing.JLabel();
        lblNumPartida = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        lblResultados = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtJogador1 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtJogador2 = new javax.swing.JTextPane();
        lblJog2 = new javax.swing.JLabel();
        lblJog1 = new javax.swing.JLabel();
        lblLegenda = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn22 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn00 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem.setText("Partida não iniciada. Defina jogadores e inicie!");

        lblDefPartida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDefPartida.setText("Definição da Partida");

        lblNumPartida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumPartida.setToolTipText("");

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Partida", "Jogador 1", "Jogador 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblResultados);

        lblResultados.setText("Resultados Anteriores");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(txtJogador1);

        jScrollPane5.setViewportView(txtJogador2);

        lblJog2.setText("Jogador O");

        lblJog1.setText("Jogador X");

        lblLegenda.setText("* = Ganhador da partida");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.setToolTipText("");

        btn22.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn22.setBorderPainted(false);
        btn22.setFocusable(false);
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        btn12.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn12.setBorderPainted(false);
        btn12.setFocusable(false);
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn02.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn02.setBorderPainted(false);
        btn02.setFocusable(false);
        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });

        btn01.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn01.setBorderPainted(false);
        btn01.setFocusable(false);
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });

        btn11.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn11.setBorderPainted(false);
        btn11.setFocusable(false);
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn21.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn21.setBorderPainted(false);
        btn21.setFocusable(false);
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn20.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn20.setBorderPainted(false);
        btn20.setFocusable(false);
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn10.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn10.setBorderPainted(false);
        btn10.setFocusable(false);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn00.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        btn00.setForeground(new java.awt.Color(0, 153, 255));
        btn00.setBorderPainted(false);
        btn00.setFocusable(false);
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJog1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lblDefPartida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblNumPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(lblResultados))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(lblJog2)))
                                            .addGap(44, 44, 44))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(btnIniciar)
                                            .addGap(18, 18, 18)))
                                    .addComponent(btnCancelar))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLegenda)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDefPartida)
                            .addComponent(lblNumPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblJog1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJog2)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciar)
                            .addComponent(btnCancelar))
                        .addGap(39, 39, 39)
                        .addComponent(lblResultados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLegenda)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try{
            iniciarPartida();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro Ao Iniciar",
                    JOptionPane.ERROR_MESSAGE);
            
            
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jvc.cancelarPartida();
        finalizarPartida();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        try {
            realizarJogada(0, 0, BTN00);
        } catch(Exception e) {
            
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btn00ActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        try {
            realizarJogada(0, 1, BTN01);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        try {
            realizarJogada(0, 2, BTN02);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        try {
            realizarJogada(1, 0, BTN10);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        try {
            realizarJogada(1, 1, BTN11);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        try {
            realizarJogada(1, 2, BTN12);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);

                finalizarPartida();
            } else {
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        try {
            realizarJogada(2, 0, BTN20);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        try {
            realizarJogada(2, 1, BTN21);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        try {
            realizarJogada(2, 2, BTN22);
        } catch(Exception e) {
            if(e.getClass().getName().equals("jogovelha.controle.FimPartidaException")){
                pintarQuadradosGanhador(jvc.getModoDoGanho());
                
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Vitória!",
                    JOptionPane.INFORMATION_MESSAGE);
                
                finalizarPartida();
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btn22ActionPerformed

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
            java.util.logging.Logger.getLogger(JogoVelhaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoVelhaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblDefPartida;
    private javax.swing.JLabel lblJog1;
    private javax.swing.JLabel lblJog2;
    private javax.swing.JLabel lblLegenda;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNumPartida;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextPane txtJogador1;
    private javax.swing.JTextPane txtJogador2;
    // End of variables declaration//GEN-END:variables
}
