package com.tenjava.entries.CoderMusgrove.t3;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.CoderMusgrove.t3.handler.RandomEventHandler;

/**
 * The main class for my TenJava plugin.
 * 
 * THEME: What random events can occur in Minecraft?
 * 
 * @author CoderMusgrove
 */
public class TenJava extends JavaPlugin {

	private static TenJava instance;
	private RandomEventHandler randomEventHandler;
	private int delay = 100;
	private int threads = 1;
	private boolean lightning = true;
	private boolean creeper, chargedcreeper = true;
	private boolean rainDogs = true;
	private boolean lava = true;
	private boolean poop = true;
	private boolean waterWave = true;
	private boolean sinkhole = true;
	private boolean takeEntityVelocity = true;
	private boolean bonusChests = true;
	private boolean wind = true;
	private boolean angryWolf = true;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		loadValues();
		randomEventHandler = RandomEventHandler.initialize();
	}

	@Override
	public void onDisable() {
		for (int i = 0; i < randomEventHandler.getRunnables().size(); i++)
			randomEventHandler.getRunnables().get(i).cancel();
	}

	/**
	 * Returns an instance of the TenJava plugin
	 * 
	 * @return
	 */
	public static TenJava getInstance() {
		return instance;
	}

	/**
	 * Gets the delay for each loop of the random event
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * The amount of threads running of the runnable for the random events.
	 * 
	 * @return
	 */
	public int getThreads() {
		return threads;
	}

	/**
	 * Returns if random lightning is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomLightning() {
		return lightning;
	}

	/**
	 * Returns if randomly spawning creatures at any time of day/night is
	 * enabled.
	 * 
	 * @return
	 */
	public boolean getRandomCreepers() {
		return creeper;
	}

	/**
	 * Returns if random creepers will have the potential to become charged.
	 * 
	 * This will not work if random creepers aren't even enabled.
	 * 
	 * @return
	 */
	public boolean getRandomCreeperCharged() {
		return chargedcreeper;
	}

	/**
	 * Returns if raining dogs is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomRainDogs() {
		return rainDogs;
	}

	/**
	 * Returns if lava randomly spawning is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomSpawnLava() {
		return lava;
	}

	/**
	 * Returns if a player randomly pooping is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomPoop() {
		return poop;
	}

	/**
	 * Returns if a random water wave is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomWaterWave() {
		return waterWave;
	}

	/**
	 * Returns if random sinkholes is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomSinkhole() {
		return sinkhole;
	}

	/**
	 * Returns if random takes of an entity's velocity when attacking is
	 * enabled.
	 * 
	 * @return
	 */
	public boolean getRandomTakeEntityVelocity() {
		return takeEntityVelocity;
	}

	/**
	 * Returns if random bonus chests appearing is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomBonusChests() {
		return bonusChests;
	}

	/**
	 * Returns if wind randomly lifting you momentarily is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomWind() {
		return wind;
	}

	/**
	 * Returns if angry wolves spawning randomly to attack you is enabled.
	 * 
	 * @return
	 */
	public boolean getRandomAngryWolf() {
		return angryWolf;
	}

	/**
	 * Loads the values from the config.
	 * 
	 * Each value is handled with a try and catch just in case something goes
	 * wrong.
	 */
	private void loadValues() {
		try {
			delay = getConfig().getInt("delay");
		} catch (Exception e) {
			System.out.println("Error loading 'delay' from config.yml! Using the default value (100)");
		}

		try {
			threads = getConfig().getInt("threads");
		} catch (Exception e) {
			System.out.println("Error loading 'threads' from config.yml! Using the default value (1)");
		}

		try {
			lightning = getConfig().getBoolean("lightning");
		} catch (Exception e) {
			System.out.println("Error loading 'lighting' from config.yml! Using the default value (true)");
		}

		try {
			creeper = getConfig().getBoolean("creeper");
		} catch (Exception e) {
			System.out.println("Error loading 'creeper' from config.yml! Using the default value (true)");
		}

		try {
			chargedcreeper = getConfig().getBoolean("charged-creeper");
		} catch (Exception e) {
			System.out.println("Error loading 'charged-creeper' from config.yml! Using the default value (true)");
		}

		try {
			rainDogs = getConfig().getBoolean("rain-dogs");
		} catch (Exception e) {
			System.out.println("Error loading 'rain-dogs' from config.yml! Using the default value (true)");
		}

		try {
			lava = getConfig().getBoolean("lava");
		} catch (Exception e) {
			System.out.println("Error loading 'lava' from config.yml! Using the default value (true)");
		}

		try {
			poop = getConfig().getBoolean("poop");
		} catch (Exception e) {
			System.out.println("Error loading 'poop' from config.yml! Using the default value (true)");
		}

		try {
			waterWave = getConfig().getBoolean("waterwave");
		} catch (Exception e) {
			System.out.println("Error loading 'waterwave' from config.yml! Using the default value (true)");
		}

		try {
			sinkhole = getConfig().getBoolean("sinkholes");
		} catch (Exception e) {
			System.out.println("Error loading 'sinkholes' from config.yml! Using the default value (true)");
		}

		try {
			sinkhole = getConfig().getBoolean("take-entity-velocity");
		} catch (Exception e) {
			System.out.println("Error loading 'take-entity-velocity' from config.yml! Using the default value (true)");
		}

		try {
			bonusChests = getConfig().getBoolean("bonus-chests");
		} catch (Exception e) {
			System.out.println("Error loading 'bonus-chests' from config.yml! Using the default value (true)");
		}

		try {
			wind = getConfig().getBoolean("wind");
		} catch (Exception e) {
			System.out.println("Error loading 'wind' from config.yml! Using the default value (true)");
		}

		try {
			angryWolf = getConfig().getBoolean("angry-wolf");
		} catch (Exception e) {
			System.out.println("Error loading 'angry-wolf' from config.yml! Using the default value (true)");
		}
	}
}
