package com.zextras.proxyconfgen;

import com.zimbra.common.service.ServiceException;

/**
 * Provide the timeout value which accepts an offset
 *
 * @author jiankuan
 */
class TimeoutVar extends com.zextras.proxyconfgen.ProxyConfVar {

  private final int offset;

  public TimeoutVar(
      String keyword,
      String attribute,
      Object defaultValue,
      ProxyConfOverride overrideType,
      int offset,
      String description) {
    super(keyword, attribute, defaultValue, ProxyConfValueType.INTEGER, overrideType, description);
    this.offset = offset;
  }

  @Override
  public void update() throws ServiceException, com.zextras.proxyconfgen.ProxyConfException {
    super.update();
    mValue = (Integer) mValue + offset;
  }
}
