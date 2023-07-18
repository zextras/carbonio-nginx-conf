package com.zextras.proxyconfgen;

class IPv6OnlyEnablerVar extends com.zextras.proxyconfgen.IPModeEnablerVar {

  public IPv6OnlyEnablerVar() {
    super("core.ipv6only.enabled", false, "IPv6 Only");
  }

  @Override
  public void update() {
    IPMode ipmode = getZimbraIPMode();
    mValue = ipmode == IPMode.IPV6_ONLY;
  }
}
