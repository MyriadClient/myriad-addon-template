# My Addon

A starting point for a [Myriad](https://myriadclient.dev/) addon (see the [developer docs](https://myriadclient.dev/docs/develop)). It has a module, a mixin-driven module and a
HUD element. It targets Minecraft 26.2 on Fabric with Mojang names, and needs JDK 25+.

1. Rename things: the mod id `my-addon` (in `fabric.mod.json`, `settings.gradle`, the mixin config's file name and
   the `assets/my-addon/` folder), the package `com.example.addon`, and the class `MyAddon`. Replace the blueprint
   `icon.png` with your own (Myriad's addons use one outlined square, a link of Myriad's logo, in their own
   colours). Point `contact.sources` in `fabric.mod.json` at your GitHub repository: Myriad offers players your new
   GitHub releases (tag `v<version>`, with the jar attached) as updates.
2. `./gradlew runClient` starts the game with Myriad, Myriad Essentials and your addon (`-PopenDesktop` opens the
   menu on the title screen). `./gradlew build` writes your jar to `build/libs/`. The build runs on Myriad's Gradle
   plugin, from its maven (`https://maven.myriadclient.dev/releases`): its version in `build.gradle` is the Myriad
   release you build against, and it brings Minecraft, Fabric and Myriad at that release's versions, the dev client
   and the check that you use only Myriad's API ([Setting up](https://myriadclient.dev/docs/develop/setup) lists all
   it does). To build against unreleased Myriad changes, build core's jar in a Myriad checkout next to this one
   (`./gradlew :core:jar`) and build here with `-PcoreDir=../myriad`.
3. To smoke-test every module, append `selftest` to `run/myriad-dev-inbox` while the game is in a world: each module
   is turned on for a second and off again, and the log reports any that failed or whose handlers threw. The file
   takes any Myriad command too (`.toggle greeter on`), and Myriad's `tools/grim-test/` drives it against a local
   Grim server.

Settings a player will want to change go on the module; a behaviour that would be on nearly always should simply be
on. Don't add a "Strict" option for anti-cheats: use the services' `forServer()` presets, which follow the player's
anti-cheat profile (Auto detects Grim per server).

For how to build real features (saved data, commands, windows, more HUD elements, services, talking to other
addons), read [`example-addon/`](https://github.com/MyriadClient/myriad-core/tree/master/example-addon) in the Myriad repository.
For anything that breaks, places, builds, rotates or moves items, use Myriad's services (`Myriad.breaking()`,
`placement()`, `building()`, `rotations()`, `inventory()`) rather than sending packets yourself: they're timed and
ordered to pass Grim, the anti-cheat on 2b2t, and they share the packet budget with every other addon.

The template is CC0, so your addon can use any license.
