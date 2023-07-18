package com.zextras.proxyconfgen;

/**
 * The visit of LdapProvisioning can't throw the exception out. Therefore, uses this special item to
 * indicate exception.
 *
 * @author jiankuan
 */
class DomainAttrExceptionItem extends com.zextras.proxyconfgen.DomainAttrItem {

  com.zextras.proxyconfgen.ProxyConfException exception;

  public DomainAttrExceptionItem(com.zextras.proxyconfgen.ProxyConfException e) {
    super(null, null, null, null, null, null, null, null, null);
    this.exception = e;
  }
}
