package ganymedes01.ganysnether.integration;

import ganymedes01.ganysnether.blocks.ModBlocks;
import ganymedes01.ganysnether.core.utils.HoeList;
import ganymedes01.ganysnether.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.event.FMLInterModComms;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class ThaumCraftManager extends Integration {

	@Override
	public void init() {
		HoeList.addHoe(ItemApi.getItem("itemHoeThaumium", 0));
		HoeList.addHoe(ItemApi.getItem("itemHoeElemental", 0));

		ThaumcraftApi.addSmeltingBonus(new ItemStack(ModItems.blazeIngot, 1, 1), new ItemStack(ModItems.blazeIngot, 0, 2));

		FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(ModBlocks.witherShrub, 1, 8));

		addAspectsToItem(ModBlocks.soulGlass, new Aspect[] { Aspect.CRYSTAL, Aspect.SOUL }, new int[] { 1, 1 });
		addAspectsToItem(ModBlocks.glowBox, new Aspect[] { Aspect.LIGHT, Aspect.SENSES }, new int[] { 3, 1 });
		addAspectsToItem(ModBlocks.colouredQuartzBlock, new Aspect[] { Aspect.WATER, Aspect.CRYSTAL }, new int[] { 1, 1 });
		addAspectsToItem(ModBlocks.colouredChiselledQuartzBlock, new Aspect[] { Aspect.WATER, Aspect.CRYSTAL }, new int[] { 1, 1 });
		for (int i = 0; i < ModBlocks.colouredQuartzPillar.length; i++)
			addAspectsToItem(ModBlocks.colouredQuartzPillar[i], new Aspect[] { Aspect.WATER, Aspect.CRYSTAL }, new int[] { 1, 1 });
		for (int i = 0; i < ModBlocks.colouredQuartzBlockStairs.length; i++)
			addAspectsToItem(ModBlocks.colouredQuartzBlockStairs[i], new Aspect[] { Aspect.WATER, Aspect.CRYSTAL }, new int[] { 2, 2 });
		addAspectsToItem(ModBlocks.undertaker, new Aspect[] { Aspect.EARTH, Aspect.TRAP, Aspect.SOUL, Aspect.CRYSTAL, Aspect.ENERGY }, new int[] { 7, 7, 7, 1, 1 });
		addAspectsToItem(ModItems.blazeIngot, 1, new Aspect[] { Aspect.FIRE, Aspect.MAGIC, Aspect.METAL }, new int[] { 2, 2, 2 });
		addAspectsToItem(ModItems.quarzBerrySeeds, new Aspect[] { Aspect.SEED, Aspect.UNDEAD }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.ghostSeeds, new Aspect[] { Aspect.SEED, Aspect.SOUL }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.witherShrubSeeds, new Aspect[] { Aspect.SEED, Aspect.UNDEAD }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.batWing, new Aspect[] { Aspect.AIR, Aspect.FLIGHT }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.cookedBatWing, new Aspect[] { Aspect.AIR, Aspect.HUNGER }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.wolfTeeth, new Aspect[] { Aspect.BEAST }, new int[] { 1 });
		addAspectsToItem(ModItems.silverfishScale, new Aspect[] { Aspect.BEAST, Aspect.EARTH }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.glowingReed, new Aspect[] { Aspect.AIR, Aspect.FIRE, Aspect.LIGHT }, new int[] { 1, 1, 1 });
		addAspectsToItem(ModItems.spectreWheat, new Aspect[] { Aspect.CROP, Aspect.SOUL }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.quarzBerry, new Aspect[] { Aspect.CROP, Aspect.CRYSTAL }, new int[] { 1, 1 });
		addAspectsToItem(Item.monsterPlacer, new Aspect[] { Aspect.SOUL, Aspect.TRAP }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.skeletonSpawner, new Aspect[] { Aspect.SOUL, Aspect.TRAP }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.spookyFlour, new Aspect[] { Aspect.SOUL, Aspect.CROP }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.dimensionalBread, new Aspect[] { Aspect.SOUL, Aspect.CROP, Aspect.HUNGER }, new int[] { 1, 3, 2 });
		addAspectsToItem(ModItems.blazeIngot, 2, new Aspect[] { Aspect.FIRE }, new int[] { 1 });
		addAspectsToItem(ModItems.flour, new Aspect[] { Aspect.HUNGER, Aspect.ENTROPY }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.hellBushSeeds, new Aspect[] { Aspect.SEED, Aspect.FIRE }, new int[] { 1, 1 });
		addAspectsToItem(ModItems.lavaBerry, new Aspect[] { Aspect.FIRE }, new int[] { 3 });
		addAspectsToItem(ModBlocks.blazingCactoid, new Aspect[] { Aspect.PLANT, Aspect.ENTROPY, Aspect.FIRE }, new int[] { 3, 1, 1 });
	}

	@Override
	public void postInit() {
	}

	@Override
	public String getModID() {
		return "Thaumcraft";
	}

	private void addAspectsToItem(Item item, Aspect[] aspects, int[] amounts) {
		if (item != null)
			addAspectsToItem(item.itemID, -1, aspects, amounts);
	}

	private void addAspectsToItem(Block block, Aspect[] aspects, int[] amounts) {
		if (block != null)
			addAspectsToItem(block.blockID, -1, aspects, amounts);
	}

	private void addAspectsToItem(int id, Aspect[] aspects, int[] amounts) {
		addAspectsToItem(id, -1, aspects, amounts);
	}

	private void addAspectsToItem(Block block, int meta, Aspect[] aspects, int[] amounts) {
		if (block != null)
			addAspectsToItem(block.blockID, meta, aspects, amounts);
	}

	private void addAspectsToItem(Item item, int meta, Aspect[] aspects, int[] amounts) {
		if (item != null)
			addAspectsToItem(item.itemID, meta, aspects, amounts);
	}

	private void addAspectsToItem(int id, int meta, Aspect[] aspects, int[] amounts) {
		AspectList list = new AspectList();
		for (int i = 0; i < aspects.length; i++)
			list.add(aspects[i], amounts[i]);

		ThaumcraftApi.registerObjectTag(id, meta, list);
	}
}