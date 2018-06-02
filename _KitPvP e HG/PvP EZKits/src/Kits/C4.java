package Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Utils.Array;

public class C4
  implements CommandExecutor, Listener
{
  public static Main plugin;
  
  public C4(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("C4"))
    {
      if (!p.hasPermission("kit.c4"))
      {
        p.sendMessage("§7[§c!§7]§c Você não tem permissão para este kit! §7[§c!§7]");
        return true;
      }
      if (Array.Usando.contains(p.getName()))
      {
        p.sendMessage("§7[§c!§7]§c Você já esta usando um kit! §7[§c!§7]");
        return true;
      }
      ItemStack kPvP = new ItemStack(Material.IRON_SWORD);
      ItemMeta mPvP = kPvP.getItemMeta();
      mPvP.setDisplayName("§6§oEspada");
      kPvP.setItemMeta(mPvP);
      
      ItemStack kC4 = new ItemStack(Material.WOOD_BUTTON);
      ItemMeta mC4 = kC4.getItemMeta();
      mC4.setDisplayName("§a§oC4");
      kC4.setItemMeta(mC4);
      
      p.sendMessage("§7[§c!§7]§2 Você pegou o kit: §6§oC4 §7[§c!§7]");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      

      
      p.getInventory().setItem(0, kPvP);
      p.getInventory().setItem(1, kC4);
      
      
      p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      
      
      Array.C4.add(p.getName());
      Array.Usando.add(p.getName());
    }
    return false;
  }
}
