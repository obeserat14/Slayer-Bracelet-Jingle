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
		//even if the spam filter is on, the client still catches it!
		if (event.getType() == ChatMessageType.SPAM) {
			String message = Text.standardize(event.getMessageNode().getValue()); //this makes the message lowercase

			//contains allows you to grab sections of a string, doesnt have to be the full string
			if ((message.contains("expeditious bracelet helps you progress") || message.contains("bracelet of slaughter prevents"))
					&& !this.config.DisableBraceletSounds()) {
				client.playSoundEffect(3924, this.config.volume());
			}
		}

		//the last 2 charges are handled as a game message by the client instead of spam, edge case required
		if (event.getType() == ChatMessageType.GAMEMESSAGE) {
			String message = Text.standardize(event.getMessageNode().getValue());

			if (message.contains("it has 1 charge left") && !this.config.LastChargeSound()) {
				client.playSoundEffect(3925, this.config.volume());
			}
			if (message.contains("crumbles to dust") && !this.config.CrumbledBraceletSound()) {
				client.playSoundEffect(3926, this.config.volume());
			}
		}
	}

	@Provides
	SlayerBraceletJingleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerBraceletJingleConfig.class);
	}
}
