package Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import ca.wacos.nametagedit.NametagAPI;
import ca.wacos.nametagedit.NametagChangeEvent;
import ca.wacos.nametagedit.NametagEdit;
import ru.tehkode.permissions.exceptions.RankingException;

@SuppressWarnings("unused")
public class Tag implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("tag"))) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("*")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					p.sendMessage("§c§lADMIN");
					p.sendMessage("§C§L§OGERENTE");
					p.sendMessage("§4§lDONO");
					return true;
				}
				if (p.hasPermission("tag.gerente")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§5§lTRIAL");
					p.sendMessage("§5§lMOD");
					p.sendMessage("§5§lMOD+");
					p.sendMessage("§c§lADMIN");
					p.sendMessage("§C§L§OGERENTE");
					return true;
				}
				if (p.hasPermission("tag.ultimate")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§d§lULTIMATE");
					return true;
				}
				if (p.hasPermission("tag.Admin")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§b§lYOUTUBER");
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§c§lADMIN");;
					return true;
				}
				if (p.hasPermission("tag.mod")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§5§lMOD");;
					return true;
				}
				if (p.hasPermission("tag.trial")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§a§lLIGHT");;
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§5§lTRIAL");
					return true;
				}
				if (p.hasPermission("tag.helper")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                        l");
					p.sendMessage("§3§lTAGS§f de ultilidade §e§lSTAFF§f:");
					p.sendMessage("                        ");
					p.sendMessage("§9§lAJUDANTE");
					return true;
				}
				if (p.hasPermission("tag.Youtuber")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					p.sendMessage("§a§lLIGHT");
					p.sendMessage("§d§lULTIMATE");
					p.sendMessage("§b§lYOUTUBER");
					return true;
				}
				if (p.hasPermission("tag.premium")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                   ");
					p.sendMessage("§6§lPREMIUM");
					return true;
				}
				if (p.hasPermission("tag.normal")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					return true;
				}
				if (p.hasPermission("tag.light")) {
					p.sendMessage("§9§lTAGS §fSelecione sua §3§lTAG:");
					p.sendMessage("§7§lNORMAL");
					p.sendMessage("                 ");
					p.sendMessage("§3§lTAGS§f de ultilidade §A§LVIP§f:");
					p.sendMessage("                  ");
					p.sendMessage("§a§lLIGHT");
					return true;
				}
				return false;
			}
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("tag.normal")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §7§lNORMAL");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§7");
					p.setDisplayName("§7" + p.getName());
					p.setPlayerListName("§7" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("premium")) {
				if (p.hasPermission("tag.premium")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §6§lPREMIUM");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§6§lPREMIUM§6 ");
					p.setDisplayName("§6§lPREMIUM§6 " + p.getName());
					p.setPlayerListName("§6" + p.getName());
					return true;

				}
				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}
			if (args[0].equalsIgnoreCase("helper")) {
				if (p.hasPermission("tag.helper")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §9§lAJUDANTE");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§9§o");
					p.setDisplayName("§9§lAJUDANTE§6 " + p.getName());
					p.setPlayerListName("§9" + p.getName());
					return true;
				}

				p.sendMessage("§cSem Permissao para isso");
			}

			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §e§lBUILDER");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§2");
					p.setDisplayName("§e§lBUILDER§e " + p.getName());
					p.setPlayerListName("§e" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("light")) {
				if (p.hasPermission("tag.light")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §a§lLIGHT");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§a");
					p.setDisplayName("§a§lLIGHT§a " + p.getName());
					p.setPlayerListName("§9" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §b§lYOUTUBER");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§b");
					p.setDisplayName("§b§lYOUTUBER§b " + p.getName());
					p.setPlayerListName("§b" + p.getName());
					return true;
				}
				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("youtuberplus")) {
				if (p.hasPermission("tag.youtuberplus")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §3§lYT+");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§e§o");
					p.setDisplayName("§3§lYT+§3 " + p.getName());
					p.setPlayerListName("§3§o" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §5§lTRIAL");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§d");
					p.setDisplayName("§5§lTRIAL§5 " + p.getName());
					p.setPlayerListName("§5" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §5§lMOD");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§5");
					p.setDisplayName("§5§lMOD§5 " + p.getName());
					p.setPlayerListName("§5" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §c§lADMIN");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§c");
					p.setDisplayName("§c§lADMIN§c " + p.getName());
					p.setPlayerListName("§c" + p.getName());
					return true;
				}
				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §4§lDONO");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§4");
					p.setDisplayName("§4§lDONO§4 " + p.getName());
					p.setPlayerListName("§4" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}

			if (args[0].equalsIgnoreCase("ultimate")) {
				if (p.hasPermission("tag.ultimate")) {
					p.sendMessage(" ");
					p.sendMessage("§3§lTAG§f Voce esta §3§lULTILIZANDO§f A Tag §d§lULTIMATE");
					p.sendMessage(" ");
					NametagAPI.setPrefix(p.getName(), "§d");
					p.setDisplayName("§d§lULTIMATE§d " + p.getName());
					p.setPlayerListName("§d§o" + p.getName());
					return true;
				}

				p.sendMessage("§cVoce nao tem permissao para esta tag");
			}
					return true;

				}
		return false;
	}
}
	