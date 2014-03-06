package org.dasein.cloud.vsphere.network;

import org.dasein.cloud.AbstractCapabilities;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.Requirement;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.network.IPAddressCapabilities;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.vsphere.PrivateCloud;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Locale;

/**
 * Describes the capabilities of VSphere with respect to Dasein virtual machine operations.
 * <p>Created by Danielle Mayne: 4/03/14 16:00 PM</p>
 * @author Danielle Mayne
 * @version 2014.03 initial version
 * @since 2014.03
 */
public class StaticIPCapabilities extends AbstractCapabilities<PrivateCloud> implements IPAddressCapabilities{
    public StaticIPCapabilities(@Nonnull PrivateCloud provider) {
        super(provider);
    }

    @Nonnull
    @Override
    public String getProviderTermForIpAddress(@Nonnull Locale locale) {
        return "ip address";
    }

    @Nonnull
    @Override
    public Requirement identifyVlanForVlanIPRequirement() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Override
    public boolean isAssigned(@Nonnull IPVersion version) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canBeAssigned(@Nonnull VmState vmState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isAssignablePostLaunch(@Nonnull IPVersion version) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isForwarding(IPVersion version) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isRequestable(@Nonnull IPVersion version) throws CloudException, InternalException {
        return false;
    }

    @Nonnull
    @Override
    public Iterable<IPVersion> listSupportedIPVersions() throws CloudException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public boolean supportsVLANAddresses(@Nonnull IPVersion ofVersion) throws InternalException, CloudException {
        return false;
    }
}