/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckValidation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation 
{

    // Valide un numéro de téléphone, retourne vrai si il est valide et faux si il ne l'est pas
    // Modèle : 1234567890 , (123)456-7890, 123-456-7890 , 123 456 7890.
    static public boolean validerTel(String numTel) 
    {
        Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");
        // Regex pour la validation d'un numéro de téléphone
        Matcher matcher = pattern.matcher(numTel);
        if (matcher.matches()) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    // Valide une adresse courriel, retourne vrai si il est valide et faux si il ne l'est pas
    // Modèle .net, .fr, .com, .ca, etc.
    // Modèle @gmail, @hotmail, @globetrotter, @live, etc.
    static public boolean validerCourriel(String courriel) 
    {
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        // Regex pour la validation d'une adresse courriel.
        Matcher matcher = pattern.matcher(courriel);
        if (matcher.matches()) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    // Valide un code postal, retourne vrai si il est valide et faux si il ne l'est pas
    // Modèle A0A0A0
    // Erreur ne fonctionne pas 
    static public boolean validerCodePostal(String codePostal)
    {
        Pattern pattern = Pattern.compile("[A-Za-z][0-9][A-Za-z][ ]?[0-9][A-Za-z][0-9]");

        // Regex pour la validation d'un code postal
        Matcher matcher = pattern.matcher(codePostal);
        if (matcher.matches()) 
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    // Valide un code postal, retourne vrai si il est valide et faux si il ne l'est pas
    // Modèle AAAA-MM-JJ.
    static public boolean validerDate(String date)
    {
        Pattern pattern = Pattern.compile("(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])");
        // Regex pour la validation d'une date
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    // Valide une heure, retourne vrai si il est valide et faux si il ne l'est pas
    // Modèle 24h 23:59 --> 00:00.
    static public boolean validerHeure(String heure) 
    {
        Pattern pattern = Pattern.compile("^([01]\\d|2[0-3]):?([0-5]\\d)$");
        // Regex pour la validation d'une heure.
        Matcher matcher = pattern.matcher(heure);
        if (matcher.matches()) 
        {
            return true;
        } else 
        {
            return false;
        }

    }

    // Validation du NAS à faire
    static public boolean validerNAS(String NAS) 
    {
         Pattern pattern = Pattern.compile("[0-9]{3}\\s?[0-9]{3}\\s?[0-9]{3}");
        // Regex pour la validation d'une heure.
        Matcher matcher = pattern.matcher(NAS);
        if (matcher.matches()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    // Validation Mot de Passe
    static public boolean validerMotPasse(String motPasse)
    {
//        Pattern pattern = Pattern.compile("([A-ZÉÊÈËÀÄÖÏ-/*_#!$%?&]*|[0-9]*|[a-z]*)*");
//        // Regex pour la validation d'une heure.
//        Matcher matcher = pattern.matcher(motPasse);
//        if (matcher.matches()) 
//        {
            return true;
//        }
//        else 
//        {
//            return false;
//        }
    }

    // Validation du Nom et Prénom 
    static public boolean validerNom(String nom)
    {
        Pattern pattern = Pattern.compile("([A-ZÉÊÈ ]{1}[a-zéêèôûùiîïëàáâç ]+)|([A-ZÉÊÈ ]{1}[a-zéêèôûùiîïëàáâç ]+)(\\-{1}[A-ZÉÊÈ ]{1}[a-zéêèôûùiîïëàáâç ]+)|([A-ZÉÊÈ ]{1}\'{1}[A-ZÉÊÈ ][a-zéêèôûùiîïëàáâç ]+)|([A-Z]{1}[a-zéêèôûùiîïëàáâç ]+[A-Z]{2})");
        // Regex pour la validation d'un nom
        Matcher matcher = pattern.matcher(nom);
        if (matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    static public boolean validerCredit(String psChaine) 
    {
        boolean lbValide = false;
        try
        {
            double lrNombre = Double.parseDouble(psChaine);
            lbValide = true;
        } 
        catch (Exception e) 
        {

        }
        return lbValide;
    }
    

    static public boolean validerCodePermanent(String psChaine)
    {
        Pattern pattern = Pattern.compile("[A-Za-z]{4}[0-9]{8}");
        // Regex pour la validation d'une heure.
        Matcher matcher = pattern.matcher(psChaine);
        if (matcher.matches()) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    static public boolean validerNoPoste(String psChaine)
    {
        Pattern pattern = Pattern.compile("([0-9]{4})");
        // Regex pour la validation d'une heure.
        Matcher matcher = pattern.matcher(psChaine);
        if (matcher.matches()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    static public boolean validerMatricule(String matricule)
    {
     
        Pattern pattern = Pattern.compile("([0-9]{7})");

        Matcher matcher = pattern.matcher(matricule);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
          
    }
    static public boolean validerNumDepartement(String numDep)
    {
        Pattern pattern = Pattern.compile("([0-9]{3}([.][A-Z][0-9])?)");
        Matcher matcher = pattern.matcher(numDep);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    static public boolean validerNoEmploye(String noEmploye)
    {
       
        Pattern pattern = Pattern.compile("([0-9]{5})");
        Matcher matcher = pattern.matcher(noEmploye);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    static public boolean validerCours(String numero)
    {
        try
        {
            if(numero.length() ==3)
            {
                int numeroS = Integer.parseInt(numero);
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception x)
        {
            return false;
        }
    }
    
    static public boolean validerLocal(String local)
    {
        Pattern pattern = Pattern.compile("([A-Z]-[0-9]{3}[a-z]?)");
        Matcher matcher = pattern.matcher(local);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    static public boolean validerAnnee(String annee)
    {
        int i;
        try
        {
            i = Integer.parseInt(annee);
            if((i >2000) && (i<3000))
            {
                return true;
            }
            else
            {
                return false;
            }   
        }
        catch (Exception e)
        {
            return false;
        }
    }
    static public boolean validerNoBureau(String psChaine)
    {
        Pattern pattern = Pattern.compile("([A-Z]{1}\\-[0-9]{3})|([a-z]{1}\\-[0-9]{3})");
        // Regex pour la validation d'une heure.
        Matcher matcher = pattern.matcher(psChaine);
        if (matcher.matches())
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    
    static public boolean validerPhotographie(String chemin)
    {
        Pattern pattern = Pattern.compile("([a-zA-Z]:)?(\\\\\\\\[a-zA-Z0-9._-]+)+\\\\\\\\?");
        //Regex pour la validation d'un chemin de fichier
        Matcher matcher = pattern.matcher(chemin);
        if(matcher.matches())
        {
            return true;
        }
        else
        {
            return true;
        }
    }
    
    static public boolean validerFonction(String psChaine)
    {
        
        return true;
    }
    
    static public boolean validerNombre(String nombre)
    {
        int i;
        try
        {
            i = Integer.parseInt(nombre);
            return true;
        }
        catch( Exception e)
        {
           return false;
        }
    }
    
    
    
    
    
    ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    ///                                             ///
    ///           Formater  les données             ///
    ///                                             ///
    ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    
    static public Date retournerDate(String psChaine) {
        String lsdate = "";
        Date unDate = null;
        try
        {   
            DateFormat format = new SimpleDateFormat("yyyy-dd-mm",Locale.CANADA_FRENCH);
            unDate = format.parse(psChaine);
        }
        catch(Exception e)
        {
           
        }
        return unDate;
    }
    
    static public String retournerCodePostal(String psChaine)
    {
        String vide = " ";
        String nouv = psChaine.replace(vide, "");
        return nouv.toUpperCase();
    }
    
    static public String retournerNoTel(String psChaine)
    {
        StringBuilder modif = new StringBuilder();
        for(int indice = 0;indice < psChaine.length(); indice++)
        {
            char x = psChaine.charAt(indice);
            if((x >= '0')&&( x <= '9'))
            {
                modif.append(x);
            }
        }
        modif.insert(3, "-");
        modif.insert(7, "-");
        return modif.toString();
    }
    
    static public int retournerNAS(String psChaine)
    {
        StringBuilder modif = new StringBuilder();
        for(int indice = 0;indice < psChaine.length(); indice++)
        {
            char x = psChaine.charAt(indice);
            if((x >= '0')&&( x <= '9'))
            {
                modif.append(x);
            }
        }
        return Integer.parseInt(modif.toString());
    }
    
    static public String retournerCodePermanent(String psChaine)
    {
        
        return psChaine.toUpperCase();
    }
    
    static public String retournerMotPasse(char[] pTblMotPasse)
    {
        StringBuilder motPasse = new StringBuilder();
        
        for (int indice = 0; indice < pTblMotPasse.length; indice++) {
            motPasse.append(pTblMotPasse[indice]);
        }
        return motPasse.toString();
    }
    
    static public byte[] retournerImageBytes (String ImageName) throws FileNotFoundException, IOException{
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///   Ce code provient de ce site web                                                                                   ///
///   http://www.programcreek.com/2009/02/java-convert-image-to-byte-array-convert-byte-array-to-image/                 ///
///   * 1. How to convert an image file to  byte array?                                                                 ///
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	 
 
        File unFile = new File(ImageName);
 
        FileInputStream fis = new FileInputStream(unFile);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
//            Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        byte[] bytes = bos.toByteArray();
        return bytes;
    }
    
}
