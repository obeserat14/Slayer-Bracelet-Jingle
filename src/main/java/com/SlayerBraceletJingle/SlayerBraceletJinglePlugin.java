package com.SlayerBraceletJingle;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;



@Slf4j
@PluginDescriptor(
	name = "Slayer Bracelet Jingle"
)
public class SlayerBraceletJinglePlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private SlayerBraceletJingleConfig config;

	@Override
	protected void startUp() throws Exception
	{ 			}

	@Override
	protected void shutDown() throws Exception
	{			}

	@Subscribe
	private void onChatMessage(ChatMessage event) {
		if (event.getType() == ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.GAMEMESSAGE) {
			String message = Text.standardize(event.getMessageNode().getValue());
			if (message.contains("Some nicely cooked trout.")) {
				client.playSoundEffect(3924, this.config.volume());
			}
		}
	}
	@Provides
	SlayerBraceletJingleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerBraceletJingleConfig.class);
	}
}
