package com.starshootercity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Wither;

public class BetterWitherWrapper {
    private final Wither wither;
    public BetterWitherWrapper(Wither wither) {
        this.wither = wither;

        Bukkit.getMobGoals().removeAllGoals(wither);
    }

    public void gotHurt(double damage) {

    }
}
