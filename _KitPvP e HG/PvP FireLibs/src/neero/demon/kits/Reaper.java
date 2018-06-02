/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;

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
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Reaper
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 25 */   public static ArrayList<Player> reaper = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 29 */     Player p = e.getEntity();
/*    */     
/* 31 */     reaper.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 36 */     Player jogador = (Player)sender;
/* 37 */     if (label.equalsIgnoreCase("reaper")) {
/* 38 */       if (jogador.hasPermission("kit.reaper"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 42 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 46 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 51 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 59 */     p.getInventory().clear();
/* 60 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 61 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 62 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_HOE) });
/* 63 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cReaper!");
KitAPI.setKit(p, "Reaper");
Scoreboard.iscoriboard(p);
KitAPI.darsopa(p);
/* 68 */     reaper.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onWither(EntityDamageByEntityEvent e)
/*    */   {
/* 74 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
/*    */     {
/* 76 */       Player p = (Player)e.getEntity();
/* 77 */       Player d = (Player)e.getDamager();
/* 78 */       if ((reaper.contains(d)) && (d.getItemInHand().getType() == Material.WOOD_HOE)) {
/* 79 */         p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 0));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Reaper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */