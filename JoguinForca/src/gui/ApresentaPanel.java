package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ApresentaPanel extends javax.swing.JPanel {

    private FramePrincipal framePai;
    
    public ApresentaPanel(FramePrincipal pai) {
        initComponents();
        
        //passando o FramePrincipal como atributo "pai" do Painel
        this.framePai = pai;
    }
    
    //método que define a imagem de fundo do Painel
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        try {  
            //carregando a imagem de fundo a partir de seu endereço na pasta
            Image imagemFundo = ImageIO.read(
                    new File(getClass().
                            getResource("/imagens/campinho.png").
                            getFile()));
            
            //redimensionando a imagem de acordo com as proporções do Frame e do Painel
            imagemFundo = imagemFundo.getScaledInstance(1042, 509, 
                    Image.SCALE_DEFAULT);
            
            //"pintando" a imagem no painel
            g.drawImage(imagemFundo, 0, 0, this);
            
            
        } catch (IOException ex) {
            //tratamento de erro
            System.err.println("o arquivo está corrompido");
        }
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        iniciarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("FORCA");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("(SIMULADOR DE ESTUDANTE DO IFMG)");

        iniciarBtn.setBackground(new java.awt.Color(255, 255, 255));
        iniciarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        iniciarBtn.setText("INICIAR");
        iniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("By: Nicolas & Otávio. All rights reserved.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(iniciarBtn)
                                .addGap(274, 274, 274))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(249, 249, 249)
                                    .addComponent(jLabel3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(iniciarBtn)
                .addGap(118, 118, 118)
                .addComponent(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //quando o botâo de iniciar for pressionado, o painel é trocado
    //painel de definição da palavra misteriosa
    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        framePai.trocarPainel(new DefinePalavraPanel(framePai));
    }//GEN-LAST:event_iniciarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
