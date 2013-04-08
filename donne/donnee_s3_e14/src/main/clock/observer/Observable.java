package clock.observer;

/**
 * Cette interface existe déjà dans java standard, mais pour l'exercise, je la refait.
 * définit les méthodes pour pour les objets qui doivent être écouté
 * @author Numa de Montmollin
 */
public interface Observable {
    
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObs();
}
