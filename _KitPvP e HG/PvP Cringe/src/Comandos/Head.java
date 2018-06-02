package Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cComando apenas para players");
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("cmd.admin"))
    {
      p.sendMessage("§2§lHEAD §fSem permissao para isso.");
      return true;
    }
    if (args.length == 0)
    {
      p.sendMessage("");
    }
    else
    {
      ItemStack C1 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
      SkullMeta sm = (SkullMeta)C1.getItemMeta();
      sm.setOwner(args[0]);
      sm.setDisplayName(args[0]);
      sm.setDisplayName("§c:" + args[0]);
      C1.setItemMeta(sm);
      p.getInventory().addItem(new ItemStack[] { C1 });
      p.updateInventory();
    }
    return false;
  }
}
