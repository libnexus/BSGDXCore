package com.libnexus.bsgdx.plugin.core.boid.prejudice;

import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.boidsimulator.util.Vector2f;

public class PrejudiceBoid extends Boid {
    public static final Color RED = Colour.fromRGB(205, 0, 0, 1);
    public static final Color BLUE = Colour.fromRGB(0, 0, 205, 1);

    public PrejudiceBoid(BoidAgency agency, Vector2f location, Color colour) {
        super(agency, location, colour);
    }

    @Override
    public void avoidOthers() {
        Vector2f move = new Vector2f(0, 0);
        for (Boid boid : World.boids()) {
            if (boid == this)
                continue;

            if (currLocation.distance(boid.currLocation) < currShynessThreshold) {
                if (!Colour.equals(currColour, boid.currColour)) {
                    currVelocity.add(boid.currVelocity.opposite().divideBy(currLocation.subtracted(boid.currLocation).abs()));
                } else {
                    move.add(currLocation.subtracted(boid.currLocation));
                }
            }
        }

        currVelocity.add(move.multipliedBy(currShynessFactor));

        keepWithinBounds();
    }
}
