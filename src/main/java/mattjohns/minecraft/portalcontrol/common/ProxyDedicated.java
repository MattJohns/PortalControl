package mattjohns.minecraft.portalcontrol.common;

import mattjohns.minecraft.common.log.Log;
import mattjohns.minecraft.common.network.NetworkChannel;
import mattjohns.minecraft.portalcontrol.server.ClientControllerDedicated;

/**
 * Program is dedicated server so this has a dummy client controller.
 */
public class ProxyDedicated extends ProxyCommon {
	@Override
	protected ClientController clientCreate(Log log, CommonConfiguration commonConfiguration,
			NetworkChannel network) {
		return new ClientControllerDedicated(log, commonConfiguration, network);
	}
}
