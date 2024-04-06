package com.libnexus.bsgdx.plugin.core.boid.prejudice.agency;

import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.ColorUtils;
import com.libnexus.boidsimulator.util.Vector2f;
import com.libnexus.bsgdx.plugin.core.boid.prejudice.PrejudiceBoid;
import com.sun.source.tree.LiteralTree;

import java.util.HashSet;
import java.util.Iterator;

public class PrejudiceRedBoidAgency extends PluginBoidAgency {
    public PrejudiceRedBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new PrejudiceBoid(this, location, PrejudiceBoid.RED);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{"core:prejudice:red"};
    }

    @Override
    public int[] keyBindings() {
        return new int[]{};
    }

    @Override
    public String name() {
        return "Red Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return false;
    }

    @Override
    public void killAll() {

        for (Iterator<Boid> boids = plugin.getAllBoids().iterator(); boids.hasNext(); ) {
            Boid boid = boids.next();
            if (boid.getClass() == PrejudiceBoid.class && ColorUtils.equals(PrejudiceBoid.RED, boid.currColour))
                plugin.removeBoid(boid);
        }
    }
}
