package com.libnexus.bsgdx.plugin.core.boid.disruptive;

import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class DisruptiveBoidAgency extends PluginBoidAgency {
    public DisruptiveBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new DisruptiveBoid(this, location);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{"core:disruptive", "disruptive", "DBoid"};
    }

    @Override
    public int[] keyBindings() {
        return new int[]{Input.Keys.NUM_3, Input.Keys.D};
    }

    @Override
    public String name() {
        return "Disruptive Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == DisruptiveBoid.class;
    }
}
