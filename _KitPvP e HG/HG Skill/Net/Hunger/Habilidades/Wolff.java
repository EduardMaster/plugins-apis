package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Wolff implements Listener {

	private ArrayList<String> WolffCooldown = new ArrayList<String>();
	private ArrayList<String> addCooldown = new ArrayList<String>();
	
	@EventHandler
	public void onWolff(PlayerInteractEvent e) {
	if(Main.Partida) {
	Player p = e.getPlayer();
	if((WolffCooldown.contains(p.getName()) && (p.getItemInHand().getType() == Material.FLINT))) {
	p.sendMessage("§7[§a?§7] Você esta no cooldown!");
	e.setCancelled(true);
	return;
	} else {
	if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	(p.getItemInHand().getType() == Material.FLINT) && ((Habilidade.getAbility(p).equalsIgnoreCase("wolff")))) {
	final Wolf wolf = (Wolf) p.getLocation().getWorld().spawn(p.getLocation(), Wolf.class);
    wolf.setCustomName("§cCachorro de §a§l" + p.getName());
    wolf.setAdult();
    wolf.setOwner(p);
    wolf.setHealth(5.0D);
    wolf.setTamed(true);
    wolf.setCollarColor(DyeColor.BLUE);
    wolf.setCustomNameVisible(true);
    WolffCooldown.add(p.getName());
    addCooldown.add(p.getName());
    }
	if(addCooldown.contains(p.getName())) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
    WolffCooldown.remove(p.getName());
    addCooldown.remove(p.getName());
    return;
    }
    },1500L);
    }
   }
  }
 }
}
