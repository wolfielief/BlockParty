package com.BlockParty.game;

import com.BlockParty.BlockParty;
import wueffi.MiniGameCore.api.GameStartEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RoundManager implements Listener {

    private final BlockParty plugin;

    public RoundManager(BlockParty plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onGameStart(GameStartEvent event) {
        if (!event.getGameName().equalsIgnoreCase("BlockParty")) {
            return;
        }

        Round round = new Round(plugin, event.getLobby());

        Bukkit.getPluginManager().registerEvents(round, plugin);

        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> round.runRound(1.234f),
                20L * 10
        );
    }
}