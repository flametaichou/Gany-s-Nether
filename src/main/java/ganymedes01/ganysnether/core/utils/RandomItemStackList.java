package ganymedes01.ganysnether.core.utils;

import ganymedes01.ganysnether.GanysNether;
import ganymedes01.ganysnether.items.ModItems;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class RandomItemStackList {

	private static HashMap<UnsizedStack, Integer> weightedStackList = new HashMap<UnsizedStack, Integer>();

	static {
		insertStackOnList(new ItemStack(ModItems.witherShrubSeeds), 200);
		insertStackOnList(new ItemStack(ModItems.skeletonSpawner), 45);
		insertStackOnList(new ItemStack(ModItems.skeletonSpawner, 1, 1), 50);
		insertStackOnList(new ItemStack(ModItems.dimensionalBread, 18), 10);
		insertStackOnList(new ItemStack(ModItems.quarzBerrySeeds, 12), 40);
		insertStackOnList(new ItemStack(ModItems.ghostSeeds, 16), 40);

		insertStackOnList(new ItemStack(Block.torchWood, 32), 30);
		insertStackOnList(new ItemStack(Item.coal, 32), 10);
		insertStackOnList(new ItemStack(Item.stick, 32), 4);
		insertStackOnList(new ItemStack(Item.beefCooked, 10), 10);
		insertStackOnList(new ItemStack(Item.bakedPotato, 20), 7);
		insertStackOnList(new ItemStack(Item.goldNugget, 14), 30);
		insertStackOnList(new ItemStack(Item.rottenFlesh, 64), 5);
		insertStackOnList(new ItemStack(Block.netherBrick, 64), 15);
		insertStackOnList(new ItemStack(Item.netherStalkSeeds, 11), 8);
		insertStackOnList(new ItemStack(Block.whiteStone, 40), 20);
		insertStackOnList(new ItemStack(Block.wood, 32), 10);
		insertStackOnList(new ItemStack(Block.dirt, 64), 5);
		insertStackOnList(new ItemStack(Block.sand, 64), 5);
		insertStackOnList(new ItemStack(Item.seeds, 20), 25);
		insertStackOnList(new ItemStack(Item.leather, 10), 30);
		insertStackOnList(new ItemStack(Block.cobblestone, 64), 5);
		insertStackOnList(new ItemStack(Item.redstone, 24), 25);
	}

	public static void insertStackOnList(ItemStack stack, int weight) {
		if (stack != null && stack.stackSize > 0 && weight > 0)
			weightedStackList.put(new UnsizedStack(stack), weight);
	}

	public static void fillInventory(IInventory inventory, int maxSlot, Random rand) {
		for (int i = 0; i < maxSlot; i++)
			for (Entry<UnsizedStack, Integer> entry : weightedStackList.entrySet())
				if (rand.nextInt(entry.getValue()) == 0 && rand.nextInt(GanysNether.undertakerFillSlotChance) == 0) {
					ItemStack stack = entry.getKey().getStack(rand.nextInt(entry.getKey().getOldStackSize()));
					inventory.setInventorySlotContents(i, stack);
				}
	}
}