/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.comparator;

import java.util.Comparator;
import shapes.AShape;

/**
 *
 * @author leo
 */
public class ById implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {
       AShape s1 = (AShape)o1;
       AShape s2 = (AShape)o2;
        if(s1.getID()<s2.getID()) {
            return -1;
        } else if(s1.getID()>s2.getID()) {
            return 1;
        }
        return 0;
    }

    
}
