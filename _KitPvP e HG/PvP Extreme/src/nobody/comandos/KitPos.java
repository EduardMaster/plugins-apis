package nobody.comandos;

import nobody.main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitPos
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kitpos1"))
    {
      if (!p.hasPermission("ng.kitpos"))
      {
        sender.sendMessage("§cSem Permissao");
        return true;
      }
      Main.getInstance().KitPos.set("KitPos1World", p.getLocation().getWorld().getName());
      Main.getInstance().KitPos.set("KitPos1X", Double.valueOf(p.getLocation().getX()));
      Main.getInstance().KitPos.set("KitPos1Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstance().KitPos.set("KitPos1Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstance().save4();
      p.sendMessage("§aKitPos1 Foi setada");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("kitpos2"))
    {
      if (!p.hasPermission("ng.kitpos"))
      {
        sender.sendMessage("§cSem Permissao");
        return true;
      }
      Main.getInstance().KitPos.set(" ", null);
      Main.getInstance().KitPos.set("KitPos2World", p.getLocation().getWorld().getName());
      Main.getInstance().KitPos.set("KitPos2X", Double.valueOf(p.getLocation().getX()));
      Main.getInstance().KitPos.set("KitPos2Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstance().KitPos.set("KitPos2Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstance().save4();
      p.sendMessage("§aKitPos2 Foi setada");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("kitpos3"))
    {
      if (!p.hasPermission("ng.kitpos"))
      {
        sender.sendMessage("§cSem Permissao");
        return true;
      }
      Main.getInstance().KitPos.set(" ", null);
      Main.getInstance().KitPos.set("KitPos3World", p.getLocation().getWorld().getName());
      Main.getInstance().KitPos.set("KitPos3X", Double.valueOf(p.getLocation().getX()));
      Main.getInstance().KitPos.set("KitPos3Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstance().KitPos.set("KitPos3Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstance().save4();
      p.sendMessage("§aKitPos3 Foi setada");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("kitpos4"))
    {
      if (!p.hasPermission("ng.kitpos"))
      {
        sender.sendMessage("§cSem Permissao");
        return true;
      }
      Main.getInstance().KitPos.set(" ", null);
      Main.getInstance().KitPos.set("KitPos4World", p.getLocation().getWorld().getName());
      Main.getInstance().KitPos.set("KitPos4X", Double.valueOf(p.getLocation().getX()));
      Main.getInstance().KitPos.set("KitPos4Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstance().KitPos.set("KitPos4Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstance().save4();
      p.sendMessage("§aKitPos4 Foi setada");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("kitpos5"))
    {
      if (!p.hasPermission("ng.kitpos"))
      {
        sender.sendMessage("§cSem Permissao");
        return true;
      }
      Main.getInstance().KitPos.set(" ", null);
      Main.getInstance().KitPos.set("KitPos5World", p.getLocation().getWorld().getName());
      Main.getInstance().KitPos.set("KitPos5X", Double.valueOf(p.getLocation().getX()));
      Main.getInstance().KitPos.set("KitPos5Y", Double.valueOf(p.getLocation().getY()));
      Main.getInstance().KitPos.set("KitPos5Z", Double.valueOf(p.getLocation().getZ()));
      Main.getInstance().save4();
      p.sendMessage("§aKitPos5 Foi setada");
      return true;
    }
    return false;
  }
}
