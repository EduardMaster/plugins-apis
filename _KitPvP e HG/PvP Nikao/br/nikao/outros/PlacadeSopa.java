/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.SignChangeEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class PlacadeSopa implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Escrever(SignChangeEvent e)
/*    */   {
/* 22 */     Player p = e.getPlayer();
/* 23 */     if ((p.hasPermission("ng.placadesopa")) && (e.getLine(0).equalsIgnoreCase("sopa"))) {
/* 24 */       e.setLine(0, "==§f[§b!§f]§0==");
/* 25 */       e.setLine(1, Main.getInstance().getConfig().getString("PlacaDeSopa").replace("&", "§"));
/* 26 */       e.setLine(2, "§5§lSopas");
/* 27 */       e.setLine(3, " ");
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void inv(PlayerInteractEvent e)
/*    */   {
/* 34 */     Player p = e.getPlayer();
/* 35 */     if ((e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && 
/* 36 */       (e.getClickedBlock() != null) && (
/* 37 */       (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST))) {
/* 38 */       Sign s = (Sign)e.getClickedBlock().getState();
/* 39 */       String[] lines = s.getLines();
/* 40 */       if ((lines.length > 0) && (lines[0].equals("==§f[§b!§f]§0==")) && 
/* 41 */         (lines.length > 1) && (lines[1].equals(Main.getInstance().getConfig().getString("PlacaDeSopa").replace("&", "§"))) && 
/* 42 */         (lines.length > 2) && (lines[2].equals("§5§lSopas")) && 
/* 43 */         (lines.length > 3) && (lines[3].equals(" "))) {
/* 44 */         Inventory inv = org.bukkit.Bukkit.createInventory(p, 54, "§5§l§nSopas");
/*    */         
/* 46 */         ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 47 */         ItemMeta sopameta = sopa.getItemMeta();
/* 48 */         sopa.setItemMeta(sopameta);
/*    */         
/* 50 */         for (int i = 0; i != 54; i++) {
/* 51 */           inv.setItem(i, sopa);
/*    */         }
/* 53 */         p.openInventory(inv);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\PlacadeSopa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */