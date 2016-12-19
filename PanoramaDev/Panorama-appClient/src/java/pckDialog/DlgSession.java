package pckDialog;

// William Thibodeau.
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pckEntites.Session;
import static pckValidation.Validation.validerAnnee;
import static pckValidation.Validation.validerDate;

// Fenêtre permettant la modification et l'ajout d'une session.
public class DlgSession extends javax.swing.JDialog 
{
    // <editor-fold defaultstate="collapsed" desc="Variables">
    boolean result = false;
    Session uneSession;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Initialisation">
    public DlgSession(java.awt.Frame parent, boolean modal, Session laSession)
    {
        super(parent, modal);
        uneSession = laSession;
        initComponents();
        
        initialiserChamps();
    }
    
    public DlgSession(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        uneSession = new Session();
        initComponents();
    }
    
    private void initialiserChamps()
    {
        //Année
        txfAnnee.setText(String.valueOf(uneSession.getAnnee()));
        //Date de début
        txfDateDebut.setText(df.format(uneSession.getDateDebutSession()));
        //Date de fin
        txfDateFin.setText(df.format(uneSession.getDateFinSession()));
        //Saison
        switch(uneSession.getSaison())
        {
            case "Été" :         
                cmbSession.setSelectedIndex(1);
                break;
            
            case "Hiver" : 
                cmbSession.setSelectedIndex(0);
                break;
            
            case "Automne" :    
                cmbSession.setSelectedIndex(2);
                break;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getter / setter">
    public Session getUneSession() {
        return uneSession;
    }
    
    public boolean isResult() 
    {
        return result;
    }

    private void setResult(boolean result) 
    {
        this.result = result;
    }
    
     //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlBas = new javax.swing.JPanel();
        pnlBoutons = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        txfDateFin = new javax.swing.JTextField();
        txfDateDebut = new javax.swing.JTextField();
        lblDateFin = new javax.swing.JLabel();
        lblSession = new javax.swing.JLabel();
        lblDateDebut = new javax.swing.JLabel();
        cmbSession = new javax.swing.JComboBox<>();
        txfAnnee = new javax.swing.JTextField();
        lblAnnee = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter une session");

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Session");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        pnlBas.setToolTipText("");
        pnlBas.setPreferredSize(new java.awt.Dimension(267, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        pnlBoutons.setPreferredSize(new java.awt.Dimension(189, 30));

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

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.CENTER);

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        txfDateFin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfDateFin.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txfDateDebut.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblDateFin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDateFin.setText("Date de fin :");

        lblSession.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSession.setText("Saison :");

        lblDateDebut.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDateDebut.setText("Date de début :");

        cmbSession.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiver", "Été", "Automne" }));

        txfAnnee.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfAnnee.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lblAnnee.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAnnee.setText("Année :");

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateFin)
                    .addComponent(lblAnnee)
                    .addComponent(lblSession)
                    .addComponent(lblDateDebut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfDateDebut)
                    .addComponent(cmbSession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfDateFin)
                    .addComponent(txfAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateDebut))
                .addGap(13, 13, 13)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateFin)
                    .addComponent(txfDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnnee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSession)
                    .addComponent(cmbSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
        if (validerInfos())
        {
            setResult(true);
            setInfos();
            calculerCode();
            setVisible(false);
        }
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        setResult(false);
        setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Opérations">
    private boolean validerInfos()
    {
        if (!validerDate(txfDateDebut.getText()))
        {
            lblMessage.setText("Veuillez entrer une date de début valide.");
            return false;
        }
        if (!validerDate(txfDateFin.getText()))
        {
            lblMessage.setText("Veuillez entrer une date de fin valide.");
            return false;
        }
        if (!validerAnnee(txfAnnee.getText()))
        {
            lblMessage.setText("Veuillez enter une année valide.");
            return false;
        }
        return true;
    }
    private void setInfos()
    {
        uneSession.setAnnee(Integer.parseInt(txfAnnee.getText()));
        uneSession.setSaison(obtenirSaison(cmbSession.getSelectedIndex()));
        
        try 
        {
            uneSession.setDateDebutSession(df.parse(txfDateDebut.getText() ) );
            uneSession.setDateFinSession(df.parse(txfDateFin.getText() ));
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
    }
    
    private void calculerCode()
    {
        String code = "";
        code = (uneSession.getSaison().substring(0,1));
        code += (String.valueOf(uneSession.getAnnee() % 100));
        uneSession.setCodeSession(code);
    }
    
    private String obtenirSaison(int i)
    {
        switch(i)
        {
            case 0 :         
                return "Hiver";           
            case 1 : 
                return "Été";
            case 2:    
                return "Automne";
            default:
                return "";
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main">
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
            java.util.logging.Logger.getLogger(DlgSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgSession dialog = new DlgSession(new javax.swing.JFrame(), true, null);
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Déclarations de composants">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JComboBox<String> cmbSession;
    private javax.swing.JLabel lblAnnee;
    private javax.swing.JLabel lblDateDebut;
    private javax.swing.JLabel lblDateFin;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblSession;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTextField txfAnnee;
    private javax.swing.JTextField txfDateDebut;
    private javax.swing.JTextField txfDateFin;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}