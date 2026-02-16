# Prokletí kamenného Golema

Autor: Vojtěch Uhlík,
Pololetní projekt – Informační technologie

### Popis projektu

Prokletí kamenného Golema je textová adventura vytvořená v jazyce Java. 
Hráč se ujímá role postavy, která se probouzí ve staré pevnosti ovládané temnou magií.
Cílem hry je prozkoumat jednotlivé místnosti, 
získat potřebné předměty a znalosti a následně porazit hlavního nepřítele – Golema.

Projekt je zaměřen na využití objektově orientovaného programování, 
práci s herní logikou, návrh tříd a implementaci příkazového systému. 
Součástí řešení jsou také jednotkové testy ověřující funkčnost vybraných částí aplikace.

### Hlavní funkce

Hra umožňuje pohyb mezi místnostmi, práci s inventářem, 
sbírání a používání předmětů, komunikaci s postavami a bojový systém založený na splnění určitých podmínek. 
Některé místnosti jsou uzamčené a hráč musí nejprve získat potřebné předměty, aby mohl postupovat dál.
Výhra je jednoznačně definována poražením Golema a vstupem do portálu.

### Instalace a spuštění

Projekt je vytvořen v jazyce Java. Pro spuštění je potřeba:

-nainstalované JDK (doporučena verze 17 nebo vyšší)

-vývojové prostředí (například IntelliJ IDEA)

#### Postup spuštění:

-Otevřít projekt v IDE

-Zkompilovat projekt

-Spustit hlavní třídu Main

-Hra probíhá v konzoli

### Použití

Hra je ovládána textovými příkazy zadávanými do konzole.

#### Základní příklady použití:
`-jdi zbrojnice`

`-vezmi stary_mec`

`-pouzij stary_svitek`

`-utoc golem`

`-inventar`

Hráč musí správně kombinovat pohyb, sbírání předmětů a jejich používání, aby mohl úspěšně dokončit hru.

### Struktura projektu

Projekt je rozdělen do několika hlavních částí:

-třídy reprezentující herní svět (Game, Location, Player, Item),

-rozhraní Command a jeho implementace jednotlivých příkazů, herní data a jejich načítání, 
testovací balíček obsahující jednotkové testy.

-Třídy jsou navrženy podle principů objektově orientovaného programování.

### Testování

Součástí projektu jsou jednotkové testy vytvořené pomocí frameworku JUnit 5. Testována je zejména:

-práce s inventářem,

-pohyb mezi lokacemi,

-používání předmětů,

-chování vybraných příkazů.

Testy ověřují správnou funkčnost herní logiky a pomáhají předcházet chybám při úpravách kódu.

### Závislosti

Projekt využívá:

-Java

-JUnit 5 (pro testování)

-gson(pro načítání dat z json souboru)
### Známá omezení

Hra je navržena jako lineární dobrodružství s pevně danou strukturou mapy. 
Neobsahuje grafické rozhraní ani ukládání postupu hry. 
Inventář má omezenou kapacitu a bojový systém je založen na jednoduché podmínkové logice.
