package factory;

import simj.SimEntity;
import simj.SimResource;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class ReparationSite extends SimResource {

    public ReparationSite(int pCapacity, String pResourceName) {
        super(pCapacity, pResourceName);
    }

    @Override
    protected double getServiceTime(SimEntity pEntity) {
        return 0;
    }
}
