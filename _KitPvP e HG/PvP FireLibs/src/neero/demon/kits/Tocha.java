/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Tocha implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Tocha(Main plugin)
/*     */   {
/*  36 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  39 */   public static ArrayList<Player> torch = new ArrayList();
/*  40 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  44 */     Player p = e.getEntity();
/*     */     
/*  46 */     torch.remove(p);
/*  47 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  51 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  53 */     torch.remove(p);
/*  54 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  59 */     Player jogador = (Player)sender;
/*  60 */     if (label.equalsIgnoreCase("tocha")) {
/*  61 */       if (jogador.hasPermission("kit.tocha"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  65 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  69 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  74 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  82 */     p.getInventory().clear();
/*  83 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cTocha!");
KitAPI.setKit(p, "Tocha");Scoreboard.iscoriboard(p);
/*  84 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  85 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  86 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BLAZE_POWDER) });
KitAPI.darsopa(p);
/*  91 */     torch.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEntityDamage(EntityDamageEvent e)
/*     */   {
/*  97 */     if ((e.getEntity() instanceof Player))
/*     */     {
/*  99 */       Player p = (Player)e.getEntity();
/* 100 */       if (!torch.contains(p)) {
/* 101 */         return;
/*     */       }
/* 103 */       if (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
/*     */       {
/* 105 */         p.sendMessage(ChatColor.DARK_RED + "Me ajudem , estou pegando fogo!");
/* 106 */         p.removePotionEffect(PotionEffectType.SPEED);
/* 107 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
/* 108 */         p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 0));
/* 109 */         p.getActivePotionEffects().remove(Boolean.valueOf(true));
/* 110 */         e.setCancelled(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onFireUp(PlayerInteractEvent e)
/*     */   {
/* 118 */     final Player p = e.getPlayer();
/* 119 */     if (!torch.contains(p)) {
/* 120 */       return;
/*     */     }
/* 122 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 124 */       if (p.getItemInHand().getType() != Material.BLAZE_POWDER) {
/* 125 */         return;
/*     */       }
/* 127 */       if (cooldown.contains(p))
/*     */       {
/* 129 */         p.sendMessage(ChatColor.RED + "Nao pode usar a tocha ainda.");
/* 130 */         return;
/*     */       }
/* 132 */       p.setFireTicks(300);
/* 133 */       p.sendMessage(ChatColor.GRAY + "Obrigado , esta se apagando =)!");
/* 134 */       cooldown.add(p);
/* 135 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 139 */           p.sendMessage(ChatColor.GREEN + "Lance suas chamas novamente.");
/* 140 */           Tocha.cooldown.remove(p);
/*     */         }
/* 142 */       }, 600L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void ontorchDamage(EntityDamageByEntityEvent e)
/*     */   {
/* 149 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/* 151 */       Player p = (Player)e.getEntity();
/* 152 */       Player d = (Player)e.getDamager();
/* 153 */       if ((torch.contains(p)) && (p.getFireTicks() > 0))
/*     */       {
/* 155 */         d.setFireTicks(200);
/* 156 */         d.sendMessage(ChatColor.RED + "Eita , isso queima!");
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Tocha.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */