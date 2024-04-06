package com.libnexus.bsgdx.plugin.core.boid.chameleon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.ColorUtils;
import com.libnexus.boidsimulator.util.Vector2f;

public class ChameleonBoid extends Boid {
    private Color targetColour = null;
    private int progress;

    public ChameleonBoid(BoidAgency agency, Vector2f location) {
        super(agency, location, ColorUtils.fromRGB(255, 255, 255, 1));
    }

    @Override
    public void update() {
        super.update();
        progress++;

        if (targetColour != null && ColorUtils.equals(currColour, targetColour)) {
            if (progress < 800) {
                return;
            }

            progress = 0;
            targetColour = null;
        }

        if (targetColour == null) {
            worldCell.forEachBoidNeighbour(boid -> {
                if (currLocation.distance(boid.currLocation) > currVisualRange) return;
                if (ColorUtils.equals(currColour, boid.currColour)) return;
                else if (boid instanceof ChameleonBoid cBoid && cBoid.targetColour != null && (
                        !ColorUtils.equals(cBoid.currColour, cBoid.targetColour))) return;
                if (targetColour != null) return;

                targetColour = boid.currColour.cpy();
                progress = 0;
            });
        } else {
            currColour.set(ColorUtils.difference(currColour, targetColour, (float) progress / 400));
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

