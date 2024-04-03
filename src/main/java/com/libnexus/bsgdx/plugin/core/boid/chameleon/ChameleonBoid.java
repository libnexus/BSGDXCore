package com.libnexus.bsgdx.plugin.core.boid.chameleon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.boidsimulator.util.Vector2f;

import java.util.HashMap;

public class ChameleonBoid extends Boid {
    private Color targetColour = null;
    private int progress;

    public ChameleonBoid(BoidAgency agency, Vector2f location) {
        super(agency, location, Colour.fromRGB(255, 255, 255, 1));
    }

    @Override
    public void update() {
        super.update();
        progress++;

        if (targetColour != null && Colour.equals(currColour, targetColour)) {
            if (progress < 800) {
                return;
            }

            progress = 0;
            targetColour = null;
        }

        if (targetColour == null) {
            for (Boid boid : World.boids()) {
                if (currLocation.distance(boid.currLocation) > currVisualRange)
                    continue;
                if (Colour.equals(currColour, boid.currColour))
                    continue;
                else if (boid instanceof ChameleonBoid cBoid && cBoid.targetColour != null && (
                        !Colour.equals(cBoid.currColour, cBoid.targetColour)))
                continue;

                targetColour = boid.currColour.cpy();
                progress = 0;
                break;
            }
        } else {
            currColour.set(Colour.difference(currColour, targetColour, (float) progress / 400));
        }
    }

    @Override
    public void drawFov(ShapeRenderer shapeRenderer) {
        super.drawFov(shapeRenderer);
        if (targetColour != null) {
            Gdx.gl.glLineWidth(1);
            shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        }
    }
}
