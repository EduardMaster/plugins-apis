/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;
import neero.demon.utils.Uteis;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Challenger implements Listener, CommandExecutor
/*     */ {
/*  30 */   public static ArrayList<Player> challenger = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void entr(PlayerJoinEvent e) {
/*  34 */     Player p = e.getPlayer();
/*     */     
/*  36 */     challenger.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void sair(PlayerQuitEvent e) {
/*  41 */     Player p = e.getPlayer();
/*     */     
/*  43 */     challenger.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void click(PlayerInteractEntityEvent event)
/*     */   {
/*  49 */     final Player p = event.getPlayer();
/*  50 */     if ((event.getRightClicked() instanceof Player)) {
/*  51 */       Player p2 = (Player)event.getRightClicked();
/*  52 */       if ((p.getItemInHand().getType() == Material.getMaterial(20)) && 
/*  53 */         (challenger.contains(p))) {
/*  54 */         if (Uteis.hasCooldown(p)) {
/*  55 */           p.sendMessage("§4§lKIT §cAguarde " + Uteis.getCooldown(p) + " segundos!");
/*  56 */           return;
/*     */         }
/*  58 */         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*     */           public void run() {
/*  60 */             p.sendMessage("§4§lKIT §7§aVoce não esta mais em cooldown!");
/*     */           }
/*  62 */         }, 400L);
/*  63 */         Location loc3 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 20.0D, p.getLocation().getZ());
/*  64 */         List<Location> cuboid = new ArrayList();
/*  65 */         cuboid.clear();
/*     */         
/*  67 */         for (int bX = -2; bX <= 2; bX++) {
/*  68 */           for (int bZ = -2; bZ <= 2; bZ++) {
/*  69 */             for (int bY = -1; bY <= 2; bY++) {
/*  70 */               Block b = loc3.clone().add(bX, bY, bZ).getBlock();
/*  71 */               if ((!b.isEmpty()) || (b.getLocation().getBlock().getType() != Material.AIR)) {
/*  72 */                 p.sendMessage(ChatColor.RED + "§4§lKIT §7A blocos encima de você");
/*  73 */                 return;
/*     */               }
/*  75 */               Uteis.addCooldown(p, 20);
/*  76 */               if (bY == 2) {
/*  77 */                 cuboid.add(loc3.clone().add(bX, bY, bZ));
/*  78 */               } else if (bY == -1) {
/*  79 */                 cuboid.add(loc3.clone().add(bX, bY, bZ));
/*  80 */               } else if ((bX == -2) || (bZ == -2) || (bX == 2) || (bZ == 2)) {
/*  81 */                 cuboid.add(loc3.clone().add(bX, bY, bZ));
/*     */               }
/*  83 */               for (final Location loc11 : cuboid) {
/*  84 */                 loc11.getBlock().setType(Material.GLASS);
/*  85 */                 p2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 5));
/*  86 */                 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
/*     */                   public void run() {
/*  88 */                     loc11.getBlock().setType(Material.AIR);
/*     */                   }
/*  90 */                 }, 200L);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*  95 */         p2.teleport(loc3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/* 103 */     Player jogador = (Player)sender;
/* 104 */     if (label.equalsIgnoreCase("challenger")) {
/* 105 */       if (jogador.hasPermission("kit.challenger"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/* 109 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/* 113 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/* 118 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possui este kit !");
/*     */       }
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/* 126 */     p.getInventory().clear();
/* 127 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cChallenger!");
KitAPI.setKit(p, "Challenger");
Scoreboard.iscoriboard(p);
/* 128 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 129 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 130 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GLASS, 1) });
KitAPI.darsopa(p);
/* 135 */     challenger.add(p);
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Challenger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */