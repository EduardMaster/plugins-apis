package Utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import Main.Main;
import me.confuser.barapi.BarAPI;

public class WarpsAPI implements Listener {

	public static ArrayList<String> segundos = new ArrayList<>();
	
	
	@EventHandler
	public void Andou(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (segundos.contains(p.getDisplayName())) {
		segundos.remove(p.getDisplayName());
		p.sendMessage("§c§lVoce se moveu seu teleport foi cancelado!");
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		BarAPI.removeBar(p);
	}
  }
	
   public static void Set(Player p, String w) {
	   Main.getInstace().warps.set("warps." + w + ".X", p.getLocation().getX());
	   Main.getInstace().warps.set("warps." + w + ".Y", p.getLocation().getY());
	   Main.getInstace().warps.set("warps." + w + ".Z", p.getLocation().getZ());
	   Main.getInstace().warps.set("warps." + w + ".Pitch", p.getLocation().getPitch());
	   Main.getInstace().warps.set("warps." + w + ".Yam", p.getLocation().getYaw());
	   Main.getInstace().warps.set("warps." + w + ".World", p.getLocation().getWorld().getName());
	   Main.getInstace().save();
	   
   }
   
   public static void ir(Player p, String w) {
	   if (Main.getInstace().warps.contains("warps." + w )) {
		   Double X = Main.getInstace().warps.getDouble("warps." + w + ".X");
		   Double Y = Main.getInstace().warps.getDouble("warps." + w + ".Y");
		   Double Z = Main.getInstace().warps.getDouble("warps." + w + ".Z");
		   float Pitch = (float)Main.getInstace().warps.getDouble("warps." + w + ".Pitch");
		   float Yam = (float)Main.getInstace().warps.getDouble("warps." + w + ".Yam");
		   World world = Bukkit.getWorld(Main.getInstace().warps.getString("warps." + w + ".World"));
		   Location loc = new Location(world, X, Y, Z, Yam, Pitch);
		   p.teleport(loc);
	   } else {
		   p.sendMessage("§c§lAinda nao foi setada!");
	   }
   }
}