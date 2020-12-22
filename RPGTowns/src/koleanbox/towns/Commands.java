package koleanbox.towns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import koleanbox.towns.utils.Utils;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("towns") && s instanceof Player) {
			Player p = (Player)s;
			if (args[0].equalsIgnoreCase("info")) {
				p.sendMessage("--------TOWNS OWNERS--------");
				for(String to : Utils.getTownOwenersList()) {
					p.sendMessage(to);
				}
				p.sendMessage("-----------------------------");
			}
			if (args[0].equalsIgnoreCase("teleport")) {
                String town = args[1].toString().toLowerCase();
			}
			return true;
		}
		return false;
	}

}
