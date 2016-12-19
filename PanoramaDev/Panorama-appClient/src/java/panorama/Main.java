package panorama;

import pckDialog.DlgConnexion;
import pckDialog.FrmPanorama;
import pckFournisseur.FournisseurServices;
import pckFournisseur.ManufacturePanorama;

public class Main {
    final static boolean activerConnexion = false; //False Permet d'utiliser le programme sans connexion.
                                                   //True permet d'afficher la fenetre de connexion pour une utilisation normale.
    public static void main(String[] args) {
        ManufacturePanorama manufacture = new ManufacturePanorama(ManufacturePanorama._FournisseurPanorama);
        FournisseurServices fs = manufacture.creerFournisseur();
        FrmPanorama frmPrincipale = new FrmPanorama(fs);
        
        if (activerConnexion)
        {
            DlgConnexion dlgConnexion = new DlgConnexion(frmPrincipale,true,fs);
            dlgConnexion.show();
            if(dlgConnexion.isModal())
            {
                frmPrincipale.setEnabled(true);
                frmPrincipale.setGiPersonneConnecter(dlgConnexion.getGiPersonneConnecter());
                dlgConnexion.setVisible(false);
                frmPrincipale.show();
                frmPrincipale.gererDroitAcces();
            }
        }
        else
        {
            frmPrincipale.show();
        }
    }
}
