package es.hulk.survival.recipes.recipes.netherite;

import es.hulk.survival.Survival;
import dev.panda.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NetheriteSword {

    public static void load() {
        ItemStack pickaxe = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = pickaxe.getItemMeta();

        meta.setDisplayName(ChatUtil.translate("&dNetherite Sword"));
        meta.setUnbreakable(true);
        pickaxe.setItemMeta(meta);

        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.MENDING, 1);
        pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 50);
        pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
        pickaxe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
        pickaxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);

        NamespacedKey key = new NamespacedKey(Survival.getInstance(), "ultimate_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, pickaxe);
        recipe.shape(" D ", " D ", " I ");
        recipe.setIngredient('D', Material.NETHERITE_BLOCK);
        recipe.setIngredient('I', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

}
