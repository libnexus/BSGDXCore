package com.libnexus.bsgdx.plugin.core.boid.prejudice.agency;

import com.libnexus.bsgdx.plugin.core.boid.prejudice.PrejudiceBoid;
import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.World;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class PrejudiceBoidAgency extends PluginBoidAgency {
    public PrejudiceBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new PrejudiceBoid(this, location, World.RANDOM.nextInt(2) == 0 ? PrejudiceBoid.RED : PrejudiceBoid.BLUE);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{ "core:prejudice", "prejudice", "PBoid" };
    }

    @Override
    public int[] keyBindings() {
        return new int[]{ Input.Keys.NUM_2, Input.Keys.R };
    }

    @Override
    public String name() {
        return "Red/Blue Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == PrejudiceBoid.class;
    }
}
