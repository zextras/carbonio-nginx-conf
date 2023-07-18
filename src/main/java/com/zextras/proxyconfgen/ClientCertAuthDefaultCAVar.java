package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zimbra.common.service.ServiceException;
import com.zextras.proxyconfgen.ProxyConfGen;

class ClientCertAuthDefaultCAVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public ClientCertAuthDefaultCAVar() {
    super(
        "ssl.clientcertca.default",
        ZAttrProvisioning.A_zimbraReverseProxyClientCertCA,
        ProxyConfGen.getDefaultClientCertCaFile(),
        ProxyConfValueType.STRING,
        ProxyConfOverride.CUSTOM,
        "CA certificate for authenticating client certificates in nginx proxy (https only)");
  }

  @Override
  public void update() throws ServiceException {

    mValue = mDefault; // must be the value of getDefaultClientCertCaPath
  }
}
