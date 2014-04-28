package ganymedes01.ganysnether.lib;

/**
 * Gany's Nether
 * 
 * @author ganymedes01
 * 
 */

public class Reference {

	public static final String MOD_ID = "ganysnether";
	public static final String MOD_NAME = "Gany's Nether";
	public static final String DEPENDENCIES = "required-after:Forge@[9.10.1.849,)";
	public static final String CHANNEL_NAME = "GanysNether";
	public static final String MASTER = "GanysMods";
	public static final String VERSION_NUMBER = "1.6.2";
	public static final int RAW_VERSION_NUMBER = 162;
	public static String LATEST_VERSION;
	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
	public static final String ARMOUR_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/models/armor/";
	public static final String ENTITY_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/entities/";
	public static final String GUI_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/gui/container/";

	public static final String SERVER_PROXY_CLASS = "ganymedes01.ganysnether.core.proxy.CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "ganymedes01.ganysnether.core.proxy.ClientProxy";
	public static final String VERSION_CHECK_FILE = "https://raw.github.com/ganymedes01/Version-Checks/master/Version.xml";
	public static final String USERS_WITH_CAPES_FILE = "https://raw.github.com/ganymedes01/Version-Checks/master/UsersWithCapes.txt";
	public static final String CAPE_IMAGE_FILE = "https://dl.dropboxusercontent.com/u/213747910/gany.png";
	public static final String JEBJEB_CAPE_IMAGE_FILE = "https://dl.dropboxusercontent.com/u/213747910/jade.png";
	public static final String KPR_CAPE_IMAGE_FILE = "https://dl.dropboxusercontent.com/u/213747910/KingPurpleRaptor.png";

	public static final int ITEM_ID_BASE = 7000;
	public static final int BLOCK_ID_BASE = 1600;
}