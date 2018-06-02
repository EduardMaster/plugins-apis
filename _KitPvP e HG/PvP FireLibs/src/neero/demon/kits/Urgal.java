/*    */ package neero.demon.kits;
/*    */ 
/*    */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.Potion;
/*    */ import org.bukkit.potion.PotionType;
/*    */ 
/*    */ 
/*    */ public class Urgal
/*    */   implements CommandExecutor
/*    */ {
/* 23 */   public static ArrayList<Player> urgal = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void deathe(PlayerDeathEvent e) {
/* 27 */     Player p = e.getEntity();
/*    */     
/* 29 */     urgal.remove(p);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 33 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*    */     
/* 35 */     urgal.remove(p);
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 40 */     Player jogador = (Player)sender;
/* 41 */     if (label.equalsIgnoreCase("urgal")) {
/* 42 */       if (jogador.hasPermission("kit.urgal"))
/*    */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*    */         {
/* 46 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*    */         }
/*    */         else
/*    */         {
/* 50 */           giveKit(jogador);
/*    */         }
/*    */         
/*    */       }
/*    */       else {
/* 55 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*    */       }
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public void giveKit(Player p)
/*    */   {
/* 63 */     p.getInventory().clear();
/* 64 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cUrgal!");
KitAPI.setKit(p, "Urgal");
/* 65 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/* 66 */     p.getInventory().addItem(new ItemStack[] { sword });
/* 67 */     Potion potion = new Potion(PotionType.STRENGTH);
/* 68 */     ItemStack itemStack = new ItemStack(Material.POTION);
/* 69 */     potion.apply(itemStack);
/* 70 */     p.getInventory().addItem(new ItemStack[] { itemStack });
KitAPI.darsopa(p);
/* 75 */     urgal.add(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Urgal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */