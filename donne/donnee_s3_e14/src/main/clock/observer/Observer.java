package clock.observer;

/**
 * Cette interface existe déjà dans java standard, mais pour l'exercise, je la refait.
 * Définit les méthodes que doit impléementer tout oberserver.
 * @author Numa de Montmollin
 */
public interface Observer {
    
    public void update(int hour, int minute, int second);
}
