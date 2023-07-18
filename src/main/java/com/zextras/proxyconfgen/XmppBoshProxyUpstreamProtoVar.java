package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;

class XmppBoshProxyUpstreamProtoVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public XmppBoshProxyUpstreamProtoVar() {
    super(
        "xmpp.upstream.schema",
        ZAttrProvisioning.A_zimbraReverseProxyXmppBoshSSL,
        true,
        ProxyConfValueType.BOOLEAN,
        ProxyConfOverride.SERVER,
        "The XMPP target of proxy_pass for web proxy");
  }

  @Override
  public String format(Object o) throws ProxyConfException {
    if (!((Boolean) o)) {
      return "http";
    } else {
      return "https";
    }
  }
}
