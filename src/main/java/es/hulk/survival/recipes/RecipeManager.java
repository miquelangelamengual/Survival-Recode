package es.hulk.survival.recipes;

import es.hulk.survival.recipes.recipes.coal.*;
import es.hulk.survival.recipes.recipes.diamond.*;
import es.hulk.survival.recipes.recipes.diamond.armor.*;
import es.hulk.survival.recipes.recipes.emerald.*;
import es.hulk.survival.recipes.recipes.emerald.armor.*;
import es.hulk.survival.recipes.recipes.gold.*;
import es.hulk.survival.recipes.recipes.gold.armor.*;
import es.hulk.survival.recipes.recipes.iron.*;
import es.hulk.survival.recipes.recipes.iron.armor.*;
import es.hulk.survival.recipes.recipes.netherite.*;
import es.hulk.survival.recipes.recipes.netherite.armor.*;
import es.hulk.survival.recipes.recipes.other.*;
import es.hulk.survival.recipes.recipes.stone.*;
import es.hulk.survival.recipes.recipes.wood.*;
import es.hulk.survival.recipes.smithingtable.*;

public class RecipeManager {

    public void loadRecipes() {
        NameTag.load();
        EnchantedGoldenApple.load();

        WoodSword.load();
        WoodPickaxe.load();
        WoodAxe.load();
        WoodShovel.load();

        StoneSword.load();
        StonePickaxe.load();
        StoneAxe.load();
        StoneShovel.load();

        CoalSword.load();
        CoalPickaxe.load();
        CoalAxe.load();
        CoalShovel.load();

        IronAxe.load();
        IronShovel.load();
        IronPickaxe.load();
        IronSword.load();
        IronHelmet.load();
        IronChestplate.load();
        IronLeggins.load();
        IronBoots.load();

        GoldSword.load();
        GoldPickaxe.load();
        GoldAxe.load();
        GoldShovel.load();
        GoldHelmet.load();
        GoldChestplate.load();
        GoldLeggings.load();
        GoldBoots.load();

        DiamondSword.load();
        DiamondFortunePickaxe.load();
        DiamondSilkTouchPickaxe.load();
        DiamondEffiencyPickaxe.load();
        DiamondAxe.load();
        DiamondShovel.load();
        DiamondHelmet.load();
        DiamondChestplate.load();
        DiamondLeggings.load();
        DiamondBoots.load();

        EmeraldSword.load();
        EmeraldPickaxe.load();
        EmeraldAxe.load();
        EmeraldShovel.load();
        EmeraldHelmet.load();
        EmeraldChestplate.load();
        EmeraldLeggings.load();
        EmeraldBoots.load();

        NetheriteSword.load();
        NetheriteFortunePickaxe.load();
        NetheriteSilkPickaxe.load();
        NetheriteAxe.load();
        NetheriteShovel.load();
        NetheriteHelmet.load();
        NetheriteChestplate.load();
        NetheriteLeggings.load();
        NetheriteBoots.load();

        CustomExperienceBottle.load();
        FortuneSword.load();
        FortunePickaxe.load();
        KnockbackStick.load();
        UltimateBow.load();
        EnderPearlRecipe.load();
    }
}
