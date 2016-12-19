package pckDialog;

// William Thibodeau, Kathy Landry, Samuel Proulx et Jean-Claude Sheehy
import ejb.AdresseFacadeRemote;
import ejb.CegepFacadeRemote;
import ejb.CodePostalFacadeRemote;
import ejb.CoursFacadeRemote;
import ejb.DepartementFacadeRemote;
import ejb.EtudiantFacadeRemote;
import ejb.EvaluationFacadeRemote;
import ejb.GroupeFacadeRemote;
import ejb.ListeEtudiantFacadeRemote;
import ejb.LocauxFacadeRemote;
import ejb.NoteFacadeRemote;
import ejb.PersonnelSoutienFacadeRemote;
import ejb.PlageHoraireFacadeRemote;
import ejb.ProfesseurFacadeRemote;
import ejb.ReserverLocauxFacadeRemote;
import ejb.SessionFacadeRemote;
import ejb.UtilisateurFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.beansbinding.Binding;
import panorama.CoursTempo;
import panorama.EtudiantTempo;
import panorama.GroupeTempo;
import panorama.PersonnelSoutienTempo;
import panorama.ProfesseurTempo;
import pckEntites.Cegep;
import pckEntites.Cours;
import pckEntites.Departement;
import pckEntites.Etudiant;
import pckEntites.Groupe;
import pckEntites.Locaux;
import pckEntites.PersonnelSoutien;
import pckEntites.Professeur;
import pckEntites.Session;
import pckEntites.Utilisateur;
import pckFournisseur.FournisseurServices;
import static pckValidation.Validation.validerAnnee;
import static pckValidation.Validation.validerCours;
import static pckValidation.Validation.validerLocal;
import static pckValidation.Validation.validerMatricule;
import static pckValidation.Validation.validerNoEmploye;
import static pckValidation.Validation.validerNom;
import static pckValidation.Validation.validerNombre;
import static pckValidation.Validation.validerNumDepartement;

public class FrmPanorama extends javax.swing.JFrame 
{
    // <editor-fold defaultstate="collapsed" desc="Variables">
    FournisseurServices fournisseur;
    
    Onglet selectedTab = Onglet.Etudiant; // Onglet sélectionné
 
    //Facades
    UtilisateurFacadeRemote facadeUtilisateur;
    EtudiantFacadeRemote facadeEtudiant;
    ProfesseurFacadeRemote facadeEnseignant;
    PersonnelSoutienFacadeRemote facadePersonnel;
    CoursFacadeRemote facadeCours;
    LocauxFacadeRemote facadeLocaux;
    DepartementFacadeRemote facadeDepartement; 
    SessionFacadeRemote facadeSession;        
    GroupeFacadeRemote facadeGroupe;
    CegepFacadeRemote facadeCegep;
    ListeEtudiantFacadeRemote facadeListeEtudiant;
    AdresseFacadeRemote facadeAdresse;
    CodePostalFacadeRemote facadeCodePostal;
    PlageHoraireFacadeRemote facadePlageHoraire;
    EvaluationFacadeRemote facadeEvaluation;
    NoteFacadeRemote facadeNote;
    ReserverLocauxFacadeRemote facadeReservation;
    
    //Listes
    List<Utilisateur> lstUtilisateur;
    List<Etudiant> lstEtudiant;
    List<Professeur> lstEnseignant;
    List<PersonnelSoutien> lstPersonnel;
    List<Cours> lstCours;
    List<Locaux> lstLocaux;
    List<Session> lstSession;
    List<Groupe> lstGroupe;
    List<Departement> lstDepartement;
    List<Cegep> lstCegep;
    
    //Listes temporaires
    List<EtudiantTempo> lstEtudiantTempo = new ArrayList<>();
    List<ProfesseurTempo> lstEnseignantTempo = new ArrayList<>();
    List<PersonnelSoutienTempo> lstPersonnelSoutienTempo = new ArrayList<>();
    List<GroupeTempo> lstGroupeTempo = new ArrayList<>();
    List<CoursTempo> lstCoursTempo = new ArrayList<>();
    
    private int giPersonneConnecter = 0;
    
    private boolean recherche = false;
    
