package com.libnexus.bsgdx.plugin.core.boid.blind;

import com.badlogic.gdx.Gdx;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.ColorUtils;
import com.libnexus.boidsimulator.util.Vector2f;

import java.util.concurrent.atomic.AtomicInteger;

public class BlindBoid extends Boid {

    public BlindBoid(BoidAgency agency, Vector2f location) {
        super(agency, location, ColorUtils.fromRGB(0, 155, 155, 1));
    }

    @Override
    public Vector2f perceivedCentre() {
        Vector2f centre = new Vector2f((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);
        AtomicInteger neighbours = new AtomicInteger();

        worldCell.forEachBoidNeighbour(boid -> {
            if (currLocation.distance(boid.currLocation) < currVisualRange && !(boid.getClass() == BlindBoid.class)) {
                neighbours.getAndIncrement();
                centre.add(boid.perceivedCentre());
            }
        });

        if (neighbours.get() > 0)
            centre.divideBy(neighbours.get() * 2);

        return centre;
    }
}
