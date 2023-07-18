package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zextras.proxyconfgen.ProxyConfGen;

/**
 * Provide the value of "proxy_pass" for web proxy.
 *
 * @author jiankuan
 */
class WebProxyUpstreamClientTargetVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public WebProxyUpstreamClientTargetVar() {
    super(
        "web.upstream.schema",
        ZAttrProvisioning.A_zimbraReverseProxySSLToUpstreamEnabled,
        true,
        ProxyConfValueType.BOOLEAN,
        ProxyConfOverride.SERVER,
        "The target of proxy_pass for web client proxy");
  }

  @Override
  public String format(Object o) throws com.zextras.proxyconfgen.ProxyConfException {
    Boolean value = (Boolean) o;
    if (Boolean.FALSE.equals(value)) {
      return "http://" + com.zextras.proxyconfgen.ProxyConfGen.ZIMBRA_UPSTREAM_WEBCLIENT_NAME;
    } else {
      return "https://" + ProxyConfGen.ZIMBRA_SSL_UPSTREAM_WEBCLIENT_NAME;
    }
  }
}
