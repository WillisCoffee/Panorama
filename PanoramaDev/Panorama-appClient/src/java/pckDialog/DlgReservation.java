package pckDialog;

import ejb.ReserverLocauxFacadeRemote;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import pckEntites.Locaux;
import pckEntites.ReserverLocaux;
import pckFournisseur.FournisseurServices;
import pckValidation.Validation;

public class DlgReservation extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="comment">
    Locaux local;
    FournisseurServices fournisseur;
    
    ReserverLocauxFacadeRemote facadeReserverLocaux;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public Locaux getLocal() {
        return local;
    }

    public void setLocal(Locaux local) {
        this.local = local;
    }
    boolean mrOk = false;

    public boolean isMrOk() {
        return mrOk;
    }

    public void setMrOk(boolean mrOk) {
        this.mrOk = mrOk;
    }
    //</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgReservation(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }
    
    public DlgReservation(java.awt.Frame parent, boolean modal,Locaux unLocal,FournisseurServices fs)
    {
        super(parent, modal);
        local = unLocal;
        fournisseur = fs;
        
        initComponents();
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        lblHeureDebut = new javax.swing.JLabel();
        lblHeureFin = new javax.swing.JLabel();
        txfHeureDebut = new javax.swing.JTextField();
        txfHeureFin = new javax.swing.JTextField();
        txfReserve = new javax.swing.JTextField();
        lblReserve = new javax.swing.JLabel();
        txfDate = new javax.swing.JTextField();
        txfLocal = new javax.swing.JTextField();
        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        lblErreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Réservé un local");

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Réservation");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        lblDate.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDate.setText("Date :");

        lblLocal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLocal.setText("Local :");

        lblHeureDebut.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblHeureDebut.setText("Heure début :");

        lblHeureFin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblHeureFin.setText("Heure fin :");

        lblReserve.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblReserve.setText("Réservé à :");

        txfLocal.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${local.numeroLocal}"), txfLocal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenuLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addComponent(lblHeureDebut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfHeureDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHeureFin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfHeureFin, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addComponent(lblLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDate))
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addComponent(lblReserve)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfReserve)))
                .addGap(51, 51, 51))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocal)
                    .addComponent(lblDate)
                    .addComponent(txfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeureFin)
                    .addComponent(txfHeureFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeureDebut)
                    .addComponent(txfHeureDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReserve)
                    .addComponent(txfReserve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setPreferredSize(new java.awt.Dimension(350, 59));
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
        pnlBas.add(lblErreur, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
    mrOk = true;
    ReserverLocaux unReservation;
    unReservation = reserver();
    if(unReservation == null)
    {
        JOptionPane.showMessageDialog(this,"Erreur de réservation de local.");
    }
    else
    {
        if(verifierDoublons(unReservation))
        {
            facadeReserverLocaux.create(unReservation);
            setVisible(false);
        }
        else
        {
            lblErreur.setText("Le local est déjà réservé pour ce moment.");
        }
    }
    
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
     mrOk = false;
     setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Opérations">
    private ReserverLocaux reserver()
    {
        ReserverLocaux unReservation = null;
        String date = txfDate.getText();
        String heureDebut = txfHeureDebut.getText();
        String heureFin = txfHeureFin.getText();
        
        facadeReserverLocaux = fournisseur.obtenirReserverLocauxFacade();
        if(Validation.validerDate(date) && Validation.validerHeure(heureDebut) && Validation.validerHeure(heureFin))
        {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CANADA_FRENCH);
            DateFormat heure = new SimpleDateFormat("kk:mm");
            try
            {
                Date unDate = format.parse(date);
                Date unHeureDebut = heure.parse(heureDebut);
                Date unHeureFin = heure.parse(heureFin);
                String ReserverA = txfReserve.getText();
                unReservation = new ReserverLocaux();
                unReservation.setHeureDebut(unHeureDebut);
                unReservation.setHeureFin(unHeureFin);
                unReservation.setReserverA(ReserverA);
                unReservation.setIdLocauxFK(local);
                unReservation.setDateReservation(unDate);
            }
            catch(ParseException Px)
            {
                lblErreur.setText("Entrer une date (aaaa-mm-jj) ou une heure (hh:mm) valide.");
            }
        }
        else
        {
            lblErreur.setText("Entrer une date (aaaa-mm-jj) ou une heure (hh:mm) valide.");
        }
        return unReservation;
    }
    private boolean verifierDoublons(ReserverLocaux uneReservation)
    {
        boolean valide = true;
        List<ReserverLocaux> lstReserv;
        lstReserv = facadeReserverLocaux.findAll();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CANADA_FRENCH);
        String date1 = format.format(uneReservation.getDateReservation());
        for(ReserverLocaux r:lstReserv)
        {
            String date2 = format.format(r.getDateReservation());
            if(date1.equals(date2))
            {
                if(r.getIdLocauxFK().equals(uneReservation.getIdLocauxFK()))
                {
                    if(compHeureReservation(r,uneReservation))
                    {
                        valide = true;  
                    }
                    else
                    {
                        valide = false;
                    }
                }
                else
                {
                    valide = false;
                }
            }
            else
            {
                valide = false;
            }
        }
        return valide;
    }
    
    private boolean compHeureReservation(ReserverLocaux reserv1,ReserverLocaux reserv2 )
    {
        
        DateFormat heure = new SimpleDateFormat("kk:mm"); 
        String heure1 = heure.format(reserv1.getHeureDebut());
        String heure2 = heure.format(reserv2.getHeureDebut());
        int heureDebut = Integer.parseInt(heure1.substring(0, 2));
        int heureDebutComp = Integer.parseInt(heure2.substring(0, 2));
        
        heure1 = heure.format(reserv1.getHeureFin());
        heure2 = heure.format(reserv2.getHeureFin());
        int heureFin = Integer.parseInt(heure1.substring(0, 2));
        int heureFinComp = Integer.parseInt(heure2.substring(0, 2));
        
        if(heureDebutComp < heureFin)
        {
            lblErreur.setText("Il est impossible de réserver, il y a déjà une réservation présente durant ces heures.");
            return false;
        }
        else if(heureDebut < heureFinComp)
        {
            lblErreur.setText("Il est impossible de réserver, il y a déjà une réservation présente durant ces heures.");
            return false;
        }
        else
        {
            return true;
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
            java.util.logging.Logger.getLogger(DlgReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgReservation dialog = new DlgReservation(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblErreur;
    private javax.swing.JLabel lblHeureDebut;
    private javax.swing.JLabel lblHeureFin;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblReserve;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTextField txfDate;
    private javax.swing.JTextField txfHeureDebut;
    private javax.swing.JTextField txfHeureFin;
    private javax.swing.JTextField txfLocal;
    private javax.swing.JTextField txfReserve;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
    //</editor-fold>