    private enum Onglet {
        Etudiant,
        Enseignant,
        Personnel,
        Cours,
        Locaux,
        Session,
        Groupes,
        Departement
    } //Valeur des onglets
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructeur">
    public FrmPanorama(FournisseurServices fs)
    {
        fournisseur = fs;
       
        initComponents();
        chargerListe();
        
        setLocationRelativeTo(this);
        //Listener permettant de savoir quel onglet est présentement sélectionné.
        tbpOnglet.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                switch(tbpOnglet.getSelectedIndex())
                {
                    case 0:     selectedTab = Onglet.Etudiant;
                                
                                break;
                    case 1:     selectedTab = Onglet.Enseignant;
                             
                                break;
                    case 2:     selectedTab = Onglet.Personnel;
                                
                                break;
                    case 3:     selectedTab = Onglet.Cours;
                              
                                break;
                    case 4:     selectedTab = Onglet.Locaux;
                      
                                break;
                    case 5:     selectedTab = Onglet.Session;
                            
                                break;
                    case 6:     selectedTab = Onglet.Groupes;
                       
                                break;
                    case 7:     selectedTab = Onglet.Departement;
                               
                                break;            
                }
                GererActions(selectedTab);
            }
        }); 
        
        //Listener permettant de changer les boutons si une ligne est sélectionnée
        ListSelectionListener lsl = new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent lse) 
            {    
                GererActions(selectedTab);
            }
        };
        
        // Ajout du listener à tous les tableaux
        tblEtudiant.getSelectionModel().addListSelectionListener(lsl);
        tblDepartements.getSelectionModel().addListSelectionListener(lsl);
        tblCours.getSelectionModel().addListSelectionListener(lsl);
        tblEnseignant.getSelectionModel().addListSelectionListener(lsl);
        tblGroupe.getSelectionModel().addListSelectionListener(lsl);
        tblLocaux.getSelectionModel().addListSelectionListener(lsl);
        tblPersonnel.getSelectionModel().addListSelectionListener(lsl);
        tblSession.getSelectionModel().addListSelectionListener(lsl);

        GererActions(selectedTab);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Tableaux">
    //Chargement des listes
    private void chargerEtudiant()
    {
        facadeEtudiant = fournisseur.obtenirFacadeEtudiant();
        lstEtudiant = facadeEtudiant.chargerListAdresse();
        remplirListeEtudiantTempo();
    }
    
    private void chargerEnseignant()
    {
        facadeEnseignant = fournisseur.obtenirFacadeEnseignant();
        lstEnseignant = facadeEnseignant.chargerListAdresse();
        remplirListeEnseignantTempo();
    }
    
    private void chargerPersonnel()
    {
        facadePersonnel = fournisseur.obtenirFacadePersonnelSoutien();
        lstPersonnel = facadePersonnel.chargerListAdresse();
        remplirListePersonnelTempo();
    }
    
    private void chargerListeEtudiant()
    {
        facadeListeEtudiant = fournisseur.obtenirListeEtudiantFacade();
    }
    
    private void chargerPlageHoraire()
    {
        facadePlageHoraire = fournisseur.obtenirPlageHoraireFacade();
    }
    
    private void chargerDepartement()
    {
        facadeDepartement = fournisseur.obtenirFacadeDepartement();
        lstDepartement = facadeDepartement.findAll(); 
        remplirListeDepartement();
    }
    private void chargerReservation()
    {
        facadeReservation = fournisseur.obtenirReserverLocauxFacade();
    }
    
    private void chargerUtilisateur()
    {
        facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
        lstUtilisateur = facadeUtilisateur.findAll();
    }
 
    private void chargerLocaux()
    {
        facadeLocaux = fournisseur.obtenirFacadeLocaux();
        lstLocaux = facadeLocaux.findAll();
        remplirListeLocaux();
    }
    
    private void chargerCours()
    {
        facadeCours = fournisseur.obtenirFacadeCours();
        lstCours = facadeCours.findAll(); 
        remplirListeCours();
    }
    
    private void chargerSession()
    {
        facadeSession = fournisseur.obtenirFacadeSession();
        lstSession = facadeSession.findAll();  
        remplirListeSession();
    }
    
    private void chargerGroupe()
    {
        facadeGroupe = fournisseur.obtenirFacadeGroupe();
        lstGroupe = facadeGroupe.findAll();
        remplirListeGroupe();
    }
    
    private void chargerCegep()
    {
        facadeCegep = fournisseur.obtenirFacadeCegep();
        lstCegep = facadeCegep.findAll();
    }
    
    private void chargerNote()
    {
        facadeNote = fournisseur.obtenirNoteFacade();
    }
    
    private void chargerEvaluation()
    {
        facadeEvaluation = fournisseur.obtenirEvaluationFacade();
    }
    
    //remplissage des listes de classes temporaire.
    private void remplirListeEnseignantTempo()
    {
        lstEnseignantTempo.clear();
        for (Professeur unProf : lstEnseignant)
        {
            Utilisateur unUtilisateur = facadeUtilisateur.findByIdUtilisateurPK(unProf.getIdUtilisateurFK());
            Departement unDepartement = facadeDepartement.findByIdDepartementPK(unProf.getIdDepartementFK());
            ProfesseurTempo unProfTempo = new ProfesseurTempo(unUtilisateur.getNom(),unUtilisateur.getPrenom(), 
                                              unProf.getNumeroEmployePK(),unDepartement.getNomDep());
            lstEnseignantTempo.add(unProfTempo);
        }
        Binding bindingEnseignant = bindingGroup.getBinding("bindEnseignant");
        bindingEnseignant.unbind();
        bindingEnseignant.bind();        
    }
    
    private void remplirListeEtudiantTempo()
    {
        lstEtudiantTempo.clear();
        for (Etudiant unEtudiant : lstEtudiant)
        {
            Utilisateur unUtilisateur = facadeUtilisateur.findByIdUtilisateurPK(unEtudiant.getIdUtilisateurFK());
            EtudiantTempo unEtudiantTempo = new EtudiantTempo(unUtilisateur.getNom(),unUtilisateur.getPrenom(),
                                                    unEtudiant.getMatriculePK(),unEtudiant.getCodePermanent());
            lstEtudiantTempo.add(unEtudiantTempo);  
        } 
        Binding bindingEtudiant = bindingGroup.getBinding("bindEtudiant");
        bindingEtudiant.unbind();
        bindingEtudiant.bind();
    }
    
     private void remplirListePersonnelTempo()
     {
        lstPersonnelSoutienTempo.clear();
        for (PersonnelSoutien unPersonnel : lstPersonnel)
        {
            Utilisateur unUtilisateur = facadeUtilisateur.findByIdUtilisateurPK(unPersonnel.getIdUtilisateurFK());
            PersonnelSoutienTempo unPersonnelTempo = new  PersonnelSoutienTempo(unUtilisateur.getNom(),
                                                          unUtilisateur.getPrenom(),unPersonnel.getNumeroPersonnelPK(),unPersonnel.getFonction());
            lstPersonnelSoutienTempo.add(unPersonnelTempo);
        }  
        Binding bindingSoutien = bindingGroup.getBinding("bindPersonnel");
        bindingSoutien.unbind();
        bindingSoutien.bind();
     }
     
     private void remplirListeCours()
     {
        lstCoursTempo.clear();   
        for (Cours unCours : lstCours)
        {
            Departement unDepartement = facadeDepartement.findByIdDepartementPK(unCours.getIdDepartementFK());
            CoursTempo unCoursTempo = new CoursTempo(unDepartement.getNomDep(), unCours.getNomCours(), 
                                            String.valueOf(unCours.getNumeroCours()));
            lstCoursTempo.add(unCoursTempo);
        }
        Binding bindingCours = bindingGroup.getBinding("bindCours");
        bindingCours.unbind();
        bindingCours.bind();
     }
     
     private void remplirListeGroupe()
     {
        lstGroupeTempo.clear();
        for (Groupe unGroupe : lstGroupe)
        {
            Utilisateur unProf = facadeUtilisateur.findByIdUtilisateurPK(unGroupe.getProfesseurFK().getIdUtilisateurFK());
            Cours unCours = facadeCours.findByIdCoursFK(unGroupe.getIdCoursFK());
            GroupeTempo unGroupeTempo = new GroupeTempo(unGroupe.getIdGroupePK().toString(),
                                            unProf.getPrenom()+" "+unProf.getNom(),unCours.getNomCours());
            lstGroupeTempo.add(unGroupeTempo);
        }
        Binding bindingGroupe = bindingGroup.getBinding("bindGroupe");
        bindingGroupe.unbind();
        bindingGroupe.bind();
     }
     
     private void remplirListeDepartement()
     {
        Binding bindingDepart = bindingGroup.getBinding("bindDepartement");
        bindingDepart.unbind();
        bindingDepart.bind();
     }
     private void remplirListeSession()
     {
        Binding bindingSession = bindingGroup.getBinding("bindSession");
        bindingSession.unbind();
        bindingSession.bind();
     }
     private void remplirListeLocaux()
     {
        Binding bindingLocaux = bindingGroup.getBinding("bindLocaux");
        bindingLocaux.unbind();
        bindingLocaux.bind();
     }
    //Chargement de toute les liste.
    private void chargerListe()
    {
        chargerUtilisateur();
        chargerEtudiant();
        chargerPersonnel();
        chargerLocaux();
        chargerSession();
        chargerDepartement();
        chargerEnseignant();
        chargerCours();
        chargerGroupe();
        chargerCegep();
        chargerListeEtudiant();
        chargerPlageHoraire();
        chargerNote();
        chargerEvaluation();
        chargerReservation();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getter / setter">
    public List<CoursTempo> getLstCoursTempo() {
        return lstCoursTempo;
    }

    public void setLstCoursTempo(List<CoursTempo> lstCoursTempo) {
        this.lstCoursTempo = lstCoursTempo;
    }
    
    public List<Etudiant> getLstEtudiant() {
        return lstEtudiant;
    }

    public void setLstEtudiant(List<Etudiant> lstEtudiant) {
        this.lstEtudiant = lstEtudiant;
    }

    public List<Professeur> getLstEnseignant() {
        return lstEnseignant;
    }

    public void setLstEnseignant(List<Professeur> lstEnseignant) {
        this.lstEnseignant = lstEnseignant;
    }

    public List<PersonnelSoutien> getLstPersonnel() {
        return lstPersonnel;
    }

    public void setLstPersonnel(List<PersonnelSoutien> lstPersonnel) {
        this.lstPersonnel = lstPersonnel;
    }

    public List<Cours> getLstCours() {
        return lstCours;
    }

    public void setLstCours(List<Cours> lstCours) {
        this.lstCours = lstCours;
    }

    public List<Locaux> getLstLocaux() {
        return lstLocaux;
    }

    public void setLstLocaux(List<Locaux> lstLocaux) {
        this.lstLocaux = lstLocaux;
    }

    public List<Session> getLstSession() {
        return lstSession;
    }

    public void setLstSession(List<Session> lstSession) {
        this.lstSession = lstSession;
    }

    public List<Groupe> getLstGroupe() {
        return lstGroupe;
    }

    public void setLstGroupe(List<Groupe> lstGroupe) {
        this.lstGroupe = lstGroupe;
    }

    public List<Departement> getLstDepartement() {
        return lstDepartement;
    }

    public void setLstDepartement(List<Departement> lstDepartement) {
        this.lstDepartement = lstDepartement;
    }

    public List<EtudiantTempo> getLstEtudiantTempo() {
        return lstEtudiantTempo;
    }

    public void setLstEtudiantTempo(List<EtudiantTempo> lstEtudiantTempo) {
        this.lstEtudiantTempo = lstEtudiantTempo;
        
    }

    public List<ProfesseurTempo> getLstEnseignantTempo() {
        return lstEnseignantTempo;
    }

    public void setLstEnseignantTempo(List<ProfesseurTempo> lstEnseignantTempo) {
        this.lstEnseignantTempo = lstEnseignantTempo;
    }

    public List<PersonnelSoutienTempo> getLstPersonnelSoutienTempo() {
        return lstPersonnelSoutienTempo;
    }

    public void setLstPersonnelSoutienTempo(List<PersonnelSoutienTempo> lstPersonnelSoutienTempo) {
        this.lstPersonnelSoutienTempo = lstPersonnelSoutienTempo;
    }

    public List<GroupeTempo> getLstGroupeTempo() {
        return lstGroupeTempo;
    }

    public void setLstGroupeTempo(List<GroupeTempo> lstGroupeTempo) {
        this.lstGroupeTempo = lstGroupeTempo;
    }

    public int getGiPersonneConnecter() {
        return giPersonneConnecter;
    }

    public void setGiPersonneConnecter(int giPersonneConnecter) {
        this.giPersonneConnecter = giPersonneConnecter;
    }
    
    
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlDroit = new javax.swing.JPanel();
        pnlRecherche = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        lblCritere1 = new javax.swing.JLabel();
        lblCritere2 = new javax.swing.JLabel();
        lblCritere3 = new javax.swing.JLabel();
        txfCritere1 = new javax.swing.JTextField();
        txfCritere2 = new javax.swing.JTextField();
        txfCritere3 = new javax.swing.JTextField();
        btnRechercher = new javax.swing.JButton();
        btnReinitialiser = new javax.swing.JButton();
        pnlOperation = new javax.swing.JPanel();
        btnAjouter = new javax.swing.JButton();
        btnGerer = new javax.swing.JButton();
        btnReservation = new javax.swing.JButton();
        btnHoraire = new javax.swing.JButton();
        btnResultat = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        pnlStatusBar = new javax.swing.JPanel();
        tbpOnglet = new javax.swing.JTabbedPane();
        pnlEtudiant = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEtudiant = new javax.swing.JTable();
        pnlEnseignant = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnseignant = new javax.swing.JTable();
        pnlPersonnel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPersonnel = new javax.swing.JTable();
        pnlCours = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCours = new javax.swing.JTable();
        pnlLocaux = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLocaux = new javax.swing.JTable();
        pnlSession = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSession = new javax.swing.JTable();
        pnlGroupe = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblGroupe = new javax.swing.JTable();
        pnlDepartement = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDepartements = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        mnfichier = new javax.swing.JMenu();
        mniQuitter = new javax.swing.JMenuItem();
        mniDeconnexion = new javax.swing.JMenuItem();
        mnAction = new javax.swing.JMenu();
        mniAjouter = new javax.swing.JMenuItem();
        mniModifier = new javax.swing.JMenuItem();
        mniSupprimer = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniResultat = new javax.swing.JMenuItem();
        mniHoraire = new javax.swing.JMenuItem();
        mniGerer = new javax.swing.JMenuItem();
        mniReservation = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniRechercher = new javax.swing.JMenuItem();
        mniReinitialiser = new javax.swing.JMenuItem();
        mnNavigation = new javax.swing.JMenu();
        mniEtudiant = new javax.swing.JMenuItem();
        mniEnseignant = new javax.swing.JMenuItem();
        mniPersonnel = new javax.swing.JMenuItem();
        mniCours = new javax.swing.JMenuItem();
        mniLocaux = new javax.swing.JMenuItem();
        mniSession = new javax.swing.JMenuItem();
        mniGroupes = new javax.swing.JMenuItem();
        mniDepartements = new javax.swing.JMenuItem();
        mnAide = new javax.swing.JMenu();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panorama");
        setMinimumSize(new java.awt.Dimension(800, 600));

        pnlDroit.setPreferredSize(new java.awt.Dimension(300, 296));

        pnlRecherche.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Recherche :");

        lblCritere1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCritere1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCritere1.setText("Critère 1 :");

        lblCritere2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCritere2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCritere2.setText("Critère 2 :");

        lblCritere3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCritere3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCritere3.setText("Critère 3 :");

        txfCritere1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfCritere1.setPreferredSize(new java.awt.Dimension(100, 25));

        txfCritere2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfCritere2.setPreferredSize(new java.awt.Dimension(100, 25));

        txfCritere3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfCritere3.setPreferredSize(new java.awt.Dimension(100, 25));

        btnRechercher.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnRechercher.setText("Rechercher");
        btnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherActionPerformed(evt);
            }
        });

        btnReinitialiser.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnReinitialiser.setText("Réinitialiser");
        btnReinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReinitialiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRechercheLayout = new javax.swing.GroupLayout(pnlRecherche);
        pnlRecherche.setLayout(pnlRechercheLayout);
        pnlRechercheLayout.setHorizontalGroup(
            pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRechercheLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRechercheLayout.createSequentialGroup()
                        .addComponent(lblCritere1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCritere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRechercheLayout.createSequentialGroup()
                        .addComponent(lblCritere2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCritere2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRechercheLayout.createSequentialGroup()
                        .addComponent(lblCritere3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCritere3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRechercheLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReinitialiser)))
                .addContainerGap())
            .addGroup(pnlRechercheLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblTitre)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlRechercheLayout.setVerticalGroup(
            pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRechercheLayout.createSequentialGroup()
                .addComponent(lblTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCritere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCritere1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCritere2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCritere2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCritere3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCritere3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnlRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechercher)
                    .addComponent(btnReinitialiser))
                .addContainerGap())
        );

        pnlOperation.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlOperation.setLayout(new java.awt.GridBagLayout());

        btnAjouter.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.setPreferredSize(new java.awt.Dimension(110, 25));
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnAjouter, gridBagConstraints);

        btnGerer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnGerer.setText("Gérer");
        btnGerer.setPreferredSize(new java.awt.Dimension(110, 25));
        btnGerer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGererActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnGerer, gridBagConstraints);

        btnReservation.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnReservation.setText("Réservation");
        btnReservation.setPreferredSize(new java.awt.Dimension(110, 25));
        btnReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnReservation, gridBagConstraints);

        btnHoraire.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnHoraire.setText("Horaire");
        btnHoraire.setPreferredSize(new java.awt.Dimension(110, 25));
        btnHoraire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoraireActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnHoraire, gridBagConstraints);

        btnResultat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnResultat.setText("Résultats");
        btnResultat.setPreferredSize(new java.awt.Dimension(110, 25));
        btnResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnResultat, gridBagConstraints);

        btnModifier.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.setPreferredSize(new java.awt.Dimension(110, 25));
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnModifier, gridBagConstraints);

        btnSupprimer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setPreferredSize(new java.awt.Dimension(110, 25));
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlOperation.add(btnSupprimer, gridBagConstraints);

        javax.swing.GroupLayout pnlDroitLayout = new javax.swing.GroupLayout(pnlDroit);
        pnlDroit.setLayout(pnlDroitLayout);
        pnlDroitLayout.setHorizontalGroup(
            pnlDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDroitLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRecherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        pnlDroitLayout.setVerticalGroup(
            pnlDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDroitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDroit, java.awt.BorderLayout.LINE_END);

        pnlStatusBar.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 16)); // NOI18N
        pnlStatusBar.setPreferredSize(new java.awt.Dimension(910, 40));

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(pnlStatusBar, java.awt.BorderLayout.PAGE_END);

        tbpOnglet.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tbpOnglet.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 16)); // NOI18N
        tbpOnglet.setPreferredSize(new java.awt.Dimension(200, 356));

        pnlEtudiant.setPreferredSize(new java.awt.Dimension(200, 351));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstEtudiantTempo}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblEtudiant, "bindEtudiant");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codePermanent_}"));
        columnBinding.setColumnName("Code permanent");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${matricule_}"));
        columnBinding.setColumnName("Matricule");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom_}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prenom_}"));
        columnBinding.setColumnName("Prénom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblEtudiant);

        javax.swing.GroupLayout pnlEtudiantLayout = new javax.swing.GroupLayout(pnlEtudiant);
        pnlEtudiant.setLayout(pnlEtudiantLayout);
        pnlEtudiantLayout.setHorizontalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlEtudiantLayout.setVerticalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Étudiants", pnlEtudiant);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstEnseignantTempo}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblEnseignant, "bindEnseignant");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${departement_}"));
        columnBinding.setColumnName("Département");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noEmploye_}"));
        columnBinding.setColumnName("No employé");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom_}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prenom_}"));
        columnBinding.setColumnName("Prénom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tblEnseignant);

        javax.swing.GroupLayout pnlEnseignantLayout = new javax.swing.GroupLayout(pnlEnseignant);
        pnlEnseignant.setLayout(pnlEnseignantLayout);
        pnlEnseignantLayout.setHorizontalGroup(
            pnlEnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlEnseignantLayout.setVerticalGroup(
            pnlEnseignantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnseignantLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbpOnglet.addTab("Enseignants", pnlEnseignant);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstPersonnelSoutienTempo}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblPersonnel, "bindPersonnel");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noEmploye_}"));
        columnBinding.setColumnName("No employé");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fonction_}"));
        columnBinding.setColumnName("Fonction");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom_}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prenom_}"));
        columnBinding.setColumnName("Prénom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(tblPersonnel);

        javax.swing.GroupLayout pnlPersonnelLayout = new javax.swing.GroupLayout(pnlPersonnel);
        pnlPersonnel.setLayout(pnlPersonnelLayout);
        pnlPersonnelLayout.setHorizontalGroup(
            pnlPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlPersonnelLayout.setVerticalGroup(
            pnlPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Personnel", pnlPersonnel);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstCoursTempo}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblCours, "bindCours");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${departement_}"));
        columnBinding.setColumnName("Département");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero_}"));
        columnBinding.setColumnName("Numéro cours");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titre_}"));
        columnBinding.setColumnName("Titre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(tblCours);

        javax.swing.GroupLayout pnlCoursLayout = new javax.swing.GroupLayout(pnlCours);
        pnlCours.setLayout(pnlCoursLayout);
        pnlCoursLayout.setHorizontalGroup(
            pnlCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlCoursLayout.setVerticalGroup(
            pnlCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Cours", pnlCours);

        tblLocaux.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstLocaux}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblLocaux, "bindLocaux");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroLocal}"));
        columnBinding.setColumnName("Numéro Local");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${reserverA}"));
        columnBinding.setColumnName("Reservé à");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${categorie}"));
        columnBinding.setColumnName("Catégorie");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(tblLocaux);
        if (tblLocaux.getColumnModel().getColumnCount() > 0) {
            tblLocaux.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout pnlLocauxLayout = new javax.swing.GroupLayout(pnlLocaux);
        pnlLocaux.setLayout(pnlLocauxLayout);
        pnlLocauxLayout.setHorizontalGroup(
            pnlLocauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlLocauxLayout.setVerticalGroup(
            pnlLocauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Locaux", pnlLocaux);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstSession}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblSession, "bindSession");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${annee}"));
        columnBinding.setColumnName("Année");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${saison}"));
        columnBinding.setColumnName("Saison");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane8.setViewportView(tblSession);

        javax.swing.GroupLayout pnlSessionLayout = new javax.swing.GroupLayout(pnlSession);
        pnlSession.setLayout(pnlSessionLayout);
        pnlSessionLayout.setHorizontalGroup(
            pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlSessionLayout.setVerticalGroup(
            pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Session", pnlSession);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstGroupeTempo}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblGroupe, "bindGroupe");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero_}"));
        columnBinding.setColumnName("Numéro");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cours_}"));
        columnBinding.setColumnName("Cours");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${professeur_}"));
        columnBinding.setColumnName("Professeur");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane7.setViewportView(tblGroupe);

        javax.swing.GroupLayout pnlGroupeLayout = new javax.swing.GroupLayout(pnlGroupe);
        pnlGroupe.setLayout(pnlGroupeLayout);
        pnlGroupeLayout.setHorizontalGroup(
            pnlGroupeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlGroupeLayout.setVerticalGroup(
            pnlGroupeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Groupes", pnlGroupe);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstDepartement}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblDepartements, "bindDepartement");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomDep}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroDep}"));
        columnBinding.setColumnName("Numéro");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${responsable}"));
        columnBinding.setColumnName("Responsable");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(tblDepartements);

        javax.swing.GroupLayout pnlDepartementLayout = new javax.swing.GroupLayout(pnlDepartement);
        pnlDepartement.setLayout(pnlDepartementLayout);
        pnlDepartementLayout.setHorizontalGroup(
            pnlDepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        pnlDepartementLayout.setVerticalGroup(
            pnlDepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        tbpOnglet.addTab("Départements", pnlDepartement);

        getContentPane().add(tbpOnglet, java.awt.BorderLayout.CENTER);

        mnfichier.setMnemonic('f');
        mnfichier.setText("Fichier");
        mnfichier.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mniQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mniQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/quitter.png"))); // NOI18N
        mniQuitter.setMnemonic('Q');
        mniQuitter.setText("Quitter");
        mniQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuitterActionPerformed(evt);
            }
        });
        mnfichier.add(mniQuitter);

        mniDeconnexion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniDeconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/deconnexion.png"))); // NOI18N
        mniDeconnexion.setMnemonic('D');
        mniDeconnexion.setText("Déconnexion");
        mniDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeconnexionActionPerformed(evt);
            }
        });
        mnfichier.add(mniDeconnexion);

        MenuBar.add(mnfichier);

        mnAction.setMnemonic('A');
        mnAction.setText("Actions");
        mnAction.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mniAjouter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mniAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/ajouter.png"))); // NOI18N
        mniAjouter.setMnemonic('A');
        mniAjouter.setText("Ajouter...");
        mniAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAjouterActionPerformed(evt);
            }
        });
        mnAction.add(mniAjouter);

        mniModifier.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mniModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/modifier.png"))); // NOI18N
        mniModifier.setMnemonic('m');
        mniModifier.setText("Modifier...");
        mniModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniModifierActionPerformed(evt);
            }
        });
        mnAction.add(mniModifier);

        mniSupprimer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/supprimer.png"))); // NOI18N
        mniSupprimer.setMnemonic('s');
        mniSupprimer.setText("Supprimer");
        mniSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSupprimerActionPerformed(evt);
            }
        });
        mnAction.add(mniSupprimer);
        mnAction.add(jSeparator2);

        mniResultat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniResultat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/resultats.png"))); // NOI18N
        mniResultat.setMnemonic('r');
        mniResultat.setText("Résultats...");
        mniResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniResultatActionPerformed(evt);
            }
        });
        mnAction.add(mniResultat);

        mniHoraire.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mniHoraire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/horaire.png"))); // NOI18N
        mniHoraire.setMnemonic('h');
        mniHoraire.setText("Horaire...");
        mniHoraire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHoraireActionPerformed(evt);
            }
        });
        mnAction.add(mniHoraire);

        mniGerer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mniGerer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/gerer.png"))); // NOI18N
        mniGerer.setMnemonic('g');
        mniGerer.setText("Gérer...");
        mniGerer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGererActionPerformed(evt);
            }
        });
        mnAction.add(mniGerer);

        mniReservation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        mniReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/reservation.png"))); // NOI18N
        mniReservation.setMnemonic('v');
        mniReservation.setText("Réservation...");
        mniReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReservationActionPerformed(evt);
            }
        });
        mnAction.add(mniReservation);
        mnAction.add(jSeparator1);

        mniRechercher.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniRechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/rechercher.png"))); // NOI18N
        mniRechercher.setMnemonic('r');
        mniRechercher.setText("Rechercher");
        mniRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRechercherActionPerformed(evt);
            }
        });
        mnAction.add(mniRechercher);

        mniReinitialiser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mniReinitialiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/reinitialiser.png"))); // NOI18N
        mniReinitialiser.setMnemonic('i');
        mniReinitialiser.setText("Réinitialiser");
        mniReinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReinitialiserActionPerformed(evt);
            }
        });
        mnAction.add(mniReinitialiser);

        MenuBar.add(mnAction);

        mnNavigation.setMnemonic('n');
        mnNavigation.setText("Navigation");
        mnNavigation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mniEtudiant.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mniEtudiant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/etudiants.png"))); // NOI18N
        mniEtudiant.setMnemonic('T');
        mniEtudiant.setText("Étudiants");
        mniEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEtudiantActionPerformed(evt);
            }
        });
        mnNavigation.add(mniEtudiant);

        mniEnseignant.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mniEnseignant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/enseignants.png"))); // NOI18N
        mniEnseignant.setMnemonic('e');
        mniEnseignant.setText("Enseignants");
        mniEnseignant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEnseignantActionPerformed(evt);
            }
        });
        mnNavigation.add(mniEnseignant);

        mniPersonnel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mniPersonnel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/personnel.png"))); // NOI18N
        mniPersonnel.setMnemonic('p');
        mniPersonnel.setText("Personnel");
        mniPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPersonnelActionPerformed(evt);
            }
        });
        mnNavigation.add(mniPersonnel);

        mniCours.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mniCours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/cours.png"))); // NOI18N
        mniCours.setMnemonic('c');
        mniCours.setText("Cours");
        mniCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCoursActionPerformed(evt);
            }
        });
        mnNavigation.add(mniCours);

        mniLocaux.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mniLocaux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/locaux.png"))); // NOI18N
        mniLocaux.setMnemonic('l');
        mniLocaux.setText("Locaux");
        mniLocaux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLocauxActionPerformed(evt);
            }
        });
        mnNavigation.add(mniLocaux);

        mniSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mniSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/session.png"))); // NOI18N
        mniSession.setMnemonic('s');
        mniSession.setText("Session");
        mniSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSessionActionPerformed(evt);
            }
        });
        mnNavigation.add(mniSession);

        mniGroupes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mniGroupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/groupe.png"))); // NOI18N
        mniGroupes.setMnemonic('g');
        mniGroupes.setText("Groupes");
        mniGroupes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGroupesActionPerformed(evt);
            }
        });
        mnNavigation.add(mniGroupes);

        mniDepartements.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniDepartements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/departement.png"))); // NOI18N
        mniDepartements.setMnemonic('d');
        mniDepartements.setText("Départements");
        mniDepartements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDepartementsActionPerformed(evt);
            }
        });
        mnNavigation.add(mniDepartements);

        MenuBar.add(mnNavigation);

        mnAide.setMnemonic('i');
        mnAide.setText("Aide");
        mnAide.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mniAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/apropos.png"))); // NOI18N
        mniAbout.setMnemonic('o');
        mniAbout.setText("À propos...");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        mnAide.add(mniAbout);

        MenuBar.add(mnAide);

        setJMenuBar(MenuBar);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // Condition permettant l'ouverture de la bonne fenêtre d'ajout selon l'onglet.
        switch(selectedTab)
        {
            case    Etudiant:  Etudiant unEtudiant = new Etudiant();
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               DlgGererEtudiant dlgEtudiant = new DlgGererEtudiant(this, true, unEtudiant, facadeUtilisateur, facadeCodePostal);
                               dlgEtudiant.setLocationRelativeTo(this);
                               dlgEtudiant.deseactiverChamps(true);
                               dlgEtudiant.setVisible(true);
                               if(dlgEtudiant.isResult())
                               {
                                   facadeEtudiant = fournisseur.obtenirFacadeEtudiant();
                                   facadeEtudiant.create(dlgEtudiant.getUnEtudiant());
                                   facadeAdresse = fournisseur.obtenirFacadeAdresse();
                                   facadeAdresse.create(dlgEtudiant.getAdresse());
                               }
                               chargerEtudiant();
                               break;
            case  Enseignant:  Professeur unProfesseur = new Professeur();
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               facadeDepartement = fournisseur.obtenirFacadeDepartement();
                               DlgGererProfesseur dlgProfesseur = new DlgGererProfesseur(this, true, unProfesseur, lstDepartement, facadeUtilisateur, facadeCodePostal, facadeDepartement);
                               dlgProfesseur.setLocationRelativeTo(this);
                               dlgProfesseur.setVisible(true);
                               if(dlgProfesseur.isResult())
                               {
                                   facadeAdresse = fournisseur.obtenirFacadeAdresse();
                                   facadeAdresse.create(dlgProfesseur.getAdresse());
                                   facadeEnseignant = fournisseur.obtenirFacadeEnseignant();
                                   facadeEnseignant.create(dlgProfesseur.getProfesseur());
                                   
                               }
                               chargerEnseignant();
                               break;
            case   Personnel:  PersonnelSoutien unPersonnel = new PersonnelSoutien();
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               DlgGererPersonnel dlgPersonnel = new DlgGererPersonnel(this, true, unPersonnel, facadeUtilisateur, facadeCodePostal);
                               dlgPersonnel.setLocationRelativeTo(this);
                               dlgPersonnel.setVisible(true);
                               if(dlgPersonnel.isResult())
                               {
                                   facadeAdresse = fournisseur.obtenirFacadeAdresse();
                                   facadeAdresse.create(dlgPersonnel.getAdresse());
                                   facadePersonnel = fournisseur.obtenirFacadePersonnelSoutien();
                                   facadePersonnel.create(dlgPersonnel.getPesonnelSoutien());
                               }
                               chargerPersonnel();
                               break;
            case       Cours:  DlgCours dlgCours = new DlgCours(this, true, lstDepartement);
                               dlgCours.setLocationRelativeTo(this);
                               dlgCours.setVisible(true);
                               if (dlgCours.isResult())
                               {
                                    facadeCours.create(dlgCours.getUnCours());                               
                               }
                               chargerCours();
                               break;
            case      Locaux:  DlgLocaux dlgLocaux = new DlgLocaux(this, true);
                               dlgLocaux.setLocationRelativeTo(this);
                               dlgLocaux.setVisible(true);
                               if (dlgLocaux.isResult())
                               {
                                    facadeLocaux.create(dlgLocaux.getUnLocal());                               
                               }
                               chargerLocaux();
                               break;
            case     Session:  DlgSession dlgSession = new DlgSession(this, true); 
                               dlgSession.setLocationRelativeTo(this); 
                               dlgSession.setVisible(true);// William Thibodeau
                               if (dlgSession.isResult())
                               {
                                    facadeSession.create(dlgSession.getUneSession());                               
                               }
                               chargerSession();
                               break;
            case     Groupes:  DlgGroupe dlgGroupe = new DlgGroupe(this, true,lstDepartement,lstSession, facadeCours, facadeEnseignant);
                               dlgGroupe.setLocationRelativeTo(this);
                               dlgGroupe.setVisible(true);
                               if (dlgGroupe.isResult())
                               {
                                    facadeGroupe.create(dlgGroupe.getUnGroupe());                               
                               }
                               chargerGroupe();
                               break;
            case Departement:  DlgDepartement dlgDepartement = new DlgDepartement(this, true, new Departement());
                               dlgDepartement.setLstCegep(lstCegep);
                               dlgDepartement.setLocationRelativeTo(this);
                               dlgDepartement.setVisible(true);                  // Kathy Landry
                               if (dlgDepartement.isOk())
                               {
                                   facadeDepartement.create(dlgDepartement.getUnDepartement());
                               }
                               chargerDepartement();
                               break;
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // Condition permettant l'ouverture de la bonne fenêtre d'ajout selon l'onglet.
        switch(selectedTab)
        {
            case    Etudiant:  Etudiant unEtudiant = lstEtudiant.get(tblEtudiant.getSelectedRow());
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               facadeAdresse = fournisseur.obtenirFacadeAdresse();
                               facadeEtudiant = fournisseur.obtenirFacadeEtudiant();
                               DlgGererEtudiant dlgEtudiant = new DlgGererEtudiant(this, true, unEtudiant, facadeUtilisateur, facadeCodePostal);
                               dlgEtudiant.setLocationRelativeTo(this);
                               dlgEtudiant.deseactiverChamps(false);
                               dlgEtudiant.setVisible(true);
                               if(dlgEtudiant.isResult())
                               {
                                   facadeCodePostal.edit(dlgEtudiant.getCodePostal());
                                   facadeAdresse.edit(dlgEtudiant.getAdresse());
                                   facadeUtilisateur.edit(dlgEtudiant.getUnUtilisateur());
                                   facadeEtudiant.edit(dlgEtudiant.getUnEtudiant());
                               }
                               chargerEtudiant();
                               break;
            case  Enseignant:  Professeur unProf = lstEnseignant.get(tblEnseignant.getSelectedRow());
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               facadeAdresse = fournisseur.obtenirFacadeAdresse();
                               facadeEnseignant = fournisseur.obtenirFacadeEnseignant();
                               DlgGererProfesseur dlgProfesseur = new DlgGererProfesseur(this, true, unProf, lstDepartement, facadeUtilisateur, facadeCodePostal, facadeDepartement);
                               dlgProfesseur.setLocationRelativeTo(this);
                               dlgProfesseur.setVisible(true);
                               if(dlgProfesseur.isResult())
                               {
                                   facadeCodePostal.edit(dlgProfesseur.getCodePostal());
                                   facadeAdresse.edit(dlgProfesseur.getAdresse());
                                   facadeUtilisateur.edit(dlgProfesseur.getUtilisateur());
                                   facadeEnseignant.edit(dlgProfesseur.getProfesseur());
                               }
                               chargerEnseignant();
                               break;
            case   Personnel:  PersonnelSoutien unPersonnel = lstPersonnel.get(tblPersonnel.getSelectedRow());
                               facadeUtilisateur = fournisseur.obtenirFacadeUtilisateur();
                               facadeCodePostal = fournisseur.obtenirFacadeCodePostal();
                               facadeAdresse = fournisseur.obtenirFacadeAdresse();
                               facadePersonnel = fournisseur.obtenirFacadePersonnelSoutien();
                               DlgGererPersonnel dlgPersonnel = new DlgGererPersonnel(this, true, unPersonnel, facadeUtilisateur, facadeCodePostal);
                               dlgPersonnel.setLocationRelativeTo(this);
                               dlgPersonnel.setVisible(true);
                               if(dlgPersonnel.isResult())
                               {
                                   facadeCodePostal.edit(dlgPersonnel.getCodePostal());
                                   facadeAdresse.edit(dlgPersonnel.getAdresse());
                                   facadeUtilisateur.edit(dlgPersonnel.getUtilisateur());
                                   facadePersonnel.edit(dlgPersonnel.getPesonnelSoutien());
                               }
                               chargerPersonnel();
                               break;
            case       Cours:  DlgCours dlgCours = new DlgCours(this, true, lstCours.get(tblCours.getSelectedRow()), lstDepartement);
                               dlgCours.setLocationRelativeTo(this);
                               dlgCours.setVisible(true);
                               if (dlgCours.isResult())
                               {
                                    facadeCours.edit(dlgCours.getUnCours());
                               }
                               chargerCours();
                               break;
            case      Locaux:  DlgLocaux dlgLocaux = new DlgLocaux(this, true, lstLocaux.get(tblLocaux.getSelectedRow()));
                               dlgLocaux.setLocationRelativeTo(this);
                               dlgLocaux.setVisible(true);
                               if (dlgLocaux.isResult())
                               {
                                   facadeLocaux.edit(dlgLocaux.getUnLocal());
                               }
                               chargerLocaux();
                               break;
            case     Session:  DlgSession dlgSession = new DlgSession(this, true, lstSession.get(tblSession.getSelectedRow())); 
                               dlgSession.setLocationRelativeTo(this);
                               dlgSession.setVisible(true);                      // William Thibodeau
                               if (dlgSession.isResult())
                               {
                                    facadeSession.edit(dlgSession.getUneSession());
                               }
                               chargerSession();
                               break;
            case     Groupes:  DlgGroupe dlgGroupe = new DlgGroupe(this, true, lstGroupe.get(tblGroupe.getSelectedRow()), lstDepartement, lstSession, facadeCours, facadeEnseignant);
                               dlgGroupe.setLocationRelativeTo(this);
                               dlgGroupe.setVisible(true);
                               if (dlgGroupe.isResult())
                               {
                                   facadeGroupe.edit(dlgGroupe.getUnGroupe());
                               }
                               chargerGroupe();
                               break;
            case Departement:  DlgDepartement dlgDepartement = new DlgDepartement(this, true, lstDepartement.get(tblDepartements.getSelectedRow()));
                               dlgDepartement.setLstCegep(lstCegep);
                               dlgDepartement.setLocationRelativeTo(this);
                               dlgDepartement.setVisible(true);                  // Kathy Landry
                               if (dlgDepartement.isOk())
                               {
                                   facadeDepartement.edit(dlgDepartement.getUnDepartement());
                               }
                               chargerDepartement();
                               break;
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    private void mniEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEtudiantActionPerformed
        GererNavigation(Onglet.Etudiant);
    }//GEN-LAST:event_mniEtudiantActionPerformed

    private void mniEnseignantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEnseignantActionPerformed
        GererNavigation(Onglet.Enseignant);
    }//GEN-LAST:event_mniEnseignantActionPerformed

    private void mniPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPersonnelActionPerformed
        GererNavigation(Onglet.Personnel);
    }//GEN-LAST:event_mniPersonnelActionPerformed

    private void mniCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCoursActionPerformed
        GererNavigation(Onglet.Cours);
    }//GEN-LAST:event_mniCoursActionPerformed

    private void mniLocauxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLocauxActionPerformed
        GererNavigation(Onglet.Locaux);
    }//GEN-LAST:event_mniLocauxActionPerformed

    private void mniSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSessionActionPerformed
        GererNavigation(Onglet.Session);
    }//GEN-LAST:event_mniSessionActionPerformed

    private void mniGroupesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGroupesActionPerformed
        GererNavigation(Onglet.Groupes);
    }//GEN-LAST:event_mniGroupesActionPerformed

    private void mniDepartementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDepartementsActionPerformed
        GererNavigation(Onglet.Departement);
    }//GEN-LAST:event_mniDepartementsActionPerformed

    private void mniAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAjouterActionPerformed
        btnAjouter.doClick();
    }//GEN-LAST:event_mniAjouterActionPerformed

    private void mniModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModifierActionPerformed
       
        btnModifier.doClick();
        
    }//GEN-LAST:event_mniModifierActionPerformed

    private void mniSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSupprimerActionPerformed
        btnSupprimer.doClick();
    }//GEN-LAST:event_mniSupprimerActionPerformed

    private void mniResultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniResultatActionPerformed
        btnResultat.doClick();
    }//GEN-LAST:event_mniResultatActionPerformed

    private void mniHoraireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHoraireActionPerformed
        btnHoraire.doClick();
    }//GEN-LAST:event_mniHoraireActionPerformed

    private void mniGererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGererActionPerformed
        btnGerer.doClick();
    }//GEN-LAST:event_mniGererActionPerformed

    private void mniReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReservationActionPerformed
        btnReservation.doClick();
    }//GEN-LAST:event_mniReservationActionPerformed

    private void mniRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRechercherActionPerformed
        btnRechercher.doClick();
    }//GEN-LAST:event_mniRechercherActionPerformed

    private void btnGererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGererActionPerformed
        switch(selectedTab)
        {
            case    Groupes:    DlgGererGroupe2 dlgGererGroupe = new DlgGererGroupe2(this, true, lstGroupe.get(tblGroupe.getSelectedRow()), facadeEtudiant, fournisseur);
                                dlgGererGroupe.setLocationRelativeTo(this);
                                dlgGererGroupe.setVisible(true);
                                break;
            case   Etudiant:    DlgAbsence dlgAbsenceEtudiant = new DlgAbsence(this, true,lstEtudiant.get(tblEtudiant.getSelectedRow()),facadePlageHoraire,facadeListeEtudiant);
                                dlgAbsenceEtudiant.setLocationRelativeTo(this);
                                dlgAbsenceEtudiant.setVisible(true);
//                                if(dlgAbsenceEtudiant.isOk)
//                                {
//                                    
//                                }
                                break;
            case Enseignant:    DlgAbsence dlgAbsenceEnseignant = new DlgAbsence(this, true,lstEnseignant.get(tblEnseignant.getSelectedRow()),facadePlageHoraire,fournisseur);
                                dlgAbsenceEnseignant.setLocationRelativeTo(this);
                                dlgAbsenceEnseignant.setVisible(true);
                                break;
            case Locaux:        DlgGererReservation dlgReservation = new DlgGererReservation(this,true,facadeReservation);
                                dlgReservation.setLocationRelativeTo(this);
                                dlgReservation.setVisible(true);
        }
    }//GEN-LAST:event_btnGererActionPerformed

    private void btnResultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultatActionPerformed
        DlgResultat2 dlgResultat = new DlgResultat2(this, true, lstEtudiant.get(tblEtudiant.getSelectedRow()), facadeNote, facadeListeEtudiant, facadeEvaluation);
        dlgResultat.setLocationRelativeTo(this);
        dlgResultat.setVisible(true);
    }//GEN-LAST:event_btnResultatActionPerformed

    private void btnReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationActionPerformed
        DlgReservation dlgReservation = new DlgReservation(this, true,lstLocaux.get(tblLocaux.getSelectedRow()),fournisseur);
        dlgReservation.setLocationRelativeTo(this);
        dlgReservation.setVisible(true);
        if(dlgReservation.mrOk)
        {
            Binding bind = bindingGroup.getBinding("bindLocaux");
            bind.unbind();
            bind.bind();
        }
    }//GEN-LAST:event_btnReservationActionPerformed

    private void btnHoraireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoraireActionPerformed
        switch(selectedTab)
        {
            case    Etudiant:   DlgHoraire dlgHoraire = new DlgHoraire(this, true, lstEtudiant.get(tblEtudiant.getSelectedRow()), facadePlageHoraire, facadeGroupe, facadeEtudiant, facadeListeEtudiant);
                                dlgHoraire.setLocationRelativeTo(this);
                                dlgHoraire.setVisible(true);
                                break;
            case     Groupes:   DlgGroupeHoraire dlgGrpHoraire = new DlgGroupeHoraire(this, true, lstGroupe.get(tblGroupe.getSelectedRow()),
                                                                                facadeLocaux, facadePlageHoraire, facadeGroupe);
                                dlgGrpHoraire.setLocationRelativeTo(this);
                                dlgGrpHoraire.setVisible(true);
                                break;
        }
        
    }//GEN-LAST:event_btnHoraireActionPerformed

    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        DlgAbout dlgAbout = new DlgAbout(this, true);
        dlgAbout.setLocationRelativeTo(this);
        dlgAbout.setVisible(true);
    }//GEN-LAST:event_mniAboutActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // Condition permettant la suppression du bon élément sélectionné
        if (JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer la sélection ?", "Supprimer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            switch(selectedTab)
            {
            case    Etudiant:  facadeEtudiant.remove(lstEtudiant.get(tblEtudiant.getSelectedRow()));
                               chargerEtudiant();
                               break;
            case  Enseignant:  facadeEnseignant.remove(lstEnseignant.get(tblEnseignant.getSelectedRow()));
                               chargerEnseignant();
                               break;
            case   Personnel:  facadePersonnel.remove(lstPersonnel.get(tblPersonnel.getSelectedRow()));
                               chargerPersonnel();
                               break;
            case       Cours:  facadeCours.remove(lstCours.get(tblCours.getSelectedRow()));
                               chargerCours();
                               break;
            case      Locaux:  facadeLocaux.remove(lstLocaux.get(tblLocaux.getSelectedRow()));
                               chargerLocaux();
                               break;
            case     Session:  facadeSession.remove(lstSession.get(tblSession.getSelectedRow()));
                               chargerSession();
                               break;
            case     Groupes:  facadeGroupe.remove(lstGroupe.get(tblGroupe.getSelectedRow()));
                               chargerGroupe();
                               break;
            case Departement:  facadeDepartement.remove(lstDepartement.get(tblDepartements.getSelectedRow()));
                               chargerDepartement();
                               break;
            }
        }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnReinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReinitialiserActionPerformed
        // Réinitialise la liste de l'onglet sélectionné.
        txfCritere1.setText("");
        txfCritere2.setText("");
        txfCritere3.setText("");
        if(recherche)
        {    
            switch(selectedTab)
            {
                case    Etudiant:  chargerEtudiant();
                                   break;
                case  Enseignant:  chargerEnseignant();
                                   break;
                case   Personnel:  chargerPersonnel();
                                   break;
                case       Cours:  chargerCours();
                                   break;
                case      Locaux:  chargerLocaux();
                                   break;
                case     Session:  chargerSession();
                                   break;
                case     Groupes:  chargerGroupe();
                                   break;
                case Departement:  chargerDepartement();
                                   break;
            }
        recherche = false;    
        }
    }//GEN-LAST:event_btnReinitialiserActionPerformed

    private void mniQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuitterActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ?", "Quitter", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_mniQuitterActionPerformed

    private void mniReinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReinitialiserActionPerformed
        btnReinitialiser.doClick();
    }//GEN-LAST:event_mniReinitialiserActionPerformed

    private void mniDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeconnexionActionPerformed
        // TODO add your handling code here:

        DlgConnexion dlgConnexion = new DlgConnexion(this, recherche, fournisseur);
        dlgConnexion.setLocationRelativeTo(this);
