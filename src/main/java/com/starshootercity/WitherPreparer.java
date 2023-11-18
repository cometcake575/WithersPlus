package com.starshootercity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.world.EntitiesLoadEvent;

import java.util.HashMap;
import java.util.Map;

public class WitherPreparer implements Listener {
    private final Map<Wither, BetterWitherWrapper> registeredWithers = new HashMap<>();
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Wither wither) {
            registeredWithers.put(wither, new BetterWitherWrapper(wither));
        }
    }

    @EventHandler
    public void onEntitiesLoad(EntitiesLoadEvent event) {
        for (Entity entity : event.getEntities()) {
            if (entity instanceof Wither wither) {
                registeredWithers.put(wither, new BetterWitherWrapper(wither));
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Wither wither) {
            BetterWitherWrapper wrapper = registeredWithers.get(wither);
            wrapper.gotHurt(event.getFinalDamage());
        }
    }
}
