package koleanbox.towns.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import koleanbox.towns.Towns;
import koleanbox.towns.enums.TownsList;
import koleanbox.towns.enums.TownsPriority;

public class Utils {

	public static File town_file;
	public static FileConfiguration town_cfg;

	public static FileConfiguration getTownConfig(TownsList town) {
		town_file = new File(Towns.getInstance().getDataFolder(), town.name().toLowerCase() + ".yml");
		if (!town_file.exists()) {
			try {
				town_file.createNewFile();
				town_cfg = YamlConfiguration.loadConfiguration(town_file);
				ifCreatedConfiguration(town_cfg, town);
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		town_cfg = YamlConfiguration.loadConfiguration(town_file);
		return town_cfg;
	}

	public static void reload() throws FileNotFoundException, IOException, InvalidConfigurationException {
		Utils.town_cfg.load(Utils.town_file);
	}

	public static TownsPriority toEnum(String priority) {
		if (priority.equalsIgnoreCase("COMMON")) {
			return TownsPriority.COMMON;
		}
		if (priority.equalsIgnoreCase("MEDIUM")) {
			return TownsPriority.MEDIUM;
		}
		if (priority.equalsIgnoreCase("GREAT")) {
			return TownsPriority.GREAT;
		}
		return null;
	}
	
	public static void ifCreatedConfiguration(FileConfiguration town_cfg,TownsList town) throws IOException {
		town_cfg.addDefault("Town.name", town.name());
		town_cfg.addDefault("Town.capture.location", "0:0:0");
		town_cfg.addDefault("Town.capture.defend.location",  "0:0:0");
		town_cfg.addDefault("Town.capture.world", town.name());
		town_cfg.addDefault("Town.priority", "COMMON,MEDIUM or GREAT");
		town_cfg.addDefault("Town.capture.time", 15);
		town_cfg.addDefault("Town.event.time", 120);
		town_cfg.addDefault("Town.gate.hp", 20);
		town_cfg.addDefault("Town.msg.captured", town.name() + " captured");
		town_cfg.addDefault("Town.msg.capturing",town.name() +  " capturing");
		town_cfg.addDefault("Town.msg.occupied", town.name() + " suc occupied");
		town_cfg.addDefault("Town.msg.defended", town.name() + " suc defend");
		town_cfg.addDefault("Town.msg.gateHp", town.name() + " gate have %hp%");
		town_cfg.addDefault("Town.msg.gateBroke", town.name() + " gate has broken");
		town_cfg.addDefault("Town.owners", "PartyDaunov");
		town_cfg.options().copyDefaults(true);
		town_cfg.save(town_file);
	}
	
	public static Logger log = Logger.getLogger("Minecraft");
	
	public static void DEBUG(String msg) {
		 String name = Towns.getInstance().getName();
		log.info("[" + name + "] " + msg);
	}
	
	public static List<String> getTownOwenersList() {
		List<String> list = new ArrayList<String>();
		for(TownsList e : TownsList.values()) {
			list.add(e + " occupied by" + Utils.getTownConfig(e).get("Town.owners"));
		}
		return list;
	}
	
	

}
