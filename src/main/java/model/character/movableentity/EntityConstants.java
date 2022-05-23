package model.character.movableentity;

import controller.Controller;

/**
 * This is a static class where all the main environment constants are
 * contained. The constants can be modified to fit any possible environment
 */
public final class EntityConstants {

    /**
     * Field that represents the max horizontal speed (in module) reachable in this
     * environment.
     */
    public static final double MAXHORIZONTALSPEED = 5 / Controller.TPS;
    /**
     * Field that represents the max vertical speed (in module) reachable in this
     * environment.
     */
    public static final double MAXVERTICALSPEED = 8 / Controller.TPS;
    /**
     * Field that represents the speed reached by the jumping subjects in this
     * environment.
     */
    public static final double JUMP = -13 / Controller.TPS;
    /**
     * Field that represents the horizontal deceleration (in module) in this
     * environment.
     */
    public static final double DECELERATION = 1 / Controller.TPS;
    /**
     * Field that represents the horizontal acceleration (in module) in this
     * environment.
     */
    public static final double ACCELERATION = 0.5 / Controller.TPS;
    /**
     * Field that represents the vertical acceleration in this environment.
     */
    public static final double GRAVITY = 9.81 / Math.pow(Controller.TPS, 2);

    private EntityConstants() {
    }
}