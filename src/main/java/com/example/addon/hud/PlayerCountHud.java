package com.example.addon.hud;

import dev.myriad.api.ui.hud.HudStyle;
import dev.myriad.api.ui.hud.TextHudPanel;

/** A HUD element: supply the lines, and sizing, alignment and the standard colour options come for free. */
public final class PlayerCountHud extends TextHudPanel {
	public PlayerCountHud() {
		super("Player Count", "", HudStyle.Mode.TEXT);
	}

	@Override
	protected void lines(Lines out) {
		int players = preview() ? 1 : mc.getNetworkHandler() == null ? 0 : mc.getNetworkHandler().getPlayerList().size();
		out.add("Players", String.valueOf(players));
	}
}
