
package net.mcreator.bimble.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ShotgunShellItem extends Item {
	public ShotgunShellItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
