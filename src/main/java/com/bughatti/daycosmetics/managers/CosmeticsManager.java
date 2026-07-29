package com.bughatti.daycosmetics.managers;

import com.bughatti.daycosmetics.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CosmeticsManager {

    private final Main plugin;
    private final Map<UUID, String> selectedKillEffect = new HashMap<>();
    private final Map<UUID, String> selectedTag = new HashMap<>();

    public CosmeticsManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setKillEffect(UUID uuid, String effectKey) {
        selectedKillEffect.put(uuid, effectKey);
    }

    public String getKillEffect(UUID uuid) {
        return selectedKillEffect.getOrDefault(uuid, "none");
    }

    public void setTag(UUID uuid, String tagKey) {
        selectedTag.put(uuid, tagKey);
    }

    public String getTag(UUID uuid) {
        return selectedTag.getOrDefault(uuid, "none");
    }
}
