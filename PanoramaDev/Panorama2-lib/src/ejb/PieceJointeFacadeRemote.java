/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.PieceJointe;

/**
 *
 * @author clocal
 */
@Remote
public interface PieceJointeFacadeRemote {

    void create(PieceJointe pieceJointe);

    void edit(PieceJointe pieceJointe);

    void remove(PieceJointe pieceJointe);

    PieceJointe find(Object id);

    List<PieceJointe> findAll();

    List<PieceJointe> findRange(int[] range);

    int count();
    
}
