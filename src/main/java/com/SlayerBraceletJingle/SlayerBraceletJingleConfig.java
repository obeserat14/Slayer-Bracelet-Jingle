package com.SlayerBraceletJingle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("SlayerBraceletJingle")
public interface SlayerBraceletJingleConfig extends Config
{
	@Range(min = 1, max = 50)
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
			keyName = "BraceletSounds",
			name = "Disable Charge Sound",
			description = "Disables sound for each charge",
			position = 2
	)
	default boolean DisableBraceletSounds()
{
	return false;
}

	@ConfigItem(
			keyName = "LastCharge",
			name = "Disable Last Charge Sound",
			description = "Disables the sound made when on final charge",
			position = 3
	)
	default boolean LastChargeSound()
	{
		return false;
	}

	@ConfigItem(
			keyName = "CrumbledBracelet",
			name = "Disable Crumbled Bracelet Sound",
			description = "Disables the sound made when your bracelet crumbles",
			position = 4
	)
	default boolean CrumbledBraceletSound()
	{
		return false;
	}
}
