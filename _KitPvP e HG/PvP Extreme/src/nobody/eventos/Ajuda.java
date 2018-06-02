package nobody.eventos;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ajuda
  implements CommandExecutor
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    Cmd.getName().equalsIgnoreCase("regras");
    {
    	p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      p.sendMessage("                           ");
      p.sendMessage("§e» §a§m----------------------");
      p.sendMessage("§e» §e§lBem-Vindo a Ajuda!");
      p.sendMessage("§e» §a§l1: §5§LRANK!");
      p.sendMessage("§e»                           ");
      p.sendMessage("§e» §a§lFIRST: §b1K§e De XP");
      p.sendMessage("§e» §a§lNOOB: §b5K§e De XP");
      p.sendMessage("§e» §a§lPRIMARY: §b7K§e De XP");
      p.sendMessage("§e» §a§lINTERMEDIARY: §b10K§e De XP");
      p.sendMessage("§e» §a§lADVANCE: §b13K§e De XP");
      p.sendMessage("§e» §a§lEXPERT: §b16K§e De XP");
      p.sendMessage("§e» §a§lSILVER: §b20K§e De XP");
      p.sendMessage("§e» §a§lGOLD: §b24K§e De XP");
      p.sendMessage("§e» §a§lKING: §b27K§e De XP");
      p.sendMessage("§e» §a§lG0D: §b35K§e De XP");
      p.sendMessage("§e» §a§m----------------------");
      p.sendMessage("§e»                           ");
      p.sendMessage("§e» §a§l2: §6§LREGRAS!");
      p.sendMessage("§e» §eNão forjar hack");
      p.sendMessage("§e» §3Não desrespeitar ninguém.");
      p.sendMessage("§e» §2Não usar qualquer tipo de hack,cliente.");
      p.sendMessage("§e» §aNão pedir staff/vip.");
      p.sendMessage("§e» §bTag youtuber: 1k + Vídeo , PRO: 700 + Video!");
      p.sendMessage("§e»                           ");
      p.sendMessage("§e» §a§l3: §5§LAJUDA!");
      p.sendMessage("§e» §4Primeiramente, obrigado por jogar no");
      p.sendMessage("§e» §cExtreme§fPvP!");
      p.sendMessage("§e» §8Se você não tem nenhuma noção de jogo,");
      p.sendMessage("§e» §6Iremos explicar!");
      p.sendMessage("§e» §1§lComo jogar:");
      p.sendMessage("§e» §fPegue seu kit clicando no baú.");
      p.sendMessage("§e» §7Você ganhará uma espada e um inventário cheio de sopas.");
      p.sendMessage("§e» §6Quando clicar na sopa, ela irá recuperar 3,5 Corações.");
      p.sendMessage("§e» §aAssim fazendo o PVP Durar Mais.");
      p.sendMessage("§e» §3Tem um pc ruim ? Sem Problemas ! Digite /FPS!");
      p.sendMessage("§e» §a§m----------------------");
      p.sendMessage("                           ");
      p.sendMessage("§e» §6§l     SUBA O CHAT     ");
      return true;
    }
  }
}