package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class TestClick 
implements Listener, CommandExecutor
{
	public static ArrayList<String> click = new ArrayList();
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("testclick")){
			if(click.contains(p.getName())){
				p.sendMessage("§c§lClickTeste: §7Voce ja esta testando seu click !");
				return true;
			}
			if(Array.used.contains(p.getName())){
				p.sendMessage("§c§lClickTeste: §7Retire seu kit para usar o test-click !");
				return true;
			}
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					p.getInventory().clear();
					p.sendMessage("§c§lClickTeste: §7Iniciando Teste-Click...");
					p.sendMessage("§c§lClickTeste: §7Voce tem §c10 §7segundos para mostrar sua habilidade !");
					p.sendMessage("§c§lClickTeste: §4Lembre-se de clicar no ar sem nenhum item na mao !");
					click.add(p.getName());
				}
			}, 0 * 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					if(click.contains(p.getName())){
					click.remove(p.getName());
					p.sendMessage("§c§lClickTeste: §7Voce deu §c" + p.getLevel() + " §7clicks em §c10 §7segundos !");
					p.setLevel(0);
		              String d = p.getName();
		              ItemStack kits = new ItemStack(Material.CHEST);
		      		ItemMeta kits2 = kits.getItemMeta();
		      		kits2.setDisplayName("§a» Kits «");
		      		kits.setItemMeta(kits2);
		      		
		      		
		      		
		      		ItemStack warps = new ItemStack(Material.PAPER);
		      		ItemMeta warps2 = warps.getItemMeta();
		      		warps2.setDisplayName("§7» Warps «");
		      		warps.setItemMeta(warps2);
		      		
		      		ItemStack d1 = new ItemStack(Material.GHAST_TEAR);
		      		ItemMeta d2 = d1.getItemMeta();
		      		d2.setDisplayName("§1» CoinsDiario «");
		      		d1.setItemMeta(d2);
		      		
		      		ItemStack i1 = new ItemStack(Material.CLAY_BRICK);
		      		ItemMeta i2 = i1.getItemMeta();
		      		i2.setDisplayName("§c» Informaçoes «");
		      		i1.setItemMeta(i2);
		      		
		      		ItemStack a1 = new ItemStack(Material.IRON_INGOT);
		      		ItemMeta a2 = a1.getItemMeta();
		      		a2.setDisplayName("§6» Extra «");
		      		a1.setItemMeta(a2);
		      		
		      		ItemStack c1 = new ItemStack(Material.NAME_TAG);
		      		ItemMeta c2 = c1.getItemMeta();
		      		c2.setDisplayName("§2» Click-Test «");
		      		c1.setItemMeta(c2);
		      		
		      		ItemStack loja = new ItemStack(Material.EMERALD);
		      		ItemMeta loja2 = loja.getItemMeta();
		      		loja2.setDisplayName("§a» Loja «");
		      		loja.setItemMeta(loja2);
		      		
		      		
		      		
		      		
		      		p.getInventory().clear();
		      		p.getInventory().setArmorContents(null);
		      		p.teleport(p.getWorld().getSpawnLocation());
		      		p.setGameMode(GameMode.ADVENTURE);
		      		p.getInventory().setItem(4, kits);
		    		p.getInventory().setItem(3, warps);
		    		p.getInventory().setItem(1, i1);
		    		p.getInventory().setItem(5, loja);
		    		p.getInventory().setItem(2, a1);
		    		p.getInventory().setItem(6, c1);
		    		p.getInventory().setItem(7, d1);
					}
				}
			}, 10 * 20L);
			return true;
		}
		return true;
	}
	
	@EventHandler
	public void clicar(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if((click.contains(p.getName())) && (e.getAction() == Action.LEFT_CLICK_AIR) && (p.getItemInHand().getType() == Material.AIR)){
		        p.setLevel(p.getLevel() + 1);
		}
	}
}
