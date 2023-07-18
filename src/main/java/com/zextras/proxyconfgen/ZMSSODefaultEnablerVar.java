package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zimbra.common.service.ServiceException;
import com.zextras.proxyconfgen.ProxyConfGen;

class ZMSSODefaultEnablerVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public ZMSSODefaultEnablerVar() {
    super(
        "web.sso.enabled",
        ZAttrProvisioning.A_zimbraReverseProxyClientCertMode,
        false,
        ProxyConfValueType.ENABLER,
        ProxyConfOverride.CUSTOM,
        "whether enable sso for global/server level");
  }

  @Override
  public void update() throws ServiceException {
    if (ProxyConfGen.isClientCertVerifyEnabled()) {
      mValue = true;
    } else {
      mValue = false;
    }
  }
}
