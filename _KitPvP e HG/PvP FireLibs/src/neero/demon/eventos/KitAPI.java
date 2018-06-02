package neero.demon.eventos;

import java.util.HashMap;
import neero.demon.utils.Scoreboard;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitAPI {
	/*      */   public static ItemStack potinho;
	/*      */   public static ItemMeta potinhometa;
	/*      */   public static ItemStack cogu1;
	/*      */   public static ItemMeta cogu1meta;
	/*      */   public static ItemStack cogu2;
	/*      */   public static ItemMeta cogu2meta;
	/*      */   public static ItemStack pote;
	/*      */   public static ItemMeta potemeta;
	/*      */   public static ItemStack bu;
	/*      */   public static ItemMeta bumeta;
	/*      */   public static ItemStack espada;
	/*      */   public static ItemMeta espadameta;
	       public static HashMap<String, String> Kit = new HashMap<String, String>();
	public static HashMap<String, String> Kit2 = new HashMap<String, String>();
	       public static HashMap<String, Integer> KitDelay = new HashMap<String, Integer>();
	
	
	         public static String getkit(Player p)
	         {
	         if (Kit.containsKey(p.getName())) {
	           return (String)Kit.get(p.getName());
	           }
	         return "Nenhum";
	         }
	         public static String getkit2(Player p)
	         {
	        if (Kit2.containsKey(p.getName())) {
	           return (String)Kit2.get(p.getName());
	           }
	         return "Nenhum";
	         }
	       public static void setKit(Player p, String kit) { Kit.put(p.getName(), kit); }
	       public static void setKit2(Player p, String kit) { Kit2.put(p.getName(), kit); }


public static void darsopa(Player p ) {
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				
/*   44 */     potinho = new ItemStack(Material.MUSHROOM_SOUP);
/*   45 */     potinhometa = potinho.getItemMeta();
/*   46 */     potinhometa.setDisplayName("§b» §6Sopinha");
/*   47 */     potinho.setItemMeta(potinhometa);
/*      */     
/*   49 */    cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/*   50 */     cogu1meta = cogu1.getItemMeta();
/*   51 */    cogu1meta.setDisplayName("§b» §6Cogumelo");
/*   52 */     cogu1.setItemMeta(cogu1meta);
/*      */     
/*   54 */    cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/*   55 */    cogu2meta = cogu2.getItemMeta();
/*   56 */    cogu2meta.setDisplayName("§b» §eCogumelo");
/*   57 */    cogu2.setItemMeta(cogu2meta);
/*      */     
/*   59 */    pote = new ItemStack(Material.BOWL, 64);
/*   60 */    potemeta = pote.getItemMeta();
/*   61 */     potemeta.setDisplayName("§b» §7Pote");
/*   62 */     pote.setItemMeta(potemeta);
/*      */     
/*   64 */     bu = new ItemStack(Material.COMPASS);
/*   65 */     bumeta = bu.getItemMeta();
/*   66 */     bumeta.setDisplayName("§b» §aBússola");
/*   67 */     bu.setItemMeta(bumeta);
/*      */     Scoreboard.iscoriboard(p);
/*   69 */     for (int i = 1; i < 35; i++) {
/*   70 */       p.getInventory().addItem(new ItemStack[] { potinho });
				 p.getInventory().setItem(0, espada);
/*   71 */      p.getInventory().setItem(15, cogu1);
/*   72 */      p.getInventory().setItem(14, cogu2);
/*   73 */      p.getInventory().setItem(13, pote);
/*   74 */       p.getInventory().setItem(8, bu);
/*      */     }
/*      */   }
/*      */
public static void setitem(Player p, Material mat, String nome, int lugar) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

}
