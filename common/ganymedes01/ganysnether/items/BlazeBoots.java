package ganymedes01.ganysnether.items;

import ganymedes01.ganysnether.core.utils.Utils;
import ganymedes01.ganysnether.lib.Strings;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class BlazeBoots extends BlazeArmour {

	public BlazeBoots(int id) {
		super(id, 3);
		setTextureName(Utils.getItemTexture(Strings.BLAZE_BOOTS_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.BLAZE_BOOTS_NAME));
	}
}
