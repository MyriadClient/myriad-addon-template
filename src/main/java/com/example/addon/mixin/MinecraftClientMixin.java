package com.example.addon.mixin;

import com.example.addon.modules.WindowTitle;
import dev.myriadclient.api.module.Modules;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {
	// Prefix injector names with your mod id so they can't clash with other mods' mixins.
	@Inject(method = "createTitle", at = @At("RETURN"), cancellable = true)
	private void myAddon$windowTitle(CallbackInfoReturnable<String> cir) {
		WindowTitle m = Modules.active(WindowTitle.class);
		// Through the guard: an exception here turns the module off instead of crashing the game.
		if (m != null) Modules.guard(m, () -> cir.setReturnValue(m.title.get()));
	}
}
