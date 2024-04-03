package com.libnexus.bsgdx.plugin.core.boid.killer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.entity.boid.BoidAgency;
import com.libnexus.boidsimulator.entity.effect.ExplosionEffect;
import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.boidsimulator.util.Vector2f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KillerBoid extends Boid {
    private final HashMap<Boid, Integer> enemies = new HashMap<>();

    public KillerBoid(BoidAgency agency, Vector2f location) {
        super(agency, location, Colour.fromRGB(76, 0, 153, 1));
    }

    @Override
    public void update() {
        super.update();
        final HashMap<Boid, Integer> tempEnemies = new HashMap<>(enemies);
        enemies.clear();
        for (Boid boid : new HashSet<>(World.boids())) {
            if (boid == this)
                continue;

            if (boid.currLocation.distance(currLocation) < currVisualRange) {
                Integer boidInRangeFor = tempEnemies.getOrDefault(boid, null);
                if (boidInRangeFor == null)
                    enemies.put(boid, 1);
                else if (boidInRangeFor > 450) {
                    ExplosionEffect.forBoid(boid);
                    boid.agency.kill(boid);
                } else
                    enemies.put(boid, boidInRangeFor + 1);
            }
        }
    }

    @Override
    public void drawFov(ShapeRenderer shapeRenderer) {
        super.drawFov(shapeRenderer);
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        for (Map.Entry<Boid, Integer> boidTimer : enemies.entrySet()) {
            shapeRenderer.setColor(Colour.difference(currColour, boidTimer.getKey().currColour, (float) boidTimer.getValue() / 450));
            Vector2f tl = boidTimer.getKey().currLocation;
            shapeRenderer.line(new Vector2(tl.x, tl.y), new Vector2(currLocation.x, currLocation.y));
        }
    }
}
