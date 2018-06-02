/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityExplodeEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Demoman implements Listener, CommandExecutor
/*     */ {
/*  30 */   public static ArrayList<Player> demoman = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  34 */     Player p = e.getEntity();
/*     */     
/*  36 */     demoman.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  40 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  42 */     demoman.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  47 */     Player jogador = (Player)sender;
/*  48 */     if (label.equalsIgnoreCase("demoman")) {
/*  49 */       if (jogador.hasPermission("kit.demoman"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  53 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  57 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  62 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  70 */     p.getInventory().clear();
/*  71 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cDemoman!");
KitAPI.setKit(p, "Demoman");
Scoreboard.iscoriboard(p);
/*  72 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  73 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  74 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.TNT, 10) });
KitAPI.darsopa(p);
/*  79 */     demoman.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTntLaunch(PlayerInteractEvent e)
/*     */   {
/*  85 */     Player p = e.getPlayer();
/*  86 */     if (!demoman.contains(p)) {
/*  87 */       return;
/*     */     }
/*  89 */     if (p.getItemInHand().getType() != Material.TNT) {
/*  90 */       return;
/*     */     }
/*  92 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/*  94 */       e.setCancelled(true);
/*  95 */       int tntleft = p.getItemInHand().getAmount();
/*  96 */       if (tntleft == 1) {
/*  97 */         p.setItemInHand(new ItemStack(Material.AIR));
/*     */       } else {
/*  99 */         p.getItemInHand().setAmount(tntleft - 1);
/*     */       }
/* 101 */       Location loc = p.getLocation();
/* 102 */       loc.setY(loc.getY() + 1.0D);
/* 103 */       Entity tnt = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.PRIMED_TNT);
/* 104 */       tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void boomboom(EntityExplodeEvent e)
/*     */   {
/* 111 */     if (e.getEntityType() == EntityType.PRIMED_TNT) {
/* 112 */       e.blockList().clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Demoman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */