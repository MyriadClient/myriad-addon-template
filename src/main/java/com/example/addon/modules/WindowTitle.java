package com.example.addon.modules;

import dev.myriad.api.module.Categories;
import dev.myriad.api.module.Module;
import dev.myriad.api.setting.StringSetting;
import net.minecraft.client.Minecraft;

/**
 * A module driven by a mixin ({@code MinecraftClientMixin}) rather than events: the mixin asks
 * {@code Modules.active(WindowTitle.class)} whether to act and reads the setting from it.
 */
public final class WindowTitle extends Module {
	public final StringSetting title = sgGeneral.string("Title").description("Replaces the game window's title.").defaultValue("Minecraft").build();

	public WindowTitle() {
		super(Categories.MISC, "Window Title", "Sets the game window's title.");
		// The title only refreshes when vanilla asks for it; nudge it whenever ours changes.
		title.onChanged(v -> refresh());
	}

	@Override
	protected void onEnable() {
		refresh();
	}

	@Override
	protected void onDisable() {
		refresh();
	}

	private static void refresh() {
		Minecraft mc = Minecraft.getInstance();
		if (mc.getWindow() != null) mc.execute(mc::updateTitle);
	}
}
