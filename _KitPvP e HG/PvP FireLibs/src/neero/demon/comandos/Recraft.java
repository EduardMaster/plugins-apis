package neero.demon.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import neero.demon.Main;
import net.minecraft.server.v1_7_R4.Material;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Recraft implements CommandExecutor{
public static ArrayList<String> cooldown = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(label.equalsIgnoreCase("recraft")) {
			Player p = (Player) sender;
			if(!cooldown.contains(p.getName())) {
				darosbang(p);
		}else{
			p.sendMessage("§cEspere Voce Ja Recebeu Seu Recraft!");
		}
		}
				return false;
		}
		@SuppressWarnings("deprecation")
		public void darosbang(Player p ) {
	p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 3));
	p.sendMessage("§aRecraft Recebido");
	Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
		public void run() {
			cooldown.add(p.getName());				
			}
	},20L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
		public void run() {
		}
	},40L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
		public void run() {
			p.getInventory().setItem(13, new ItemStack(org.bukkit.Material.BOWL, 64));
			p.getInventory().setItem(14, new ItemStack(org.bukkit.Material.RED_MUSHROOM, 64));
			p.getInventory().setItem(15, new ItemStack(org.bukkit.Material.BROWN_MUSHROOM, 64));
		}
	},60L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
		public void run() {
			cooldown.remove(p.getName());
		}
		
	},1000L);
	

}

	}