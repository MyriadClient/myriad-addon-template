# My Addon

A starting point for a Myriad addon (see "Writing an addon" in [Myriad's README](https://github.com/fyzz-dev/myriad#writing-an-addon)). It has a module, a mixin-driven module and a
HUD element. It targets Minecraft 26.2 on Fabric with Mojang names, and needs JDK 25+.

1. In the Myriad repository, run `./gradlew publishToMavenLocal`. Run it again whenever you update Myriad.
2. Rename things: the mod id `my-addon` (in `fabric.mod.json`, `settings.gradle` and the mixin config's file name),
   the package `com.example.addon`, and the class `MyAddon`.
3. `./gradlew runClient` starts the game with Myriad, Myriad Essentials and your addon. `./gradlew build` writes
   your jar to `build/libs/`.

For how to build real features (saved data, commands, windows, more HUD elements, services, talking to other
addons), read [`example-addon/`](https://github.com/fyzz-dev/myriad/tree/master/example-addon) in the Myriad repository.
For anything that breaks, places, builds, rotates or moves items, use Myriad's services (`Myriad.breaking()`,
`placement()`, `building()`, `rotations()`, `inventory()`) rather than sending packets yourself: they're timed and
ordered to pass Grim, the anti-cheat on 2b2t, and they share the packet budget with every other addon.

The template is CC0, so your addon can use any license.
