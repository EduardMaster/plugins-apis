package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.rafael.vinagre.KomboPvP.Main;

public class Chat
  implements CommandExecutor, Listener
{
  public static boolean c = false;
  
  public Chat() {
}

public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("Chat"))
    {
      if (!p.hasPermission("kitpvp.Chat"))
      {
        p.sendMessage("§4§lErro: §c§lAcesso negado");
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage( "§c Use: /Chat [ON/OFF]");
        return true;
      }
      if (Args[0].equalsIgnoreCase("Off"))
      {
        c = true;
        p.sendMessage("§cVocê Desativou o Chat");
        Bukkit.broadcastMessage( "§c O Chat Foi Desativado Pelo Jogador §7" + p.getName());
      }
      if (Args[0].equalsIgnoreCase("On"))
      {
        c = false;
        p.sendMessage("§2Você Ativou o Chat ");
        Bukkit.broadcastMessage( "§2 O Chat Foi Ativado Pelo Jogador §7" + p.getName());
      }
    }
    return false;
  }
  
  @EventHandler
  public void naoFalarNoChatQuandoTiverOFF(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if ((!p.hasPermission("falar.chat")) && (c))
    {
      e.setCancelled(true);
      p.sendMessage("§7 §cO Chat Está Desativado §c");
    }
  }
}
