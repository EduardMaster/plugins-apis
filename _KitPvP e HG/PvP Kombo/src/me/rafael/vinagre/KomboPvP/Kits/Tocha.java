package me.rafael.vinagre.KomboPvP.Kits;



import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;


public class Tocha
  implements Listener, CommandExecutor
{
  public Main plugin;
  
  public Tocha()
  {
    this.plugin = plugin;
  }
  
  public static ArrayList<Player> torch = new ArrayList();
  public static ArrayList<Player> cooldown = new ArrayList();
  
  @EventHandler
  public void deathe(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    
    torch.remove(p);
    cooldown.remove(p);
  }
  
  @EventHandler
  public void ent(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
    torch.remove(p);
    cooldown.remove(p);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player jogador = (Player)sender;
    if (label.equalsIgnoreCase("tocha")) {
      if (jogador.hasPermission("kitpvp.kit.tocha"))
      {
        if (Array.used.contains(jogador.getName())) {
          jogador.sendMessage("Voce ja selecionou um kit !");
        } else {
          giveKit(jogador);
        }
      }
      else {
        jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
      }
    }
    return false;
  }
  
  public static void giveKit(Player p)
  {
    p.getInventory().clear();
    p.sendMessage(ChatColor.GREEN + "Voce escolheu Torch!");
    ItemStack sword = new ItemStack(Material.STONE_SWORD);
    p.getInventory().addItem(new ItemStack[] { sword });
    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BLAZE_POWDER) });
    for (int i = 0; i < 37; i++) {
      p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
    }
    Array.used.add(p.getName());
    torch.add(p);
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (!torch.contains(p)) {
        return;
      }
      if (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
      {
        p.sendMessage(ChatColor.DARK_RED + "Me ajudem , estou pegando fogo!");
        p.removePotionEffect(PotionEffectType.SPEED);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 0));
        p.getActivePotionEffects().remove(Boolean.valueOf(true));
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onFireUp(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (!torch.contains(p)) {
      return;
    }
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      if (p.getItemInHand().getType() != Material.BLAZE_POWDER) {
        return;
      }
      if (cooldown.contains(p))
      {
        p.sendMessage(ChatColor.RED + "Nao pode usar a tocha ainda.");
        return;
      }
      p.setFireTicks(300);
      p.sendMessage(ChatColor.GRAY + "Obrigado , esta se apagando =)!");
      cooldown.add(p);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage(ChatColor.GREEN + "Lance suas chamas novamente.");
          Tocha.cooldown.remove(p);
        }
      }, 200L);
    }
  }
  
  @EventHandler
  public void ontorchDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if ((torch.contains(p)) && (p.getFireTicks() > 0))
      {
        d.setFireTicks(200);
        d.sendMessage(ChatColor.RED + "Eita , isso queima!");
      }
    }
  }
}

