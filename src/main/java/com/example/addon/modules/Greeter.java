package com.example.addon.modules;

import dev.myriadclient.api.event.Subscribe;
import dev.myriadclient.api.event.events.WorldEvent;
import dev.myriadclient.api.module.Module;
import dev.myriadclient.api.module.Tags;
import dev.myriadclient.api.setting.StringSetting;

/** A module with a setting and an event handler. Handlers only run while the module is enabled. */
public final class Greeter extends Module {
	private final StringSetting message = sgGeneral.string("Message").description("Shown when you join a world.").defaultValue("Welcome back!").build();

	public Greeter() {
		super(Tags.MISC, "Greeter", "Greets you when you join a world.");
	}

	@Subscribe
	private void onJoin(WorldEvent.Join e) {
		info(message.get());
	}
}
