package me.recenthg.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.CMDS.Admin;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Endermage implements Listener {
	
  public ArrayList<String> inPvP = new ArrayList<String>();
  
  @SuppressWarnings("deprecation")
  @EventHandler
  public void onPlace(PlayerInteractEvent event) {
    ItemStack item = event.getItem();
    Player p2 = event.getPlayer();
    if (Main.estados == Estado.INVENCIBILIDADE ||Main.estados == Estado.ANDAMENTO)
    	
		if ((Habilidade.getAbility(p2).equalsIgnoreCase("endermage")))
			if (p2.getItemInHand().getType() == Material.ENDER_PORTAL_FRAME)
				if ((event.getAction() == Action.RIGHT_CLICK_AIR)
						|| (event.getAction() == Action.RIGHT_CLICK_BLOCK) && (!event.getClickedBlock().getType().equals(Material.BEDROCK))) {
      event.setCancelled(true);
      final Block b = event.getClickedBlock();
      if ((Habilidade.getAbility(p2).equalsIgnoreCase("endermage"))&& (b.getTypeId() == 120)) {
    	    
        return;
      }
      item.setAmount(0);
      if (item.getAmount() == 0) {
        event.getPlayer().setItemInHand(new ItemStack(0));
      }
      final Location portal = b.getLocation().clone().add(0.5D, 0.5D, 0.5D);
      b.getType();
      b.getData();
      portal.getBlock().setTypeId(120);
      final Player mager = event.getPlayer();
      for (int i = 0; i <= 5; i++) {
        final int no = i;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()  {
          public void run() {
            for (Player p1 : Bukkit.getOnlinePlayers()) {
              Player p = p1.getPlayer();
              if ((b.getTypeId() == 120) && (p != mager.getPlayer()) && (isEnderable(portal, p.getLocation()))) {
                Location teleport = portal.clone().add(0.0D, 0.5D, 0.0D);
                if (p.getLocation().distance(portal) > 4.0D) {
                  if ((!Habilidade.getAbility(p).equalsIgnoreCase("endermage")) || (!Admin.admin.contains(p)) || (!Admin.admin.contains(p)) || (!Admin.admin.contains(mager)) || (!Endermage.this.inPvP.contains(p)) || (!Endermage.this.inPvP.contains(mager)) || (!Main.Watch.contains(p.getName()) || (!Admin.admin.contains(mager)))) {
                    mager.getPlayer().sendMessage("§7Você puxou §4" + p.getName() + "\n§7Você esta invencivel por 5 segundos!");
                    p.sendMessage("§8\u276e§4§l!§8\u276f §7Você foi puxado por §4" + mager.getName() + "\n§7Você esta invencivel por 5 segundos!");
                    p.setNoDamageTicks(100);
                    mager.getPlayer().setNoDamageTicks(100);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
                    p.getPlayer().setNoDamageTicks(100);
                    mager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
                    mager.getPlayer().teleport(teleport);
                    p.teleport(teleport);
                    mager.getInventory().addItem(new ItemStack(Material.PORTAL));
                  } else {
                    return;
                  }
                  mager.getInventory().addItem(new ItemStack(Material.PORTAL));
                }
                if ((portal.getBlock().getType() != Material.RED_MUSHROOM) || (portal.getBlock().getType() != Material.BROWN_MUSHROOM) || (portal.getBlock().getType() != Material.CHEST)) {
                  portal.getBlock().setTypeId(121);
                }
              } if (no == 5) {
               if (b.getType() == Material.ENDER_PORTAL_FRAME) {
                  mager.getInventory().addItem(new ItemStack(Material.PORTAL));
                }
                if ((portal.getBlock().getType() != Material.RED_MUSHROOM) || (portal.getBlock().getType() != Material.BROWN_MUSHROOM) || (portal.getBlock().getType() != Material.CHEST)) {
                  portal.getBlock().setTypeId(121);
                }
              }
            }
          }
        }, i * 20);
      }
    }
    
  }
  private boolean isEnderable(Location portal, Location player) {
    return (Math.abs(portal.getX() - player.getX()) < 2.5D) && (Math.abs(portal.getZ() - player.getZ()) < 2.5D) && (
      Math.abs(portal.getY() - player.getY()) > 3.0D);
  }
}