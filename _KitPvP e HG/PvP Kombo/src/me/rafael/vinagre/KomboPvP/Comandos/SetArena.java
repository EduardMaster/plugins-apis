package me.rafael.vinagre.KomboPvP.Comandos;



	import org.bukkit.command.*;
	import org.bukkit.entity.*;

import me.rafael.vinagre.KomboPvP.*;

import java.util.*;
	import org.bukkit.*;

	public class SetArena implements CommandExecutor
	{
	    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
	        if (!(sender instanceof Player)) {
	            sender.sendMessage("Sem console");
	            return true;
	        }
	        final Player p = (Player)sender;
	        if (label.equalsIgnoreCase("setarena")) {
	            if (p.hasPermission("kitpvp.staff")) {
	                if (args.length == 0) {
	                    p.sendMessage(String.valueOf( "Sintaxe correta: /setarena (1|7)"));
	                    return true;
	                }
	                if (args[0].equalsIgnoreCase("1")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 1"));
	                    Main.getInstance().arenas.set("arena1.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena1.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena1.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena1.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena1.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena1.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("2")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 2"));
	                    Main.getInstance().arenas.set("arena2.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena2.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena2.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena2.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena2.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena2.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("3")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 3"));
	                    Main.getInstance().arenas.set("arena3.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena3.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena3.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena3.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena3.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena3.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("4")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 4"));
	                    Main.getInstance().arenas.set("arena4.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena4.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena4.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena4.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena4.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena4.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("5")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 5"));
	                    Main.getInstance().arenas.set("arena5.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena5.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena5.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena5.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena5.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena5.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("6")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 6"));
	                    Main.getInstance().arenas.set("arena6.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena6.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena6.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena6.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena6.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena6.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	                if (args[0].equalsIgnoreCase("7")) {
	                    p.sendMessage(String.valueOf( "§aVoc\u00ea setou a ARENA 7"));
	                    Main.getInstance().arenas.set("arena7.x", (Object)p.getLocation().getX());
	                    Main.getInstance().arenas.set("arena7.y", (Object)p.getLocation().getY());
	                    Main.getInstance().arenas.set("arena7.z", (Object)p.getLocation().getZ());
	                    final World w = p.getWorld();
	                    Main.getInstance().arenas.set("arena7.pitch", (Object)p.getLocation().getPitch());
	                    Main.getInstance().arenas.set("arena7.yaw", (Object)p.getLocation().getYaw());
	                    Main.getInstance().arenas.set("arena7.world", (Object)p.getLocation().getWorld().getName());
	                    Main.getInstance().save();
	                }
	            }
	            else {
	                p.sendMessage("Sem permissao");
	            }
	        }
	        return false;
	    }
	    
	    public static void TeleportArenaRandom(final Player p) {
	        final Random dice = new Random();
	        final int number = dice.nextInt(6);
	        switch (number) {
	            case 0: {
	                final World w = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena1.world"));
	                final double x = Main.getInstance().arenas.getDouble("arena1.x");
	                final double y = Main.getInstance().arenas.getDouble("arena1.y");
	                final double z = Main.getInstance().arenas.getDouble("arena1.z");
	                final Location lobby = new Location(w, x, y, z);
	                lobby.setPitch((float)Main.getInstance().arenas.getDouble("arena1.pitch"));
	                lobby.setYaw((float)Main.getInstance().arenas.getDouble("arena1.yaw"));
	                p.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby);
	                break;
	            }
	            case 1: {
	                final World w2 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena2.world"));
	                final double x2 = Main.getInstance().arenas.getDouble("arena2.x");
	                final double y2 = Main.getInstance().arenas.getDouble("arena2.y");
	                final double z2 = Main.getInstance().arenas.getDouble("arena2.z");
	                final Location lobby2 = new Location(w2, x2, y2, z2);
	                lobby2.setPitch((float)Main.getInstance().arenas.getDouble("arena2.pitch"));
	                lobby2.setYaw((float)Main.getInstance().arenas.getDouble("arena2.yaw"));
	                p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby2);
	                break;
	            }
	            case 2: {
	                final World w3 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena3.world"));
	                final double x3 = Main.getInstance().arenas.getDouble("arena3.x");
	                final double y3 = Main.getInstance().arenas.getDouble("arena3.y");
	                final double z3 = Main.getInstance().arenas.getDouble("arena3.z");
	                final Location lobby3 = new Location(w3, x3, y3, z3);
	                lobby3.setPitch((float)Main.getInstance().arenas.getDouble("arena3.pitch"));
	                lobby3.setYaw((float)Main.getInstance().arenas.getDouble("arena3.yaw"));
	                p.getWorld().playEffect(lobby3, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby3);
	                break;
	            }
	            case 3: {
	                final World w4 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena4.world"));
	                final double x4 = Main.getInstance().arenas.getDouble("arena4.x");
	                final double y4 = Main.getInstance().arenas.getDouble("arena4.y");
	                final double z4 = Main.getInstance().arenas.getDouble("arena4.z");
	                final Location lobby4 = new Location(w4, x4, y4, z4);
	                lobby4.setPitch((float)Main.getInstance().arenas.getDouble("arena4.pitch"));
	                lobby4.setYaw((float)Main.getInstance().arenas.getDouble("arena4.yaw"));
	                p.getWorld().playEffect(lobby4, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby4);
	                break;
	            }
	            case 4: {
	                final World w5 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena5.world"));
	                final double x5 = Main.getInstance().arenas.getDouble("arena5.x");
	                final double y5 = Main.getInstance().arenas.getDouble("arena5.y");
	                final double z5 = Main.getInstance().arenas.getDouble("arena5.z");
	                final Location lobby5 = new Location(w5, x5, y5, z5);
	                lobby5.setPitch((float)Main.getInstance().arenas.getDouble("arena5.pitch"));
	                lobby5.setYaw((float)Main.getInstance().arenas.getDouble("arena5.yaw"));
	                p.getWorld().playEffect(lobby5, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby5);
	                break;
	            }
	            case 5: {
	                final World w6 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena6.world"));
	                final double x6 = Main.getInstance().arenas.getDouble("arena6.x");
	                final double y6 = Main.getInstance().arenas.getDouble("arena6.y");
	                final double z6 = Main.getInstance().arenas.getDouble("arena6.z");
	                final Location lobby6 = new Location(w6, x6, y6, z6);
	                lobby6.setPitch((float)Main.getInstance().arenas.getDouble("arena6.pitch"));
	                lobby6.setYaw((float)Main.getInstance().arenas.getDouble("arena6.yaw"));
	                p.getWorld().playEffect(lobby6, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby6);
	                break;
	            }
	            case 6: {
	                final World w7 = Bukkit.getServer().getWorld(Main.getInstance().arenas.getString("arena7.world"));
	                final double x7 = Main.getInstance().arenas.getDouble("arena7.x");
	                final double y7 = Main.getInstance().arenas.getDouble("arena7.y");
	                final double z7 = Main.getInstance().arenas.getDouble("arena7.z");
	                final Location lobby7 = new Location(w7, x7, y7, z7);
	                lobby7.setPitch((float)Main.getInstance().arenas.getDouble("arena7.pitch"));
	                lobby7.setYaw((float)Main.getInstance().arenas.getDouble("arena7.yaw"));
	                p.getWorld().playEffect(lobby7, Effect.ENDER_SIGNAL, 5);
	                p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
	                p.teleport(lobby7);
	                break;
	            }
	        }
	    }
	}

