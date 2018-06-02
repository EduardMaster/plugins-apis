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
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Berserker
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 24 */   public static ArrayList<Player> berserker = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 28 */     Player p = e.getEntity();
/*    */     
/* 30 */     berserker.remove(p);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 36 */     Player jogador = (Player)sender;
/* 37 */     if (label.equalsIgnoreCase("berserker")) {
/* 38 */       if (jogador.hasPermission("kit.berserker"))
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
/* 51 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*    */       }
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 59 */     p.getInventory().clear();
/* 60 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cBerserker!");
KitAPI.setKit(p, "Berserker");
Scoreboard.iscoriboard(p);
/* 61 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 62 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/* 67 */     berserker.add(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerDeath(PlayerDeathEvent e)
/*    */   {
/* 73 */     Player p = e.getEntity();
/* 74 */     if ((p.getKiller() instanceof Player))
/*    */     {
/* 76 */       Player k = p.getKiller();
/* 77 */       if (!berserker.contains(k)) {
/* 78 */         return;
/*    */       }
/* 80 */       k.sendMessage(ChatColor.DARK_RED + "§4§lKIT §7VOCE PEGOU RAIVA!");
/* 81 */       k.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 82 */       k.removePotionEffect(PotionEffectType.CONFUSION);
/* 83 */       k.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 240, 0));
/* 84 */       k.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 240, 3));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Berserker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */