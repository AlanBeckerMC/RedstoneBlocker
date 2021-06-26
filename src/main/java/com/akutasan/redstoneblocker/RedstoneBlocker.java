package com.akutasan.redstoneblocker;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class RedstoneBlocker extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this,this);
        getLogger().info(" succesfully activated!");
    }

    @Override
    public void onDisable() {
        getLogger().info(" succesfully deactivated!");
    }

    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onHopperItemPickup(InventoryPickupItemEvent e){
        if (e.getInventory().getType().equals(InventoryType.HOPPER)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPistonExtend(BlockPistonExtendEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPistonRetract(BlockPistonRetractEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onRedstoneBlock(BlockRedstoneEvent e) {
        e.setNewCurrent(0);
    }
}
