package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zextras.proxyconfgen.ProxyConfGen;

class WebProxyUpstreamLoginTargetVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public WebProxyUpstreamLoginTargetVar() {
    super(
        "web.upstream.schema",
        ZAttrProvisioning.A_zimbraReverseProxySSLToUpstreamEnabled,
        true,
        ProxyConfValueType.BOOLEAN,
        ProxyConfOverride.SERVER,
        "The login target of proxy_pass for web proxy");
  }

  @Override
  public String format(Object o) throws com.zextras.proxyconfgen.ProxyConfException {
    Boolean value = (Boolean) o;
    if (Boolean.FALSE.equals(value)) {
      return "http://" + com.zextras.proxyconfgen.ProxyConfGen.ZIMBRA_UPSTREAM_LOGIN_NAME;
    } else {
      return "https://" + ProxyConfGen.ZIMBRA_SSL_UPSTREAM_LOGIN_NAME;
    }
  }
}
