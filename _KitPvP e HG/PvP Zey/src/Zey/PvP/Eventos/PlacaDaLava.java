package Zey.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Main.Main;

public class PlacaDaLava implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("[facil]")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Fácil)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("[medio]")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Médio)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("[dificil]")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Difícil)");
		}
		
		if(e.getLine(0).equalsIgnoreCase("[extremo]")) {
			e.setLine(0, "");
			e.setLine(1, "§c§lCHALLENGE");
			e.setLine(2, "");
			e.setLine(3, "§7(Extremo)");
		}
	}
	
	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
			   if (e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Fácil)")) &&  	
					Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
				
				p.sendMessage(String.valueOf(Main.prefix) + " §7» Você completou o challenge §efácil§7.");
				
				ZeyCoins.addMoney(p, 200);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.remove(p);
	            
	            final World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
	            final double x = Main.instance.getConfig().getDouble("lava.x");
	            final double y = Main.instance.getConfig().getDouble("lava.y");
	            final double z = Main.instance.getConfig().getDouble("lava.z");
	            final Location lobby = new Location(w, x, y, z);
	            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
	            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
                p.teleport(lobby);
	            
				Habilidade.setAbility(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				
				p.sendMessage(String.valueOf(Main.prefix) + " §7» Você ganhou §e§l200 ZeyCoins§7.");
				
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Médio)")) &&  	
					Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
				
				p.sendMessage(String.valueOf(Main.prefix) + " §7» Você completou o challenge §emedio§7.");
				
				ZeyCoins.addMoney(p, 300);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.remove(p);
				
	            final World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
	            final double x = Main.instance.getConfig().getDouble("lava.x");
	            final double y = Main.instance.getConfig().getDouble("lava.y");
	            final double z = Main.instance.getConfig().getDouble("lava.z");
	            final Location lobby = new Location(w, x, y, z);
	            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
	            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
                p.teleport(lobby);
	            
                Habilidade.setAbility(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				
		        p.sendMessage(String.valueOf(Main.prefix) + " §7» Você ganhou §e§l300 ZeyCoins§7.");
				
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Difícil)")) &&  	
					Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
				
				p.sendMessage(String.valueOf(Main.prefix) + " §7» Você completou o challenge §edifício§7.");
				
				
				ZeyCoins.addMoney(p, 500);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
		        KitAPI.remove(p);
				
	            final World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
	            final double x = Main.instance.getConfig().getDouble("lava.x");
	            final double y = Main.instance.getConfig().getDouble("lava.y");
	            final double z = Main.instance.getConfig().getDouble("lava.z");
	            final Location lobby = new Location(w, x, y, z);
	            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
	            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
                p.teleport(lobby);
	            
                Habilidade.setAbility(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				
		        p.sendMessage(String.valueOf(Main.prefix) + " §7» Você ganhou §e§l500 ZeyCoins§7.");
				
		}
			
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§c§lCHALLENGE")) &&
					(lines.length > 2) && (lines[2].equals("")) &&
					(lines.length > 3) && (lines[3].equals("§7(Extremo)")) &&  	
					Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
				
				p.sendMessage(String.valueOf(Main.prefix) + " §7» Você completou o challenge §eextremo§7.");
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §7» O jogador(a): §e" + p.getName() + " §7compretou o challenger, §c§LEXTREMO§7.");
				Bukkit.broadcastMessage(" ");
				
				ZeyCoins.addMoney(p, 1000);
				
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
		        KitAPI.remove(p);
				
	            final World w = Bukkit.getServer().getWorld(Main.instance.getConfig().getString("lava.world"));
	            final double x = Main.instance.getConfig().getDouble("lava.x");
	            final double y = Main.instance.getConfig().getDouble("lava.y");
	            final double z = Main.instance.getConfig().getDouble("lava.z");
	            final Location lobby = new Location(w, x, y, z);
	            lobby.setPitch((float)Main.instance.getConfig().getDouble("lava.pitch"));
	            lobby.setYaw((float)Main.instance.getConfig().getDouble("lava.yaw"));
                p.teleport(lobby);
	            
                Habilidade.setAbility(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				
		        p.sendMessage(String.valueOf(Main.prefix) + " §7» Você ganhou §e§l1500 ZeyCoins§7.");
				
		}
			
			}

	    }
}
