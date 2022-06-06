package es.hulk.survival.hooks;

import es.hulk.survival.Survival;
import es.hulk.survival.providers.TablistProvider;
import es.hulk.tablist.Omega;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TablistHook {

    @Getter private Omega tablist;

    public void init(Survival survival) {
        if (survival.getMainConfig().getBoolean("TOGGLES.TABLIST")) {
            tablist = new Omega(survival, new TablistProvider());
        }
    }

}
