/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Viper
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 27 */   public static ArrayList<Player> viper = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 31 */     Player p = e.getEntity();
/*    */     
/* 33 */     viper.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 37 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 39 */     viper.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 44 */     Player jogador = (Player)sender;
/* 45 */     if (label.equalsIgnoreCase("viper")) {
/* 46 */       if (jogador.hasPermission("kit.viper"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 50 */           jogador.sendMessage("§4§lKIT §coVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 54 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 59 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 67 */     p.getInventory().clear();
/* 68 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 69 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 70 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cViper!");
KitAPI.setKit(p, "Viper");
Scoreboard.iscoriboard(p);
KitAPI.darsopa(p);
/* 75 */     viper.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPosion(EntityDamageByEntityEvent e)
/*    */   {
/* 81 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
/*    */     {
/* 83 */       Player p = (Player)e.getEntity();
/* 84 */       Player d = (Player)e.getDamager();
/* 85 */       if (viper.contains(d))
/*    */       {
/* 87 */         Random r = new Random();
/* 88 */         int rand = r.nextInt(100);
/* 89 */         if (rand >= 67) {
/* 90 */           p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Viper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */