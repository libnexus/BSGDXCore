package com.libnexus.bsgdx.plugin.core.boid.chameleon;

import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class ChameleonBoidAgency extends PluginBoidAgency {
    public ChameleonBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new ChameleonBoid(this, location);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{ "core:chameleon", "chameleon", "CMBoid" };
    }

    @Override
    public int[] keyBindings() {
        return new int[]{ Input.Keys.NUM_6 };
    }

    @Override
    public String name() {
        return "Chameleon Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == ChameleonBoid.class;
    }
}
