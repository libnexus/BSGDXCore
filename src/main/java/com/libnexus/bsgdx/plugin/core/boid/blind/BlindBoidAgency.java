package com.libnexus.bsgdx.plugin.core.boid.blind;

import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class BlindBoidAgency extends PluginBoidAgency {
    public BlindBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new BlindBoid(this, location);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{"core:blind", "blind", "BDBoid"};
    }

    @Override
    public int[] keyBindings() {
        return new int[]{Input.Keys.NUM_4};
    }

    @Override
    public String name() {
        return "Blind Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == BlindBoid.class;
    }
}
