/*    */ package br.nikao.eventos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import br.nikao.outros.Scoreboards;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Respawn implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Eventos(PlayerRespawnEvent e)
/*    */   {
/* 23 */     final Player p = e.getPlayer();
/* 24 */     p.teleport(p.getWorld().getSpawnLocation());
/* 25 */     p.getInventory().clear();
/* 26 */     p.setHealth(20.0D);
/* 27 */     p.setFoodLevel(20);
/* 28 */     KitAPI.RemoveKit(p);
/* 29 */     p.getInventory().setArmorContents(null);
/* 30 */     p.setGameMode(GameMode.ADVENTURE);
/* 31 */     br.nikao.outros.KillStreaks.setKillStreak(p);
/* 32 */     org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/* 36 */         if (br.nikao.comandos.Score.score.contains(p.getName())) {
/* 37 */           return;
/*    */         }
/* 39 */         Scoreboards.Scores(p);
/*    */       }
/*    */       
/*    */ 
/* 43 */     }, 20L);
/*    */     
/* 45 */     ItemStack kit = new ItemStack(Material.CHEST);
/* 46 */     ItemMeta kitmeta = kit.getItemMeta();
/* 47 */     kitmeta.setDisplayName("§7» §f§lSeus Kits §8§l(§7§n" + p.getName() + "§8§l)");
/* 48 */     kit.setItemMeta(kitmeta);
/*    */     
/* 50 */     ItemStack warps = new ItemStack(Material.PAPER);
/* 51 */     ItemMeta warpsmeta = warps.getItemMeta();
/* 52 */     warpsmeta.setDisplayName("§7» §f§lWarps");
/* 53 */     warps.setItemMeta(warpsmeta);
/*    */     
/* 55 */     ItemStack loja = new ItemStack(Material.EXP_BOTTLE);
/* 56 */     ItemMeta lojameta = loja.getItemMeta();
/* 57 */     lojameta.setDisplayName("§7» §f§lLoja §8§l(§6§nXP§8§l)");
/* 58 */     loja.setItemMeta(lojameta);
/*    */     
/* 60 */     ItemStack status = new ItemStack(Material.ENCHANTED_BOOK);
/* 61 */     ItemMeta statusmeta = status.getItemMeta();
/* 62 */     statusmeta.setDisplayName("§7» §f§lRegras");
/* 63 */     status.setItemMeta(statusmeta);
/*    */     
/* 65 */     ItemStack caixa = new ItemStack(Material.ENCHANTMENT_TABLE);
/* 66 */     ItemMeta caixameta = caixa.getItemMeta();
/* 67 */     caixameta.setDisplayName("§7» §f§l§nCaixas");
/* 68 */     caixa.setItemMeta(caixameta);
/*    */     
/* 70 */     ItemStack vidro = new ItemStack(Material.IRON_FENCE, 1, (short)15);
/* 71 */     ItemMeta vidrometa = vidro.getItemMeta();
/* 72 */     vidrometa.setDisplayName("§c§lSTOMPA§8§l-§e§lKITS");
/* 73 */     vidro.setItemMeta(vidrometa);
/*    */     
/* 75 */     p.getInventory().setItem(0, status);
/* 76 */     p.getInventory().setItem(2, vidro);
/* 77 */     p.getInventory().setItem(3, warps);
/* 78 */     p.getInventory().setItem(4, kit);
/* 79 */     p.getInventory().setItem(5, loja);
/* 80 */     p.getInventory().setItem(6, vidro);
/* 81 */     p.getInventory().setItem(8, caixa);
/* 82 */     p.updateInventory();
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\eventos\Respawn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */