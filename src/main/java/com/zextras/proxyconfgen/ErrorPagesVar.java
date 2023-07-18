package com.zextras.proxyconfgen;

import com.zimbra.common.account.ZAttrProvisioning;

class ErrorPagesVar extends com.zextras.proxyconfgen.ProxyConfVar {

  static final String[] ERRORS = {"502", "504"};

  public ErrorPagesVar() {
    super(
        "web.:errorPages",
        ZAttrProvisioning.A_zimbraReverseProxyErrorHandlerURL,
        "",
        ProxyConfValueType.STRING,
        ProxyConfOverride.SERVER,
        "the error page statements");
  }

  @Override
  public String format(Object o) throws com.zextras.proxyconfgen.ProxyConfException {

    String errURL = (String) o;
    StringBuilder sb = new StringBuilder();
    if (errURL.length() == 0) {
      for (String err : ErrorPagesVar.ERRORS) {
        sb.append("error_page ")
            .append(err)
            .append(" /zmerror_upstream_")
            .append(err)
            .append(".html;\n");
      }
    } else {
      for (String err : ErrorPagesVar.ERRORS) {
        sb.append("error_page ")
            .append(err)
            .append(" ")
            .append(errURL)
            .append("?err=")
            .append(err)
            .append("&up=$upstream_addr;\n");
      }
    }
    return sb.toString();
  }
}
