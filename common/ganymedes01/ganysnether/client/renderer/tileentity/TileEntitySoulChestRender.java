package ganymedes01.ganysnether.client.renderer.tileentity;

import ganymedes01.ganysnether.tileentities.TileEntitySoulChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

@SideOnly(Side.CLIENT)
public class TileEntitySoulChestRender extends TileEntitySpecialRenderer {

	private final ResourceLocation texture;

	public TileEntitySoulChestRender(ResourceLocation texture) {
		this.texture = texture;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float angle) {
		TileEntitySoulChest soulChest = (TileEntitySoulChest) tile;

		ModelChest modelchest = new ModelChest();
		bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);

		short rotation = 0;
		switch (soulChest.getBlockMetadata()) {
			case 2:
				rotation = 180;
				break;
			case 4:
				rotation = 90;
				break;
			case 5:
				rotation = -90;
				break;
		}

		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float lidRotation = 1.0F - (soulChest.prevLidAngle + (soulChest.lidAngle - soulChest.prevLidAngle) * angle);
		lidRotation = 1.0F - lidRotation * lidRotation * lidRotation;
		modelchest.chestLid.rotateAngleX = -(lidRotation * (float) Math.PI / 2.0F);
		modelchest.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}
