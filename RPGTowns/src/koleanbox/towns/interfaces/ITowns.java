package koleanbox.towns.interfaces;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import koleanbox.towns.enums.TownsList;
import koleanbox.towns.enums.TownsPriority;

public interface ITowns{
	
	public TownsList getTown();
	
	public String Name();
	
	public Location getCaptureLocation();
	
	public TownsPriority getPriority();
	
	public int getCaptureTime();
	
	public void isCapturing(PlayerMoveEvent event);
	
	public boolean isCaptured = false;
	
	public List<Location> getGates();
	
	public void letGate();
	
	public void riseGate();
	
	public void getHolderParty();
	
	
}
