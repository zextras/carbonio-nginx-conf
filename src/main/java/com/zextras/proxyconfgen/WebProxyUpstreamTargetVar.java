package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zextras.proxyconfgen.ProxyConfGen;

/**
 * Provide the value of "proxy_pass" for web proxy.
 *
 * @author jiankuan
 */
class WebProxyUpstreamTargetVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public WebProxyUpstreamTargetVar() {
    super(
        "web.upstream.schema",
        ZAttrProvisioning.A_zimbraReverseProxySSLToUpstreamEnabled,
        true,
        com.zextras.proxyconfgen.ProxyConfValueType.BOOLEAN,
        com.zextras.proxyconfgen.ProxyConfOverride.SERVER,
        "The target of proxy_pass for web proxy");
  }

  @Override
  public String format(Object o) throws com.zextras.proxyconfgen.ProxyConfException {
    Boolean value = (Boolean) o;
    if (Boolean.FALSE.equals(value)) {
      return "http://" + com.zextras.proxyconfgen.ProxyConfGen.ZIMBRA_UPSTREAM_NAME;
    } else {
      return "https://" + ProxyConfGen.ZIMBRA_SSL_UPSTREAM_NAME;
    }
  }
}
