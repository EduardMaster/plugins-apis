package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Phantom implements Listener, CommandExecutor
{
  public static HashMap<Player, ItemStack[]> playerArmor = new HashMap<Player, ItemStack[]>();

  private ArrayList<String> cooldownp = new ArrayList<String>();

  private ItemStack colorIn(Material mat)
  {
    ItemStack armor = new ItemStack(mat);
    LeatherArmorMeta metaa = (LeatherArmorMeta)armor.getItemMeta();
    metaa.setColor(Color.WHITE);
    armor.setItemMeta(metaa);
    return armor;
  }

  @EventHandler
  public void death2324(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (this.cooldownp.contains(p.getName()))
      this.cooldownp.remove(p.getName());
  }

  @EventHandler
  public void death232(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    if (this.cooldownp.contains(p.getName()))
      this.cooldownp.remove(p.getName());
  }

  @EventHandler
  public void PlayerArmor(InventoryClickEvent e)
  {
    if (e.getCurrentItem() != null) {
      ItemStack po = e.getCurrentItem();
      if ((po.equals(new ItemStack(colorIn(Material.LEATHER_BOOTS)))) || 
        (po.equals(new ItemStack(
        colorIn(Material.LEATHER_CHESTPLATE)))) || 
        (po.equals(new ItemStack(
        colorIn(Material.LEATHER_HELMET)))) || 
        (po.equals(new ItemStack(
        colorIn(Material.LEATHER_LEGGINGS)))))
        e.setCancelled(true);
    }
  }

  @EventHandler
  public void interact1231(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (Main.estados == Estado.ANDAMENTO)
    	if ((Habilidade.getAbility(p).equalsIgnoreCase("phantom")))
    		if (p.getItemInHand().getType() == Material.FEATHER)
				if ((e.getAction() == Action.RIGHT_CLICK_AIR)
						|| (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      if (this.cooldownp.contains(p.getName()))
        p.sendMessage("§8\u276e§4§l!§8\u276f §7Espere para usar novamente");
      else
        for (Entity en : p.getNearbyEntities(20.0D, 20.0D, 20.0D))
          if ((en instanceof Player)) {
            Player nearby = (Player)en;
            if (nearby != null) {
              p.setAllowFlight(true);
            }
            p.setFlying(true);
            nearby.sendMessage("§8\u276e§4§l!§8\u276f §7Um Phantom está voando\nEle Nao Esta Usando Hack, isso e apenas um kit");
            p.addPotionEffect(new PotionEffect(
              PotionEffectType.SPEED, 100, 2));
            p.addPotionEffect(new PotionEffect(
              PotionEffectType.DAMAGE_RESISTANCE, 150, 3));
            this.cooldownp.add(p.getName());
            PlayerInventory inv = p.getInventory();
            playerArmor.put(p, inv.getArmorContents());
            inv.setHelmet(colorIn(Material.LEATHER_HELMET));
            inv.setChestplate(colorIn(Material.LEATHER_CHESTPLATE));
            inv.setLeggings(colorIn(Material.LEATHER_LEGGINGS));
            inv.setBoots(colorIn(Material.LEATHER_BOOTS));
            p.updateInventory();
            Bukkit.getServer()
              .getScheduler()
              .scheduleSyncDelayedTask(Main.instance, 
              new Runnable()
            {
            	  public void run() {
                      p.setFallDistance(0.0F);
                      p.setFlying(false);
                      p.setAllowFlight(false);
                      p.getInventory()
                        .setArmorContents(
                        (ItemStack[])Phantom.playerArmor
                        .remove(p));
                      p.getWorld().playSound(
                        p.getLocation(), 
                        Sound.WITHER_SPAWN, 
                        2.0F, 1.0F);
                      p.sendMessage("Seu tempo de voo acabou!");
                    }
                  }
                  , 100L);
                  Bukkit.getServer()
                    .getScheduler()
                    .scheduleSyncDelayedTask(Main.instance, 
                    new Runnable()
                  {
                    public void run() {
                      Phantom.this.cooldownp.remove(p
                        .getName());
                      p.getWorld()
                        .playSound(
                        p.getLocation(), 
                        Sound.CLICK, 
                        1.0F, 1.0F);
                      p.sendMessage("§8\u276e§4§l!§8\u276f §7Você pode voar novamente");
                 	 p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
                      p.getWorld()
                        .playSound(
                        p.getLocation(), 
                        Sound.CLICK, 
                        1.0F, 1.0F);
                    }
                  }
                  , 375L);
                }

        }
  }

@Override
public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}

}