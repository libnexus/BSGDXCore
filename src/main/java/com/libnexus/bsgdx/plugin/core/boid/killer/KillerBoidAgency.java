package com.libnexus.bsgdx.plugin.core.boid.killer;

import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class KillerBoidAgency extends PluginBoidAgency {
    public KillerBoidAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Boid make(Vector2f location) {
        return new KillerBoid(this, location);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{"core:killer", "killer", "KBoid"};
    }

    @Override
    public int[] keyBindings() {
        return new int[]{Input.Keys.NUM_5, Input.Keys.K};
    }

    @Override
    public String name() {
        return "Killer Boid Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == KillerBoid.class;
    }
}
