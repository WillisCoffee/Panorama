package pckDialog;

// William Thibodeau
import pckEntites.Locaux;
import static pckValidation.Validation.validerLocal;
import static pckValidation.Validation.validerNombre;

//Fenêtre permettant la modification et l'ajout d'un local
public class DlgLocaux extends javax.swing.JDialog {
    
    //<editor-fold defaultstate="collapsed" desc="Variables">
    boolean result = false;
    Locaux unLocal;
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgLocaux(java.awt.Frame parent, boolean modal, Locaux leLocal)
    {
        super(parent, modal);
        unLocal = leLocal;
        initComponents();
        
        initialiserChamps();
    }
    
    public DlgLocaux(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        unLocal = new Locaux();
        initComponents();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public boolean isResult()
    {
        return this.result;
    }

    public Locaux getUnLocal() {
        return unLocal;
    }

    public void setUnLocal(Locaux unLocal) {
        this.unLocal = unLocal;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitre = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblNumeroLocal = new javax.swing.JLabel();
        lblCategorie = new javax.swing.JLabel();
        txfNoLocal = new javax.swing.JTextField();
        lblNbrPlace = new javax.swing.JLabel();
        txfNbPlaces = new javax.swing.JTextField();
        cmbCategorie = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txfDepartement = new javax.swing.JTextField();
        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer un local");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Locaux");
        pnlTitre.add(jLabel1);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        pnlContenu.setPreferredSize(new java.awt.Dimension(381, 130));

        lblNumeroLocal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroLocal.setText("Numéro du local :");

        lblCategorie.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCategorie.setText("Catégorie :");

        txfNoLocal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblNbrPlace.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNbrPlace.setText("Nombre de places :");

        txfNbPlaces.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        cmbCategorie.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laboratoire", "Classe" }));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Département :");

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCategorie)
                    .addComponent(lblNumeroLocal)
                    .addComponent(lblNbrPlace)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNbPlaces, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(txfNoLocal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCategorie, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfDepartement))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroLocal)
                    .addComponent(txfNoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategorie)
                    .addComponent(cmbCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNbrPlace)
                    .addComponent(txfNbPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setPreferredSize(new java.awt.Dimension(0, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        btnAccepter.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAccepter.setMnemonic('a');
        btnAccepter.setText("Accepter");
        btnAccepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccepterActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnAccepter);

        btnAnnuler.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAnnuler.setMnemonic('n');
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnAnnuler);

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
        if (validerInfos())
        {
            setResult(true);
            setInfos();
            setVisible(false);
        }
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        setResult(false);
        
        setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Opérations">  
    private void setInfos()
    {
        unLocal.setCategorie(cmbCategorie.getSelectedItem().toString());
        unLocal.setNombrePlace(Integer.parseInt(txfNbPlaces.getText()));
        unLocal.setNumeroLocal(txfNoLocal.getText());
        if ("".equals(txfDepartement.getText()))
            unLocal.setReserverA(null);
        else
            unLocal.setReserverA(txfDepartement.getText());
    }

    private boolean validerInfos()
    {
        if(!validerLocal(txfNoLocal.getText()))
        {
            lblMessage.setText("Veuillez entrer un numéro de local valide.");
            return false;
        }
        if(!validerNombre(txfNbPlaces.getText()))
        {
            lblMessage.setText("Veuillez entrer un nombre de place valide.");
            return false;
        }
        if (txfDepartement.getText().isEmpty())
        {
            lblMessage.setText("Veuillez entrer un département valide.");
            return false;
        }
        return true;
    }
    
    private void initialiserChamps()
    {
        txfNoLocal.setText(unLocal.getNumeroLocal());
        txfNbPlaces.setText(String.valueOf(unLocal.getNombrePlace()));
        txfDepartement.setText(unLocal.getReserverA());
        setCategorieLocal();
    }
    
    private void setCategorieLocal()
    {
        switch(unLocal.getCategorie())
        {
            case "Classe": cmbCategorie.setSelectedIndex(1);
                
            case "Laboratoire": cmbCategorie.setSelectedIndex(0);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
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
            java.util.logging.Logger.getLogger(DlgLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgLocaux dialog = new DlgLocaux(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Composants">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JComboBox<String> cmbCategorie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCategorie;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNbrPlace;
    private javax.swing.JLabel lblNumeroLocal;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTextField txfDepartement;
    private javax.swing.JTextField txfNbPlaces;
    private javax.swing.JTextField txfNoLocal;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
