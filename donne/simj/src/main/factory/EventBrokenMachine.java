/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import simj.SimEvent;
import simj.SimRandom;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class EventBrokenMachine extends SimEvent{

    private SimRandom random = SimRandom.getUniqueInstance();
    private double tNextBroken;
    
    private EventBrokenMachine(double tNextBroken) {
        super(0);
        this.tNextBroken = tNextBroken;
    }
    
    @Override
    public void execute() {
        
        this.schedule(getNextBrokenMachine());
    }
    
    private double getNextBrokenMachine() {
        return getCurrentTime()+random.expo(tNextBroken);
    }
}
