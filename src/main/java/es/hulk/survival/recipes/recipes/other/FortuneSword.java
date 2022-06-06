package es.hulk.survival.recipes.recipes.other;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class FortuneSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&aLooting Sword"));
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 30);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "looting_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" L ", " R ", " I ");
        recipe.setIngredient('L', Material.LAPIS_BLOCK);
        recipe.setIngredient('R', Material.IRON_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
