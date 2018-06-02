package nobody.comandos;

import java.util.HashMap;

import nobody.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Autosoup
  implements CommandExecutor
{
  public static String resultado = "§6Desconhecido!";
  public HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
  
  public boolean onCommand(CommandSender sender, Command comando, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (comando.getName().equalsIgnoreCase("autosoup")) {
      if ((sender instanceof Player))
      {
        if (!p.hasPermission("tk.autosoup"))
        {
          p.sendMessage("§7[§6§l!§7] §cPerms");
          return true;
        }
        if (args.length == 0)
        {
          p.sendMessage("§7[§6§l!§7] §eUtilize:");
          p.sendMessage("§7[§6§l!§7] §b/autosoup §f<jogador>");
          return true;
        }
        final Player t = Bukkit.getPlayer(args[0]);
        if (t == null)
        {
          p.sendMessage("§7[§6§l!§7] §cJogador Offline");
          return true;
        }
        p.sendMessage("§7[§6§l!§7] §7Testando Jogador...");
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        this.saveinv.put(t.getName(), t.getInventory().getContents());
        t.getInventory().clear();
        t.getInventory().setItem(10, sopa);
        t.setHealth(1.0D);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getMain(), new Runnable()
        {
          public void run()
          {
            if 	(((CraftPlayer)t).getHealth() > 3.0D) {
              Autosoup.resultado = "Usa Auto-Soup";
            } else {
              Autosoup.resultado = "Não usa Auto-Soup";
            }
            p.sendMessage("§6{§a§lAUTO-SOUP§6}");
            p.sendMessage("");
            p.sendMessage("§eVocê Testou§b: §7" + t.getName());
            p.sendMessage("");
            p.sendMessage("§eStaff§b: §7" + p.getName());
            p.sendMessage("");
            p.sendMessage("§eResultado§b: §7" + Autosoup.resultado);
            p.sendMessage("");
            t.setHealth(20.0D);
            t.getInventory().setContents((ItemStack[])Autosoup.this.saveinv.get(t.getName()));
            t.updateInventory();
          }
        }, 20L);
      }
      else
      {
        sender.sendMessage("§b§lConsole ?");
      }
    }
    return false;
  }
}
