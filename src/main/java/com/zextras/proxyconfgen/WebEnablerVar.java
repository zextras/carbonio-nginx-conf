package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;

abstract class WebEnablerVar extends com.zextras.proxyconfgen.ProxyConfVar {

  protected WebEnablerVar(String keyword, Object defaultValue, String description) {
    super(
        keyword,
        null,
        defaultValue,
        ProxyConfValueType.ENABLER,
        ProxyConfOverride.CUSTOM,
        description);
  }

  static String getZimbraReverseProxyMailMode() {
    return serverSource.getAttr(ZAttrProvisioning.A_zimbraReverseProxyMailMode, "both");
  }
}
