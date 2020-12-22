package koleanbox.towns.list;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import koleanbox.towns.Towns;
import koleanbox.towns.enums.TownsList;
import koleanbox.towns.enums.TownsPriority;
import koleanbox.towns.interfaces.ITowns;
import koleanbox.towns.utils.Utils;

public class Aden implements ITowns, Listener {

	@Override
	public TownsList getTown() {

		return TownsList.ADEN;
	}

	@Override
	public String Name() {

		return Utils.getTownConfig(getTown()).getString("Town.name");
	}

	@Override
	public Location getCaptureLocation() {
		String[] xyz = Utils.getTownConfig(getTown()).getString("Town.capture.location").split(":");
		int x = Integer.parseInt(xyz[0]);
		int y = Integer.parseInt(xyz[1]);
		int z = Integer.parseInt(xyz[1]);
		Block plate = Towns.getInstance().getServer()
				.getWorld(Utils.getTownConfig(getTown()).getString("Town.capture.world")).getBlockAt(x, y, -z);
		return plate.getLocation();
	}

	@Override
	public TownsPriority getPriority() {
		return Utils.toEnum(Utils.getTownConfig(getTown()).getString("Town.priority"));
	}

	@Override
	public int getCaptureTime() {
		return Utils.getTownConfig(getTown()).getInt("Town.capture.time");
	}

	@Override
	public void letGate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void riseGate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getHolderParty() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Location> getGates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@EventHandler
	public void isCapturing(PlayerMoveEvent e) {
		Bukkit.broadcastMessage("DOWN");
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STONE_PLATE) {
          Bukkit.broadcastMessage("DOWN");
		}
	}

}
