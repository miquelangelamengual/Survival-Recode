package es.hulk.survival.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@AllArgsConstructor
@Setter
@Getter
public class Warp {

    private final String name;
    private final Location location;

}
