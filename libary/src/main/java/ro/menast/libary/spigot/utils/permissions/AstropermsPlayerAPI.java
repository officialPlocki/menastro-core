package ro.menast.libary.spigot.utils.permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissibleBase;

public class AstropermsPlayerAPI extends PermissibleBase {
  private final ro.menast.libary.spigot.utils.player.Player p;
  
  public AstropermsPlayerAPI(Player player) {
    super(player);
    this.p = new ro.menast.libary.spigot.utils.player.Player(player.getUniqueId().toString());
  }

  public AstropermsPlayerAPI(String uuid) {
    super(Bukkit.getPlayer(uuid));
    this.p = new ro.menast.libary.spigot.utils.player.Player(uuid);
  }
  
  public boolean hasPermission(String inName) {
    return (new AstropermsMySQL()).hasPermission(this.p, inName);
  }
  
  public boolean isOp() {
    return false;
  }
  
  public ro.menast.libary.spigot.utils.player.Player getPlayer() {
    return this.p;
  }
  
  public void setGroup(String group) {
    (new AstropermsMySQL()).setPlayerGroup(this.p, new PermissionableGroupBuilder(group));
  }
  
  public Group getGroupOfPlayer() {
    return new PermissionableGroupBuilder((new AstropermsMySQL()).getPlayerGroup(this.p));
  }
  
  public void addPermission(String permission) {
    (new AstropermsMySQL()).addPlayerPermission(this.p, permission);
  }
  
  public void removePermission(String permission) {
    (new AstropermsMySQL()).removePlayerPermission(this.p, permission);
  }
}
