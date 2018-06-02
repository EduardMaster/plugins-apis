package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import me.Pedro.Main;
import me.Pedro.Eventos.API;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.Eventos.Protecao;
import me.Pedro.Score.Habilidade;

public class Cwarps implements CommandExecutor, Listener {

	public Cwarps(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("kreload")) && 
	      (p.hasPermission("admin.reload")))
	    {
	      p.sendMessage(API.sev + "§aConfiguracoes recarregadas!");
	      Main.plugin.reloadConfig();
	    }
	    if (cmd.getName().equalsIgnoreCase("setfps")) {
	      if (p.hasPermission("admin.setar"))
	      {
	    	Main.plugin.getConfig().set("fps.world", p.getLocation().getWorld().getName());
	    	Main.plugin.getConfig().set("fps.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("fps.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("fps.z", Double.valueOf(p.getLocation().getZ()));
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setdragon")) {
	      if (p.hasPermission("admin.setar"))
	      {
	        Main.plugin.getConfig().set("dragon.world", p.getLocation().getWorld().getName());
	        Main.plugin.getConfig().set("dragon.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("dragon.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("dragon.z", Double.valueOf(p.getLocation().getZ()));
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("sethard")) {
	      if (p.hasPermission("admin.setar"))
	      {
	        Main.plugin.getConfig().set("hard.world", p.getLocation().getWorld().getName());
	        Main.plugin.getConfig().set("hard.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("hard.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("hard.z", Double.valueOf(p.getLocation().getZ()));
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setlava")) {
	      if (p.hasPermission("admin.setar"))
	      {
	        Main.plugin.getConfig().set("lava.world", p.getLocation().getWorld().getName());
	        Main.plugin.getConfig().set("lava.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("lava.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("lava.z", Double.valueOf(p.getLocation().getZ()));
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setRDM")) {
	      if (p.hasPermission("admin.setar"))
	      {
	        Main.plugin.getConfig().set("rdm.world", p.getLocation().getWorld().getName());
	        Main.plugin.getConfig().set("rdm.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("rdm.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("rdm.z", Double.valueOf(p.getLocation().getZ()));
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("setSpawn")) {
	      if (p.hasPermission("admin.setar"))
	      {
	        Main.plugin.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
	        Main.plugin.getConfig().set("spawn.x", Double.valueOf(p.getLocation().getX()));
	        Main.plugin.getConfig().set("spawn.y", Double.valueOf(p.getLocation().getY()));
	        Main.plugin.getConfig().set("spawn.z", Double.valueOf(p.getLocation().getZ()));
	        p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
	        Main.plugin.saveConfig();
	        p.sendMessage(API.sev + "Warp Setada com Sucesso");
	        return true;
	      }
	    }
	    if (cmd.getName().equalsIgnoreCase("fps"))
	    {
	      if (Main.plugin.getConfig().getConfigurationSection("fps") == null)
	      {
	        p.sendMessage("§cFps Nao Setado!");
	        return true;
	      }
	      
	      World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("fps.world"));
	      double x = Main.plugin.getConfig().getDouble("fps.x");
	      double y = Main.plugin.getConfig().getDouble("fps.y");
	      double z = Main.plugin.getConfig().getDouble("fps.z");
	      p.teleport(new Location(w, x, y, z));
	      p.getInventory().clear();
	      KitAPI.GiveKit(p); 
	      KitAPI.remove(p);
	      p.setAllowFlight(false);
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	    }
	    if (cmd.getName().equalsIgnoreCase("spawn"))
	    {
	      if (Main.plugin.getConfig().getConfigurationSection("spawn") == null)
	      {
	        p.sendMessage("§cSPAWN Nao Setado!");
	        return true;
	      }
	      World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("spawn.world"));
	      double x = Main.plugin.getConfig().getDouble("spawn.x");
	      double y = Main.plugin.getConfig().getDouble("spawn.y");
	      double z = Main.plugin.getConfig().getDouble("spawn.z");
	      p.teleport(new Location(w, x, y, z));
	      p.getInventory().clear();
          API.GiveSpawn(p);
          KitAPI.remove(p);
  		p.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
  		if(Protecao.protecao.contains(p.getPlayer())) {
  			Protecao.protecao.remove(p.getPlayer());
  			p.getPlayer().sendMessage(API.sev + "Voce recebeu a protecao do Spawn!");
	      p.setAllowFlight(false);
	      p.getInventory().setArmorContents(null);
	      
	      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	      p.removePotionEffect(PotionEffectType.SPEED);
	    }
	    if (cmd.getName().equalsIgnoreCase("lava"))
	      {
	        if (Main.plugin.getConfig().getConfigurationSection("lava") == null)
	        {
	          p.sendMessage("§cLava Nao Setado!");
	          return true;
	        }
	        World w1 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("lava.world"));
	        double x1 = Main.plugin.getConfig().getDouble("lava.x");
	        double y1 = Main.plugin.getConfig().getDouble("lava.y");
	        double z1 = Main.plugin.getConfig().getDouble("lava.z");
	        p.teleport(new Location(w1, x1, y1, z1));
	        KitAPI.remove(p);
	        p.getInventory().clear();
	        KitAPI.GiveKit(p);
	        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	        p.removePotionEffect(PotionEffectType.SPEED);
	        p.setAllowFlight(false);
	        p.getInventory().setArmorContents(null);
	      }
	      if (cmd.getName().equalsIgnoreCase("rdm"))
	      {
	        if (p.hasPermission("kitpvp.rdmabrir"))
	        {
	          if (Main.plugin.getConfig().getConfigurationSection("rdm") == null)
	          {
	            p.sendMessage("§cRDM Nao Setado!");
	            return true;
	          }
	          World w1 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("rdm.world"));
	          double x1 = Main.plugin.getConfig().getDouble("rdm.x");
	          double y1 = Main.plugin.getConfig().getDouble("rdm.y");
	          double z1 = Main.plugin.getConfig().getDouble("rdm.z");
	          p.teleport(new Location(w1, x1, y1, z1));
	          KitAPI.GiveKit(p);
	          KitAPI.remove(p);
	          p.setAllowFlight(false);
	          p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	          p.removePotionEffect(PotionEffectType.SPEED);
	        }
	        if (cmd.getName().equalsIgnoreCase("feast"))
	        {
	          if (Main.plugin.getConfig().getConfigurationSection("feast") == null)
	          {
	            p.sendMessage("§cFeast Nao Setado!");
	            return true;
	          }
	          World w1 = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("feast.world"));
	          double x1 = Main.plugin.getConfig().getDouble("feast.x");
	          double y1 = Main.plugin.getConfig().getDouble("faest.y");
	          double z1 = Main.plugin.getConfig().getDouble("feast.z");
	          p.teleport(new Location(w1, x1, y1, z1));
	          ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
	          espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	          p.getInventory().clear();
	          p.getInventory().setItem(0, espada);
	          p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	          p.removePotionEffect(PotionEffectType.SPEED);
	        }
	        return false;
	      }
	    return false;
	  }
		return false;
	}
}
