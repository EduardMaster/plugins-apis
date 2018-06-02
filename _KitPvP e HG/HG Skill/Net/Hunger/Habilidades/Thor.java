package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Thor implements Listener{
	
public static List<Location> explodir = new ArrayList();

public static HashMap<Player, Long> cooldown = new HashMap<Player, Long>();

public static boolean hasCooldown(Player p) {
return cooldown.containsKey(p);
}

public static String getTempo(Player p) {
long tempo1= ((Long)cooldown.get(p)).longValue();
long left = (tempo1 - System.currentTimeMillis()) / 1000L;
return 
left+"";
}

public static void addColdown(final Player p, Integer tempo) {
long tempo1 = System.currentTimeMillis() + tempo * 1000;
cooldown.put(p, tempo1);
Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
public void run() {
cooldown.remove(p);
}
}, 20*tempo);
}

@EventHandler
public void Thorzao(PlayerInteractEvent e)
{
Player p = e.getPlayer();
if((Habilidade.getAbility(p).equalsIgnoreCase("thor") && (!Main.PreGame)) && 
((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
(p.getItemInHand().getType().equals(Material.WOOD_AXE))){
if (Net.Hunger.Main.PreInvencibilidade)
{
p.sendMessage("§cVocê não pode usar seu kit na invencibilidade!");
return;
}
if (hasCooldown(p))
{
p.sendMessage("§cVocê esta no cooldown");
return;
}
Location loc = p.getTargetBlock(null, 40).getLocation();
loc = loc.getWorld().getHighestBlockAt(loc).getLocation();
      
Location down = loc.getBlock().getRelative(BlockFace.DOWN).getLocation();
if (down.getBlock().getType() == Material.NETHERRACK){
if (explodir.contains(down)){
down.getBlock().setType(Material.AIR);
explodir.remove(down);
p.getWorld().strikeLightning(loc);
p.getWorld().createExplosion(loc, 4.0F, false);
}
} else {
p.getWorld().strikeLightning(loc);
if (loc.getBlock().getY() >= 80){
loc.getBlock().setType(Material.NETHERRACK);
explodir.add(loc);
}
addColdown(p, 15);
}
}
}
}
