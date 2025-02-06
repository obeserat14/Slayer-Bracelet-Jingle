package com.SlayerBraceletJingle;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SlayerBraceletJingleTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SlayerBraceletJinglePlugin.class);
		RuneLite.main(args);
	}
}