package com.libnexus.bsgdx.plugin.core.boid.jeb;

import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.util.ColorUtils;
import com.libnexus.boidsimulator.util.Vector2f;

public class Jeb extends Boid {

    private Color lastColor = Color.BLUE;
    private Color targetColor = Color.RED;
    private float progress = 1.1f;

    public Jeb(BoidAgency agency, Vector2f location) {
        super(agency, location, Color.BLUE);
    }

    @Override
    public void update() {
        super.update();

        if (progress > 1) {
            lastColor = targetColor;
            if (ColorUtils.equals(targetColor, Color.RED)) {
                targetColor = Color.GREEN;
            } else if (ColorUtils.equals(targetColor, Color.GREEN)) {
                targetColor = Color.CYAN;
            } else if (ColorUtils.equals(targetColor, Color.CYAN)) {
                targetColor = Color.RED;
            }
            progress = 0;
        }

        progress += .001f;

        currColour.set(ColorUtils.difference(lastColor, targetColor, progress));
    }

    public String colour(Color color) {
        return String.format("(%s, %s, %s)", color.r, color.g, color.b);
    }
}
