/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.CodePostal;

/**
 *
 * @author clocal
 */
@Remote
public interface CodePostalFacadeRemote {

    void create(CodePostal codePostal);

    void edit(CodePostal codePostal);

    void remove(CodePostal codePostal);

    CodePostal find(Object id);
    
    CodePostal findByCodePostal(String codePostal);

    List<CodePostal> findAll();

    List<CodePostal> findRange(int[] range);

    int count();
    
}