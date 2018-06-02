package Efeitos;

import java.util.ArrayList;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;


@SuppressWarnings("unused")
public class RemoverEfeito
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("removerefeito")) && (p.hasPermission("kitpvp.efeitos")))
    {
      p.sendMessage("ง7Efeitos Removidos Com Sucesso!");
      
      p.playSound(p.getLocation(), Sound.SPLASH, 1.0F, 1.0F);
      
      Main.Flames.remove(p.getName());
      Main.Efeitos.remove(p.getName());
      Main.Ender.remove(p.getName());
      Main.Smoke.remove(p.getName());
      Main.Redstone.remove(p.getName());
      Main.Rainbow.remove(p.getName());
      Main.Diamond.remove(p.getName());
      Main.Water.remove(p.getName());
      Main.Potion.remove(p.getName());
    }
    else
    {
      p.sendMessage("ยง4Voce nao tem permissao para remover efeitos!");
      p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0F, 1.0F);
    }
    return false;
  }
}

