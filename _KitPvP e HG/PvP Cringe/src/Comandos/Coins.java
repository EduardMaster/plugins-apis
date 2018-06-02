package Comandos;

import Main.Main;
import Outros.ScoreBoard;
import Utils.KillsDeathsMoney;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import APIs.LetrasAPI;

public class Coins
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cVoce nao e um player!");
      return true;
    }
    Player p = (Player)sender;
    if (args.length < 2)
    {
      p.sendMessage("§8§lMOEDAS §fUse /doar <nick> <quantidade>");
      return true;
    }
    Player t = Bukkit.getPlayer(args[0]);
    if (t == p) {
      p.sendMessage("8§lMOEDAS §fO Player indicado é §3§lVOCE §fMesmo!");
    }
    if (t == null)
    {
      p.sendMessage("8§lMOEDAS §fJogador Nao existe ou esta offline.");
    }
    else
    {
      if (KillsDeathsMoney.getMoney(p) == Integer.parseInt(args[1]))
      {
        KillsDeathsMoney.addMoney(t, Integer.parseInt(args[1]));
        KillsDeathsMoney.removermoney(p, Integer.parseInt(args[1]));
        t.sendMessage("8§lMOEDAS §fVoce Recebeu §b§l " + Integer.parseInt(args[1]) + "§f de §b§l " + p.getDisplayName());
        p.sendMessage("8§lMOEDAS §fVoce acaba de doar §b§l " + Integer.parseInt(args[1]) + "§f para §b§l " + t.getDisplayName());
        ScoreBoard.UpdateScore(p);
        ScoreBoard.UpdateScore(t);
        Main.getInstace().save();
      }
      else
      {
        p.sendMessage("8§lMOEDAS §fVoce nao tem §b§l" + Integer.parseInt(args[1]) + " Coins");
      }
      if (LetrasAPI.ContemLetra(args[1])) {
        p.sendMessage("8§lMOEDAS §fUse apenas numeros!");
      }
    }
    return false;
  }
}
