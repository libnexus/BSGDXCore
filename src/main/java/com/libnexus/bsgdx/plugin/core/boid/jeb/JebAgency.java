package com.libnexus.bsgdx.plugin.core.boid.jeb;

import com.badlogic.gdx.Input;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.boidsimulator.api.plugin.PluginBoidAgency;
import com.libnexus.boidsimulator.entity.boid.Boid;
import com.libnexus.boidsimulator.util.Vector2f;

public class JebAgency extends PluginBoidAgency {
    public JebAgency(Plugin plugin) {
        super(plugin);
    }

    @Override
    public Jeb make(Vector2f location) {
        return new Jeb(this, location);
    }

    @Override
    public String[] qualifiers() {
        return new String[]{"core:jeb", "jeb", "JEBoid"};
    }

    @Override
    public int[] keyBindings() {
        return new int[]{Input.Keys.NUM_7};
    }

    @Override
    public String name() {
        return "Jeb Agency";
    }

    @Override
    public boolean takeResponsibility(Boid boid) {
        return boid.getClass() == Jeb.class;
    }
}
