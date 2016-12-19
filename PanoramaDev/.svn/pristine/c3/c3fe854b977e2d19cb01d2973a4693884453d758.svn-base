/*
 * Kathy Landry
 * Sert à l'impression de l'horaire de'un étudiant.
 * 
 */
package pckImpressions;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import pckEntites.Etudiant;
import pckEntites.PlageHoraire;

/**
 *
 * @author Kathy
 */
public class ImpressionHoraire implements Printable{
   
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private final Etudiant unEtudiant;
    private final List<PlageHoraire> lstPlageHoraire;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructeur">
    public ImpressionHoraire(List<PlageHoraire> plageHoraire, Etudiant etudiant)
    {
        lstPlageHoraire = plageHoraire;
        unEtudiant = etudiant;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Opérations">
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
    {
        int ret = NO_SUCH_PAGE; //Veillez à vous assurer que cette valeur est retournée lorsque le PrinterJob
                                //demande d'imprimer une page qui est passée la fin du document
        
        if (pageIndex == 0) //S'assurer qu'on nous a bien demandé d'imprimer la première page du document
        {
            //L'instance de Graphics reçue en paramètre est en fait une instance de Graphics2D
            //Comme cette classe offre plus de possibilités, on transtype le paramètre en Graphics2D
            Graphics2D g = (Graphics2D) graphics;
            
            //Déterminer le point central de la page
            int departX = (int) (pageFormat.getWidth() / 8.0);
            int departY = (int) (pageFormat.getHeight() / 22.0);
            
            //Imprimer le texte
            imprimerJour(g, departX, departY);
                        
            //ImprimerHeures
            imprimerHeures(g, departX, departY);
            
            //Imprimer tableau
            imprimerTableau(g, departX, departY);
            
            //Imprimer entête
            imprimerEntete(g, departX, departY);
            
            //Imprimer plage horaire
            imprimerPlageHoraire(g, departX, departY);
            
            ret = PAGE_EXISTS;
        }
        return ret;
    }
    
    private void imprimerJour(Graphics2D g, int departX, int departY)
    {
        //Changer la police utilisée pour imprimer le texte
        g.setFont(new Font("Verdana", Font.BOLD, 10));
        
        g.drawString("Lundi", departX*2 - 4, departY*5 + 22);
        g.drawString("Mardi", departX*3, departY*5 + 22);
        g.drawString("Mercredi", departX*4, departY*5 + 22);
        g.drawString("Jeudi", departX*5 + 13, departY*5 + 22);
        g.drawString("Vendredi", departX*6 + 9, departY*5 + 22);
    }
    
    private void imprimerHeures(Graphics2D g, int departX, int departY)
    {
        //Changer la police utilisée pour imprimer le texte
        g.setFont(new Font("Verdana", Font.BOLD, 10));
        
        g.drawString("8:15", departX + 12, departY*6 + 12);
        g.drawString("9:05", departX + 12, departY*6 + 33);           
        g.drawString("9:10", departX + 12, departY*7 + 12);
        g.drawString("10:00", departX + 7, departY*7 + 33);           
        g.drawString("10:10", departX + 7, departY*8 + 12);
        g.drawString("11:00", departX + 7, departY*8 + 33);            
        g.drawString("11:05", departX + 7, departY*9 + 12);
        g.drawString("11:55", departX + 7, departY*9 + 33);           
        g.drawString("12:00", departX + 7, departY*10 + 12);
        g.drawString("12:50", departX + 7, departY*10 + 33);            
        g.drawString("13:00", departX + 7, departY*11 + 12);
        g.drawString("13:50", departX + 7, departY*11 + 33);            
        g.drawString("14:00", departX + 7, departY*12 + 12);
        g.drawString("14:50", departX + 7, departY*12 + 33);           
        g.drawString("15:00", departX + 7, departY*13 + 12);
        g.drawString("15:50", departX + 7, departY*13 + 33);            
        g.drawString("16:00", departX + 7, departY*14 + 12);
        g.drawString("16:50", departX + 7, departY*14 + 33);           
        g.drawString("17:00", departX + 7, departY*15 + 12);
        g.drawString("17:50", departX + 7, departY*15 + 33);            
        g.drawString("18:00", departX + 7, departY*16 + 12);
        g.drawString("18:50", departX + 7, departY*16 + 33);            
        g.drawString("19:00", departX + 7, departY*17 + 12);
        g.drawString("19:50", departX + 7, departY*17 + 33);            
        g.drawString("20:00", departX + 7, departY*18 + 12);
        g.drawString("20:50", departX + 7, departY*18 + 33);            
        g.drawString("21:00", departX + 7, departY*19 + 12);
        g.drawString("21:50", departX + 7, departY*19 + 33);           
        g.drawString("22:00", departX + 7, departY*20 + 12);
        g.drawString("22:50", departX + 7, departY*20 + 33);
    }
    
    private void imprimerTableau(Graphics2D g, int departX, int departY)
    {
        //Changer la largeur du trait à 5 (Pixels? Points? mm?)
        //Avis aux intéressé(e)s, la classe BasicStroke permet aussi de réaliser
        //des lignes pointillées, voir les détails dans la javadoc!
        g.setStroke(new BasicStroke(1));

        g.drawLine(departX, departY + 10, departX*7, departY + 10);

        //Dessiner un tableau
        int i = 0;
        for (i=0; i < 17; i++)
        {
            g.drawLine(departX, departY*5 + departY*i, departX*7, departY*5 + departY*i);
        }


        //Lignes des colonnes
        g.drawLine(departX, departY*5, departX, departY*21);
        g.drawLine(departX + departX/2 + 10, departY*5, departX + departX/2 + 10, departY*21);

        g.drawLine(departX + departX*1 + departX/2 + 15, departY*5, departX + departX*1 + departX/2 + 15, departY*21);
        g.drawLine(departX + departX*2 + departX/2 + 20, departY*5, departX + departX*2 + departX/2 + 20, departY*21);
        g.drawLine(departX + departX*3 + departX/2 + 25, departY*5, departX + departX*3 + departX/2 + 25, departY*21);
        g.drawLine(departX + departX*4 + departX/2 + 30, departY*5, departX + departX*4 + departX/2 + 30, departY*21);   

        g.drawLine(departX + departX*6, departY*5, departX + departX*6, departY*21);

    }
    
    private void imprimerEntete(Graphics2D g, int departX, int departY)
    {
        LocalDateTime now = LocalDateTime.now();  //Obtenir la date du jour
                
        g.setFont(new Font("Verdana", Font.PLAIN, 9));
        g.drawString("Cégep de Rimouski", departX, departY); 
        g.drawString(now.format(DateTimeFormatter.ISO_LOCAL_DATE), departX*6 + 20, departY);
        
        g.setFont(new Font("Verdana", Font.BOLD, 15));
        g.drawString("Horaire", departX*3 + 40, departY*2);
        
        g.setFont(new Font("Verdana", Font.BOLD, 13));
        g.drawString("Informations personnelles", departX, departY*3);
        
        g.setFont(new Font("Verdana", Font.BOLD, 11));
        g.drawString("Nom :", departX, departY*4);
        g.drawString(unEtudiant.getIdUtilisateurFK().getNom(), departX + 80, departY*4);
        
        g.drawString("Prénom :", departX, departY*4 + 20);
        g.drawString(unEtudiant.getIdUtilisateurFK().getPrenom(), departX + 80, departY*4 + 20);
        
        g.drawString("Matricule :", departX*5, departY*4);
        g.drawString(unEtudiant.getMatriculePK(), departX*5 + 80, departY*4);   
    }
    
    private void imprimerPlageHoraire(Graphics2D g, int departX, int departY)
    {
        if(lstPlageHoraire.size() > 0)
        { 
            for(int i = 0; i < lstPlageHoraire.size(); i++)
            {
                switch(lstPlageHoraire.get(i).getJour())
                {
                    case "Lundi":
                        insererCours(g, i, departX*1 + 60, departY);
                        break;
                    case "Mardi":
                        insererCours(g, i, departX*2 + 65, departY);
                        break;
                    case "Mercredi":
                        insererCours(g, i, departX*3 + 70, departY);
                        break;
                    case "Jeudi":
                        insererCours(g, i, departX*4 + 75, departY);
                        break;
                    case "Vendredi":
                        insererCours(g, i, departX*5 + 80, departY);
                        break;
                }
            }
        }
    }
    
    private void insererCours(Graphics2D g, int indice, int colonne , int departY)
    {
        g.setFont(new Font("Verdana", Font.PLAIN, 6));
        
        DateFormat sdf = new SimpleDateFormat("kk:mm:ss");
        String dateTempo = sdf.format(lstPlageHoraire.get(indice).getHeureDebut());
        int ligneDebut = Integer.parseInt(dateTempo.substring(0, 2)) - 2;
        
        dateTempo = sdf.format(lstPlageHoraire.get(indice).getHeureFin());
        int ligneFin = Integer.parseInt(dateTempo.substring(0, 2)) - 2;
        
        int hauteur;
        int longueurMot;
        
        for(int i = ligneDebut; i < ligneFin; i++)
        {         
            longueurMot = lstPlageHoraire.get(indice).getIdGroupeFK()
                                         .getIdCoursFK().getNomCours().length();
            if (longueurMot > 34)
            {
                longueurMot = 34;
            }
            hauteur = 10;
            
            if(longueurMot > 17)
            {
                g.drawString(lstPlageHoraire.get(indice).getIdGroupeFK()
                        .getIdCoursFK().getNomCours()
                        .substring(0, 16) + "-", colonne, departY*i + hauteur);
                hauteur = 17;
                g.drawString(lstPlageHoraire.get(indice).getIdGroupeFK()
                        .getIdCoursFK().getNomCours()
                        .substring(16, longueurMot), colonne, departY*i + hauteur);
            }    
            else
            {
                g.drawString(lstPlageHoraire.get(indice).getIdGroupeFK()
                        .getIdCoursFK()
                        .getNomCours(), colonne, departY*i + hauteur);
            }
            
            hauteur = hauteur + 7;
            g.drawString(lstPlageHoraire.get(indice).getIdGroupeFK()
                    .getProfesseurFK().getIdUtilisateurFK()
                    .getPrenom() + " " + lstPlageHoraire.get(indice)
                    .getIdGroupeFK().getProfesseurFK().getIdUtilisateurFK()
                    .getNom() , colonne, departY*i + hauteur);
            g.drawString(lstPlageHoraire.get(indice).getIdLocauxFK()
                    .getNumeroLocal(), colonne, departY*i + hauteur + 7);
        }        
    }
    
    //</editor-fold>
}