//        dlgConnexion.setVisible(true);
        this.setEnabled(false);
        dlgConnexion.show();
        if(dlgConnexion.isModal())
        {
            this.setEnabled(true);
            gererDroitAcces();
        }
    }//GEN-LAST:event_mniDeconnexionActionPerformed

    private void btnRechercherActionPerformed(java.awt.event.ActionEvent evt) 
    {
       gererRecherche();
       recherche = true;
       
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Recherche">
    private void gererRecherche()
    {
        switch(selectedTab)
        {
            case Etudiant : rechercheEtudiant();
                            break;
            case Enseignant: rechercheEnseignant();
                             break;
            case Personnel: recherchePersonnel();
                            break;
            case Cours: rechercheCours();
                        break;
            case Locaux: rechercheLocaux();
                        break;
            case Session: rechercheSession();
                           break;
            case Groupes: rechercheGroupe();
                          break;                   
            case Departement: rechercheDepartement();
                                break;
        }
           
    }
    private boolean validerNomP(String nom)
    {
        if(!validerNom(nom))
        {
            JOptionPane.showMessageDialog(this,"Entrer un nom valide."); 
            return false;
        }
        else 
        {
            return true;
        }
    }
    private boolean validerMat(String mat)
    {
        if(!validerMatricule(mat))
        {
            JOptionPane.showMessageDialog(this,"Entrer un matricule valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validerNumEmp(String noEmp)
    {
        if(!validerNoEmploye(noEmp))
        {
            JOptionPane.showMessageDialog(this,"Entrer un numéro d'employé valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validerNumCours(String cours)
    {
        if(!validerCours(cours))
        {
            JOptionPane.showMessageDialog(this,"Entrer un numéro de cours valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validerLocaux(String local)
    {
        if(!validerLocal(local))
        {
            JOptionPane.showMessageDialog(this,"Entrer un numéro de local valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validerAnne(String annee)
    {
        if(!validerAnnee(annee))
        {
            JOptionPane.showMessageDialog(this,"Entrer une année valide.");
            return false;
        }
        else 
        {
            return true;
        }
    }
    private boolean validerNumGroupe(String numGroupe)
    {
        if(!validerNombre(numGroupe))
        {
            JOptionPane.showMessageDialog(this,"Entrer un numéro de groupe valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validerNumDep(String nomDep)
    {
        if(!validerNumDepartement(nomDep))
        {
            JOptionPane.showMessageDialog(this,"Entrer un numéro de département valide.");
            return false;
        }
        else
        {
            return true;
        }
    }
   // Module de recherche d'un etudiant
    private void rechercheEtudiant()
    {
        String nom = txfCritere1.getText();
        String prenom = txfCritere2.getText();
        String matricule= txfCritere3.getText();
        boolean champValide;
      
            if((nom.length() ==0) && (prenom.length()==0))
            {
                champValide = validerMat(matricule);
                if(champValide)
                {
                    lstEtudiant.clear();
                    Etudiant et = facadeEtudiant.findByMatriculePK(matricule);
                    if(lstEtudiant.get(0) == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun étudiant n'a été trouvé.");
                        chargerEtudiant();
                    }
                    else
                        {
                            lstEtudiant.add(et);
                        }
                }
            }
            else if((nom.length() !=0) && (prenom.length()!=0))
            {
                //Recherche selon le nom et le prenom
                if(matricule.length() !=0)
                {
                    champValide = validerMat(matricule);
                    if(champValide)
                    {
                        lstEtudiant.clear();
                        lstEtudiant.add(facadeEtudiant.findByMatriculePK(matricule));
                        Etudiant et = facadeEtudiant.findByMatriculePK(matricule);
                        if(lstEtudiant.get(0) == null)
                        {
                            JOptionPane.showMessageDialog(this,"Aucun étudiant n'a été trouvé.");
                            chargerEtudiant();
                        }
                        else
                        {
                            lstEtudiant.add(et);
                        }
                    }
                }
                else
                {   
                    champValide = validerNomP(nom);
                    if(champValide)
                    {
                        champValide = validerNomP(prenom);
                    }
                    if(champValide)
                    {
                        //Recherche d'un etudiant par nom et prenom
                        lstEtudiant.clear();
                        lstEtudiant = facadeEtudiant.findByNomPrenom(nom,prenom);   
                         if( lstEtudiant.isEmpty())
                        {
                            JOptionPane.showMessageDialog(this,"Aucun étudiant n'a été trouvé.");
                            chargerEtudiant();
                        }
                    }
                }    
            }    
            else if((nom.length()==0) && (prenom.length()!=0))
            {
                champValide = validerNomP(prenom);
                if(champValide)
                {
                    lstEtudiant.clear();
                    lstEtudiant = facadeEtudiant.findByPrenom(prenom);
                     if( lstEtudiant.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucun étudiant n'a été trouvé.");
                        chargerEtudiant();
                    }
                }
            }    
            else if((nom.length()!=0) && (prenom.length()==0))
            {
                champValide = validerNomP(nom);
                if(champValide)
                {
                    lstEtudiant.clear();
                    lstEtudiant = facadeEtudiant.findByNom(nom);
                     if( lstEtudiant.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucun étudiant n'a été trouvé.");
                        chargerEtudiant();
                    }
                }   
            }    
            else
            {
                JOptionPane.showMessageDialog(this,"Entrez un nom, un prénom ou un matricule.");
            }
            remplirListeEtudiantTempo();
    }    
    //Module de recherche d'un enseignant
    private void rechercheEnseignant()
    {
        String nom = txfCritere1.getText();
        String prenom = txfCritere2.getText();
        String noEmploye= txfCritere3.getText();
        boolean champValide;
        if((nom.length() ==0) && (prenom.length()==0))
        {
            if(noEmploye.length()==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez un nom, un prenom ou un numéro d'employé.");
            }
            else
            {
                champValide = validerNumEmp(noEmploye);
                if(champValide)
                {
                    //Recherche selon le numéro d'employé
                    lstEnseignant.clear();
                    Professeur pr = facadeEnseignant.findByNumeroEmployePK(noEmploye); 
                    if(pr == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun enseignant n'a été trouvé.");
                        chargerEnseignant();
                    }
                    else
                    {
                        lstEnseignant.add(pr);
                    }        
                }
            }    
        }
        else if((nom.length() !=0) && (prenom.length()!=0))
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                champValide = validerNomP(prenom);
            }
            if(champValide)
            {
                //Recherche selon le nom et le prenom
                lstEnseignant.clear();
                lstEnseignant = facadeEnseignant.findByNomPrenom(nom,prenom);
                if( lstEnseignant.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucun enseignant n'a été trouvé.");
                        chargerEnseignant();
                    }
            }    
        }
        else if((nom.length()==0) && (prenom.length()!=0))
        {
            champValide = validerNomP(prenom);
            if(champValide)
            {
                //Recherche selon le prenom
                lstEnseignant.clear();
                lstEnseignant = facadeEnseignant.findByPrenom(prenom);
                if(lstEnseignant.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun enseignant n'a été trouvé.");
                    chargerEnseignant();
                }
            }
        }    
        else if((nom.length()!=0) && (prenom.length()==0))
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                //Recherche selon le nom
                lstEnseignant.clear();
                lstEnseignant = facadeEnseignant.findByNom(nom);
                if(lstEnseignant.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun enseignant n'a été trouvé.");
                    chargerEnseignant();
                }
            }
        }
        else
        {
            champValide = validerNumEmp(noEmploye);
            if(champValide)
            {
                //Si les 3 champ son remplis recherche par le numéro d'employe
                lstEnseignant.clear();
                Professeur pr = facadeEnseignant.findByNumeroEmployePK(noEmploye); 
                    if(pr == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun enseignant n'a été trouvé.");
                        chargerEnseignant();
                    }
                    else
                    {
                        lstEnseignant.add(pr);
                    } 
            }
        }    
        remplirListeEnseignantTempo();    
    }
    // Module de recherche d'un membre du personnel
    private void recherchePersonnel()
    {
           String nom = txfCritere1.getText();
        String prenom = txfCritere2.getText();
        String noEmploye= txfCritere3.getText();
        boolean champValide;
        if((nom.length() ==0) && (prenom.length()==0))
        {
            if(noEmploye.length()==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez un nom, un prenom ou un numéro d'employé.");
            }
            else
            {
                champValide = validerNumEmp(noEmploye);
                if(champValide)
                {
                    //Recherche selon le numéro d'employé
                    lstPersonnel.clear();
                    PersonnelSoutien ps = facadePersonnel.findByNumeroEmployePK(noEmploye); 
                    if(ps == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun membre du personnel n'a été trouvé.");
                        chargerPersonnel();
                    }
                    else
                    {
                        lstPersonnel.add(ps);
                    }
                }
            }
        }
        else if((nom.length() !=0) && (prenom.length()!=0))
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                champValide = validerNomP(prenom);
            }
            if(champValide)
            {
                //Recherche selon le nom et le prenom
                lstPersonnel.clear();
                lstPersonnel = facadePersonnel.findByNomPrenom(nom,prenom);
                if(lstPersonnel.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun membre du personnel n'a été trouvé.");
                    chargerPersonnel();
                }
            }
        }
        else if((nom.length()==0) && (prenom.length()!=0))
        {
            champValide = validerNomP(prenom);
            if(champValide)
            {
                //Recherche selon le prenom
                lstPersonnel.clear();
                lstPersonnel = facadePersonnel.findByPrenom(prenom);
                if(lstPersonnel.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun membre du personnel n'a été trouvé.");
                    chargerPersonnel();
                }
            }
        }
        else if((nom.length()!=0) && (prenom.length()==0))
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                //Recherche selon le nom
                lstPersonnel.clear();
                lstPersonnel = facadePersonnel.findByNom(nom);
                if(lstPersonnel.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun membre du personnel n'a été trouvé.");
                    chargerPersonnel();
                }
            }    
        }
        else
        {
            champValide = validerNumEmp(noEmploye);
            if(champValide)
            {
                //Si les 3 champ son remplis recherche par le numéro d'employe
                lstPersonnel.clear();
                PersonnelSoutien ps = facadePersonnel.findByNumeroEmployePK(noEmploye); 
                if(ps == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun membre du personnel n'a été trouvé.");
                        chargerPersonnel();
                    }
                    else
                    {
                        lstPersonnel.add(ps);
                    }
            }   
        }    
        remplirListePersonnelTempo();  
    }
    //Module de recherche d'un cours
    private void rechercheCours()
    {
        String nom = txfCritere1.getText();  
        int numeroCours =0;
        String numero = txfCritere2.getText();
        boolean champValide;

        if((nom.length() !=0) && (numeroCours !=0))
        {
            JOptionPane.showMessageDialog(this,"Entrez un nom de cours ou un numéro."); 
        }
        else if(nom.length() ==0)
        {
            if( numero.length() ==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez un numéro de cours.");  
            }
            champValide = validerNumCours(numero);
            if(champValide)
            {
                numeroCours = Integer.parseInt(numero);
                lstCours.clear();
                Cours c = facadeCours.findByNumeroCours(numeroCours);
                if(c == null)
                {
                    JOptionPane.showMessageDialog(this,"Aucun cours n'a été trouvé.");
                    chargerCours();
                }
                else
                {
                    lstCours.add(c);
                }
            }
        }
        else if(numero.length()==0)
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                lstCours.clear();
                Cours c = facadeCours.findByNom(nom);
                if(c == null)
                {
                    JOptionPane.showMessageDialog(this,"Aucun cours n'a été trouvé.");
                    chargerCours();
                }
                else
                {
                    lstCours.add(c);
                }
            }
        }
        else
        {
           JOptionPane.showMessageDialog(this,"Entrez un nom de cours ou un numéro."); 
        }
    remplirListeCours();
    }
    //Module de recherche d'un locaux
    private void rechercheLocaux()
    {
         String numero = txfCritere1.getText();  
        String categorie = txfCritere2.getText();
        boolean champValide ;

        if((numero.length() !=0) && (categorie.length() !=0))
        {
            JOptionPane.showMessageDialog(this,"Entrez un numéro de local ou une catégorie."); 
        }
        
        else if(numero.length() ==0)
        {
            if( categorie.length()==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez un numéro de cours.");  
            }
            champValide = validerNomP(categorie);
            if(champValide)
            {
                lstLocaux.clear();
                lstLocaux = facadeLocaux.findByCategorie(categorie);
                if(lstLocaux.isEmpty())
                {
                    JOptionPane.showMessageDialog(this,"Aucun local n'a été trouvé.");
                    chargerLocaux();
                }
            }    
        }
        else if(categorie.length()==0)
        {
            champValide = validerLocaux(numero);
            if(champValide)
            {    
                lstLocaux.clear();
                Locaux l = facadeLocaux.findByNumeroLocaux(numero);
                if(l == null)
                {
                    JOptionPane.showMessageDialog(this,"Aucun local n'a été trouvé.");
                    chargerLocaux();
                }
                else
                {
                    lstLocaux.add(l);
                }
            }
        }    
        else
        {
           JOptionPane.showMessageDialog(this,"Entrez un nom de cour ou un numéro."); 
        }
    remplirListeLocaux();
    }
    //Module de recherche d'une session
    private void rechercheSession()
    {
        String annee = txfCritere1.getText();  
        int anneeSession = 0;
        String saison = txfCritere2.getText();
        boolean champValide;

        if((annee.length() !=0) && (saison.length() !=0))
        {
            champValide = validerAnne(annee);
            if(champValide)
            {
                champValide = validerNomP(saison);
                if(champValide)
                {
                    anneeSession = Integer.parseInt(annee);
                    lstSession.clear();
                    Session s = facadeSession.findByAnneeSaison(saison,anneeSession);
                    if(s==null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucune session n'a été trouvé.");
                        
                    }
                    else
                    {
                        lstSession = facadeSession.findAll();
                        remplirListeSession();
                    }
                }
            }
        }
        
        else if(saison.length() ==0)
        {
            if( annee.length() ==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez une année ou une saison");  
            }
            champValide = validerAnne(annee);
            if(champValide)
            {
                anneeSession = Integer.parseInt(annee);
                lstSession.clear();
                lstSession = facadeSession.findByAnnee(anneeSession);
                if(lstSession.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucune session n'a été trouvé.");
                        lstSession = facadeSession.findAll();
                    }
                    else
                    {
                        remplirListeSession();
                    }
            }
        }
        else if(annee.length()==0)
        {
            champValide = validerNomP(saison);
            if(champValide)
            {
                lstSession.clear();
                lstSession = facadeSession.findBySaison(saison);
                if(lstSession.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucune session n'a été trouvé.");
                        lstSession = facadeSession.findAll();
                    }
                    else
                    {
                        remplirListeSession();
                    }
            }
        }    
        else
        {
           JOptionPane.showMessageDialog(this,"Entrez une années ou une saison"); 
        }
    }
    private void rechercheGroupe()
    {
        String numeroGroupe = txfCritere1.getText();
        String numeroEnseignant = txfCritere2.getText();
        String numeroCours = txfCritere3.getText();
        boolean champValide;
        if((numeroGroupe.length() ==0) && (numeroEnseignant.length() ==0) )
        {
            if(numeroCours.length() ==0)
            {
                 JOptionPane.showMessageDialog(this,"Entrez un numéro de groupe, un numéro d'enseignant ou un numéro de cours.");
            }
            else
            {
                champValide= validerNumCours(numeroCours);
                if(champValide)
                {
                    lstGroupe.clear();
                    Cours unCours = facadeCours.findByNumeroCours(Integer.parseInt(numeroCours));
                    lstGroupe = facadeGroupe.findByCours(unCours);
                    if(lstGroupe.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucun groupe n'a été trouvé.");
                        lstGroupe = facadeGroupe.findAll();
                    }
                    else
                    {
                        remplirListeGroupe();
                    }
                }    
            }
        }
        else if((numeroCours.length() ==0) && (numeroEnseignant.length() ==0))
        {
            if(numeroGroupe.length() ==0)
            {
                 JOptionPane.showMessageDialog(this,"Entrez un numéro de groupe, un numéro d'enseignant ou un numéro de cours.");
            } 
            else
            {
                champValide= validerNumGroupe(numeroGroupe);
                if(champValide)
                {
                    lstGroupe.clear();
                    Groupe g = facadeGroupe.findByIdGroupePK(Integer.parseInt(numeroGroupe));
                    if(g == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun groupe n'a été trouvé.");
                    }
                    else
                    {
                        lstGroupe = facadeGroupe.findAll();
                        remplirListeGroupe();
                    }
                }    
            }
        }
         else if((numeroCours.length() ==0) && (numeroGroupe.length() ==0))
        {
            if(numeroEnseignant.length() ==0)
            {
                 JOptionPane.showMessageDialog(this,"Entrez un numéro de groupe, un numéro d'enseignant ou un numéro de cours.");
            } 
            else
            {
                champValide = validerNumEmp(numeroEnseignant);
                if(champValide)
                {
                    lstGroupe.clear();
                    Professeur unProf = facadeEnseignant.findByNumeroEmployePK(numeroEnseignant);
                    lstGroupe = facadeGroupe.findByEnseignant(unProf);
                    if(lstGroupe.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this,"Aucun groupe n'a été trouvé.");
                        lstGroupe = facadeGroupe.findAll();
                    }
                    else
                    {
                        remplirListeGroupe();
                    }                
                }    
            }
        }
    }
    private void rechercheDepartement()
    {
        String nom = txfCritere1.getText();  
        String numero = txfCritere2.getText();
        boolean champValide;

        if((numero.length() !=0) && (nom.length() !=0))
        {
            champValide = validerNomP(nom);
            if(champValide)
            {
                champValide = validerNumDep(numero);
                if(champValide)
                {
                    lstDepartement.clear();
                    Departement d =facadeDepartement.findByNumeroNom(numero, nom);
                    if(d == null)
                    {
                        JOptionPane.showMessageDialog(this,"Aucun département n'a été trouvé.");
                        lstDepartement = facadeDepartement.findAll();
                    }
                    else
                    {
                        remplirListeGroupe();
                    }
                }
            }    
        }
        
        else if(numero.length() ==0)
        {
            if( nom.length() ==0)
            {
                JOptionPane.showMessageDialog(this,"Entrez un nom ou un numéro de département.");  
            }
            champValide = validerNomP(nom);
            if(champValide)
            {
                lstDepartement.clear();
                Departement d =facadeDepartement.findByNom(nom);
                if(d == null)
                {
                    JOptionPane.showMessageDialog(this,"Aucun département n'a été trouvé.");
                    lstDepartement = facadeDepartement.findAll();
                }
                else
                {
                    remplirListeGroupe();
                }
            }
        }
        else if(nom.length()==0)
        {
            champValide = validerNumDep(numero);
            if(champValide)
            {
                lstDepartement.clear();
                Departement d = facadeDepartement.findByNumero(numero);
                if(d == null)
                {
                    JOptionPane.showMessageDialog(this,"Aucun département n'a été trouvé.");
                    lstDepartement = facadeDepartement.findAll();
                }
                else
                {
                    remplirListeGroupe();
                }
            }
        }    
        else
        {
           JOptionPane.showMessageDialog(this,"Entrez un nom ou un numéro de département."); 
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Gestion de l'interface">
    private void GererActions(Onglet O)
    {
        //Gestion des boutons et des actions dans le menu
        GererRechercher(O);
        switch(O)
        {
            case    Etudiant:  if (tblEtudiant.getSelectedRow() != -1)
                               {
                                    btnResultat.setEnabled(true); //Boutons
                                    btnHoraire.setEnabled(true);
                                    btnGerer.setEnabled(true);
                                    btnReservation.setEnabled(false);
                                    btnModifier.setEnabled(true);
                                    btnSupprimer.setEnabled(true);

                                    mniResultat.setEnabled(true); //Menu actions
                                    mniHoraire.setEnabled(true);
                                    mniGerer.setEnabled(true);
                                    mniReservation.setEnabled(false); 
                                    mniModifier.setEnabled(true);
                                    mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                      
                               }
                               break;
            case  Enseignant:  if (tblEnseignant.getSelectedRow() != -1)
                               {
                                    btnResultat.setEnabled(false); //Boutons
                                    btnHoraire.setEnabled(false);
                                    btnGerer.setEnabled(true);
                                    btnReservation.setEnabled(false);
                                    btnModifier.setEnabled(true);
                                    btnSupprimer.setEnabled(true);

                                    mniResultat.setEnabled(false); //Menu actions
                                    mniHoraire.setEnabled(false);
                                    mniGerer.setEnabled(true);
                                    mniReservation.setEnabled(false); 
                                    mniModifier.setEnabled(true);
                                    mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                    boutonDefault();
                               }
                               break;
            case   Personnel:  if (tblPersonnel.getSelectedRow() != -1)
                               {
                                    btnResultat.setEnabled(false); //Boutons
                                    btnHoraire.setEnabled(false);
                                    btnGerer.setEnabled(false);
                                    btnReservation.setEnabled(false);
                                    btnModifier.setEnabled(true);
                                    btnSupprimer.setEnabled(true);

                                    mniResultat.setEnabled(false); //Menu actions
                                    mniHoraire.setEnabled(false);
                                    mniGerer.setEnabled(false);
                                    mniReservation.setEnabled(false); 
                                    mniModifier.setEnabled(true);
                                    mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                               }
                               break;
            case       Cours:  if(tblCours.getSelectedRow() != -1)
                               {
                                    btnResultat.setEnabled(false); //Boutons
                                    btnHoraire.setEnabled(false);
                                    btnGerer.setEnabled(false);
                                    btnReservation.setEnabled(false);
                                    btnModifier.setEnabled(true);
                                    btnSupprimer.setEnabled(true);

                                    mniResultat.setEnabled(false); //Menu actions
                                    mniHoraire.setEnabled(false);
                                    mniGerer.setEnabled(false);
                                    mniReservation.setEnabled(false);
                                    mniModifier.setEnabled(true);
                                    mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                               }
                
                               break;
            case      Locaux:  if(tblLocaux.getSelectedRow() != -1)
                               {
                                    btnResultat.setEnabled(false); //Boutons
                                    btnHoraire.setEnabled(false);
                                    btnGerer.setEnabled(true);
                                    btnReservation.setEnabled(true);
                                    btnModifier.setEnabled(true);
                                    btnSupprimer.setEnabled(true);

                                    mniResultat.setEnabled(false); //Menu actions
                                    mniHoraire.setEnabled(false);
                                    mniGerer.setEnabled(true);
                                    mniReservation.setEnabled(true);
                                    mniModifier.setEnabled(true);
                                    mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                                   btnGerer.setEnabled(true);
                                   mniGerer.setEnabled(true);
                               }
                               break;
            case     Session:  if(tblSession.getSelectedRow() != -1)
                               {
                               btnResultat.setEnabled(false); //Boutons
                               btnHoraire.setEnabled(false);
                               btnGerer.setEnabled(false);
                               btnReservation.setEnabled(false);
                               btnModifier.setEnabled(true);
                               btnSupprimer.setEnabled(true);
                               
                               mniResultat.setEnabled(false); //Menu actions
                               mniHoraire.setEnabled(false);
                               mniGerer.setEnabled(false);
                               mniReservation.setEnabled(false);
                               mniModifier.setEnabled(true);
                               mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                               }
                               break;
            case     Groupes:  if(tblGroupe.getSelectedRow() != -1)
                               {
                               btnResultat.setEnabled(false); //Boutons
                               btnHoraire.setEnabled(true);
                               btnGerer.setEnabled(true);
                               btnReservation.setEnabled(false);
                               btnModifier.setEnabled(true);
                               btnSupprimer.setEnabled(true);
                               
                               mniResultat.setEnabled(false); //Menu actions
                               mniHoraire.setEnabled(true);
                               mniGerer.setEnabled(true);
                               mniReservation.setEnabled(false);
                               mniModifier.setEnabled(true);
                               mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                               }
                               break;
            case Departement:  if(tblDepartements.getSelectedRow() != -1)
                               {
                               btnResultat.setEnabled(false); //Boutons
                               btnHoraire.setEnabled(false);
                               btnGerer.setEnabled(false);
                               btnReservation.setEnabled(false);
                               btnModifier.setEnabled(true);
                               btnSupprimer.setEnabled(true);
                               
                               mniResultat.setEnabled(false); //Menu actions
                               mniHoraire.setEnabled(false);
                               mniGerer.setEnabled(false);
                               mniReservation.setEnabled(false);
                               mniModifier.setEnabled(true);
                               mniSupprimer.setEnabled(true);
                               }
                               else
                               {
                                   boutonDefault();
                               }
                               break;
        }
    }
    public void gererDroitAcces()
    {
        if(giPersonneConnecter ==0)
        {
            this.setVisible(false);
        }
        else if((giPersonneConnecter ==1)|(giPersonneConnecter == 2))
        {
            tbpOnglet.setEnabledAt(1,false);
            mniEnseignant.setEnabled(false);
            tbpOnglet.setEnabledAt(2,false);
            mniPersonnel.setEnabled(false);
        }
        else if(giPersonneConnecter ==3)
        {
            tbpOnglet.setEnabledAt(0,false);
            mniEtudiant.setEnabled(false);
        }
        tbpOnglet.setSelectedIndex(4);
        GererActions(selectedTab);
    }
    private void boutonDefault()
    {
       btnResultat.setEnabled(false); //Boutons
       btnHoraire.setEnabled(false);
       btnGerer.setEnabled(false);
       btnReservation.setEnabled(false);
       btnModifier.setEnabled(false);
       btnSupprimer.setEnabled(false);

       mniResultat.setEnabled(false); //Menu actions
       mniHoraire.setEnabled(false);
       mniGerer.setEnabled(false);
       mniReservation.setEnabled(false);
       mniModifier.setEnabled(false); 
       mniSupprimer.setEnabled(false);
    }
    
    private void GererNavigation(Onglet O)
    {
        //Gère la navigation dans les onglets à partir du menu 'navigation'.
        switch(O)
        {
            case    Etudiant:  tbpOnglet.setSelectedIndex(0);
                               break;
            case  Enseignant:  tbpOnglet.setSelectedIndex(1);
                               break;
            case   Personnel:  tbpOnglet.setSelectedIndex(2);
                               break;
            case       Cours:  tbpOnglet.setSelectedIndex(3);
                               break;
            case      Locaux:  tbpOnglet.setSelectedIndex(4);
                               break;
            case     Session:  tbpOnglet.setSelectedIndex(5);
                               break;
            case     Groupes:  tbpOnglet.setSelectedIndex(6);
                               break;
            case Departement:  tbpOnglet.setSelectedIndex(7);
                               break;
        }
    }
           
    private void GererRechercher(Onglet O)
    {
      //Gestion des critères de recherche.
      switch(O)
        {
            case    Etudiant:  lblCritere1.setText("Nom :");
                               lblCritere2.setText("Prénom :");
                               lblCritere3.setText("Matricule :");
                               txfCritere3.setEnabled(true);
                               break;
            case  Enseignant:  lblCritere1.setText("Nom :");
                               lblCritere2.setText("Prénom :");
                               lblCritere3.setText("No employé :");
                               txfCritere3.setEnabled(true);
                               break;
            case   Personnel:  lblCritere1.setText("Nom :");
                               lblCritere2.setText("Prénom :");
                               lblCritere3.setText("No employé :");
                               txfCritere3.setEnabled(true);
                               break;
            case       Cours:  lblCritere1.setText("Nom :");
                               lblCritere2.setText("No Cours:");
                               lblCritere3.setText("");
                               txfCritere3.setEnabled(false);
                               break;
            case      Locaux:  lblCritere1.setText("Numéro :");
                               lblCritere2.setText("Catégorie :");
                               lblCritere3.setText("");
                               txfCritere3.setEnabled(false);
                               break;
            case     Session:  lblCritere1.setText("Année :");
                               lblCritere2.setText("Session :");
                               lblCritere3.setText("");
                               txfCritere3.setEnabled(false);
                               break;
            case     Groupes:  lblCritere1.setText("No Groupe :");
                               lblCritere2.setText("No Professeur :");
                               lblCritere3.setText("No Cours :");
                               txfCritere3.setEnabled(true);
                               break;
            case Departement:  lblCritere1.setText("Nom :");
                               lblCritere2.setText("Numéro :");
                               lblCritere3.setText("");
                               txfCritere3.setEnabled(false);
                               break;
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
            java.util.logging.Logger.getLogger(FrmPanorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPanorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPanorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPanorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPanorama(null).setVisible(true);
            }
        });
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Déclarations de composants">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnGerer;
    private javax.swing.JButton btnHoraire;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnRechercher;
    private javax.swing.JButton btnReinitialiser;
    private javax.swing.JButton btnReservation;
    private javax.swing.JButton btnResultat;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblCritere1;
    private javax.swing.JLabel lblCritere2;
    private javax.swing.JLabel lblCritere3;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JMenu mnAction;
    private javax.swing.JMenu mnAide;
    private javax.swing.JMenu mnNavigation;
    private javax.swing.JMenu mnfichier;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniAjouter;
    private javax.swing.JMenuItem mniCours;
    private javax.swing.JMenuItem mniDeconnexion;
    private javax.swing.JMenuItem mniDepartements;
    private javax.swing.JMenuItem mniEnseignant;
    private javax.swing.JMenuItem mniEtudiant;
    private javax.swing.JMenuItem mniGerer;
    private javax.swing.JMenuItem mniGroupes;
    private javax.swing.JMenuItem mniHoraire;
    private javax.swing.JMenuItem mniLocaux;
    private javax.swing.JMenuItem mniModifier;
    private javax.swing.JMenuItem mniPersonnel;
    private javax.swing.JMenuItem mniQuitter;
    private javax.swing.JMenuItem mniRechercher;
    private javax.swing.JMenuItem mniReinitialiser;
    private javax.swing.JMenuItem mniReservation;
    private javax.swing.JMenuItem mniResultat;
    private javax.swing.JMenuItem mniSession;
    private javax.swing.JMenuItem mniSupprimer;
    private javax.swing.JPanel pnlCours;
    private javax.swing.JPanel pnlDepartement;
    private javax.swing.JPanel pnlDroit;
    private javax.swing.JPanel pnlEnseignant;
    private javax.swing.JPanel pnlEtudiant;
    private javax.swing.JPanel pnlGroupe;
    private javax.swing.JPanel pnlLocaux;
    private javax.swing.JPanel pnlOperation;
    private javax.swing.JPanel pnlPersonnel;
    private javax.swing.JPanel pnlRecherche;
    private javax.swing.JPanel pnlSession;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.JTable tblCours;
    private javax.swing.JTable tblDepartements;
    private javax.swing.JTable tblEnseignant;
    private javax.swing.JTable tblEtudiant;
    private javax.swing.JTable tblGroupe;
    private javax.swing.JTable tblLocaux;
    private javax.swing.JTable tblPersonnel;
    private javax.swing.JTable tblSession;
    private javax.swing.JTabbedPane tbpOnglet;
    private javax.swing.JTextField txfCritere1;
    private javax.swing.JTextField txfCritere2;
    private javax.swing.JTextField txfCritere3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    }
    // </editor-fold>