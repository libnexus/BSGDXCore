package com.libnexus.bsgdx.plugin.core;

import com.badlogic.gdx.graphics.Color;
import com.libnexus.boidsimulator.BoidSimulator;
import com.libnexus.boidsimulator.api.plugin.Plugin;
import com.libnexus.bsgdx.plugin.core.boid.blind.BlindBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.chameleon.ChameleonBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.disruptive.DisruptiveBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.killer.KillerBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.prejudice.agency.PrejudiceBlueBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.prejudice.agency.PrejudiceBoidAgency;
import com.libnexus.bsgdx.plugin.core.boid.prejudice.agency.PrejudiceRedBoidAgency;

public class Core extends Plugin {
    public Core(BoidSimulator simulator) {
        super(simulator);
    }

    @Override
    public void init() {
        addAgency(new BlindBoidAgency(this));
        addAgency(new DisruptiveBoidAgency(this));
        addAgency(new PrejudiceBoidAgency(this));
        addAgency(new KillerBoidAgency(this));
        addAgency(new ChameleonBoidAgency(this));

        addAgency(new PrejudiceBlueBoidAgency(this));
        addAgency(new PrejudiceRedBoidAgency(this));

        console().announce("core", Color.CYAN, "initialized");
    }

    @Override
    public void dispose() {

    }

    @Override
    public String name() {
        return "Core";
    }
}
