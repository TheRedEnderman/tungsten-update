# Tungsten Update

Mod Fabric per Minecraft 26.3 che aggiunge il tungsteno. Mod id: `tungsten-update`.

## Stato attuale

- Minerale di tungsteno (generazione nel sottosuolo)
- Raw tungsten, lingotto di tungsteno, piccone di tungsteno
- Ricetta del piccone (3 lingotti + 2 bastoni)
- Tab creativo "Tungsten Update"

## Come deve funzionare alla fine

- Il minerale richiede un piccone di netherite o superiore.
- Con Silk Touch droppa il blocco di minerale, altrimenti raw tungsten.
- Il minerale richiede sempre 2,5 volte il tempo del minerale di diamante ("troppo friabile").
- Nulla del tungsteno brucia nella lava.
- Il tungsteno è un materiale superiore alla netherite: il piccone di tungsteno mina il minerale ed è migliore del piccone di netherite.
- Il raw tungsten si fonde in lingotto solo nella futura "fornace industriale".

## Bug e cose da fare

- Texture del piccone di tungsteno mancante (appare viola e nero).
- Nessun modo di ottenere il lingotto in survival (manca la fornace industriale e la ricetta di fusione).
- Il piccone ha statistiche inferiori alla netherite (1800 di durabilità, incantabilità 14) e mina esattamente ciò che mina la netherite: non è ancora "superiore".
- Il minerale non supporta Fortune e non dà esperienza.
- Nessuna variante deepslate del minerale, anche se può generarsi in deepslate.
- Generazione naturale del minerale non ancora verificata in gioco; bilanciamento da rivedere (probabilmente troppo comune e troppo in alto).
- Il piccone e gli oggetti non sono nei tab vanilla, mancano i tag convenzionali (`c:ores`, `c:ingots`, `c:raw_materials`).
- La ricetta del piccone non ha un advancement che la sblocchi.
- Mancano le traduzioni dei tag item e la lingua italiana.
- Mixin di esempio (`ExampleMixin`, `ExampleClientMixin`) da rimuovere: con `defaultRequire: 1` possono far crashare il gioco dopo un aggiornamento.
- `loom_version` è uno snapshot (`1.18-SNAPSHOT`).

## Sviluppo

Serve Java 25.

- `.\gradlew runClient` avvia Minecraft con la mod
- `.\gradlew runServer` avvia un server di test
- `.\gradlew build` crea il jar in `build\libs\`

## Licenza

CC0-1.0
