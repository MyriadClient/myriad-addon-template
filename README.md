# My Addon

A starting point for a Myriad addon (see "Writing an addon" in [Myriad's README](https://github.com/fyzz-dev/myriad#writing-an-addon)). It has a module, a mixin-driven module and a
HUD element.

1. In the Myriad repository, run `./gradlew publishToMavenLocal`. Run it again whenever you update Myriad.
2. Rename things: the mod id `my-addon` (in `fabric.mod.json`, `settings.gradle` and the mixin config's file name),
   the package `com.example.addon`, and the class `MyAddon`.
3. `./gradlew runClient` starts the game with Myriad, Myriad Essentials and your addon. `./gradlew build` writes
   your jar to `build/libs/`.

For how to build real features (saved data, commands, windows, more HUD elements, services, talking to other
addons), read [`example-addon/`](https://github.com/fyzz-dev/myriad/tree/master/example-addon) in the Myriad repository.

The template is CC0, so your addon can use any license.
