package fr.zyumie.setheart;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Démarrage-du-Plugin
	@Override
	public void onEnable() {
	    System.out.println("SetHeart: Plugin On");	    

	    // Commands
	    getCommand("heal").setExecutor(new HealCommand());
	}

    // Plugin-qui-s'éteint
    @Override
    public void onDisable() {
        System.out.println("SetHeart : Plugin Off");
    }
}