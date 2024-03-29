package fr.utt.classes.controler;

import fr.utt.classes.model.GameManager;

/**
 * This class is where all the controllers inherit from.
 * It's only made in case you want to add another controller but it's not used in the code yet.
 * We left it here to make the code easier to improve.
 *
 * @author Edgar
 */
public abstract class AbstractControler {

    protected GameManager gm;

    /**
     * Create an <code>AbstractControler</code> object
     *
     * @param gm GameManager the name of the main class of our model{@link fr.utt.classes.model.GameManager}
     */
    public AbstractControler(GameManager gm) {
        this.gm = gm;
    }
}
