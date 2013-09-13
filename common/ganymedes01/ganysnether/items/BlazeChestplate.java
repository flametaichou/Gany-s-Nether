package ganymedes01.ganysnether.items;

import ganymedes01.ganysnether.core.utils.Utils;
import ganymedes01.ganysnether.lib.Strings;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class BlazeChestplate extends BlazeArmour {

	public BlazeChestplate(int id) {
		super(id, 1);
		setTextureName(Utils.getItemTexture(Strings.BLAZE_CHESTPLATE_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.BLAZE_CHESTPLATE_NAME));
	}
}
