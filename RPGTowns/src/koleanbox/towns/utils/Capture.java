package koleanbox.towns.utils;

import org.bukkit.Bukkit;

import koleanbox.towns.Towns;

public class Capture {
	
	static int capture;
	
	public static void start() { 
		
		capture = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Towns.getInstance(), new Runnable() {
			int countdown = 15;
            @Override
            public void run() {
            	switch (countdown) {
                case 10:
                    Bukkit.broadcastMessage("10 sek");
                    break;
                case 3: 
                	 Bukkit.broadcastMessage("3 sek");
                     break;
                case 2:
                    Bukkit.broadcastMessage("2 sek");
                    break;
                case 1:
                    Bukkit.broadcastMessage("1 sek");
                    break;
                case 0:
                	Bukkit.broadcastMessage("powla jara");
                    off(capture);
                    break;
                }

                countdown--;
                 
            }
        }, 0L, 20L);
		
		
    }
	
	public static void off(int id) {
		Bukkit.getServer().getScheduler().cancelTask(id);
	}

}
