package com.zextras.proxyconfgen;

class IPBothEnablerVar extends com.zextras.proxyconfgen.IPModeEnablerVar {

  public IPBothEnablerVar() {
    super("core.ipboth.enabled", true, "Both IPv4 and IPv6");
  }

  @Override
  public void update() {
    IPMode ipmode = getZimbraIPMode();
    mValue = ipmode == IPMode.BOTH;
  }
}
