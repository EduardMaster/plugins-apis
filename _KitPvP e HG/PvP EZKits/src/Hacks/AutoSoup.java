package Hacks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Main.Main;

public class AutoSoup
  implements CommandExecutor
{
  public static String resultado = "§cDesconhecido!";
  public HashMap<String, ItemStack[]> saveinv = new HashMap<  >();
  
  public boolean onCommand(CommandSender sender, Command comando, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (comando.getName().equalsIgnoreCase("autosoup")) {
      if ((sender instanceof Player))
      {
        if (!p.hasPermission("system.autosoup"))
        {
          p.sendMessage("§6§lEZKits §cVocê não pode fazer isto!");
          return true;
        }
        if (args.length == 0)
        {
          p.sendMessage("§6§lEZKits §7Use /autosoup (Nick)");
          return true;
        }
        final Player t = Bukkit.getPlayer(args[0]);
        if (t == null)
        {
          p.sendMessage("§6§lEZKits §cEste Jogador não está online");
          return true;
        }
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        this.saveinv.put(t.getName(), t.getInventory().getContents());
        t.getInventory().clear();
        t.getInventory().setItem(10, sopa);
        t.setHealth(1.0D);
        p.sendMessage("§6§lEZKits §aTestando o Player!");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
        	  if(((CraftPlayer)t).getHealth() < 3.0D){

              AutoSoup.resultado = "Não Usa auto-soup";
            } else {
              AutoSoup.resultado = "Usa auto-soup";
            }
            p.sendMessage("§6§lEZKits > §e§lAntiCheat");
            p.sendMessage("");
            p.sendMessage("§bPlayer Testado > §6" + t.getName());
            p.sendMessage("");
            p.sendMessage("§bResultado > §6" + AutoSoup.resultado);
            p.sendMessage("");
            t.setHealth(20.0D);
            t.getInventory().setContents((ItemStack[])AutoSoup.this.saveinv.get(t.getName()));
            t.updateInventory();
          }
        }, 20L);
      }
      else
      {
        sender.sendMessage("§cVocê não é um player ");
      }
    }
    return false;
  }
}
