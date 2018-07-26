package cn.academy.energy.client.app;

import cn.academy.terminal.App;
import cn.academy.terminal.AppEnvironment;
import cn.academy.terminal.client.TerminalUI;
import cn.academy.terminal.registry.AppRegistration.RegApp;
import cn.lambdalib2.util.client.auxgui.AuxGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 */
public class AppFreqTransmitter extends App {
    
    @RegApp
    public static AppFreqTransmitter instance = new AppFreqTransmitter();

    private AppFreqTransmitter() {
        super("freq_transmitter");
    }

    @Override
    public AppEnvironment createEnvironment() {
        return new AppEnvironment() {
            @Override
            @SideOnly(Side.CLIENT)
            public void onStart() {
                TerminalUI.passOn(new FreqTransmitterUI());
            }
        };
    }

}