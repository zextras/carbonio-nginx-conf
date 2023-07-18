package com.zextras.proxyconfgen;

import com.zimbra.common.service.ServiceException;

/**
 * a wrapper class that convert a ProxyConfVar which contains the time in milliseconds to seconds.
 * This is useful when the default timeout unit used by Provisioning API is "ms" but nginx uses "s".
 *
 * @author jiankuan
 */
class TimeInSecVarWrapper extends com.zextras.proxyconfgen.ProxyConfVar {

  protected com.zextras.proxyconfgen.ProxyConfVar mVar;

  public TimeInSecVarWrapper(com.zextras.proxyconfgen.ProxyConfVar proxyConfVar) {
    super(null, null, null, null, null, null);

    if (proxyConfVar.mValueType != ProxyConfValueType.TIME) {
      throw new RuntimeException(
          "Only Proxy Conf Var with TIME" + " type can be used in this wrapper");
    }

    mVar = proxyConfVar;
  }

  @Override
  public void update() throws ServiceException, com.zextras.proxyconfgen.ProxyConfException {
    mVar.update();
    mVar.mValue = (Long) mVar.mValue / 1000;
  }

  @Override
  public String format(Object o) throws com.zextras.proxyconfgen.ProxyConfException {
    return mVar.mValue.toString();
  }
}
