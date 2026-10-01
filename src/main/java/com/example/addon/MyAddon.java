package com.example.addon;

import com.example.addon.hud.PlayerCountHud;
import com.example.addon.modules.Greeter;
import com.example.addon.modules.WindowTitle;
import dev.myriad.api.addon.AddonContext;
import dev.myriad.api.addon.MyriadAddon;

/**
 * Your addon's entry point, named in fabric.mod.json under {@code entrypoints.myriad}. Rename the package, the mod id
 * ("my-addon" in fabric.mod.json, the mixin config's file name, and settings.gradle) and this class, then build out
 * from here. For a tour of everything the API offers, read Myriad's example-addon.
 */
public final class MyAddon implements MyriadAddon {
	@Override
	public void initialize(AddonContext ctx) {
		ctx.registerModules(new Greeter(), new WindowTitle());
		ctx.registerHud("Player Count", "", PlayerCountHud::new);
	}
}
