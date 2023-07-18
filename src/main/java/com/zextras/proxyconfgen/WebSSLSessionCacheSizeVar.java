package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;

class WebSSLSessionCacheSizeVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public WebSSLSessionCacheSizeVar() {
    super(
        "ssl.session.cachesize",
        ZAttrProvisioning.A_zimbraReverseProxySSLSessionCacheSize,
        "10m",
        ProxyConfValueType.STRING,
        ProxyConfOverride.SERVER,
        "SSL session cache size for the proxy");
  }

  @Override
  public String format(Object o) {
    String sslSessionCacheSize = (String) o;
    return "shared:SSL:" + sslSessionCacheSize;
  }
}
