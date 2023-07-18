package com.zextras.proxyconfgen;

import com.zimbra.common.service.ServiceException;
import java.util.ArrayList;

class ZMWebAvailableVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public ZMWebAvailableVar() {
    super(
        "web.available",
        null,
        false,
        ProxyConfValueType.ENABLER,
        ProxyConfOverride.CUSTOM,
        "Indicates whether there are available web client servers or not");
  }

  @Override
  public void update() throws ServiceException, ProxyConfException {
    WebUpstreamClientServersVar lhVar = new WebUpstreamClientServersVar();
    lhVar.update();
    @SuppressWarnings("unchecked")
    ArrayList<String> servers = (ArrayList<String>) lhVar.mValue;
    if (servers.isEmpty()) {
      mValue = false;
    } else {
      mValue = true;
    }
  }
}
