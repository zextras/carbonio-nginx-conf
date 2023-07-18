package com.zextras.proxyconfgen;

import com.zimbra.common.service.ServiceException;
import java.util.ArrayList;

class ZMLookupAvailableVar extends com.zextras.proxyconfgen.ProxyConfVar {

  public ZMLookupAvailableVar() {
    super(
        "lookup.available",
        null,
        false,
        ProxyConfValueType.ENABLER,
        ProxyConfOverride.CUSTOM,
        "Indicates whether there are available lookup handlers or not");
  }

  @Override
  public void update() throws ServiceException, com.zextras.proxyconfgen.ProxyConfException {
    ZMLookupHandlerVar lhVar = new ZMLookupHandlerVar();
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
