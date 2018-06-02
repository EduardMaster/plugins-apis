package me.rafael.vinagre.KomboPvP.Comandos;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Regras
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender Sender, Command cmd, String string, String[] args)
  {
    Player p = (Player)Sender;
    if (cmd.getName().equalsIgnoreCase("regras"))
    {
      p.playSound(p.getLocation(), Sound.NOTE_BASS, 15.0F, 1.0F);
      p.sendMessage("§A- §6>> §C§LREGRAS §6<<");
      p.sendMessage("§A-§6NAO USE HACK OU MACRO");
      p.sendMessage("§A-§6NAO DIVULGUE SV AQUI");
      p.sendMessage("§A-§6NAO XINGE A STAFF NEM O SERVER");
      p.sendMessage("§A-§6NAO FLOODE");
      p.sendMessage("§A-§6NAO CHINGE OS PLAYERS");		
      p.sendMessage("§A-§6NAO ABUSE DE BUG");
      p.sendMessage("§A-§6NAO PEÇA STAFF NEM VIP");
      p.sendMessage("§A-§6NAO PEÇA PARA LER FORMULARIO");
      p.sendMessage("§A-§6NAO FORJE HACK SEM AUTORIZAÇÃO");
      p.sendMessage("§A-§6NAO FALE PORNOGRAFIA NO CHAT");
      p.sendMessage("§A-§4§LSE VC USAR HACK OU DIVULGAR SV");
      p.sendMessage("§A-§4§LVAI SER BAN NA CERTA");
    }
    return false;
  }
}
      
