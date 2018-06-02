/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Arrow;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ 
/*     */ public class Archer
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  26 */   public static ArrayList<Player> archer = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  30 */     Player p = e.getEntity();
/*     */     
/*  32 */     archer.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  36 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  38 */     archer.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  43 */     Player jogador = (Player)sender;
/*  44 */     if (label.equalsIgnoreCase("archer")) {
/*  45 */       if (jogador.hasPermission("kit.archer"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  49 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  53 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  58 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  66 */     p.getInventory().clear();
/*  67 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cArcher!");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Archer");
/*  68 */     archer.add(p);
/*  69 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  70 */     ItemStack bow = new ItemStack(Material.BOW);
/*  71 */     bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
/*  73 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  74 */     p.getInventory().addItem(new ItemStack[] { bow });
/*  75 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 10) });
KitAPI.darsopa(p);
/*     */     }
/*     */ 
/*     */   @EventHandler
/*     */   public void onArrowHit(EntityDamageByEntityEvent e)
/*     */   {
/*  85 */     if ((e.getEntity() instanceof Player))
/*     */     {
/*  87 */       Player p = (Player)e.getEntity();
/*  88 */       if ((e.getDamager() instanceof Arrow))
/*     */       {
/*  90 */         Arrow a = (Arrow)e.getDamager();
/*  91 */         if ((a.getShooter() instanceof Player))
/*     */         {
/*  93 */           Player s = (Player)a.getShooter();
/*  94 */           if (!archer.contains(s)) {
/*  95 */             return;
/*     */           }
/*  97 */           s.sendMessage(ChatColor.GREEN + "§4§lKIT §a + 1 Flecha.");
/*  98 */           s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
/*  99 */           double y = a.getLocation().getY();
/* 100 */           double shotY = p.getLocation().getY();
/* 101 */           if (y - shotY > 1.35D)
/*     */           {
/* 103 */             s.sendMessage(ChatColor.GREEN + "§4§lKIT §7Headshot!");
/* 104 */             p.sendMessage(ChatColor.RED + "§4§lKIT §7 Merda , te acertaram com uma flecha bem na cabeça.");
/* 105 */             e.setDamage(e.getDamage() * 1.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Archer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */