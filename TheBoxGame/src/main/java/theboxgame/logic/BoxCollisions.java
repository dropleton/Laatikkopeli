/**
 * Apuluokka luokalle MovingLogic, sisältää tarkistukset pelaajan tai laatikon
 * laatikkoon törmäämisestä.
 */

package theboxgame.logic;

import theboxgame.entities.Entity;

public class BoxCollisions {
    
    /**
     * Metodi tarkistaa, onko yläpuolella laatikkoa.
     * @param e MovingLogic-luokalta saatu Entity
     * @return Totuusarvomuuttuja, törmääkö laatikkoon vai ei.
     */
    public boolean isAboveABox(Entity e) {
        if(e.getTile().getUp().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko oikealla laatikkoa.
     * @param e MovingLogic-luokalta saatu Entity
     * @return Totuusarvomuuttuja, törmääkö laatikkoon vai ei.
     */
    public boolean isRightABox(Entity e) {
        if (e.getTile().getRight().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko vasemmalla laatikkoa.
     * @param e MovingLogic-luokalta saatu Entity
     * @return Totuusarvomuuttuja, törmääkö laatikkoon vai ei.
     */
    public boolean isLeftABox(Entity e) {
        if (e.getTile().getLeft().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko alapuolella laatikkoa.
     * @param e MovingLogic-luokalta saatu Entity
     * @return Totuusarvomuuttuja, törmääkö laatikkoon vai ei.
     */
    public boolean isUnderABox(Entity e) {
        if (e.getTile().getDown().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

}
