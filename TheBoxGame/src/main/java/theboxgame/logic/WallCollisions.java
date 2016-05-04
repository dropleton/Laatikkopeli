/**
 * Apuluokka luokalle MovingLogic, sisältää tarkistukset laatikon tai pelaajan
 * seinään törmäämisestä.
 */
package theboxgame.logic;

import theboxgame.entities.Entity;

public class WallCollisions {

    /**
     * Metodi tarkistaa, törmääkö parametrina saatu Entity seinään.
     *
     * @param entity MovingLogic-luokasta saatu entity
     * @return Totuusarvomuuttuja, törmääkö seinään vai ei
     */
    public boolean isAboveAWall(Entity entity) {
        if (entity.getTile().getUp().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, törmääkö parametrina saatu Entity seinään.
     *
     * @param entity MovingLogic-luokasta saatu entity
     * @return Totuusarvomuuttuja, törmääkö seinään vai ei
     */
    public boolean isUnderAWall(Entity entity) {
        if (entity.getTile().getDown().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, törmääkö parametrina saatu Entity seinään.
     *
     * @param entity MovingLogic-luokasta saatu entity
     * @return Totuusarvomuuttuja, törmääkö seinään vai ei
     */
    public boolean isRightAWall(Entity entity) {
        if (entity.getTile().getRight().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa, törmääkö parametrina saatu Entity seinään.
     *
     * @param entity MovingLogic-luokasta saatu entity
     * @return Totuusarvomuuttuja, törmääkö seinään vai ei
     */
    public boolean isLeftAWall(Entity entity) {
        if (entity.getTile().getLeft().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

}
