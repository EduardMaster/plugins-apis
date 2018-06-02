package GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sopinha implements Listener, CommandExecutor{
	
	public static ItemStack sopas;
	public static ItemMeta sopasmeta;
	public static ItemStack pt1;
	public static ItemMeta pt1meta;
	public static ItemStack rc2;
	public static ItemMeta rc2meta;
	public static ItemStack rc3;
	public static ItemMeta rc3meta;
	
	
	@SuppressWarnings("rawtypes")
    public static List<String> Lore(String string)
      {
        String[] split = string.split(" ");
        string = "";
        ChatColor color = ChatColor.GOLD;
        @SuppressWarnings("unchecked")
            ArrayList<String> newString = new ArrayList();
        for (int i = 0; i < split.length; i++)
        {
          if ((string.length() > 20) || (string.endsWith(".")))
          {
            newString.add(color + string);
            if ((string.endsWith("."))) {
              newString.add("");
            }
            string = "";
          }
          string = string + (string.length() == 0 ? "" : " ") + split[i];
        }
        newString.add(string);
        return newString;
      }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cPara usar isso tem que ser um player");
			return true;
		}
		Player p = (Player)sender;
		Inventory sopa = Bukkit.createInventory(p, 54, "§6Sopa");
		
		sopas = new ItemStack(Material.MUSHROOM_SOUP);
		sopasmeta = sopas.getItemMeta();
		sopasmeta.setDisplayName("§4Sopinga de Gogumelo");
		sopas.setItemMeta(sopasmeta);
		
		pt1 = new ItemStack(Material.BOWL, 64);
		pt1meta = pt1.getItemMeta();
		pt1meta.setDisplayName("§bCumbuca");
		pt1.setItemMeta(pt1meta);
		
		rc2 = new ItemStack(Material.RED_MUSHROOM, 64);
		rc2meta = rc2.getItemMeta();
		rc2meta.setDisplayName("§6Gogumelo Vermelho");
		rc2.setItemMeta(rc2meta);
		
		rc3 = new ItemStack(Material.BROWN_MUSHROOM, 64);
		rc3meta = rc3.getItemMeta();
		rc3meta.setDisplayName("§6Gogumelo Marron");
		rc3.setItemMeta(rc3meta);
		
		for (int i =1; i != 54; i++) {
			sopa.setItem(i, sopas);
		}
			sopa.setItem(0, pt1);
			sopa.setItem(1, rc2);
			sopa.setItem(2, rc3);
		p.openInventory(sopa);
		return false;
	}
}
