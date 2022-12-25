package dev.lupluv.challenges.inventories;

import dev.lupluv.challenges.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MainInventory implements Listener {

    public Inventory inventory;
    public String invName;

    public MainInventory() {
        this.invName = MessageUtil.getMessage("inventories.main_inventory.title");
        this.inventory = Bukkit.createInventory(null, 9*5, invName);

    }

    public void openInventory(Player player){
        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){

    }

}
