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
/*    */ public class PlacadeRecraft implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Escrever(SignChangeEvent e)
/*    */   {
/* 22 */     Player p = e.getPlayer();
/* 23 */     if ((p.hasPermission("ng.placadesopa")) && (e.getLine(0).equalsIgnoreCase("recraft"))) {
/* 24 */       e.setLine(0, "==§f[§b!§f]§0==");
/* 25 */       e.setLine(1, Main.getInstance().getConfig().getString("PlacaDeRecraft").replace("&", "§"));
/* 26 */       e.setLine(2, "§5§lRecraft");
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
/* 41 */         (lines.length > 1) && (lines[1].equals(Main.getInstance().getConfig().getString("PlacaDeRecraft").replace("&", "§"))) && 
/* 42 */         (lines.length > 2) && (lines[2].equals("§5§lRecraft")) && 
/* 43 */         (lines.length > 3) && (lines[3].equals(" "))) {
/* 44 */         Inventory inv = org.bukkit.Bukkit.createInventory(p, 27, "§5§l§nRecraft");
/*    */         
/* 46 */         ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 47 */         ItemMeta cogu1meta = cogu1.getItemMeta();
/* 48 */         cogu1.setItemMeta(cogu1meta);
/*    */         
/* 50 */         ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 51 */         ItemMeta cogu2meta = cogu2.getItemMeta();
/* 52 */         cogu2.setItemMeta(cogu2meta);
/*    */         
/* 54 */         ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 55 */         ItemMeta potemeta = pote.getItemMeta();
/* 56 */         pote.setItemMeta(potemeta);
/*    */         
/* 58 */         for (int i = 0; i != 9; i++) {
/* 59 */           inv.setItem(i, cogu1);
/*    */         }
/* 61 */         for (int i = 9; i != 18; i++) {
/* 62 */           inv.setItem(i, cogu2);
/*    */         }
/* 64 */         for (int i = 18; i != 27; i++) {
/* 65 */           inv.setItem(i, pote);
/*    */         }
/* 67 */         p.openInventory(inv);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\PlacadeRecraft.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */