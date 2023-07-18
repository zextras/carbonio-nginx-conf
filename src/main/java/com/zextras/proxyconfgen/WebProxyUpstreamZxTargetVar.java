package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;
import com.zextras.proxyconfgen.ProxyConfGen;

class WebProxyUpstreamZxTargetVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public WebProxyUpstreamZxTargetVar() {
    super(
        "web.upstream.schema",
        ZAttrProvisioning.A_zimbraReverseProxySSLToUpstreamEnabled,
        true,
        ProxyConfValueType.BOOLEAN,
        ProxyConfOverride.SERVER,
        "The target for zx paths");
  }

  @Override
  public String format(Object o) throws ProxyConfException {
    Boolean value = (Boolean) o;
    if (Boolean.FALSE.equals(value)) {
      return "http://" + ProxyConfGen.ZIMBRA_UPSTREAM_ZX_NAME;
    } else {
      return "https://" + ProxyConfGen.ZIMBRA_SSL_UPSTREAM_ZX_NAME;
    }
  }
}
