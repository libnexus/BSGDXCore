package com.libnexus.bsgdx.plugin.core.boid.blind;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.boidsimulator.util.Vector2f;

import static com.libnexus.boidsimulator.World.RANDOM;

public class BlindBoid extends Boid {

    public BlindBoid(BoidAgency agency, Vector2f location) {
        super(agency, location, Colour.fromRGB(0, 155, 155, 1));
    }

    @Override
    public Vector2f perceivedCentre() {
        Vector2f centre = new Vector2f((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);
        int neighbours = 0;

        for (Boid boid : World.boids()) {
            if (currLocation.distance(boid.currLocation) < currVisualRange && !(boid.getClass() == BlindBoid.class)) {
                neighbours++;
                centre.add(boid.perceivedCentre());
            }
        }

        if (neighbours > 0)
            centre.divideBy(neighbours * 2);

        return centre;
    }
}
