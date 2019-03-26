package mattjohns.minecraft.portalcontrol.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import mattjohns.minecraft.common.log.Log;
import mattjohns.minecraft.common.network.NetworkChannel;
import mattjohns.minecraft.portalcontrol.client.network.ClientNetworkController;
import mattjohns.minecraft.portalcontrol.common.ClientController;
import mattjohns.minecraft.portalcontrol.common.CommonConfiguration;
import mattjohns.minecraft.portalcontrol.common.PacketFromServerReceiver;
import mattjohns.minecraft.portalcontrol.common.ProgramEventReceiver;

/**
 * Main client code. Gets run only when program has integrated server, not
 * dedicated.
 */
public class ClientControllerIntegrated extends ClientController implements ProgramEventReceiver {
	protected ClientNetworkController network;

	public ClientControllerIntegrated(Log log, CommonConfiguration configuration, NetworkChannel network) {
		super(log, configuration, network);
	}

	@Override
	public void onProgramInitializeStart(FMLPreInitializationEvent event) {
		super.onProgramInitializeStart(event);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void onProgramInitializeEnd(FMLInitializationEvent event) {
		super.onProgramInitializeEnd(event);

		log.information("Client initialized");
	}

	@Override
	protected PacketFromServerReceiver packetReceiverCreate() {
		// already created
		return network;
	}
}