package me.rafael.vinagre.KomboPvP.Listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.rafael.vinagre.KomboPvP.Main;

public class Feast implements Listener, CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn-feast")){
			if(!sender.hasPermission("kitpvp.feast")){
				return true;
			}
			RodarComando();
		}
		if (cmd.getName().equalsIgnoreCase("setfeast")){
			Player p = (Player)sender;
			Location pc = p.getLocation();
			if (!p.hasPermission("kitpvp.admin")){
				return true;
			}
			Main.plugin.getConfig().set("Feast.X", pc.getX());
			Main.plugin.getConfig().set("Feast.Y", pc.getY());
			Main.plugin.getConfig().set("Feast.Z", pc.getZ());
			Main.plugin.getConfig().set("Feast.Pitch", pc.getPitch());
			Main.plugin.getConfig().set("Feast.Yaw", pc.getYaw());
			Main.plugin.getConfig().set("Feast.Mundo", p.getWorld().getName());
			Main.plugin.saveConfig();
			p.sendMessage("§e§lDesert§f§lPvP §7» §aFeast setado.");
		}
		if (cmd.getName().equalsIgnoreCase("setfeast2")){
			Player p = (Player)sender;
			Location pc = p.getLocation();
			if (!p.hasPermission("kitpvp.admin")){
				return true;
			}
			Main.plugin.getConfig().set("Feast2.X", pc.getX());
			Main.plugin.getConfig().set("Feast2.Y", pc.getY());
			Main.plugin.getConfig().set("Feast2.Z", pc.getZ());
			Main.plugin.getConfig().set("Feast2.Pitch", pc.getPitch());
			Main.plugin.getConfig().set("Feast2.Yaw", pc.getYaw());
			Main.plugin.getConfig().set("Feast2.Mundo", p.getWorld().getName());
			Main.plugin.saveConfig();
			p.sendMessage("§e§lDesert§f§lPvP §7» §aFeast 2 setado.");
		}
		if (cmd.getName().equalsIgnoreCase("setfeast3")){
			Player p = (Player)sender;
			Location pc = p.getLocation();
			if (!p.hasPermission("kitpvp.admin")){
				return true;
			}
			Main.plugin.getConfig().set("Feast3.X", pc.getX());
			Main.plugin.getConfig().set("Feast3.Y", pc.getY());
			Main.plugin.getConfig().set("Feast3.Z", pc.getZ());
			Main.plugin.getConfig().set("Feast3.Pitch", pc.getPitch());
			Main.plugin.getConfig().set("Feast3.Yaw", pc.getYaw());
			Main.plugin.getConfig().set("Feast3.Mundo", p.getWorld().getName());
			Main.plugin.saveConfig();
			p.sendMessage("§e§lDesert§f§lPvP §7» §aFeast 3 setado.");
		}
		if (cmd.getName().equalsIgnoreCase("setfeast4")){
			Player p = (Player)sender;
			Location pc = p.getLocation();
			if (!p.hasPermission("kitpvp.admin")){
				return true;
			}
			Main.plugin.getConfig().set("Feast4.X", pc.getX());
			Main.plugin.getConfig().set("Feast4.Y", pc.getY());
			Main.plugin.getConfig().set("Feast4.Z", pc.getZ());
			Main.plugin.getConfig().set("Feast4.Pitch", pc.getPitch());
			Main.plugin.getConfig().set("Feast4.Yaw", pc.getYaw());
			Main.plugin.getConfig().set("Feast4.Mundo", p.getWorld().getName());
			Main.plugin.saveConfig();
			p.sendMessage("§e§lDesert§f§lPvP §7» §aFeast 4 setado.");
		}
		if (cmd.getName().equalsIgnoreCase("setfeast5")){
			Player p = (Player)sender;
			Location pc = p.getLocation();
			if (!p.hasPermission("kitpvp.admin")){
				return true;
			}
			Main.plugin.getConfig().set("Feast5.X", pc.getX());
			Main.plugin.getConfig().set("Feast5.Y", pc.getY());
			Main.plugin.getConfig().set("Feast5.Z", pc.getZ());
			Main.plugin.getConfig().set("Feast5.Pitch", pc.getPitch());
			Main.plugin.getConfig().set("Feast5.Yaw", pc.getYaw());
			Main.plugin.getConfig().set("Feast5.Mundo", p.getWorld().getName());
			Main.plugin.saveConfig();
			p.sendMessage("§e§lDesert§f§lPvP §7» §aFeast 5 setado.");
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void RodarComando(){
		if(!Main.plugin.getConfig().contains("Feast")){
			Bukkit.broadcastMessage("§e§lDesert§f§lPvP §7» §cNa tentativa de spawnar o feast, nao foi achado um lugar !");
			return;
		}
		double X = Main.plugin.getConfig().getDouble("Feast.X");
		double Y = Main.plugin.getConfig().getDouble("Feast.Y");
		double Z = Main.plugin.getConfig().getDouble("Feast.Z");
		float Pitch = (float)Main.plugin.getConfig().getDouble("Feast.Pitch");
		float Yaw = (float)Main.plugin.getConfig().getDouble("Feast.Yaw");
		World W = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Feast.Mundo"));
		Location bau = new Location(W, X, Y, Z);
		bau.setPitch(Pitch);
		bau.setYaw(Yaw);
		Block BauSpawn = bau.clone().getBlock();
		BauSpawn.setType(Material.CHEST);
		Chest AddBau = (Chest)BauSpawn.getState();
		
		double x = Main.plugin.getConfig().getDouble("Feast2.X");
		double y = Main.plugin.getConfig().getDouble("Feast2.Y");
		double z = Main.plugin.getConfig().getDouble("Feast2.Z");
		float pitch = (float)Main.plugin.getConfig().getDouble("Feast2.Pitch");
		float yaw = (float)Main.plugin.getConfig().getDouble("Feast2.Yaw");
		World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Feast2.Mundo"));
		Location bau2 = new Location(w, x, y, z);
		bau2.setPitch(pitch);
		bau2.setYaw(yaw);
		Block BauSpawn2 = bau2.clone().getBlock();
		BauSpawn2.setType(Material.CHEST);
		Chest AddBau2 = (Chest)BauSpawn2.getState();
		
		double X3 = Main.plugin.getConfig().getDouble("Feast3.X");
		double Y3 = Main.plugin.getConfig().getDouble("Feast3.Y");
		double Z3 = Main.plugin.getConfig().getDouble("Feast3.Z");
		float Pitch3 = (float)Main.plugin.getConfig().getDouble("Feast3.Pitch");
		float Yaw3 = (float)Main.plugin.getConfig().getDouble("Feast3.Yaw");
		World W3 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Feast3.Mundo"));
		Location bau3 = new Location(W3, X3, Y3, Z3);
		bau3.setPitch(Pitch3);
		bau3.setYaw(Yaw3);
		Block BauSpawn3 = bau3.clone().getBlock();
		BauSpawn3.setType(Material.CHEST);
		Chest AddBau3 = (Chest)BauSpawn3.getState();
		
		double X4 = Main.plugin.getConfig().getDouble("Feast4.X");
		double Y4 = Main.plugin.getConfig().getDouble("Feast4.Y");
		double Z4 = Main.plugin.getConfig().getDouble("Feast4.Z");
		float Pitch4 = (float)Main.plugin.getConfig().getDouble("Feast4.Pitch");
		float Yaw4 = (float)Main.plugin.getConfig().getDouble("Feast4.Yaw");
		World W4 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Feast4.Mundo"));
		Location bau4 = new Location(W4, X4, Y4, Z4);
		bau4.setPitch(Pitch4);
		bau4.setYaw(Yaw4);
		Block BauSpawn4 = bau4.clone().getBlock();
		BauSpawn4.setType(Material.CHEST);
		Chest AddBau4 = (Chest)BauSpawn4.getState();
		
		double X5 = Main.plugin.getConfig().getDouble("Feast5.X");
		double Y5 = Main.plugin.getConfig().getDouble("Feast5.Y");
		double Z5 = Main.plugin.getConfig().getDouble("Feast5.Z");
		float Pitch5 = (float)Main.plugin.getConfig().getDouble("Feast5.Pitch");
		float Yaw5 = (float)Main.plugin.getConfig().getDouble("Feast5.Yaw");
		World W5 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Feast5.Mundo"));
		Location bau5 = new Location(W5, X5, Y5, Z5);
		bau5.setPitch(Pitch5);
		bau5.setYaw(Yaw5);
		Block BauSpawn5 = bau5.clone().getBlock();
		BauSpawn5.setType(Material.CHEST);
		Chest AddBau5 = (Chest)BauSpawn5.getState();
		
		//Itens
		int lista[] = {384, 306, 313, 303, 315, 316, 282, 267, 283, 344, 261, 262, 322, 335, 368, 280, 281, 299, 301};
		int slot = new Random().nextInt(26);
		int slot2 = new Random().nextInt(26);
		int slot3 = new Random().nextInt(26);
		
		AddBau.getBlockInventory().clear();
		AddBau2.getBlockInventory().clear();
		AddBau3.getBlockInventory().clear();
		AddBau4.getBlockInventory().clear();
		AddBau5.getBlockInventory().clear();
		AddBau.getBlockInventory().setItem(slot, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau.getBlockInventory().setItem(slot2, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau.getBlockInventory().setItem(slot3, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau2.getBlockInventory().setItem(slot, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau2.getBlockInventory().setItem(slot2, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau2.getBlockInventory().setItem(slot3, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau3.getBlockInventory().setItem(slot, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau3.getBlockInventory().setItem(slot2, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau3.getBlockInventory().setItem(slot3, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau4.getBlockInventory().setItem(slot, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau4.getBlockInventory().setItem(slot2, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau4.getBlockInventory().setItem(slot3, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau5.getBlockInventory().setItem(slot, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau5.getBlockInventory().setItem(slot2, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau5.getBlockInventory().setItem(slot3, new ItemStack(Material.getMaterial(lista[new Random().nextInt(lista.length)])));
		AddBau.update();
		AddBau2.update();
		AddBau3.update();
		AddBau4.update();
		AddBau5.update();
		Bukkit.broadcastMessage("§7» §aO feast spawnou !");
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("§7» §cO feast ira spawnar daqui §71 §cminuto !");
			}
		}, 10800L);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
			public void run() {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn-feast");
			}
		}, 12000L);
	}
}