package com.libnexus.bsgdx.plugin.core.boid.prejudice.agency;

import com.libnexus.boidsimulator.util.Colour;
import com.libnexus.bsgdx.plugin.core.boid.prejudice.PrejudiceBoid;
import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

import java.util.HashSet;

public class PrejudiceBlueBoidAgency extends PluginBoidAgency {
    public PrejudiceBlueBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new PrejudiceBoid(this, location, PrejudiceBoid.BLUE);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{ "core:prejudice:blue" };
    }

    @Override
    public int[] keyBindings() {
        return new int[]{  };
    }

    @Override
    public String name() {
        return "Blue Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return false;
    }

    @Override
    public void killAll() {
        for (Boid boid : new HashSet<>(plugin.getWorldBoids()))
            if (boid.getClass() == PrejudiceBoid.class && Colour.equals(PrejudiceBoid.BLUE, boid.currColour))
                plugin.removeBoid(boid);
    }
}
