package ganymedes01.ganysnether.blocks;

import ganymedes01.ganysnether.GanysNether;
import ganymedes01.ganysnether.core.utils.Utils;
import ganymedes01.ganysnether.lib.ModIDs;
import ganymedes01.ganysnether.lib.ModSounds;
import ganymedes01.ganysnether.lib.RenderIDs;
import ganymedes01.ganysnether.lib.Strings;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class BlazingCactoid extends BlockCactus {

	@SideOnly(Side.CLIENT)
	private Icon cactusTopIcon, cactusBottomIcon;

	public BlazingCactoid() {
		super(ModIDs.BLAZING_CACTOID_ID);
		setHardness(0.4F);
		setLightValue(0.8F);
		setStepSound(ModSounds.soundBlaze);
		setCreativeTab(GanysNether.netherTab);
		setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
		setTextureName(Utils.getBlockTexture(Strings.BLAZING_CACTOID_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.BLAZING_CACTOID_NAME));
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(5) == 0)
			super.updateTick(world, x, y, z, rand);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getAABBPool().getAABB(x + 0.375F, y + 0.0F, z + 0.375F, x + 0.625F, y + 1.0F, z + 0.625F);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		if (world.getBlockMaterial(x - 1, y, z).isSolid())
			return false;
		else if (world.getBlockMaterial(x + 1, y, z).isSolid())
			return false;
		else if (world.getBlockMaterial(x, y, z - 1).isSolid())
			return false;
		else if (world.getBlockMaterial(x, y, z + 1).isSolid())
			return false;
		else {
			int blockID = world.getBlockId(x, y - 1, z);
			return blockID == Block.netherrack.blockID || blockID == this.blockID;
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.setFire(2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return blockIcon;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.BLAZING_CACTOID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		blockIcon = reg.registerIcon(getTextureName());
	}
}