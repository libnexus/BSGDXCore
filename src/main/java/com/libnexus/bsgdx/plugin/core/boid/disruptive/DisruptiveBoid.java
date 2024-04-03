package com.libnexus.bsgdx.plugin.core.boid.disruptive;

import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.boidsimulator.util.Vector2f;

public class DisruptiveBoid extends Boid {
    public DisruptiveBoid(BoidAgency boidAgency, Vector2f location) {
        super(boidAgency, location, null, 8, 2, 8, 15, null, 0.01f, 0.05f, Colour.fromRGB(255, 255, 0, 1));
    }

    @Override
    public void update() {
        super.update();
        for (Boid boid : World.boids()) {
            if (currLocation.distance(boid.currLocation) < (currVisualRange / 2f)) {
                boid.currVelocity.add(currVelocity.opposite().multiplyBy(currCentringFactor * 10));
            }
        }
    }
}
