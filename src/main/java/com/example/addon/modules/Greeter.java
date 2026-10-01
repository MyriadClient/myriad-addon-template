package com.example.addon.modules;

import dev.myriad.api.event.Subscribe;
import dev.myriad.api.event.events.WorldEvent;
import dev.myriad.api.module.Categories;
import dev.myriad.api.module.Module;
import dev.myriad.api.setting.StringSetting;

/** A module with a setting and an event handler. Handlers only run while the module is enabled. */
public final class Greeter extends Module {
	private final StringSetting message = sgGeneral.string("Message").description("Shown when you join a world.").defaultValue("Welcome back!").build();

	public Greeter() {
		super(Categories.MISC, "Greeter", "Greets you when you join a world.");
	}

	@Subscribe
	private void onJoin(WorldEvent.Join e) {
		info(message.get());
	}
}
