package koleanbox.towns;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import koleanbox.towns.enums.TownsList;
import koleanbox.towns.list.Aden;
import koleanbox.towns.utils.Utils;

public class Towns extends JavaPlugin{

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		if(!getConfig().getBoolean("enable")) {
			Bukkit.getPluginManager().disablePlugin(this);
		}
		for(TownsList e : TownsList.values()) {
			Utils.DEBUG(e + " town load!");
			Utils.getTownConfig(e);
		}
		getServer().getPluginManager().registerEvents(new Aden(), this);
	}
	
	public static Towns getInstance() {
		return (Towns) Bukkit.getPluginManager().getPlugin("RPGTowns");
	}
}
