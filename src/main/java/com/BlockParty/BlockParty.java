package com.BlockParty;

import com.BlockParty.game.Round;
import com.BlockParty.game.RoundManager;
import com.BlockParty.generic.copyWorldAndConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockParty extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting up BlockParty Plugin...");

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(
                new RoundManager(this),
                this
        );
        getLogger().info("Registered Events!");

        copyWorldAndConfig.setup(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BlockParty has been disabled!");
    }
}