package ganymedes01.ganysnether.items;

import ganymedes01.ganysnether.core.utils.Utils;
import ganymedes01.ganysnether.lib.ModIDs;
import ganymedes01.ganysnether.lib.Strings;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class BlazeChestplate extends BlazeArmour {

	BlazeChestplate() {
		super(ModIDs.BLAZE_CHESTPLATE_ID, 1);
		setTextureName(Utils.getItemTexture(Strings.Items.BLAZE_CHESTPLATE_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.Items.BLAZE_CHESTPLATE_NAME));
	}
}