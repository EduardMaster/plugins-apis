package Net.Hunger.Eventos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class DropItem implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent e) {
    Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("backpacker") && (e.getItemDrop().getItemStack().getType() == Material.LEATHER)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("crafter") && (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("demoman") && (e.getItemDrop().getItemStack().getType() == Material.GRAVEL)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("grandpa") && (e.getItemDrop().getItemStack().getType() == Material.STICK)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("well") && (e.getItemDrop().getItemStack().getType() == Material.GOLD_NUGGET)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("demoman") && (e.getItemDrop().getItemStack().getType() == Material.STONE_PLATE)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("endermage") && (e.getItemDrop().getItemStack().getType() == Material.PORTAL)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("jellyfish") && (e.getItemDrop().getItemStack().getType() == Material.CLAY_BALL)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("enderman") && (e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if(Habilidade.getAbility(p).equalsIgnoreCase("fisherman")  && (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("gladiator") && (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("grappler") && (e.getItemDrop().getItemStack().getType() == Material.LEASH)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("kangaroo") && (e.getItemDrop().getItemStack().getType() == Material.FIREWORK)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("monk") && (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("reaper") && (e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("specialist") && (e.getItemDrop().getItemStack().getType() == Material.BOOK)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("thor") && (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("timelord") && (e.getItemDrop().getItemStack().getType() == Material.WATCH)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
    if (Habilidade.getAbility(p).equalsIgnoreCase("wolff") && (e.getItemDrop().getItemStack().getType() == Material.FLINT)) {
    e.setCancelled(true);
    p.updateInventory();
    p.sendMessage("§7[§a!§7] Você não pode transferir o item do seu kit no inventario!");
    }
  }
}