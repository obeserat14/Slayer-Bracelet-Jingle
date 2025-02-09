package com.SlayerBraceletJingle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("SlayerBraceletJingle")
public interface SlayerBraceletJingleConfig extends Config
{
	@Range(min = 1, max = 100)
	@ConfigItem(
			keyName = "volume",
			name = "Volume",
			description = "Sound effect volume",
			position = 1
	)
	default int volume()
	{
		return 20;
	}

	@ConfigItem(
			keyName = "braceletSound",
			name = "Bracelet Charge Sound",
			description = "select the ID to play for when you lose a charge",
			position = 2
	)
	default int braceletSound()
	{
		return 65;
	}

	@ConfigItem(
			keyName = "lastChargeSound",
			name = "Last Charge Sound",
			description = "select the sound ID to play for when on your last charge",
			position = 3
	)
	default int lastChargeSound()
	{
		return 2268;
	}

	@ConfigItem(
			keyName = "crumbledBraceletSound",
			name = "Crumbled Bracelet Charge Sound",
			description = "select a sound ID to play for when your bracelet crumbles ",
			position = 4
	)
	default int crumbledBraceletSound()
	{
		return 2589;
	}
	@ConfigItem(
			keyName = "disableBraceletSounds",
			name = "Disable Charge Sound",
			description = "Disables sound for each charge",
			position = 4
	)
	default boolean disableBraceletSounds()
{
	return false;
}

	@ConfigItem(
			keyName = "lastCharge",
			name = "Disable Last Charge Sound",
			description = "Disables the sound made when on final charge",
			position = 5
	)
	default boolean disableLastChargeSound()
	{
		return false;
	}

	@ConfigItem(
			keyName = "crumbledBracelet",
			name = "Disable Crumbled Bracelet Sound",
			description = "Disables the sound made when your bracelet crumbles",
			position = 6
	)
	default boolean disableCrumbledBraceletSound()
	{
		return false;
	}
}
