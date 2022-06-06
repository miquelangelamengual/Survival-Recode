package es.hulk.survival.recipes.recipes.gold;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&6Golden Sword"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 2);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "gold_block_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" R ", " R ", " I ");
        recipe.setIngredient('R', Material.GOLD_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
