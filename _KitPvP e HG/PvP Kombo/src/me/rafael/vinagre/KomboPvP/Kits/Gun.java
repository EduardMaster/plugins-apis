package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
import Vinagre.Cooldown;
import Vinagre.Habilidade;

public class Gun implements Listener, CommandExecutor
{
    public static HashMap<Player, Integer> guntiros;
    
    static {
        Gun.guntiros = new HashMap<Player, Integer>();
    }
    
    @EventHandler
    public void ar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.WOOD_HOE && (p.getItemInHand().getType() == Material.WOOD_HOE) && (Habilidade.getAbility(p).equalsIgnoreCase("Gun"))) {
            e.setCancelled(true);
            if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 2) {
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Gun.guntiros.remove(p);
                        p.sendMessage("§cVoce ja pode atirar novamente");
                    }
                }, 400L);
            }
            if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 3) {
                if (Cooldown.add(p)) {
                	 p.sendMessage("§bVoc\u00ea est\u00e1 em cooldown de: §5" + Cooldown.cooldown(p) + "§bs");
                    return;
                }
                Cooldown.add(p, 15);
            }
            else if (!Gun.guntiros.containsKey(p)) {
                Gun.guntiros.put(p, 1);
            }
            else {
                Gun.guntiros.put(p, Gun.guntiros.get(p) + 1);
            }
            Location loc = p.getLocation().add(0.0, 1.5, 0.0);
            for (int i = 0; i <= 240; ++i) {
                loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY() - 0.05, loc.getDirection().getZ());
                p.getWorld().playEffect(loc, Effect.COLOURED_DUST, 15);
                for (final Entity ent : this.getEntitiesByLocation(loc, 1.0f)) {
                    if (ent instanceof LivingEntity && ent != p) {
                        ((LivingEntity)ent).damage(7.0);
                    }
                }
                if (loc.getBlock().getType().isSolid()) {
                    break;
                }
            }
            p.getLocation().getWorld().playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 2.0f, 2.0f);
        }
    }
    
    private List<Entity> getEntitiesByLocation(final Location loc, final float r) {
        final List<Entity> ent = new ArrayList<Entity>();
        for (final Entity e : loc.getWorld().getEntities()) {
            if (e.getLocation().distanceSquared(loc) <= r) {
                ent.add(e);
            }
        }
        return ent;
    }

public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
{
  Player p = (Player)sender;
  ItemStack dima = new ItemStack(Material.STONE_SWORD);
  ItemMeta souperaa = dima.getItemMeta();
  souperaa.setDisplayName("§cEspada");
  dima.setItemMeta(souperaa);
  ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta sopas = sopa.getItemMeta();
  sopas.setDisplayName("§6Sopa");
  sopa.setItemMeta(sopas);
  ItemStack especial = new ItemStack(Material.WOOD_HOE);
  ItemMeta especial1 = especial.getItemMeta();
  especial1.setDisplayName("§6Pistola!");
  especial.setItemMeta(especial1);
  
  ItemStack capacete0 = new ItemStack(Material.AIR);
  
  ItemStack peitoral0 = new ItemStack(Material.AIR);
  
  ItemStack calca0 = new ItemStack(Material.AIR);
  
  ItemStack Bota0 = new ItemStack(Material.AIR);
  
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);
  
  if (cmd.equalsIgnoreCase("gun")) {
    if (Array.used.contains(p.getName())) {
  	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
      return true;
    }
    if (!p.hasPermission("kitpvp.kit.gun")) {
	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
      return true;
    }
    Array.used.add(p.getName());
    p.sendMessage("§7» Voce escolheu o kit §cGun §7!");
    p.setGameMode(GameMode.ADVENTURE);
    p.getInventory().clear();
    Array.kit.put(p, "Gun");
    p.getInventory().addItem(new ItemStack[] { dima });
    p.getInventory().addItem(new ItemStack[] { especial });
    Main.give(p);
    Main.Dj.remove(p.getName());
    Main.stomper.remove(p.getName());
    Habilidade.setAbility(p, "Gun");
   
    
    for (int i = 0; i <= 34; i++) {
      p.getInventory().addItem(new ItemStack[] { sopa });
      
    }
  }
  me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
  return false;
}
}


