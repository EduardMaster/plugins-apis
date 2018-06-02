package nobody.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager
{
	
  public static HashMap<ItemStack, String> items = new HashMap<ItemStack, String>();
  
  public ItemStack createItem(Material m, String id, String displayName, String[] lore, int amount, short data)
  {	
	  
    ItemStack item = new ItemStack(m, amount, data);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(displayName);
    ArrayList<String> l = new ArrayList<String>();
    if (lore != null) {
      for (int i = 0; i < lore.length; i++) {
        l.add(lore[i]);
      }
    }
    meta.setLore(l); 
    item.setItemMeta(meta);
    if (items.containsKey(item)) {
      items.remove(item);
    }
    items.put(item, id);
    return item;
  }
  
  
  public HashMap<ItemStack, String> getItems()
  {
    return items;
  }
  
  public ItemStack getItemByID(String id)
  {
    if (getItems().containsValue(id)) {
      for (Entry<ItemStack, String> en : items.entrySet()) {
        if (((String)en.getValue()).equals(id)) {
          return (ItemStack)en.getKey();
        }
      }
    }
    return null;
  }
}
