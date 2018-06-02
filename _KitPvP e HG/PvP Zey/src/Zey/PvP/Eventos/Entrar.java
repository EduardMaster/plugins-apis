package Zey.PvP.Eventos;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.APIs.WarpAPI;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;

public class Entrar implements Listener
{
	@EventHandler
    public void Join(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        
        TheTitle.sendTitle(p, Main.prefix);
        TheTitle.sendSubTitle(p, "§fTreine para se tornar o melhor!");

        KitAPI.remove(p);
        Habilidade.removeAbility(p);
        KitAPI.removeAbility(p);
        BuildCommand.embuild.remove(p);
        p.setGameMode(GameMode.SURVIVAL);
        WarpAPI.setWarp(p, "Spawn");
        
		Proteção.setImortal(p, true);
		Proteção.isImortal(p);
        
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§a  ");
        p.sendMessage("§c" + Main.prefix + " §7» §fTreine para se tornar o melhor!");
        p.sendMessage("§a  ");
        
        p.teleport(p.getWorld().getSpawnLocation());
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        e.setJoinMessage((String)null);
        p.getInventory().clear();
        
    	final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrohotx = vidrohot.getItemMeta();
        vidrohotx.setDisplayName("§6§lZey§f§lPvP");
        vidrohot.setItemMeta(vidrohotx);
        
        p.getInventory().setItem(0, vidrohot);
        p.getInventory().setItem(1, vidrohot);
        KitAPI.setitem(p, Material.PAPER, "§e§lWARPS", 2, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(3, vidrohot);
        KitAPI.setitem(p, Material.ENDER_CHEST, "§e§lKITS", 4, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(5, vidrohot);
        KitAPI.setitem(p, Material.BOOK, "§e§lMENU GERAL", 6, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(7, vidrohot);
        p.getInventory().setItem(8, vidrohot);
        
        p.performCommand("tag normal");
}
    
	@EventHandler
    public void Morte(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().setHelmet((ItemStack)null);
        p.getInventory().setChestplate((ItemStack)null);
        p.getInventory().setLeggings((ItemStack)null);
        p.getInventory().setBoots((ItemStack)null);
        p.getInventory().clear();
        
        KitAPI.remove(p);
        Habilidade.removeAbility(p);
        KitAPI.removeAbility(p);
        BuildCommand.embuild.remove(p);
        p.setGameMode(GameMode.SURVIVAL);
        WarpAPI.setWarp(p, "Spawn");
        
		Proteção.setImortal(p, true);
		Proteção.isImortal(p);
        
    	final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrohotx = vidrohot.getItemMeta();
        vidrohotx.setDisplayName("§6§lZey§f§lPvP");
        vidrohot.setItemMeta(vidrohotx);
        
        p.getInventory().setItem(0, vidrohot);
        p.getInventory().setItem(1, vidrohot);
        KitAPI.setitem(p, Material.PAPER, "§e§lWARPS", 2, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(3, vidrohot);
        KitAPI.setitem(p, Material.ENDER_CHEST, "§e§lKITS", 4, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(5, vidrohot);
        KitAPI.setitem(p, Material.BOOK, "§e§lMENU GERAL", 6, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(7, vidrohot);
        p.getInventory().setItem(8, vidrohot);

        TheTitle.sendTitle(p, Main.prefix);
        TheTitle.sendSubTitle(p, "§7Você morreu.");
    }
    
    public static void setitem(final Player p, final Material mat, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.addEnchant(enchant, level, trueorfalse);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }

    @EventHandler
    public void onSair(final PlayerQuitEvent e) {
        @SuppressWarnings("unused")
		final Player p = e.getPlayer();
        e.setQuitMessage((String)null);
    }
}
