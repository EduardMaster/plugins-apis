package me.rafael.vinagre.KomboPvP.Comandos;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    Method[] arrayOfMethod;
    int j;
    int i;
    Field[] arrayOfField;
    int m;
    int k;
    if (args.length > 0)
    {
      Player p = Bukkit.getPlayer(args[0]);
      if (p != null)
      {
        String ping = null;
        j = (arrayOfMethod = p.getClass().getMethods()).length;
        for (i = 0; i < j; i++)
        {
          Method meth = arrayOfMethod[i];
          if (meth.getName().equals("getHandle")) {
            try
            {
              Object obj = meth.invoke(p, null);
              m = (arrayOfField = obj.getClass().getFields()).length;
              for (k = 0; k < m; k++)
              {
                Field field = arrayOfField[k];
                if (field.getName().equals("ping")) {
                  ping = String.valueOf(field.getInt(obj));
                }
              }
            }
            catch (Exception e)
            {
              e.printStackTrace();
            }
          }
        }
        sender.sendMessage("§7O ping de " + ChatColor.GRAY + p.getName() + " é: " + ChatColor.RED + ping + "ms");
      }
      else
      {
        sender.sendMessage(ChatColor.RED + "Player nao encontrado.");
      }
      return true;
    }
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      String ping = null;
      j = (arrayOfMethod = p.getClass().getMethods()).length;
      for (i = 0; i < j; i++)
      {
        Method meth = arrayOfMethod[i];
        if (meth.getName().equals("getHandle")) {
          try
          {
            Object obj = meth.invoke(p, null);
            m = (arrayOfField = obj.getClass().getFields()).length;
            for (k = 0; k < m; k++)
            {
              Field field = arrayOfField[k];
              if (field.getName().equals("ping")) {
                ping = String.valueOf(field.getInt(obj));
              }
            }
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
        }
      }
      sender.sendMessage(ChatColor.GRAY + "Seu ping e de : " + ChatColor.RED + ping + "ms");
    }
    else
    {
      sender.sendMessage(ChatColor.GRAY + "Seu ping e de: " + ChatColor.RED + "0ms");
    }
    return true;
  }
}