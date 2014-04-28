package ganymedes01.ganysnether.core.handlers;

import ganymedes01.ganysnether.blocks.ModBlocks;
import ganymedes01.ganysnether.items.ModItems;
import ganymedes01.ganysnether.items.SpawnerUpgrade.UpgradeType;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipEvent {

	@ForgeSubscribe(priority = EventPriority.HIGHEST)
	public void getTooltip(ItemTooltipEvent event) {
		if (event.itemStack == null)
			return;

		int id = event.itemStack.itemID;

		if (id == Item.ghastTear.itemID)
			event.toolTip.add(StatCollector.translateToLocal("tooltip.ganysnether.ghastTear"));
		if (id == ModBlocks.extendedSpawner.blockID && event.itemStack.hasTagCompound() && event.itemStack.getTagCompound().hasKey("EntityId"))
			event.toolTip.add(EnumChatFormatting.GOLD + event.itemStack.getTagCompound().getString("EntityId"));
		else if (id == ModItems.spawnerUpgrade.itemID) {
			int meta = event.itemStack.getItemDamage();
			if (meta == UpgradeType.tierCoal.ordinal())
				event.toolTip.add("First Upgrade");
			else if (meta < UpgradeType.tierDragonEgg.ordinal())
				event.toolTip.add("+2 Slots");
			else if (meta == UpgradeType.tierDragonEgg.ordinal()) {
				event.toolTip.add("+2 Slots");
				event.toolTip.add("Spawns up to 3 different mobs");
			} else if (meta == UpgradeType.redstone.ordinal())
				event.toolTip.add("Control spawner with redstone signals");
			else if (meta == UpgradeType.noPlayer.ordinal())
				event.toolTip.add("Spawner will run even if there's no players nearby");
			else if (meta == UpgradeType.ignoreConditions.ordinal())
				event.toolTip.add("Spawner will ignore light levels, dimension, etc...");
			else if (meta == UpgradeType.silky.ordinal())
				event.toolTip.add("Spawner block will drop when broken");
			else if (meta == UpgradeType.spawnCount.ordinal())
				event.toolTip.add("+1 possible spawn");
			else if (meta == UpgradeType.spawnRange.ordinal())
				event.toolTip.add("+2,+0,+2 (x,y,z) spawn range upgrade");
		}
	}
}