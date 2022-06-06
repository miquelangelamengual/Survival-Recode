package es.hulk.survival.providers;

import com.google.common.collect.Sets;
import es.hulk.survival.utils.PlayerUtils;
import es.hulk.tablist.TablistAdapter;
import es.hulk.tablist.TablistLayout;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TablistProvider implements TablistAdapter {
    @Override
    public Set<TablistLayout> getProvider(Player player) {
        Set<TablistLayout> layoutSet = Sets.newHashSet();
        PlayerUtils playerUtils = new PlayerUtils(player);
        return layoutSet;
    }

    @Override
    public List<String> getFooter(Player player) {
        return Arrays.asList(
                "",
                "&eBienvendo &a" + player.getName() + " &eal Survival",
                "");
    }

    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList(
                "",
                "&eDisfruta de tu estancia en el servidor",
                "");
    }
}
