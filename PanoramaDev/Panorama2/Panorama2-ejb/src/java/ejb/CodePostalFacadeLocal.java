/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.CodePostal;

/**
 *
 * @author clocal
 */
@Local
public interface CodePostalFacadeLocal {

    void create(CodePostal codePostal);

    void edit(CodePostal codePostal);

    void remove(CodePostal codePostal);

    CodePostal find(Object id);

    List<CodePostal> findAll();

    List<CodePostal> findRange(int[] range);

    int count();
    
}
