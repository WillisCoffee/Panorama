package pckDialog;

// William Thibodeau
import ejb.EtudiantFacadeRemote;
import ejb.GroupeFacadeRemote;
import ejb.ListeEtudiantFacadeRemote;
import ejb.PlageHoraireFacadeRemote;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import pckEntites.Etudiant;
import pckEntites.Groupe;
import pckEntites.ListeEtudiant;
import pckEntites.PlageHoraire;
import pckImpressions.ImpressionHoraire;

// Fenêtre servant à voir l'horaire d'un étudiant et importer un horaire
public class DlgHoraire extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="Variables">
        //Lists
    Etudiant unEtudiant;
    List<PlageHoraire> lstPlageHoraire;
    List<Plage> lstPlage;
    
        //Facade
    PlageHoraireFacadeRemote facadePlageHoraire;
    GroupeFacadeRemote facadeGroupe;
    EtudiantFacadeRemote facadeEtudiant;
    ListeEtudiantFacadeRemote facadeListeEtudiant;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Contructeurs">
    public DlgHoraire(java.awt.Frame parent, boolean modal, Etudiant leEtudiant,
                                                   PlageHoraireFacadeRemote fph,
                                                   GroupeFacadeRemote gf,
                                                   EtudiantFacadeRemote ef,
                                                   ListeEtudiantFacadeRemote lef) 
    {
        super(parent, modal);
        unEtudiant = leEtudiant;
        facadePlageHoraire = fph;
        facadeGroupe = gf;
        facadeEtudiant = ef;
        facadeListeEtudiant = lef;
        lstPlage = new ArrayList<>();
        lstPlageHoraire = facadePlageHoraire.findPlageParMatricule(unEtudiant);
        
        initComponents();
        initialiserChamps();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public Etudiant getUnEtudiant() {
        return unEtudiant;
    }

    public void setUnEtudiant(Etudiant unEtudiant) {
        this.unEtudiant = unEtudiant;
    }
    //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoraire = new javax.swing.JTable();
        pnlEtudiant = new javax.swing.JPanel();
        labelPrenom = new javax.swing.JLabel();
        lblPrenom = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        labelMatricule = new javax.swing.JLabel();
        lblMatricule = new javax.swing.JLabel();
        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons = new javax.swing.JPanel();
        btnFermer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnImprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer horaire");

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Gérer horaire");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        tblHoraire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Heure", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoraire.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHoraire);

        pnlEtudiant.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        labelPrenom.setText("Prénom :");

        lblPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.idUtilisateurFK.prenom}"), lblPrenom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        labelNom.setText("Nom :");

        lblNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.idUtilisateurFK.nom}"), lblNom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        labelMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        labelMatricule.setText("Matricule :");

        lblMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.matriculePK}"), lblMatricule, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlEtudiantLayout = new javax.swing.GroupLayout(pnlEtudiant);
        pnlEtudiant.setLayout(pnlEtudiantLayout);
        pnlEtudiantLayout.setHorizontalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEtudiantLayout.createSequentialGroup()
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEtudiantLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNom)
                            .addComponent(labelPrenom)))
                    .addGroup(pnlEtudiantLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelMatricule)))
                .addGap(18, 18, 18)
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrenom)
                    .addComponent(lblNom)
                    .addComponent(lblMatricule))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        pnlEtudiantLayout.setVerticalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEtudiantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrenom)
                    .addComponent(lblPrenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(lblNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricule)
                    .addComponent(labelMatricule))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlEtudiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addComponent(pnlEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setPreferredSize(new java.awt.Dimension(0, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        btnFermer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFermer.setMnemonic('f');
        btnFermer.setText("Fermer");
        btnFermer.setNextFocusableComponent(btnImprimer);
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnFermer);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setMnemonic('i');
        jButton1.setText("Importer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBoutons.add(jButton1);

        btnImprimer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnImprimer.setMnemonic('m');
        btnImprimer.setText("Imprimer");
        btnImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnImprimer);

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimerActionPerformed
        imprimer();
    }//GEN-LAST:event_btnImprimerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers textes (.txt)", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            try
            {
                FileInputStream fstream = new FileInputStream(chooser.getSelectedFile());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;

                while ((strLine = br.readLine()) != null)   
                {
                    String[] uneLigne = strLine.split("/");
                    importerUnEtudiant(uneLigne);
                }

                br.close();
                System.out.println("Importation terminée!");
            }
            catch(Exception e)
            {
                System.out.println("Erreur lors de la lecture du fichier d'horaire d'un étudiant.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Classe">
    class Plage
    {
           private int _debut;
           private int _fin;
           private String _contenu;
           private String _journee;
           
           public Plage(int debut, int fin, String contenu, String journee)
           {
               _debut = debut;
               _fin = fin;
               _contenu = contenu;
               _journee = journee;
           }
           
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Opérations">
    private void importerUnEtudiant(String[] uneLigne)
    {
        Groupe leGroupe = facadeGroupe.findByIdGroupePK(Integer.valueOf(uneLigne[1]));
        Etudiant leEtudiant = facadeEtudiant.findByMatriculePK(uneLigne[0]);
        
        //Nouveau lien entre un groupe et un étudiant
        ListeEtudiant unLien = new ListeEtudiant();
        unLien.setIdGroupeFK(leGroupe);
        unLien.setMatriculeFK(leEtudiant);
        
        try
        {
            facadeListeEtudiant.create(unLien);
        }
        catch(Exception e)
        {
            System.out.println("Erreur lors de l'ajout d'un entité ListeEtudiant.");
        }
        System.out.println("Groupe ajouté à l'étudiant!");
    }
    
    private void initialiserChamps()
    {
        insererHeures();
        insererPlages();
    }
    
    private void insererHeures()
    {
        DefaultTableModel model = (DefaultTableModel)tblHoraire.getModel();

        model.setValueAt("8h",  0, 0);
        model.setValueAt("9h",  1, 0);
        model.setValueAt("10h", 2, 0);
        model.setValueAt("11h", 3, 0);
        model.setValueAt("12h", 4, 0);
        model.setValueAt("13h", 5, 0);
        model.setValueAt("14h", 6, 0);
        model.setValueAt("15h", 7, 0);
        model.setValueAt("16h", 8, 0);
        model.setValueAt("17h", 9, 0);
        model.setValueAt("18h", 10, 0);
        model.setValueAt("19h", 11, 0);
        model.setValueAt("20h", 12, 0);
        model.setValueAt("21h", 13, 0);
        model.setValueAt("22h", 14, 0);
    }
    
    private void insererPlages()
    {
        for (PlageHoraire p : lstPlageHoraire)
        {
            lstPlage.add(creerPlage(p));
        }
        
        for (Plage pl : lstPlage)
        {
            switch(pl._journee)
            {
                case    "Lundi":  insererJournee(1, pl);
                                  break;
                case    "Mardi":  insererJournee(2, pl);
                                  break;
                case "Mercredi":  insererJournee(3, pl);
                                  break;
                case    "Jeudi":  insererJournee(4, pl);
                                  break;
                case "Vendredi":  insererJournee(5, pl);
                                  break;
            }
        }
    }
    
    private void insererJournee(int colonne, Plage laPlage)
    {
        for (int i = laPlage._debut; i < laPlage._fin; i++)
        {
            tblHoraire.setValueAt(laPlage._contenu, i - 8, colonne);
        }
    }
    
    private Plage creerPlage(PlageHoraire p)
    {
        int debut;
        int fin;
        
        DateFormat sdf = new SimpleDateFormat("kk:mm:ss");
        String dateTempo = sdf.format(p.getHeureDebut());
        debut = Integer.parseInt(dateTempo.substring(0, 2));
        
        dateTempo = sdf.format(p.getHeureFin());
        fin = Integer.parseInt(dateTempo.substring(0, 2));
        
        Plage unePlage =  new Plage(debut, fin,p.getIdGroupeFK().getIdCoursFK().getNomCours() ,p.getJour());
        return unePlage;
    }
    
    private void imprimer()  //Kathy
    {
        PrintService [] services = PrinterJob.lookupPrintServices();
        
        if (services.length > 0)
        {
            //L'instance de PrinterJob activera le processus d'impression
            PrinterJob job = PrinterJob.getPrinterJob();
            
            
            //Afficher la fenêtre de sélection d'imprimante
            if(job.printDialog())
            {
                //L'instance de PrinterJob ne peut rien faire si on ne lui dit pas ce qu'elle
                //doit imprimer...
                job.setPrintable(new ImpressionHoraire(lstPlageHoraire, unEtudiant));

                try
                {
                    //Lancer l'impression  
                    job.print();
                }

                catch (PrinterException e)
                {
                    e.printStackTrace(System.out);
                }
            }
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
            java.util.logging.Logger.getLogger(DlgHoraire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgHoraire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgHoraire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgHoraire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgHoraire dialog = new DlgHoraire(new javax.swing.JFrame(), true, null, null, null, null, null);
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
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnImprimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMatricule;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel lblMatricule;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlEtudiant;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTable tblHoraire;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>
