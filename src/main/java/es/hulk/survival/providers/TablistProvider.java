package es.hulk.survival.providers;

import es.hulk.tablist.TablistAdapter;
import es.hulk.tablist.TablistLayout;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public class TablistProvider implements TablistAdapter {
    @Override
    public Set<TablistLayout> getProvider(Player player) {
        return null;
    }

    @Override
    public List<String> getFooter(Player player) {
        return null;
    }

    @Override
    public List<String> getHeader(Player player) {
        return null;
    }
}
