/*    */ package neero.demon.utils;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
import java.util.Map;
/*    */ import java.util.Map.Entry;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class ItemManager
/*    */ {
/* 12 */   public static HashMap<ItemStack, String> items = new HashMap();
/*    */   
/*    */   public ItemStack createItem(Material m, String id, String displayName, String[] lore, int amount, short data) {
/* 15 */     ItemStack item = new ItemStack(m, amount, data);
/* 16 */     ItemMeta meta = item.getItemMeta();
/* 17 */     meta.setDisplayName(displayName);
/* 18 */     ArrayList<String> l = new ArrayList();
/* 19 */     if (lore != null) {
/* 20 */       for (int i = 0; i < lore.length; i++) {
/* 21 */         l.add(lore[i]);
/*    */       }
/*    */     }
/* 24 */     meta.setLore(l);
/* 25 */     item.setItemMeta(meta);
/* 26 */     if (items.containsKey(item)) {
/* 27 */       items.remove(item);
/*    */     }
/* 29 */     items.put(item, id);
/* 30 */     return item;
/*    */   }
/*    */   
/*    */   public HashMap<ItemStack, String> getItems() {
/* 34 */     return items;
/*    */   }
/*    */   
/*    */   public ItemStack getItemByID(String id) {
/* 38 */     if (getItems().containsValue(id)) {
/* 39 */       for (Map.Entry<ItemStack, String> en : items.entrySet()) {
/* 40 */         if (((String)en.getValue()).equals(id)) {
/* 41 */           return (ItemStack)en.getKey();
/*    */         }
/*    */       }
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\managers\ItemManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */