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

public class BlazeLeggings extends BlazeArmour {

	BlazeLeggings() {
		super(ModIDs.BLAZE_LEGGINGS_ID, 2);
		setTextureName(Utils.getItemTexture(Strings.Items.BLAZE_LEGGINGS_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.Items.BLAZE_LEGGINGS_NAME));
	}
}