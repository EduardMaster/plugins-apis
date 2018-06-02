package me.rafael.vinagre.KomboPvP.Comandos;



	import org.bukkit.Sound;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandExecutor;
	import org.bukkit.command.CommandSender;
	import org.bukkit.entity.Player;

	import me.rafael.vinagre.KomboPvP.Main;

	public class Help implements CommandExecutor{

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label,
				String[] args) {
			Player p = (Player) sender;
			if(label.equalsIgnoreCase("help")) {
				p.sendMessage("§4Permissoes do plugin:"); 
				p.sendMessage("§3Qualquer Kit: §akitpvp.kit.nomedokit");
				p.sendMessage("§3Ex de perm de kit: §akitpvp.kit.kangaroo");
				p.sendMessage("§3Qualquer Comando: §akitpvp.comando");
				p.sendMessage("§3Ex de perm de comando: §akitpvp.tp");
				p.sendMessage("§3Perm do /kills: §akitpvp.darkills");
				p.sendMessage("§3Setar warp: §aset.warp");
				p.sendMessage("§3Setar spawn: §aset.spawn");
				p.sendMessage("§3Falar chat mutado: §afalar.chat");
				p.sendMessage("§3Dar fly pra alguen: §akitpvp.darfly");
				p.sendMessage("§3Falar §6Colorido§3: §achat.color");
				p.sendMessage("§3Para fazer o teleporte de kits");
				p.sendMessage("§3De /setarena 1 ao 7 pelo mapa");
				
				p.playSound(p.getLocation(), Sound.DOOR_OPEN, 12.0F, 12.0F);
			}
			return false;
		}
	}
