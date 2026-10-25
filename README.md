# Tungsten Update

A Fabric mod for Minecraft 26.3 that adds tungsten. Mod id: `tungsten-update`.

## Current state

- Tungsten ore (generates underground)
- Raw tungsten, tungsten ingot, tungsten pickaxe
- Pickaxe recipe (3 ingots + 2 sticks)
- Creative tab "Tungsten Update"

## How it should work in the end

- The ore requires a netherite pickaxe or better.
- With Silk Touch the ore drops itself, otherwise it drops raw tungsten.
- The ore always takes 2.5 times as long to mine as diamond ore ("too brittle").
- Nothing made of tungsten burns in lava.
- Tungsten is a material superior to netherite: the tungsten pickaxe mines the ore and is better than the netherite pickaxe.
- Raw tungsten can only be smelted into an ingot in the future "industrial furnace".

## Known bugs and to-do

- The tungsten pickaxe texture is missing (shows as purple and black).
- There is no way to get an ingot in survival (the industrial furnace and the smelting recipe are missing).
- The pickaxe has worse stats than netherite (1800 durability, enchantability 14) and mines exactly what netherite mines, so it is not yet "superior".
- The ore does not support Fortune and drops no experience.
- No deepslate variant of the ore, although it can generate in deepslate.
- Natural ore generation has not been tested in game yet; balance needs a review (probably too common and too high up).
- Items are not in the vanilla creative tabs, and the conventional tags are missing (`c:ores`, `c:ingots`, `c:raw_materials`).
- The pickaxe recipe has no advancement to unlock it.
- Item tag translations and an Italian language file are missing.
- Example mixins (`ExampleMixin`, `ExampleClientMixin`) should be removed: with `defaultRequire: 1` they can crash the game after a Minecraft update.
- `loom_version` is a snapshot (`1.18-SNAPSHOT`).

## Development

Requires Java 25.

- `.\gradlew runClient` starts Minecraft with the mod
- `.\gradlew runServer` starts a test server
- `.\gradlew build` builds the jar into `build\libs\`

## Bug reports

Found a bug or a problem? Message me on Discord: `.enderman_.`

## License

CC0-1.0